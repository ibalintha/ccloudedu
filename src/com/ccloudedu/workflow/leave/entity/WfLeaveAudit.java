package com.ccloudedu.workflow.leave.entity;

import java.io.Serializable;

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
import com.ccloudedu.system.entity.SysUser;
/**
 * 请假单审核
 * @author wade
 */
@Entity
@Table(name = "WF_LEAVE_AUDIT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class WfLeaveAudit extends IDEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysUser audtiUser;
	private String auditState;
	private String auditContent;
	private String auditTime;
    private WfLeave leave;
    
    public WfLeaveAudit() {
	}

	public WfLeaveAudit(String id) {
		super(id);
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUDTI_USER_ID")
	public SysUser getAudtiUser() {
		return audtiUser;
	}

	public void setAudtiUser(SysUser audtiUser) {
		this.audtiUser = audtiUser;
	}

	@Column(name = "AUDIT_STATE", length = 20)
	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	@Column(name = "AUDIT_CONTENT", length = 500)
	@Lob
	public String getAuditContent() {
		return auditContent;
	}

	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}

	@Column(name = "AUDIT_TIME", length = 20)
	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEAVE_ID")
	public WfLeave getLeave() {
		return leave;
	}

	public void setLeave(WfLeave leave) {
		this.leave = leave;
	}
	
}
