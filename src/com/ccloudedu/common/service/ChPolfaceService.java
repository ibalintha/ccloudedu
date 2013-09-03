package com.ccloudedu.common.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChPolface;

public interface ChPolfaceService extends BaseService<ChPolface>{

	public void savePolface(ChPolface polface) throws Exception;
}
