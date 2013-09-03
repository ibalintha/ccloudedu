package com.ccloudedu.oa.article.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
/**
 * 后台信息发布--文章评论
 * @author wade
 *
 */
@Entity
@Table(name = "OA_ARTICLE_COMMENT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaArticleComment extends BaseEntity implements java.io.Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;//评论标题
	private String comment;//评论内容
	private String ip;//评论人ip
	private String is_check;//是否需要审核
	private String is_recommend;//是否推荐
	private String is_disabled;//是否不可用
	
	private OaArticle oaArticle;
	private Set<OaArticleCommentReplay> oaArticleCommentReplays = new HashSet<OaArticleCommentReplay>(0);
	
	public OaArticleComment(){
		
	}
	public OaArticleComment(String id) {
		super(id);
	}
	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "COMMENT", length = 512)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(name = "IP", length = 20)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	@Column(name = "IS_CHECK", length = 2)
	public String getIs_check() {
		return is_check;
	}

	public void setIs_check(String isCheck) {
		is_check = isCheck;
	}
	@Column(name = "IS_RECOMMEND", length = 2)
	public String getIs_recommend() {
		return is_recommend;
	}

	public void setIs_recommend(String isRecommend) {
		is_recommend = isRecommend;
	}
	@Column(name = "IS_DISABLED", length = 2)
	public String getIs_disabled() {
		return is_disabled;
	}

	public void setIs_disabled(String isDisabled) {
		is_disabled = isDisabled;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLE_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public OaArticle getOaArticle() {
		return oaArticle;
	}
	public void setOaArticle(OaArticle oaArticle) {
		this.oaArticle = oaArticle;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL ,mappedBy = "oaArticleComment")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<OaArticleCommentReplay> getOaArticleCommentReplays() {
		return oaArticleCommentReplays;
	}
	public void setOaArticleCommentReplays(
			Set<OaArticleCommentReplay> oaArticleCommentReplays) {
		this.oaArticleCommentReplays = oaArticleCommentReplays;
	}
}
