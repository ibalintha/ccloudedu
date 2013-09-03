package com.ccloudedu.system.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.common.entity.ChFunction;
import com.ccloudedu.common.entity.ChRole;
import com.ccloudedu.common.entity.ChRolefunc;
import com.ccloudedu.common.entity.ChUser;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.UserServiceCh;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * 系统页面布局
 * 
 * @author xubo
 * 
 */
@Controller("system.action.LayoutActionCh")
@Scope("prototype")
public class LayoutActionCh extends ActionSupport implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page = new Page(100);
	private ChUser user;
	private List<ChFunction> menuSet;
	private List<ChFunction> menuList;
	private String changeRoleId;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserServiceCh userService;

	public void prepare() throws Exception {
		// 第一次登录从session中获得用户，登录以后的页面刷新不再重复从session中获得
		if (user == null) {
			user = Sessions.getChUser();
		}
	}

	@SuppressWarnings("unchecked")
	public String layout() throws Exception {
		ChRole chRole = new ChRole();
		if (user.getChUserRoleids() != null) {

			if (StringUtils.isEmpty(changeRoleId)) {
				chRole = roleService.get(user.getChRole().getId());
			} else {// 切换角色
				chRole = roleService.get(changeRoleId);
			}
		}
		// 获得菜单层级结构，下面的办法真的很烂

		menuSet = new ArrayList(chRole.getChFuncs());

		// 对菜单进行排序
		Collections.sort(menuSet, new Comparator() {
			public int compare(Object o1, Object o2) {
				String num1 = ((ChFunction) (o1)).getChFuncSortno();
				String num2 = ((ChFunction) (o2)).getChFuncSortno();
				return (num1).compareTo(num2);
			}
		});

		List<String> menuPaths = new ArrayList<String>();
		if (menuSet != null && menuSet.size() > 0) {
			menuList = new ArrayList<ChFunction>();
			List<ChFunction> subList = null;
			for (ChFunction m : menuSet) {// 获得一级菜单
				if (m.getChFunc() != null) {
					if ("1".equals(m.getChFunc().getId())) {
						menuList.add(m);
					}
				}
				if (StringUtils.isNotBlank(m.getChFuncPath())) {
					menuPaths.add(m.getChFuncPath());
				}
			}

			if (menuList.size() > 0) {
				for (ChFunction m : menuList) {// 获得二级菜单
					subList = new ArrayList<ChFunction>();
					for (ChFunction m1 : menuSet) {
						if (m1.getChFunc() != null) {
							if (m.getId().equals(m1.getChFunc().getId())) {
								subList.add(m1);
							}
						}
					}
					m.setSubList(subList);
				}

				for (ChFunction m : menuList) {// 获得三级菜单
					for (ChFunction m2 : m.getSubList()) {
						subList = new ArrayList<ChFunction>();
						for (ChFunction m1 : menuSet) {
							if (m1.getChFunc() != null) {
								if (m2.getId().equals(m1.getChFunc().getId())) {
									subList.add(m1);
								}
							}
						}
						m2.setSubList(subList);
					}
				}
			}

		}

		user.setRoleId(chRole.getId());
		user.setChRole(chRole);
		user.setFuncPaths(menuPaths);
		// 存放国际化
		// Servlets.getSession().put("LOCALE", getLocale());

		return "layout";
	}

	/**
	 * 在线用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String listOnlineUser() throws Exception {
		// 获得当前在线用户的id List
		List<String> userIdList = new ArrayList<String>();
		Map<String, ChUser> onlineUserMap = (Map<String, ChUser>) EhCacheManager
				.getAll(CacheConstants.HTTP_SESSION_CACHE);

		Collection<ChUser> users = onlineUserMap.values();
		Iterator<ChUser> iterator = users.iterator();
		while (iterator.hasNext()) {
			userIdList.add(iterator.next().getId());
		}
		page = userService.findUsers(page, "", "", userIdList);

		return "onlineUser";
	}

	/**
	 * 查询在线用户数量
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getOnlineUserCount() throws Exception {
		Renders.renderHtml(EhCacheManager.getAll(
				CacheConstants.HTTP_SESSION_CACHE).size());
		return NONE;
	}

	/**
	 * 我要留言
	 * 
	 * @return
	 */
	public String leaveAMessage() {
		return "leaveAMessage";
	}

	/**
	 * 在线聊天
	 * 
	 * @return
	 */
	public String onlineChart() {
		return "onlineChart";
	}

	public ChUser getUser() {
		return user;
	}

	public void setUser(ChUser user) {
		this.user = user;
	}

	public List<ChFunction> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(List<ChFunction> menuSet) {
		this.menuSet = menuSet;
	}

	public List<ChFunction> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<ChFunction> menuList) {
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
