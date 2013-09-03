package com.ccloudedu.system.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.annotation.AccessLog;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChDepartment;
import com.ccloudedu.system.service.DeptServiceCh;
@Service
@Transactional
@AccessLog
public class DeptServiceChImpl extends BaseServiceImpl<ChDepartment> implements DeptServiceCh {
}
