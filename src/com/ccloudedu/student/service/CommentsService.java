package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChComment;

/**
 * 学籍信息中的评论信息服务类
 * @author Pescadito
 * 2013-07-31 08:46
 */
public interface CommentsService extends BaseService<ChComment> {

	/**
	 * 根据学籍id来查询学生的评论信息
	 * @param chScroId 学籍id
	 * @return
	 * @throws Exception
	 */
	public List<ChComment> getCommentById(String chScroId)throws Exception;
	
	/**
	 * 根据评论id来删除学生的评论信息
	 * @param commentId 评论信息id
	 * @return
	 * @throws Exception
	 */
	public int deleteCommentById(String commentId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deleteCommentByScroIds(String[] scroIds)throws Exception;
}
