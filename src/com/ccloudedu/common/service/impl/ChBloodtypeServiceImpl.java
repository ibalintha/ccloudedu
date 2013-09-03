package com.ccloudedu.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChBloodtype;
import com.ccloudedu.common.service.ChBloodtypeService;
@Service
@Transactional
public class ChBloodtypeServiceImpl extends BaseServiceImpl<ChBloodtype> implements ChBloodtypeService{

	@Override
	public void saveBloodtype(ChBloodtype bloodtype) throws Exception {
		save(bloodtype);
	}

}
