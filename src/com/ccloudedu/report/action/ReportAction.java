package com.ccloudedu.report.action;

 

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller; 

import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.common.entity.ChClasstree;
import com.ccloudedu.common.entity.ChStudent;
import com.ccloudedu.report.entity.ChStudentCount;
import com.ccloudedu.report.entity.Person;
import com.ccloudedu.report.service.PersonService;
import com.ccloudedu.report.service.StudentCountServer;
import com.ccloudedu.student.entity.ChReportList;
import com.ccloudedu.student.service.ChClasstreeService;
import com.ccloudedu.student.service.SchoolRollService;
import com.ccloudedu.student.service.StudentService;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@Controller("report.action.ReportAction")
@Scope("prototype")
public class ReportAction extends ActionSupport {
	public static final String EXPORTMANAGER = "exportmanager";
	
	private String exportId;
	private String valueclass;
	private String chClasId;
	private static String chClassId;
	private static String chStuName;
	
	private List<ChReportList> reportList;
	private List<ChStudent> studentList;
	
	private String chStudSex ;
	private String chStudSchcode;
	private String chStudName;
	private List<String> classes;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SchoolRollService schoolrollService;
	
	@Autowired
	private ChClasstreeService classtreeService;
	
	private List<ChClasstree> chclasstreeList;
	private ChClasstree chclasstree;

	private String[] checkbox;
	
	/**
	 * 弹出报表查询页面，查询班级和学生list
	 * @return
	 * @throws Exception 
	 */
	
	@SuppressWarnings("unchecked")
	public String reportlayout() throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chStudSchcode", "%"+chStudSchcode+"%")
		.set("chStudName", "%"+chStudName+"%")
		.set("chStudSex", "%"+chStudSex+"%");
		studentList = studentService.findList("student.findStudents", paramMap);
		System.out.println("sssssssslllist--->"+studentList);
		
