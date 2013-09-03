package com.ccloudedu.system.action;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.file.PropertiesUtils;
import com.ccloudedu.base.utils.file.UploadUtils;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.system.entity.SysAccessLog;
import com.ccloudedu.system.entity.SysAccessLogFile;
/**
 * 
 * @author 系统访问日志
 *
 */
@Controller("system.action.AccessLogAction")
@Scope("prototype")
public class AccessLogAction  extends BaseCrudAction<SysAccessLog>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysAccessLog accessLog;
	 
	
	private String id;
	//每页显示10条记录
    private Page page = new Page(Constants.PAGE_SIZE);
	//@Autowired
    //private AccessLogService accessLogService;
	//查询参数
	private String accessUserId;
	private String accessUserName;
	private String startAccessTime;
	private String endAccessTime;
	
    
	private Map<String,String> logFileMap;
	private String logPath;

	public SysAccessLog getModel() {
		return accessLog;
	}
	
	public void prepareModel() throws Exception {
	 
	}
	@Override
	public String update() throws Exception {
		
		return null;
	}
	
	@Override
	public String detail() throws Exception {
		//accessLog = accessLogService.get(id);
		return DETAIL;
	}
	
	public String downLoad() throws Exception {
		File file = new File(logPath);
		String fileName = "AccessLogFile.log";
		UploadUtils.download(file, fileName);
		return NONE;
	}
	@Override
	public String add() throws Exception {
		
		return NONE;
	}
	public String save() throws Exception {
		
		return NONE;
	}
	@Menu
	public String list() throws Exception {
		
		String logFilePath="";
		URL url = getClass().getClassLoader().getResource("/");
		if(url.getPath().contains("classes")){
			String serverRoot = new File(url.getPath()).getParentFile().getParentFile().getParentFile().getParent() + File.separator;
		    logFilePath = serverRoot+"logs\\ccloudedu\\"; 
		}else
		{
			logFilePath = url.getPath().substring(0,url.getPath().indexOf(":")+1)+PropertiesUtils.getPropertyValue("accesslog.properties", "log.path");  
		}  
	 
		File file = new File(logFilePath);
	    
		FileFilter filter = new FileFilter() {                            
			public boolean accept(File file) {                          
				String tmp = file.getName().toLowerCase();      
				 return true;
//				if (tmp.startsWith("accesslogfile.log") 
//						|| tmp.startsWith("systemfile.log")
//						||tmp.startsWith("logfile.log")
//						||tmp.startsWith("errorfile.log")
//						) {   
//					System.out.println("*********"+tmp);
//					return true;                        
//				}  
//				return false;             
			}       
		};  
		//map有序
		logFileMap = new LinkedHashMap<String, String>();
		List logfiles = new ArrayList();
		File[] files = file.listFiles(filter);
		if(files==null)return LIST;
		
		for(File f : files){
			//文件最后修改日期+文件路径
			String filePath = f.getPath();
			int lastIndexOf = filePath.lastIndexOf(".");
			String fileCreateDate = filePath.substring(lastIndexOf+1,filePath.length());
			String fileLastModifiedDate = DateUtils.dateToString(new Date(file.lastModified()), "yyyy-MM-dd");
			if(fileCreateDate.equals("log")){
				fileCreateDate = fileLastModifiedDate;
			}
			SysAccessLogFile accessLogFile = new SysAccessLogFile( filePath,fileCreateDate);
			logfiles.add(accessLogFile);
		    logFileMap.put(fileCreateDate, filePath);
		}  
		List list = new ArrayList();
		for(int i=10*(page.getCurrentPage()-1);i<10*(page.getCurrentPage())&&i<logfiles.size();i++){ 
			list.add(logfiles.get(i));
		}
		
		page=new Page(list,page.getCurrentPage(),logfiles.size(),10,page.getOrderattr(),page.getOrdertype());
		//page = accessLogService.findPage(page,accessUserId,accessUserName,startAccessTime,endAccessTime);
		return LIST;
	}
	
	public String delete() throws Exception {
		return NONE;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public SysAccessLog getAccessLog() {
		return accessLog;
	}
	public void setAccessLog(SysAccessLog accessLog) {
		this.accessLog = accessLog;
	}
	public String getAccessUserId() {
		return accessUserId;
	}
	public void setAccessUserId(String accessUserId) {
		this.accessUserId = accessUserId;
	}
	public String getAccessUserName() {
		return accessUserName;
	}
	public void setAccessUserName(String accessUserName) {
		this.accessUserName = accessUserName;
	}
	public String getStartAccessTime() {
		return startAccessTime;
	}
	public void setStartAccessTime(String startAccessTime) {
		this.startAccessTime = startAccessTime;
	}
	
	public String getEndAccessTime() {
		return endAccessTime;
	}
	public void setEndAccessTime(String endAccessTime) {
		this.endAccessTime = endAccessTime;
	}
	/*public void setAccessLogService(AccessLogService accessLogService) {
		this.accessLogService = accessLogService;
	}*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Map<String, String> getLogFileMap() {
		return logFileMap;
	}
	public void setLogFileMap(Map<String, String> logFileMap) {
		this.logFileMap = logFileMap;
	}
	public String getLogPath() {
		return logPath;
	}
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
	
	
	 
}
