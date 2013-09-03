package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChSchoolcal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_schoolcal")
public class ChSchoolcal implements java.io.Serializable {

	// Fields

	private String id;
	private Integer chSemeId;
	private String chScclDate;
	private String chScclDesc;

	// Constructors

	/** default constructor */
	public ChSchoolcal() {
	}

	/** minimal constructor */
	public ChSchoolcal(String id) {
		this.id = id;
	}

	/** full constructor */
	public ChSchoolcal(String id, Integer chSemeId, String chScclDate,
			String chScclDesc) {
		this.id = id;
		this.chSemeId = chSemeId;
		this.chScclDate = chScclDate;
		this.chScclDesc = chScclDesc;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ch_seme_id")
	public Integer getChSemeId() {
		return this.chSemeId;
	}

	public void setChSemeId(Integer chSemeId) {
		this.chSemeId = chSemeId;
	}

	@Column(name = "ch_sccl_date", length = 20)
	public String getChScclDate() {
		return this.chScclDate;
	}

	public void setChScclDate(String chScclDate) {
		this.chScclDate = chScclDate;
	}

	@Column(name = "ch_sccl_desc", length = 100)
	public String getChScclDesc() {
		return this.chScclDesc;
	}

	public void setChScclDesc(String chScclDesc) {
		this.chScclDesc = chScclDesc;
	}

}