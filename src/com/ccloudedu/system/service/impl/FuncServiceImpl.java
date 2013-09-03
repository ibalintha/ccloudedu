package com.ccloudedu.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChFunction;
import com.ccloudedu.system.service.FuncService;
@Service
@Transactional
public class FuncServiceImpl extends BaseServiceImpl<ChFunction> implements FuncService {
	
}
