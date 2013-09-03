package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChPosition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_position")
public class ChPosition extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chScroId;
	private String chPisitionTime;
	private String chPositionClass;
	private String chPositionSemester;
	private String chPositionJob;
	private String chPositionPolface;
	private String chPositionMaketime;
	private String chPositionAgent;

	// Constructors

	/** default constructor */
	public ChPosition() {
	}

	/** full constructor */
	public ChPosition(String chScroId,
			String chPisitionTime, String chPositionClass,
			String chPositionSemester, String chPositionJob,
			String chPositionPolface, String chPositionMaketime,
			String chPositionAgent) {
		this.chScroId = chScroId;
		this.chPisitionTime = chPisitionTime;
		this.chPositionClass = chPositionClass;
		this.chPositionSemester = chPositionSemester;
		this.chPositionJob = chPositionJob;
		this.chPositionPolface = chPositionPolface;
		this.chPositionMaketime = chPositionMaketime;
		this.chPositionAgent = chPositionAgent;
	}


	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_pisition_time", nullable = false, length = 20)
	public String getChPisitionTime() {
		return this.chPisitionTime;
	}

	public void setChPisitionTime(String chPisitionTime) {
		this.chPisitionTime = chPisitionTime;
	}

	@Column(name = "ch_position_class", nullable = false, length = 50)
	public String getChPositionClass() {
		return this.chPositionClass;
	}

	public void setChPositionClass(String chPositionClass) {
		this.chPositionClass = chPositionClass;
	}

	@Column(name = "ch_position_semester", nullable = false, length = 20)
	public String getChPositionSemester() {
		return this.chPositionSemester;
	}

	public void setChPositionSemester(String chPositionSemester) {
		this.chPositionSemester = chPositionSemester;
	}

	@Column(name = "ch_position_job", nullable = false, length = 50)
	public String getChPositionJob() {
		return this.chPositionJob;
	}

	public void setChPositionJob(String chPositionJob) {
		this.chPositionJob = chPositionJob;
	}

	@Column(name = "ch_position_polface", nullable = false, length = 50)
	public String getChPositionPolface() {
		return this.chPositionPolface;
	}

	public void setChPositionPolface(String chPositionPolface) {
		this.chPositionPolface = chPositionPolface;
	}

	@Column(name = "ch_position_maketime", nullable = false, length = 20)
	public String getChPositionMaketime() {
		return this.chPositionMaketime;
	}

	public void setChPositionMaketime(String chPositionMaketime) {
		this.chPositionMaketime = chPositionMaketime;
	}

	@Column(name = "ch_position_agent", nullable = false, length = 20)
	public String getChPositionAgent() {
		return this.chPositionAgent;
	}

	public void setChPositionAgent(String chPositionAgent) {
		this.chPositionAgent = chPositionAgent;
	}

}