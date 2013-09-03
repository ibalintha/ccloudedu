package com.ccloudedu.oa.article.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
/**
 * 信息发布--文章评论回复
 * @author wade
 * 
 */
@Entity
@Table(name = "OA_ARTICLE_COMMENT_REPLAY")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaArticleCommentReplay extends BaseEntity implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String replay;//回复内容
    private String state;
    private String remark;
    
    private OaArticleComment oaArticleComment;
    
    public OaArticleCommentReplay(){
    	
	}
	public OaArticleCommentReplay(String id) {
		super(id);
	}
    
    @Column(name = "REPLAY", length = 512)
	public String getReplay() {
		return replay;
	}
	public void setReplay(String replay) {
		this.replay = replay;
	}
	
	@Column(name = "STATE", length = 2)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "REMARK", length = 256)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMENT_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public OaArticleComment getOaArticleComment() {
		return oaArticleComment;
	}
	public void setOaArticleComment(OaArticleComment oaArticleComment) {
		this.oaArticleComment = oaArticleComment;
	}
}
