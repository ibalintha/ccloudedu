package com.ccloudedu.system.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.LoginValidation;
import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseAuthAction;
import com.ccloudedu.system.entity.SysMailServerSetting;
import com.ccloudedu.system.entity.SysRuleSetting;
import com.ccloudedu.system.service.MailServerSettingService;
import com.ccloudedu.system.service.RuleSettingService;

@Scope("prototype")
@Controller("system.action.SystemSettingAction")
public class SystemSettingAction extends BaseAuthAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysRuleSetting ruleSetting;
	private String ruleType="login";
	
	private SysMailServerSetting mailServerSetting;
	
	@Autowired
	private RuleSettingService ruleSettingService;
	@Autowired
	private MailServerSettingService mailServerSettingService;
	
	/**
	 * 进入系统规则设置页面
	 * @return
	 * @throws Exception 
	 */
	@Menu
	public String addRuleSetting() throws Exception{
		ruleSetting = ruleSettingService.findOne(ruleType);
		return ruleType+"RuleSetting";
	}
	
	@LoginValidation(validate=YN.N)
	public String saveRuleSetting() throws Exception{
		ruleSettingService.update(ruleSetting);
		ruleSettingService.updateRuleSettingInCache();
		Renders.renderJson(Renders.UPDATE_SUCCESS);
		return NONE;
	}

	public String addMailServerSetting() throws Exception{
		mailServerSetting = mailServerSettingService.findOne("system.findMailServerSettings",null);
		return "mailServerSetting";
	}
	public String saveMailServerSetting() throws Exception{
		if(StringUtils.isBlank(mailServerSetting.getId())){
			mailServerSettingService.save(mailServerSetting);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			mailServerSettingService.update(mailServerSetting);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}

	public SysMailServerSetting getMailServerSetting() {
		return mailServerSetting;
	}
	public void setMailServerSetting(SysMailServerSetting mailServerSetting) {
		this.mailServerSetting = mailServerSetting;
	}


	public SysRuleSetting getRuleSetting() {
		return ruleSetting;
	}

	public void setRuleSetting(SysRuleSetting ruleSetting) {
		this.ruleSetting = ruleSetting;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
}
