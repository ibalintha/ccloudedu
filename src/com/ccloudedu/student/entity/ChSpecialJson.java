package com.ccloudedu.student.entity;

/**
 * 学籍管理信息中的特长信息，用来向页面传输json串时使用
 * @author Pescadito
 * 2013-07-31 11:27
 */
public class ChSpecialJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chScroSchcode;//学号
	private String chSpecialTimespan;
	private String chSpecialSemester;
	private String chSpecialTime;
	private String chSpecialReason;
	private String chSpecialComment;
	private String chSpecialLevel;//ch_special_level
	private String chSpecialOffice;//ch_special_office
	private String chSpecialContent;//ch_special_content
	private String chSpecialCertificate;//ch_special_certificate
	
	public ChSpecialJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChSpecialJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chScroSchcode, String chSpecialTimespan,
			String chSpecialSemester, String chSpecialTime,
			String chSpecialReason, String chSpecialComment,
			String chSpecialLevel, String chSpecialOffice,
			String chSpecialContent, String chSpecialCertificate) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chScroSchcode = chScroSchcode;
		this.chSpecialTimespan = chSpecialTimespan;
		this.chSpecialSemester = chSpecialSemester;
		this.chSpecialTime = chSpecialTime;
		this.chSpecialReason = chSpecialReason;
		this.chSpecialComment = chSpecialComment;
		this.chSpecialLevel = chSpecialLevel;
		this.chSpecialOffice = chSpecialOffice;
		this.chSpecialContent = chSpecialContent;
		this.chSpecialCertificate = chSpecialCertificate;
	}
	@Override
	public String toString() {
		return "ChSpecialJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chScroSchcode=" + chScroSchcode
				+ ", chSpecialTimespan=" + chSpecialTimespan
				+ ", chSpecialSemester=" + chSpecialSemester
				+ ", chSpecialTime=" + chSpecialTime + ", chSpecialReason="
				+ chSpecialReason + ", chSpecialComment=" + chSpecialComment
				+ ", chSpecialLevel=" + chSpecialLevel + ", chSpecialOffice="
				+ chSpecialOffice + ", chSpecialContent=" + chSpecialContent
				+ ", chSpecialCertificate=" + chSpecialCertificate + "]";
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

	public String getChSpecialTimespan() {
		return chSpecialTimespan;
	}

	public void setChSpecialTimespan(String chSpecialTimespan) {
		this.chSpecialTimespan = chSpecialTimespan;
	}

	public String getChSpecialSemester() {
		return chSpecialSemester;
	}

	public void setChSpecialSemester(String chSpecialSemester) {
		this.chSpecialSemester = chSpecialSemester;
	}

	public String getChSpecialTime() {
		return chSpecialTime;
	}

	public void setChSpecialTime(String chSpecialTime) {
		this.chSpecialTime = chSpecialTime;
	}

	public String getChSpecialReason() {
		return chSpecialReason;
	}

	public void setChSpecialReason(String chSpecialReason) {
		this.chSpecialReason = chSpecialReason;
	}

	public String getChSpecialComment() {
		return chSpecialComment;
	}

	public void setChSpecialComment(String chSpecialComment) {
		this.chSpecialComment = chSpecialComment;
	}

	public String getChScroSchcode() {
		return chScroSchcode;
	}

	public void setChScroSchcode(String chScroSchcode) {
		this.chScroSchcode = chScroSchcode;
	}
	public String getChSpecialLevel() {
		return chSpecialLevel;
	}
	public void setChSpecialLevel(String chSpecialLevel) {
		this.chSpecialLevel = chSpecialLevel;
	}
	public String getChSpecialOffice() {
		return chSpecialOffice;
	}
	public void setChSpecialOffice(String chSpecialOffice) {
		this.chSpecialOffice = chSpecialOffice;
	}
	public String getChSpecialContent() {
		return chSpecialContent;
	}
	public void setChSpecialContent(String chSpecialContent) {
		this.chSpecialContent = chSpecialContent;
	}
	public String getChSpecialCertificate() {
		return chSpecialCertificate;
	}
	public void setChSpecialCertificate(String chSpecialCertificate) {
		this.chSpecialCertificate = chSpecialCertificate;
	}

	
}