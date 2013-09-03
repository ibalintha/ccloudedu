package com.ccloudedu.student.entity;

/**
 * 学籍管理信息中的实践信息，用来向前台返回json串时使用
 * @author Pescadito
 * 2013-07-31 11:20
 */
public class ChPracticeJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chPracticeTimespan;
	private String chPracticeSemester;
	private String chPracticeTime;
	private String chPracticePlace;
	private String chPracticeContent;
	private String chPracticeMemo;//ch_practice_memo
	
	public ChPracticeJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChPracticeJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chPracticeTimespan,
			String chPracticeSemester, String chPracticeTime,
			String chPracticePlace, String chPracticeContent,String chPracticeMemo) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chPracticeTimespan = chPracticeTimespan;
		this.chPracticeSemester = chPracticeSemester;
		this.chPracticeTime = chPracticeTime;
		this.chPracticePlace = chPracticePlace;
		this.chPracticeContent = chPracticeContent;
		this.chPracticeMemo = chPracticeMemo;
	}
	@Override
	public String toString() {
		return "ChPracticeJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chPracticeTimespan=" + chPracticeTimespan
				+ ", chPracticeSemester=" + chPracticeSemester
				+ ", chPracticeTime=" + chPracticeTime + ", chPracticePlace="
				+ chPracticePlace + ", chPracticeContent=" + chPracticeContent
				+ ", chPracticeMemo=" + chPracticeMemo + "]";
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

	public String getChPracticeTimespan() {
		return chPracticeTimespan;
	}

	public void setChPracticeTimespan(String chPracticeTimespan) {
		this.chPracticeTimespan = chPracticeTimespan;
	}

	public String getChPracticeSemester() {
		return chPracticeSemester;
	}

	public void setChPracticeSemester(String chPracticeSemester) {
		this.chPracticeSemester = chPracticeSemester;
	}

	public String getChPracticeTime() {
		return chPracticeTime;
	}

	public void setChPracticeTime(String chPracticeTime) {
		this.chPracticeTime = chPracticeTime;
	}

	public String getChPracticePlace() {
		return chPracticePlace;
	}

	public void setChPracticePlace(String chPracticePlace) {
		this.chPracticePlace = chPracticePlace;
	}

	public String getChPracticeContent() {
		return chPracticeContent;
	}

	public void setChPracticeContent(String chPracticeContent) {
		this.chPracticeContent = chPracticeContent;
	}

	public String getChPracticeMemo() {
		return chPracticeMemo;
	}

	public void setChPracticeMemo(String chPracticeMemo) {
		this.chPracticeMemo = chPracticeMemo;
	}


}