package com.ccloudedu.system.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.dao.utils.Querys;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.utils.string.EncodeUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.system.entity.SysDept;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.DeptService;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.RoleService2;
import com.ccloudedu.system.service.UserService;

/**
 * 用户管理
 * @author wade
 * 2009-03-29 中午12点
 */
@Controller("system.action.UserAction")
@Scope("prototype")
public class UserAction extends BaseUploadFileAction<SysUser>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysUser user;
	//用户id
	private String id;
	private String userName;
	private String deptId;
	private String deptName;
	private String roleId;
	private String roleIds="";
	private String roleNames="";
	private String enRoleNames="";
	private String pictureOnly="";
	
	//修改密码
	private String oldPassword;
	private String newPassword;
	
	private List<SysDept> deptList;
	private List<SysRole> roleList;
	
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService2 roleService;
	
	private Page page = new Page(Constants.PAGE_SIZE);
	
	public SysUser getModel() {
		return user;
	}
	@SuppressWarnings("unchecked")
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			user = new SysUser();
			user.setCreateTime(DateUtils.getCurrentDate());
			//user.setCreateUser(this.UserSession.getSysUser());
		}else{
			user = userService.get(id);
			deptList = deptService.findListByDeptLevel();
			roleList = roleService.findRoles(new FastMap().newHashMap().set(Querys.PREFIX+"existedParentRole", true));
			List<SysRole> roleList = user.getSysRoles();
			if(roleList!=null && roleList.size()>0){
				for(SysRole role : roleList){
					roleNames+=","+role.getRoleName();
					enRoleNames+=","+role.getEnRoleName();
					roleIds+=","+role.getId();
				}
				roleNames = roleNames.replaceFirst(",", "");
				enRoleNames = enRoleNames.replaceFirst(",", "");
				roleIds = roleIds.replaceFirst(",", "");
			}
		}
	}
	
	/**
	 * 用户列表
	 * @return
	 * @throws Exception 
	 */
	 @SuppressWarnings("unchecked")
	@Menu
     public String list() throws Exception{
		deptList = deptService.findListByDeptLevel();
		roleList = roleService.findRoles(new FastMap().newHashMap().set(Querys.PREFIX+"existedParentRole", true));
			
		page = userService.findUsers(page, deptId,roleIds,userName,null);
		return LIST;
	}
	
	 /**
	  * 个人设置中 个人基本信息
	  * @return
	 * @throws Exception 
	  * @throws Exception
	  */
	 @Menu
	 public String toUserBasicInfo() throws Exception{
		 user =  userService.get(Sessions.getSysUser().getId());
		 getUserInfo();
		 return "userBasicInfo";
	 }
	 /**
	  * 在线用户中 查看用户信息
	  * @return
	  * @throws Exception
	  */
	 public String showUserInfo() throws Exception{
		 user =  userService.get(getId());
		 getUserInfo();
		 return "showUserInfo";
	 }
	/**
	 * 更新用户个人信息
	 * @throws Exception
	 */
	public void prepareUpdateUserBasicInfo() throws Exception {
		 user = userService.get(id);
	}

	 public String updateUserBasicInfo() throws Exception{
		String uploadPath = "uploadfile/system/user";
		userService.update(user,uploadPath,getUpload(),getUploadFileName(),getUploadContentType());
		Renders.renderJson(Renders.UPDATE_SUCCESS);
	    return NONE;
	 }
	 /**
	  * 头像照片
	  * @return
	 * @throws Exception 
	  */
	 @Menu
	 public String toUserPicture() throws Exception{
		 setUploadFileList(getUploadFileService().findByOwnerId(Sessions.getSysUser().getId()));
		 return "userPicture";
	 }
	
	 public String uploadUserPicture() throws Exception{
		 user = userService.get(user.getId());
		 String uploadPath = "uploadfile/system/user";
		 userService.update(user,uploadPath,getUpload(),getUploadFileName(),getUploadContentType());
		 return toUserPicture();
	 }
	 
	public String deleteUserPicture() throws Exception{
		this.deleteUploadFile();
		if("yes".equals(pictureOnly)){
			return toUserPicture();
		}
    	return toUserBasicInfo();
	 }
	
	@Menu
	public String toUpdatePassword() throws Exception {
		return "updatePassword";
	}
	
	public String updatePassword() throws Exception {
		user = Sessions.getSysUser();
        if(!EncodeUtils.isValidMd5(user.getPassWord(),oldPassword)){
        	Renders.renderJson(new EasyUiResult("旧密码不正确"));
        }else{
        	user.setPassWord(EncodeUtils.encodeMd5(newPassword));
        	userService.update(user);
        	Renders.renderJson(new EasyUiResult("密码修改成功，重新登录生效"));
        }
		return NONE;
	}
	@Menu
	public String toSetDesk() throws Exception {
		user =  userService.get(Sessions.getSysUser().getId());
		//如果用户没有设置桌面，则使用该用户所属角色的桌面
		if(StringUtils.isEmpty(user.getMyselfDesk())){
			user.setMyselfDesk(Sessions.getSysUser().getSysRole().getDeskSetting());
		}
		return "setDesk";
	}
	
	public void prepareSetDesk() throws Exception {
		user = userService.get(id);
	}
	
	public String setDesk() throws Exception {
		userService.update(user);
		Renders.renderJson(new EasyUiResult("设置成功"));
		return NONE;
	}
	
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	/**
	 * 进入新增用户页
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String add() throws Exception{
		deptList = deptService.findListByDeptLevel();
		roleList = roleService.findRoles(new FastMap().newHashMap().set(Querys.PREFIX+"existedParentRole", true));
		return ADD;
	}

	/**
	 * 查看用户详情
	 */
	public String update(){
		
		return UPDATE;
	}
	
	/**
	 * 新增用户
	 * @return
	 * @throws Exception 
	 */
	public String save() throws Exception{
		
		String[] roleIds = getRoleIds().split(",");
		List<SysRole> roleList = new ArrayList<SysRole>();
		SysRole role = null;
		for(String roleId : roleIds){
			role = new SysRole();
			role.setId(roleId);
			roleList.add(role);
		}
		if(roleList!=null && roleList.size()>0){
			user.setSysRoles(roleList);
		}
		if(StringUtils.isBlank(id)){
			//设置用户的主要部门和主要角色
			user.setSysDept(deptService.get(deptId));
			//user.setSysRole(roleService.get(roleId));
			user.setPassWord(EncodeUtils.encodeMd5(user.getPassWord()));
			userService.save(user);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			user.setSysDept(deptService.get(deptId));
			userService.update(user);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	
	public String resetPassword() throws Exception{
		user = userService.get(id);
		user.setPassWord(EncodeUtils.encodeMd5("123456"));
		userService.update(user);
		Renders.renderJson(new EasyUiResult("密码重置成功"));
		return NONE;
	}
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		userService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}
	/**
	 * 选择用户
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String chooseUser() throws Exception {
		deptList = deptService.findListByDeptLevel();
		roleList = roleService.findRoles(new FastMap().newHashMap().set(Querys.PREFIX+"existedParentRole", true));
		page = userService.findUsers(page, deptId,roleIds, userName,null);
		return "chooseUser";
	}
	
	@SuppressWarnings("unchecked")
	public String getUserByAjax() throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap().set("userName", "%"+userName+"%");
		List<SysUser> userList = userService.findList("system.findUsers", paramMap);
		List<SysUser> jsonList = new ArrayList<SysUser>();
		if(userList!=null && userList.size()>0){
			for(SysUser u : userList){
				user = new SysUser();
				user.setId(u.getId());
				user.setUserName(u.getUserName());
				jsonList.add(user);
			}
		}
		Renders.renderJson(jsonList);
		return NONE;
	}

	//exportExcelDetail  exportPdfDetail

	 private void getUserInfo() throws Exception{
		  setUploadFileList(getUploadFileService().findByOwnerId(user.getId()));
		  List<SysRole> roleList = user.getSysRoles();
		  if(roleList!=null && roleList.size()>0){
			  for(SysRole role : roleList){
				 roleNames+=","+role.getRoleName();
				 roleIds+=","+role.getId();
		      }
		     roleNames = roleNames.replaceFirst(",", "");
		     roleIds = roleIds.replaceFirst(",", "");
		 } 
	 }
	//------------------------------getter/setter方法----------------------------------

	public String getDeptId() {
		return deptId;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public List<SysDept> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<SysDept> deptList) {
		this.deptList = deptList;
	}
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPictureOnly() {
		return pictureOnly;
	}
	public void setPictureOnly(String pictureOnly) {
		this.pictureOnly = pictureOnly;
	}
	public String getEnRoleNames() {
		return enRoleNames;
	}
	public void setEnRoleNames(String enRoleNames) {
		this.enRoleNames = enRoleNames;
	}
}
