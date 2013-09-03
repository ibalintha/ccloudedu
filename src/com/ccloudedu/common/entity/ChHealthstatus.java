package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChHealthstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_healthstatus")
public class ChHealthstatus extends IDEntity implements java.io.Serializable {

	// Fields

	private String chHestCode;
	private String chHestName;
	private String chHestDesc;

	// Constructors

	/** default constructor */
	public ChHealthstatus() {
	}


	/** full constructor */
	public ChHealthstatus( String chHestCode, String chHestName,
			String chHestDesc) {
		this.chHestCode = chHestCode;
		this.chHestName = chHestName;
		this.chHestDesc = chHestDesc;
	}

	// Property accessors

	@Column(name = "ch_hest_code", length = 20)
	public String getChHestCode() {
		return this.chHestCode;
	}

	public void setChHestCode(String chHestCode) {
		this.chHestCode = chHestCode;
	}

	@Column(name = "ch_hest_name", length = 50)
	public String getChHestName() {
		return this.chHestName;
	}

	public void setChHestName(String chHestName) {
		this.chHestName = chHestName;
	}

	@Column(name = "ch_hest_desc", length = 100)
	public String getChHestDesc() {
		return this.chHestDesc;
	}

	public void setChHestDesc(String chHestDesc) {
		this.chHestDesc = chHestDesc;
	}

}