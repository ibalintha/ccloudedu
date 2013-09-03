package com.ccloudedu.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;

@Entity
@Table(name = "SYS_ACCESS_LOG")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysAccessLog extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysUser accessUser;
	private String acccessIp;
	private String accessTime;
	private String accessType;
	private String accessMethod;
	private String operateArg;
	private String accessDescribe;
	private String createTime;
	
	public SysAccessLog() {
	}
	public SysAccessLog(String id) {
		super(id);
	}
	public SysAccessLog(String id,SysUser accessUser,
			          String acccessIp,String accessTime,String accessType,String accessMethod,
			          String operateArg,String accessDescribe,String createTime) {
		this.accessUser = accessUser;
		this.acccessIp = acccessIp;
		this.accessTime = accessTime;
		this.accessType = accessType;
		this.accessMethod = accessMethod;
		this.operateArg = operateArg;
		this.accessDescribe = accessDescribe;
		this.createTime = createTime;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public SysUser getAccessUser() {
		return accessUser;
	}
	public void setAccessUser(SysUser accessUser) {
		this.accessUser = accessUser;
	}
	
	@Column(name = "ACCCESS_IP", length = 20)
	public String getAcccessIp() {
		return acccessIp;
	}
	public void setAcccessIp(String acccessIp) {
		this.acccessIp = acccessIp;
	}
	
	@Column(name = "ACCESS_TIME", length = 20)
	public String getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	
	@Column(name = "ACCESS_TYPE", length = 20)
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	
	@Column(name = "ACCESS_METHOD", length = 200)
	public String getAccessMethod() {
		return accessMethod;
	}
	public void setAccessMethod(String accessMethod) {
		this.accessMethod = accessMethod;
	}
	@Lob
	@Column(name = "OPERATE_ARG")
	public String getOperateArg() {
		return operateArg;
	}
	public void setOperateArg(String operateArg) {
		this.operateArg = operateArg;
	}
	
	@Column(name = "ACCESS_DESCRIBE", length = 20)
	public String getAccessDescribe() {
		return accessDescribe;
	}
	public void setAccessDescribe(String accessDescribe) {
		this.accessDescribe = accessDescribe;
	}
	
	@Column(name = "CREATE_TIME", length = 20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
