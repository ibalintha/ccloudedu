package com.ccloudedu.oa.msg.service;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.oa.msg.entity.OaMessageBoard;

public interface MessageBoardService extends BaseService<OaMessageBoard>{

	public Page findPage(Page page)throws Exception;
}
