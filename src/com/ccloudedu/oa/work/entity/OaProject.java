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
 * 项目
 * @author wade
 *
 */
@Entity
@Table(name = "OA_PROJECT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaProject extends IDEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String projectCode;//项目编号
	private String projectName;//项目名称
	private String urgencyDegree;//紧急程度
	private String projectDesc;//项目描述
	
	private Set<OaProjectSchedule> OaProjectSchedules = new HashSet<OaProjectSchedule>(0);
	private Set<OaProjectParticipant> oaProjectParticipant = new HashSet<OaProjectParticipant>(0);
	
	private SysUser creator;//创建人
	private String createTime;//创建时间
	
    public OaProject(){
		
	}
    public OaProject(String id){
		super(id);
	}
    
    @Column(name = "PROJECT_CODE", length = 50)
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Column(name = "PROJECT_NAME", length = 200)
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Column(name = "URGENCY_DEGREE", length = 10)
	public String getUrgencyDegree() {
		return urgencyDegree;
	}
	public void setUrgencyDegree(String urgencyDegree) {
		this.urgencyDegree = urgencyDegree;
	}
	
	@Column(name = "PROJECT_DESC", length = 1000)
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "oaProject")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<OaProjectSchedule> getOaProjectSchedules() {
		return OaProjectSchedules;
	}
	public void setOaProjectSchedules(Set<OaProjectSchedule> oaProjectSchedules) {
		OaProjectSchedules = oaProjectSchedules;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "oaProject")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<OaProjectParticipant> getOaProjectParticipant() {
		return oaProjectParticipant;
	}
	public void setOaProjectParticipant(
			Set<OaProjectParticipant> oaProjectParticipant) {
		this.oaProjectParticipant = oaProjectParticipant;
	}
}
