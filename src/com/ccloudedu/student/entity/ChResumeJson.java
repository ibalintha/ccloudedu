package com.ccloudedu.student.entity;

/**
 * 学籍管理中的简历信息，用来向前台发送json串时使用
 * @author Pescadito
 * 2013-07-31 11:22
 */
public class ChResumeJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chResumeSchool;
	private String chResumeTime;
	private String chResumeBeginTime;
	private String chResumeEndTime;
	private String chResumeCertifier;
	private String chResumeSemester;//ch_resume_semester
	private String chResumeMemo;//ch_resume_memo
	
	public ChResumeJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChResumeJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chResumeSchool, String chResumeTime,
			String chResumeBeginTime, String chResumeEndTime,
			String chResumeCertifier, String chResumeSemester,
			String chResumeMemo) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chResumeSchool = chResumeSchool;
		this.chResumeTime = chResumeTime;
		this.chResumeBeginTime = chResumeBeginTime;
		this.chResumeEndTime = chResumeEndTime;
		this.chResumeCertifier = chResumeCertifier;
		this.chResumeSemester = chResumeSemester;
		this.chResumeMemo = chResumeMemo;
	}
	@Override
	public String toString() {
		return "ChResumeJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chResumeSchool=" + chResumeSchool
				+ ", chResumeTime=" + chResumeTime + ", chResumeBeginTime="
				+ chResumeBeginTime + ", chResumeEndTime=" + chResumeEndTime
				+ ", chResumeCertifier=" + chResumeCertifier
				+ ", chResumeSemester=" + chResumeSemester + ", chResumeMemo="
				+ chResumeMemo + "]";
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

	public String getChResumeSchool() {
		return chResumeSchool;
	}

	public void setChResumeSchool(String chResumeSchool) {
		this.chResumeSchool = chResumeSchool;
	}

	public String getChResumeTime() {
		return chResumeTime;
	}

	public void setChResumeTime(String chResumeTime) {
		this.chResumeTime = chResumeTime;
	}

	public String getChResumeBeginTime() {
		return chResumeBeginTime;
	}

	public void setChResumeBeginTime(String chResumeBeginTime) {
		this.chResumeBeginTime = chResumeBeginTime;
	}

	public String getChResumeEndTime() {
		return chResumeEndTime;
	}

	public void setChResumeEndTime(String chResumeEndTime) {
		this.chResumeEndTime = chResumeEndTime;
	}

	public String getChResumeCertifier() {
		return chResumeCertifier;
	}

	public void setChResumeCertifier(String chResumeCertifier) {
		this.chResumeCertifier = chResumeCertifier;
	}
	public String getChResumeSemester() {
		return chResumeSemester;
	}
	public void setChResumeSemester(String chResumeSemester) {
		this.chResumeSemester = chResumeSemester;
	}
	public String getChResumeMemo() {
		return chResumeMemo;
	}
	public void setChResumeMemo(String chResumeMemo) {
		this.chResumeMemo = chResumeMemo;
	}

}