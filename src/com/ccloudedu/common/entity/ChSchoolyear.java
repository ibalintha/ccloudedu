package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChSchoolyear entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_schoolyear")
public class ChSchoolyear extends IDEntity implements java.io.Serializable {

	// Fields

	//private String id;
	private String chScyeCode;
	private String chScyeYear;
	private String chScyeShowflag;
	private String chScyeMemo;

	// Constructors

	/** default constructor */
	public ChSchoolyear() {
	}



	/** full constructor */
	public ChSchoolyear( String chScyeCode, String chScyeYear,
			String chScyeShowflag, String chScyeMemo) {
	
		this.chScyeCode = chScyeCode;
		this.chScyeYear = chScyeYear;
		this.chScyeShowflag = chScyeShowflag;
		this.chScyeMemo = chScyeMemo;
	}

	// Property accessors


	@Column(name = "ch_scye_code", length = 20)
	public String getChScyeCode() {
		return this.chScyeCode;
	}

	public void setChScyeCode(String chScyeCode) {
		this.chScyeCode = chScyeCode;
	}

	@Column(name = "ch_scye_year", length = 50)
	public String getChScyeYear() {
		return this.chScyeYear;
	}

	public void setChScyeYear(String chScyeYear) {
		this.chScyeYear = chScyeYear;
	}

	@Column(name = "ch_scye_showflag", length = 1)
	public String getChScyeShowflag() {
		return this.chScyeShowflag;
	}

	public void setChScyeShowflag(String chScyeShowflag) {
		this.chScyeShowflag = chScyeShowflag;
	}

	@Column(name = "ch_scye_memo", length = 100)
	public String getChScyeMemo() {
		return this.chScyeMemo;
	}

	public void setChScyeMemo(String chScyeMemo) {
		this.chScyeMemo = chScyeMemo;
	}

}