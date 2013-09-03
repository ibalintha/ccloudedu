package com.ccloudedu.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChPersontype;
import com.ccloudedu.common.service.ChPersontypeService;
@Service
@Transactional
public class ChPersontypeServiceImpl extends BaseServiceImpl<ChPersontype> implements ChPersontypeService{

	@Override
	public void savePersontype(ChPersontype persontype) throws Exception {
		save(persontype);
	}

}
