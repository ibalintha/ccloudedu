package com.ccloudedu.system.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.system.entity.SysMenu;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.RoleService2;
import com.ccloudedu.system.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
/**
 * 系统页面布局
 * @author wade
 * 2009-03-21 晚
 */
@Controller("system.action.LayoutAction")
@Scope("prototype")
public class LayoutAction  extends ActionSupport implements Preparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page = new Page(100);
	private SysUser user;
    private Set<SysMenu> menuSet;
    private List<SysMenu> menuList;
    private String changeRoleId;
	@Autowired
	private RoleService2 roleService;
	@Autowired
	private UserService userService;
	
	public void prepare() throws Exception {
		//第一次登录从session中获得用户，登录以后的页面刷新不再重复从session中获得
		if(user==null){
			user = Sessions.getSysUser();
		}
	}
	
	public String layout()throws Exception{
		    SysRole role = new SysRole();
		    if(StringUtils.isEmpty(changeRoleId)){
				role = roleService.get(user.getRoleId());//user.getSysRoles().get(0);
		    }else{//切换角色
		    	role = roleService.get(changeRoleId);
		    }
		    
		    //获得菜单层级结构，下面的办法真的很烂
			menuSet = role.getSysMenus();
			List<String> menuPaths = new ArrayList<String>();
			
			if(menuSet!=null && menuSet.size()>0){
				
				menuList = new ArrayList<SysMenu>();
				List<SysMenu> subList = null;
				
				for(SysMenu m : menuSet){//获得一级菜单
					if(m.getSysMenu()!=null){
						if("1".equals(m.getSysMenu().getId())){
							menuList.add(m);
						}
					}
					if(StringUtils.isNotBlank(m.getMenuPath())){
						menuPaths.add(m.getMenuPath());
					}
				}
				if(menuList.size()>0){
					for(SysMenu m : menuList){//获得二级菜单
						subList = new ArrayList<SysMenu>();
						for(SysMenu m1 : menuSet){
							if(m1.getSysMenu()!=null){
								if(m.getId().equals(m1.getSysMenu().getId())){
									subList.add(m1);
								}
							}
						}
						m.setSubList(subList);
					}
					
					for(SysMenu m : menuList){//获得三级菜单
						for(SysMenu m2 : m.getSubList()){
							subList = new ArrayList<SysMenu>();
							for(SysMenu m1 : menuSet){
								if(m1.getSysMenu()!=null){
									if(m2.getId().equals(m1.getSysMenu().getId())){
										subList.add(m1);
									}
								}
							}
							m2.setSubList(subList);
						}
					}
				}
			}
			
			user.setRoleId(role.getId());
			user.setSysRole(role);
			user.setMenuPaths(menuPaths);
			
			//存放国际化
			//Servlets.getSession().put("LOCALE", getLocale());
			
			return "layout";
		
	}
	
	/**
	 * 在线用户
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String listOnlineUser() throws Exception{
		 //获得当前在线用户的id List
		 List<String> userIdList = new ArrayList<String>();
		
		 Map<String,SysUser> onlineUserMap = (Map<String, SysUser>) EhCacheManager.getAll(CacheConstants.HTTP_SESSION_CACHE);
         
         Collection<SysUser> users = onlineUserMap.values();
         Iterator<SysUser> iterator = users.iterator();
         while(iterator.hasNext()){
        	userIdList.add(iterator.next().getId());
        }
         
        page = userService.findUsers(page, "", "","", userIdList);
        
		return "onlineUser";
	}
	
	/**
	 * 查询在线用户数量
	 * @return
	 * @throws Exception
	 */
	public String getOnlineUserCount()throws Exception{
		Renders.renderHtml(EhCacheManager.getAll(CacheConstants.HTTP_SESSION_CACHE).size());
		return NONE;
	}
	/**
	 * 我要留言
	 * @return
	 */
	public String leaveAMessage(){
		return "leaveAMessage";
	}
	
	/**
	 * 在线聊天
	 * @return
	 */
	public String onlineChart(){
		return "onlineChart";
	}
	
	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
	
	public Set<SysMenu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<SysMenu> menuSet) {
		this.menuSet = menuSet;
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}

	public String getChangeRoleId() {
		return changeRoleId;
	}

	public void setChangeRoleId(String changeRoleId) {
		this.changeRoleId = changeRoleId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
