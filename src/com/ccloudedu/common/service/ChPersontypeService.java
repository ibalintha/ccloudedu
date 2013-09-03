package com.ccloudedu.common.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChPersontype;

public interface ChPersontypeService extends BaseService<ChPersontype>{
	
	public void savePersontype(ChPersontype persontype) throws Exception;
}
