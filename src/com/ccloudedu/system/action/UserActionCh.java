package com.ccloudedu.system.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.ccloudedu.common.entity.ChRange;
import com.ccloudedu.common.entity.ChRole;
import com.ccloudedu.common.entity.ChRolebutton;
import com.ccloudedu.common.entity.ChTeacher;
import com.ccloudedu.common.entity.ChUser;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.ButtonService;
import com.ccloudedu.system.service.RangeService;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.TeacherService;
import com.ccloudedu.system.service.UserServiceCh;

/**
 * 用户管理
 * 
 * @author xubo
 * 2013-07-08
 */
@Controller("system.action.UserActionCh")
@Scope("prototype")
public class UserActionCh extends BaseUploadFileAction<ChUser>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChUser user;
	//用户id
	private String id;
	private String userName;
	private String deptId;
	private String deptName;
	private String roleId;
	private String roleIds="";
	private String funcIds="";
	private String roleNames="";
	private String enRoleNames="";
	private String pictureOnly="";
	private String teacherId="";
	
	//修改密码
	private String oldPassword;
	private String newPassword;
	
//	private List<SysDept> deptList;
	private List<ChRole> roleList;
	private List<ChTeacher> teacherList;
	private List<ChRange> rangeList;
	private List<ChRolebutton> chRolebuttons;
	
	@Autowired
	private UserServiceCh userService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private RangeService rangeService;
	@Autowired
	private ButtonService buttonService;
	@Autowired
	private RoleService roleService;
	
	private Page page = new Page(Constants.PAGE_SIZE);
	
	public ChUser getModel() {
		return user;
	}

	@SuppressWarnings("unchecked")
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			user = new ChUser();
			user.setChUserMaketime(DateUtils.getCurrentDate());
			//user.setCreateUser(this.UserSession.getSysUser());
		}else{
			user = userService.get(id);
			teacherList = teacherService.findTeachers();
			roleList = roleService.findRoles(new FastMap().newHashMap().set(
					Querys.PREFIX + "existedParentRole", true));
			roleIds = user.getChUserRoleids();
			funcIds = user.getChUserFuncs();
		}
	}
	
	/**
	 * 用户列表 2013-7-16:用户和用户拥有角色名称查询
	 * @author xubo
	 * @return
	 * @throws Exception 
	 */
	 @SuppressWarnings("unchecked")
	@Menu
     public String list() throws Exception{
		 try{
			setId(id);
			String chUserLogName = Servlets.getRequest().getParameter("chUserLogName");
			Map<String,String> paramMap = new FastMap().newHashMap().set("parentId", id).set("userName", userName).set("loginName", chUserLogName);
			page = roleService.findPage(page,"system.findChUsers",paramMap);
			List<ChUser> userList = page.getList();
			for (ChUser usr : userList) {
				List<ChRole> chRoles = new ArrayList<ChRole>(0);
				String roleIds = usr.getChUserRoleids();
				if (roleIds != null) {
					String[] roleID = roleIds.split(", ");
					for (String roleid : roleID) {
						ChRole cR = roleService.get(roleid);
						chRoles.add(cR);
					}
					usr.setChRoles(chRoles);
				}
			}
			chRolebuttons = buttonService.getButtonsByRoleAndFunc("用户管理");
		}catch (Exception e) {
				addActionMessage("查询异常");
		}
		return LIST;
	}
	
	


	 
	 
	 /**
	  * 个人设置中 个人基本信息
	 * 
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
	 * 
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
	 * 
	 * @throws Exception
	 */
	public void prepareUpdateUserBasicInfo() throws Exception {
		 user = userService.get(id);
	}

	 public String updateUserBasicInfo() throws Exception{
		String uploadPath = "uploadfile/system/user";
		userService.update(user, uploadPath, getUpload(), getUploadFileName(),
				getUploadContentType());
		Renders.renderJson(Renders.UPDATE_SUCCESS);
	    return NONE;
	 }

	 /**
	  * 头像照片
	 * 
	  * @return
	 * @throws Exception 
	  */
	 @Menu
	 public String toUserPicture() throws Exception{
		setUploadFileList(getUploadFileService().findByOwnerId(
				Sessions.getSysUser().getId()));
		 return "userPicture";
	 }
	
	 public String uploadUserPicture() throws Exception{
		 user = userService.get(user.getId());
		 String uploadPath = "uploadfile/system/user";
		userService.update(user, uploadPath, getUpload(), getUploadFileName(),
				getUploadContentType());
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
//		user = Sessions.getSysUser();
        if(!EncodeUtils.isValidMd5(user.getChUserPassword(),oldPassword)){
        	Renders.renderJson(new EasyUiResult("旧密码不正确"));
        }else{
        	user.setChUserPassword(EncodeUtils.encodeMd5(newPassword));
        	userService.update(user);
        	Renders.renderJson(new EasyUiResult("密码修改成功，重新登录生效"));
        }
		return NONE;
	}

