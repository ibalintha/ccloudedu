package com.ccloudedu.workflow.common.entity;

/**
 * 流程执行人
 * @author wade
 *
 */

public class WfExecutor implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String wfExecuteId;
	private String userId;
	private String userName;
	private String eUserName;
	private String roleName;
	private String eRoleName;
	private String transition;
	
	public WfExecutor(){
		
	}
    public WfExecutor(String wfExecuteId,String userId,String userName,String roleName,String transition){
    	this.wfExecuteId = wfExecuteId;
		this.userId = userId;
		this.userName = userName;
		this.roleName = roleName;
		this.transition = transition;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String geteUserName() {
		return eUserName;
	}
	public void seteUserName(String eUserName) {
		this.eUserName = eUserName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String geteRoleName() {
		return eRoleName;
	}
	public void seteRoleName(String eRoleName) {
		this.eRoleName = eRoleName;
	}
	public String getTransition() {
		return transition;
	}
	public void setTransition(String transition) {
		this.transition = transition;
	}
	public String getWfExecuteId() {
		return wfExecuteId;
	}
	public void setWfExecuteId(String wfExecuteId) {
		this.wfExecuteId = wfExecuteId;
	}

}
