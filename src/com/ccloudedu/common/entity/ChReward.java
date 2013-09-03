package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChReward entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_reward")
public class ChReward extends IDEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String chScroId;
	private String chRewardTimespan;
	private String chRewardSemester;
	private String chRewardPunishment;
	private String chRewardOffice;
	private String chRewardName;
	private String chRewardCertificate;
	private String chRewardTime;
	private String chRewardLevel;
	private String chRewardReason;
	private String chRewardInfo;
	private String chRewardWay;
	private String chRewardMemo;


	public ChReward() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChReward(String chScroId, String chRewardTimespan,
			String chRewardSemester, String chRewardPunishment,
			String chRewardOffice, String chRewardName,
			String chRewardCertificate, String chRewardTime,
			String chRewardLevel, String chRewardReason, String chRewardInfo,
			String chRewardWay, String chRewardMemo) {
		super();
		this.chScroId = chScroId;
		this.chRewardTimespan = chRewardTimespan;
		this.chRewardSemester = chRewardSemester;
		this.chRewardPunishment = chRewardPunishment;
		this.chRewardOffice = chRewardOffice;
		this.chRewardName = chRewardName;
		this.chRewardCertificate = chRewardCertificate;
		this.chRewardTime = chRewardTime;
		this.chRewardLevel = chRewardLevel;
		this.chRewardReason = chRewardReason;
		this.chRewardInfo = chRewardInfo;
		this.chRewardWay = chRewardWay;
		this.chRewardMemo = chRewardMemo;
	}

	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_reward_timespan", nullable = false, length = 50)
	public String getChRewardTimespan() {
		return this.chRewardTimespan;
	}

	public void setChRewardTimespan(String chRewardTimespan) {
		this.chRewardTimespan = chRewardTimespan;
	}

	@Column(name = "ch_reward_semester", nullable = false, length = 50)
	public String getChRewardSemester() {
		return this.chRewardSemester;
	}

	public void setChRewardSemester(String chRewardSemester) {
		this.chRewardSemester = chRewardSemester;
	}

	@Column(name = "ch_reward_punishment", nullable = false, length = 10)
	public String getChRewardPunishment() {
		return this.chRewardPunishment;
	}

	public void setChRewardPunishment(String chRewardPunishment) {
		this.chRewardPunishment = chRewardPunishment;
	}

	@Column(name = "ch_reward_office", length = 50)
	public String getChRewardOffice() {
		return this.chRewardOffice;
	}

	public void setChRewardOffice(String chRewardOffice) {
		this.chRewardOffice = chRewardOffice;
	}

	@Column(name = "ch_reward_name", length = 50)
	public String getChRewardName() {
		return this.chRewardName;
	}

	public void setChRewardName(String chRewardName) {
		this.chRewardName = chRewardName;
	}

	@Column(name = "ch_reward_certificate", length = 500)
	public String getChRewardCertificate() {
		return this.chRewardCertificate;
	}

	public void setChRewardCertificate(String chRewardCertificate) {
		this.chRewardCertificate = chRewardCertificate;
	}

	@Column(name = "ch_reward_time", length = 20)
	public String getChRewardTime() {
		return this.chRewardTime;
	}

	public void setChRewardTime(String chRewardTime) {
		this.chRewardTime = chRewardTime;
	}

	@Column(name = "ch_reward_level", length = 20)
	public String getChRewardLevel() {
		return this.chRewardLevel;
	}

	public void setChRewardLevel(String chRewardLevel) {
		this.chRewardLevel = chRewardLevel;
	}

	@Column(name = "ch_reward_reason", length = 50)
	public String getChRewardReason() {
		return this.chRewardReason;
	}

	public void setChRewardReason(String chRewardReason) {
		this.chRewardReason = chRewardReason;
	}

	@Column(name = "ch_reward_info", length = 50)
	public String getChRewardInfo() {
		return this.chRewardInfo;
	}

	public void setChRewardInfo(String chRewardInfo) {
		this.chRewardInfo = chRewardInfo;
	}

	@Column(name = "ch_reward_way", length = 50)
	public String getChRewardWay() {
		return this.chRewardWay;
	}

	public void setChRewardWay(String chRewardWay) {
		this.chRewardWay = chRewardWay;
	}

	@Column(name = "ch_reward_memo", length = 100)
	public String getChRewardMemo() {
		return this.chRewardMemo;
	}

	public void setChRewardMemo(String chRewardMemo) {
		this.chRewardMemo = chRewardMemo;
	}

}