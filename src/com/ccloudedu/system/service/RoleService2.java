package com.ccloudedu.system.service;

import java.util.List;
import java.util.Map;

import com.ccloudedu.base.constants.enums.Auth;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysRoleMenu;

public interface RoleService2 extends BaseService<SysRole>{

	public int saveOrUpdate(SysRole sysRole,String checkIds, String rwAuths) throws Exception;
	
	public int saveOrUpdateSysRoleMenu(SysRole role,String checkIds,String rwAuths) throws Exception;
	
	public int getCountSubRoleNumByParentId(String parentId) throws Exception;

	public List<SysRoleMenu> findSysRoleMenuByRoleId(String roleId) throws Exception;

	public Auth findAuthByRoleId(String roleId, String menuPath) throws Exception;

	public List<SysRole> findRoles(Map<String,?> paramMap) throws Exception;
}
