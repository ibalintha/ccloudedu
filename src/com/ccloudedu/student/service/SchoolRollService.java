package com.ccloudedu.student.service;

import java.io.File;
import java.util.List;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChFamily;
import com.ccloudedu.common.entity.ChSchoolroll;

/**
 * 学籍管理的服务类
 * @author Pescadito
 * 2013-07-23 10:23
 */
public interface SchoolRollService extends BaseService<ChSchoolroll> {
	

	/**
	 * 按条件查询学籍信息
	 * @param page 分页原则
	 * @param chScroSchcode 学号
	 * @param chScroName 姓名
	 * @param chClasId 班级id	 
	 * @return
	 * @throws Exception
	 */
	public Page findSchoolRolls(Page page,String chScroSchcode,String chScroName,String chClasId) throws Exception;

	/**
	 * 按条件查询学籍信息
	 * @param page 分页原则
	 * @param chScroSchcode 学号
	 * @param chScroName 姓名
	 * @param chClasId 班级id
	 * @return
	 * @throws Exception
	 */
	public Page findSchoolRolls2(Page page,String chScroSchcode,String chScroName,String chClasId) throws Exception;


	
	/**
	 * 同时保存多个SysUser，在excel导入用户时使用
	 * @param userList
	 * @return
	 * @throws Exception
	 */
	public int saveStudentList(List<ChSchoolroll> studentList) throws Exception;
	/**
	 * 更新用户信息，带用户图片
	 * @param user
	 * @param uploadPath
	 * @param upload
	 * @param uploadFileName
	 * @param uploadContentType
	 * @throws Exception
	 */
	public void update(ChSchoolroll student, String uploadPath, List<File> upload,List<String> uploadFileName, List<String> uploadContentType) throws Exception;
	

	
}
