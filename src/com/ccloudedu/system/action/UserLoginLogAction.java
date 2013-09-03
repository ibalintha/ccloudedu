package com.ccloudedu.system.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.system.entity.UserLoginLog;
import com.ccloudedu.system.service.UserLoginLogService;
/**
 * 用户登录日志
 * @author wade
 */
@Controller("system.action.UserLoginLogAction")
@Scope("prototype")
public class UserLoginLogAction extends BaseCrudAction<UserLoginLog>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserLoginLog userLog;
	//每页显示10条记录
    private Page page = new Page(Constants.PAGE_SIZE);
	@Autowired
    private UserLoginLogService userLoginLogService;
	//查询参数
	private String loginUserName;
	private String startLoginTime;
	private String endLoginTime;

	public UserLoginLog getModel() {
		return userLog;
	}
	public String delete() throws Exception {
		return NONE;
	} 
	public void prepareModel() throws Exception {
	
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	@Override
	public String add() throws Exception {
		
		return NONE;
	}
	public String save() throws Exception {
		return NONE;
	}
	@Override
	public String update() throws Exception {
		
		return NONE;
	}
	@SuppressWarnings("unchecked")
	@Menu
	public String list() throws Exception {
		Map<String,String> paramMap = (Map<String, String>) Servlets.getParameters("page");
		//查询参数loginUserName单独处理下
		paramMap.put("loginUserName", "%"+loginUserName+"%");
		page = userLoginLogService.findPage(page, "system.userLoginLog.findPage",paramMap);
		return LIST;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public String getLoginUserName() {
		return loginUserName;
	}
	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
	
	public String getStartLoginTime() {
		return startLoginTime;
	}
	public void setStartLoginTime(String startLoginTime) {
		this.startLoginTime = startLoginTime;
	}
	public String getEndLoginTime() {
		return endLoginTime;
	}
	public void setEndLoginTime(String endLoginTime) {
		this.endLoginTime = endLoginTime;
	}
}
