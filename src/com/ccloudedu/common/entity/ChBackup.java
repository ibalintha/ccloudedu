package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChBackup entity. @author yueyongsheng
 * 2013-07-22
 */
@Entity
@Table(name = "CH_BACKUP")
public class ChBackup extends IDEntity implements java.io.Serializable {

    private static final long serialVersionUID = 4217744317686113164L;
	// Fields
	private String chBaupDatabase;
	private String chBaupPath;
	private String chBaupWay;
	private String chBaupRate;
	private String chBaupBegtime;
	private String chBaupMemo;

	// Constructors

	/** default constructor */
	public ChBackup() {
	}

	/** minimal constructor */
	public ChBackup(String id) {
		super(id);
	}

	/** full constructor */
	public ChBackup(String id, String chBaupDatabase, String chBaupPath, String chBaupWay, String chBaupRate,
	        String chBaupBegtime, String chBaupMemo) {
		super(id);
		this.chBaupDatabase = chBaupDatabase;
		this.chBaupPath = chBaupPath;
		this.chBaupWay = chBaupWay;
		this.chBaupRate = chBaupRate;
		this.chBaupBegtime = chBaupBegtime;
		this.chBaupMemo = chBaupMemo;
	}

	// Property accessors
	@Column(name = "ch_baup_database", length = 20)
	public String getChBaupDatabase() {
		return this.chBaupDatabase;
	}

	public void setChBaupDatabase(String chBaupDatabase) {
		this.chBaupDatabase = chBaupDatabase;
	}

	@Column(name = "ch_baup_path", length = 100)
	public String getChBaupPath() {
		return this.chBaupPath;
	}

	public void setChBaupPath(String chBaupPath) {
		this.chBaupPath = chBaupPath;
	}

	@Column(name = "ch_baup_way", length = 10)
	public String getChBaupWay() {
		return this.chBaupWay;
	}

	public void setChBaupWay(String chBaupWay) {
		this.chBaupWay = chBaupWay;
	}

	@Column(name = "ch_baup_rate", length = 10)
	public String getChBaupRate() {
		return this.chBaupRate;
	}

	public void setChBaupRate(String chBaupRate) {
		this.chBaupRate = chBaupRate;
	}

	@Column(name = "ch_baup_begtime", length = 20)
	public String getChBaupBegtime() {
		return this.chBaupBegtime;
	}

	public void setChBaupBegtime(String chBaupBegtime) {
		this.chBaupBegtime = chBaupBegtime;
	}

	@Column(name = "ch_baup_memo", length = 100)
	public String getChBaupMemo() {
		return this.chBaupMemo;
	}

	public void setChBaupMemo(String chBaupMemo) {
		this.chBaupMemo = chBaupMemo;
	}

}