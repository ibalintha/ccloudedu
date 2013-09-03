package com.ccloudedu.oa.work.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.dao.utils.Querys;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.oa.work.entity.OaProject;
import com.ccloudedu.oa.work.entity.OaProjectSchedule;
import com.ccloudedu.oa.work.service.OaProjectScheduleService;
import com.ccloudedu.oa.work.service.OaProjectService;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.RoleService2;

@Scope("prototype")
@Controller("oa.work.action.OaProjectScheduleAction")
public class OaProjectScheduleAction extends BaseUploadFileAction<OaProjectSchedule> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String projectId;
	private OaProject oaProject;
	private OaProjectSchedule oaProjectSchedule;
	private List<OaProjectSchedule> oaProjectScheduleList;
	private Page page = new Page(Constants.PAGE_SIZE);
	private List<SysRole> roleList;
	
	//项目参与人信息
	private List<String> descriptions;//描述
	private List<String> startDts;//开始时间
	private List<String> endDts;//结束时间
	private List<String> userIds;//参与人
	private List<String> roleIds;//参与人角色
	
	@Autowired
	private OaProjectService oaProjectService;
	@Autowired
	private OaProjectScheduleService oaProjectScheduleService;
	@Autowired
	private RoleService2 roleService;

	public OaProjectSchedule getModel() {
		
		return oaProjectSchedule;
	}
	
	@Override
	public void prepareModel() throws Exception {
		oaProject = oaProjectService.get(projectId);
		if(StringUtils.isBlank(id)){
			oaProjectSchedule = new OaProjectSchedule();
			oaProjectSchedule.setCreateTime(DateUtils.getCurrentDate("yyyy-MM-dd"));
			oaProjectSchedule.setCreator(Sessions.getSysUser());
			oaProjectSchedule.setOaProject(oaProject);
		}
		else{
			oaProjectSchedule = oaProjectScheduleService.get(id);
			setUploadFileList(getUploadFileService().findByOwnerId(id));
		}
	}
	
	@Override
	public String add() throws Exception {
		
		return ADD;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String update() throws Exception {
		if(StringUtils.isNotBlank(id)){
			setUploadFileList(getUploadFileService().findByOwnerId(id));
		}
		roleList = roleService.findRoles(new FastMap().newHashMap().set(Querys.PREFIX+"existedParentRole", true));
		return "schedule";
	}

	@SuppressWarnings("unchecked")
	public String completedSchedule()throws Exception{
		oaProject = oaProjectService.get(projectId);
		oaProjectScheduleList = oaProjectScheduleService.findList("oa.findProjectSchedules",new FastMap().newHashMap().set("projectId", projectId));
		return "completedSchedule";
	}
	@Override
	public String delete() throws Exception {
		
		return NONE;
	}

	/**
	 * 新增或修改项目阶段设置
	 */
	@Override
	public String save() throws Exception {
		String uploadPath="uploadfile/oa/projectSchedule";
		
		oaProjectScheduleService.save(oaProject,oaProjectSchedule,roleIds,userIds,startDts,endDts,descriptions,
				uploadPath,getUpload(),getUploadFileName(),getUploadContentType());
		Renders.renderJson(StringUtils.isBlank(id)?Renders.SAVE_SUCCESS:Renders.UPDATE_SUCCESS);
		return NONE;
	}
	
	@Override
	public String detail() throws Exception {
		
		return NONE;
	}

	@Override
	public String list() throws Exception {
		page = oaProjectService.findPage(page, "oa.findProjects",null);
		return LIST;
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

	public OaProjectSchedule getOaProjectSchedule() {
		return oaProjectSchedule;
	}

	public void setOaProjectSchedule(OaProjectSchedule oaProjectSchedule) {
		this.oaProjectSchedule = oaProjectSchedule;
	}

	public void setOaProjectScheduleService(
			OaProjectScheduleService oaProjectScheduleService) {
		this.oaProjectScheduleService = oaProjectScheduleService;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public void setRoleService(RoleService2 roleService) {
		this.roleService = roleService;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public List<String> getStartDts() {
		return startDts;
	}

	public void setStartDts(List<String> startDts) {
		this.startDts = startDts;
	}

	public List<String> getEndDts() {
		return endDts;
	}

	public void setEndDts(List<String> endDts) {
		this.endDts = endDts;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public List<OaProjectSchedule> getOaProjectScheduleList() {
		return oaProjectScheduleList;
	}

	public void setOaProjectSchedules(List<OaProjectSchedule> oaProjectScheduleList) {
		this.oaProjectScheduleList = oaProjectScheduleList;
	}
}
