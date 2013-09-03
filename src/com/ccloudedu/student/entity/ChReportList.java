package com.ccloudedu.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChEthnic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_reportList_tb")
public class ChReportList extends IDEntity  implements java.io.Serializable {

	// Fields

	private String chReportCode;
	private String chReportName;
	private String chReportPiny;
	private String chReportDesc;

	// Constructors

	/** default constructor */
	public ChReportList() {
	}


	/** full constructor */
	public ChReportList(String chReportCode, String chReportName,
			String chReportPiny, String chReportDesc) {
		this.chReportCode = chReportCode;
		this.chReportName = chReportName;
		this.chReportPiny = chReportPiny;
		this.chReportDesc = chReportDesc;
	}

	// Property accessors

	@Column(name = "ch_report_code", length = 20)
	public String getChReportCode() {
		return this.chReportCode;
	}

	public void setChReportCode(String chReportCode) {
		this.chReportCode = chReportCode;
	}

	@Column(name = "ch_report_name", length = 20)
	public String getChReportName() {
		return this.chReportName;
	}

	public void setChReportName(String chReportName) {
		this.chReportName = chReportName;
	}

	@Column(name = "ch_report_piny", length = 20)
	public String getChReportPiny() {
		return this.chReportPiny;
	}

	public void setChReportPiny(String chReportPiny) {
		this.chReportPiny = chReportPiny;
	}

	@Column(name = "ch_report_desc", length = 100)
	public String getChReportDesc() {
		return this.chReportDesc;
	}

	public void setChReportDesc(String chReportDesc) {
		this.chReportDesc = chReportDesc;
	}

}