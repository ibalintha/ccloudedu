package com.ccloudedu.workflow.leave.entity;

import java.util.Date;

public class LeaveWorkFlow {
	private String id;//请假单id
	private String leave_time;
	private String leave_end_time;
    private String leave_content;
    private int leave_day_number;
    private String leave_user_name;
    private String leave_type;
    private String project_name;
		
	private String task_name;
	private Date task_create_dt;
	private String task_user_name;
	private String process_definition_id;
	private String process_instance_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String taskName) {
		task_name = taskName;
	}
	public Date getTask_create_dt() {
		return task_create_dt;
	}
	public void setTask_create_dt(Date taskCreateDt) {
		task_create_dt = taskCreateDt;
	}
	public String getTask_user_name() {
		return task_user_name;
	}
	public void setTask_user_name(String taskUserName) {
		task_user_name = taskUserName;
	}
	public String getLeave_time() {
		return leave_time;
	}
	public void setLeave_time(String leaveTime) {
		leave_time = leaveTime;
	}
	public String getLeave_content() {
		return leave_content;
	}
	public void setLeave_content(String leaveContent) {
		leave_content = leaveContent;
	}
	public String getProcess_definition_id() {
		return process_definition_id;
	}
	public void setProcess_definition_id(String processDefinitionId) {
		process_definition_id = processDefinitionId;
	}
	public String getProcess_instance_id() {
		return process_instance_id;
	}
	public void setProcess_instance_id(String processInstanceId) {
		process_instance_id = processInstanceId;
	}
	public int getLeave_day_number() {
		return leave_day_number;
	}
	public void setLeave_day_number(int leaveDayNumber) {
		leave_day_number = leaveDayNumber;
	}
	public String getLeave_user_name() {
		return leave_user_name;
	}
	public void setLeave_user_name(String leaveUserName) {
		leave_user_name = leaveUserName;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leaveType) {
		leave_type = leaveType;
	}
	public String getLeave_end_time() {
		return leave_end_time;
	}
	public void setLeave_end_time(String leaveEndTime) {
		leave_end_time = leaveEndTime;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String projectName) {
		project_name = projectName;
	}
}
