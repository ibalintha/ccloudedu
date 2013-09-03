package com.ccloudedu.common.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChForeign;

public interface ChForeignService extends BaseService<ChForeign>{

	public void saveForeign(ChForeign foreign) throws Exception;
}
