package com.ccloudedu.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.common.entity.ChRole;
import com.ccloudedu.common.entity.ChRolebutton;
import com.ccloudedu.common.entity.ChUser;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.ButtonService;
import com.ccloudedu.system.service.RoleService;

@Service
@Transactional
public class ButtonServiceImpl extends BaseServiceImpl<ChRolebutton> implements ButtonService {

	@Autowired
	private RoleService roleService;
	
	@SuppressWarnings("unchecked")
    @Override
    public List<ChRolebutton> getButtonsByRoleAndFunc(String funcName) throws Exception {
		ChUser user = Sessions.getChUser();
		String roleId = user.getRoleId();
		ChRole role = roleService.get(roleId);
    	Map<String,String> paramMap = new FastMap().newHashMap().set("roleName", role.getChRoleName()).set("funcName", funcName);
    	List<ChRolebutton> chRolebuttons = this.findList("system.findButtons", paramMap);
    	return chRolebuttons;
    }

}
