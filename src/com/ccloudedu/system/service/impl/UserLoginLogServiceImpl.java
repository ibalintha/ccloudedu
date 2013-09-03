package com.ccloudedu.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.system.entity.UserLoginLog;
import com.ccloudedu.system.service.UserLoginLogService;

@Service
@Transactional
public class UserLoginLogServiceImpl extends BaseServiceImpl<UserLoginLog> implements UserLoginLogService {

}
