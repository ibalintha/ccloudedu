package com.ccloudedu.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChModel;
import com.ccloudedu.system.service.ModelService;
@Service
@Transactional
public class ModelServiceImpl extends BaseServiceImpl<ChModel> implements ModelService {

}
