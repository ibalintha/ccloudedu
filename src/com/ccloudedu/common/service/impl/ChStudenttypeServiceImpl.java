package com.ccloudedu.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChStudenttype;
import com.ccloudedu.common.service.ChStudenttypeService;
@Service
@Transactional
public class ChStudenttypeServiceImpl extends BaseServiceImpl<ChStudenttype> implements ChStudenttypeService{

	@Override
	public void saveStutype(ChStudenttype stutype) throws Exception {
		save(stutype);
	}

}
