package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChPartition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_partition")
public class ChPartition implements java.io.Serializable {

	// Fields

	private String id;
	private String chPartCode;
	private String chPartName;
	private String chPartFlag;
	private String chPartDesc;
	private String chPartShowflag;
	private String chPartMemo;

	// Constructors

	/** default constructor */
	public ChPartition() {
	}

	/** minimal constructor */
	public ChPartition(String id) {
		this.id = id;
	}

	/** full constructor */
	public ChPartition(String id, String chPartCode, String chPartName,
			String chPartFlag, String chPartDesc, String chPartShowflag,
			String chPartMemo) {
		this.id = id;
		this.chPartCode = chPartCode;
		this.chPartName = chPartName;
		this.chPartFlag = chPartFlag;
		this.chPartDesc = chPartDesc;
		this.chPartShowflag = chPartShowflag;
		this.chPartMemo = chPartMemo;
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

	@Column(name = "ch_part_code", length = 20)
	public String getChPartCode() {
		return this.chPartCode;
	}

	public void setChPartCode(String chPartCode) {
		this.chPartCode = chPartCode;
	}

	@Column(name = "ch_part_name", length = 50)
	public String getChPartName() {
		return this.chPartName;
	}

	public void setChPartName(String chPartName) {
		this.chPartName = chPartName;
	}

	@Column(name = "ch_part_flag", length = 1)
	public String getChPartFlag() {
		return this.chPartFlag;
	}

	public void setChPartFlag(String chPartFlag) {
		this.chPartFlag = chPartFlag;
	}

	@Column(name = "ch_part_desc", length = 100)
	public String getChPartDesc() {
		return this.chPartDesc;
	}

	public void setChPartDesc(String chPartDesc) {
		this.chPartDesc = chPartDesc;
	}

	@Column(name = "ch_part_showflag", length = 1)
	public String getChPartShowflag() {
		return this.chPartShowflag;
	}

	public void setChPartShowflag(String chPartShowflag) {
		this.chPartShowflag = chPartShowflag;
	}

	@Column(name = "ch_part_memo", length = 100)
	public String getChPartMemo() {
		return this.chPartMemo;
	}

	public void setChPartMemo(String chPartMemo) {
		this.chPartMemo = chPartMemo;
	}

}