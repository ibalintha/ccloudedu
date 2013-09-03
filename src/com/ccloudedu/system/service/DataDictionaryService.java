package com.ccloudedu.system.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.system.entity.SysDataDictionary;

public interface DataDictionaryService  extends BaseService<SysDataDictionary>{

	 /**
	  * 加载/更新数据字典在缓存中的数据
	  */
	 public int updateDDInCache()throws Exception;

	 public int save(SysDataDictionary dd, SysDataDictionary parentDD) throws Exception;

	 public SysDataDictionary findone(String ddValue) throws Exception;
	 
	 /**
	  * 由上级数据字典的值，获得所有直接下级字典项
	  */
	 public List<SysDataDictionary> getDDbyParentDDValue(String parentDDValue) throws Exception;
}
