package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChForeign entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_foreign")
public class ChForeign extends IDEntity implements java.io.Serializable {

	// Fields

	private String chFognCode;
	private String chFognName;
	private String chFognDesc;

	// Constructors

	/** default constructor */
	public ChForeign() {
	}


	/** full constructor */
	public ChForeign( String chFognCode, String chFognName,
			String chFognDesc) {
		this.chFognCode = chFognCode;
		this.chFognName = chFognName;
		this.chFognDesc = chFognDesc;
	}

	// Property accessors

	@Column(name = "ch_fogn_code", length = 20)
	public String getChFognCode() {
		return this.chFognCode;
	}

	public void setChFognCode(String chFognCode) {
		this.chFognCode = chFognCode;
	}

	@Column(name = "ch_fogn_name", length = 50)
	public String getChFognName() {
		return this.chFognName;
	}

	public void setChFognName(String chFognName) {
		this.chFognName = chFognName;
	}

	@Column(name = "ch_fogn_desc", length = 100)
	public String getChFognDesc() {
		return this.chFognDesc;
	}

	public void setChFognDesc(String chFognDesc) {
		this.chFognDesc = chFognDesc;
	}

}