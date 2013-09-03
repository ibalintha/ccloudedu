package com.ccloudedu.system.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;

@Entity
@Table(name = "USER_LOGIN_LOG")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserLoginLog extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String loginTime;
	private String logoutTime;
	private String onlineTimeLength;
	private String loginIp;
	private SysUser loginUser;
	
	public UserLoginLog() {
	}
	public UserLoginLog(String id) {
		super(id);
	}
	public UserLoginLog(String id,SysUser sysUser,String createTime,
			          String loginTime,String logoutTime,String onlineTimeLength,String loginIp,SysUser loginUser) {
		super(id,sysUser,createTime);
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.loginIp = loginIp;
		this.onlineTimeLength = onlineTimeLength;
		this.loginUser = loginUser;
	}
	
	@Column(name = "LOGIN_TIME", length = 20)
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	
	@Column(name = "LOGOUT_TIME", length = 20)
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	
	@Column(name = "ONLINE_TIME_LENGTH", length = 20)
	public String getOnlineTimeLength() {
		return onlineTimeLength;
	}
	public void setOnlineTimeLength(String onlineTimeLength) {
		this.onlineTimeLength = onlineTimeLength;
	}

	@Column(name = "LOGIN_IP", length = 20)
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public SysUser getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(SysUser loginUser) {
		this.loginUser = loginUser;
	}
	

}
