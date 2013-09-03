package com.ccloudedu.system.service;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChBackup;

public interface BackupService extends BaseService<ChBackup> {

	public static final String STUDENT_DATABASE = "在校学生信息库";
	public static final String GRADUATE_DATABASE = "毕业学生信息库";
	public static final String PIC_DATABASE = "图片库";
	public static final String LOG_DATABASE = "日志库";
	public final String studentDatabase = "ccloudedu";
	public final String graduateDatabase = "ccloudedu1";
	public final String picDatabase = "ccloudedu2";
	public final String logDatabase = "ccloudedu3";
	
	public String doBackup(String path,String db_name) throws Exception;
	
	public void backupTask(String path, String database, String expression, String jobName, String trigger) throws Exception;
}
