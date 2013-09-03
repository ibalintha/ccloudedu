package com.ccloudedu.system.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChRecord;

/*
 * 日志管理
 * @author xub
 * 2013-07-23
 * */

public interface RecordService extends BaseService<ChRecord>{
	/*
	 * *@param:
	 * chFuncModuel:功能模块
	 * chRecdType：日志类型-新增、删除、系统异常、其他
	 * chRecdDesc：日志描述
	 * chRecdMemo：备注
	 */
	public void saveOperLog(String chFuncModuel,String chRecdType,String chRecdDesc,String chRecdMemo)throws Exception;
}
