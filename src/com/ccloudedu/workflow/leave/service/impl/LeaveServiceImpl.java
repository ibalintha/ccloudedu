package com.ccloudedu.workflow.leave.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.dao.dbutils.BaseDbutilsDao;
import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.workflow.common.entity.WfExecuteSetting;
import com.ccloudedu.workflow.common.service.JbpmService;
import com.ccloudedu.workflow.common.service.WorkFlowSettingService;
import com.ccloudedu.workflow.leave.entity.LeaveWorkFlow;
import com.ccloudedu.workflow.leave.entity.WfLeave;
import com.ccloudedu.workflow.leave.entity.WfLeaveAudit;
import com.ccloudedu.workflow.leave.service.LeaveService;

@Service
@Transactional
public class LeaveServiceImpl extends BaseServiceImpl<WfLeave> implements LeaveService {
	@Autowired
	private BaseHibernateDao<WfLeaveAudit> leaveAuditDao;
	@Autowired
	private WorkFlowSettingService wfSettingService;
	@Autowired
	private JbpmService jbpmService;
	
	@Autowired
	private BaseDbutilsDao baseDbutilsDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveLeave(WfLeave leave, String nextExecutorId) throws Exception{
		
		String[] nextExecutors = nextExecutorId.split(",");
		WfExecuteSetting wfer = wfSettingService.get(nextExecutors[1]);
		SysUser user = Sessions.getSysUser();
		//保存请假单
		leave.setCreateTime(DateUtils.getCurrentDate());
		leave.setLeaveUser(user);
		save(leave);
		
		//启动一个流程
		Map<String,Object> variables = new HashMap<String, Object>();
		
		//发起人
		variables.put("applyer", user.getId());
		//发起人角色判断，jbpm自动执行decision节点，expr=name
		variables.put("roleName", wfer.getTransition());
		//下一步执行人
		variables.put(wfer.getVariableName(),nextExecutors[0]);
		//下一步执行人的操作类型
		variables.put("operateType",wfer.getOperateType());
		/*if("否".equals(ismanager)){
			variables.put("manager", nextExecutorId);
		}else{
			variables.put("boss", nextExecutorId);
		}*/
		ProcessInstance processInstance = jbpmService.addProcessInstance("leave", variables, leave.getId());
		
		 //让任务向下流转,提交任务 
		//jbpmService.findPersonalTasks(user.getId());
		Task task = jbpmService.findPersonalTasks(processInstance.getId(), user.getId());
		jbpmService.completeTask(task.getId(),"判断填写人角色");
		
		return 1;
	}
	
	/**
	 * 审核
	 * @throws Exception 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveAudit(WfLeave leave, WfLeaveAudit leaveAudit,String nextExecutorId,String processInstanceId) throws Exception{
		String transitionName = "";
		Map<String,Object> variables = new HashMap<String, Object>();
		if(leaveAudit!=null && "disAgree".equals(leaveAudit.getAuditState())){//不同意
			transitionName = "不同意";
		}else{
			if(StringUtils.isNotBlank(nextExecutorId)){//非最后一步
				
				//nextExecutorId = 下一步执行人id,流程执行设置id
				String[] nextExecutors = nextExecutorId.split(",");
				
				//获得流程执行设置
				WfExecuteSetting wfer = wfSettingService.get(nextExecutors[1]);
				//流程转向
				transitionName= wfer.getTransition();
				//下一步执行人
				variables.put(wfer.getVariableName(), nextExecutors[0]);
				//下一步执行人的操作类型
				variables.put("operateType",wfer.getOperateType());
			}else{//最后一步
				transitionName = "财务完成";
			}
		}
		Task task = jbpmService.findPersonalTasks(processInstanceId,Sessions.getSysUser().getId());
		jbpmService.completeTask(task.getId(),transitionName,variables);
		
		//保存审核意见
		if(leaveAudit!=null){
			leaveAudit.setAudtiUser(Sessions.getSysUser());
			leaveAudit.setAuditTime(DateUtils.getCurrentDate());
			leaveAudit.setLeave(leave);
			leaveAuditDao.save(leaveAudit);
			
			//这里需要手工清理下缓存
			EhCacheManager.remove("dbutilsCache","wf_leave");
		}
		
		return 1;
	}
	/**
	 * 查询我的请假单
	 */
	public Page findPageTasks(Page page) throws Exception{
		 Map<String,String> paramMap = new LinkedHashMap<String,String>();
		 paramMap.put("userId",Sessions.getSysUser().getId());
 		 return baseDbutilsDao.findPage(LeaveWorkFlow.class,page,"workflow.findTasks",paramMap);
	}
	/**
	 * 查询审核中的请假单
	 */
	@SuppressWarnings("unchecked")
	public Page findPageAuditingTasks(Page page) throws Exception{
		 String userId = Sessions.getSysUser().getId();
		 Map<String,String> paramMap = new FastMap().newHashMap().set("userId", userId);
 		 return baseDbutilsDao.findPage(LeaveWorkFlow.class,page,"findAuditingTasks",paramMap);
	}
	/**
	 * 查询已完成的请假单
	 */
	@SuppressWarnings("unchecked")
	public Page findPageHistoryTasks(Page page) throws Exception{
		 String userId = Sessions.getSysUser().getId();
		 Map<String,String> paramMap = new FastMap().newHashMap().set("userId", userId) ;
		return baseDbutilsDao.findPage(LeaveWorkFlow.class,page,"findHistoryTasks",paramMap);
	}
}
