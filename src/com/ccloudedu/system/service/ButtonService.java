package com.ccloudedu.system.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChRolebutton;

public interface ButtonService extends BaseService<ChRolebutton> {

	/**
     * 由当前用户的角色Id和菜单名称获取此菜单中button的状态
     * @param funcName
     * @return
     * @throws Exception 
     */
	public List<ChRolebutton> getButtonsByRoleAndFunc (String funcName) throws Exception;
}
