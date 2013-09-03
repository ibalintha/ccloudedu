package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChSpecial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_special")
public class ChSpecial extends IDEntity implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chScroId;
	private String chSpecialTimespan;
	private String chSpecialSemester;
	private String chSpecialTime;
	private String chSpecialReason;
	private String chSpecialComment;
	private String chSpecialLevel;//ch_special_level
	private String chSpecialOffice;//ch_special_office
	private String chSpecialContent;//ch_special_content
	private String chSpecialCertificate;//ch_special_certificate
	
	// Constructors

	public ChSpecial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChSpecial(String chScroId, String chSpecialTimespan,
			String chSpecialSemester, String chSpecialTime,
			String chSpecialReason, String chSpecialComment,
			String chSpecialLevel, String chSpecialOffice,
			String chSpecialContent, String chSpecialCertificate) {
		super();
		this.chScroId = chScroId;
		this.chSpecialTimespan = chSpecialTimespan;
		this.chSpecialSemester = chSpecialSemester;
		this.chSpecialTime = chSpecialTime;
		this.chSpecialReason = chSpecialReason;
		this.chSpecialComment = chSpecialComment;
		this.chSpecialLevel = chSpecialLevel;
		this.chSpecialOffice = chSpecialOffice;
		this.chSpecialContent = chSpecialContent;
		this.chSpecialCertificate = chSpecialCertificate;
	}

	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_special_timespan", nullable = false, length = 50)
	public String getChSpecialTimespan() {
		return this.chSpecialTimespan;
	}

	public void setChSpecialTimespan(String chSpecialTimespan) {
		this.chSpecialTimespan = chSpecialTimespan;
	}

	@Column(name = "ch_special_semester", nullable = false, length = 20)
	public String getChSpecialSemester() {
		return this.chSpecialSemester;
	}

	public void setChSpecialSemester(String chSpecialSemester) {
		this.chSpecialSemester = chSpecialSemester;
	}

	@Column(name = "ch_special_time", nullable = false, length = 20)
	public String getChSpecialTime() {
		return this.chSpecialTime;
	}

	public void setChSpecialTime(String chSpecialTime) {
		this.chSpecialTime = chSpecialTime;
	}

	@Column(name = "ch_special_reason", nullable = false, length = 50)
	public String getChSpecialReason() {
		return this.chSpecialReason;
	}

	public void setChSpecialReason(String chSpecialReason) {
		this.chSpecialReason = chSpecialReason;
	}

	@Column(name = "ch_special_comment", length = 50)
	public String getChSpecialComment() {
		return this.chSpecialComment;
	}

	public void setChSpecialComment(String chSpecialComment) {
		this.chSpecialComment = chSpecialComment;
	}
	
	@Column(name = "ch_special_level", length = 50)
	public String getChSpecialLevel() {
		return chSpecialLevel;
	}
	public void setChSpecialLevel(String chSpecialLevel) {
		this.chSpecialLevel = chSpecialLevel;
	}
	
	@Column(name = "ch_special_office", length = 50)
	public String getChSpecialOffice() {
		return chSpecialOffice;
	}
	public void setChSpecialOffice(String chSpecialOffice) {
		this.chSpecialOffice = chSpecialOffice;
	}

	@Column(name = "ch_special_content", length = 50)
	public String getChSpecialContent() {
		return chSpecialContent;
	}
	public void setChSpecialContent(String chSpecialContent) {
		this.chSpecialContent = chSpecialContent;
	}
	
	@Column(name = "ch_special_certificate", length = 500)
	public String getChSpecialCertificate() {
		return chSpecialCertificate;
	}
	public void setChSpecialCertificate(String chSpecialCertificate) {
		this.chSpecialCertificate = chSpecialCertificate;
	}

}