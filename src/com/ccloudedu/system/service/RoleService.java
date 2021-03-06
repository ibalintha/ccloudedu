package com.ccloudedu.system.service;

import java.util.List;
import java.util.Map;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChRole;
import com.ccloudedu.common.entity.ChRolefunc;

public interface RoleService extends BaseService<ChRole>{

	public int saveOrUpdate(ChRole sysRole,String checkIds) throws Exception;
	
	public int saveOrUpdateChRoleFunc(ChRole role,String checkIds) throws Exception;
	
	public int getCountSubRoleNumByParentId(String parentId) throws Exception;

	public List<ChRolefunc> findChRoleFuncByRoleId(String roleId) throws Exception;

//	public Auth findAuthByRoleId(String roleId, String menuPath) throws Exception;

	public List<ChRole> findRoles(Map<String,?> paramMap) throws Exception;
	
	public void changeUserState(ChRole role, String state) throws Exception;
}
