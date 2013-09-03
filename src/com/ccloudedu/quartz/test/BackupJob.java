package com.ccloudedu.quartz.test;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccloudedu.system.service.BackupService;
import com.ccloudedu.system.service.impl.BackupServiceImpl;
/**
 * 自动备份数据的定时任务
 * @author yueyongsheng
 * 2013-07-25
 */
public class BackupJob implements Job {
	
	@Autowired
	private BackupService backupService;
	private String path;
	private String db_name;

	public BackupJob(){
		backupService = new BackupServiceImpl();
	}
	
	public BackupJob(BackupService backupService,String path, String db_name){
		this.backupService = backupService;
		this.path = path;
		this.db_name = db_name;
	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			JobDataMap dataMap = context.getJobDetail().getJobDataMap();
			path = dataMap.getString("path");
			db_name = dataMap.getString("db_name");
//			System.out.println("In SimpleQuartzJob - executing its JOB at " 
//	                + new Date() + " by " + path  + " " + db_name);
	        backupService.doBackup(path, db_name);
        } catch (Exception e) {
	        e.printStackTrace();
        }
	}

}
