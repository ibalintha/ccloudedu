package com.ccloudedu.common.entity;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;
import com.ccloudedu.cms.entity.CmsTemplet;
import com.ccloudedu.system.entity.SysMenu;

/**
 * ChClasstree entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_classtree")
public class ChClasstree extends IDEntity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String parentId;
	private String name;
	private String remark;
	private Integer orderNumber;
	private String isDelete;
	private String state;
	private String isLast;
	private String unallocated;
	
	private ChClasstree chclasstree;
	
	
	private Set<ChClasstree> chclasstrees = new HashSet<ChClasstree>(0);

	// Constructors

	/** default constructor */
	public ChClasstree() {
	}


	/** full constructor */
	public ChClasstree( String parentId, String name, String remark,
			Integer orderNumber, String isDelete, String state,
			ChClasstree chclasstree,Set<ChClasstree> chclasstrees,String isLast) {
		this.parentId = parentId;
		this.name = name;
		this.remark = remark;
		this.orderNumber = orderNumber;
		this.isDelete = isDelete;
		this.state = state;
		this.chclasstree = chclasstree;
		this.chclasstrees = chclasstrees;
		this.isLast = isLast;
	}

	// Property accessors

	@Column(name = "parent_id", length = 50)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "order_number")
	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "is_delete", length = 2)
	public String getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "state", length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public ChClasstree getChclasstree() {
		return chclasstree;
	}

	public void setChclasstree(ChClasstree chclasstree) {
		this.chclasstree = chclasstree;
	}

	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "chclasstree")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@OrderBy("id asc")
	public Set<ChClasstree> getChclasstrees() {
		return chclasstrees;
	}


	public void setChclasstrees(Set<ChClasstree> chclasstrees) {
		this.chclasstrees = chclasstrees;
	}

	@Column(name = "is_last", length = 2)
	public String getIsLast() {
		return isLast;
	}


	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}

	@Column(name = "unallocated", length = 2)
	public String getUnallocated() {
		return this.unallocated;
	}


	public void setUnallocated(String unallocated) {
		this.unallocated = unallocated;
	}
	
	

}