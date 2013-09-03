package com.ccloudedu.system.action.report;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.FontKey;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.PdfFont;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.file.PropertiesUtils;
import com.ccloudedu.base.utils.file.UploadUtils;
import com.ccloudedu.base.utils.report.ExcelUtils;
import com.ccloudedu.base.utils.report.PdfUtils;
import com.ccloudedu.base.utils.string.EncodeUtils;
import com.ccloudedu.base.utils.string.StringEncodeUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseAuthAction;
import com.ccloudedu.report.entity.Person;
import com.ccloudedu.report.service.PersonService;
import com.ccloudedu.system.entity.SysDept;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.DeptService;
import com.ccloudedu.system.service.RoleService;
import com.ccloudedu.system.service.UserService;
 

/**
 * 用户报表
 * @author wade
 */
@Controller("system.action.report.UserReportAction")
@Scope("prototype")
public class UserReportAction extends BaseAuthAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private SysUser user;
	//用户id
	private String userName;
	private String deptId;
	private String roleIds="";
	private String roleNames;
	
	private File upload; //附件
	
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	
	private Page page = new Page(Constants.PAGE_SIZE);
	
	/**
      * 通过excel导入用户	
      * @return
      */
	 public String toImportUser(){
		 return "toImportUser";
	 }
	/**
	 * 下载excel模板
	 * @return
	 * @throws Exception
	 */
	public String download()throws Exception{
		UploadUtils.download("用户模板.xls","/uploadfile/templete/user_templete.xlsx");
       return NONE;
	}
	
	/**
	 * 导出用户列表excel
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String exportExcel2()throws Exception{
		page = userService.findUsers(page, deptId,roleIds,userName,null);
		List<SysUser> list = page.getList();
		//对于不少来自数据库的、在getter/setter方法中设置的数据，调用getter/setter方法，刷新数据
		for(SysUser u : list){
			u.getSexTemp();
			u.getDeptNameTemp();
			u.getRoleNameTemp();
		}
		//excel模板
		Workbook wb = ExcelUtils.getWorkbook("/uploadfile/templete/user_templete.xlsx");
		Sheet sheet = wb.getSheetAt(0);
		
		//导出的列
		String[] propertyNames = {"userName","enUserName","birthday","sexTemp","ophone","mphone","mailbox","deptNameTemp","roleNameTemp"};
		ExcelUtils.toCellByList(sheet, 2, 0, list, propertyNames);
		Renders.renderExcel(wb, "用户列表.xlsx");
		return NONE;
		//return "exportExcel";
	}
	/**
	 * 导出一个用户详细信息到excel
	 * @return
	 * @throws Exception
	 */
	public String exportExcelDetail() throws Exception{
		user = userService.get(id);
		String roleNames = "";
		List<SysRole> roleList = user.getSysRoles();
		if(roleList!=null && roleList.size()>0){
			for(SysRole role : roleList){
				roleNames+=","+role.getRoleName();
			}
			roleNames = roleNames.replaceFirst(",", "");
		}

		Workbook wb = ExcelUtils.getWorkbook("/uploadfile/templete/user_detail_templete.xlsx");
		Sheet sheet = wb.getSheetAt(0);
		ExcelUtils.toCellByValue(sheet, 2,1,user.getLoginName());
		ExcelUtils.toCellByValue(sheet, 4,1,user.getUserName());
		ExcelUtils.toCellByValue(sheet, 4,3,user.getEnUserName());
		ExcelUtils.toCellByValue(sheet, 5,1,user.getBirthday());
		ExcelUtils.toCellByValue(sheet, 5,3,user.getSex().equals("F")?"女":"男");
		ExcelUtils.toCellByValue(sheet, 6,1,user.getSysDept().getDeptName());
		ExcelUtils.toCellByValue(sheet, 6,3,roleNames);
		ExcelUtils.toCellByValue(sheet, 7,1,user.getOphone());
		ExcelUtils.toCellByValue(sheet, 7,3,user.getMphone());
		ExcelUtils.toCellByValue(sheet, 8,1,user.getMailbox());
		ExcelUtils.toCellByValue(sheet, 8,3,user.getRegisterTime());
		ExcelUtils.toCellByValue(sheet, 9,1,user.getWorkPlace());

		Renders.renderExcel(wb, "用户详细信息.xlsx");
		return NONE;
	}
	
	/**
	 * 导入用户
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
    public String importExcel() throws Exception {
		String msg = "导入成功";
		
        Workbook wb = ExcelUtils.getWorkbook(new FileInputStream(upload));
		Sheet sheet = wb.getSheetAt(0);
		
	    String[] propertyNames = {"userName","enUserName","birthday","sex","ophone","mphone","mailbox","deptNameTemp","roleNameTemp"};
	    List<SysUser> userListTemp = ExcelUtils.toBeanList(sheet, 2, 0, SysUser.class, propertyNames);
		List<String> errorMsgList = ExcelUtils.errorMsgList;
		List<SysUser> userList = new ArrayList<SysUser>();
		
	    Map<String,SysDept> deptMap = (Map<String, SysDept>) deptService.findMap("system.findDepts","deptName",SysDept.class, null);
	    Map<String,SysRole> roleMap = (Map<String, SysRole>) roleService.findMap("system.findRoles","roleName",SysRole.class, null);
	    
		int i=2;
		for(SysUser u : userListTemp){
			i++;
			SysDept dept = deptMap.get(u.getDeptNameTemp().trim());
        	if(dept==null){
        		msg = "第"+i+"行，部门："+u.getDeptNameTemp()+"在数据库中不存在\n";
        		errorMsgList.add(msg);
        	}
        	
        	List<SysRole> roles = new ArrayList<SysRole>();
        	String[] roleNameArr = u.getRoleNameTemp().split(",");
        	SysRole role = null;
        	for(String rn : roleNameArr){
        		role = roleMap.get(rn.trim());
        		if(role==null){
        			msg = "第"+i+"行，角色："+rn+"在数据库中不存在\n";
        			errorMsgList.add(msg);
        		}
        		roles.add(role);
        	}
        	
        	u.setSysDept(dept);
        	u.setSysRoles(roles);
        	u.setPassWord(EncodeUtils.encodeMd5(u.getPassWord()));
        	userList.add(u);
        	
		}
		if(errorMsgList.size()==0){
			userService.saveUserList(userList);
			Renders.renderJson(new EasyUiResult(msg));
		}else{
			throw new Exception(errorMsgList+"");
			//Renders.renderJson(new EasyUiResult("1",errorMsgList));
		}
        return NONE;
	}
	
	
	
	/**
	 * 导出word
	 * @return
	 * @throws Exception 
	 */
	public String exportWord() throws Exception{
		page = userService.findUsers(page, deptId,roleIds,userName,null);
		return "exportWord";
	}

	public String exportWordDetail() throws Exception{
		user = userService.get(id);
		List<SysRole> roleList = user.getSysRoles();
		if(roleList!=null && roleList.size()>0){
			for(SysRole role : roleList){
				roleNames+=","+role.getRoleName();
			}
			roleNames = roleNames.replaceFirst(",", "");
		}
		return "exportWordDetail";
	}
	
	
