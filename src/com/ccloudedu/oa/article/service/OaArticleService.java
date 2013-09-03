package com.ccloudedu.oa.article.service;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.oa.article.entity.OaArticle;

public interface OaArticleService extends BaseService<OaArticle>{

	public Page findPage(Page page,String categoryValue,String isDraft) throws Exception;

	public int createStaticPage(OaArticle oaArticle, String id) throws Exception;

}
