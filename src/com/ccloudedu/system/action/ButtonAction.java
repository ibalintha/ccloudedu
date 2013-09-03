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
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.common.entity.ChFunction;
import com.ccloudedu.common.entity.ChRole;
import com.ccloudedu.common.entity.ChRolebutton;
import com.ccloudedu.common.entity.ChRolefunc;
import com.ccloudedu.system.service.ButtonService;
import com.ccloudedu.system.service.FuncService;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.RolefuncService;
/**
 * 按钮管理action
 * @author yueyongsheng
 * 2013-07-25
 */
@Controller("system.action.ButtonAction")
@Scope("prototype")
public class ButtonAction extends BaseCrudAction<ChRolebutton> {

    private static final long serialVersionUID = 4263349098215921129L;

    private String id;
    private ChRolebutton roleButton;
    private List<ChFunction> funcList;
    private List<ChRolefunc> roleFuncList;
	private List<ChRole> roleList;
	private List<ChRolebutton> chRolebuttons;
	private ChRolebutton button;
	private String roleName;
	private String funcName;
	private Page page = new Page(Constants.PAGE_SIZE);
    
    @Autowired
    private RoleService roleService;
    @Autowired
    private ButtonService buttonService;
    @Autowired
	private RolefuncService rolefuncService;
    @Autowired
	private FuncService funcService;
    
	@Override
    public String add() throws Exception {
		String roleName = Servlets.getRequest().getParameter("roleName");
		String funcName = Servlets.getRequest().getParameter("funcName");
		this.setRoleName(roleName);
		this.setFuncName(funcName);
		
	    return ADD;
    }

