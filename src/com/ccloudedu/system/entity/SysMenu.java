package com.ccloudedu.system.entity;

import java.util.HashSet;
import java.util.List;
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
@Table(name = "SYS_MENU")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysMenu extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2091693125436003189L;
	
	private String menuPath;
	private String menuName;
	private String enMenuName;
	private int orderNumber;
	private SysMenu sysMenu;
	private String remark;
	private Set<SysRole> sysRoles = new HashSet<SysRole>(0);
	private Set<SysMenu> sysMenus = new HashSet<SysMenu>(0);
	
	//以下两个是临时对象，用于生成菜单树
	private List<SysMenu> subList;
	//private JsonTreeNode jsonTree;

	public SysMenu() {
	}
	public SysMenu(String id, SysMenu sysMenu, String menuPath,
			String menuName,SysUser sysUser,
			String createTime, int orderNumber,Set<SysRole> sysRoles, Set<SysMenu> sysMenus) {
		super(id,sysUser,createTime);
		this.sysMenu = sysMenu;
		this.menuPath = menuPath;
		this.menuName = menuName;
		this.orderNumber = orderNumber;
		this.sysRoles = sysRoles;
		this.sysMenus = sysMenus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public SysMenu getSysMenu() {
		return this.sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	@Column(name = "MENU_PATH", length = 128)
	public String getMenuPath() {
		return this.menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	@Column(name = "MENU_NAME", length = 50)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Column(name = "EN_MENU_NAME", length = 50)
	public String getEnMenuName() {
		return enMenuName;
	}
	public void setEnMenuName(String enMenuName) {
		this.enMenuName = enMenuName;
	}
	
	@Column(name = "ORDER_NUMBER", precision = 22, scale = 0)
	public int getOrderNumber() {
		return this.orderNumber;
	}

	@Column(name = "REMARK", length = 512)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYS_ROLE_MENU", joinColumns = { @JoinColumn(name = "MENU_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<SysRole> getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysMenu")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.NONE)
	public Set<SysMenu> getSysMenus() {
		return this.sysMenus;
	}

	public void setSysMenus(Set<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}
	
	@Transient
	public List<SysMenu> getSubList() {
		return subList;
	}
	public void setSubList(List<SysMenu> subList) {
		this.subList = subList;
	}
}
