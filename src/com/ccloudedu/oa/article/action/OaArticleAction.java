package com.ccloudedu.oa.article.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.LoginValidation;
import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.oa.article.entity.OaArticle;
import com.ccloudedu.oa.article.service.OaArticleService;
import com.ccloudedu.system.entity.SysDataDictionary;
import com.ccloudedu.system.service.DataDictionaryService;
/**
 * 后台信息发布
 * @author wade
 *
 */
@Scope("prototype")
@Controller("oa.article.action.OaArticleAction")
public class OaArticleAction extends BaseUploadFileAction<OaArticle> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int visitPageNum=1;
	private String categoryValue;
	private Page page = new Page(Constants.PAGE_SIZE);
	private OaArticle oaArticle;
	private List<SysDataDictionary> ddList;
	
	@Autowired
	private OaArticleService oaArticleService;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	public OaArticle getModel() {
		return oaArticle;
	}
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			oaArticle = new OaArticle();
			oaArticle.setCreateTime(DateUtils.getCurrentDate());
			oaArticle.setCreateUser(Sessions.getSysUser());
			oaArticle.setCategoryValue(categoryValue);
		}else{
			oaArticle = oaArticleService.get(id);
			setUploadFileList(getUploadFileService().findByOwnerId(id));
		}		
	}
	
	public String add() throws Exception {
		return ADD;
	}
	public String update() throws Exception {
		 return ADD;
	}
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		oaArticleService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	public String list() throws Exception {
		if("oaarticle".equals(categoryValue)){
			categoryValue=null;
		}
		page = oaArticleService.findPage(page,categoryValue,"");
		return LIST;
	}

	public String save() throws Exception {
		
		String uploadPath = "uploadfile/oa/article/picture";
		
		//上传的图片
		if(getUploadFileName()!=null && getUploadFileName().size()>0){
			String picPath = uploadPath+"/"+getUploadFileName().get(0);
			oaArticle.setContentImg(picPath);
		}
		if(StringUtils.isEmpty(oaArticle.getContentImg())){
			oaArticle.setContentImg(null);
		 }
	 	if(StringUtils.isBlank(id)){
	 		oaArticleService.createStaticPage(oaArticle,id);
			 Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			oaArticleService.createStaticPage(oaArticle,id);
			 Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	
	public String detail() throws Exception {
		
		return NONE;
	}
	
	/**
	 * 获得/更新访问次数
	 * @return
	 * @throws Exception
	 */
	@LoginValidation(validate=YN.N)
	public String visitQuarter() throws Exception {
		oaArticle = oaArticleService.get(id);
		Renders.renderJson(oaArticle.getVisitQuarter()+"");
		if(visitPageNum==1){
			oaArticle.setVisitQuarter(oaArticle.getVisitQuarter()+1);
			oaArticleService.update(oaArticle);
		}
		return NONE;
	}
	
	public String deleteImg() throws Exception{
		deleteUploadFile();
		oaArticle = oaArticleService.get(id);
		oaArticle.setContentImg(null);
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}
	@SuppressWarnings("unchecked")
	@Menu
	public String tree() throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("undefined1", "oaarticle");
		ddList = dataDictionaryService.findList("system.findDataDictionarys",paramMap);
		return TREE;
	}

	/**----------------------------------以下是getter/setter方法-------------------------------------------------------*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<SysDataDictionary> getDdList() {
		return ddList;
	}
	public void setDdList(List<SysDataDictionary> ddList) {
		this.ddList = ddList;
	}
	public String getCategoryValue() {
		return categoryValue;
	}

	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public int getVisitPageNum() {
		return visitPageNum;
	}
	public void setVisitPageNum(int visitPageNum) {
		this.visitPageNum = visitPageNum;
	}
}
