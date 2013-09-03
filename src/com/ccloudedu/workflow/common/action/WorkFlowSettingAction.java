package com.ccloudedu.workflow.common.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.dao.utils.Querys;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.system.entity.SysDataDictionary;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.service.DataDictionaryService;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.RoleService2;
import com.ccloudedu.workflow.common.entity.WfExecuteSetting;
import com.ccloudedu.workflow.common.service.WorkFlowSettingService;
/**
 * 工作流设置
 * @author wade
 *
 */
@Controller("workflow.common.action.WorkFlowSettingAction")
@Scope("prototype")
public class WorkFlowSettingAction extends BaseCrudAction<WfExecuteSetting>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WfExecuteSetting wfExecuteSetting;
	private List<WfExecuteSetting> wfExecuteSettingList;
	private String id;
	private String wfCat;
	private List<String> curExecutorRoles;
	private List<String> nextExecutorRoles;
	private List<String> transitions;
	private List<String> variableNames;
	private List<String> operateTypes;
	private List<SysRole> roleList;
	
	private List<SysDataDictionary> ddExecuteSettingList;
	@Autowired
	private WorkFlowSettingService workFlowSettingService;
	@Autowired
	private RoleService2 roleService;
	
	@Autowired
	private DataDictionaryService dataDictionaryService;

	public WfExecuteSetting getModel() {
		
		return wfExecuteSetting;
	}
	@Override
	public void prepareModel() throws Exception {
		
		
	}

	@Override
	public String save() throws Exception {
		if(curExecutorRoles!=null && curExecutorRoles.size()>0){
			workFlowSettingService.save(wfCat,curExecutorRoles,nextExecutorRoles,transitions,variableNames,operateTypes);
		}
		Renders.renderJson(Renders.SAVE_SUCCESS);
		return NONE ;
	}

	@SuppressWarnings("unchecked")
	@Menu
	public String list() throws Exception {
		if(StringUtils.isBlank(wfCat)){
			Map<String,List<SysDataDictionary>> parentMap =  (Map<String, List<SysDataDictionary>>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.DATA_DICTIONARY_KEY);
			List<SysDataDictionary> subList = parentMap.get("wfCat");
			wfCat = subList.get(0).getDdValue();
		}
		roleList = roleService.findRoles(new FastMap().newHashMap().set(Querys.PREFIX+"existedParentRole", true));
		wfExecuteSettingList = workFlowSettingService.findListByWfCat(wfCat);
		ddExecuteSettingList = dataDictionaryService.getDDbyParentDDValue("wfCat");
		return LIST;
	}

	@Override
	public String detail() throws Exception {
		
		return NONE;
	}
	
	@Override
	public String add() throws Exception {
		
		return NONE;
	}

	@Override
	public String delete() throws Exception {
		
		return NONE;
	}

	public WfExecuteSetting getWfExecuteSetting() {
		return wfExecuteSetting;
	}
	public void setWfExecuteSetting(WfExecuteSetting wfExecuteSetting) {
		this.wfExecuteSetting = wfExecuteSetting;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public String getWfCat() {
		return wfCat;
	}
	public void setWfCat(String wfCat) {
		this.wfCat = wfCat;
	}
	public List<String> getCurExecutorRoles() {
		return curExecutorRoles;
	}
	public void setCurExecutorRoles(List<String> curExecutorRoles) {
		this.curExecutorRoles = curExecutorRoles;
	}
	public List<String> getNextExecutorRoles() {
		return nextExecutorRoles;
	}
	public void setNextExecutorRoles(List<String> nextExecutorRoles) {
		this.nextExecutorRoles = nextExecutorRoles;
	}
	public List<String> getTransitions() {
		return transitions;
	}
	public void setTransitions(List<String> transitions) {
		this.transitions = transitions;
	}
	public List<String> getVariableNames() {
		return variableNames;
	}
	public void setVariableNames(List<String> variableNames) {
		this.variableNames = variableNames;
	}
	public List<WfExecuteSetting> getWfExecuteSettingList() {
		return wfExecuteSettingList;
	}
	public void setWfExecuteSettingList(List<WfExecuteSetting> wfExecuteSettingList) {
		this.wfExecuteSettingList = wfExecuteSettingList;
	}
	public List<String> getOperateTypes() {
		return operateTypes;
	}
	public void setOperateTypes(List<String> operateTypes) {
		this.operateTypes = operateTypes;
	}
	@Override
	public String update() throws Exception {
		
		return null;
	}
	public List<SysDataDictionary> getDdExecuteSettingList() {
		return ddExecuteSettingList;
	}
	public void setDdExecuteSettingList(List<SysDataDictionary> ddExecuteSettingList) {
		this.ddExecuteSettingList = ddExecuteSettingList;
	}
	
}
