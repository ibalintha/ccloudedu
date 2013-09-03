package com.ccloudedu.system.service;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.system.entity.SysAccessLog;

public interface AccessLogService extends BaseService<SysAccessLog> {

	Page findPage(Page page, String accessUserId, String accessUserName,
			String startAccessTime, String endAccessTime) throws Exception;

}
