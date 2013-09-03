package com.ccloudedu.system.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
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
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.system.entity.QuerySqlHql;
import com.ccloudedu.system.entity.SysMenu;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.MenuService;
import com.ccloudedu.system.service.QuerySqlHqlService;
@Controller("system.action.querySqlHqlAction")
@Scope("prototype")
public class QuerySqlHqlAction  extends BaseCrudAction<QuerySqlHql>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String menuId;
	private SysMenu menu;
	private Page page = new Page(Constants.PAGE_SIZE);
	
	private QuerySqlHql querySqlHql;
	private List<SysMenu> menuList;
	@Autowired
	private QuerySqlHqlService querySqlHqlService;
	@Autowired
	private MenuService menuService;
	
	public QuerySqlHql getModel() {
		
		return querySqlHql;
	}
    public void prepareModel() throws Exception {
		if(StringUtils.isEmpty(id)){//新增
			querySqlHql = new QuerySqlHql();
			querySqlHql.setCreateTime(DateUtils.getCurrentDate());
			querySqlHql.setCreateUser(Sessions.getSysUser());
			querySqlHql.setMenu(menuService.get(menuId));
		}
		else{//修改
			querySqlHql = querySqlHqlService.get(id);
		}
	}
    
    public String add() throws Exception {
    	menu = menuService.get(menuId);
		return "add";
	}
	
	public String save() throws Exception {
		if(id==null){
			querySqlHqlService.save(querySqlHql);
			querySqlHqlService.updateQueryTemplateInCache();
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			querySqlHqlService.update(querySqlHql);
			querySqlHqlService.updateQueryTemplateInCache();
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return null;
	}

	public String update() throws Exception {
		
		return null;
	}
	
	public String detail() throws Exception {
		
		return "detail";
	}

    public String delete() throws Exception {
    	String ids = Servlets.getRequest().getParameter("ids");
    	querySqlHqlService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return null;
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		if(StringUtils.isNotBlank(menuId)){
			menu = menuService.get(menuId);
		}
		Map<String,String> paramMap = new FastMap().newHashMap().set("menuId", menuId);
		page = querySqlHqlService.findPage(page,"system.findQuerySqlHqls",paramMap);
		return "list";
	}
	
	@Menu
	@SuppressWarnings("unchecked")
	public String menuTree() throws Exception{
		menuList = menuService.findList("system.findMenus",null);
		return "menuTree";
	}
	
	
	@SuppressWarnings("unchecked")
	public String valideQueryName() throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap().set("queryName", querySqlHql.getQueryName());
		querySqlHql = querySqlHqlService.findOne("system.findQuerySqlHqls", paramMap);
		if(querySqlHql!=null){
			Renders.renderJson("existed");
		}else{
			Renders.renderJson("not exist");
		}
		return null;
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SysMenu getMenu() {
		return menu;
	}
	public void setMenu(SysMenu menu) {
		this.menu = menu;
	}
	public QuerySqlHql getQuerySqlHql() {
		return querySqlHql;
	}
	public void setQuerySqlHql(QuerySqlHql querySqlHql) {
		this.querySqlHql = querySqlHql;
	}
	
	
	public static void main(String[] args){
		
	    SysUser a = new SysUser();
		System.out.println(BeanUtils.isSimpleProperty(a.getClass()));
	}
}
