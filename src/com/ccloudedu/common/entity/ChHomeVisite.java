package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChHomeVisite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_homeVisite")
public class ChHomeVisite extends IDEntity implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chScroId;
	private String chHomeVisiteTimespan;
	private String chHomeVisiteSemester;
	private String chHomeVisiteTime;
	private String chHomeVisiteReason;

	// Constructors

	/** default constructor */
	public ChHomeVisite() {
	}

	/** full constructor */
	public ChHomeVisite(String chScroId,
			String chHomeVisiteTimespan, String chHomeVisiteSemester,
			String chHomeVisiteTime, String chHomeVisiteReason) {
		this.chScroId = chScroId;
		this.chHomeVisiteTimespan = chHomeVisiteTimespan;
		this.chHomeVisiteSemester = chHomeVisiteSemester;
		this.chHomeVisiteTime = chHomeVisiteTime;
		this.chHomeVisiteReason = chHomeVisiteReason;
	}


	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_homeVisite_timespan", nullable = false, length = 20)
	public String getChHomeVisiteTimespan() {
		return this.chHomeVisiteTimespan;
	}

	public void setChHomeVisiteTimespan(String chHomeVisiteTimespan) {
		this.chHomeVisiteTimespan = chHomeVisiteTimespan;
	}

	@Column(name = "ch_homeVisite_semester", nullable = false, length = 20)
	public String getChHomeVisiteSemester() {
		return this.chHomeVisiteSemester;
	}

	public void setChHomeVisiteSemester(String chHomeVisiteSemester) {
		this.chHomeVisiteSemester = chHomeVisiteSemester;
	}

	@Column(name = "ch_homeVisite_time", nullable = false, length = 20)
	public String getChHomeVisiteTime() {
		return this.chHomeVisiteTime;
	}

	public void setChHomeVisiteTime(String chHomeVisiteTime) {
		this.chHomeVisiteTime = chHomeVisiteTime;
	}

	@Column(name = "ch_homeVisite_reason", nullable = false, length = 100)
	public String getChHomeVisiteReason() {
		return this.chHomeVisiteReason;
	}

	public void setChHomeVisiteReason(String chHomeVisiteReason) {
		this.chHomeVisiteReason = chHomeVisiteReason;
	}

}