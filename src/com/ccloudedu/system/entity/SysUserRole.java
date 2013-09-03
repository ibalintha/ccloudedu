package com.ccloudedu.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;


/**
 * 用户角色中间表
 * @author wade
 *
 */
@Entity
@Table(name = "SYS_USER_ROLE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysUserRole extends IDEntity implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderNum;
	private SysUser sysUser;
	private SysRole sysRole;
	private String createTime;
	
	public SysUserRole() {
	}

	public SysUserRole(String id) {
		super(id);
	}
	
	public SysUserRole(String id,int orderNum, SysUser sysUser, SysRole sysRole, String createTime){
		 super(id);
	     this.orderNum=orderNum;
		 this.sysUser=sysUser;
		 this.sysRole=sysRole;
		 this.createTime=createTime;
	}
	
	@Column(name = "ORDER_NUM")
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public SysRole getSysRole() {
		return sysRole;
	}
	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
	
	@Column(name = "CREATE_TIME",length=20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
