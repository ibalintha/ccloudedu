package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChDatadictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_datadictionary")
public class ChDatadictionary extends IDEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String chDadtModule;
	private String chDadtMenu;
	private String chDadtSyscode;
	private String chDadtEducode;
	private String chDadtName;
	private String chDadtFlag;
	private String chDadtDeftype;
	private String chDadtTable;
	private String chDadtMemo;

	// Constructors

	/** default constructor */
	public ChDatadictionary() {
	}

	/** minimal constructor */

	/** full constructor */
	public ChDatadictionary(String chDadtModule, String chDadtMenu,
			String chDadtSyscode, String chDadtEducode, String chDadtName,
			String chDadtFlag, String chDadtDeftype, String chDadtTable,
			String chDadtMemo) {

		this.chDadtModule = chDadtModule;
		this.chDadtMenu = chDadtMenu;
		this.chDadtSyscode = chDadtSyscode;
		this.chDadtEducode = chDadtEducode;
		this.chDadtName = chDadtName;
		this.chDadtFlag = chDadtFlag;
		this.chDadtDeftype = chDadtDeftype;
		this.chDadtTable = chDadtTable;
		this.chDadtMemo = chDadtMemo;
	}

	// Property accessors

	@Column(name = "ch_dadt_module", length = 20)
	public String getChDadtModule() {
		return this.chDadtModule;
	}

	public void setChDadtModule(String chDadtModule) {
		this.chDadtModule = chDadtModule;
	}

	@Column(name = "ch_dadt_menu", length = 20)
	public String getChDadtMenu() {
		return this.chDadtMenu;
	}

	public void setChDadtMenu(String chDadtMenu) {
		this.chDadtMenu = chDadtMenu;
	}

	@Column(name = "ch_dadt_syscode", length = 20)
	public String getChDadtSyscode() {
		return this.chDadtSyscode;
	}

	public void setChDadtSyscode(String chDadtSyscode) {
		this.chDadtSyscode = chDadtSyscode;
	}

	@Column(name = "ch_dadt_educode", length = 20)
	public String getChDadtEducode() {
		return this.chDadtEducode;
	}

	public void setChDadtEducode(String chDadtEducode) {
		this.chDadtEducode = chDadtEducode;
	}

	@Column(name = "ch_dadt_name", length = 50)
	public String getChDadtName() {
		return this.chDadtName;
	}

	public void setChDadtName(String chDadtName) {
		this.chDadtName = chDadtName;
	}

	@Column(name = "ch_dadt_flag", length = 1)
	public String getChDadtFlag() {
		return this.chDadtFlag;
	}

	public void setChDadtFlag(String chDadtFlag) {
		this.chDadtFlag = chDadtFlag;
	}

	@Column(name = "ch_dadt_deftype", length = 1)
	public String getChDadtDeftype() {
		return this.chDadtDeftype;
	}

	public void setChDadtDeftype(String chDadtDeftype) {
		this.chDadtDeftype = chDadtDeftype;
	}

	@Column(name = "ch_dadt_table", length = 20)
	public String getChDadtTable() {
		return this.chDadtTable;
	}

	public void setChDadtTable(String chDadtTable) {
		this.chDadtTable = chDadtTable;
	}

	@Column(name = "ch_dadt_memo", length = 500)
	public String getChDadtMemo() {
		return this.chDadtMemo;
	}

	public void setChDadtMemo(String chDadtMemo) {
		this.chDadtMemo = chDadtMemo;
	}

}