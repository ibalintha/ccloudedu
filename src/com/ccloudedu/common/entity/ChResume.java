package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChResume entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_resume")
public class ChResume extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chScroId;
	private String chResumeSchool;
	private String chResumeTime;
	private String chResumeBeginTime;
	private String chResumeEndTime;
	private String chResumeCertifier;	
	private String chResumeSemester;//ch_resume_semester
	private String chResumeMemo;//ch_resume_memo
		

	public ChResume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChResume(String chScroId, String chResumeSchool,
			String chResumeTime, String chResumeBeginTime,
			String chResumeEndTime, String chResumeCertifier,
			String chResumeSemester, String chResumeMemo) {
		super();
		this.chScroId = chScroId;
		this.chResumeSchool = chResumeSchool;
		this.chResumeTime = chResumeTime;
		this.chResumeBeginTime = chResumeBeginTime;
		this.chResumeEndTime = chResumeEndTime;
		this.chResumeCertifier = chResumeCertifier;
		this.chResumeSemester = chResumeSemester;
		this.chResumeMemo = chResumeMemo;
	}

	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_resume_school", nullable = false, length = 50)
	public String getChResumeSchool() {
		return this.chResumeSchool;
	}

	public void setChResumeSchool(String chResumeSchool) {
		this.chResumeSchool = chResumeSchool;
	}

	@Column(name = "ch_resume_time", nullable = false, length = 50)
	public String getChResumeTime() {
		return this.chResumeTime;
	}

	public void setChResumeTime(String chResumeTime) {
		this.chResumeTime = chResumeTime;
	}

	@Column(name = "ch_resume_beginTime", nullable = false, length = 20)
	public String getChResumeBeginTime() {
		return this.chResumeBeginTime;
	}

	public void setChResumeBeginTime(String chResumeBeginTime) {
		this.chResumeBeginTime = chResumeBeginTime;
	}

	@Column(name = "ch_resume_endTime", nullable = false, length = 20)
	public String getChResumeEndTime() {
		return this.chResumeEndTime;
	}

	public void setChResumeEndTime(String chResumeEndTime) {
		this.chResumeEndTime = chResumeEndTime;
	}

	@Column(name = "ch_resume_certifier", nullable = false, length = 50)
	public String getChResumeCertifier() {
		return this.chResumeCertifier;
	}

	public void setChResumeCertifier(String chResumeCertifier) {
		this.chResumeCertifier = chResumeCertifier;
	}

	@Column(name = "ch_resume_semester", nullable = false, length = 10)
	public String getChResumeSemester() {
		return chResumeSemester;
	}

	public void setChResumeSemester(String chResumeSemester) {
		this.chResumeSemester = chResumeSemester;
	}

	@Column(name = "ch_resume_memo", nullable = true, length = 200)
	public String getChResumeMemo() {
		return chResumeMemo;
	}

	public void setChResumeMemo(String chResumeMemo) {
		this.chResumeMemo = chResumeMemo;
	}

}