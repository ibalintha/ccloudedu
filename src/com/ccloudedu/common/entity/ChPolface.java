package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChPolface entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_polface")
public class ChPolface extends IDEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chPlfaCode;
	private String chPlfaName;
	private String chPlfaDesc;

	// Constructors

	/** default constructor */
	public ChPolface() {
	}


	/** full constructor */
	public ChPolface(String chPlfaCode, String chPlfaName,
			String chPlfaDesc) {

		this.chPlfaCode = chPlfaCode;
		this.chPlfaName = chPlfaName;
		this.chPlfaDesc = chPlfaDesc;
	}

	// Property accessors


	@Column(name = "ch_plfa_code", length = 20)
	public String getChPlfaCode() {
		return this.chPlfaCode;
	}

	public void setChPlfaCode(String chPlfaCode) {
		this.chPlfaCode = chPlfaCode;
	}

	@Column(name = "ch_plfa_name", length = 50)
	public String getChPlfaName() {
		return this.chPlfaName;
	}

	public void setChPlfaName(String chPlfaName) {
		this.chPlfaName = chPlfaName;
	}

	@Column(name = "ch_plfa_desc", length = 100)
	public String getChPlfaDesc() {
		return this.chPlfaDesc;
	}

	public void setChPlfaDesc(String chPlfaDesc) {
		this.chPlfaDesc = chPlfaDesc;
	}

}