package com.ccloudedu.system.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChTeacher;

/**
 * teacher管理服务接口
 * @author yueyongsheng
 * 2013-07-11
 */
public interface TeacherService extends BaseService<ChTeacher> {

	/**
	 * 查询所有的老师
	 * @return
	 * @throws Exception
	 */
	public List<ChTeacher> findTeachers() throws Exception;
}
