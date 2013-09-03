package com.ccloudedu.base.web.taglib;

import java.util.List;
import java.util.Map;

import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.system.entity.SysDataDictionary;

public abstract class DictionaryParentTag extends ParentTag{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//数据字典父项名称
	private String pvalue;
	
	/**
	 * 根据数据字典父项取出所有的下级
	 * @param parentdictionary 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysDataDictionary> getSubList(String parentdictionary){
		Map<String,List<SysDataDictionary>> parentMap = (Map<String, List<SysDataDictionary>>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.DATA_DICTIONARY_KEY);
		List<SysDataDictionary> subList =  parentMap.get(parentdictionary);
		return subList;
	}
	/**
	 * 获得一个数据字典名称
	 * @param parentdictionary 父项数据字典
	 * @param value 子项id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getSubName(String parentdictionary,String value){
		Map<String,List<SysDataDictionary>> parentMap = (Map<String, List<SysDataDictionary>>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.DATA_DICTIONARY_KEY);
		List<SysDataDictionary> subList =  parentMap.get(parentdictionary);
		String subName = "";
		if(subList!=null && subList.size()>0){
			for(SysDataDictionary dd : subList){
				if(dd.getDdValue().equals(value)){
					subName = dd.getDdName();
					break;
				}
			}
		}
		return subName;
	}
	public String getPvalue() {
		return pvalue;
	}
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
}
