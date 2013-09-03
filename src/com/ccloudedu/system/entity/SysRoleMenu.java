package com.ccloudedu.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.constants.enums.Auth;
import com.ccloudedu.base.entity.IDEntity;
import com.ccloudedu.base.utils.DateUtils;
/**
 * 角色菜单中间表
 * @author wade
 *
 */
@Entity
@Table(name = "SYS_ROLE_MENU")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysRoleMenu  extends IDEntity implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Auth auth=Auth.W;//权限级别，R:查看，W:增删改查，N：不具有访问权限
	private SysRole sysRole;
	private SysMenu sysMenu;
	private String createTime=DateUtils.getCurrentDate();
	
	public SysRoleMenu() {
		
	}

	public SysRoleMenu(String id) {
		super(id);
	}
	
	public SysRoleMenu(String id,Auth auth, SysRole sysRole, SysMenu sysMenu, String createTime){
		 super(id);
	     this.auth=auth;
		 this.sysMenu=sysMenu;
		 this.sysRole=sysRole;
		 this.createTime=createTime;
	}
	
	@Column(name = "AUTH",length=10)
	@Enumerated(EnumType.STRING)
	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}
	
	@Column(name = "CREATE_TIME",length=20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}

