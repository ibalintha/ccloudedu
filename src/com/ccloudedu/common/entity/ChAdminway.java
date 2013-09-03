package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChAdminway entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_adminway")
public class ChAdminway extends IDEntity implements java.io.Serializable {

	// Fields

	private String chAdwaCode;
	private String chAdwaName;
	private String chAdwaDesc;

	// Constructors

	/** default constructor */
	public ChAdminway() {
	}


	/** full constructor */
	public ChAdminway( String chAdwaCode, String chAdwaName,
			String chAdwaDesc) {
		this.chAdwaCode = chAdwaCode;
		this.chAdwaName = chAdwaName;
		this.chAdwaDesc = chAdwaDesc;
	}

	@Column(name = "ch_adwa_code", length = 20)
	public String getChAdwaCode() {
		return this.chAdwaCode;
	}

	public void setChAdwaCode(String chAdwaCode) {
		this.chAdwaCode = chAdwaCode;
	}

	@Column(name = "ch_adwa_name", length = 50)
	public String getChAdwaName() {
		return this.chAdwaName;
	}

	public void setChAdwaName(String chAdwaName) {
		this.chAdwaName = chAdwaName;
	}

	@Column(name = "ch_adwa_desc", length = 100)
	public String getChAdwaDesc() {
		return this.chAdwaDesc;
	}

	public void setChAdwaDesc(String chAdwaDesc) {
		this.chAdwaDesc = chAdwaDesc;
	}

}