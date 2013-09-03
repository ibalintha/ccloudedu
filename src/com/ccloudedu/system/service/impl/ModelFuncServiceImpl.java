package com.ccloudedu.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChModelfunc;
import com.ccloudedu.system.service.ModelFuncService;
@Service
@Transactional
public class ModelFuncServiceImpl extends BaseServiceImpl<ChModelfunc> implements ModelFuncService {

}
