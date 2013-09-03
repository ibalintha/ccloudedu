package com.ccloudedu.system.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.dao.utils.Querys;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.system.entity.SysDept;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.UserService;
import com.ccloudedu.upload.service.UploadFileService;
import com.ccloudedu.workflow.common.entity.WfExecutor;

/**
 * 用户基本信息管理类
 * @author wade
 *
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<SysUser> implements UserService {
	@Autowired
	private BaseHibernateDao<SysDept> deptDao;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@SuppressWarnings("unchecked")
	public Page findUsers(Page page,String deptId,String roleId,String userName,List<String> userIdList) throws Exception {
		SysUser user = Sessions.getSysUser();
		String parentDeptLevel = deptDao.get(SysDept.class, user.getSysDept().getId()).getDeptLevel();
		
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set(Querys.PREFIX+"roleId", roleId)
		.set("deptId", deptId)
		.set("roleId", roleId)
		.set("userName", "%"+userName+"%")
		.set("userIdList", userIdList)//userIdList !=null 时，是查看在线用户
		.set("parentDeptLevel", (userIdList==null && user.getUserRoleType()==YN.N)?parentDeptLevel+"%":null);
		
		return this.findPage(page,"system.findUsers",paramMap);
	}
	
	/**
	 * 查询流程执行人
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<WfExecutor> findWfExecutor(String roleId,String wfCat,String operateType) throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap().set("roleId", roleId).set("wfCat", wfCat).set("operateType", operateType);
		return this.findList("workflow.findWfExecutor",paramMap);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveUserList(List<SysUser> userList) throws Exception{
		for(SysUser user : userList){
			this.save(user);
		}
		return 1;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void update(SysUser user, String uploadPath, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType)
			throws Exception {
		
		//更新用户
		update(user);
		
		//上传用户图片到磁盘、保存图片信息到数据库
		uploadFileService.upload(user.getId(), uploadPath, upload, uploadFileName, uploadContentType);
	}
}
