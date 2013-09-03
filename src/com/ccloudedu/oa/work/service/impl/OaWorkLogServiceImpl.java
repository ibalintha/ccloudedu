package com.ccloudedu.oa.work.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.oa.work.entity.OaWorkLog;
import com.ccloudedu.oa.work.service.OaWorkLogService;
import com.ccloudedu.system.entity.SysDept;

@Service
@Transactional
public class OaWorkLogServiceImpl extends BaseServiceImpl<OaWorkLog> implements OaWorkLogService {
	@Autowired
	private BaseHibernateDao<SysDept> deptDao;
	
	public Page findPage(Page page,String isLeaderRead) throws Exception{
		Map<String,String> paramMap = new FastMap<String, String>().newHashMap();
		if(StringUtils.isNotBlank(isLeaderRead)){
			String parentDeptLevel = deptDao.get(SysDept.class, Sessions.getSysUser().getSysDept().getId()).getDeptLevel();
			paramMap.put("parentDeptLevel", parentDeptLevel);
		}else{
			paramMap.put("userId", Sessions.getSysUser().getId());
		}
		return findPage(page, "oa.findWorkLogs",paramMap);
	}
}
