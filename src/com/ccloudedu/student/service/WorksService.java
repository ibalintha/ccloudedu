package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChWorks;

/**
 * 学籍管理中的学生作品服务接口
 * @author Pescadito
 * 2013-07-31 10:46
 */
public interface WorksService extends BaseService<ChWorks> {

	/**
	 * 通过学生的学籍id查询学生的作品信息
	 * @param chScroId 学籍id
	 * @return
	 * @throws Exception
	 */
	public List<ChWorks> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deleteWorksByScroIds(String[] scroIds)throws Exception;
}
