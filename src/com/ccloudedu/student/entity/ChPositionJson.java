package com.ccloudedu.student.entity;

/**
 * 学籍管理信息中的职位信息，用来向前台传输json串时使用
 * @author Pescadito
 * 2013-07-31 11:18
 */
public class ChPositionJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chPisitionTime;
	private String chPositionClass;
	private String chPositionSemester;
	private String chPositionJob;
	private String chPositionPolface;
	private String chPositionMaketime;
	private String chPositionAgent;
	
	
	public ChPositionJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChPositionJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chPisitionTime, String chPositionClass,
			String chPositionSemester, String chPositionJob,
			String chPositionPolface, String chPositionMaketime,
			String chPositionAgent) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chPisitionTime = chPisitionTime;
		this.chPositionClass = chPositionClass;
		this.chPositionSemester = chPositionSemester;
		this.chPositionJob = chPositionJob;
		this.chPositionPolface = chPositionPolface;
		this.chPositionMaketime = chPositionMaketime;
		this.chPositionAgent = chPositionAgent;
	}
	@Override
	public String toString() {
		return "ChPositionJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chPisitionTime=" + chPisitionTime
				+ ", chPositionClass=" + chPositionClass
				+ ", chPositionSemester=" + chPositionSemester
				+ ", chPositionJob=" + chPositionJob + ", chPositionPolface="
				+ chPositionPolface + ", chPositionMaketime="
				+ chPositionMaketime + ", chPositionAgent=" + chPositionAgent
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChScroId() {
		return chScroId;
	}
	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}
	public String getChScroSchroll() {
		return chScroSchroll;
	}
	public void setChScroSchroll(String chScroSchroll) {
		this.chScroSchroll = chScroSchroll;
	}
	public String getChScroName() {
		return chScroName;
	}
	public void setChScroName(String chScroName) {
		this.chScroName = chScroName;
	}
	public String getChPisitionTime() {
		return chPisitionTime;
	}
	public void setChPisitionTime(String chPisitionTime) {
		this.chPisitionTime = chPisitionTime;
	}
	public String getChPositionClass() {
		return chPositionClass;
	}
	public void setChPositionClass(String chPositionClass) {
		this.chPositionClass = chPositionClass;
	}
	public String getChPositionSemester() {
		return chPositionSemester;
	}
	public void setChPositionSemester(String chPositionSemester) {
		this.chPositionSemester = chPositionSemester;
	}
	public String getChPositionJob() {
		return chPositionJob;
	}
	public void setChPositionJob(String chPositionJob) {
		this.chPositionJob = chPositionJob;
	}
	public String getChPositionPolface() {
		return chPositionPolface;
	}
	public void setChPositionPolface(String chPositionPolface) {
		this.chPositionPolface = chPositionPolface;
	}
	public String getChPositionMaketime() {
		return chPositionMaketime;
	}
	public void setChPositionMaketime(String chPositionMaketime) {
		this.chPositionMaketime = chPositionMaketime;
	}
	public String getChPositionAgent() {
		return chPositionAgent;
	}
	public void setChPositionAgent(String chPositionAgent) {
		this.chPositionAgent = chPositionAgent;
	}


}