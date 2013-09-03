package com.ccloudedu.oa.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysUser;

/**
 * 项目进度参与人员
 * @author wade
 *
 */
@Entity
@Table(name = "OA_PROJECT_PARTICIPANT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaProjectParticipant extends IDEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;//描述
	private String immediately;//到岗时限
	private String startDt;//开始时间
	private String endDt;//结束时间
	
	private OaProjectSchedule oaProjectSchedule;
	private OaProject oaProject;//所属项目
	private SysUser sysUser;//参与人
	private SysRole sysRole;//参与人角色
	
	private SysUser creator;//创建人
	private String createTime;//创建时间
	
    public OaProjectParticipant(){
		
	}
    public OaProjectParticipant(String id){
		super(id);
	}
    
    @Column(name = "DESCRIPTION", length = 500)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "IMMEDIATELY", length = 50)
	public String getImmediately() {
		return immediately;
	}
	public void setImmediately(String immediately) {
		this.immediately = immediately;
	}
	
	@Column(name = "START_DT", length = 20)
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	
	@Column(name = "END_DT", length = 20)
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATE_USER_ID")
	public SysUser getCreator() {
		return creator;
	}
	public void setCreator(SysUser creator) {
		this.creator = creator;
	}
	
	@Column(name = "CREATE_TIME", length = 20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHEDUAL_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public OaProjectSchedule getOaProjectSchedule() {
		return oaProjectSchedule;
	}
	public void setOaProjectSchedule(OaProjectSchedule oaProjectSchedule) {
		this.oaProjectSchedule = oaProjectSchedule;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public OaProject getOaProject() {
		return oaProject;
	}
	public void setOaProject(OaProject oaProject) {
		this.oaProject = oaProject;
	}
}