//	/**
//	 * 导出pdf
//	 * @return
//	 * @throws Exception 
//	 */
//	public String exportPdf() throws Exception{
//		
//		Map<String,String> paramMap = new HashMap<String,String>();
//		paramMap.put("userName", userName);
//		paramMap.put("deptId", deptId);
//		paramMap.put("roleIds", roleIds);
//		
//		String targetPath = "/pdffile/user/"+UUID.randomUUID().toString()+"/";
//		String pdfFileName = "用户信息列表.pdf";
//		//生成pdf
//		PdfUtils.createPdf(Servlets.genUrl("userreport_renderPdf.do", paramMap), targetPath, pdfFileName);
//		//输出到客户端
//		UploadUtils.download(pdfFileName, targetPath+pdfFileName);
//		
//		return NONE;
//	}
	
	private List<Person> presonList = null;

	private Map<String, String> reportParameter = null;
	
	public List<Person> getPresonList() {
		return presonList;
	}

	public void setPresonList(List<Person> presonList) {
		this.presonList = presonList;
	}

	public Map<String, String> getReportParameter() {
		return reportParameter;
	}

	public void setReportParameter(Map<String, String> reportParameter) {
		this.reportParameter = reportParameter;
	}

	/**
	 * 导出pdf
	 * @return
	 * @throws Exception 
	 */
	public String exportPdf() throws Exception{
		
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("userName", userName);
		paramMap.put("deptId", deptId);
		paramMap.put("roleIds", roleIds); 
 
		page = userService.findUsers(page, deptId,roleIds,userName,null);
		
		
		
//		File reportFile = new File(ServletActionContext.getRequest()
//				.getRealPath("/jasper/preson-for5.jasper"));
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("year", "2009");
//		parameters.put("unit_mc", "青川高级中学XX班");
//		List<Person> personList = new PersonService().getAllPerson();
//		JRDataSource dataSource  = new JRBeanCollectionDataSource(personList);   
	 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "青川高级中学XX班");
		List<Person> personList = new PersonService().getAllPerson();
		JRDataSource dataSource  = new JRBeanCollectionDataSource(page.getList());  
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
	 
