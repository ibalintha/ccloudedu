package com.ccloudedu.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChFamily;

/**
 * 学生家庭信息管理接口
 * @author Pescadito
 * 2013-07-30 10:35
 */
public interface FamilyInfoService extends BaseService<ChFamily> {

	/**
	 *	通过学籍号来查找学生的家庭信息
	 * @param page
	 * @param chScroSchroll 学籍号
	 * @return
	 * @throws Exception
	 */
	public List<ChFamily> getFamilyById(String chScroId)throws Exception;
	
	/**
	 * 根据家庭信息主键删除家庭信息记录
	 * @param familyId 家庭信息主键
	 * @return
	 * @throws Exception
	 */
	public int delFamilyById(String familyId)throws Exception;
	
	/**
	 * 通过学籍id来删除家庭信息
	 * @return
	 * @throws Exception
	 */
	public void deleteFamilyByScroIds(String[] scroIds)throws Exception;
}
