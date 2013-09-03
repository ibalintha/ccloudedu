package com.ccloudedu.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.system.entity.SysMenu;
import com.ccloudedu.system.service.MenuService;
@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<SysMenu> implements MenuService {
	
}
