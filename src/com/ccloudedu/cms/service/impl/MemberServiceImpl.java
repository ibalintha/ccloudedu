package com.ccloudedu.cms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.cms.entity.CmsMember;
import com.ccloudedu.cms.service.MemberService;
@Service
@Transactional
public class MemberServiceImpl extends BaseServiceImpl<CmsMember> implements MemberService {

}
