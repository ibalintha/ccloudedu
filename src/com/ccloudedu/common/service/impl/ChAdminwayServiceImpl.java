package com.ccloudedu.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChAdminway;
import com.ccloudedu.common.service.ChAdminwayService;
@Service
@Transactional
public class ChAdminwayServiceImpl extends BaseServiceImpl<ChAdminway> implements ChAdminwayService{

	@Override
	public void saveAdminway(ChAdminway adminway) throws Exception {
		save(adminway);		
	}

}
