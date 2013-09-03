package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChHomeVisite;

/**
 * 学籍信息中的家访信息服务接口
 * @author Pescadito
 * 2013-07-31 09:22
 */
public interface HomeVisiteService extends BaseService<ChHomeVisite> {

	/**
	 * 根据学籍id查询学生信息中的家访信息
	 * @param chScroId 学籍id
	 * @return
	 * @throws Exception
	 */
	public List<ChHomeVisite> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除家访信息
	 * @return
	 * @throws Exception
	 */
	public void deleteHomeVisiteByScroIds(String[] scroIds)throws Exception;
}
