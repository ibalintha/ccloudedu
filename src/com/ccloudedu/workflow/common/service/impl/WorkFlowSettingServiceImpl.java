package com.ccloudedu.workflow.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.workflow.common.entity.WfExecuteSetting;
import com.ccloudedu.workflow.common.service.WorkFlowSettingService;
@Service
@Transactional
public class WorkFlowSettingServiceImpl extends BaseServiceImpl<WfExecuteSetting> implements WorkFlowSettingService {

	/**
	 * @throws Exception 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<WfExecuteSetting> findListByWfCat(String wfCat) throws Exception{
		return findList("workflow.findWfExecuteSettings",new FastMap().newHashMap().set("wfCat", wfCat));
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(String wfCat, List<String> curExecutorRoles,List<String> nextExecutorRoles,
			List<String> transitions,List<String> variableNames,List<String> operateTypes) throws Exception{
		//删除旧的
		batch("workflow.deleteWfExecuteSettings",new FastMap<String,String>().newHashMap().set("wfCat", wfCat));
		//插入新的
		WfExecuteSetting wfExecuteSetting = null;
		int i=0;
		for(String roleId : curExecutorRoles){
			wfExecuteSetting = new WfExecuteSetting();
			wfExecuteSetting.setCreateTime(DateUtils.getCurrentDate());
			wfExecuteSetting.setCreateUser(Sessions.getSysUser());
			wfExecuteSetting.setWfCat(wfCat);
			wfExecuteSetting.setCurRoleId(roleId);
			wfExecuteSetting.setNextRoleId(nextExecutorRoles.get(i));
			wfExecuteSetting.setTransition(transitions.get(i));
			wfExecuteSetting.setVariableName(variableNames.get(i));
			wfExecuteSetting.setOperateType(operateTypes.get(i));
			
			i++;
			
			save(wfExecuteSetting);
		}
		return 1;
	}
}
