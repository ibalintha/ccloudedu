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
 * ChMenu entity. @author yueyongsheng
 * 2013-07-17
 */
@Entity
@Table(name = "CH_MENU")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ChMenu extends IDEntity implements java.io.Serializable {

    private static final long serialVersionUID = 2985748512203651092L;
	// Fields

    private ChFunction chFunc;
	private String chMenuName;
	private String chMenuSortno;
	private String chMenuMemo;

	// Constructors

	/** default constructor */
	public ChMenu() {
	}

	/** minimal constructor */
	public ChMenu(String id) {
		super(id);
	}

	/** full constructor */
	public ChMenu(String id, ChFunction chFunc, String chMenuName, String chMenuSortno, String chMenuMemo) {
		super(id);
		this.chFunc = chFunc;
		this.chMenuName = chMenuName;
		this.chMenuSortno = chMenuSortno;
		this.chMenuMemo = chMenuMemo;
	}

	// Property accessors
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ch_menu_code")
	public ChFunction getChFunc() {
		return this.chFunc;
	}

	public void setChFunc(ChFunction chFunc) {
		this.chFunc = chFunc;
	}

	@Column(name = "ch_menu_name", length = 50)
	public String getChMenuName() {
		return this.chMenuName;
	}

	public void setChMenuName(String chMenuName) {
		this.chMenuName = chMenuName;
	}

	@Column(name = "ch_menu_sortno", length = 10)
	public String getChMenuSortno() {
		return this.chMenuSortno;
	}

	public void setChMenuSortno(String chMenuSortno) {
		this.chMenuSortno = chMenuSortno;
	}

	@Column(name = "ch_menu_memo", length = 100)
	public String getChMenuMemo() {
		return this.chMenuMemo;
	}

	public void setChMenuMemo(String chMenuMemo) {
		this.chMenuMemo = chMenuMemo;
	}

}