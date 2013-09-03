package com.ccloudedu.oa.work.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.oa.work.entity.OaProject;
import com.ccloudedu.oa.work.service.OaProjectService;

@Scope("prototype")
@Controller("oa.work.action.OaProjectAction")
public class OaProjectAction  extends BaseUploadFileAction<OaProject> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private OaProject oaProject;
	private Page page = new Page(Constants.PAGE_SIZE);
	@Autowired
	private OaProjectService oaProjectService;

	public OaProject getModel() {
		
		return oaProject;
	}
	
	@Override
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			oaProject = new OaProject();
			oaProject.setCreateTime(DateUtils.getCurrentDate("yyyy-MM-dd"));
			oaProject.setCreator(Sessions.getSysUser());
		}
		else{
			oaProject = oaProjectService.get(id);
			setUploadFileList(getUploadFileService().findByOwnerId(id));
		}
	}
	
	@Override
	public String add() throws Exception {
		
		return ADD;
	}
	
	@Override
	public String update() throws Exception {
		
		return ADD;
	}

	@Override
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		oaProjectService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	/**
	 * 新增或修改项目
	 */
	@Override
	public String save() throws Exception {
		String uploadPath = "uploadfile/oa/project";
		oaProjectService.save(oaProject,uploadPath,getUpload(),getUploadFileName(),getUploadContentType());
		Renders.renderJson(StringUtils.isBlank(id)?Renders.SAVE_SUCCESS:Renders.UPDATE_SUCCESS);
		return NONE;
	}
	@Override
	public String detail() throws Exception {
		
		return NONE;
	}

	@Override
	@Menu
	public String list() throws Exception {
		page = oaProjectService.findPage(page, "oa.findProjects",null);
		return LIST;
	}
	
	public String chooseProject() throws Exception {
		page = oaProjectService.findPage(page,"oa.findProjects",null);
		return "chooseProject";
	}
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setOaProjectService(OaProjectService oaProjectService) {
		this.oaProjectService = oaProjectService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OaProject getOaProject() {
		return oaProject;
	}

	public void setOaProject(OaProject oaProject) {
		this.oaProject = oaProject;
	}
}
