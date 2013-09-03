package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChPractice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_practice")
public class ChPractice extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chScroId;
	private String chPracticeTimespan;
	private String chPracticeSemester;
	private String chPracticeTime;
	private String chPracticePlace;
	private String chPracticeContent;
	private String chPracticeMemo;//ch_practice_memo
	// Constructors

	/** default constructor */
	public ChPractice() {
	}

	/** full constructor */
	public ChPractice(String chScroId,
			String chPracticeTimespan, String chPracticeSemester,
			String chPracticeTime, String chPracticePlace,
			String chPracticeContent,String chPracticeMemo) {
		this.chScroId = chScroId;
		this.chPracticeTimespan = chPracticeTimespan;
		this.chPracticeSemester = chPracticeSemester;
		this.chPracticeTime = chPracticeTime;
		this.chPracticePlace = chPracticePlace;
		this.chPracticeContent = chPracticeContent;
		this.chPracticeMemo = chPracticeMemo;
	}

	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_practice_timespan", nullable = false, length = 20)
	public String getChPracticeTimespan() {
		return this.chPracticeTimespan;
	}

	public void setChPracticeTimespan(String chPracticeTimespan) {
		this.chPracticeTimespan = chPracticeTimespan;
	}

	@Column(name = "ch_practice_semester", nullable = false, length = 20)
	public String getChPracticeSemester() {
		return this.chPracticeSemester;
	}

	public void setChPracticeSemester(String chPracticeSemester) {
		this.chPracticeSemester = chPracticeSemester;
	}

	@Column(name = "ch_practice_time", nullable = false, length = 20)
	public String getChPracticeTime() {
		return this.chPracticeTime;
	}

	public void setChPracticeTime(String chPracticeTime) {
		this.chPracticeTime = chPracticeTime;
	}

	@Column(name = "ch_practice_place", nullable = false, length = 50)
	public String getChPracticePlace() {
		return this.chPracticePlace;
	}

	public void setChPracticePlace(String chPracticePlace) {
		this.chPracticePlace = chPracticePlace;
	}

	@Column(name = "ch_practice_content", nullable = false, length = 100)
	public String getChPracticeContent() {
		return this.chPracticeContent;
	}

	public void setChPracticeContent(String chPracticeContent) {
		this.chPracticeContent = chPracticeContent;
	}

	@Column(name = "ch_practice_memo", nullable = true, length = 100)
	public String getChPracticeMemo() {
		return chPracticeMemo;
	}

	public void setChPracticeMemo(String chPracticeMemo) {
		this.chPracticeMemo = chPracticeMemo;
	}

}