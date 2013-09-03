package com.ccloudedu.workflow.leave.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.WorkFlowUtils;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.system.entity.SysDataDictionary;
import com.ccloudedu.system.service.DataDictionaryService;
import com.ccloudedu.system.service.UserService;
import com.ccloudedu.workflow.common.entity.WfExecutor;
import com.ccloudedu.workflow.common.service.JbpmService;
import com.ccloudedu.workflow.leave.entity.WfLeave;
import com.ccloudedu.workflow.leave.entity.WfLeaveAudit;
import com.ccloudedu.workflow.leave.service.LeaveService;

/**
 * 请假流程action
 * @author wade
 */
@Scope("prototype")
@Controller("workflow.leave.action.LeaveAction")
public class LeaveAction extends BaseCrudAction<WfLeave>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private WfLeave leave;
	private WfLeaveAudit leaveAudit;
	private Page page = new Page(Constants.PAGE_SIZE);
	private List<WfExecutor> nextExecutors;
	private String nextExecutorId;
	private String processInstanceId;
	private String executionId;
	private String operateType;//当前执行人操作类型
	//private List<LeaveWorkFlow> leaveWorkFlowList;
	
	private List<SysDataDictionary> ddLeaveList;
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private UserService userService;
	@Autowired
	private JbpmService jbpmService;
	
	@Autowired
	private DataDictionaryService dataDictionaryService;

	public WfLeave getModel() {
		return leave;
	}
	
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			leave = new WfLeave();
		}else{
			leave = leaveService.get(id);
		}
	}
	
	public String add() throws Exception {
		nextExecutors = userService.findWfExecutor(Sessions.getSysUser().getRoleId(),"qingjia","");
		ddLeaveList = dataDictionaryService.getDDbyParentDDValue("leave");
		return ADD;
	}
	
	public String save() throws Exception {
		leaveService.saveLeave(leave,nextExecutorId);
		Renders.renderJson(Renders.SAVE_SUCCESS);
		return NONE;
	}
    @Menu
	public String list() throws Exception {
		page = leaveService.findPageTasks(page);
		return LIST;
	}
	/**
	 * 审核请假单列表
	 * @return
	 * @throws Exception 
	 */
	@Menu
	public String listAudit() throws Exception{
		page = leaveService.findPageAuditingTasks(page);
		return "listAudit";
	}
	/**
	 * 历史请假单
	 * @return
	 * @throws Exception 
	 */
	@Menu
	public String listHistory() throws Exception{
		page = leaveService.findPageHistoryTasks(page);
		return "listHistory";
	}
	
	public String detail() throws Exception{
		leave = leaveService.get(id);
		return DETAIL;
	}
	
	//审核
	public String detailAudit() throws Exception{
		leave = leaveService.get(id);
		
		int leaveDayNum = leave.getLeaveDayNumber();
		List<String> decisions = new ArrayList<String>();
		if(leaveDayNum<=5){
			decisions.add("请假不多于5天");
		}else if(leaveDayNum>5 && leaveDayNum<=10){
			decisions.add("请假大于5天");
			decisions.add("请假不多于10天");
		}else{
			decisions.add("请假大于5天");
			decisions.add("请假大于10天");
		}
		//当前执行人操作类型，由上一步执行人设置
		operateType = jbpmService.getVariableByexecutionId(processInstanceId, "operateType").toString();
		nextExecutors = userService.findWfExecutor(Sessions.getSysUser().getRoleId(),"qingjia","");
		nextExecutors = WorkFlowUtils.filterNextExecutors(decisions, nextExecutors);
		return "detailAudit";
	}
	public String saveAudit() throws Exception{
		leave = leaveService.get(id);
		leaveService.saveAudit(leave,leaveAudit,nextExecutorId,processInstanceId);
		Renders.renderJson(Renders.SAVE_SUCCESS);
		return "detailAudit";
	}
	
	
	public String delete() throws Exception {
		
		return NONE;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<WfExecutor> getNextExecutors() {
		return nextExecutors;
	}

	public void setNextExecutors(List<WfExecutor> nextExecutors) {
		this.nextExecutors = nextExecutors;
	}

	public String getNextExecutorId() {
		return nextExecutorId;
	}

	public void setNextExecutorId(String nextExecutorId) {
		this.nextExecutorId = nextExecutorId;
	}

	public WfLeave getLeave() {
		return leave;
	}

	public void setLeave(WfLeave leave) {
		this.leave = leave;
	}

	/*public List<LeaveWorkFlow> getLeaveWorkFlowList() {
		return leaveWorkFlowList;
	}

	public void setLeaveWorkFlowList(List<LeaveWorkFlow> leaveWorkFlowList) {
		this.leaveWorkFlowList = leaveWorkFlowList;
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WfLeaveAudit getLeaveAudit() {
		return leaveAudit;
	}

	public void setLeaveAudit(WfLeaveAudit leaveAudit) {
		this.leaveAudit = leaveAudit;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	@Override
	public String update() throws Exception {
		
		return null;
	}

	public List<SysDataDictionary> getDdLeaveList() {
		return ddLeaveList;
	}

	public void setDdLeaveList(List<SysDataDictionary> ddLeaveList) {
		this.ddLeaveList = ddLeaveList;
	}
}
