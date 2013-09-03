package com.ccloudedu.system.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;

@Entity
@Table(name = "SYS_DEPT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysDept extends BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = -7969250614159287629L;
	
	private String deptName;
	private String enDeptName;
	private String deptFax;
	private String deptPhone;
	private String deptEmail;
	private String linkMan;
	private String postAddress;
	private String shortName;
	private String webSite;
	private String deptLevel;
	private SysDept sysDept;
	private String remark;
	
	private Set<SysDept> sysDepts = new HashSet<SysDept>(0);
	private Set<SysUser> sysUsers = new HashSet<SysUser>(0);
	//private JsonTreeNode jsonTree;

	public SysDept() {
		super();
	}
	public SysDept(String id) {
		super(id);
	}
	public SysDept(String id, SysDept sysDept, String deptName, String deptFax,
			String deptPhone, String deptEmail, String linkMan,
			String postAddress, String shortName, String webSite,
			String deptLevel, SysUser sysUser, String createTime,
			Set<SysDept> sysDepts, Set<SysUser> sysUsers) {
		super(id,sysUser,createTime);
		this.sysDept = sysDept;
		this.deptName = deptName;
		this.deptFax = deptFax;
		this.deptPhone = deptPhone;
		this.deptEmail = deptEmail;
		this.linkMan = linkMan;
		this.postAddress = postAddress;
		this.shortName = shortName;
		this.webSite = webSite;
		this.deptLevel = deptLevel;
		this.sysDepts = sysDepts;
		this.sysUsers = sysUsers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public SysDept getSysDept() {
		return this.sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Column(name = "DEPT_NAME", length = 50)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Column(name = "EN_DEPT_NAME", length = 50)
	public String getEnDeptName() {
		return enDeptName;
	}
	public void setEnDeptName(String enDeptName) {
		this.enDeptName = enDeptName;
	}

	@Column(name = "DEPT_FAX", length = 24)
	public String getDeptFax() {
		return this.deptFax;
	}

	public void setDeptFax(String deptFax) {
		this.deptFax = deptFax;
	}

	@Column(name = "DEPT_PHONE", length = 24)
	public String getDeptPhone() {
		return this.deptPhone;
	}

	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}

	@Column(name = "DEPT_EMAIL", length = 36)
	public String getDeptEmail() {
		return this.deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	@Column(name = "LINK_MAN", length = 120)
	public String getLinkMan() {
		return this.linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	@Column(name = "POST_ADDRESS", length = 250)
	public String getPostAddress() {
		return this.postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	@Column(name = "SHORT_NAME", length = 60)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "WEB_SITE", length = 128)
	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	@Column(name = "DEPT_LEVEL",length=50)
	public String getDeptLevel() {
		return deptLevel;
	}
	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}
	@Column(name = "REMARK", length = 512)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysDept")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<SysDept> getSysDepts() {
		return this.sysDepts;
	}

	public void setSysDepts(Set<SysDept> sysDepts) {
		this.sysDepts = sysDepts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysDept")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<SysUser> getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
}
