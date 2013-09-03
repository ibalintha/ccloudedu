package com.ccloudedu.common.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChHealthstatus;

public interface ChHealthstatusService extends BaseService<ChHealthstatus>{

	public void saveHealthstatus(ChHealthstatus healthstatus) throws Exception;
}
