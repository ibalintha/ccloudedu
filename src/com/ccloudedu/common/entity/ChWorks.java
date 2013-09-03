package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChWorks entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_works")
public class ChWorks extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chScroId;
	private String chWorksTime;
	private String chWorksSemester;
	private String chWorksName;
	private String chWorksDealTime;
	private String chWorksContent;
	private String chWorksMemo;//ch_works_memo
	
	public ChWorks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChWorks(String chScroId, String chWorksTime, String chWorksSemester,
			String chWorksName, String chWorksDealTime, String chWorksContent,
			String chWorksMemo) {
		super();
		this.chScroId = chScroId;
		this.chWorksTime = chWorksTime;
		this.chWorksSemester = chWorksSemester;
		this.chWorksName = chWorksName;
		this.chWorksDealTime = chWorksDealTime;
		this.chWorksContent = chWorksContent;
		this.chWorksMemo = chWorksMemo;
	}

	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_works_time", nullable = false, length = 20)
	public String getChWorksTime() {
		return this.chWorksTime;
	}

	public void setChWorksTime(String chWorksTime) {
		this.chWorksTime = chWorksTime;
	}

	@Column(name = "ch_works_semester", nullable = false, length = 20)
	public String getChWorksSemester() {
		return this.chWorksSemester;
	}

	public void setChWorksSemester(String chWorksSemester) {
		this.chWorksSemester = chWorksSemester;
	}

	@Column(name = "ch_works_name", nullable = false, length = 50)
	public String getChWorksName() {
		return this.chWorksName;
	}

	public void setChWorksName(String chWorksName) {
		this.chWorksName = chWorksName;
	}

	@Column(name = "ch_works_dealTime", nullable = false, length = 20)
	public String getChWorksDealTime() {
		return this.chWorksDealTime;
	}

	public void setChWorksDealTime(String chWorksDealTime) {
		this.chWorksDealTime = chWorksDealTime;
	}

	@Column(name = "ch_works_content", nullable = false, length = 50)
	public String getChWorksContent() {
		return this.chWorksContent;
	}

	public void setChWorksContent(String chWorksContent) {
		this.chWorksContent = chWorksContent;
	}

	@Column(name = "ch_works_memo", nullable = true, length = 100)
	public String getChWorksMemo() {
		return chWorksMemo;
	}

	public void setChWorksMemo(String chWorksMemo) {
		this.chWorksMemo = chWorksMemo;
	}

}