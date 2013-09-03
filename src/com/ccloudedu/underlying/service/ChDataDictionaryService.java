package com.ccloudedu.underlying.service;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChDatadictionary;

public interface ChDataDictionaryService extends BaseService<ChDatadictionary>{

	/**
	 * 根据字典菜单查询数据字典
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	public Page findDataDictByMenu(Page page, String menu) throws Exception;
	
	/**
	 * 根据ID查询数据字典
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ChDatadictionary findDataDictById(String id) throws Exception;
	
	/**
	 * 新增数据字典
	 * @param dict
	 * @throws Exception
	 */
	public void saveDictionary(ChDatadictionary dict) throws Exception;
	
	/**
	 * 更新数据字典
	 * @param dict
	 * @throws Exception
	 */
	public void updateDictionary(ChDatadictionary dict) throws Exception;
	
	/**
	 * 查询数据字典
	 * @param menu
	 * @param syscode
	 * @param educode
	 * @param dictname
	 * @throws Exception
	 */
	public ChDatadictionary findDataDict(String menu, String syscode, String educode, String dictname) throws Exception;
	
}