//	@Menu
//	public String toSetDesk() throws Exception {
//		user =  userService.get(Sessions.getSysUser().getId());
//		//如果用户没有设置桌面，则使用该用户所属角色的桌面
//		if(StringUtils.isEmpty(user.getMyselfDesk())){
//			user.setMyselfDesk(Sessions.getSysUser().getSysRole().getDeskSetting());
//		}
//		return "setDesk";
//	}
	
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
	 * 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String add() throws Exception{
		teacherList = teacherService.findTeachers();
		roleList = roleService.findRoles(new FastMap().newHashMap().set(
				Querys.PREFIX + "existedParentRole", true));
		return ADD;
	}

	/**
	 * 查看用户详情
	 */
	public String update(){
		return UPDATE;
	}
	
	/*
	 *密码初始化 跳转页面
	 */
	public String setPwdRule(){
		return "setInitPwd";
	}
	
	/*
	 * 密码初始化实现 0：采用固定方式生成密码123456 1：采用身份证后8位 2：采用随机生成6位密码 3：以登录账户为密码
	 */
	public String initPassword() throws Exception {
		String ruleId=Servlets.getRequest().getParameter("setInitPwd");
		user = userService.get(id);
		if(ruleId.equals("0")){
			user.setChUserPassword(EncodeUtils.encodeMd5("123456"));	
		}else if(ruleId.equals("1")){
			ChTeacher chTeacher=teacherService.get(user.getChTeacher().getId());
			String teacherID=chTeacher.getChTeacPersonid();
			user.setChUserPassword(EncodeUtils.encodeMd5(teacherID.substring(teacherID.length()-8,teacherID.length())));	
		}else if(ruleId.equals("2")){
			user.setChUserPassword(EncodeUtils.encodeMd5(genRandomNum(6)));
		}else{
			user.setChUserPassword(EncodeUtils.encodeMd5(user
					.getChUserLogname()));
		}
		userService.update(user);
		Renders.renderJson(new EasyUiResult("密码重置成功"));
		return NONE;
	}
	
	/**
	  * 生成随即密码
	 * 
	 * @param pwd_len
	 *            生成的密码的总长度
	  * @return  密码的字符串
	  */
	 public  String genRandomNum(int pwd_len){
	  //35是因为数组是从0开始的，26个字母+10个数字
	  final int  maxNum = 36;
	  int i;  //生成的随机数
	  int count = 0; //生成的密码的长度
	  char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
	    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
	    'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	  
	  StringBuffer pwd = new StringBuffer("");
	  Random r = new Random();
	  while(count < pwd_len){
	   //生成随机数，取绝对值，防止生成负数，
	   i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1
	   if (i >= 0 && i < str.length) {
		    pwd.append(str[i]);
		    count ++;
	   }
	  }
	  System.out.println("随机生成密码："+pwd.toString());
	  return pwd.toString();
	 }
	
	/**
	 * 改变用户状态
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
    public String changeUserState() throws Exception {
		user = userService.get(id);
		userService.changeUserState(user);
		
		roleList = roleService.findRoles(new FastMap().newHashMap().set(
				Querys.PREFIX + "existedParentRole", true));
		page = userService.findUsers(page, roleIds,userName,null);
		List<ChUser> userList = page.getList();
		for (ChUser usr : userList) {
			List<ChRole> chRoles = new ArrayList<ChRole>(0);
			String roleIds = usr.getChUserRoleids();
			if (roleIds != null) {
				String[] roleID = roleIds.split(", ");
				for (String roleid : roleID) {
					ChRole cR = roleService.get(roleid);
					chRoles.add(cR);
				}
				usr.setChRoles(chRoles);
			}
		}
		
		
		return LIST;
	}
	
	/**
	 * 新增用户
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String save() throws Exception{
		
		if(StringUtils.isBlank(id)){
			user.setChTeacher(teacherService.get(teacherId));
			user.setChUserPassword(EncodeUtils.encodeMd5(user
					.getChUserPassword()));
			userService.saveOrUpdate(user, funcIds, roleIds);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			user.setChTeacher(teacherService.get(teacherId));
			String userPWD = Servlets.getRequest().getParameter(
					"chUserPassword2");
			if(!userPWD.equals("")){//修改了密码
				user.setChUserPassword(EncodeUtils.encodeMd5(userPWD));
			}
			System.out.println(funcIds+" "+roleIds);
			userService.saveOrUpdate(user, funcIds, roleIds);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	
	public String resetPassword() throws Exception{
		user = userService.get(id);
		user.setChUserPassword(EncodeUtils.encodeMd5("123456"));
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
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String chooseUser() throws Exception {
//		deptList = deptService.findListByDeptLevel();
		roleList = roleService.findRoles(new FastMap().newHashMap().set(
				Querys.PREFIX + "existedParentRole", true));
		page = userService.findUsers(page,roleIds, userName,null);
		return "chooseUser";
	}
	
	@SuppressWarnings("unchecked")
	public String getUserByAjax() throws Exception{
		Map<String, String> paramMap = new FastMap().newHashMap().set(
				"userName", "%" + userName + "%");
		List<SysUser> userList = userService.findList("system.findUsers",
				paramMap);
		List<SysUser> jsonList = new ArrayList<SysUser>();
		if(userList!=null && userList.size()>0){
			for(SysUser u : userList){
				user = new ChUser();
				user.setId(u.getId());
				user.setChUsername(u.getUserName());
//				jsonList.add(user);
			}
		}
		Renders.renderJson(jsonList);
		return NONE;
	}

	//exportExcelDetail  exportPdfDetail

	 private void getUserInfo() throws Exception{
		  setUploadFileList(getUploadFileService().findByOwnerId(user.getId()));
		  List<SysRole> roleList = null;//user.getSysRoles();
		  if(roleList!=null && roleList.size()>0){
			  for(SysRole role : roleList){
				 roleNames+=","+role.getRoleName();
				 roleIds+=","+role.getId();
		      }
		     roleNames = roleNames.replaceFirst(",", "");
		     roleIds = roleIds.replaceFirst(",", "");
		 } 
	 }
	 
	 /**
	  * 有角色ID获取权限范围
	 * 
	  * @throws Exception
	  */
    @SuppressWarnings("unchecked")
    public String getRangeByRoleId() throws Exception {
		rangeList = rangeService.findList("system.findRanges", new FastMap()
				.newHashMap().set("roleId", roleId));
		 List<ChRange> jsonList = new ArrayList<ChRange>();
			if(rangeList!=null && rangeList.size()>0){
				for(ChRange r : rangeList){
					ChRange range = new ChRange();
					range.setId(r.getId());
					range.setChRangDesc(r.getChRangDesc());
					jsonList.add(range);
				}
			}
			Renders.renderJson(jsonList);
		 return NONE;
	 }

	 /**
	  * 根据用户登录名查找用户
	 * 
	  * @throws Exception
	  */
   @SuppressWarnings("unchecked")
   public String findUserByLogName() throws Exception {
	   Map<String, String> paramMap = new FastMap().newHashMap().set(
				"loginName", userName);
		List<ChUser> userList = userService.findList("system.findChUsers",paramMap);
		//List<SysUser> userList = userService.findList("system.findUsers",	paramMap);
		//List<SysUser> jsonList = new ArrayList<SysUser>();
		List<ChUser> jsonList = new ArrayList<ChUser>();
		if(userList!=null){
			for(ChUser user:userList){
				jsonList.add(user);
			}
		}
		Renders.renderJson(jsonList);
		 return NONE;
	 }
   
   public String showSearch() throws Exception {
		return "showSearch";
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

//	public List<SysDept> getDeptList() {
//		return deptList;
//	}
//	public void setDeptList(List<SysDept> deptList) {
//		this.deptList = deptList;
//	}
	public List<ChRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<ChRole> roleList) {
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

	public ChUser getUser() {
		return user;
	}

	public void setUser(ChUser user) {
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
	
	public List<ChTeacher> getTeacherList() {
    	return teacherList;
    }

	public void setTeacherList(List<ChTeacher> teacherList) {
    	this.teacherList = teacherList;
    }
	
	public List<ChRange> getRangeList() {
    	return rangeList;
    }

	public void setRangeList(List<ChRange> rangeList) {
    	this.rangeList = rangeList;
    }

	public String getFuncIds() {
    	return funcIds;
    }

	public void setFuncIds(String funcIds) {
    	this.funcIds = funcIds;
    }

	public String getTeacherId() {
    	return teacherId;
    }

	public void setTeacherId(String teacherId) {
    	this.teacherId = teacherId;
    }
	
	public List<ChRolebutton> getChRolebuttons() {
    	return chRolebuttons;
    }

	public void setChRolebuttons(List<ChRolebutton> chRolebuttons) {
    	this.chRolebuttons = chRolebuttons;
    }
}
