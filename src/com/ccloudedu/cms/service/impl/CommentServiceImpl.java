package com.ccloudedu.cms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.cms.entity.CmsComment;
import com.ccloudedu.cms.service.CommentService;
@Service
@Transactional
public class CommentServiceImpl extends BaseServiceImpl<CmsComment> implements CommentService {

}
