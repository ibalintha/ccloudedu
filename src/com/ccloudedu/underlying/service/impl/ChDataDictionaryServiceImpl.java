package com.ccloudedu.underlying.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.common.entity.ChDatadictionary;
import com.ccloudedu.underlying.service.ChDataDictionaryService;

@Service
@Transactional
public class ChDataDictionaryServiceImpl extends BaseServiceImpl<ChDatadictionary> implements ChDataDictionaryService{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page findDataDictByMenu(Page page, String menu)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("menu", menu);
		return this.findPage(page, "underlying.findDataDictionary", paramMap);
	}

	@Override
	public void saveDictionary(ChDatadictionary dict) throws Exception {
		// TODO Auto-generated method stub
		save(dict);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ChDatadictionary findDataDictById(String id) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("id", id);
		return findOne("underlying.findDataDictionary", paramMap);
	}

	@Override
	public void updateDictionary(ChDatadictionary dict) throws Exception {
		// TODO Auto-generated method stub
		update(dict);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ChDatadictionary findDataDict(String menu, String syscode, String educode, String dictname)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("menu", menu)
				.set("syscode", syscode)
				.set("educode", educode)
				.set("dictname", dictname);
		return findOne("underlying.findDataDictionary", paramMap);
	}

}
