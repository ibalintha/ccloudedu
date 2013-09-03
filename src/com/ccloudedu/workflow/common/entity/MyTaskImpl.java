package com.ccloudedu.workflow.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jbpm.pvm.internal.task.TaskImpl;
/**
 * 扩展jbpmm的TaskImpl
 * @author wade
 *
 */
@Entity
@Table(name="jbpm4_task")
public class MyTaskImpl extends TaskImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String operateType;//执行人的操作类型，对应数据库字段OPERATE_TYPE_，长度为20

	public MyTaskImpl(){
		super();
	}
	@Column(name="OPERATE_TYPE_",length=20)
	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
}
