package com.ccloudedu.cms.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.cms.entity.CmsTemplet;

public interface TempletService extends BaseService<CmsTemplet>{

	public List<CmsTemplet> findListExclude(String templeteName)throws Exception;

}
