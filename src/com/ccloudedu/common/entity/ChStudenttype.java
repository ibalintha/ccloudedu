package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChStudenttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_studenttype")
public class ChStudenttype extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	private String chSttpCode;
	private String chSttpName;
	private String chSttpDesc;

	// Constructors

	/** default constructor */
	public ChStudenttype() {
	}


	/** full constructor */
	public ChStudenttype(String chSttpCode, String chSttpName,
			String chSttpDesc) {
		this.chSttpCode = chSttpCode;
		this.chSttpName = chSttpName;
		this.chSttpDesc = chSttpDesc;
	}

	// Property accessors

	@Column(name = "ch_sttp_code", length = 20)
	public String getChSttpCode() {
		return this.chSttpCode;
	}

	public void setChSttpCode(String chSttpCode) {
		this.chSttpCode = chSttpCode;
	}

	@Column(name = "ch_sttp_name", length = 50)
	public String getChSttpName() {
		return this.chSttpName;
	}

	public void setChSttpName(String chSttpName) {
		this.chSttpName = chSttpName;
	}

	@Column(name = "ch_sttp_desc", length = 100)
	public String getChSttpDesc() {
		return this.chSttpDesc;
	}

	public void setChSttpDesc(String chSttpDesc) {
		this.chSttpDesc = chSttpDesc;
	}

}