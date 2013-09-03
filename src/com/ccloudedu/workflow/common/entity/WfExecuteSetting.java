package com.ccloudedu.workflow.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
/**
 * 流程执行设置
 * @author wade
 */
@Entity
@Table(name = "WF_EXECUTE_SETTING")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class WfExecuteSetting  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String curRoleId;//当前执行人角色
	private String nextRoleId;//下一步执行人角色
	private String wfCat;//归属流程
	private String transition;//流程转向name
	private String variableName;//下一步执行人在流程中的变量名
	private String operateType;//下一步执行人的操作类型
	
	public WfExecuteSetting() {
		super();
	}
	public WfExecuteSetting(String id) {
		super(id);
	}
	@Column(name = "CUR_ROLE_ID", length = 32)
	public String getCurRoleId() {
		return curRoleId;
	}
	public void setCurRoleId(String curRoleId) {
		this.curRoleId = curRoleId;
	}
	
	@Column(name = "NEXT_ROLE_ID", length = 32)
	public String getNextRoleId() {
		return nextRoleId;
	}
	public void setNextRoleId(String nextRoleId) {
		this.nextRoleId = nextRoleId;
	}
	@Column(name = "WF_CAT", length = 10)
	public String getWfCat() {
		return wfCat;
	}
	public void setWfCat(String wfCat) {
		this.wfCat = wfCat;
	}
	
	@Column(name = "TRANSITION", length = 50)
	public String getTransition() {
		return transition;
	}
	public void setTransition(String transition) {
		this.transition = transition;
	}
	
	@Column(name = "VARIABLE_NAME", length = 20)
	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	
	@Column(name = "OPERATE_TYPE", length = 20)
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	
}
