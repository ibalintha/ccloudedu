package com.ccloudedu.oa.work.service;

import java.io.File;
import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.oa.work.entity.OaProject;
import com.ccloudedu.oa.work.entity.OaProjectSchedule;

public interface OaProjectScheduleService extends BaseService<OaProjectSchedule>{

	public int save(OaProject oaProject,
			OaProjectSchedule oaProjectSchedule, List<String> roleIds,
			List<String> userIds, List<String> startDts, List<String> endDts,
			List<String> descriptions, String uploadPath,List<File> upload,List<String> uploadFileName, List<String> uploadContentType)throws Exception;
}
