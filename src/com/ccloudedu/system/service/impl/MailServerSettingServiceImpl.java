package com.ccloudedu.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.system.entity.SysMailServerSetting;
import com.ccloudedu.system.service.MailServerSettingService;

@Service
@Transactional
public class MailServerSettingServiceImpl extends BaseServiceImpl<SysMailServerSetting> implements MailServerSettingService {

}