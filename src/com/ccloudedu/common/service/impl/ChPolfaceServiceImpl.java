package com.ccloudedu.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChPolface;
import com.ccloudedu.common.service.ChPolfaceService;
@Service
@Transactional
public class ChPolfaceServiceImpl extends BaseServiceImpl<ChPolface> implements ChPolfaceService{

	@Override
	public void savePolface(ChPolface polface) throws Exception {
		save(polface);
	}

}
