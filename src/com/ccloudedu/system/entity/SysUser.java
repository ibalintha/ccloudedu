package com.ccloudedu.system.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.entity.BaseEntity;

@Entity
@Table(name = "SYS_USER")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysUser extends BaseEntity implements java.io.Serializable,HttpSessionBindingListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -761106677200018356L;
	private String userName;
	private String enUserName;
	private String passWord;
	private String loginName;
	private String isLeader;
	private String isOnline;
	private String ipAddress;
	private String isKeyLogin;
	private String entranceTime;
	private String cphone;
	private String ophone;
	private String mphone;
	private String hphone;
	private String birthday;
	private String status;
	private String addressHome;
	
	private String qq;
	private String msn;
	
	private String sex;
	private String registerTime;
	private String dimissionTime;
	private String addressBirth;
	private String postCode;
	private String mailbox;
	private String mailboxPassword;
	private String workPlace;//办公地点
	
	private String myselfDesk;//桌面设置
	private YN userRoleType;//用户角色类型 :是否系统管理员，Y：是，N:否（普通用户）
	
	private SysDept sysDept;//部门
	private List<SysRole> SysRoles = new ArrayList<SysRole>(0);
	
	//--------------------下面几个 是瞬时变量-------------------------------------------
	private SysRole sysRole;//当前访问系统的角色
	private String roleId;
	private String depeId;
	private String loginTime;//登录时间
	private List<String> menuPaths = new ArrayList<String>();//可访问的菜单路径
	//以下三个变量用于导出excel
	private String sexTemp;
	private String deptNameTemp;
	private String roleNameTemp;
	
	public SysUser() {
	}

	public SysUser(String id) {
		super(id);
	}
	
	public SysUser(String id,SysDept sysDept,
			SysUser sysUser, String createTime,String userName, String passWord, String loginName,
			String isLeader, String isOnline, String ipAddress,
			String isKeyLogin, String entranceTime, String cphone,
			String ophone, String birthday, String status,
			String addressHome, String hphone, String sex,
			String registerTime, String dimissionTime, String mphone,String myselfDesk,
			String addressBirth, String postCode, String mailbox) {
		super(id,sysUser,createTime);
		this.sysDept = sysDept;
		this.userName = userName;
		this.passWord = passWord;
		this.loginName = loginName;
		this.isLeader = isLeader;
		this.isOnline = isOnline;
		this.ipAddress = ipAddress;
		this.isKeyLogin = isKeyLogin;
		this.entranceTime = entranceTime;
		this.cphone = cphone;
		this.ophone = ophone;
		this.birthday = birthday;
		this.status = status;
		this.addressHome = addressHome;
		this.hphone = hphone;
		this.sex = sex;
		this.registerTime = registerTime;
		this.dimissionTime = dimissionTime;
		this.mphone = mphone;
		this.addressBirth = addressBirth;
		this.postCode = postCode;
		this.mailbox = mailbox;
		this.myselfDesk = myselfDesk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPE_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public SysDept getSysDept() {
		return this.sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	@Column(name = "USER_NAME", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "EN_USER_NAME", length = 20)
	public String getEnUserName() {
		return enUserName;
	}

	public void setEnUserName(String enUserName) {
		this.enUserName = enUserName;
	}
	
	@Column(name = "PASS_WORD", length = 32)
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "LOGIN_NAME", length = 12)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "IS_LEADER", length = 1)
	public String getIsLeader() {
		return this.isLeader;
	}

	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}

	@Column(name = "IS_ONLINE", length = 1)
	public String getIsOnline() {
		return this.isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	@Column(name = "IP_ADDRESS", length = 24)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "IS_KEY_LOGIN", length = 1)
	public String getIsKeyLogin() {
		return this.isKeyLogin;
	}

	public void setIsKeyLogin(String isKeyLogin) {
		this.isKeyLogin = isKeyLogin;
	}

	@Column(name = "ENTRANCE_TIME", length = 20)
	public String getEntranceTime() {
		return this.entranceTime;
	}

	public void setEntranceTime(String entranceTime) {
		this.entranceTime = entranceTime;
	}

	@Column(name = "CPHONE", length = 20)
	public String getCphone() {
		return this.cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	@Column(name = "OPHONE", length = 15)
	public String getOphone() {
		return this.ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	@Column(name = "BIRTHDAY", length = 24)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "ADDRESS_HOME", length = 100)
	public String getAddressHome() {
		return this.addressHome;
	}

	public void setAddressHome(String addressHome) {
		this.addressHome = addressHome;
	}

	@Column(name = "HPHONE", length = 15)
	public String getHphone() {
		return this.hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	@Column(name = "SEX", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "REGISTER_TIME", length = 20)
	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "DIMISSION_TIME", length = 20)
	public String getDimissionTime() {
		return this.dimissionTime;
	}

	public void setDimissionTime(String dimissionTime) {
		this.dimissionTime = dimissionTime;
	}

	@Column(name = "MPHONE", length = 15)
	public String getMphone() {
		return this.mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	@Column(name = "ADDRESS_BIRTH", length = 100)
	public String getAddressBirth() {
		return this.addressBirth;
	}

	public void setAddressBirth(String addressBirth) {
		this.addressBirth = addressBirth;
	}

	@Column(name = "POST_CODE", length = 6)
	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "MAILBOX", length = 50)
	public String getMailbox() {
		return this.mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	
	@Column(name = "QQ", length = 15)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	@Column(name = "MSN", length = 60)
	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}
	
	@Column(name = "WORK_PLACE", length = 200)
	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	
	@Column(name = "MYSELF_DESK", length = 100)
	public String getMyselfDesk() {
		return myselfDesk;
	}
	public void setMyselfDesk(String myselfDesk) {
		this.myselfDesk = myselfDesk;
	}
	@Column(name = "USER_ROLE_TYPE", length = 2)
	@Enumerated(EnumType.STRING)
	public YN getUserRoleType() {
		return userRoleType;
	}

	public void setUserRoleType(YN userRoleType) {
		this.userRoleType = userRoleType;
	}
	
	@Column(name = "MAIL_BOX_PASSWORD", length = 32)
	public String getMailboxPassword() {
		return mailboxPassword;
	}

	public void setMailboxPassword(String mailboxPassword) {
		this.mailboxPassword = mailboxPassword;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYS_USER_ROLE", 
			joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public List<SysRole> getSysRoles() {
		return SysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles) {
		SysRoles = sysRoles;
	}
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)*/
	@Transient
	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
	
	@Transient
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Transient
	public String getDepeId() {
		return depeId;
	}

	public void setDepeId(String depeId) {
		this.depeId = depeId;
	}

	@Transient
	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
    
	@Transient
	public List<String> getMenuPaths() {
		return menuPaths;
	}

	public void setMenuPaths(List<String> menuPaths) {
		this.menuPaths = menuPaths;
	}

	@Transient
	public String getSexTemp() {
		sexTemp = "M".equals(sex)?"男":"女";
		return sexTemp;
	}

    public void setSexTemp(String sexTemp) {
		this.sexTemp = sexTemp;
	}
	
	@Transient
	public String getDeptNameTemp() {
		if(getSysDept()!=null){
			deptNameTemp = getSysDept().getDeptName();
		}
		return deptNameTemp;
	}

	public void setDeptNameTemp(String deptNameTemp) {
		this.deptNameTemp = deptNameTemp;
	}
	
	@Transient
	public String getRoleNameTemp() {
		List<SysRole> roleList = getSysRoles();
		if(roleList!=null && roleList.size()>0){
			roleNameTemp = "";
			for(SysRole role : roleList){
				if(StringUtils.isNotBlank(role.getRoleName())){
					roleNameTemp += (role.getRoleName()+" ");
				}
			}
		}
		return roleNameTemp;
	}

	public void setRoleNameTemp(String roleNameTemp) {
		this.roleNameTemp = roleNameTemp;
	}

	/**
	 * 获得在线用户信息
     * 放在ehcache缓存中，分布式环境配置分布式缓存
	 */
	public void valueBound(HttpSessionBindingEvent event) {
		//放入ehcache
		EhCacheManager.put(CacheConstants.HTTP_SESSION_CACHE, event.getSession().getId(), this);
	}

    /**
     * 用户退出时，从ehcache缓存中删除该用户的信息
     */
	public void valueUnbound(HttpSessionBindingEvent event) {
		//从ehcache中移除
		EhCacheManager.remove(CacheConstants.HTTP_SESSION_CACHE, event.getSession().getId());
	}
}
