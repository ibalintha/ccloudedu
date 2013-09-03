package com.ccloudedu.oa.work.entity;

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
import com.ccloudedu.system.entity.SysUser;
/**
 * 项目进度
 * @author wade
 */
@Entity
@Table(name = "OA_PROJECT_SCHEDULE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaProjectSchedule extends IDEntity implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String scheduleCode;//代码
	private String description;//描述
	private String startDt;//开始时间
	private String endDt;//结束时间
	
	private OaProject oaProject;//所属项目
	private Set<OaProjectParticipant> oaProjectParticipant = new HashSet<OaProjectParticipant>(0);
	
	private SysUser creator;//创建人
	private String createTime;//创建时间
	
    public OaProjectSchedule(){
		
	}
    public OaProjectSchedule(String id){
		super(id);
	}
    
    @Column(name = "SCHEDULE_CODE", length = 20)
	public String getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
    
    @Column(name = "DESCRIPTION", length = 500)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	@JoinColumn(name = "PROJECT_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public OaProject getOaProject() {
		return oaProject;
	}
	public void setOaProject(OaProject oaProject) {
		this.oaProject = oaProject;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "oaProjectSchedule")
	@OrderBy("createTime asc")
	//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<OaProjectParticipant> getOaProjectParticipant() {
		return oaProjectParticipant;
	}
	public void setOaProjectParticipant(
			Set<OaProjectParticipant> oaProjectParticipant) {
		this.oaProjectParticipant = oaProjectParticipant;
	}
}