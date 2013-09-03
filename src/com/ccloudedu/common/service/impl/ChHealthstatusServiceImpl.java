package com.ccloudedu.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChHealthstatus;
import com.ccloudedu.common.service.ChHealthstatusService;
@Service
@Transactional
public class ChHealthstatusServiceImpl extends BaseServiceImpl<ChHealthstatus> implements ChHealthstatusService{

	@Override
	public void saveHealthstatus(ChHealthstatus healthstatus) throws Exception {
		save(healthstatus);
	}

}
