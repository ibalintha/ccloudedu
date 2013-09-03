package com.ccloudedu.cms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.system.entity.SysUser;

@Entity
@Table(name = "CMS_ARTICLE")
public class CmsArticle implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5406057357491623200L;
    private long id;
	private int preId;
	private int nextId;
	private String title;
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
	private SysUser createUser;
	private String createTime;
	private String remark;
	
	private String contentImg;//图片，保存图片的路径
	
	//many-to-one
	private CmsArticleAttr cmsArticleAttr;
	private CmsChannel cmsChannel;
	
	//one-to-many
	private Set<CmsComment> cmsComments = new HashSet<CmsComment>(0);

	public CmsArticle() {
	}

	public CmsArticle(long id) {
		this.id = id;
	}

	public CmsArticle(long id, CmsArticleAttr cmsArticleAttr,
			CmsChannel cmsChannel, int preId, int nextId,
			String title,String content ,String shortTitle, String titleColor,
			String titleImg, String contentImg, String description,
			String tags, String author, String origin, String sortDate,
			String releaseDate, String releaseSysDate, String checkTime,
			String disableTime, int visitTotal, int visitToday,
			int visitWeek, int visitMonth,
			int visitQuarter, int visitYear, String outerUrl,
			String statDate, String contentResPath, int pageCount,
			String tplContent, int checkStep, String topLevel,
			int commentCount, String checkOpinion, String relatedIds,
			String isHasTitleimg, String isAllowComment,
			String isBold, String isDraft, String isRecommend,
			String isCheck, String isDisabled, String isReject,
			SysUser createUser, String createTime, Set<CmsComment> cmsComments) {
		this.id = id;
		this.cmsArticleAttr = cmsArticleAttr;
		this.cmsChannel = cmsChannel;
		this.preId = preId;
		this.nextId = nextId;
		this.title = title;
		this.content = content;
		this.shortTitle = shortTitle;
		this.titleColor = titleColor;
		this.titleImg = titleImg;
		this.contentImg = contentImg;
		this.description = description;
		this.tags = tags;
		this.author = author;
		this.origin = origin;
		this.sortDate = sortDate;
		this.releaseDate = releaseDate;
		this.releaseSysDate = releaseSysDate;
		this.checkTime = checkTime;
		this.disableTime = disableTime;
		this.visitTotal = visitTotal;
		this.visitToday = visitToday;
		this.visitWeek = visitWeek;
		this.visitMonth = visitMonth;
		this.visitQuarter = visitQuarter;
		this.visitYear = visitYear;
		this.outerUrl = outerUrl;
		this.statDate = statDate;
		this.contentResPath = contentResPath;
		this.pageCount = pageCount;
		this.tplContent = tplContent;
		this.checkStep = checkStep;
		this.topLevel = topLevel;
		this.commentCount = commentCount;
		this.checkOpinion = checkOpinion;
		this.relatedIds = relatedIds;
		this.isHasTitleimg = isHasTitleimg;
		this.isAllowComment = isAllowComment;
		this.isBold = isBold;
		this.isDraft = isDraft;
		this.isRecommend = isRecommend;
		this.isCheck = isCheck;
		this.isDisabled = isDisabled;
		this.isReject = isReject;
		this.createUser = createUser;
		this.createTime = createTime;
		this.cmsComments = cmsComments;
	}

	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ATTR_ID")
	
	public CmsArticleAttr getCmsArticleAttr() {
		return this.cmsArticleAttr;
	}

	public void setCmsArticleAttr(CmsArticleAttr cmsArticleAttr) {
		this.cmsArticleAttr = cmsArticleAttr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHANNEL_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public CmsChannel getCmsChannel() {
		return this.cmsChannel;
	}

	public void setCmsChannel(CmsChannel cmsChannel) {
		this.cmsChannel = cmsChannel;
	}

	@Column(name = "PRE_ID", precision = 20, scale = 0)
	public int getPreId() {
		return this.preId;
	}

	public void setPreId(int preId) {
		this.preId = preId;
	}

	@Column(name = "NEXT_ID", precision = 20, scale = 0)
	public int getNextId() {
		return this.nextId;
	}

	public void setNextId(int nextId) {
		this.nextId = nextId;
	}

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    @Lob
    @Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "SHORT_TITLE", length = 50)
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

	@Column(name = "CREATE_TIME", length = 20)
	public String getCreateTime() {
		return this.createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATE_USER_ID")
	public SysUser getCreateUser() {
		return createUser;
	}

	public void setCreateUser(SysUser createUser) {
		this.createUser = createUser;
	}
	@Column(name = "REMARK", length = 256)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmsArticle")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public Set<CmsComment> getCmsComments() {
		return this.cmsComments;
	}

	public void setCmsComments(Set<CmsComment> cmsComments) {
		this.cmsComments = cmsComments;
	}

}
