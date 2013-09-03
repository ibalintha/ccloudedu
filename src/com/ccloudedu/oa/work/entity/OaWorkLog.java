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
import com.ccloudedu.system.entity.SysUser;

/**
 * 工作日志
 * @author wade
 *
 */
@Entity
@Table(name = "OA_WORK_LOG")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaWorkLog extends IDEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String weekDay;
	private String workType;
	private String workPlace;
	private String workTheme;
	private String workContent;
	private String workDate;//工作日期
	private String isArchive;
	private String archiveTime;
	private String urgencyDegree;
	private String isDraft;
	private String startTime;
	private String endTime;
	private double duringLlong;
	
	private OaProject oaProject;//所属项目
	private SysUser creator;//创建人
	private String createTime;//创建时间
	
    public OaWorkLog(){
		
	}
    public OaWorkLog(String id){
		super(id);
	}
    
    @Column(name = "WEEK_DAY", length = 20)
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	
	@Column(name = "WORK_TYPE", length = 20)
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	@Column(name = "WORK_PLACE", length = 20)
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	
	@Column(name = "WORK_THEME", length = 200)
	public String getWorkTheme() {
		return workTheme;
	}
	public void setWorkTheme(String workTheme) {
		this.workTheme = workTheme;
	}
	
	@Column(name = "WORK_CONTENT", length = 1000)
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	
	@Column(name = "IS_ARCHIVE", length = 10)
	public String getIsArchive() {
		return isArchive;
	}
	public void setIsArchive(String isArchive) {
		this.isArchive = isArchive;
	}
	
	@Column(name = "ARCHIVE_TIME", length = 20)
	public String getArchiveTime() {
		return archiveTime;
	}
	public void setArchiveTime(String archiveTime) {
		this.archiveTime = archiveTime;
	}
	
	@Column(name = "URGENCY_DEGREE", length = 10)
	public String getUrgencyDegree() {
		return urgencyDegree;
	}
	public void setUrgencyDegree(String urgencyDegree) {
		this.urgencyDegree = urgencyDegree;
	}
	
	@Column(name = "IS_DRAFT", length = 10)
	public String getIsDraft() {
		return isDraft;
	}
	public void setIsDraft(String isDraft) {
		this.isDraft = isDraft;
	}
	
	@Column(name = "START_TIME", length = 20)
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	@Column(name = "END_TIME", length = 20)
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Column(name = "DURING_LONG")
	public double getDuringLlong() {
		return duringLlong;
	}
	public void setDuringLlong(double duringLlong) {
		this.duringLlong = duringLlong;
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
	
	@Column(name = "WORK_DATE", length = 20)
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
}