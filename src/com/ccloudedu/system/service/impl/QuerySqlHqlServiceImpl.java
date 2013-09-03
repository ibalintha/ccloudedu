package com.ccloudedu.system.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.system.entity.QuerySqlHql;
import com.ccloudedu.system.service.QuerySqlHqlService;
@Service
@Transactional
public class QuerySqlHqlServiceImpl extends BaseServiceImpl<QuerySqlHql> implements QuerySqlHqlService {

	@SuppressWarnings("unchecked")
	public void updateQueryTemplateInCache() throws Exception{
		
		Map<String,String> map = (Map<String, String>) findMap("system.findQuerySqlHqls", "queryName", "sqlHql", null);
	
		EhCacheManager.remove(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.QUERY_SQL_HQL_KEY);
    	EhCacheManager.put(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.QUERY_SQL_HQL_KEY, map);
	}
}
