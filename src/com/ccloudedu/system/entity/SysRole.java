package com.ccloudedu.system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;

@Entity
@Table(name = "SYS_ROLE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysRole extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1459437022032814773L;
	private String roleName;
	private String enRoleName;
	private String roleCode;
	private String roleLevel;
	private String deskSetting;//桌面设置;
	private String remark;
	private String roleNameTemp;
	
	private SysRole sysRole;
	private Set<SysRole> sysRoles = new HashSet<SysRole>(0);
	private Set<SysUser> sysUsers = new HashSet<SysUser>(0);
	private Set<SysMenu> sysMenus = new HashSet<SysMenu>(0);
	//private JsonTreeNode jsonTree;
	public SysRole() {
	}
	public SysRole(String id) {
		super(id);
	}

	public SysRole(String id, SysRole sysRole, String roleName,
			SysUser sysUser, String createTime, String roleLevel, Set<SysMenu> sysMenus,
			Set<SysRole> sysRoles, Set<SysUser> sysUsers) {
		super(id,sysUser,createTime);
		this.sysRole = sysRole;
		this.roleName = roleName;
		this.roleLevel = roleLevel;
		this.sysMenus = sysMenus;
		this.sysRoles = sysRoles;
		this.sysUsers = sysUsers;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	@Column(name = "ROLE_NAME", length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Column(name = "EN_ROLE_NAME", length = 50)
	public String getEnRoleName() {
		return enRoleName;
	}
	public void setEnRoleName(String enRoleName) {
		this.enRoleName = enRoleName;
	}
	
	@Column(name = "ROLE_CODE", length = 20)
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYS_ROLE_MENU", 
			joinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "MENU_ID", nullable = false, updatable = false) })
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<SysMenu> getSysMenus() {
		return this.sysMenus;
	}

	public void setSysMenus(Set<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysRole")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<SysRole> getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysRole")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)*/
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYS_USER_ROLE", 
			joinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<SysUser> getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

	@Column(name = "ROLE_LEVEL",length=50)
	public String getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	@Column(name = "DESK_SETTING",length=100)
	public String getDeskSetting() {
		return deskSetting;
	}

	public void setDeskSetting(String deskSetting) {
		this.deskSetting = deskSetting;
	}
	@Column(name = "REMARK", length = 512)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public String getRoleNameTemp() {
		String nbsp = "";
		for(int i=0;i<(getRoleLevel().split("_").length/2)-1;i++){
			nbsp = (nbsp+"&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		roleNameTemp = nbsp+roleName;
		return roleNameTemp;
	}

	public void setRoleNameTemp(String roleNameTemp) {
		this.roleNameTemp = roleNameTemp;
	}
}
