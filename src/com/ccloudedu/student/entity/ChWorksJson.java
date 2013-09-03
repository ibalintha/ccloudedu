package com.ccloudedu.student.entity;

/**
 * 学籍管理中的作品信息，用来向前台提交json串
 * @author Pescadito
 * 2013-07-31 11:29
 */
public class ChWorksJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chWorksTime;
	private String chWorksSemester;
	private String chWorksName;
	private String chWorksDealTime;
	private String chWorksContent;
	private String chWorksMemo;
	
	public ChWorksJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChWorksJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chWorksTime, String chWorksSemester,
			String chWorksName, String chWorksDealTime, String chWorksContent,
			String chWorksMemo) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chWorksTime = chWorksTime;
		this.chWorksSemester = chWorksSemester;
		this.chWorksName = chWorksName;
		this.chWorksDealTime = chWorksDealTime;
		this.chWorksContent = chWorksContent;
		this.chWorksMemo = chWorksMemo;
	}

	@Override
	public String toString() {
		return "ChWorksJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chWorksTime=" + chWorksTime
				+ ", chWorksSemester=" + chWorksSemester + ", chWorksName="
				+ chWorksName + ", chWorksDealTime=" + chWorksDealTime
				+ ", chWorksContent=" + chWorksContent + ", chWorksMemo="
				+ chWorksMemo + "]";
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
	public String getChWorksTime() {
		return chWorksTime;
	}
	public void setChWorksTime(String chWorksTime) {
		this.chWorksTime = chWorksTime;
	}
	public String getChWorksSemester() {
		return chWorksSemester;
	}
	public void setChWorksSemester(String chWorksSemester) {
		this.chWorksSemester = chWorksSemester;
	}
	public String getChWorksName() {
		return chWorksName;
	}
	public void setChWorksName(String chWorksName) {
		this.chWorksName = chWorksName;
	}
	public String getChWorksDealTime() {
		return chWorksDealTime;
	}
	public void setChWorksDealTime(String chWorksDealTime) {
		this.chWorksDealTime = chWorksDealTime;
	}
	public String getChWorksContent() {
		return chWorksContent;
	}
	public void setChWorksContent(String chWorksContent) {
		this.chWorksContent = chWorksContent;
	}
	public String getChWorksMemo() {
		return chWorksMemo;
	}
	public void setChWorksMemo(String chWorksMemo) {
		this.chWorksMemo = chWorksMemo;
	}


}