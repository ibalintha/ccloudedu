package com.ccloudedu.system.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.common.entity.ChFunction;
import com.ccloudedu.common.entity.ChRecord;
import com.ccloudedu.system.service.FuncService;
import com.ccloudedu.system.service.RecordService;

/**
 * 日志管理 action
 * @author xubo
 * 2013-07-24
 */
@Controller("system.action.LogAction")
@Scope("prototype")
public class LogAction extends BaseCrudAction<ChRecord> {

    private static final long serialVersionUID = -5017792394945536429L;

	private ChRecord chRecord;
	private List<ChFunction> funcList;
	private Page page=new Page(Constants.PAGE_SIZE); 
//	private Page page;
	private ChFunction chFunc;
	@Autowired
	private FuncService funcService;
	@Autowired
	private RecordService recordService;
	
	//查询参数
	private String chRecdModule;
	private String chRecdType;
	private String startLoginTime;
	private String endLoginTime;
	

	public ChRecord getModel() {
		return chRecord;
    }
    public void prepareModel() throws Exception {

	}
	/**
	 * 日志列表 2013-7-24:查询日志
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Menu
	@Override
    public String list() throws Exception {
		funcList = funcService.findList("system.findFuncs",null);
		//page= new Page(Constants.PAGE_SIZE);
		Map<String,String> paramMap =new FastMap().newHashMap().set("chRecdModule",  "%"+chRecdModule+"%")
		.set("startLoginTime", startLoginTime)
		.set("endLoginTime", endLoginTime)
		.set("chRecdType", "%"+chRecdType+"%");
		page = recordService.findPage(page, "system.chRecord.findPage",paramMap);
	    return LIST;
    }
	
	
    public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		recordService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
    }


	@Override
    public String add() throws Exception {
	    return null;
    }
	


	@Override
    public String detail() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String save() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String update() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }




	
	/************---------------get()/set()方法***********/
	public void setFuncList(List<ChFunction> funcList) {
		this.funcList = funcList;
	}


	public List<ChFunction> getFuncList() {
		return funcList;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public Page getPage() {
		return page;
	}
	public void setChFunc(ChFunction chFunc) {
		this.chFunc = chFunc;
	}
	public ChFunction getChFunc() {
		return chFunc;
	}
	public void setChRecdType(String chRecdType) {
		this.chRecdType = chRecdType;
	}
	public String getChRecdType() {
		return chRecdType;
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
	public String getChRecdModule() {
		return chRecdModule;
	}
	public void setChRecdModule(String chRecdModule) {
		this.chRecdModule = chRecdModule;
	}

}
