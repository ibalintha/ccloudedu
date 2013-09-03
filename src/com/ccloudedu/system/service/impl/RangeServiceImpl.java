package com.ccloudedu.system.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChRange;
import com.ccloudedu.system.service.RangeService;
@Service
@Transactional
public class RangeServiceImpl extends BaseServiceImpl<ChRange> implements RangeService {

}
