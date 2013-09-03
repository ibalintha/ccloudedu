package com.ccloudedu.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChForeign;
import com.ccloudedu.common.service.ChForeignService;
@Service
@Transactional
public class ChForeignServiceImpl extends BaseServiceImpl<ChForeign> implements ChForeignService{

	@Override
	public void saveForeign(ChForeign foreign) throws Exception {
		save(foreign);
	}

}
