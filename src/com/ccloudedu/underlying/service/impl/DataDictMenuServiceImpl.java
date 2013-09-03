package com.ccloudedu.underlying.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.underlying.entity.ChDatadictionaryMenu;
import com.ccloudedu.underlying.service.DataDictMenuService;

@Service
@Transactional
public class DataDictMenuServiceImpl extends BaseServiceImpl<ChDatadictionaryMenu> implements DataDictMenuService{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<String> getAllModule() throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap();
		return findList("underlying.findAllModules", paramMap);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<String> getMenusByModule(String module) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("module", module);
		List<ChDatadictionaryMenu> dms = findList("underlying.findDictionaryMenu", paramMap);
		List<String> menus = new ArrayList<String>();
		for(ChDatadictionaryMenu dm : dms){
			menus.add(dm.getDictMenu());
		}
		return menus;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String getModuleByMenu(String menu) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("menu", menu);
		ChDatadictionaryMenu dm = findOne("underlying.findDictionaryMenu", paramMap);
		return dm.getModule();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String getTableNameByMenu(String menu) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("menu", menu);
		ChDatadictionaryMenu dm = findOne("underlying.findDictionaryMenu", paramMap);
		return dm.getTableName();
	}


}
