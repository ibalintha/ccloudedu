package com.ccloudedu.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.common.entity.ChFunction;
import com.ccloudedu.common.entity.ChModel;
import com.ccloudedu.common.entity.ChModelfunc;
import com.ccloudedu.system.service.FuncService;
import com.ccloudedu.system.service.ModelFuncService;
import com.ccloudedu.system.service.ModelService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller("system.action.ModelAction")
@Scope("prototype")
public class ModelAction extends BaseCrudAction<ChModel> {

    private static final long serialVersionUID = -2643124229891653076L;

    private String id;
	private ChModel chModel;
	
	@Autowired
	private ModelService modelService;
	@Autowired
	private ModelFuncService modelFuncService;
	@Autowired
	private FuncService funcService;
	
	@Override
    public String add() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String delete() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String detail() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String list() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			chModel = new ChModel();
		}
		else{
			chModel = modelService.get(id);
		}
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

	@Override
    public ChModel getModel() {
	    return chModel;
    }
	
	@SuppressWarnings("unchecked")
    public String funcList() throws Exception {
		String modelId = Servlets.getRequest().getParameter("modelId");
		Map<String,String> paramMap = new FastMap().newHashMap().set("modelId", modelId);
		List<ChModelfunc> chModelFuncs = modelFuncService.findList("system.findFuncsByModel", paramMap);
		
		List<ChFunction> jsonList = new ArrayList<ChFunction>();
		if(chModelFuncs !=null && chModelFuncs.size()>0){
			for(ChModelfunc mf : chModelFuncs){
				ChFunction func = new ChFunction();
				ChFunction funct = funcService.get(mf.getChFuncId());
				func.setId(funct.getId());
				func.setChFunc(funct.getChFunc());
				func.setChFuncName(funct.getChFuncName());
				func.setChFuncPath(funct.getChFuncPath());
				jsonList.add(funct);	
			}
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		
		String str = gson.toJson(jsonList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	 public String getId() {
	    	return id;
	    }

		public void setId(String id) {
	    	this.id = id;
	    }

		public ChModel getChModel() {
	    	return chModel;
	    }

		public void setChModel(ChModel chModel) {
	    	this.chModel = chModel;
	    }

}
