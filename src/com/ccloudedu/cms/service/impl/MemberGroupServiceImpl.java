package com.ccloudedu.cms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.cms.entity.CmsMemberGroup;
import com.ccloudedu.cms.service.MemberGroupService;
@Service
@Transactional
public class MemberGroupServiceImpl extends BaseServiceImpl<CmsMemberGroup> implements
		MemberGroupService {

}