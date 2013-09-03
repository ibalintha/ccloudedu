package com.ccloudedu.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.dao.dbutils.BaseDbutilsDao;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.system.entity.SysDataDictionary;
import com.ccloudedu.system.service.DataDictionaryService;
@Service
@Transactional
public class DataDictionaryServiceImpl extends BaseServiceImpl<SysDataDictionary> implements DataDictionaryService {
	
	@Autowired
	private BaseDbutilsDao baseDbutilsDao;

	/**
	 * 更新数据字典
	 */
	public int updateDDInCache() throws Exception{
		
    	List<SysDataDictionary> allDdList = baseDbutilsDao.findList(SysDataDictionary.class,"system.findDataDictionarys1",null);
    	
    	List<SysDataDictionary> parentDdList = baseDbutilsDao.findList(SysDataDictionary.class,"system.findDataDictionarys2",null);
    	
    	Map<String,List<SysDataDictionary>> map = new HashMap<String,List<SysDataDictionary>>();
    	List<SysDataDictionary> childrenDD = null;
    	for(SysDataDictionary parent : parentDdList){
    		childrenDD = new ArrayList<SysDataDictionary>();
    		for(SysDataDictionary dd : allDdList){
    			if(parent.getId().equals(dd.getParentId())){
        			childrenDD.add(dd);
    			}
    		}
    		map.put(parent.getDdValue(), childrenDD);
    	}
    	
    	EhCacheManager.remove(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.DATA_DICTIONARY_KEY);
    	EhCacheManager.put(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.DATA_DICTIONARY_KEY, map);
    	
    	return 1;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(SysDataDictionary dd, SysDataDictionary parentDD) throws Exception{
		this.save(dd);
		this.update(parentDD);
		return 1;
	}
	@SuppressWarnings("unchecked")
	public SysDataDictionary findone(String ddValue) throws Exception{
		return findOne("system.findDataDictionarys",new FastMap().newHashMap().set("ddValue", ddValue));
	}
	
	 /**
	  * 由上级数据字典的值，获得所有直接下级字典项
	  */
	 @SuppressWarnings("unchecked")
	public List<SysDataDictionary> getDDbyParentDDValue(String parentDDValue) throws Exception{
		 Map<String,List<SysDataDictionary>> parentMap = (Map<String, List<SysDataDictionary>>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.DATA_DICTIONARY_KEY);
		 List<SysDataDictionary> ddExecuteSettingList =  parentMap.get(parentDDValue);
		 return ddExecuteSettingList;
	 }
}
