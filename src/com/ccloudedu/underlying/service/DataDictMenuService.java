package com.ccloudedu.underlying.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.underlying.entity.ChDatadictionaryMenu;

public interface DataDictMenuService extends BaseService<ChDatadictionaryMenu>{

	public List<String> getAllModule() throws Exception;
	public List<String> getMenusByModule(String module) throws Exception;
	public String getModuleByMenu(String menu) throws Exception;
	public String getTableNameByMenu(String menu) throws Exception;
}
