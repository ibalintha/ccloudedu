package com.ccloudedu.student.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.fluent.Request;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.common.entity.ChAdminway;
import com.ccloudedu.common.entity.ChBloodtype;
import com.ccloudedu.common.entity.ChClasstree;
import com.ccloudedu.common.entity.ChEthnic;
import com.ccloudedu.common.entity.ChForeign;
import com.ccloudedu.common.entity.ChHealthstatus;
import com.ccloudedu.common.entity.ChPolface;
import com.ccloudedu.common.entity.ChSchoolroll;
import com.ccloudedu.common.entity.ChStudent;
import com.ccloudedu.report.entity.ChStudentCount;
import com.ccloudedu.report.entity.ChStudent_Card;
import com.ccloudedu.report.service.StudentCardService;
import com.ccloudedu.report.service.StudentCountServer;
import com.ccloudedu.student.entity.ChReportList;
import com.ccloudedu.student.entity.SchcodeGenerate;
import com.ccloudedu.student.service.ChClasstreeService;
import com.ccloudedu.student.service.SchoolRollService;
import com.ccloudedu.student.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * 新生管理
 * @author sungege
 * 2013-07-4 中午12点
 */
@Controller("student.action.StudentAction")
@Scope("prototype")
public class StudentAction extends BaseUploadFileAction<ChStudent>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChStudent student;
	private String id;

	private String ids;
	private String state;
	private String SerialNumber;
	private String SerialNumber2;
	private String staticstr;
	
	private String chClasId;

	private String isLast;
	
	private String sss;
	
	private String chStudSex ;
	private String chStudAdmway;
	private String chStudCadreflag ;
	private String chStudScore;
	private String belongToList;
	
	private List<ChReportList> reportList;

	private List<ChStudent> studentList;
	
	private String chStudSchcode;
	private String chStudName;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SchoolRollService schoolrollService;
	
	@Autowired
	private ChClasstreeService classtreeService;
	
	
	private List<ChAdminway> admwayList;
	private List<ChBloodtype> bltpList;
	private List<ChEthnic> ethnicList;
	private List<ChForeign> foreginList;
	private List<ChHealthstatus> hestList;
	private List<ChPolface> plfaList;
	
	private List<ChClasstree> chclasstreeList;
	private ChClasstree chclasstree;
	
	
	private Page page = new Page(Constants.PAGE_SIZE);
	private StudentCardService studentCardService;
	
	private String toUTF(String inStr) throws UnsupportedEncodingException
    {
       String outStr = "" ;
       if (inStr != null )
       {
           //outStr=java.net.URLDecoder.decode(inStr);// 不用 decode 了 , 到这的时候就已经自动 decode 过了
           // 将字符串转为 UTF-8 编码形式
           outStr = new String(inStr.getBytes( "iso-8859-1" ), "UTF-8" );        
       }
       return outStr;
    }  
	
	public ChStudent getModel() {
		return student;
	}
	@SuppressWarnings("unchecked")
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			student = new ChStudent();
			student.setChStudMaketime(DateUtils.getCurrentDate());
			//user.setCreateUser(this.UserSession.getSysUser());
		}else{
			student = studentService.get(id);
			admwayList = studentService.findListByChAdminway();
			bltpList = studentService.findListByChBloodtype();
			ethnicList = studentService.findListByChEthnic();
			hestList = studentService.findListByChHealthstatus();
			plfaList = studentService.findListByChPolface();
		}
	}
	public String autoStudents(){
		ids=Servlets.getRequest().getParameter("id");
		try {
			chclasstreeList = studentService.findListByChClasstree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "autoStudents";
	 }
	public String noautoStudents(){
		ids=Servlets.getRequest().getParameter("id");
		try {
			chclasstreeList = studentService.findListByChClasstree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "noautoStudents";
	 }
	public String schcode()throws Exception{
		String [] idss = Servlets.getRequest().getParameterValues("ids");
		if(StringUtils.isBlank("idss"))
		{
			for (String id : idss) {
				ids=ids+id+",";
			}
		}
		//ids = ids.substring(0,ids.length()-1); ;
		 return NONE;
	 }
	
	@SuppressWarnings("unchecked")
	public String generateSchcode()throws Exception{

		ids=Servlets.getRequest().getParameter("id");
		//ids = ids.substring(0,ids.length()-1); ;
		 return "generateSchcode";
	 }
	public String ethnic() throws Exception{
		ethnicList = studentService.findListByChEthnic();
		 return "ethnic";
	 }
	/**
	 * 条件搜索学生
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public String queryStudents(){
		return "queryStudents";
	}
	
	/**
	 * 学生列表
	 * @return
	 * @throws Exception 
	 */
	 @SuppressWarnings("unchecked")
	 @Menu
     public String list() throws Exception{
		 String sss1 = Servlets.getRequest().getParameter("sss");
		 
//		deptList = deptService.findListByDeptLevel();
//		roleList = roleService.findRoles(new FastMap().newHashMap().set(Querys.PREFIX+"existedParentRole", true));
		 
//		 String chClasId = Servlets.getRequest().getParameter("chClasId");
		 
//		 HttpServletRequest req = Servlets.getRequest();
//		 HttpSession hs = req.getSession();
//		 
//		 hs.setAttribute("TheClasId",chClasId);
		 
//		 String islast = Servlets.getRequest().getParameter("islast");
		 
//		 if(islast==null||islast.equals("")){
//			 hs.setAttribute("TheClasIds",chClasId);
//		 }
//		 
		 //HttpSession ses = request.getSession();
			//ses.setAttribute("B", objB); 
			
		 if(chStudSchcode==null||chStudSchcode.equals("")){
			 chStudSchcode = null;
		 }
		 if(chStudName==null||chStudName.equals("")){
			 chStudName = null;
		 }
		 if(chStudName!=null){
			 chStudName = java.net.URLDecoder.decode(chStudName,"UTF-8");
			 }
		 if(chStudSex==null||chStudSex.equals("")){
			 chStudSex = null;
		 }
		 if(chStudSex!=null){
		 chStudSex = java.net.URLDecoder.decode(chStudSex,"UTF-8");
		 }
		 if(chStudSex!=null &&chStudSex.equals("男")){
			 chStudSex = "0";
		 }else if(chStudSex!=null &&chStudSex.equals("女")){
			 chStudSex = "1";
		 }
		 
//		 if(chClasId==null||chClasId.equals("")){
//			 chClasId = null;
//			 String theclassid = (String) hs.getAttribute("TheClasId");
//			 chClasId = theclassid;
//		 }
		 
		    admwayList = studentService.findListByChAdminway();
			bltpList = studentService.findListByChBloodtype();
			ethnicList = studentService.findListByChEthnic();
			hestList = studentService.findListByChHealthstatus();
			plfaList = studentService.findListByChPolface();
		 if(!"1".equals(chClasId)){
			 if(isLast!=null&&isLast.equals("Y")){
				 page = studentService.findStudents(page, chClasId,chStudSchcode,chStudName,chStudSex);
			 }else{
				 page = studentService.findStudents2(page, chClasId,chStudSchcode,chStudName,chStudSex);
			 }
		  }else{
			  page = studentService.findStudents(page, "",chStudSchcode,chStudName,chStudSex);
		  }
		 chclasstree = classtreeService.get(chClasId);	
		return LIST;
	 }
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	/**
	 * 进入新增学生页
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String add() throws Exception{
		admwayList = studentService.findListByChAdminway();
		bltpList = studentService.findListByChBloodtype();
		ethnicList = studentService.findListByChEthnic();
		hestList = studentService.findListByChHealthstatus();
		plfaList = studentService.findListByChPolface();
		return ADD;
	}

	/**
	 * 弹出的报表管理界面
	 * @return
	 * @throws Exception 
	*/
	@SuppressWarnings("unchecked")
	public String exportManage() throws Exception{
		
		
		//studentList= studentCardService.findStudentslist(chStudSchcode,chStudName);
		
		chclasstreeList = studentService.findList("system.findClassTrees",null);

		setReportList(studentService.findListByChReportList());

		//student_CardService.findStudentslist("123123", "孙永锋");

		return EXPORTMANAGER;
	} 
	/**
	 * 查看学生详情
	 * @throws Exception 
	 */
	public String update() throws Exception{
		
		return UPDATE;
	}
	
	
	/**
	 * 保存学生信息
	 * @return
	 * @throws Exception 
	 */
	public String save() throws Exception{
		if(StringUtils.isBlank(id)){
			String aa=Servlets.getRequest().getParameter("chStudEthnic");
			if(aa.equals("")){
				aa = "1";
			}
			ChEthnic dd = new ChEthnic();
			dd.setId(aa);
            student.setChethnic(dd);
			studentService.save(student);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			String aa=Servlets.getRequest().getParameter("chStudEthnic");
			if(aa.equals("")){
				aa = "1";
			}
			ChEthnic dd = new ChEthnic();
			dd.setId(aa);
            student.setChethnic(dd);
			studentService.update(student);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	/*
	 * 学号生成
	 */
	public String generateSchcodeSave() throws Exception{
		String ids = Servlets.getRequest().getParameter("ids");
		String staticstr = Servlets.getRequest().getParameter("staticstr");
		SchcodeGenerate sg = new SchcodeGenerate();
		String[] idstr =  ids.split(",");
		if(state!=null&&state.equals("1")){
			for(int i= 0;i<idstr.length;i++){
				String no=sg.generate(SerialNumber);
				SerialNumber = no;
				studentService.updateSchcode(idstr[i],no);
			}
		}
		if(state!=null&&state.equals("2")){
			for(int i= 0;i<idstr.length;i++){
				String no=sg.generate(staticstr,SerialNumber2);
				SerialNumber2 = no;
				studentService.updateSchcode(idstr[i],no);
			}
		}
		Renders.renderJson(Renders.GENERATE_SUCCESS);
		return NONE;
	}
	
	/*
	 * 学籍生成
	 */
	public String generateStudSchroll() throws Exception{
		String ids = Servlets.getRequest().getParameter("ids");
		String initnumber = Servlets.getRequest().getParameter("initnumber");
		String[] idstr =  ids.split(",");
		for(int i=0;i<idstr.length;i++){
			String id = idstr[i];
			Map<String,String> paramMap = new HashMap<String, String>();
			paramMap = new FastMap().newHashMap().set("id",id);
			ChStudent chstu = new ChStudent();
			chstu = studentService.findOne("student.findStudents",paramMap);
			if(chstu!=null){
				ChSchoolroll csr = new ChSchoolroll();
				SchcodeGenerate sg = new SchcodeGenerate();
				Date date = new Date();
				csr.setChStudId(chstu.getId());
				csr.setChScroAddress(chstu.getChStudAddress());
				csr.setChScroAdmway(chstu.getChStudAdmway());
				csr.setChScroBirth(chstu.getChStudBirth());
				csr.setChScroBirthplace(chstu.getChStudBirthplace());
				csr.setChScroBloodtype(chstu.getChStudBloodtype());
				csr.setChScroCadreflag(chstu.getChStudCadreflag());
				csr.setChScroEmail(chstu.getChStudEmail());
				csr.setChScroEngname(chstu.getChStudEngname());
				csr.setChScroEnrolldate(chstu.getChStudEnrolldate());
				csr.setChScroEthnic(chstu.getChethnic().getId());
				csr.setChScroFlowperson(chstu.getChStudFlowperson());
				csr.setChScroForeign(chstu.getChStudFlowperson());
				csr.setChScroGrade(chstu.getChStudGrade());
				csr.setChScroHealth(chstu.getChStudHealth());
				csr.setChScroHometown(chstu.getChStudHometown());
				csr.setChClasId(chstu.getChClasId());
				csr.setChScroImage(chstu.getChStudImage());
				csr.setChScroLocakind(chstu.getChStudLocakind());
				csr.setChScroLocation(chstu.getChStudLocation());
				csr.setChScroMaketime(date.toLocaleString());
				csr.setChScroMemo(chstu.getChStudMemo());
				csr.setChScroName(chstu.getChStudName());
				csr.setChScroOldname(chstu.getChStudOldname());
				csr.setChScroOldschool(chstu.getChStudOldschool());
				csr.setChScroOnly(chstu.getChStudOnly());
				csr.setChScroPersonid(chstu.getChStudPersonid());
				csr.setChScroPersontype(chstu.getChStudPersontype());
				csr.setChScroPinyin(chstu.getChStudPinyin());
				csr.setChScroPolface(chstu.getChStudPolface());
				csr.setChScroSchcode(chstu.getChStudSchcode());
				SimpleDateFormat format= new SimpleDateFormat("yyyyMMdd");
				String datestr=format.format(new Date());
				String no=sg.generate(datestr,initnumber);
				initnumber = no;
				csr.setChScroSchroll(no);
				csr.setChScroScore(chstu.getChStudScore());
				csr.setChScroSex(chstu.getChStudSex());
				csr.setChScroSourareas(chstu.getChStudSourareas());
				csr.setChScroSpecial(chstu.getChStudSpecial());
				csr.setChScroTranaddress(chstu.getChStudTranaddress());
				csr.setChScroType(chstu.getChStudType());
				csr.setChScroUpdateflag(chstu.getChStudUpdateflag());
				csr.setChScroWebsite(chstu.getChStudWebsite());
				csr.setChScroZip(chstu.getChStudZip());
				schoolrollService.save(csr);
				
				chstu.setChStudSchroll(no);
				studentService.save(chstu);
			}
		}
		Renders.renderJson(Renders.GENERATE_SUCCESS);
		return NONE;
	}
	
	/*
	 * 自动分班
	 */
	public String autoSave() throws Exception{
		String belong =  Servlets.getRequest().getParameter("idList");
		String orderstr = "";
		if(chStudSex==null||chStudSex.equals("")){
			chStudSex = null;
		}else{
			orderstr+="chStudSex"+"  desc,";
		}
		if(chStudAdmway==null||chStudAdmway.equals("")){
			chStudAdmway = null;
		}else{
			orderstr+="chStudAdmway"+"  desc,";
		}
		if(chStudCadreflag==null||chStudCadreflag.equals("")){
			chStudCadreflag = null;
		}else{
			orderstr+="chStudCadreflag"+"  desc,";
		}
		if(chStudScore==null||chStudScore.equals("")){
			chStudScore = null;
		}else{
			orderstr+="chStudScore"+"  desc,";
		}
		if(!orderstr.equals("")){
			orderstr = orderstr.substring(0,orderstr.length()-1);
		}
		List<ChStudent> studentList  = new ArrayList<ChStudent>();
		ids = ids.substring(0,ids.length()-1);
		String[] idstr =  ids.split(",");
		String ss = "";
		for(int i=0;i<idstr.length;i++){
			ss+="'"+idstr[i]+"',";
		}
		
		ss  = ss.substring(0,ss.length()-1);
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("ids", Arrays.asList(idstr))
		.set("orderattr", ""+orderstr+"");
		
		studentList = studentService.findList("student.findStudentsBy",paramMap);
		
		String[] chClasIdsstr =  belong.split(",");
		
		DivideClass tmpClas = new DivideClass(idstr, chClasIdsstr);
		List<StuClas> stuClas = tmpClas.getStuClas();
		
		
		for(int i=0;i<studentList.size();i++){
			ChStudent csd = new ChStudent();
			csd = studentList.get(i);
			csd.setChClasId(stuClas.get(i).classID);
			studentService.update(csd);
		}
		
		Renders.renderJson(Renders.SAVE_SUCCESS);
		return NONE;
	}
	
	/*
	 * 手动分班
	 */
	public String noautoSave() throws Exception{
		
		String[] idstr =  ids.split(",");
		for(int i=0;i<idstr.length;i++){
			Map<String,String> paramMap = new FastMap().newHashMap()
			.set("id", ""+idstr[i]+"");
			ChStudent cst = new ChStudent();
			cst = studentService.findOne("student.findStudents", paramMap);
			cst.setChClasId(chClasId);
			studentService.update(cst);
		}
		Renders.renderJson(Renders.SAVE_SUCCESS);
		return NONE;
	}
	
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		studentService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}
	
	@SuppressWarnings("unchecked")
	public String getStudentsByAjax() throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chStudSchcode", "%"+chStudSchcode+"%")
		.set("chStudName", "%"+chStudName+"%")
		.set("chStudSex", "%"+chStudSex+"%");
		List<ChStudent> studentList = studentService.findList("student.findStudents", paramMap);
		List<ChStudent> jsonList = new ArrayList<ChStudent>();
		if(studentList!=null && studentList.size()>0){
			for(ChStudent u : studentList){
				student = new ChStudent();
				student.setId(u.getId());
				student.setChStudName(u.getChStudName());
				//student.setChStudSex(u.getChStudSex());
				jsonList.add(student);
			}
		}
		Renders.renderJson(jsonList);
		return NONE;
	}
	
	
	/**
	 * 班级树
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Menu
	public String tree() throws Exception {
		chclasstreeList = studentService.findList("system.findClassTrees",null);
		return TREE;
	}
	
	
	//------------------------------getter/setter方法----------------------------------
	public ChStudent getStudent() {
		return student;
	}
	public void setStudent(ChStudent student) {
		this.student = student;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public List<ChAdminway> getAdmwayList() {
		return admwayList;
	}
	public void setAdmwayList(List<ChAdminway> admwayList) {
		this.admwayList = admwayList;
	}
	public List<ChBloodtype> getBltpList() {
		return bltpList;
	}
	public void setBltpList(List<ChBloodtype> bltpList) {
		this.bltpList = bltpList;
	}
	public List<ChEthnic> getEthnicList() {
		return ethnicList;
	}
	public void setEthnicList(List<ChEthnic> ethnicList) {
		this.ethnicList = ethnicList;
	}
	public List<ChForeign> getForeginList() {
		return foreginList;
	}
	public void setForeginList(List<ChForeign> foreginList) {
		this.foreginList = foreginList;
	}
	public List<ChHealthstatus> getHestList() {
		return hestList;
	}
	public void setHestList(List<ChHealthstatus> hestList) {
		this.hestList = hestList;
	}
	public List<ChPolface> getPlfaList() {
		return plfaList;
	}
	public void setPlfaList(List<ChPolface> plfaList) {
		this.plfaList = plfaList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getChStudSchcode() {
		return chStudSchcode;
	}
	public void setChStudSchcode(String chStudSchcode) {
		this.chStudSchcode = chStudSchcode;
	}
	public String getChStudName() {
		return chStudName;
	}
	public void setChStudName(String chStudName) {
		this.chStudName = chStudName;
	}
	public SchoolRollService getSchoolrollService() {
		return schoolrollService;
	}
	public void setSchoolrollService(SchoolRollService schoolrollService) {
		this.schoolrollService = schoolrollService;
	}
	public List<ChClasstree> getChclasstreeList() {
		return chclasstreeList;
	}
	public void setChclasstreeList(List<ChClasstree> chclasstreeList) {
		this.chclasstreeList = chclasstreeList;
	}
	public List<ChStudent> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<ChStudent> studentList) {
		this.studentList = studentList;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}
	public String getSerialNumber2() {
		return SerialNumber2;
	}
	public void setSerialNumber2(String serialNumber2) {
		SerialNumber2 = serialNumber2;
	}
	public String getStaticstr() {
		return staticstr;
	}
	public void setStaticstr(String staticstr) {
		this.staticstr = staticstr;
	}
	public String getChStudSex() {
		return chStudSex;
	}
	public void setChStudSex(String chStudSex) {
		this.chStudSex = chStudSex;
	}
	public String getChStudAdmway() {
		return chStudAdmway;
	}
	public void setChStudAdmway(String chStudAdmway) {
		this.chStudAdmway = chStudAdmway;
	}
	public String getChStudCadreflag() {
		return chStudCadreflag;
	}
	public void setChStudCadreflag(String chStudCadreflag) {
		this.chStudCadreflag = chStudCadreflag;
	}
	public String getChStudScore() {
		return chStudScore;
	}
	public void setChStudScore(String chStudScore) {
		this.chStudScore = chStudScore;
	}
	public String getBelongToList() {
		return belongToList;
	}
	public void setBelongToList(String belongToList) {
		this.belongToList = belongToList;
	}
	public String getChClasId() {
		return chClasId;
	}
	public void setChClasId(String chClasId) {
		this.chClasId = chClasId;
	}
	public ChClasstree getChclasstree() {
		return chclasstree;
	}
	public void setChclasstree(ChClasstree chclasstree) {
		this.chclasstree = chclasstree;
	}
	public ChClasstreeService getClasstreeService() {
		return classtreeService;
	}
	public void setClasstreeService(ChClasstreeService classtreeService) {
		this.classtreeService = classtreeService;
	}
	public String getIsLast() {
		return isLast;
	}
	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}
	public String getSss() {
		return sss;
	}
	public void setSss(String sss) {
		this.sss = sss;
	}

	public void setReportList(List<ChReportList> reportList) {
		this.reportList = reportList;
	}

	public List<ChReportList> getReportList() {
		return reportList;
	}


}
