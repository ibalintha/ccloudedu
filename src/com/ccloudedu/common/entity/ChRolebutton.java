package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChRolebutton entity. @author yueyongsheng
 * 2013-07-25
 */
@Entity
@Table(name = "CH_ROLEBUTTON")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ChRolebutton extends IDEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1632916995202355221L;
	// Fields
	private ChRole chRole;
	private ChFunction chFunc;
	private String chRobuId;
	private String chRobuButton;
	private String chRobuFlag;
	private String chRobuMemo;

	// Constructors

	/** default constructor */
	public ChRolebutton() {
	}

	/** minimal constructor */
	public ChRolebutton(String id) {
		super(id);
	}

	/** full constructor */
	public ChRolebutton(String id, ChRole chRole, ChFunction chFunc, String chRobuId, String chRobuButton, String chRobuFlag,
	        String chRobuMemo) {
		super(id);
		this.chRole = chRole;
		this.chFunc = chFunc;
		this.chRobuId = chRobuId;
		this.chRobuButton = chRobuButton;
		this.chRobuFlag = chRobuFlag;
		this.chRobuMemo = chRobuMemo;
	}

	// Property accessors
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ch_role_id")
	public ChRole getChRole() {
		return this.chRole;
	}

	public void setChRole(ChRole chRole) {
		this.chRole = chRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ch_func_id")
	public ChFunction getChFunc() {
		return this.chFunc;
	}

	public void setChFunc(ChFunction chFunc) {
		this.chFunc = chFunc;
	}

	@Column(name = "ch_robu_id", length = 20)
	public String getChRobuId() {
		return this.chRobuId;
	}
	
	public void setChRobuId(String chRobuId) {
		this.chRobuId = chRobuId;
	}
	
	@Column(name = "ch_robu_button", length = 20)
	public String getChRobuButton() {
		return this.chRobuButton;
	}

	public void setChRobuButton(String chRobuButton) {
		this.chRobuButton = chRobuButton;
	}

	@Column(name = "ch_robu_flag", length = 2)
	public String getChRobuFlag() {
		return this.chRobuFlag;
	}

	public void setChRobuFlag(String chRobuFlag) {
		this.chRobuFlag = chRobuFlag;
	}

	@Column(name = "ch_robu_memo", length = 100)
	public String getChRobuMemo() {
		return this.chRobuMemo;
	}

	public void setChRobuMemo(String chRobuMemo) {
		this.chRobuMemo = chRobuMemo;
	}

}