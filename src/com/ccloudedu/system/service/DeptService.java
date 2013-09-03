package com.ccloudedu.system.service;

import java.util.List;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.system.entity.SysDept;

public interface DeptService extends BaseService<SysDept>{
    
	public int getCountSubDeptNumByParentId(String parentId) throws Exception;

	public List<SysDept> findListByDeptLevel() throws Exception;

	public SysDept findDeptByDeptName(String deptName) throws Exception;

	public int saveDeptList(List<SysDept> deptList) throws Exception;

	public Page findPage(Page page, String id) throws Exception;
}
