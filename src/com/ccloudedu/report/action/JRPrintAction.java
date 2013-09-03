package com.ccloudedu.report.action;

 



import java.io.File;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

 
import com.ccloudedu.report.entity.Person;
import com.ccloudedu.report.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;


@Controller("report.action.JRPrintAction")
@Scope("prototype")
public class JRPrintAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		File reportFile = new File(ServletActionContext.getRequest()
				.getRealPath("/jasper/preson-for5.jasper"));
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "青川高级中学XX班");
		List<Person> personList = new PersonService().getAllPerson();
		JasperPrint jasperPrint = null;
		JRDataSource dataSource  = new JRBeanCollectionDataSource(personList);  
	 
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);
		jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,dataSource);
		 
		if(null != jasperPrint){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/octet-stream");
			ServletOutputStream ouputStream = response.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
			oos.writeObject(jasperPrint);
			oos.flush();
			oos.close();
			ouputStream.flush();
			ouputStream.close();
		}
		return null;
	}
}
