package com.ccloudedu.cms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
import com.ccloudedu.system.entity.SysUser;

@Entity
@Table(name = "CMS_ARTICLE_ATTR")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CmsArticleAttr extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3451318327137881579L;
	private String key;
	private String name;
	private int imgWidth;
	private int imgHeight;
	private String isHasTitleimg;
	private String isDisabled;
	private Set<CmsArticle> cmsArticles = new HashSet<CmsArticle>(0);

	public CmsArticleAttr() {
	}

	public CmsArticleAttr(String id) {
		super(id);
	}

	public CmsArticleAttr(String id, String key, String name,
			int imgWidth, int imgHeight, String isHasTitleimg,
			String isDisabled, SysUser sysUser, String createTime,
			Set<CmsArticle> cmsArticles) {
		super(id,sysUser,createTime);
		this.key = key;
		this.name = name;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.isHasTitleimg = isHasTitleimg;
		this.cmsArticles = cmsArticles;
	}

	@Column(name = "KEY", length = 10)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IMG_WIDTH", precision = 22, scale = 0)
	public int getImgWidth() {
		return this.imgWidth;
	}

	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

	@Column(name = "IMG_HEIGHT", precision = 22, scale = 0)
	public int getImgHeight() {
		return this.imgHeight;
	}

	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}

	@Column(name = "IS_HAS_TITLEIMG", length = 1)
	public String getIsHasTitleimg() {
		return this.isHasTitleimg;
	}

	public void setIsHasTitleimg(String isHasTitleimg) {
		this.isHasTitleimg = isHasTitleimg;
	}

	@Column(name = "IS_DISABLED", length = 1)
	public String getIsDisabled() {
		return this.isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmsArticleAttr")
	public Set<CmsArticle> getCmsArticles() {
		return this.cmsArticles;
	}

	public void setCmsArticles(Set<CmsArticle> cmsArticles) {
		this.cmsArticles = cmsArticles;
	}

}
