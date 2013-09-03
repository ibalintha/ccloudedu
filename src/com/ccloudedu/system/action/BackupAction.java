package com.ccloudedu.system.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.common.entity.ChBackup;
import com.ccloudedu.system.service.BackupService;

/**
 * 数据库备份管理action
 * @author yueyongsheng
 * 2013-07-23
 */
@Controller("system.action.BackupAction")
@Scope("prototype")
public class BackupAction extends BaseCrudAction<ChBackup> {
    private static final long serialVersionUID = 5481479648465109518L;

    private String id;
	private ChBackup backup;
	private ChBackup chBackup;
	private String backDatabase;
	private String backWay;
	
	private List<ChBackup> chBackups;

	@Autowired
    private BackupService backupService;
	
	@Override
    public String add() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String delete() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String detail() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
	@Menu
    public String list() throws Exception {
	    return "list";
    }

	@Override
    public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			backup = new ChBackup();
		}
    }

	@SuppressWarnings("unchecked")
    @Override
    public String save() throws Exception {
		String backupWay = Servlets.getRequest().getParameter("chBaupWay");
		String backRate = Servlets.getRequest().getParameter("chBaupRate");
		String path=Servlets.getRequest().getParameter("chBaupPath");
		if (path==null || path == "" || path.equals(""))
			path="c:\\";
		String db_name=Servlets.getRequest().getParameter("chBaupDatabase");
		if (backupWay.equals("手动备份数据库")) {
			String fileName = backupService.doBackup(path, db_name);
			if (fileName == null || fileName.equals("") || fileName == "")
				Renders.renderJson(new EasyUiResult("0","备份数据库失败"));
			else {
				backup.setChBaupPath(fileName);
				backupService.save(backup);
				Renders.renderJson(new EasyUiResult("0","备份数据库成功"));
			}
		} else {
			Map<String,String> paramMap = new FastMap().newHashMap().set("backWay", backupWay).set("database", db_name).set("backRate", backRate);
			chBackup = backupService.findOne("system.findBackups", paramMap);
			if (chBackup != null)
				backupService.deleteById(chBackup.getId());
			
			backup.setChBaupPath("c:\\");
			backupService.save(backup);
			Renders.renderJson(new EasyUiResult("0","自动备份数据库设置成功"));
			task(backup);
		}
		
		
	    return NONE;
    }
	
    public void task(ChBackup backup) throws Exception
    {
		String db_name = backup.getChBaupDatabase();
		if (db_name.equals(BackupService.STUDENT_DATABASE))
			db_name=BackupService.studentDatabase;
		else if(db_name.equals(BackupService.GRADUATE_DATABASE))
			db_name=BackupService.graduateDatabase;
		else if(db_name.equals(BackupService.PIC_DATABASE))
			db_name=BackupService.picDatabase;
		else if(db_name.equals(BackupService.LOG_DATABASE))
			db_name=BackupService.logDatabase;
		
		String path = backup.getChBaupPath();
			String time = backup.getChBaupBegtime();
			String rate = backup.getChBaupRate();
			int index = time.indexOf(":");
			String expression = "0 " + time.substring(index+1)+" "+time.substring(0, index);
			
			if (rate.equals("每日"))
				expression = " * * ?";
			else if (rate.equals("每周"))
				expression += " ? * "+getWeek();
			else if (rate.equals("每月"))
				expression += " "+getDay()+" * ?";
			
			backupService.backupTask(path, db_name, expression, db_name, db_name);
		
    }
    
    private String getWeek() {
    	Calendar calendar =Calendar.getInstance();
    	calendar.setTime(new Date());
    	int day = calendar.get(Calendar.DAY_OF_WEEK);
    	return String.valueOf(day);
    }
    
    private String getDay() {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd");
    	String date = formatter.format(new Date());
    	return date;
    }

	@Override
    public String update() throws Exception {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public ChBackup getModel() {
	    return backup;
    }
	
	public String getId() {
    	return id;
    }

	public void setId(String id) {
    	this.id = id;
    }

	public ChBackup getBackup() {
    	return backup;
    }

	public void setBackup(ChBackup backup) {
    	this.backup = backup;
    }

	public List<ChBackup> getChBackups() {
    	return chBackups;
    }

	public void setChBackups(List<ChBackup> chBackups) {
    	this.chBackups = chBackups;
    }
	
	public String getBackDatabase() {
    	return backDatabase;
    }

	public void setBackDatabase(String backDatabase) {
    	this.backDatabase = backDatabase;
    }

	public String getBackWay() {
    	return backWay;
    }

	public void setBackWay(String backWay) {
    	this.backWay = backWay;
    }
}
