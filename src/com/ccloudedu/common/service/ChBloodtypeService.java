package com.ccloudedu.common.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChBloodtype;

public interface ChBloodtypeService extends BaseService<ChBloodtype>{

	public void saveBloodtype(ChBloodtype bloodtype) throws Exception;
}
