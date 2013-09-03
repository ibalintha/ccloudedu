package com.ccloudedu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;

@Entity
@Table(name = "CMS_COMMENT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CmsComment extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8731730963607754582L;
	private String title;
	private String content;
	private String ip;
	private String isCheck;
	private String isRecommend;
	private String isDisabled;
	private CmsMember createUser;
	private String createTime;
	
	private CmsCommentReplay cmsCommentReplay;
	private CmsArticle cmsArticle;
	
	public CmsComment() {
	}

	public CmsComment(String id) {
		super(id);
	}

	public CmsComment(String id, CmsCommentReplay cmsCommentReplay,
			CmsArticle cmsArticle, String title, String content, String ip,
			String isCheck, String isRecommend, String isDisabled,
			CmsMember createUser, String createTime) {
		super(id);
		this.cmsCommentReplay = cmsCommentReplay;
		this.cmsArticle = cmsArticle;
		this.title = title;
		this.content = content;
		this.ip = ip;
		this.isCheck = isCheck;
		this.isRecommend = isRecommend;
		this.isDisabled = isDisabled;
		this.createUser = createUser;
		this.createTime = createTime;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPLAY_ID")
	public CmsCommentReplay getCmsCommentReplay() {
		return this.cmsCommentReplay;
	}

	public void setCmsCommentReplay(CmsCommentReplay cmsCommentReplay) {
		this.cmsCommentReplay = cmsCommentReplay;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICEL_ID")
	public CmsArticle getCmsArticle() {
		return this.cmsArticle;
	}

	public void setCmsArticle(CmsArticle cmsArticle) {
		this.cmsArticle = cmsArticle;
	}

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "CONTENT", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "IP", length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "IS_CHECK", length = 1)
	public String getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	@Column(name = "IS_RECOMMEND", length = 1)
	public String getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}

	@Column(name = "IS_DISABLED", length = 1)
	public String getIsDisabled() {
		return this.isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	@Column(name = "CREATE_TIME", length = 20)
	public String getCreateTime() {
		return this.createTime;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATE_USER_ID")
	public CmsMember getCreateUser() {
		return createUser;
	}

	public void setCreateUser(CmsMember createUser) {
		this.createUser = createUser;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
