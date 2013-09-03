package com.ccloudedu.student.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.dao.utils.Querys;
import com.ccloudedu.base.dao.utils.builder.HqlBuilder;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.common.entity.ChAdminway;
import com.ccloudedu.common.entity.ChBloodtype;
import com.ccloudedu.common.entity.ChEthnic;
import com.ccloudedu.common.entity.ChFamily;
import com.ccloudedu.common.entity.ChForeign;
import com.ccloudedu.common.entity.ChHealthstatus;
import com.ccloudedu.common.entity.ChPolface;
import com.ccloudedu.common.entity.ChSchoolroll;
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
public class SchoolRollServiceImpl extends BaseServiceImpl<ChSchoolroll> implements SchoolRollService {
	@Autowired
	private BaseHibernateDao<SysDept> deptDao;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@SuppressWarnings("unchecked")
	public Page findSchoolRolls(Page page,String chScroSchcode,String chScroName, String chClasId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chScroSchcode", "%"+chScroSchcode+"%")
		.set("chScroName", "%"+chScroName+"%")
		.set("chClasId", ""+chClasId+"");
		return super.findPage(page,"enrolment.findEnrolments",paramMap);
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public Page findSchoolRolls2(Page page, String chScroSchcode,
			String chScroName, String chClasId) throws Exception {		
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chScroSchcode", "%"+chScroSchcode+"%")
		.set("chScroName", "%"+chScroName+"%")
		.set("chClasId", ""+chClasId+"");
		return this.findPage(page,"enrolment.findEnrolments2",paramMap);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveStudentList(List<ChSchoolroll> studentList)  throws Exception{
		for(ChSchoolroll student : studentList){
			this.save(student);
		}
		return 1;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void update(ChSchoolroll student, String uploadPath, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType)
			throws Exception {
		//更新学生
		update(student);
		//上传学生图片到磁盘、保存图片信息到数据库
		uploadFileService.upload(student.getId(), uploadPath, upload, uploadFileName, uploadContentType);
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
	public ChSchoolroll findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return super.findOne(hqlBuilder);
	}

	@Override
	public ChSchoolroll get(Serializable id) throws Exception {
		ChSchoolroll cs = super.get(id);
		return cs;
	}



}
