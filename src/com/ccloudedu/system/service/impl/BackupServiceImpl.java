package com.ccloudedu.system.service.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.common.entity.ChBackup;
import com.ccloudedu.quartz.test.BackupJob;
import com.ccloudedu.system.service.BackupService;

@Service
@Transactional
public class BackupServiceImpl extends BaseServiceImpl<ChBackup> implements BackupService {
	
	private String dataBaseDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://127.0.0.1:1433;";
	private String dataBase = "ccloudedu";
	private String user = "sa";
	private String password = "changhong_406";
	private Connection conn = null;
	
	@Override
    public String doBackup(String path, String db_name) throws Exception {
		
		if (db_name.equals(STUDENT_DATABASE))
			db_name=studentDatabase;
		else if(db_name.equals(GRADUATE_DATABASE))
			db_name=graduateDatabase;
		else if(db_name.equals(PIC_DATABASE))
			db_name=picDatabase;
		else if(db_name.equals(LOG_DATABASE))
			db_name=logDatabase;
		
		Class.forName(dataBaseDriver).newInstance();
        url=url+"DatabaseName="+dataBase+";user="+user+";password="+password;
        conn= DriverManager.getConnection(url);
		String bk_name = ""; 

		if (path.lastIndexOf("\\") == -1)
			path += path+File.separator;
		File file = new File(path);
		if (!file.isDirectory())
			Renders.renderJson(new EasyUiResult("0","此路径不存在"));
		PreparedStatement stmt = null;
        String sql = "";
        try
        {
        	String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date())+".bak";
        	
            bk_name = path+fileName; //返回备份文件路径
            
            sql = "backup database "+db_name+" to disk='"+bk_name+"' with format,name='full backup of "+db_name+"'";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
        } catch(Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try{stmt.close();} catch(Exception e){}
        }
        
        return bk_name;
    }

	@Override
    public void backupTask(String path, String database, String expression, String jobName, String trigger) throws Exception {
		// Initiate a Schedule Factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Retrieve a scheduler from schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();
        
        // Initiate CronTrigger with its name and group name
//        CronTrigger cronTrigger = new CronTrigger(jobName, trigger);
        CronTrigger cronTrigger = (CronTrigger)scheduler.getTrigger(jobName, trigger);
        if (cronTrigger != null)
        	scheduler.deleteJob(jobName, "jobDetailGroup2");
        else
        	cronTrigger = new CronTrigger(jobName, trigger);
        
        // Initiate JobDetail with job name, job group, and executable job class
        JobDetail jobDetail = new JobDetail(jobName, "jobDetailGroup2", BackupJob.class);
        
        try {
            // setup CronExpression
            CronExpression cexp = new CronExpression(expression);
            // Assign the CronExpression to CronTrigger
            cronTrigger.setCronExpression(cexp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //set the data for job
        jobDetail.getJobDataMap().put("path", path);
        jobDetail.getJobDataMap().put("db_name", database);
                
        
        // schedule a job with JobDetail and Trigger
        scheduler.scheduleJob(jobDetail, cronTrigger);
        
        // start the scheduler
        scheduler.start();
    }
	
	public static void main(String[] args) throws Exception {
		BackupServiceImpl backup = new BackupServiceImpl();
		backup.doBackup("e:\\", "ccloudedu");
		System.out.println("备份橙红");
	}
}
