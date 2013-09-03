package com.ccloudedu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
import com.ccloudedu.system.entity.SysUser;

@Entity
@Table(name = "CMS_COMMENT_REPLAY")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CmsCommentReplay extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3703494707005741277L;

	private String replayContent;
	private CmsComment cmsComment;
	
	public CmsCommentReplay() {
	}

	public CmsCommentReplay(String id) {
		super(id);
	}

	public CmsCommentReplay(String id, CmsComment cmsComment, String replayContent, 
			SysUser sysUser, String createTime) {
		super(id,sysUser,createTime);
		this.cmsComment = cmsComment;
		this.replayContent = replayContent;
	}

	@OneToOne(mappedBy = "cmsCommentReplay")
	public CmsComment getCmsComment() {
		return this.cmsComment;
	}

	public void setCmsComment(CmsComment cmsComment) {
		this.cmsComment = cmsComment;
	}

	@Column(name = "REPLAY_CONTENT", length = 1024)
	public String getReplayContent() {
		return replayContent;
	}

	public void setReplayContent(String replayContent) {
		this.replayContent = replayContent;
	}
	
}
