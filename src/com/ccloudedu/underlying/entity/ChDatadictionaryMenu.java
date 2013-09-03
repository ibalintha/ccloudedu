package com.ccloudedu.underlying.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChDatadictionaryMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_datadictionary_menu")
public class ChDatadictionaryMenu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String dictMenu;
	private String tableName;
	private String module;

	// Constructors

	/** default constructor */
	public ChDatadictionaryMenu() {
	}

	/** minimal constructor */
	public ChDatadictionaryMenu(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ChDatadictionaryMenu(Integer id, String dictMenu, String tableName,
			String module) {
		this.id = id;
		this.dictMenu = dictMenu;
		this.tableName = tableName;
		this.module = module;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "dictMenu", length = 20)
	public String getDictMenu() {
		return this.dictMenu;
	}

	public void setDictMenu(String dictMenu) {
		this.dictMenu = dictMenu;
	}

	@Column(name = "tableName", length = 20)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "module", length = 20)
	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}