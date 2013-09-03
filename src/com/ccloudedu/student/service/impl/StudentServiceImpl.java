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
import com.ccloudedu.common.entity.ChStudent;
import com.ccloudedu.student.entity.ChReportList;
import com.ccloudedu.student.service.StudentService;
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
public class StudentServiceImpl extends BaseServiceImpl<ChStudent> implements StudentService {
	@Autowired
	private BaseHibernateDao<SysDept> deptDao;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@SuppressWarnings("unchecked")
	public Page findStudents(Page page,String chClasId,String chStudSchcode,String chStudName,String chStudSex) throws Exception {
//		String parentDeptLevel = deptDao.get(SysDept.class, user.getSysDept().getId()).getDeptLevel(); 
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chStudSchcode", "%"+chStudSchcode+"%")
		.set("chStudName", "%"+chStudName+"%")
		.set("chStudSex","%"+chStudSex+"%")
		.set("chClasId", ""+chClasId+"");
//		.set("userIdList", userIdList)//userIdList !=null 时，是查看在线用户 && user.getUserRoleType()==YN.N
//		.set("parentDeptLevel", null); 
		return this.findPage(page,"student.findStudents",paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public Page findStudents2(Page page,String chClasId,String chStudSchcode,String chStudName,String chStudSex) throws Exception {
//		String parentDeptLevel = deptDao.get(SysDept.class, user.getSysDept().getId()).getDeptLevel(); 
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chStudSchcode", "%"+chStudSchcode+"%")
		.set("chStudName", "%"+chStudName+"%")
		.set("chStudSex","%"+chStudSex+"%")
		.set("chClasId", ""+chClasId+"");
//		.set("userIdList", userIdList)//userIdList !=null 时，是查看在线用户 && user.getUserRoleType()==YN.N
//		.set("parentDeptLevel", null); 
		return this.findPage(page,"student.findStudents2",paramMap);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveStudentList(List<ChStudent> studentList)  throws Exception{
		for(ChStudent student : studentList){
			this.save(student);
		}
		return 1;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void update(ChStudent student, String uploadPath, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType)
			throws Exception {
		//更新学生
		update(student);
		//上传学生图片到磁盘、保存图片信息到数据库
		uploadFileService.upload(student.getId(), uploadPath, upload, uploadFileName, uploadContentType);
	}
	@SuppressWarnings("unchecked")
	public List<ChAdminway> findListByChAdminway()
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("chAdwaName", null);
		return findList("system.findListByChAdminway", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChBloodtype> findListByChBloodtype()
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("chBdtpName", null);
		return findList("system.findListByChBloodtype", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChEthnic> findListByChEthnic()
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("chEthnName", null);
		return findList("system.findListByChEthnic", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChForeign> findListByChForeign()
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("chFognName", null);
		return findList("system.findListByChForeign", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChHealthstatus> findListByChHealthstatus()
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("chHestName", null);
		return findList("system.findListByChHealthstatus", paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChPolface> findListByChPolface()
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("chPlfaName", null);
		return findList("system.findListByChPolface", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<ChClasstree> findListByChClasstree()
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap().set("name", null);
		return findList("system.findListByChClasstree", paramMap);
	}
	
//	@SuppressWarnings("unchecked")
//	public List<ChStudent> findListByids(String ids)
//			throws Exception {
//		Map<String,String> paramMap = new FastMap().newHashMap().set("ids", ids);
//		return findList("student.findStudentsBy", paramMap);
//	}

	@SuppressWarnings("unchecked")
	public int updateSchcode(String id, String schcode) throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("id", ""+id+"")
		.set("chStudSchcode", ""+schcode+"");
		return batch("student.updatechStudSchcode",paramMap);
	}
	@SuppressWarnings("unchecked")
	public List<ChReportList> findListByChReportList() throws Exception {
		// TODO Auto-generated method stub
		
		Map<String,String> paramMap = new FastMap().newHashMap().set("chReportName", null);
		return findList("system.findListByChReportList", paramMap);
	}

	@Override
	public List<ChStudent> findStudentsByClassId(String chStudSchcode,String chClasId) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chStudSchcode ", chStudSchcode)
		.set("chClasId", chClasId);
		return findList("student.findStudentsByClassId",paramMap);
	}

}
