package com.ccloudedu.system.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.constants.enums.Auth;
import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.system.entity.SysMenu;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysRoleMenu;
import com.ccloudedu.system.service.RoleService2;
@Service
@Transactional
public class RoleServiceImpl2 extends BaseServiceImpl<SysRole> implements RoleService2 {
	
	@Autowired
	private BaseHibernateDao<SysRoleMenu> sysRoleMenuDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveOrUpdate(SysRole role,String checkIds, String rwAuths) throws Exception{
		
		if(StringUtils.isEmpty(role.getId())){
			save(role);
			saveOrUpdateSysRoleMenuTemp(role, checkIds,rwAuths);
		}else{
			role.setSysMenus(null);
			update(role);
		}
		return 0;
	}
	/**
	 * 更新角色权限，重新开启一个事务；这里不知道会不会导致异常
	 * @param role
	 * @param menuIds
	 * @return
	 * @throws Exception 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveOrUpdateSysRoleMenu(SysRole role,String checkIds, String rwAuths) throws Exception{
		saveOrUpdateSysRoleMenuTemp(role, checkIds,rwAuths);
		return 0;
	}
	
	private void saveOrUpdateSysRoleMenuTemp(SysRole role,String checkIds,String rwAuths) throws Exception{
		SysRoleMenu roleMenu = null;
		SysMenu menu = null;
		if(StringUtils.isNotBlank(checkIds)){
			String[] arr = checkIds.split(",");
		    String[] arr2 = rwAuths.split(",");
			//插入新的
			if(checkIds!=null && arr.length>0){
				for(int i=0;i<arr.length;i++){
					if(StringUtils.isNotBlank(arr[i])){
						roleMenu = new SysRoleMenu();
						menu = new SysMenu();
						menu.setId(arr[i]);
						
						roleMenu.setSysRole(role);
						roleMenu.setSysMenu(menu);
						if(i<arr2.length && StringUtils.isNotBlank(arr2[i])){
							//转化成enum
							roleMenu.setAuth(Auth.valueOf(arr2[i]));
						}
						sysRoleMenuDao.save(roleMenu);
					}
				}
				
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysRoleMenu> findSysRoleMenuByRoleId(String roleId) throws Exception{
		return sysRoleMenuDao.findList("system.findRoleMenus",new FastMap().newHashMap().set("roleId", roleId));
	}
	
	@SuppressWarnings("unchecked")
	public Auth findAuthByRoleId(String roleId, String menuPath) throws Exception{
		Map<String,Object> paramMap = new FastMap().newHashMap().set("roleId", roleId).set("authList", Arrays.asList(Auth.values())).set("menuPath", menuPath);
		SysRoleMenu rm = sysRoleMenuDao.findOne("system.findRoleMenus",paramMap);
		if(rm!=null){
			return rm.getAuth();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<SysRole> findRoles(Map<String,?> paramMap) throws Exception{
		return findList("system.findRoles", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public int getCountSubRoleNumByParentId(String parentId) throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap().set("parentId", parentId);
		return findCount("system.getCountSubRoleNumByParentId",paramMap);
	}
}
