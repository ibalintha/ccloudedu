package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChEthnic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_ethnic")
public class ChEthnic extends IDEntity  implements java.io.Serializable {

	// Fields

	private String chEthnCode;
	private String chEthnName;
	private String chEthnPiny;
	private String chEthnDesc;

	// Constructors

	/** default constructor */
	public ChEthnic() {
	}


	/** full constructor */
	public ChEthnic(String chEthnCode, String chEthnName,
			String chEthnPiny, String chEthnDesc) {
		this.chEthnCode = chEthnCode;
		this.chEthnName = chEthnName;
		this.chEthnPiny = chEthnPiny;
		this.chEthnDesc = chEthnDesc;
	}

	// Property accessors

	@Column(name = "ch_ethn_code", length = 20)
	public String getChEthnCode() {
		return this.chEthnCode;
	}

	public void setChEthnCode(String chEthnCode) {
		this.chEthnCode = chEthnCode;
	}

	@Column(name = "ch_ethn_name", length = 20)
	public String getChEthnName() {
		return this.chEthnName;
	}

	public void setChEthnName(String chEthnName) {
		this.chEthnName = chEthnName;
	}

	@Column(name = "ch_ethn_piny", length = 20)
	public String getChEthnPiny() {
		return this.chEthnPiny;
	}

	public void setChEthnPiny(String chEthnPiny) {
		this.chEthnPiny = chEthnPiny;
	}

	@Column(name = "ch_ethn_desc", length = 100)
	public String getChEthnDesc() {
		return this.chEthnDesc;
	}

	public void setChEthnDesc(String chEthnDesc) {
		this.chEthnDesc = chEthnDesc;
	}

}