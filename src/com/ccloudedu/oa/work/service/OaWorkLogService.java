package com.ccloudedu.oa.work.service;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.oa.work.entity.OaWorkLog;

public interface OaWorkLogService extends BaseService<OaWorkLog>{

	public Page findPage(Page page,String isLeaderRead)throws Exception;

}
