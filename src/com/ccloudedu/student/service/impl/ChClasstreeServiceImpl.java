package com.ccloudedu.student.service.impl;

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
import com.ccloudedu.common.entity.ChAdminway;
import com.ccloudedu.common.entity.ChBloodtype;
import com.ccloudedu.common.entity.ChClasstree;
import com.ccloudedu.common.entity.ChEthnic;
import com.ccloudedu.common.entity.ChForeign;
import com.ccloudedu.common.entity.ChHealthstatus;
import com.ccloudedu.common.entity.ChPolface;
import com.ccloudedu.common.entity.ChSchoolroll;
import com.ccloudedu.student.service.ChClasstreeService;
import com.ccloudedu.student.service.SchoolRollService;
import com.ccloudedu.system.entity.SysDept;
import com.ccloudedu.upload.service.UploadFileService;
import com.ccloudedu.workflow.common.entity.WfExecutor;

/**
 * 用户基本信息管理类
 * @author wade
 *
 */
@Service
@Transactional
public class ChClasstreeServiceImpl extends BaseServiceImpl<ChClasstree> implements ChClasstreeService {
	@Autowired
	private BaseHibernateDao<SysDept> deptDao;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@SuppressWarnings("unchecked")
	public Page findStudents(Page page,String chStudSchcode,String chStudName) throws Exception {
//		String parentDeptLevel = deptDao.get(SysDept.class, user.getSysDept().getId()).getDeptLevel(); 
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chStudSchcode", "%"+chStudSchcode+"%")
		.set("chStudName", "%"+chStudName+"%");
//		.set("userIdList", userIdList)//userIdList !=null 时，是查看在线用户 && user.getUserRoleType()==YN.N
//		.set("parentDeptLevel", null); 
		return this.findPage(page,"student.findStudents",paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<ChAdminway> findListByChAdminway(Map<String, ?> paramMap)
			throws Exception {
		return findList("system.findListByChAdminway", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChBloodtype> findListByChBloodtype(Map<String, ?> paramMap)
			throws Exception {
		return findList("system.findListByChBloodtype", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChEthnic> findListByChEthnic(Map<String, ?> paramMap)
			throws Exception {
		return findList("system.findListByChEthnic", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChForeign> findListByChForeign(Map<String, ?> paramMap)
			throws Exception {
		return findList("system.findListByChForeign", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChHealthstatus> findListByChHealthstatus(Map<String, ?> paramMap)
			throws Exception {
		return findList("system.findListByChHealthstatus", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChPolface> findListByChPolface(Map<String, ?> paramMap)
			throws Exception {
		return findList("system.findListByChPolface", paramMap);
	}


	@SuppressWarnings("unchecked")
	public int updateSchcode(String id, String schcode) throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("id", ""+id+"")
		.set("chStudSchcode", ""+schcode+"");
		return batch("student.updatechStudSchcode",paramMap);
	}

	@Override
	public List<ChClasstree> findClasstree(String id, String parentId,
			String name) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("id", id)
		.set("parentId", parentId)
		.set("name", name);
		return findList("system.findClasstree",paramMap);
	}

}
