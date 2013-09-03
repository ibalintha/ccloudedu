package com.ccloudedu.workflow.leave.service;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.workflow.leave.entity.WfLeave;
import com.ccloudedu.workflow.leave.entity.WfLeaveAudit;
/**
 * 请假流程service
 * @author wade
 */
public interface LeaveService extends BaseService<WfLeave> {

	public int saveLeave(WfLeave leave, String nextExecutorId) throws Exception;

	public Page findPageTasks(Page page) throws Exception;

	public Page findPageAuditingTasks(Page page) throws Exception;

	public int saveAudit(WfLeave leave, WfLeaveAudit leaveAudit,String nextExecutorId,String processInstanceId) throws Exception;

	public Page findPageHistoryTasks(Page page) throws Exception;
}
