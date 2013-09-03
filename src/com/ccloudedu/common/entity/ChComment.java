package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_comment")
public class ChComment extends IDEntity implements java.io.Serializable {

	// Fields

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private String id;
	private String chScroId;
	private String chCommentTime;
	private String chCommentSemester;
	private String chCommentTeacher;
	private String chCommentContent;
	private String chCommentLevel;

	// Constructors

	/** default constructor */
	public ChComment() {
	}

	/** full constructor */
	public ChComment(String chScroId,
			String chCommentTime, String chCommentSemester,
			String chCommentTeacher, String chCommentContent,
			String chCommentLevel) {
		this.chScroId = chScroId;
		this.chCommentTime = chCommentTime;
		this.chCommentSemester = chCommentSemester;
		this.chCommentTeacher = chCommentTeacher;
		this.chCommentContent = chCommentContent;
		this.chCommentLevel = chCommentLevel;
	}
	
	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_comment_time", nullable = false, length = 20)
	public String getChCommentTime() {
		return this.chCommentTime;
	}

	public void setChCommentTime(String chCommentTime) {
		this.chCommentTime = chCommentTime;
	}

	@Column(name = "ch_comment_semester", nullable = false, length = 20)
	public String getChCommentSemester() {
		return this.chCommentSemester;
	}

	public void setChCommentSemester(String chCommentSemester) {
		this.chCommentSemester = chCommentSemester;
	}

	@Column(name = "ch_comment_teacher", nullable = false, length = 20)
	public String getChCommentTeacher() {
		return this.chCommentTeacher;
	}

	public void setChCommentTeacher(String chCommentTeacher) {
		this.chCommentTeacher = chCommentTeacher;
	}

	@Column(name = "ch_comment_content", nullable = false, length = 100)
	public String getChCommentContent() {
		return this.chCommentContent;
	}

	public void setChCommentContent(String chCommentContent) {
		this.chCommentContent = chCommentContent;
	}

	@Column(name = "ch_comment_level", nullable = false, length = 20)
	public String getChCommentLevel() {
		return this.chCommentLevel;
	}

	public void setChCommentLevel(String chCommentLevel) {
		this.chCommentLevel = chCommentLevel;
	}

}