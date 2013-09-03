package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChClasstype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_classtype")
public class ChClasstype implements java.io.Serializable {

	// Fields

	private String id;
	private String chCltpCode;
	private String chCltpType;
	private String chCltpYear;
	private String chCltpShowflag;
	private String chCltpMemo;

	// Constructors

	/** default constructor */
	public ChClasstype() {
	}

	/** minimal constructor */
	public ChClasstype(String id) {
		this.id = id;
	}

	/** full constructor */
	public ChClasstype(String id, String chCltpCode, String chCltpType,
			String chCltpYear, String chCltpShowflag, String chCltpMemo) {
		this.id = id;
		this.chCltpCode = chCltpCode;
		this.chCltpType = chCltpType;
		this.chCltpYear = chCltpYear;
		this.chCltpShowflag = chCltpShowflag;
		this.chCltpMemo = chCltpMemo;
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

	@Column(name = "ch_cltp_code", length = 20)
	public String getChCltpCode() {
		return this.chCltpCode;
	}

	public void setChCltpCode(String chCltpCode) {
		this.chCltpCode = chCltpCode;
	}

	@Column(name = "ch_cltp_type", length = 20)
	public String getChCltpType() {
		return this.chCltpType;
	}

	public void setChCltpType(String chCltpType) {
		this.chCltpType = chCltpType;
	}

	@Column(name = "ch_cltp_year", length = 10)
	public String getChCltpYear() {
		return this.chCltpYear;
	}

	public void setChCltpYear(String chCltpYear) {
		this.chCltpYear = chCltpYear;
	}

	@Column(name = "ch_cltp_showflag", length = 1)
	public String getChCltpShowflag() {
		return this.chCltpShowflag;
	}

	public void setChCltpShowflag(String chCltpShowflag) {
		this.chCltpShowflag = chCltpShowflag;
	}

	@Column(name = "ch_cltp_memo", length = 100)
	public String getChCltpMemo() {
		return this.chCltpMemo;
	}

	public void setChCltpMemo(String chCltpMemo) {
		this.chCltpMemo = chCltpMemo;
	}

}