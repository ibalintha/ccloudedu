package com.ccloudedu.workflow.leave.entity;

import java.io.Serializable;
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

import com.ccloudedu.base.entity.IDEntity;
import com.ccloudedu.oa.work.entity.OaProject;
import com.ccloudedu.system.entity.SysUser;

/**
 * 请假单
 * @author wade
 */
@Entity
@Table(name = "WF_LEAVE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class WfLeave extends IDEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String leaveType;
	private SysUser leaveUser;
	private String leaveTime;
	private String leaveEndTime;
	private String leaveContent;
	private String createTime;
	private int leaveDayNumber;
	
	private OaProject oaProject;//所属项目
    private Set<WfLeaveAudit> leaveAudtis = new HashSet<WfLeaveAudit>();
    
    public WfLeave() {
	}

	public WfLeave(String id) {
		super(id);
	}
	
	
	@Column(name = "LEAVE_TYPE", length = 20)
	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEAVE_USER_ID")
	public SysUser getLeaveUser() {
		return leaveUser;
	}
	public void setLeaveUser(SysUser leaveUser) {
		this.leaveUser = leaveUser;
	}
	
	@Column(name = "LEAVE_TIME", length = 20)
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	
	@Column(name = "LEAVE_CONTENT", length = 1000)
	public String getLeaveContent() {
		return leaveContent;
	}
	public void setLeaveContent(String leaveContent) {
		this.leaveContent = leaveContent;
	}
	
	@Column(name = "CREATE_TIME", length = 20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "leave")
	@OrderBy("auditTime asc")
	public Set<WfLeaveAudit> getLeaveAudtis() {
		return leaveAudtis;
	}
	public void setLeaveAudtis(Set<WfLeaveAudit> leaveAudtis) {
		this.leaveAudtis = leaveAudtis;
	}

	@Column(name = "LEAVE_DAY_NUMBER")
	public int getLeaveDayNumber() {
		return leaveDayNumber;
	}

	public void setLeaveDayNumber(int leaveDayNumber) {
		this.leaveDayNumber = leaveDayNumber;
	}
	
	@Column(name = "LEAVE_END_TIME", length = 20)
	public String getLeaveEndTime() {
		return leaveEndTime;
	}

	public void setLeaveEndTime(String leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
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
