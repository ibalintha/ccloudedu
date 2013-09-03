package com.ccloudedu.cms.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.FileUpload;
import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.cms.entity.CmsArticle;
import com.ccloudedu.cms.entity.CmsArticleAttr;
import com.ccloudedu.cms.entity.CmsChannel;
import com.ccloudedu.cms.service.ArticleService;
import com.ccloudedu.cms.service.ChannelService;

@Controller("cms.ArticleAction")
@Scope("prototype")
public class ArticleAction extends BaseUploadFileAction<CmsArticle>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long articleId;
	private String channelId;
	private CmsArticle article;
	private CmsChannel channel;
	private List<CmsChannel> channelList;
	private List<CmsArticleAttr> articleAttrList;
	private Page page = new Page(Constants.PAGE_SIZE);
	
	//private String fckContent;
	//private String fckContentPath;
    //查询条件
    private String title;
    private String isDraft;
    
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChannelService channelService;

	public CmsArticle getModel() {
		return article;
	}
	@Override
	public void prepareModel() throws Exception {
	    channel = channelService.get(channelId);
		if(articleId==0){
			article = new CmsArticle();
			article.setCreateTime(DateUtils.getCurrentDate());
			//article.setCreateUser(UserSession.getSysUser());
			article.setCmsChannel(channel);
		}else{
			article = articleService.get(articleId);
		}		
		//临时设置发布时间
		article.setReleaseDate(article.getCreateTime());
		//setFckContentPath("/fckcontent/cms/content/"+channel.getPath()+"/");
	}
    @Override
    public String detail() throws Exception {
		return DETAIL;
	}
	public String update() throws Exception {
		 return ADD;
	}
   public String add() throws Exception {
       channel = channelService.get(channelId);
       return ADD;
    }
	
   @FileUpload(filePath="uploadfile/cms/article/picture",isRecordToDB=false)
	public String save() throws Exception {
	    //上传的图片
		if(getUploadFileName()!=null && getUploadFileName().size()>0){
			String picPath = "/uploadfile/cms/article/picture/"+getUploadFileName().get(0);
			article.setContentImg(picPath);
		}
		if(StringUtils.isEmpty(article.getContentImg())){
			article.setContentImg(null);
		 }
	 	if(articleId==0){
		     articleService.createStaticPage(article,articleId);
			 Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			 articleService.createStaticPage(article,articleId);
			 Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
   
   /**
    * 
    */
	public String delete() throws Exception {
		String[] strids = Servlets.getRequest().getParameter("ids").split(",");
		articleService.deleteAndUpdatePage(strids);
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}
	/**
	 * 删除图片
	 * @return
	 * @throws Exception
	 */
	public String deleteUploadFile() throws Exception {
		article = articleService.get(articleId);
		String contentImg = article.getContentImg();
		File file = new File(Servlets.getServletContext().getRealPath("")+"/"+contentImg);   
		file.delete();
		
		article.setContentImg("");
		articleService.update(article);
		Renders.renderJson(Renders.DELETE_SUCCESS);
        return NONE;
	}
	
	@Override
	public String list() throws Exception {
		try {
			Map<String,String> paramMap = new HashMap<String, String>();
			if(!"1".equals(channelId)){
				paramMap.put("channelId", channelId);
				paramMap.put("title", title);
				paramMap.put("isDraft", isDraft);
			}
			page = articleService.findPage(page,paramMap);
			channel = channelService.get(channelId);
		} catch (Exception e) {
			addActionMessage("文章系统尚未初始化");
		}
		return LIST;
	}
	
	
	public String release() throws Exception {
		String[] ids = Servlets.getRequest().getParameter("ids").split(",");
		String isDraft = Servlets.getRequest().getParameter("isDraft");
		for(String id : ids){
			article = articleService.get(id);
			article.setIsDraft(isDraft);
			articleService.update(article);
			//articleService.createStaticPage();
		}
		return list();
	}
	
	@SuppressWarnings("unchecked")
	@Menu
	public String tree() throws Exception {
		channelList = channelService.findList("cms.findChannels",null);
		return TREE;
	}

	@SuppressWarnings("unchecked")
	public String generateChannelTree() throws Exception {
		channelList = channelService.findList("cms.findChannels",null);
		return "left";
	}
	
	/**
	 * 首页管理
	 * @return
	 */
	public String managerHomePage(){
		return "managerHomePage";
	}
	//----------------------getter/setter方法------------------------------
	public String getChannelId() {
		return channelId;
	}

	public long getArticleId() {
		return articleId;
	}
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public List<CmsChannel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<CmsChannel> channelList) {
		this.channelList = channelList;
	}
	public List<CmsArticleAttr> getArticleAttrList() {
		return articleAttrList;
	}
	public void setArticleAttrList(List<CmsArticleAttr> articleAttrList) {
		this.articleAttrList = articleAttrList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}
	/*public void setChannelModelService(ChannelModelService channelModelService) {
		this.channelModelService = channelModelService;
	}*/
	public CmsChannel getChannel() {
		return channel;
	}
	public void setChannel(CmsChannel channel) {
		this.channel = channel;
	}
	/*public String getFckContent() {
		return fckContent;
	}
	public void setFckContent(String fckContent) {
		this.fckContent = fckContent;
	}
	public String getFckContentPath() {
		return fckContentPath;
	}
	public void setFckContentPath(String fckContentPath) {
		this.fckContentPath = fckContentPath;
	}
    */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsDraft() {
		return isDraft;
	}
	public void setIsDraft(String isDraft) {
		this.isDraft = isDraft;
	}
	
}
