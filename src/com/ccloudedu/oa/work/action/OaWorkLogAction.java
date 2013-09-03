package com.ccloudedu.oa.work.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.oa.work.entity.OaProject;
import com.ccloudedu.oa.work.entity.OaWorkLog;
import com.ccloudedu.oa.work.service.OaWorkLogService;

@Controller("oa.work.action.OaWorkLogAction")
@Scope("prototype")
public class OaWorkLogAction extends BaseCrudAction<OaWorkLog> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String projectId;
	private String isLeaderRead;
	private OaWorkLog oaWorkLog;
	private Page page = new Page(Constants.PAGE_SIZE);
	@Autowired
	private OaWorkLogService oaWorkLogService;


	public OaWorkLog getModel() {
		
		return oaWorkLog;
	}

	@Override
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			oaWorkLog = new OaWorkLog();
			oaWorkLog.setCreateTime(DateUtils.getCurrentDate());
			oaWorkLog.setCreator(Sessions.getSysUser());
			//oaWorkLog.setWeekDay("星期"+getZhongwenWeek(w+""));
		}else{
			oaWorkLog = oaWorkLogService.get(id);
		}
	}
	
	public String update(){
		return ADD;
	}
	@Override
	public String add() throws Exception {
		
		return NONE;
	}

	@Override
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		oaWorkLogService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	@Override
	@Menu
	public String list() throws Exception {
		page = oaWorkLogService.findPage(page,isLeaderRead);
		return LIST;
	}

	@Override
	public String save() throws Exception {
		java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(DateUtils.parseDate(oaWorkLog.getStartTime(), DateUtils.DATE_FORMAT));          
        int w=cal.get(java.util.Calendar.DAY_OF_WEEK)-1;
        if(w==0)w=7;
		oaWorkLog.setWeekDay(w+"");
		oaWorkLog.setWorkDate(oaWorkLog.getStartTime().split(" ")[0]);
		oaWorkLog.setOaProject(new OaProject(projectId));
		
		if(StringUtils.isBlank(id)){
			oaWorkLogService.save(oaWorkLog);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			oaWorkLogService.update(oaWorkLog);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}

	@Override
	public String detail() throws Exception {
		oaWorkLog = oaWorkLogService.get(id);
		return DETAIL;
	}

	public String getZhongwenWeek(String week){
		Map<String,String> weekMap = new HashMap<String, String>();
		weekMap.put("1", "一");
		weekMap.put("2", "二");
		weekMap.put("3", "三");
		weekMap.put("4", "四");
		weekMap.put("5", "五");
		weekMap.put("6", "六");
		weekMap.put("7", "日");
		return weekMap.get(week);
	}
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

	public void setOaWorkLogService(OaWorkLogService oaWorkLogService) {
		this.oaWorkLogService = oaWorkLogService;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getIsLeaderRead() {
		return isLeaderRead;
	}

	public void setIsLeaderRead(String isLeaderRead) {
		this.isLeaderRead = isLeaderRead;
	}
}
