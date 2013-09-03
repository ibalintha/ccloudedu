package com.ccloudedu.student.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChAdminway;
import com.ccloudedu.common.entity.ChBloodtype;
import com.ccloudedu.common.entity.ChClasstree;
import com.ccloudedu.common.entity.ChEthnic;
import com.ccloudedu.common.entity.ChForeign;
import com.ccloudedu.common.entity.ChHealthstatus;
import com.ccloudedu.common.entity.ChPolface;
import com.ccloudedu.common.entity.ChStudent;
import com.ccloudedu.student.entity.ChReportList;

/**
 * @author wade
 */
public interface StudentService extends BaseService<ChStudent> {
	
	/**
	 * 按条件查询用户
	 */
	public Page findStudents(Page page,String chClasId,String chStudSchcode,String chStudName,String chStudSex) throws Exception;

	/**
	 * 按条件查询用户2
	 */
	public Page findStudents2(Page page,String chClasId,String chStudSchcode,String chStudName,String chStudSex) throws Exception;

	
	/**
	 * 同时保存多个SysUser，在excel导入用户时使用
	 * @param userList
	 * @return
	 * @throws Exception
	 */
	public int saveStudentList(List<ChStudent> studentList) throws Exception;
	/**
	 * 更新用户信息，带用户图片
	 * @param user
	 * @param uploadPath
	 * @param upload
	 * @param uploadFileName
	 * @param uploadContentType
	 * @throws Exception
	 */
	public void update(ChStudent student, String uploadPath, List<File> upload,List<String> uploadFileName, List<String> uploadContentType) throws Exception;
	
	//public List<ChStudent> findListByids(String ids) throws Exception;
	
	public List<ChAdminway> findListByChAdminway() throws Exception;
	public List<ChBloodtype> findListByChBloodtype() throws Exception;
	public List<ChEthnic> findListByChEthnic() throws Exception;
	public List<ChForeign> findListByChForeign() throws Exception;
	public List<ChHealthstatus> findListByChHealthstatus() throws Exception;
	public List<ChPolface> findListByChPolface() throws Exception;
	
	public List<ChClasstree> findListByChClasstree() throws Exception;
	
	public int updateSchcode(String id,String schcode) throws Exception;
	
	public List<ChReportList> findListByChReportList() throws Exception;
	
	public List<ChStudent> findStudentsByClassId(String stucode , String chClasId) throws Exception;

}
