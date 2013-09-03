package com.ccloudedu.oa.msg.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.oa.msg.entity.OaMessageBoard;
import com.ccloudedu.oa.msg.service.MessageBoardService;

@Service
@Transactional
public class MessageBoardServiceImpl extends BaseServiceImpl<OaMessageBoard> implements MessageBoardService {
	
	public Page findPage(Page page) throws Exception{
		return findPage(page, "oa.findMessageBoards",null);
	}
}
