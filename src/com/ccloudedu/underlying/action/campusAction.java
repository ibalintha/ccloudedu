package com.ccloudedu.underlying.action;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.common.entity.ChCampus;
import com.ccloudedu.underlying.service.campusService;


/**
 * 校区管理
 * @author ZLY
 * 
 */
@Controller("campus.action.campusAction")
@Scope("prototype")
public class campusAction extends BaseUploadFileAction<ChCampus>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String chCampCode;
	private String chCampName;
	private String chCampDesc;
	private String chCampShowflag;
	private String chCampMemo;
	private String chCampAddress;
	private ChCampus campus;
    
	private String checkflag;



	private String ids;
//	private String chClasId;
//	private String isLast;
	
	
	
	@Autowired
	private campusService campusService;
	

//	private List<ChCampName> CampNameList;
//	private List<ChCampDesc> CampDescList;
//	private List<ChCampCode> CampCodeList;
//	private List<ChCampMemo> CampMemoList;
////	private List<ChHealthstatus> hestList;
//	private List<ChCampAddress> CampAddressList;
	
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
	@SuppressWarnings("unchecked")
	public String edit() throws Exception{
		
		campus = campusService.get(id);
	//	chCampCode=campusService.get(id).getChCampCode();
		return "edit";
	}

	
	/**
	 * 进入查询页面
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public String queryCampus(){
		return "queryCampus";
	}
	
	/**
	 *校区列表
	 * @return
	 * @throws Exception 
	 */
	 @SuppressWarnings("unchecked")
	 @Menu
     public String list() throws Exception{

			
		 if(chCampCode==null||chCampCode.equals("")){
			 chCampCode = null;
		 }
		 if(chCampName==null||chCampName.equals("")){
			 chCampName = null;
		 }
	
	  
		  page = campusService.findCampus(page,chCampCode,chCampName);
	  
		return LIST;
	 }
	 
	 
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	/**
	 * 进入新增校区页
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String add() throws Exception{

		return ADD;
	}
	

	/**
	 * 查看校区详情
	 * @SuppressWarnings("unchecked")
	 */

	public String update(){
		
		return UPDATE;
	}
	
	/**
	 * 保存校区信息
	 * @return
	 * @throws Exception 
	 */
	public String save() throws Exception{
		if(StringUtils.isBlank(id)){
		
			ChCampus campus = new ChCampus();
						
			HttpServletRequest req = Servlets.getRequest();	
			//String ss=req.getParameter("chCampShowflag");
			campus.setChCampCode(chCampCode);
            campus.setChCampName(chCampName);
            campus.setChCampDesc(chCampDesc);
            campus.setChCampShowflag(checkflag);
            campus.setChCampAddress(chCampAddress);
            campus.setChCampMemo(chCampMemo);
			campusService.save(campus);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			//HttpServletRequest req = Servlets.getRequest();	
			ChCampus campus = new ChCampus();
			campus = campusService.get(id);
			campus.setChCampCode(chCampCode);
            campus.setChCampName(chCampName);
            campus.setChCampDesc(chCampDesc);
            campus.setChCampShowflag(checkflag);
            campus.setChCampAddress(chCampAddress);
            campus.setChCampMemo(chCampMemo);
//			campusService.edit(campus);
            campusService.update(campus);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	

	
	/**
	 * 导出pdf
	 * @return
	 * @throws Exception 
	 */
	public String exportPdf() throws Exception{  
		
		 Connection conn = null;
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
         conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");
         
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("chCampCode", "01");
		parameters.put("chCampName", "清华校区");
		parameters.put("chCampDesc", null);
		parameters.put("chCampAddress", null);
		//按照创建时间排序，降序方式
		parameters.put("ORDER_ID", "CREATE_TIME DESC");
  
		HttpServletResponse response = ServletActionContext.getResponse();
		 
		
		String file =  JasperFillManager.fillReportToFile(ServletActionContext.getRequest()
				.getRealPath("/jasper/stu-roll.jasper"), parameters, conn); 
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=\"" + new String("文件".getBytes("utf-8")) + ".pdf"+ "\"");
		response.setCharacterEncoding("utf-8"); 
		ServletOutputStream os = response.getOutputStream();
		JRAbstractExporter exporter = new JRPdfExporter();
		JasperPrint print = (JasperPrint)JRLoader.loadObject(file);		
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
		exporter.exportReport();
		conn.close();
		return NONE; 
		
	}
	@Override
	public String delete() throws Exception {
		
		String ids = Servlets.getRequest().getParameter("ids");
		campusService.deleteByIds(ids.split(","));
		
		Renders.renderJson(Renders.DELETE_SUCCESS);

		return null;
	}


	@Override
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			campus = new ChCampus();
		}else{
			campus = campusService.get(id);
		}	
	}

	

	//------------------------------getter/setter方法----------------------------------

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}


	public String getChCampCode() {
		return chCampCode;
	}
	public void setChCampCode(String chCampCode) {
		this.chCampCode = chCampCode;
	}
	public String getChCampName() {
		return chCampName;
	}
	public void setChCampName(String chCampName) {
		this.chCampName = chCampName;
	}
	public String getChCampDesc() {
		return chCampDesc;
	}
	public void setChCampDesc(String chCampDesc) {
		this.chCampDesc = chCampDesc;
	}
	public String getChCampShowflag() {
		return chCampShowflag;
	}
	public void setChCampShowflag(String chCampShowflag) {
		this.chCampShowflag = chCampShowflag;
	}
	public String getChCampMemo() {
		return chCampMemo;
	}
	public void setChCampMemo(String chCampMemo) {
		this.chCampMemo = chCampMemo;
	}
	public String getChCampAddress() {
		return chCampAddress;
	}
	public void setChCampAddress(String chCampAddress) {
		this.chCampAddress = chCampAddress;
	}
	public ChCampus getCampus() {
		return campus;
	}
	public void setCampus(ChCampus campus) {
		this.campus = campus;
	}
	public campusService getCampusService() {
		return campusService;
	}
	public void setCampusService(campusService campusService) {
		this.campusService = campusService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	private Page page = new Page(Constants.PAGE_SIZE);
	
	public ChCampus getModel() {
		return campus;
	}	
	public String getCheckflag() {
		return checkflag;
	}
	public void setCheckflag(String checkflag) {
		this.checkflag = checkflag;
	}
}
