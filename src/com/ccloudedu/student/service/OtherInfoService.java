package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChOtherInfo;

/**
 * 学籍信息中的其他信息服务接口
 * @author Pescadito
 * 2013-07-31 09:31
 */
public interface OtherInfoService extends BaseService<ChOtherInfo> {

	/**
	 * 根据学籍信息中的学籍信息id查询学生的其他信息
	 * @param chScroId 学籍信息id
	 * @return
	 * @throws Exception
	 */
	public List<ChOtherInfo> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deleteOtherInfoByScroIds(String[] scroIds)throws Exception;
}