		chclasstreeList = studentService.findList("system.findClassTrees",null);
		return  "reportlayout";
	}
	/**
	 * 下拉框的关联查询实现，思路：先年级后按照id查班级，再查姓名
	 * @return
	 * @throws Exception 
	 */
	public String classmenu() throws Exception {
		String grade=Servlets.getRequest().getParameter("grade");		
		List<ChClasstree> chclasstreeList  = classtreeService.findClasstree(null, null, grade);
		
		String gradeId =chclasstreeList.get(0).getId();
		
		List<ChClasstree> chclasstreeList2  = classtreeService.findClasstree(null, gradeId, null);
		classes = new ArrayList<String>();
		for(ChClasstree clstree : chclasstreeList2){
			classes.add(clstree.getName());
			
		}
		GsonBuilder builder = new GsonBuilder();		
		String ajaxJson = builder.create().toJson(classes);
		sendMsg(ajaxJson);
		
		
		return NONE;
		
	}
	/**
	 * 根据班级名字查询班级id。再传递给报表查出班级名册
	 * @return
	 * @throws Exception 
	 */
	public String classReport() throws Exception {
		String valueclass=Servlets.getRequest().getParameter("valueclass");		
		List<ChClasstree> chclasstreeList  = classtreeService.findClasstree(null, null, valueclass);
	
		classes = new ArrayList<String>();
		for(ChClasstree clstree : chclasstreeList){
			classes.add(clstree.getId());
			chClassId = clstree.getId();
		}
		//根据班级查询学生列表
		List<ChStudent> chstudentList = studentService.findStudentsByClassId(null,chClassId);
		List<String> stuList = new ArrayList<String>();
		for (ChStudent stulist : chstudentList){
			stuList.add(stulist.getChStudName());
			System.out.println("stustu----->"+stulist.getChStudName());	
		}
		GsonBuilder builder = new GsonBuilder();		
		String ajaxJson = builder.create().toJson(stuList);
		sendMsg(ajaxJson);
		
		
		return NONE;
		
	}
	/**
	 * 查询的学生姓名传递给报表查出班学生学籍卡
	 * @return
	 * @throws Exception 
	 */
	public String nameReport() throws Exception {
		chStuName=Servlets.getRequest().getParameter("valuename");		

		GsonBuilder builder = new GsonBuilder();		
		String ajaxJson = builder.create().toJson(chStuName);
		sendMsg(ajaxJson);
		
		
		return NONE;
		
	}
	/**
	 * Ajax的消息发送方法
	 * @return
	 * @throws Exception 
	 */
	public void sendMsg(String content){      
	    HttpServletResponse response = ServletActionContext.getResponse();      
	    response.setCharacterEncoding("UTF-8");      
	    try {
			response.getWriter().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	} 

	/**
	 * 点击班级后弹出班级名次的预览，PDF的实现
	 * @return
	 * @throws Exception 
	 */
	public String exportByclass() throws Exception {

//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		Connection conn = DriverManager.getConnection(
//				"jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu",
//				"sa", "changhong_406");
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("where", "四川省");
//		parameters.put("school", "青川高级中学XX班");
//		parameters.put("grade", "高一508");
//		parameters.put("clas_id", chClassId);
//	
//		File reportFile = new File(ServletActionContext.getRequest()
//				.getRealPath("/jasper/stu-msg.jasper"));
//		JasperReport jasperReport = (JasperReport) JRLoader
//				.loadObject(reportFile.getPath());
//	
//		JasperPrint jasperPrint = JasperFillManager.fillReport(
//				jasperReport, parameters, conn);
//		HttpServletResponse response = ServletActionContext.getResponse();  
//		response.setCharacterEncoding("utf-8"); 
//	
//		JRHtmlExporter exporter = new JRHtmlExporter();
//		exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//		exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, "pt"); //默认情况下用的是px,会导致字体缩小
//		exporter.setParameter(
//				JRHtmlExporterParameter.FRAMES_AS_NESTED_TABLES, false); //线条不对齐的解决方法: 
//		exporter.setParameter(
//				JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
//				Boolean.FALSE);
//		exporter.exportReport();
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=\"" + new String("文件".getBytes("utf-8")) + ".pdf"+ "\"");
		response.setCharacterEncoding("utf-8"); 
		ServletOutputStream os = response.getOutputStream();
        Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("where", "四川省");
		parameters.put("school", "青川高级中学XX班");
		parameters.put("grade", "高一508");
		parameters.put("clas_id", chClassId);
		
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/stu-msg.jasper"), parameters, conn); 
		JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
		JRAbstractExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
		exporter.exportReport();
		
		return NONE;
	}
	/**
	 * 点击班级后弹出班级名次的预览，PDF的实现
	 * @return
	 * @throws Exception 
	 */
	public String exportByname() throws Exception {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=\"" + new String("文件".getBytes("utf-8")) + ".pdf"+ "\"");
		response.setCharacterEncoding("utf-8"); 
		ServletOutputStream os = response.getOutputStream();
	    Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("where", "四川省");
		parameters.put("school", "青川高级中学XX班");
		parameters.put("img_path", ServletActionContext.getRequest().getRealPath("/jasper/1.jpg"));
		parameters.put("grud_img", ServletActionContext.getRequest().getRealPath("/jasper/1.jpg"));
						 
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/stu-rollinfo_3.jasper"), parameters, conn); 
		JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
		JRAbstractExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
		exporter.exportReport();

		return NONE;
	}
	/**
	 * 点击班级后弹出人数统计的预览，PDF的实现
	 * @return
	 * @throws Exception 
	 */
	public String exportByStuCount() throws Exception {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=\"" + new String("文件".getBytes("utf-8")) + ".pdf"+ "\"");
		response.setCharacterEncoding("utf-8"); 
		ServletOutputStream os = response.getOutputStream();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("where", "2012-2013");
		parameters.put("school", "青川高级中学");
        List<ChStudentCount> personList = new StudentCountServer().getAllStudentCount();	
		JRDataSource dataSource  = new JRBeanCollectionDataSource(personList);  
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/StuCount.jasper"), parameters, dataSource); 
		JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
		JRAbstractExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
		exporter.exportReport();	
		return NONE;
	}

	/**
	 * 根据Id点击导出不同的报表，用Pdf
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	public String exportByIdPdf() throws Exception{  

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		exportId = request.getParameter("exportId");
//		System.out.println("valueclass---before---"+valueclass);
//		valueclass = request.getParameter("valueclass");
//		System.out.println("valueclass---after---"+valueclass);
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=\"" + new String("文件".getBytes("utf-8")) + ".pdf"+ "\"");
		response.setCharacterEncoding("utf-8"); 
		ServletOutputStream os = response.getOutputStream();
				
		System.out.println("exportId----->"+exportId);
		if(exportId.equals("1"))
		{
	        Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("where", "四川省");
			parameters.put("school", "青川高级中学XX班");
			parameters.put("grade", "高一508");
			parameters.put("clas_id", chClassId);
			
			String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
					.getRealPath("/jasper/stu-msg.jasper"), parameters, conn); 
			JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
			JRAbstractExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
			exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
			exporter.exportReport();

		}
		else if(exportId.equals("2"))
		{
		    Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("where", "四川省");
			parameters.put("school", "青川高级中学XX班");
			parameters.put("img_path", ServletActionContext.getRequest().getRealPath("/jasper/1.jpg"));
			parameters.put("grud_img", ServletActionContext.getRequest().getRealPath("/jasper/1.jpg"));
							 
			String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
					.getRealPath("/jasper/stu-rollinfo_3.jasper"), parameters, conn); 
			JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
			JRAbstractExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
			exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
			exporter.exportReport();

		}
		else if(exportId.equals("3"))
		{
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("where", "2012-2013");
				parameters.put("school", "青川高级中学");
		        List<ChStudentCount> personList = new StudentCountServer().getAllStudentCount();	
				JRDataSource dataSource  = new JRBeanCollectionDataSource(personList);  
				String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
						.getRealPath("/jasper/StuCount.jasper"), parameters, dataSource); 
				JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
				JRAbstractExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
				exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
				exporter.exportReport();		

		}


		return NONE; 
		
	}	

	/**
	 * 导出班级花名册Excel
	 * @return
	 * @throws Exception 
	 */
	public String exportStuByclassExcel() throws Exception{  
		
		 Connection conn = null;
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
         conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("where", "四川省");
		parameters.put("school", "青川高级中学XX班");
		parameters.put("grade", "高一508");
		parameters.put("clas_id", chClasId);
		
        //List<ChStudent_Card> personList = new Student_CardServiceImpl().getChStudent_CardList();	
		//JRDataSource dataSource  = new JRBeanCollectionDataSource(personList);  
		HttpServletResponse response = ServletActionContext.getResponse();
		 
		
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/stu-msg.jasper"), parameters, conn); 
		
		JasperPrint print = (JasperPrint) JRLoader.loadObject(file);
		OutputStream os = response.getOutputStream();  
		response.setContentType("application/x-zip-compressed;charset=utf-8");
		java.text.SimpleDateFormat tempDate = new java.text.SimpleDateFormat(
		"yyyyMMddHH");
		String time = tempDate.format(new Date());
		String fileName = "新生花名册_" + time + ".xls";
		fileName = new String(fileName.getBytes("GBK"), "ISO8859_1");
		response.setHeader("Content-Disposition", "attachment;filename="
		+ fileName);

		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
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
		exporter.setParameter(
				JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);
		//不分页显示
		exporter.setParameter(
				JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
				Boolean.TRUE);
		exporter.exportReport();

		return NONE; 
		
	}
	/**
	 * 导出个人学籍信息Excel
	 * @return
	 * @throws Exception 
	 */
	public String exportStuCardExcel() throws Exception{  
		
		 Connection conn = null;
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
         conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");
		 
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("where", "四川省");
		parameters.put("school", "青川高级中学XX班");
		parameters.put("img_path", ServletActionContext.getRequest().getRealPath("/jasper/1.jpg"));
		parameters.put("grud_img", ServletActionContext.getRequest().getRealPath("/jasper/1.jpg"));
		
		HttpServletResponse response = ServletActionContext.getResponse();
		 
		
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/stu-rollinfo_3.jasper"), parameters, conn); 
		
		JasperPrint print = (JasperPrint) JRLoader.loadObject(file);
		OutputStream os = response.getOutputStream();  
		response.setContentType("application/x-zip-compressed;charset=utf-8");
		java.text.SimpleDateFormat tempDate = new java.text.SimpleDateFormat(
		"yyyyMMddHH");
		String time = tempDate.format(new Date());
		String fileName = "新生学籍卡_" + time + ".xls";
		fileName = new String(fileName.getBytes("GBK"), "ISO8859_1");
		response.setHeader("Content-Disposition", "attachment;filename="
		+ fileName);

		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
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
		exporter.setParameter(
				JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);
		//不分页显示
		exporter.setParameter(
				JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
				Boolean.TRUE);
		exporter.exportReport();

		return NONE; 
		
	}
	
	/**
	 * 导出人数统计的Excel
	 * @return
	 * @throws Exception 
	 */
	public String exportStuCountExcel() throws Exception{  
		

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("where", "2012-2013");
		parameters.put("school", "青川高级中学");

        List<ChStudentCount> personList = new StudentCountServer().getAllStudentCount();	
		JRDataSource dataSource  = new JRBeanCollectionDataSource(personList);  
		HttpServletResponse response = ServletActionContext.getResponse();
		 
		
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/StuCount.jasper"), parameters, dataSource); 
		
		JasperPrint print = (JasperPrint) JRLoader.loadObject(file);
		OutputStream os = response.getOutputStream();  
		response.setContentType("application/x-zip-compressed;charset=utf-8");
		java.text.SimpleDateFormat tempDate = new java.text.SimpleDateFormat(
		"yyyyMMddHH");
		String time = tempDate.format(new Date());
		String fileName = "学生统计表_" + time + ".xls";
		fileName = new String(fileName.getBytes("GBK"), "ISO8859_1");
		response.setHeader("Content-Disposition", "attachment;filename="
		+ fileName);

		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
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
		exporter.setParameter(
				JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);
		//不分页显示
		exporter.setParameter(
				JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
				Boolean.TRUE);
		exporter.exportReport();
		return NONE; 
		
	}
