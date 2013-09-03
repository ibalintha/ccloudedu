package com.ccloudedu.system.service;

import java.io.File;
import java.util.List;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.workflow.common.entity.WfExecutor;

/**
 * @author wade
 */
public interface UserService extends BaseService<SysUser> {
	
	/**
	 * 按条件查询用户
	 */
	public Page findUsers(Page page,String deptId,String roleId,String userName,List<String> userIdList) throws Exception;

	/**
	 * 同时保存多个SysUser，在excel导入用户时使用
	 * @param userList
	 * @return
	 * @throws Exception
	 */
	public int saveUserList(List<SysUser> userList) throws Exception;

	/**
	 * 查询流程执行人
	 * @param roleId
	 * @return
	 */
	public List<WfExecutor> findWfExecutor(String roleId,String wfCat,String operateType) throws Exception;

	/**
	 * 更新用户信息，带用户图片
	 * @param user
	 * @param uploadPath
	 * @param upload
	 * @param uploadFileName
	 * @param uploadContentType
	 * @throws Exception
	 */
	public void update(SysUser user, String uploadPath, List<File> upload,List<String> uploadFileName, List<String> uploadContentType) throws Exception;
}
