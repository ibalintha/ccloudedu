package com.ccloudedu.cms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
import com.ccloudedu.system.entity.SysUser;

@Entity
@Table(name = "CMS_TEMPLET")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CmsTemplet extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String templetName;
	private String templetFileName;
	private String templetPath;
	private String templetContent;
	private String templeteType;
	
	private CmsTemplet cmsTemplet;
	private Set<CmsTemplet> cmsTemplets = new HashSet<CmsTemplet>(0);
	private Set<CmsChannel> cmsChannels = new HashSet<CmsChannel>(0);
	
	public CmsTemplet() {
	}

	public CmsTemplet(String id) {
		super(id);
	}

	public CmsTemplet(String id, SysUser sysUser, String createTime,
			String templetName,String templetFileName,String templetPath,String templetContent,CmsTemplet cmsTemplet,Set<CmsTemplet> cmsTemplets,Set<CmsChannel> cmsChannels) {
		super(id,sysUser,createTime);
		this.templetName = templetName;
		this.templetFileName = templetFileName;
		this.templetPath = templetPath;
		this.templetContent = templetContent;
		this.cmsTemplet = cmsTemplet;
		this.cmsTemplets = cmsTemplets;
		this.cmsChannels = cmsChannels;
	}
	
	@Column(name = "TEMPLET_NAME", length = 128)
	public String getTempletName() {
		return templetName;
	}
	public void setTempletName(String templetName) {
		this.templetName = templetName;
	}
	
	@Column(name = "TEMPLET_FILE_NAME", length = 32)
	public String getTempletFileName() {
		return templetFileName;
	}

	public void setTempletFileName(String templetFileName) {
		this.templetFileName = templetFileName;
	}

	@Column(name = "TEMPLET_PATH", length = 128)
	public String getTempletPath() {
		return templetPath;
	}
	public void setTempletPath(String templetPath) {
		this.templetPath = templetPath;
	}
	
	@Column(name = "TEMPLETE_TYPE", length = 20)
	public String getTempleteType() {
		return templeteType;
	}

	public void setTempleteType(String templeteType) {
		this.templeteType = templeteType;
	}

	@Lob
	@Column(name = "TEMPLET_CONTENT")
	public String getTempletContent() {
		return templetContent;
	}
	public void setTempletContent(String templetContent) {
		this.templetContent = templetContent;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public CmsTemplet getCmsTemplet() {
		return cmsTemplet;
	}
	public void setCmsTemplet(CmsTemplet cmsTemplet) {
		this.cmsTemplet = cmsTemplet;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "cmsTemplet")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@OrderBy("createTime asc")
	public Set<CmsTemplet> getCmsTemplets() {
		return cmsTemplets;
	}
	public void setCmsTemplets(Set<CmsTemplet> cmsTemplets) {
		this.cmsTemplets = cmsTemplets;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CMS_CHANNEL_TEMPLET", joinColumns = { @JoinColumn(name = "TEMPLET_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "CHANNEL_ID", nullable = false, updatable = false) })
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<CmsChannel> getCmsChannels() {
		return cmsChannels;
	}
	public void setCmsChannels(Set<CmsChannel> cmsChannels) {
		this.cmsChannels = cmsChannels;
	}
}
