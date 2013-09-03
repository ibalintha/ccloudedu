package com.ccloudedu.cms.service;

import java.util.Map;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.cms.entity.CmsArticle;

public interface ArticleService extends BaseService<CmsArticle>{

	public Page findPage(Page page,Map<String,String> paramMap)throws Exception;

	public int createStaticPage(CmsArticle article,long id) throws Exception;

	public int deleteAndUpdatePage(String[] strids)throws Exception;

}
