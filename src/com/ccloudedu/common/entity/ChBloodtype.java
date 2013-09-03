package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChBloodtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_bloodtype")
public class ChBloodtype extends IDEntity implements java.io.Serializable {

	// Fields

	private String chBdtpCode;
	private String chBdtpName;
	private String chBdtpPiny;
	private String chBdtpDesc;

	// Constructors

	/** default constructor */
	public ChBloodtype() {
	}


	/** full constructor */
	public ChBloodtype(String chBdtpCode, String chBdtpName,
			String chBdtpPiny, String chBdtpDesc) {
		this.chBdtpCode = chBdtpCode;
		this.chBdtpName = chBdtpName;
		this.chBdtpPiny = chBdtpPiny;
		this.chBdtpDesc = chBdtpDesc;
	}

	// Property accessors

	@Column(name = "ch_bdtp_code", length = 20)
	public String getChBdtpCode() {
		return this.chBdtpCode;
	}

	public void setChBdtpCode(String chBdtpCode) {
		this.chBdtpCode = chBdtpCode;
	}

	@Column(name = "ch_bdtp_name", length = 50)
	public String getChBdtpName() {
		return this.chBdtpName;
	}

	public void setChBdtpName(String chBdtpName) {
		this.chBdtpName = chBdtpName;
	}

	@Column(name = "ch_bdtp_piny", length = 20)
	public String getChBdtpPiny() {
		return this.chBdtpPiny;
	}

	public void setChBdtpPiny(String chBdtpPiny) {
		this.chBdtpPiny = chBdtpPiny;
	}

	@Column(name = "ch_bdtp_desc", length = 100)
	public String getChBdtpDesc() {
		return this.chBdtpDesc;
	}

	public void setChBdtpDesc(String chBdtpDesc) {
		this.chBdtpDesc = chBdtpDesc;
	}

}