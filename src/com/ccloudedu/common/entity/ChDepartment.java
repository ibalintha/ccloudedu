package com.ccloudedu.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * ChDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_department")
public class ChDepartment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3963645880041943453L;
	private String id;
	private Integer chDepaForedepa;
	private String chDepaCode;
	private String chDepaName;
	private String chDepaPhone;
	private String chDepaPerson;
	private String chDepaTeahflag;
	private String chDepaDesc;
	private String chDepaMemo;
	private String isLast;

	
	private ChDepartment chdeparttree;
	
	
	private Set<ChDepartment> chdeparttrees = new HashSet<ChDepartment>(0);
	// Constructors

	/** default constructor */
	public ChDepartment() {
	}

	/** minimal constructor */
	public ChDepartment(String id) {
		this.id = id;
	}

	/** full constructor */
	public ChDepartment(String id, Integer chDepaForedepa, String chDepaCode,
			String chDepaName, String chDepaPhone, String chDepaPerson,
			String chDepaTeahflag, String chDepaDesc, String chDepaMemo,String isLast) {
		this.id = id;
		this.chDepaForedepa = chDepaForedepa;
		this.chDepaCode = chDepaCode;
		this.chDepaName = chDepaName;
		this.chDepaPhone = chDepaPhone;
		this.chDepaPerson = chDepaPerson;
		this.chDepaTeahflag = chDepaTeahflag;
		this.chDepaDesc = chDepaDesc;
		this.chDepaMemo = chDepaMemo;
		this.isLast = isLast;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ch_depa_foredepa",length = 50)
	public Integer getChDepaForedepa() {
		return this.chDepaForedepa;
	}

	public void setChDepaForedepa(Integer chDepaForedepa) {
		this.chDepaForedepa = chDepaForedepa;
	}

	@Column(name = "ch_depa_code", length = 20)
	public String getChDepaCode() {
		return this.chDepaCode;
	}

	public void setChDepaCode(String chDepaCode) {
		this.chDepaCode = chDepaCode;
	}

	@Column(name = "ch_depa_name", length = 50)
	public String getChDepaName() {
		return this.chDepaName;
	}

	public void setChDepaName(String chDepaName) {
		this.chDepaName = chDepaName;
	}

	@Column(name = "ch_depa_phone", length = 20)
	public String getChDepaPhone() {
		return this.chDepaPhone;
	}

	public void setChDepaPhone(String chDepaPhone) {
		this.chDepaPhone = chDepaPhone;
	}

	@Column(name = "ch_depa_person", length = 20)
	public String getChDepaPerson() {
		return this.chDepaPerson;
	}

	public void setChDepaPerson(String chDepaPerson) {
		this.chDepaPerson = chDepaPerson;
	}

	@Column(name = "ch_depa_teahflag", length = 10)
	public String getChDepaTeahflag() {
		return this.chDepaTeahflag;
	}

	public void setChDepaTeahflag(String chDepaTeahflag) {
		this.chDepaTeahflag = chDepaTeahflag;
	}

	@Column(name = "ch_depa_desc", length = 100)
	public String getChDepaDesc() {
		return this.chDepaDesc;
	}

	public void setChDepaDesc(String chDepaDesc) {
		this.chDepaDesc = chDepaDesc;
	}

	@Column(name = "ch_depa_memo", length = 100)
	public String getChDepaMemo() {
		return this.chDepaMemo;
	}

	public void setChDepaMemo(String chDepaMemo) {
		this.chDepaMemo = chDepaMemo;
	}
	@Column(name = "is_last", length = 2)
	public String getIsLast() {
		return this.isLast;
	}

	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CH_DEPA_FOREDEPA")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public ChDepartment getChdeparttree() {
		return chdeparttree;
	}

	public void setChdeparttree(ChDepartment chdeparttree) {
		this.chdeparttree = chdeparttree;
	}
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "chdeparttree")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@OrderBy("id asc")
	public Set<ChDepartment> getChdeparttrees() {
		return chdeparttrees;
	}

	public void setChdeparttrees(Set<ChDepartment> chdeparttrees) {
		this.chdeparttrees = chdeparttrees;
	}

}