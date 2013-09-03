package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChOtherInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_otherInfo")
public class ChOtherInfo extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chScroId;
	private String chOtherInfoTimespan;
	private String chOtherInfoSemester;
	private String chOtherInfoCarNum;
	private String chOtherInfoExtend;
	private String chOtherInfoImprove;
	private String chOtherInfoSport;
	private String chOtherInfoArtSchool;
	private String chOtherInfoInterest;//ch_otherInfo_interest
	private String chOtherInfoOthers;//ch_otherInfo_others

	// Constructors

	/** default constructor */
	public ChOtherInfo() {
	}
	public ChOtherInfo(String chScroId, String chOtherInfoTimespan,
			String chOtherInfoSemester, String chOtherInfoCarNum,
			String chOtherInfoExtend, String chOtherInfoImprove,
			String chOtherInfoSport, String chOtherInfoArtSchool,
			String chOtherInfoInterest, String chOtherInfoOthers) {
		super();
		this.chScroId = chScroId;
		this.chOtherInfoTimespan = chOtherInfoTimespan;
		this.chOtherInfoSemester = chOtherInfoSemester;
		this.chOtherInfoCarNum = chOtherInfoCarNum;
		this.chOtherInfoExtend = chOtherInfoExtend;
		this.chOtherInfoImprove = chOtherInfoImprove;
		this.chOtherInfoSport = chOtherInfoSport;
		this.chOtherInfoArtSchool = chOtherInfoArtSchool;
		this.chOtherInfoInterest = chOtherInfoInterest;
		this.chOtherInfoOthers = chOtherInfoOthers;
	}
	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_otherInfo_timespan", nullable = false, length = 20)
	public String getChOtherInfoTimespan() {
		return this.chOtherInfoTimespan;
	}

	public void setChOtherInfoTimespan(String chOtherInfoTimespan) {
		this.chOtherInfoTimespan = chOtherInfoTimespan;
	}

	@Column(name = "ch_otherInfo_semester", nullable = false, length = 20)
	public String getChOtherInfoSemester() {
		return this.chOtherInfoSemester;
	}

	public void setChOtherInfoSemester(String chOtherInfoSemester) {
		this.chOtherInfoSemester = chOtherInfoSemester;
	}

	@Column(name = "ch_otherInfo_carNum", nullable = false, length = 10)
	public String getChOtherInfoCarNum() {
		return this.chOtherInfoCarNum;
	}

	public void setChOtherInfoCarNum(String chOtherInfoCarNum) {
		this.chOtherInfoCarNum = chOtherInfoCarNum;
	}

	@Column(name = "ch_otherInfo_extend", nullable = false, length = 10)
	public String getChOtherInfoExtend() {
		return this.chOtherInfoExtend;
	}

	public void setChOtherInfoExtend(String chOtherInfoExtend) {
		this.chOtherInfoExtend = chOtherInfoExtend;
	}

	@Column(name = "ch_otherInfo_improve", nullable = false, length = 10)
	public String getChOtherInfoImprove() {
		return this.chOtherInfoImprove;
	}

	public void setChOtherInfoImprove(String chOtherInfoImprove) {
		this.chOtherInfoImprove = chOtherInfoImprove;
	}

	@Column(name = "ch_otherInfo_sport", nullable = false, length = 10)
	public String getChOtherInfoSport() {
		return this.chOtherInfoSport;
	}

	public void setChOtherInfoSport(String chOtherInfoSport) {
		this.chOtherInfoSport = chOtherInfoSport;
	}

	@Column(name = "ch_otherInfo_artSchool", nullable = false, length = 50)
	public String getChOtherInfoArtSchool() {
		return this.chOtherInfoArtSchool;
	}

	public void setChOtherInfoArtSchool(String chOtherInfoArtSchool) {
		this.chOtherInfoArtSchool = chOtherInfoArtSchool;
	}
	
	@Column(name = "ch_otherInfo_interest", nullable = true, length = 100)
	public String getChOtherInfoInterest() {
		return chOtherInfoInterest;
	}
	public void setChOtherInfoInterest(String chOtherInfoInterest) {
		this.chOtherInfoInterest = chOtherInfoInterest;
	}
	
	@Column(name = "ch_otherInfo_others", nullable = true, length = 100)
	public String getChOtherInfoOthers() {
		return chOtherInfoOthers;
	}
	public void setChOtherInfoOthers(String chOtherInfoOthers) {
		this.chOtherInfoOthers = chOtherInfoOthers;
	}

}