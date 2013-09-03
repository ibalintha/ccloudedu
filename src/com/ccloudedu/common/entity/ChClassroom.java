package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChClassroom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_classroom")
public class ChClassroom implements java.io.Serializable {

	// Fields

	private String id;
	private String chClrmCode;
	private String chClrmName;
	private Integer chClrmNums;
	private String chClrmBuild;
	private String chClrmFalg;
	private Integer chClrmClanum;
	private Integer chClrmExamnum;
	private Integer chPartId;
	private Integer chCampId;
	private String chClrmShowflag;
	private String chClrmDesc;
	private String chClrmMemo;

	// Constructors

	/** default constructor */
	public ChClassroom() {
	}

	/** minimal constructor */
	public ChClassroom(String id) {
		this.id = id;
	}

	/** full constructor */
	public ChClassroom(String id, String chClrmCode, String chClrmName,
			Integer chClrmNums, String chClrmBuild, String chClrmFalg,
			Integer chClrmClanum, Integer chClrmExamnum, Integer chPartId,
			Integer chCampId, String chClrmShowflag, String chClrmDesc,
			String chClrmMemo) {
		this.id = id;
		this.chClrmCode = chClrmCode;
		this.chClrmName = chClrmName;
		this.chClrmNums = chClrmNums;
		this.chClrmBuild = chClrmBuild;
		this.chClrmFalg = chClrmFalg;
		this.chClrmClanum = chClrmClanum;
		this.chClrmExamnum = chClrmExamnum;
		this.chPartId = chPartId;
		this.chCampId = chCampId;
		this.chClrmShowflag = chClrmShowflag;
		this.chClrmDesc = chClrmDesc;
		this.chClrmMemo = chClrmMemo;
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

	@Column(name = "ch_clrm_code", length = 20)
	public String getChClrmCode() {
		return this.chClrmCode;
	}

	public void setChClrmCode(String chClrmCode) {
		this.chClrmCode = chClrmCode;
	}

	@Column(name = "ch_clrm_name", length = 50)
	public String getChClrmName() {
		return this.chClrmName;
	}

	public void setChClrmName(String chClrmName) {
		this.chClrmName = chClrmName;
	}

	@Column(name = "ch_clrm_nums")
	public Integer getChClrmNums() {
		return this.chClrmNums;
	}

	public void setChClrmNums(Integer chClrmNums) {
		this.chClrmNums = chClrmNums;
	}

	@Column(name = "ch_clrm_build", length = 20)
	public String getChClrmBuild() {
		return this.chClrmBuild;
	}

	public void setChClrmBuild(String chClrmBuild) {
		this.chClrmBuild = chClrmBuild;
	}

	@Column(name = "ch_clrm_falg", length = 1)
	public String getChClrmFalg() {
		return this.chClrmFalg;
	}

	public void setChClrmFalg(String chClrmFalg) {
		this.chClrmFalg = chClrmFalg;
	}

	@Column(name = "ch_clrm_clanum")
	public Integer getChClrmClanum() {
		return this.chClrmClanum;
	}

	public void setChClrmClanum(Integer chClrmClanum) {
		this.chClrmClanum = chClrmClanum;
	}

	@Column(name = "ch_clrm_examnum")
	public Integer getChClrmExamnum() {
		return this.chClrmExamnum;
	}

	public void setChClrmExamnum(Integer chClrmExamnum) {
		this.chClrmExamnum = chClrmExamnum;
	}

	@Column(name = "ch_part_id")
	public Integer getChPartId() {
		return this.chPartId;
	}

	public void setChPartId(Integer chPartId) {
		this.chPartId = chPartId;
	}

	@Column(name = "ch_camp_id")
	public Integer getChCampId() {
		return this.chCampId;
	}

	public void setChCampId(Integer chCampId) {
		this.chCampId = chCampId;
	}

	@Column(name = "ch_clrm_showflag", length = 1)
	public String getChClrmShowflag() {
		return this.chClrmShowflag;
	}

	public void setChClrmShowflag(String chClrmShowflag) {
		this.chClrmShowflag = chClrmShowflag;
	}

	@Column(name = "ch_clrm_desc", length = 100)
	public String getChClrmDesc() {
		return this.chClrmDesc;
	}

	public void setChClrmDesc(String chClrmDesc) {
		this.chClrmDesc = chClrmDesc;
	}

	@Column(name = "ch_clrm_memo", length = 100)
	public String getChClrmMemo() {
		return this.chClrmMemo;
	}

	public void setChClrmMemo(String chClrmMemo) {
		this.chClrmMemo = chClrmMemo;
	}

}