package com.ccloudedu.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.system.entity.SysAccessLog;
import com.ccloudedu.system.service.AccessLogService;
@Service
@Transactional
public class AccessLogServiceImpl extends BaseServiceImpl<SysAccessLog> implements AccessLogService {

	public Page findPage(Page page, String accessUserId,String accessUserName,String startAccessTime, String endAccessTime) throws Exception {
	/*	HqlBuilder hqlBuilder = HqlBuilder.create("select log from SysAccessLog as log where 1=1");
		if(StringUtils.isNotEmpty(accessUserId)){
			hqlBuilder.append(" and log.accessUser.id=:accessUserId ").setParam("accessUserId", accessUserId);
		}
		if(StringUtils.isNotEmpty(accessUserName)){
			hqlBuilder.append(" and log.accessUser.userName like:accessUserName ").setParam("accessUserName", "%"+accessUserName+"%");
		}
		if(StringUtils.isNotEmpty(startAccessTime)){
			hqlBuilder.append(" and log.accessTime>=:startAccessTime ").setParam("startAccessTime", startAccessTime);
		}
		if(StringUtils.isNotEmpty(endAccessTime)){
			hqlBuilder.append(" and log.accessTime<=:endAccessTime ").setParam("endAccessTime", endAccessTime);
		}
		//hqlBuilder.append(" order by log.accessTime desc");
		if(StringUtils.isNotBlank(page.getOrderattr())){
			hqlBuilder.append("order by convert_gbk(").append(page.getOrderattr()).append(") ").append(StringUtils.isBlank(page.getOrdertype())?"desc":page.getOrdertype());
		}else{
			hqlBuilder.append(" order by log.accessTime desc");
		}*/
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("accessUserId", accessUserId);
		paramMap.put("accessUserName", "%"+accessUserName+"%");
		paramMap.put("startAccessTime", startAccessTime);
		paramMap.put("endAccessTime", endAccessTime);
		return findPage(page, "system.accessLog.findPage",paramMap);
	}

}