//		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
//						.getRealPath("/jasper/preson-for5.jasper"), parameters, dataSource);
					 
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/sysstudent.jasper"), parameters, dataSource);
		response.setContentType("application/pdf");
		//response.setHeader("Content-Disposition", "inline; filename=");
		response.setHeader("Content-Disposition", "inline; filename=\"" + new String("文件".getBytes("utf-8")) + ".pdf"+ "\"");
		response.setCharacterEncoding("utf-8"); 
		OutputStream os = response.getOutputStream();
		JRAbstractExporter exporter = new JRPdfExporter();
		JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//		exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, Boolean.FALSE);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
		exporter.exportReport();
		return NONE; 
		
	}
	
	
	/**
	 * 导出Excel
	 * @return
	 * @throws Exception 
	 */
	public String exportExcel() throws Exception{
		
		File reportFile = new File(ServletActionContext.getRequest()
				.getRealPath("/jasper/preson-for5.jasper"));
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "青川高级中学XX班");
		List<Person> personList = new PersonService().getAllPerson();
		JRDataSource dataSource  = new JRBeanCollectionDataSource(personList);  
		HttpServletResponse response = ServletActionContext.getResponse();
	 
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
						.getRealPath("/jasper/preson-for5.jasper"), parameters, dataSource);
					 
		JasperPrint print = (JasperPrint) JRLoader.loadObject(file);
		OutputStream os = response.getOutputStream();  
		
		response.setContentType("application/x-zip-compressed;charset=utf-8");
		response.setHeader("Content-disposition", "attachment; filename="
				+ java.net.URLEncoder.encode("系统管理员授权表.xls", "UTF-8"));

		JRAbstractExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
		// 删除记录最下面的空行
		exporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		exporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
				Boolean.TRUE);
		exporter.setParameter(
				JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);
		exporter.exportReport();
		
		return NONE; 
		
	}
	
	/**
	 * 导出格式是html
	 *      1.编译
	 *      2.填充数据
	 *      3.设置文件输出流
	 *      4.导出器 并设置参数
	 *      5.导出
	 * @throws Exception 
	 */
	public String  exportHtml() throws Exception
	
	{   
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "青川高级中学XX班");
		List<Person> personList = new PersonService().getAllPerson(); 
		
		
		
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("userName", userName);
		paramMap.put("deptId", deptId);
		paramMap.put("roleIds", roleIds);
		
//		if(StringUtils.isNotBlank(userName)){
//			userName = StringEncodeUtils.iso88591ToUtf8(URLDecoder.decode(userName,"UTF-8"));
//		}
		
		page = userService.findUsers(page, deptId,roleIds,userName,null);
		
		
		
		JRDataSource dataSource  = new JRBeanCollectionDataSource(page.getList());  
		HttpServletResponse response = ServletActionContext.getResponse();  
 
		try { 
//			JasperCompileManager.compileReportToFile(path+"/myReport.jrxml", path+"/myReport.jasper");
			String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
					.getRealPath("/jasper/sysstudent.jasper"), parameters, dataSource);
			JasperPrint print = (JasperPrint)JRLoader.loadObject(file); 
//			request.getSession().setAttribute( ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, print); 
			response.setHeader("Content-Disposition", "inline; filename=\""+new String("aa".getBytes("utf-8"))+".html"+"\"");
			response.setCharacterEncoding("utf-8"); 
			JRAbstractExporter expoter = new JRHtmlExporter();
			expoter.setParameter(JRHtmlExporterParameter.SIZE_UNIT,"pt"); //默认情况下用的是px,会导致字体缩小
			expoter.setParameter(JRHtmlExporterParameter.FRAMES_AS_NESTED_TABLES,false); //线条不对齐的解决方法: 
			expoter.setParameter(JRExporterParameter.JASPER_PRINT, print); 
			expoter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
			expoter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
			expoter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "servlets/image?image="); 
			
			expoter.exportReport();
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE; 
	}
	
	public String renderPdf() throws Exception{
		if(StringUtils.isNotBlank(userName)){
			userName = StringEncodeUtils.iso88591ToUtf8(URLDecoder.decode(userName,"UTF-8"));
		}
		
		page = userService.findUsers(page, deptId,roleIds,userName,null);
		
		return "renderPdf";
	}
	public String exportPdfDetail() throws Exception{
		
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("id", id);
		
		String targetPath = "/pdffile/user/"+UUID.randomUUID().toString()+"/";
		String pdfFileName = "用户信息.pdf";
		//生成pdf
		PdfUtils.createPdf(Servlets.genUrl("userreport_renderPdfDetail.do", paramMap), targetPath, pdfFileName);
		//输出到客户端
		UploadUtils.download(pdfFileName, targetPath+pdfFileName);
		return NONE;
	}
	
	public String renderPdfDetail() throws Exception{
		user = userService.get(id);
		//setUploadFileList(getUploadFileService().findByOwnerId(id));
		List<SysRole> roleList = user.getSysRoles();
		if(roleList!=null && roleList.size()>0){
			for(SysRole role : roleList){
				roleNames+=","+role.getRoleName();
			}
			roleNames = roleNames.replaceFirst(",", "");
		}
		return "renderPdfDetail";
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