public String saveReport() throws Exception{
		
		ServletRequest request = null;
		String checkbox = request.getParameter("checkbox"); 
		System.out.println("checkbox----->"+checkbox);
		String[] idstr =  checkbox.split(",");
		
		if (idstr!= null) {
		for (int i = 1; i < idstr.length; i++)
		System.out.println("checkbox----->"+idstr[i]);
		}
		return NONE; 
	}
	
//////////////////////////////////////////////set get ////////////////////////////

	public void setClasstreeService(ChClasstreeService classtreeService) {
		this.classtreeService = classtreeService;
	}

	public ChClasstreeService getClasstreeService() {
		return classtreeService;
	}

	public void setReportList(List<ChReportList> reportList) {
		this.reportList = reportList;
	}

	public List<ChReportList> getReportList() {
		return reportList;
	}

	public void setStudentList(List<ChStudent> studentList) {
		this.studentList = studentList;
	}

	public List<ChStudent> getStudentList() {
		return studentList;
	}

	public void setChclasstreeList(List<ChClasstree> chclasstreeList) {
		this.chclasstreeList = chclasstreeList;
	}

	public List<ChClasstree> getChclasstreeList() {
		return chclasstreeList;
	}

	public void setSchoolrollService(SchoolRollService schoolrollService) {
		this.schoolrollService = schoolrollService;
	}

	public SchoolRollService getSchoolrollService() {
		return schoolrollService;
	}

	public void setChclasstree(ChClasstree chclasstree) {
		this.chclasstree = chclasstree;
	}

	public ChClasstree getChclasstree() {
		return chclasstree;
	}
	public String getExportId() {
		return exportId;
	}

	public void setExportId(String exportId) {
		this.exportId = exportId;
	}
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
	public String[] getCheckbox() {
		return checkbox;
	}
	
}
