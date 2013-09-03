package com.ccloudedu.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
/**
 * 数据字典
 * @author wade
 *
 */
@Entity
@Table(name = "SYS_DATA_DICTIONARY")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysDataDictionary extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ddName;
	private String enDdName;
	
	private String ddValue;
	
	private String parentId;
	
	private String undefined1;
	private String undefined2;
	private String undefined3;
	private String remark;
    private SysDataDictionary parentDD;
	private List<SysDataDictionary> childrenDD= new ArrayList<SysDataDictionary>(0);
	
	public SysDataDictionary() {
	}

	public SysDataDictionary(String id) {
		super(id);
	}

	public SysDataDictionary(String id,SysUser sysUser, String createTime,
			String ddName,String ddValue,SysDataDictionary parentDD,List<SysDataDictionary> childrenDD,
			String undefined1,String undefined2,String undefined3) {
		super(id,sysUser,createTime);
		this.ddName = ddName;
		this.ddValue = ddValue;
		this.undefined1 = undefined1;
		this.undefined2 = undefined2;
		this.undefined3 = undefined3;
		this.parentDD = parentDD;
		this.childrenDD = childrenDD;
	}

	@Column(name = "DD_NAME", length = 50)
	public String getDdName() {
		return ddName;
	}

	public void setDdName(String ddName) {
		this.ddName = ddName;
	}
	
	@Column(name = "EN_DD_NAME", length = 50)
	public String getEnDdName() {
		return enDdName;
	}

	public void setEnDdName(String enDdName) {
		this.enDdName = enDdName;
	}
	
	@Column(name = "DD_VALUE", length = 50)
	public String getDdValue() {
		return ddValue;
	}

	public void setDdValue(String ddValue) {
		this.ddValue = ddValue;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public SysDataDictionary getParentDD() {
		return parentDD;
	}

	public void setParentDD(SysDataDictionary parentDD) {
		this.parentDD = parentDD;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentDD")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public List<SysDataDictionary> getChildrenDD() {
		return childrenDD;
	}

	public void setChildrenDD(List<SysDataDictionary> childrenDD) {
		this.childrenDD = childrenDD;
	}

	@Column(name = "UNDEFINED1", length = 50)
	public String getUndefined1() {
		return undefined1;
	}
	public void setUndefined1(String undefined1) {
		this.undefined1 = undefined1;
	}
	
	@Column(name = "UNDEFINED2", length = 50)
	public String getUndefined2() {
		return undefined2;
	}
	public void setUndefined2(String undefined2) {
		this.undefined2 = undefined2;
	}
	
	@Column(name = "UNDEFINED3", length = 50)
	public String getUndefined3() {
		return undefined3;
	}
	public void setUndefined3(String undefined3) {
		this.undefined3 = undefined3;
	}

	@Transient
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Column(name = "REMARK", length = 512)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