	@Override
    public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		buttonService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
    }

	@Override
    public String detail() throws Exception {
	    return null;
    }
	
    public String tree() throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
    @Override
    @Menu
    public String list() throws Exception {
		this.setRoleName(roleName);
		this.setFuncName(funcName);
		List<ChRolefunc> chRolefuncs = getChRolefuncByRoleName(roleName);
		funcList = new ArrayList<ChFunction>();
		for (ChRolefunc rf : chRolefuncs){
			String funcPath = rf.getChFunc().getChFuncPath();
			if (!funcPath.equals("") && funcPath != "" && funcPath != null) 
				funcList.add(rf.getChFunc());
		}
		
		roleList = roleService.findList("system.findRoles", new FastMap().newHashMap().set("_query_existedParentRole", true));
		Map<String,String> paramMap = new FastMap().newHashMap().set("roleName", roleName).set("funcName", funcName);
		page = buttonService.findPage(page, "system.findButtons", paramMap);
		
		chRolebuttons = buttonService.getButtonsByRoleAndFunc("按钮管理");
		
	    return LIST;
    }
	
    public String funcList() throws Exception {
    	String roleName = Servlets.getRequest().getParameter("roleName"); 
    	List<ChRolefunc> chRolefuncs = getChRolefuncByRoleName(roleName);
		
		List<ChFunction> jsonList = new ArrayList<ChFunction>();
		if(chRolefuncs !=null && chRolefuncs.size()>0){
			for(ChRolefunc f : chRolefuncs){
				ChFunction func = new ChFunction();
				String funcPath = f.getChFunc().getChFuncPath();
				if (!funcPath.equals("") && funcPath != "" && funcPath != null) {
					func.setId(f.getChFunc().getId());
					func.setChFuncName(f.getChFunc().getChFuncName());
					jsonList.add(func);	
				}
			}
		}
		Renders.renderJson(jsonList);
		return NONE;
	}
    
    /**
     * 由角色名称获取角色所有的权限
     * @param roleName
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<ChRolefunc> getChRolefuncByRoleName(String roleName) throws Exception {
    	ChRole role = roleService.findOne("system.findRoles", new FastMap().newHashMap().set("roleName", roleName));
		String roleId = role.getId();
		Map<String,String> paramMap = new FastMap().newHashMap().set("roleId", roleId);
		List<ChRolefunc> chRolefuncs = rolefuncService.findList("system.findRoleFuncs", paramMap);
		return chRolefuncs;
    }
    
	@Override
    public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			roleButton = new ChRolebutton();
		}
    }

	@SuppressWarnings("unchecked")
    @Override
    public String save() throws Exception {
		ChRole role = roleService.findOne("system.findRoles", new FastMap().newHashMap().set("roleName", roleName));
		ChFunction func = funcService.findOne("system.findFuncs", new FastMap().newHashMap().set("funcName", funcName));
		roleButton.setChRole(role);
		roleButton.setChFunc(func);
		buttonService.save(roleButton);
		Renders.renderJson(new EasyUiResult("0","保存成功"));
	    return null;
    }

	@SuppressWarnings("unchecked")
    @Override
    public String update() throws Exception {
		roleButton = buttonService.get(id);
		if (roleButton.getChRobuFlag().equals("是"))
			roleButton.setChRobuFlag("否");
		else
			roleButton.setChRobuFlag("是");
		buttonService.update(roleButton);
		
		String roleName = Servlets.getRequest().getParameter("roleName"); 
		String funcName = Servlets.getRequest().getParameter("funcName"); 
		this.setRoleName(roleName);
		this.setFuncName(funcName);
		List<ChRolefunc> chRolefuncs = getChRolefuncByRoleName(roleName);
		funcList = new ArrayList<ChFunction>();
		for (ChRolefunc rf : chRolefuncs){
			String funcPath = rf.getChFunc().getChFuncPath();
			if (!funcPath.equals("") && funcPath != "" && funcPath != null) 
				funcList.add(rf.getChFunc());
		}
		
		roleList = roleService.findList("system.findRoles", new FastMap().newHashMap().set("_query_existedParentRole", true));
		Map<String,String> paramMap = new FastMap().newHashMap().set("roleName", roleName).set("funcName", funcName);
		page = buttonService.findPage(page, "system.findButtons", paramMap);
		
		chRolebuttons = buttonService.getButtonsByRoleAndFunc("按钮管理");
		
	    return LIST;
    }
	
	@Override
    public ChRolebutton getModel() {
	    return roleButton;
    }

	
	
	public String getId() {
    	return id;
    }

	public void setId(String id) {
    	this.id = id;
    }

	public ChRolebutton getRoleButton() {
    	return roleButton;
    }

	public void setRoleButton(ChRolebutton roleButton) {
    	this.roleButton = roleButton;
    }
	
	public ChRolebutton getButton() {
    	return button;
    }

	public void setButton(ChRolebutton button) {
    	this.button = button;
    }
	
	public Page getPage() {
    	return page;
    }

	public void setPage(Page page) {
    	this.page = page;
    }
	
	public List<ChFunction> getFuncList() {
    	return funcList;
    }

	public void setFuncList(List<ChFunction> funcList) {
    	this.funcList = funcList;
    }

	public List<ChRole> getRoleList() {
    	return roleList;
    }

	public void setRoleList(List<ChRole> roleList) {
    	this.roleList = roleList;
    }
	
	public List<ChRolefunc> getRoleFuncList() {
    	return roleFuncList;
    }

	public void setRoleFuncList(List<ChRolefunc> roleFuncList) {
    	this.roleFuncList = roleFuncList;
    }
	
	public String getRoleName() {
    	return roleName;
    }

	public void setRoleName(String roleName) {
    	this.roleName = roleName;
    }

	public String getFuncName() {
    	return funcName;
    }

	public void setFuncName(String funcName) {
    	this.funcName = funcName;
    }
	
	public List<ChRolebutton> getChRolebuttons() {
    	return chRolebuttons;
    }

	public void setChRolebuttons(List<ChRolebutton> chRolebuttons) {
    	this.chRolebuttons = chRolebuttons;
    }
}
