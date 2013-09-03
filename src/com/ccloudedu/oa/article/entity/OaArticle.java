package com.ccloudedu.oa.article.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
/**
 * 后台信息发布--文章
 * @author wade
 *
 */
@Entity
@Table(name = "OA_ARTICLE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaArticle extends BaseEntity implements java.io.Serializable {

	
	private static final long serialVersionUID = 5406057357491623200L;
	private String title;
	private String enTitle;
	private String categoryValue;
	private String content;
	private String shortTitle;
	private String titleColor;
	private String titleImg;
	private String description;
	private String tags;
	private String author;
	private String origin;
	private String sortDate;
	private String releaseDate;
	private String releaseSysDate;
	private String checkTime;
	private String disableTime;
	private int visitTotal;
	private int visitToday;
	private int visitWeek;
	private int visitMonth;
	private int visitQuarter;
	private int visitYear;
	private String outerUrl;
	private String statDate;
	private String contentResPath;
	private int pageCount;
	private String tplContent;
	private int checkStep;
	private String topLevel;
	private int commentCount;
	private String checkOpinion;
	private String relatedIds;
	private String isHasTitleimg;
	private String isAllowComment;
	private String isBold;
	private String isDraft;
	private String isRecommend;
	private String isCheck;
	private String isDisabled;
	private String isReject;
	
	private String contentImg;//图片，保存图片的路径
	
	private Set<OaArticleComment> oaArticleComments = new HashSet<OaArticleComment>(0);
	
	public OaArticle() {
	}
	public OaArticle(String id) {
		super(id);
	}
	
	public OaArticle(String id,String title,String enTitle,String categoryValue,String outerUrl,String releaseDate,int visitQuarter,String isDraft){
		super(id);
		this.title = title;
		this.enTitle = enTitle;
		this.categoryValue = categoryValue;
		this.outerUrl = outerUrl;
		this.releaseDate = releaseDate;
		this.visitQuarter = visitQuarter;
		this.isDraft = isDraft;
	}
	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "EN_TITLE", length = 100)
	public String getEnTitle() {
		return enTitle;
	}
	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}
	@Column(name = "CATEGORY_VALUE", length = 32)
	public String getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	@Lob
	@Basic(fetch=FetchType.LAZY)
    @Column(name = "CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "SHORT_TITLE", length = 100)
	public String getShortTitle() {
		return this.shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	@Column(name = "TITLE_COLOR", length = 10)
	public String getTitleColor() {
		return this.titleColor;
	}

	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}

	@Column(name = "TITLE_IMG", length = 100)
	public String getTitleImg() {
		return this.titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	@Column(name = "CONTENT_IMG", length = 100)
	public String getContentImg() {
		return this.contentImg;
	}

	public void setContentImg(String contentImg) {
		
		this.contentImg = contentImg;
	}

	@Column(name = "DESCRIPTION", length = 256)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "TAGS", length = 256)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "AUTHOR", length = 100)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "ORIGIN", length = 100)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Column(name = "SORT_DATE", length = 20)
	public String getSortDate() {
		return this.sortDate;
	}

	public void setSortDate(String sortDate) {
		this.sortDate = sortDate;
	}

	@Column(name = "RELEASE_DATE", length = 20)
	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Column(name = "RELEASE_SYS_DATE", length = 20)
	public String getReleaseSysDate() {
		return this.releaseSysDate;
	}

	public void setReleaseSysDate(String releaseSysDate) {
		this.releaseSysDate = releaseSysDate;
	}

	@Column(name = "CHECK_TIME", length = 20)
	public String getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "DISABLE_TIME", length = 20)
	public String getDisableTime() {
		return this.disableTime;
	}

	public void setDisableTime(String disableTime) {
		this.disableTime = disableTime;
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

	@Column(name = "VISIT_WEEK", precision = 22, scale = 0)
	public int getVisitWeek() {
		return this.visitWeek;
	}

	public void setVisitWeek(int visitWeek) {
		this.visitWeek = visitWeek;
	}

	@Column(name = "VISIT_MONTH", precision = 22, scale = 0)
	public int getVisitMonth() {
		return this.visitMonth;
	}

	public void setVisitMonth(int visitMonth) {
		this.visitMonth = visitMonth;
	}

	@Column(name = "VISIT_QUARTER", precision = 22, scale = 0)
	public int getVisitQuarter() {
		return this.visitQuarter;
	}

	public void setVisitQuarter(int visitQuarter) {
		this.visitQuarter = visitQuarter;
	}

	@Column(name = "VISIT_YEAR", precision = 22, scale = 0)
	public int getVisitYear() {
		return this.visitYear;
	}

	public void setVisitYear(int visitYear) {
		this.visitYear = visitYear;
	}

	@Column(name = "OUTER_URL", length = 100)
	public String getOuterUrl() {
		return this.outerUrl;
	}

	public void setOuterUrl(String outerUrl) {
		this.outerUrl = outerUrl;
	}

	@Column(name = "STAT_DATE", length = 20)
	public String getStatDate() {
		return this.statDate;
	}

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	@Column(name = "CONTENT_RES_PATH", length = 200)
	public String getContentResPath() {
		return this.contentResPath;
	}

	public void setContentResPath(String contentResPath) {
		this.contentResPath = contentResPath;
	}

	@Column(name = "PAGE_COUNT", precision = 22, scale = 0)
	public int getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Column(name = "TPL_CONTENT", length = 100)
	public String getTplContent() {
		return this.tplContent;
	}

	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}

	@Column(name = "CHECK_STEP", precision = 22, scale = 0)
	public int getCheckStep() {
		return this.checkStep;
	}

	public void setCheckStep(int checkStep) {
		this.checkStep = checkStep;
	}

	@Column(name = "TOP_LEVEL", length = 10)
	public String getTopLevel() {
		return this.topLevel;
	}

	public void setTopLevel(String topLevel) {
		this.topLevel = topLevel;
	}

	@Column(name = "COMMENT_COUNT", precision = 22, scale = 0)
	public int getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Column(name = "CHECK_OPINION", length = 256)
	public String getCheckOpinion() {
		return this.checkOpinion;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	@Column(name = "RELATED_IDS", length = 256)
	public String getRelatedIds() {
		return this.relatedIds;
	}

	public void setRelatedIds(String relatedIds) {
		this.relatedIds = relatedIds;
	}

	@Column(name = "IS_HAS_TITLEIMG", length = 1)
	public String getIsHasTitleimg() {
		return this.isHasTitleimg;
	}

	public void setIsHasTitleimg(String isHasTitleimg) {
		this.isHasTitleimg = isHasTitleimg;
	}

	@Column(name = "IS_ALLOW_COMMENT", length = 1)
	public String getIsAllowComment() {
		return this.isAllowComment;
	}

	public void setIsAllowComment(String isAllowComment) {
		this.isAllowComment = isAllowComment;
	}

	@Column(name = "IS_BOLD", length = 1)
	public String getIsBold() {
		return this.isBold;
	}

	public void setIsBold(String isBold) {
		this.isBold = isBold;
	}

	@Column(name = "IS_DRAFT", length = 1)
	public String getIsDraft() {
		return this.isDraft;
	}

	public void setIsDraft(String isDraft) {
		this.isDraft = isDraft;
	}

	@Column(name = "IS_RECOMMEND", length = 1)
	public String getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}

	@Column(name = "IS_CHECK", length = 1)
	public String getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	@Column(name = "IS_DISABLED", length = 1)
	public String getIsDisabled() {
		return this.isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	@Column(name = "IS_REJECT", length = 1)
	public String getIsReject() {
		return this.isReject;
	}

	public void setIsReject(String isReject) {
		this.isReject = isReject;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL ,mappedBy = "oaArticle")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<OaArticleComment> getOaArticleComments() {
		return oaArticleComments;
	}
	public void setOaArticleComments(Set<OaArticleComment> oaArticleComments) {
		this.oaArticleComments = oaArticleComments;
	}
}

