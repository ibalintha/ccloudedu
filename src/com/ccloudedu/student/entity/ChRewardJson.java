package com.ccloudedu.student.entity;

/**
 * 学籍管理信息中的奖惩信息，用来向前台提交json串
 * @author Pescadito
 * 2013-07-31 11:24
 */
public class ChRewardJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chScroSchcode;//学号
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
	
	public ChRewardJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChRewardJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chScroSchcode, String chRewardTimespan,
			String chRewardSemester, String chRewardPunishment,
			String chRewardOffice, String chRewardName,
			String chRewardCertificate, String chRewardTime,
			String chRewardLevel, String chRewardReason, String chRewardInfo,
			String chRewardWay, String chRewardMemo) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chScroSchcode = chScroSchcode;
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

	@Override
	public String toString() {
		return "ChRewardJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chScroSchcode=" + chScroSchcode
				+ ", chRewardTimespan=" + chRewardTimespan
				+ ", chRewardSemester=" + chRewardSemester
				+ ", chRewardPunishment=" + chRewardPunishment
				+ ", chRewardOffice=" + chRewardOffice + ", chRewardName="
				+ chRewardName + ", chRewardCertificate=" + chRewardCertificate
				+ ", chRewardTime=" + chRewardTime + ", chRewardLevel="
				+ chRewardLevel + ", chRewardReason=" + chRewardReason
				+ ", chRewardInfo=" + chRewardInfo + ", chRewardWay="
				+ chRewardWay + ", chRewardMemo=" + chRewardMemo + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChScroId() {
		return chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	public String getChScroSchroll() {
		return chScroSchroll;
	}

	public void setChScroSchroll(String chScroSchroll) {
		this.chScroSchroll = chScroSchroll;
	}

	public String getChScroName() {
		return chScroName;
	}

	public void setChScroName(String chScroName) {
		this.chScroName = chScroName;
	}

	public String getChScroSchcode() {
		return chScroSchcode;
	}

	public void setChScroSchcode(String chScroSchcode) {
		this.chScroSchcode = chScroSchcode;
	}

	public String getChRewardTimespan() {
		return chRewardTimespan;
	}

	public void setChRewardTimespan(String chRewardTimespan) {
		this.chRewardTimespan = chRewardTimespan;
	}

	public String getChRewardSemester() {
		return chRewardSemester;
	}

	public void setChRewardSemester(String chRewardSemester) {
		this.chRewardSemester = chRewardSemester;
	}

	public String getChRewardPunishment() {
		return chRewardPunishment;
	}

	public void setChRewardPunishment(String chRewardPunishment) {
		this.chRewardPunishment = chRewardPunishment;
	}

	public String getChRewardOffice() {
		return chRewardOffice;
	}

	public void setChRewardOffice(String chRewardOffice) {
		this.chRewardOffice = chRewardOffice;
	}

	public String getChRewardName() {
		return chRewardName;
	}

	public void setChRewardName(String chRewardName) {
		this.chRewardName = chRewardName;
	}

	public String getChRewardCertificate() {
		return chRewardCertificate;
	}

	public void setChRewardCertificate(String chRewardCertificate) {
		this.chRewardCertificate = chRewardCertificate;
	}

	public String getChRewardTime() {
		return chRewardTime;
	}

	public void setChRewardTime(String chRewardTime) {
		this.chRewardTime = chRewardTime;
	}

	public String getChRewardLevel() {
		return chRewardLevel;
	}

	public void setChRewardLevel(String chRewardLevel) {
		this.chRewardLevel = chRewardLevel;
	}

	public String getChRewardReason() {
		return chRewardReason;
	}

	public void setChRewardReason(String chRewardReason) {
		this.chRewardReason = chRewardReason;
	}

	public String getChRewardInfo() {
		return chRewardInfo;
	}

	public void setChRewardInfo(String chRewardInfo) {
		this.chRewardInfo = chRewardInfo;
	}

	public String getChRewardWay() {
		return chRewardWay;
	}

	public void setChRewardWay(String chRewardWay) {
		this.chRewardWay = chRewardWay;
	}

	public String getChRewardMemo() {
		return chRewardMemo;
	}

	public void setChRewardMemo(String chRewardMemo) {
		this.chRewardMemo = chRewardMemo;
	}
	

}