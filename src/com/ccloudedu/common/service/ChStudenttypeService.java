package com.ccloudedu.common.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChStudenttype;

public interface ChStudenttypeService extends BaseService<ChStudenttype>{

	public void saveStutype(ChStudenttype stutype) throws Exception;
	
}
