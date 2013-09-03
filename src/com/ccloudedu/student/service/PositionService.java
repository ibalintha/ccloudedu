package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChPosition;

/**
 * 学籍信息中的职务信息的服务接口
 * @author Pescadito
 * 2013-07-31 09:39
 */
public interface PositionService extends BaseService<ChPosition> {

	/**
	 * 根据学籍id查询学生的职务信息
	 * @param chScroId 学籍id
	 * @return
	 * @throws Exception
	 */
	public List<ChPosition> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deletePostionByScroIds(String[] scroIds)throws Exception;
}
