package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChSemester entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_semester")
public class ChSemester implements java.io.Serializable {

	// Fields

	private String id;
	private String chSemeCode;
	private String chSemeDesc;
	private String chSemeBegtime;
	private String chSemeEndtime;
	private String chSemeCurseme;
	private String chSemeShowflag;
	private Integer chScyeId;
	private String chSemeShowseme;
	private String chSemeMemo;

	// Constructors

	/** default constructor */
	public ChSemester() {
	}

	/** minimal constructor */
	public ChSemester(String id) {
		this.id = id;
	}

	/** full constructor */
	public ChSemester(String id, String chSemeCode, String chSemeDesc,
			String chSemeBegtime, String chSemeEndtime, String chSemeCurseme,
			String chSemeShowflag, Integer chScyeId, String chSemeShowseme,
			String chSemeMemo) {
		this.id = id;
		this.chSemeCode = chSemeCode;
		this.chSemeDesc = chSemeDesc;
		this.chSemeBegtime = chSemeBegtime;
		this.chSemeEndtime = chSemeEndtime;
		this.chSemeCurseme = chSemeCurseme;
		this.chSemeShowflag = chSemeShowflag;
		this.chScyeId = chScyeId;
		this.chSemeShowseme = chSemeShowseme;
		this.chSemeMemo = chSemeMemo;
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

	@Column(name = "ch_seme_code", length = 20)
	public String getChSemeCode() {
		return this.chSemeCode;
	}

	public void setChSemeCode(String chSemeCode) {
		this.chSemeCode = chSemeCode;
	}

	@Column(name = "ch_seme_desc", length = 100)
	public String getChSemeDesc() {
		return this.chSemeDesc;
	}

	public void setChSemeDesc(String chSemeDesc) {
		this.chSemeDesc = chSemeDesc;
	}

	@Column(name = "ch_seme_begtime", length = 20)
	public String getChSemeBegtime() {
		return this.chSemeBegtime;
	}

	public void setChSemeBegtime(String chSemeBegtime) {
		this.chSemeBegtime = chSemeBegtime;
	}

	@Column(name = "ch_seme_endtime", length = 20)
	public String getChSemeEndtime() {
		return this.chSemeEndtime;
	}

	public void setChSemeEndtime(String chSemeEndtime) {
		this.chSemeEndtime = chSemeEndtime;
	}

	@Column(name = "ch_seme_curseme", length = 1)
	public String getChSemeCurseme() {
		return this.chSemeCurseme;
	}

	public void setChSemeCurseme(String chSemeCurseme) {
		this.chSemeCurseme = chSemeCurseme;
	}

	@Column(name = "ch_seme_showflag", length = 1)
	public String getChSemeShowflag() {
		return this.chSemeShowflag;
	}

	public void setChSemeShowflag(String chSemeShowflag) {
		this.chSemeShowflag = chSemeShowflag;
	}

	@Column(name = "ch_scye_id")
	public Integer getChScyeId() {
		return this.chScyeId;
	}

	public void setChScyeId(Integer chScyeId) {
		this.chScyeId = chScyeId;
	}

	@Column(name = "ch_seme_showseme", length = 1)
	public String getChSemeShowseme() {
		return this.chSemeShowseme;
	}

	public void setChSemeShowseme(String chSemeShowseme) {
		this.chSemeShowseme = chSemeShowseme;
	}

	@Column(name = "ch_seme_memo", length = 100)
	public String getChSemeMemo() {
		return this.chSemeMemo;
	}

	public void setChSemeMemo(String chSemeMemo) {
		this.chSemeMemo = chSemeMemo;
	}

}