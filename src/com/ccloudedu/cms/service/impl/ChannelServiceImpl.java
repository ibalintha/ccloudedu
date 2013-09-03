package com.ccloudedu.cms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.cms.entity.CmsChannel;
import com.ccloudedu.cms.service.ChannelService;
@Service
@Transactional
public class ChannelServiceImpl extends BaseServiceImpl<CmsChannel> implements ChannelService{

}
