package com.ccloudedu.system.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.system.entity.QuerySqlHql;

public interface QuerySqlHqlService extends BaseService<QuerySqlHql>{

	public void updateQueryTemplateInCache() throws Exception;
}
