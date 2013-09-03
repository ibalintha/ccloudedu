package com.ccloudedu.common.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChAdminway;

public interface ChAdminwayService extends BaseService<ChAdminway>{

	public void saveAdminway(ChAdminway adminway) throws Exception;
}
