package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChResume;

/**
 * 学籍信息中的简历信息服务接口
 * @author Pescadito
 * 2013-07-31 10:02
 */
public interface ResumeService extends BaseService<ChResume> {

	/**
	 * 根据学籍id查询用户的学籍信息中的简历信息
	 * @param chScroId
	 * @return
	 * @throws Exception
	 */
	public List<ChResume> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deleteResumeByScroIds(String[] scroIds)throws Exception;
}
