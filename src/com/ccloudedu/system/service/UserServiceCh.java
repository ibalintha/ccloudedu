package com.ccloudedu.system.service;

import java.io.File;
import java.util.List;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChUser;
import com.ccloudedu.workflow.common.entity.WfExecutor;

/**
 * @author yueyongsheng
 * 2013-07-08 
 */
public interface UserServiceCh extends BaseService<ChUser> {
	
	/**
	 * 按条件查询用户
	 */
	public Page findUsers(Page page,String roleId,String userName,List<String> userIdList) throws Exception;

	/**
	 * 同时保存多个SysUser，在excel导入用户时使用
	 * @param userList
	 * @return
	 * @throws Exception
	 */
	public int saveUserList(List<ChUser> userList) throws Exception;

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
	public void update(ChUser user, String uploadPath, List<File> upload,List<String> uploadFileName, List<String> uploadContentType) throws Exception;
	
	/**
	 * 改变用户状态
	 * @param userId
	 * @param userState
	 * @throws Exception
	 */
	public void changeUserState(ChUser user) throws Exception;
	
	/**
	 * 保存或更新用户，包含了用户角色的权限范围
	 * @param user
	 * @param funcIds
	 * @param roleIds
	 * @throws Exception
	 */
	public void saveOrUpdate(ChUser user, String funcIds, String roleIds) throws Exception;
}
