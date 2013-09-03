package com.ccloudedu.system.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.system.entity.SysMenu;
import com.ccloudedu.system.service.MenuService;
import com.google.common.collect.Lists;
/**
 * 菜单管理action
 * @author wade
 * 2009-03-28晚12点
 */
@Controller("system.action.MenuAction")
@Scope("prototype")
public class MenuAction extends BaseCrudAction<SysMenu>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysMenu menu;
	private SysMenu sysMenu;
	private String id;
	private List<SysMenu> menuList;
	private Page page = new Page(Constants.PAGE_SIZE);
	@Autowired
	private MenuService menuService;
	
	public SysMenu getModel() {
		return menu;
	}
	@Override
	public void prepareModel() throws Exception {
		//新增菜单
		if(!StringUtils.isNotEmpty(id)){
			menu = new SysMenu();
			menu.setCreateTime(DateUtils.getCurrentDate());
			menu.setCreateUser(Sessions.getSysUser());
			if(StringUtils.isNotEmpty(sysMenu.getId())){
				//非一级菜单
				menu.setSysMenu(menuService.get(sysMenu.getId()));
			}
		}
		//修改菜单
		else{
			menu = menuService.get(id);
		}
	}

	@Override
	public String save() throws Exception {
		if(id==null){
			menuService.save(menu);
			Renders.renderJson(new EasyUiResult("0","保存成功",Lists.newArrayList(menu.getId())));
		}else{
			menuService.update(menu);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	public String add()throws Exception{
		try{
			sysMenu = menuService.get(id);
		}catch (Exception e) {
			addActionMessage("没有上级菜单，请先选择上级角色");
		}
		return ADD;
	}

	public String update(){
		return UPDATE;
	}
	
	@Override
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		menuService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		try{
			setId(id);
			page = menuService.findPage(page,"system.findMenus",new FastMap().newHashMap().set("parentId", id));
		}catch (Exception e) {
			addActionMessage("不能获得菜单列表，请检查查询条件");
		}
		return SUCCESS;
	}
	/**
	 * 菜单树
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Menu
	public String tree() throws Exception {
		menuList = menuService.findList("system.findMenus",null);
		return TREE;
	}
	//-------------------以下是getter/setter方法--------------------------------------

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
	public List<SysMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}
	public SysMenu getSysMenu() {
		return sysMenu;
	}
	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}
}
