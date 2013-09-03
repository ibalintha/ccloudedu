package com.ccloudedu.student.entity;

/**
 * 该实体用来返回学生评论信息到页面的时候用
 * @author Pescadito
 * 2013-07-31 11:03
 */
public class ChCommentJson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chCommentTime;
	private String chCommentSemester;
	private String chCommentTeacher;
	private String chCommentContent;
	private String chCommentLevel;
	
	
	public ChCommentJson() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChCommentJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chCommentTime, String chCommentSemester,
			String chCommentTeacher, String chCommentContent,
			String chCommentLevel) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chCommentTime = chCommentTime;
		this.chCommentSemester = chCommentSemester;
		this.chCommentTeacher = chCommentTeacher;
		this.chCommentContent = chCommentContent;
		this.chCommentLevel = chCommentLevel;
	}


	@Override
	public String toString() {
		return "ChCommentJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chCommentTime=" + chCommentTime
				+ ", chCommentSemester=" + chCommentSemester
				+ ", chCommentTeacher=" + chCommentTeacher
				+ ", chCommentContent=" + chCommentContent
				+ ", chCommentLevel=" + chCommentLevel + "]";
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


	public String getChCommentTime() {
		return chCommentTime;
	}


	public void setChCommentTime(String chCommentTime) {
		this.chCommentTime = chCommentTime;
	}


	public String getChCommentSemester() {
		return chCommentSemester;
	}


	public void setChCommentSemester(String chCommentSemester) {
		this.chCommentSemester = chCommentSemester;
	}


	public String getChCommentTeacher() {
		return chCommentTeacher;
	}


	public void setChCommentTeacher(String chCommentTeacher) {
		this.chCommentTeacher = chCommentTeacher;
	}


	public String getChCommentContent() {
		return chCommentContent;
	}


	public void setChCommentContent(String chCommentContent) {
		this.chCommentContent = chCommentContent;
	}


	public String getChCommentLevel() {
		return chCommentLevel;
	}


	public void setChCommentLevel(String chCommentLevel) {
		this.chCommentLevel = chCommentLevel;
	}
	
}