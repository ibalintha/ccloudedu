package com.ccloudedu.student.entity;

public class ChHomeVisiteJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chHomeVisiteTimespan;
	private String chHomeVisiteSemester;
	private String chHomeVisiteTime;
	private String chHomeVisiteReason;
	
	public ChHomeVisiteJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChHomeVisiteJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chHomeVisiteTimespan,
			String chHomeVisiteSemester, String chHomeVisiteTime,
			String chHomeVisiteReason) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chHomeVisiteTimespan = chHomeVisiteTimespan;
		this.chHomeVisiteSemester = chHomeVisiteSemester;
		this.chHomeVisiteTime = chHomeVisiteTime;
		this.chHomeVisiteReason = chHomeVisiteReason;
	}

	@Override
	public String toString() {
		return "ChHomeVisiteJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chHomeVisiteTimespan=" + chHomeVisiteTimespan
				+ ", chHomeVisiteSemester=" + chHomeVisiteSemester
				+ ", chHomeVisiteTime=" + chHomeVisiteTime
				+ ", chHomeVisiteReason=" + chHomeVisiteReason + "]";
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

	public String getChHomeVisiteTimespan() {
		return chHomeVisiteTimespan;
	}

	public void setChHomeVisiteTimespan(String chHomeVisiteTimespan) {
		this.chHomeVisiteTimespan = chHomeVisiteTimespan;
	}

	public String getChHomeVisiteSemester() {
		return chHomeVisiteSemester;
	}

	public void setChHomeVisiteSemester(String chHomeVisiteSemester) {
		this.chHomeVisiteSemester = chHomeVisiteSemester;
	}

	public String getChHomeVisiteTime() {
		return chHomeVisiteTime;
	}

	public void setChHomeVisiteTime(String chHomeVisiteTime) {
		this.chHomeVisiteTime = chHomeVisiteTime;
	}

	public String getChHomeVisiteReason() {
		return chHomeVisiteReason;
	}

	public void setChHomeVisiteReason(String chHomeVisiteReason) {
		this.chHomeVisiteReason = chHomeVisiteReason;
	}


}