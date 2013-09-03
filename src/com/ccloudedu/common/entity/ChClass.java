package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChClass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_class")
public class ChClass extends IDEntity implements java.io.Serializable {

	// Fields

	private String id;
	private Integer chCltpId;
	private String chClasCode;
	private String chClasName;
	private String chClasGrade;
	private Integer chClasNums;
	private String chClasFlag;
	private String chClasEngname;
	private Integer chCampId;
	private String chClasShowflag;
	private String chClasDesc;
	private String chClasMemo;

	// Constructors

	/** default constructor */
	public ChClass() {
	}

	/** minimal constructor */
	public ChClass(String id) {
		this.id = id;
	}

	/** full constructor */
	public ChClass(String id, Integer chCltpId, String chClasCode,
			String chClasName, String chClasGrade, Integer chClasNums,
			String chClasFlag, String chClasEngname, Integer chCampId,
			String chClasShowflag, String chClasDesc, String chClasMemo) {
		this.id = id;
		this.chCltpId = chCltpId;
		this.chClasCode = chClasCode;
		this.chClasName = chClasName;
		this.chClasGrade = chClasGrade;
		this.chClasNums = chClasNums;
		this.chClasFlag = chClasFlag;
		this.chClasEngname = chClasEngname;
		this.chCampId = chCampId;
		this.chClasShowflag = chClasShowflag;
		this.chClasDesc = chClasDesc;
		this.chClasMemo = chClasMemo;
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

	@Column(name = "ch_cltp_id")
	public Integer getChCltpId() {
		return this.chCltpId;
	}

	public void setChCltpId(Integer chCltpId) {
		this.chCltpId = chCltpId;
	}

	@Column(name = "ch_clas_code", length = 20)
	public String getChClasCode() {
		return this.chClasCode;
	}

	public void setChClasCode(String chClasCode) {
		this.chClasCode = chClasCode;
	}

	@Column(name = "ch_clas_name", length = 50)
	public String getChClasName() {
		return this.chClasName;
	}

	public void setChClasName(String chClasName) {
		this.chClasName = chClasName;
	}

	@Column(name = "ch_clas_grade", length = 20)
	public String getChClasGrade() {
		return this.chClasGrade;
	}

	public void setChClasGrade(String chClasGrade) {
		this.chClasGrade = chClasGrade;
	}

	@Column(name = "ch_clas_nums")
	public Integer getChClasNums() {
		return this.chClasNums;
	}

	public void setChClasNums(Integer chClasNums) {
		this.chClasNums = chClasNums;
	}

	@Column(name = "ch_clas_flag", length = 1)
	public String getChClasFlag() {
		return this.chClasFlag;
	}

	public void setChClasFlag(String chClasFlag) {
		this.chClasFlag = chClasFlag;
	}

	@Column(name = "ch_clas_engname", length = 20)
	public String getChClasEngname() {
		return this.chClasEngname;
	}

	public void setChClasEngname(String chClasEngname) {
		this.chClasEngname = chClasEngname;
	}

	@Column(name = "ch_camp_id")
	public Integer getChCampId() {
		return this.chCampId;
	}

	public void setChCampId(Integer chCampId) {
		this.chCampId = chCampId;
	}

	@Column(name = "ch_clas_showflag", length = 1)
	public String getChClasShowflag() {
		return this.chClasShowflag;
	}

	public void setChClasShowflag(String chClasShowflag) {
		this.chClasShowflag = chClasShowflag;
	}

	@Column(name = "ch_clas_desc", length = 100)
	public String getChClasDesc() {
		return this.chClasDesc;
	}

	public void setChClasDesc(String chClasDesc) {
		this.chClasDesc = chClasDesc;
	}

	@Column(name = "ch_clas_memo", length = 100)
	public String getChClasMemo() {
		return this.chClasMemo;
	}

	public void setChClasMemo(String chClasMemo) {
		this.chClasMemo = chClasMemo;
	}

}