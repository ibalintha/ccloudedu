package com.ccloudedu.cms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysUser;

@Entity
@Table(name = "CMS_CHANNEL")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CmsChannel extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -672016136093198174L;
	private String channelName;
	private String path;
	private String title;
	private String keywords;
	private String description;
	private String tplIndex;
	private String tplContent;
	private int visitTotal;
	private int visitToday;
	private int priority;
	private String isDisplay;
	private String outerUrl;
	private String isControl;
	private String isContributeed;
	private String channelType;
	private String indexPageNum="5";//首页显示数据笔数
	private String secondPageNum="10";//二级页面显示数据笔数
	private CmsChannel cmsChannel;
	//private CmsChannelModel cmsChannelModel;
	
	private Set<CmsArticle> cmsArticles = new HashSet<CmsArticle>(0);
	private Set<CmsChannel> cmsChannels = new HashSet<CmsChannel>(0);
	private Set<SysRole> sysRoles = new HashSet<SysRole>(0);
	private Set<CmsTemplet> cmsTemplets = new HashSet<CmsTemplet>(0);
	
	//private JsonTreeNode jsonTree;

	public CmsChannel() {
	}

	public CmsChannel(String id) {
		super(id);
	}

	public CmsChannel(String id, CmsChannel cmsChannel,
			/*CmsChannelModel cmsChannelModel, */ String channelName,String path,
			String title, String keywords, String description, String tplIndex,
			String tplContent, int visitTotal, int visitToday,
			int priority, String isDisplay, String outerUrl,
			String isControl, String isContributeed, SysUser sysUser, String createTime,
			Set<CmsArticle> cmsArticles,
			Set<CmsChannel> cmsChannels, Set<SysRole> sysRoles) {
		super(id,sysUser,createTime);
		this.cmsChannel = cmsChannel;
		//this.cmsChannelModel = cmsChannelModel;
		this.channelName = channelName;
		this.path = path;
		this.title = title;
		this.keywords = keywords;
		this.description = description;
		this.tplIndex = tplIndex;
		this.tplContent = tplContent;
		this.visitTotal = visitTotal;
		this.visitToday = visitToday;
		this.priority = priority;
		this.isDisplay = isDisplay;
		this.outerUrl = outerUrl;
		this.isControl = isControl;
		this.isContributeed = isContributeed;
		this.cmsArticles = cmsArticles;
		this.cmsChannels = cmsChannels;
		this.sysRoles = sysRoles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public CmsChannel getCmsChannel() {
		return this.cmsChannel;
	}

	public void setCmsChannel(CmsChannel cmsChannel) {
		this.cmsChannel = cmsChannel;
	}
/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODEL_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public CmsChannelModel getCmsChannelModel() {
		return this.cmsChannelModel;
	}

	public void setCmsChannelModel(CmsChannelModel cmsChannelModel) {
		this.cmsChannelModel = cmsChannelModel;
	}
*/
	
	@Column(name = "CHANNEL_NAME", length = 50)
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Column(name = "PATH", length = 30)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "KEYWORDS", length = 100)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "TPL_INDEX", length = 100)
	public String getTplIndex() {
		return this.tplIndex;
	}

	public void setTplIndex(String tplIndex) {
		this.tplIndex = tplIndex;
	}

	@Column(name = "TPL_CONTENT", length = 100)
	public String getTplContent() {
		return this.tplContent;
	}

	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}

	@Column(name = "VISIT_TOTAL", precision = 22, scale = 0)
	public int getVisitTotal() {
		return this.visitTotal;
	}

	public void setVisitTotal(int visitTotal) {
		this.visitTotal = visitTotal;
	}

	@Column(name = "VISIT_TODAY", precision = 22, scale = 0)
	public int getVisitToday() {
		return this.visitToday;
	}

	public void setVisitToday(int visitToday) {
		this.visitToday = visitToday;
	}

	@Column(name = "PRIORITY", precision = 22, scale = 0)
	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Column(name = "IS_DISPLAY", length = 1)
	public String getIsDisplay() {
		return this.isDisplay;
	}

	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}

	@Column(name = "OUTER_URL", length = 100)
	public String getOuterUrl() {
		return this.outerUrl;
	}

	public void setOuterUrl(String outerUrl) {
		this.outerUrl = outerUrl;
	}

	@Column(name = "IS_CONTROL", length = 1)
	public String getIsControl() {
		return this.isControl;
	}

	public void setIsControl(String isControl) {
		this.isControl = isControl;
	}

	@Column(name = "CHANNEL_TYPE", length = 20)
	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	@Column(name = "IS_CONTRIBUTEED", length = 1)
	public String getIsContributeed() {
		return this.isContributeed;
	}

	public void setIsContributeed(String isContributeed) {
		this.isContributeed = isContributeed;
	}
	@Column(name = "INDEX_PAGE_NUM", length = 10)
	public String getIndexPageNum() {
		return indexPageNum;
	}

	public void setIndexPageNum(String indexPageNum) {
		this.indexPageNum = indexPageNum;
	}
	@Column(name = "SECOND_PAGE_NUM", length = 10)
	public String getSecondPageNum() {
		return secondPageNum;
	}

	public void setSecondPageNum(String secondPageNum) {
		this.secondPageNum = secondPageNum;
	}

	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL ,mappedBy = "cmsChannel")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<CmsArticle> getCmsArticles() {
		return this.cmsArticles;
	}

	public void setCmsArticles(Set<CmsArticle> cmsArticles) {
		this.cmsArticles = cmsArticles;
	}

	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "cmsChannel")
	@OrderBy("createTime asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<CmsChannel> getCmsChannels() {
		return this.cmsChannels;
	}

	public void setCmsChannels(Set<CmsChannel> cmsChannels) {
		this.cmsChannels = cmsChannels;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CMS_ROLE_CHANNEL", joinColumns = { @JoinColumn(name = "CHANNEL_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CMS_CHANNEL_TEMPLET", joinColumns = { @JoinColumn(name = "CHANNEL_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "TEMPLET_ID", nullable = false, updatable = false) })
	@OrderBy("templeteType desc")
	//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<CmsTemplet> getCmsTemplets() {
		return cmsTemplets;
	}

	public void setCmsTemplets(Set<CmsTemplet> cmsTemplets) {
		this.cmsTemplets = cmsTemplets;
	}
}
