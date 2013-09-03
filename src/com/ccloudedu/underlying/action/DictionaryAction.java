package com.ccloudedu.underlying.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.underlying.service.ChDataDictionaryService;
import com.ccloudedu.underlying.service.DataDictMenuService;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.Renders;
import com.google.gson.GsonBuilder;
import com.ccloudedu.common.entity.ChDatadictionary;
import com.ccloudedu.common.service.ChAdminwayService;
import com.ccloudedu.common.service.ChBloodtypeService;
import com.ccloudedu.common.service.ChForeignService;
import com.ccloudedu.common.service.ChHealthstatusService;
import com.ccloudedu.common.service.ChPersontypeService;
import com.ccloudedu.common.service.ChPolfaceService;
import com.ccloudedu.common.service.ChStudenttypeService;

@Controller("underlying.action.Dictionary")
@Scope("prototype")
public class DictionaryAction{
	private List<String> modules;
	private List<String> dictMenus;
	private String selectedModule;
	private String selectedMenu;
	private Page page = new Page(Constants.PAGE_SIZE);
	
	@Autowired
	private ChDataDictionaryService dictService;
	@Autowired
	private DataDictMenuService dictMenuService;
	@Autowired
	private ChAdminwayService adminwayService;
	@Autowired
	private ChBloodtypeService bloodtypeService;
	@Autowired
	private ChForeignService foreignService;
	@Autowired
	private ChHealthstatusService healthService;
	@Autowired
	private ChPersontypeService persontypeService;
	@Autowired
	private ChPolfaceService polfaceService;
	@Autowired
	private ChStudenttypeService studenttypeService;
	
	/**
	 * 查询数据字典列表
	 * @return
	 * @throws Exception
	 */
	@Menu
	public String list() throws Exception{
		modules = dictMenuService.getAllModule();
		selectedModule = Servlets.getRequest().getParameter("module");
		selectedMenu = Servlets.getRequest().getParameter("dictMenu");
		if(selectedMenu != null){
			selectedMenu = java.net.URLDecoder.decode(selectedMenu,"UTF-8");
//			selectedModule = DictMenuMapper.getModule(selectedMenu);
		} else{
			selectedMenu = "NO";
		}	
		if(selectedModule == null){
			dictMenus = new ArrayList<String>();
		} else {
			selectedModule = java.net.URLDecoder.decode(selectedModule,"UTF-8");
			if(selectedModule.equals("all")){
				dictMenus = dictMenuService.getMenusByModule(null);
			} else {
				dictMenus = dictMenuService.getMenusByModule(selectedModule);
			}
		}

		page = dictService.findDataDictByMenu(page, selectedMenu);
		return "list";
	}

	/**
	 * 获取指定模块的字典菜单(AJAX)
	 * @throws Exception
	 */
	public void menu() throws Exception{
		String module = Servlets.getRequest().getParameter("module");
		if(module.equals("all")){
			module = null;
		}
		dictMenus = dictMenuService.getMenusByModule(selectedModule);
		GsonBuilder builder = new GsonBuilder();		
		String ajaxJson = builder.create().toJson(dictMenus);
		sendMsg(ajaxJson);
	}
	
	/**
	 * 跳转到添加字典页面
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		selectedModule = Servlets.getRequest().getParameter("module");
		selectedModule = java.net.URLDecoder.decode(selectedModule,"UTF-8");
		selectedMenu = Servlets.getRequest().getParameter("dictMenu");
		selectedMenu = java.net.URLDecoder.decode(selectedMenu,"UTF-8");
		return "add";
	}
	
	/**
	 * 添加数据字典
	 * @throws Exception
	 */
	public void save() throws Exception{
		HttpServletRequest req = Servlets.getRequest();
		String menu = req.getParameter("dictMenu");
		
		ChDatadictionary dict = new ChDatadictionary();
		dict.setChDadtModule(dictMenuService.getModuleByMenu(menu));
		dict.setChDadtMenu(menu);
		dict.setChDadtSyscode(req.getParameter("dictSyscode"));
		dict.setChDadtEducode(req.getParameter("dictEducode"));
		dict.setChDadtName(req.getParameter("dictName"));
		dict.setChDadtFlag(req.getParameter("flag"));
		dict.setChDadtDeftype(req.getParameter("deftype"));
		dict.setChDadtMemo(req.getParameter("memo"));
		dict.setChDadtTable(dictMenuService.getTableNameByMenu(menu));
		dictService.saveDictionary(dict);
		
		Renders.renderJson(Renders.SAVE_SUCCESS);
	}
	
	/**
	 * 代码编号验证
	 * @throws Exception
	 */
	public void validate() throws Exception{
		String syscode = Servlets.getRequest().getParameter("syscode");
		String dictMenu = Servlets.getRequest().getParameter("dictMenu");
		ChDatadictionary dict = dictService.findDataDict(dictMenu, syscode, null, null);
		boolean exist;
		if(dict == null){
			exist = false;
		} else {
			exist = true;
		}
		GsonBuilder builder = new GsonBuilder();		
		String ajaxJson = builder.create().toJson(exist);
		sendMsg(ajaxJson);	
	}
	
	/**
	 * 更新数据字典
	 * @throws Exception
	 */
	public void update() throws Exception{
		HttpServletRequest req = Servlets.getRequest();
		String id = req.getParameter("dictId");
		ChDatadictionary dict = dictService.findDataDictById(id);
		dict.setChDadtSyscode(req.getParameter("dictSyscode"));
		dict.setChDadtEducode(req.getParameter("dictEducode"));
		dict.setChDadtName(req.getParameter("dictName"));
		dict.setChDadtFlag(req.getParameter("flag"));
		dict.setChDadtDeftype(req.getParameter("deftype"));
		dictService.updateDictionary(dict);
		
		Renders.renderJson(Renders.UPDATE_SUCCESS);
	}
	
	public String delete() throws Exception{
		String ids = Servlets.getRequest().getParameter("ids");
		dictService.deleteByIds(ids.split(","));
		
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return "none";
	}
	
	/**
	 * ajax公共方法，发送数据到页面
	 * @param content
	 */
	public void sendMsg(String content){      
        HttpServletResponse response = ServletActionContext.getResponse();      
        response.setCharacterEncoding("UTF-8");      
        try {
			response.getWriter().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
    } 
	
	/********************* getter and setter **********************/
	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}

	public List<String> getDictMenus() {
		return dictMenus;
	}

	public void setDictMenus(List<String> dictMenus) {
		this.dictMenus = dictMenus;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getSelectedModule() {
		return selectedModule;
	}

	public void setSelectedModule(String selectedModule) {
		this.selectedModule = selectedModule;
	}

	public String getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(String selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

}
