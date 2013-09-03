package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChPractice;

/**
 * 学生学籍信息中的实践信息服务接口
 * @author Pescadito
 * 2013-07-31 09:48
 */
public interface PracticeService extends BaseService<ChPractice> {

	/**
	 * 根据学籍id查询学生的实践信息
	 * @param chScroId 学籍id
	 * @return
	 * @throws Exception
	 */
	public List<ChPractice> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deletePracticeByScroIds(String[] scroIds)throws Exception;
}
