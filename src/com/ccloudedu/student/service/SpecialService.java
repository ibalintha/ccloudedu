package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChSpecial;

/**
 * 学籍信息中的特长信息服务接口
 * @author Pescadito
 * 2013-07-31 10:15
 */
public interface SpecialService extends BaseService<ChSpecial> {

	/**
	 * 根据学籍id查询学生的特长信息
	 * @param chScroId 学籍id
	 * @return
	 * @throws Exception
	 */
	public List<ChSpecial> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deleteSpecialByScroIds(String[] scroIds)throws Exception;
}
