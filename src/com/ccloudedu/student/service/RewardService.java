package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChReward;

/**
 * 学籍信息管理中的奖惩信息管理接口
 * @author Pescadito
 * 2013-07-31 10:09
 */
public interface RewardService extends BaseService<ChReward> {

	/**
	 * 根据学籍id查询学生的奖惩信息
	 * @param chScroId 学籍id
	 * @return
	 * @throws Exception
	 */
	public List<ChReward> getList(String chScroId)throws Exception;
	
	/**
	 * 通过学籍id来删除评论信息
	 * @return
	 * @throws Exception
	 */
	public void deleteRewardByScroIds(String[] scroIds)throws Exception;
}
