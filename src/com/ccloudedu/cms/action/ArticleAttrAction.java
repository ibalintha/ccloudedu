package com.ccloudedu.cms.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.cms.entity.CmsArticleAttr;
import com.ccloudedu.cms.service.ArticleAttrService;
@Controller("cms.ArticleAttrAction")
@Scope("prototype")
public class ArticleAttrAction extends BaseCrudAction<CmsArticleAttr> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CmsArticleAttr articleAttr;
	private String id;
	private Page page = new Page(Constants.PAGE_SIZE);
	@Autowired
	private ArticleAttrService articleAttrService;
	
	public CmsArticleAttr getModel() {
		return articleAttr;
	}
	@Override
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			articleAttr = new CmsArticleAttr();
			articleAttr.setCreateTime(DateUtils.getCurrentDate());
			articleAttr.setCreateUser(Sessions.getSysUser());
		}else{
			articleAttr = articleAttrService.get(id);
		}
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	 public String add() throws Exception {
			return ADD;
		}
		@Override
		public String save() throws Exception {
			
			if(StringUtils.isBlank(id)){
				articleAttrService.save(articleAttr);
				Renders.renderJson(Renders.SAVE_SUCCESS);
			}else{
				articleAttrService.update(articleAttr);
				Renders.renderJson(Renders.UPDATE_SUCCESS);
			}
			return NONE;
		}
		public String update()throws Exception{
			return ADD;
		}
		@Override
		public String delete() throws Exception {
			try{
				String[] ids = Servlets.getRequest().getParameterValues("ids");
				if(StringUtils.isNotBlank(id)){
					articleAttrService.deleteById(id);
					addActionMessage("删除成功");
				}else if(ids!=null && ids.length>0){
					List<CmsArticleAttr> list = articleAttrService.deleteByIds(ids);
					if(list!=null && list.size()==ids.length){
						addActionMessage("删除成功");
					}else{
						addActionMessage("删除失败");
					}
				}
			}catch (Exception e) {
				addActionMessage("不能删除该数据");
			}
			return list();
		}
	@Override
	public String list() throws Exception {
		page = articleAttrService.findPage(page, "cms.findArticleAttrs",null);
		return LIST;
	}
	public void setArticleAttrService(ArticleAttrService articleAttrService) {
		this.articleAttrService = articleAttrService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
