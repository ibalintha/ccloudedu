package com.ccloudedu.system.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.system.entity.SysRuleSetting;

public interface RuleSettingService extends BaseService<SysRuleSetting> {
	

	/**
	 * 根据规则类型查询规则设置
	 * @param ruleType
	 * @return
	 */
	public SysRuleSetting findOne(String ruleType) throws Exception;

	 /**
	  * 加载/更新规则在缓存存中的数据
	  */
	public int updateRuleSettingInCache()throws Exception;
}
