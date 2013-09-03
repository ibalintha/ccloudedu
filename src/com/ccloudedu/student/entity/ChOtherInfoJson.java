package com.ccloudedu.student.entity;

/**
 * 学籍信息中的其他信息实体
 * @author Pescadito
 * 2013-07-31 11:16
 */
public class ChOtherInfoJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chOtherInfoTimespan;
	private String chOtherInfoSemester;
	private String chOtherInfoCarNum;
	private String chOtherInfoExtend;
	private String chOtherInfoImprove;
	private String chOtherInfoSport;
	private String chOtherInfoArtSchool;
	private String chOtherInfoInterest;//ch_otherInfo_interest
	private String chOtherInfoOthers;//ch_otherInfo_others
	
	public ChOtherInfoJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChOtherInfoJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chOtherInfoTimespan,
			String chOtherInfoSemester, String chOtherInfoCarNum,
			String chOtherInfoExtend, String chOtherInfoImprove,
			String chOtherInfoSport, String chOtherInfoArtSchool,
			String chOtherInfoInterest, String chOtherInfoOthers) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
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
	@Override
	public String toString() {
		return "ChOtherInfoJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chOtherInfoTimespan=" + chOtherInfoTimespan
				+ ", chOtherInfoSemester=" + chOtherInfoSemester
				+ ", chOtherInfoCarNum=" + chOtherInfoCarNum
				+ ", chOtherInfoExtend=" + chOtherInfoExtend
				+ ", chOtherInfoImprove=" + chOtherInfoImprove
				+ ", chOtherInfoSport=" + chOtherInfoSport
				+ ", chOtherInfoArtSchool=" + chOtherInfoArtSchool
				+ ", chOtherInfoInterest=" + chOtherInfoInterest
				+ ", chOtherInfoOthers=" + chOtherInfoOthers + "]";
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

	public String getChOtherInfoTimespan() {
		return chOtherInfoTimespan;
	}

	public void setChOtherInfoTimespan(String chOtherInfoTimespan) {
		this.chOtherInfoTimespan = chOtherInfoTimespan;
	}

	public String getChOtherInfoSemester() {
		return chOtherInfoSemester;
	}

	public void setChOtherInfoSemester(String chOtherInfoSemester) {
		this.chOtherInfoSemester = chOtherInfoSemester;
	}

	public String getChOtherInfoCarNum() {
		return chOtherInfoCarNum;
	}

	public void setChOtherInfoCarNum(String chOtherInfoCarNum) {
		this.chOtherInfoCarNum = chOtherInfoCarNum;
	}

	public String getChOtherInfoExtend() {
		return chOtherInfoExtend;
	}

	public void setChOtherInfoExtend(String chOtherInfoExtend) {
		this.chOtherInfoExtend = chOtherInfoExtend;
	}

	public String getChOtherInfoImprove() {
		return chOtherInfoImprove;
	}

	public void setChOtherInfoImprove(String chOtherInfoImprove) {
		this.chOtherInfoImprove = chOtherInfoImprove;
	}

	public String getChOtherInfoSport() {
		return chOtherInfoSport;
	}

	public void setChOtherInfoSport(String chOtherInfoSport) {
		this.chOtherInfoSport = chOtherInfoSport;
	}

	public String getChOtherInfoArtSchool() {
		return chOtherInfoArtSchool;
	}

	public void setChOtherInfoArtSchool(String chOtherInfoArtSchool) {
		this.chOtherInfoArtSchool = chOtherInfoArtSchool;
	}
	public String getChOtherInfoInterest() {
		return chOtherInfoInterest;
	}
	public void setChOtherInfoInterest(String chOtherInfoInterest) {
		this.chOtherInfoInterest = chOtherInfoInterest;
	}
	public String getChOtherInfoOthers() {
		return chOtherInfoOthers;
	}
	public void setChOtherInfoOthers(String chOtherInfoOthers) {
		this.chOtherInfoOthers = chOtherInfoOthers;
	}	
}