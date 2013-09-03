package com.ccloudedu.report.action;

 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller; 

import com.ccloudedu.report.entity.Person;
import com.ccloudedu.report.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("report.action.PersonAction")
@Scope("prototype")
public class PersonAction extends ActionSupport {

	private List<Person> presonList = null;

	private Map<String, String> reportParameter = null;

	
	@SuppressWarnings("unchecked")
	public void prepareModel() throws Exception {
		presonList = new PersonService().getAllPerson();
		reportParameter = new HashMap<String, String>();
		reportParameter.put("year", "2013");
		reportParameter.put("unit_mc", "青川中学");	 
	} 
	
	
	public String pdf(){
		return "pdf";
	}
	
	public String htmlView(){
		return SUCCESS;
	}
	
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
}
