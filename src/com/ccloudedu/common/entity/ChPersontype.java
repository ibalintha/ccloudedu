package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChPersontype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_persontype")
public class ChPersontype extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String chPrtpCode;
	private String chPrtpName;
	private String chPrtpDesc;

	// Constructors

	/** default constructor */
	public ChPersontype() {
	}


	/** full constructor */
	public ChPersontype(String chPrtpCode, String chPrtpName,
			String chPrtpDesc) {
		this.chPrtpCode = chPrtpCode;
		this.chPrtpName = chPrtpName;
		this.chPrtpDesc = chPrtpDesc;
	}

	// Property accessors

	@Column(name = "ch_prtp_code", length = 20)
	public String getChPrtpCode() {
		return this.chPrtpCode;
	}

	public void setChPrtpCode(String chPrtpCode) {
		this.chPrtpCode = chPrtpCode;
	}

	@Column(name = "ch_prtp_name", length = 50)
	public String getChPrtpName() {
		return this.chPrtpName;
	}

	public void setChPrtpName(String chPrtpName) {
		this.chPrtpName = chPrtpName;
	}

	@Column(name = "ch_prtp_desc", length = 100)
	public String getChPrtpDesc() {
		return this.chPrtpDesc;
	}

	public void setChPrtpDesc(String chPrtpDesc) {
		this.chPrtpDesc = chPrtpDesc;
	}

}