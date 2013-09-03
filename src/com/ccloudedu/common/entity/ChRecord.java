package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;
import com.ccloudedu.system.entity.SysUser;

/**
 * ChRecord entity. @author yueyongsheng
 * 2013-07-22
 */
@Entity
@Table(name = "CH_RECORD")
public class ChRecord extends IDEntity implements java.io.Serializable{

    private static final long serialVersionUID = 1250441320117909491L;
	// Fields
	private String chRecdModule;
	private String chRecdDesc;
	private String chRecdType;
	private ChUser chUser;
//	private SysUser chUser;
	private String chRecdTime;
	private String chRecdMemo;

	// Constructors

	/** default constructor */
	public ChRecord() {
	}

	/** minimal constructor */
	public ChRecord(String id) {
		super(id);
	}

	/** full constructor */
	public ChRecord(String id, String chRecdModule, String chRecdDesc, String chRecdType, ChUser chUser,
	        String chRecdTime, String chRecdMemo) {
		super(id);
		this.chRecdModule = chRecdModule;
		this.chRecdDesc = chRecdDesc;
		this.chRecdType = chRecdType;
		this.chUser = chUser;
		this.chRecdTime = chRecdTime;
		this.chRecdMemo = chRecdMemo;
	}

	// Property accessors
	@Column(name = "ch_recd_module", length = 50)
	public String getChRecdModule() {
		return this.chRecdModule;
	}

	public void setChRecdModule(String chRecdModule) {
		this.chRecdModule = chRecdModule;
	}

	@Column(name = "ch_recd_desc", length = 100)
	public String getChRecdDesc() {
		return this.chRecdDesc;
	}

	public void setChRecdDesc(String chRecdDesc) {
		this.chRecdDesc = chRecdDesc;
	}

	@Column(name = "ch_recd_type", length = 20)
	public String getChRecdType() {
		return this.chRecdType;
	}

	public void setChRecdType(String chRecdType) {
		this.chRecdType = chRecdType;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ch_recd_userid")
	public ChUser getChUser() {
    	return chUser;
    }

	public void setChUser(ChUser chUser) {
    	this.chUser = chUser;
    }
	
	@Column(name = "ch_recd_time", length = 20)
	public String getChRecdTime() {
		return this.chRecdTime;
	}

	public void setChRecdTime(String chRecdTime) {
		this.chRecdTime = chRecdTime;
	}

	@Column(name = "ch_recd_memo", length = 100)
	public String getChRecdMemo() {
		return this.chRecdMemo;
	}

	public void setChRecdMemo(String chRecdMemo) {
		this.chRecdMemo = chRecdMemo;
	}
}