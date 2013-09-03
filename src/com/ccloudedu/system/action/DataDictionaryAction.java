package com.ccloudedu.system.action;

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
import com.ccloudedu.base.utils.LocaleUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.system.entity.SysDataDictionary;
import com.ccloudedu.system.service.DataDictionaryService;
import com.google.common.collect.Lists;
@Controller("system.action.DataDictionaryAction")
@Scope("prototype")
public class DataDictionaryAction extends BaseCrudAction<SysDataDictionary>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysDataDictionary dd;
	private SysDataDictionary parentDD ;
	private String id;
	private String type;
	private Page page = new Page(Constants.PAGE_SIZE);
	private List<SysDataDictionary> ddList;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	public SysDataDictionary getModel() {
		return dd;
	}
	@Override
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			dd = new SysDataDictionary();
			dd.setCreateTime(DateUtils.getCurrentDate());
			dd.setCreateUser(Sessions.getSysUser());
		}
		else{
			dd = dataDictionaryService.get(id);
		}
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	public String add() throws Exception {
		try{
			parentDD = dataDictionaryService.get(id);
		}catch (Exception e) {
			addActionMessage("出现异常："+e);
		}
		return ADD;
	}
	 public String update() throws Exception {
			return UPDATE;
	  }
	@Override
	public String save() throws Exception {
		if(StringUtils.isBlank(id)){
			if(StringUtils.isNotBlank(parentDD.getId())){
				 parentDD = dataDictionaryService.get(parentDD.getId());
				 dd.setParentDD(parentDD);
				 dd.setUndefined1(parentDD.getUndefined1());
				 dd.setUndefined2("noChild");
				 parentDD.setUndefined2("hasChild");
			}
			dataDictionaryService.save(dd,parentDD);
			dataDictionaryService.updateDDInCache();
			Renders.renderJson(new EasyUiResult("0","保存成功",Lists.newArrayList(dd.getId())));
		}
		else{
			dataDictionaryService.update(dd);
			
			dataDictionaryService.updateDDInCache();
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}

	public String judgeDdValue() throws Exception {
		if(dataDictionaryService.findone(dd.getDdValue())!=null){
			Renders.renderJson(LocaleUtils.getLocaleText("参数值已经存在，不可重复", ""));
		}else{
			Renders.renderJson("");
		}
		return NONE;
	}
	@Override
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		dataDictionaryService.deleteByIds(ids.split(","));
		dataDictionaryService.updateDDInCache();
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String list() throws Exception {
		if(StringUtils.isNotBlank(id)){
			page = dataDictionaryService.findPage(page, "system.findDataDictionarys",new FastMap().newHashMap().set("parentId", id));
		}else{
			page = dataDictionaryService.findPage(page, "system.findDataDictionarys",null);
		}
		return LIST;
	}
	
	@SuppressWarnings("unchecked")
	@Menu
	public String tree() throws Exception {
		if(!StringUtils.isNotBlank(type)){
			Map<String,String> paramMap = new FastMap().newHashMap().set(Querys.PREFIX+"exceptUndefined1",true);
			ddList = dataDictionaryService.findList("system.findDataDictionarys",paramMap);
		}else{
			Map<String,String> paramMap = new FastMap().newHashMap().set("undefined1",type);
			ddList = dataDictionaryService.findList("system.findDataDictionarys",paramMap);
		}
		return TREE;
	}
	//-----------------------------以下是getter/setter方法-----------------------------
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
	
	public List<SysDataDictionary> getDdList() {
		return ddList;
	}
	public void setDdList(List<SysDataDictionary> ddList) {
		this.ddList = ddList;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SysDataDictionary getParentDD() {
		return parentDD;
	}
	public void setParentDD(SysDataDictionary parentDD) {
		this.parentDD = parentDD;
	}
}
