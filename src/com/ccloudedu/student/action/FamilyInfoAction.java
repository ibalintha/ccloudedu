package com.ccloudedu.student.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.utils.ParseString;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.common.entity.ChAdminway;
import com.ccloudedu.common.entity.ChBloodtype;
import com.ccloudedu.common.entity.ChClasstree;
import com.ccloudedu.common.entity.ChComment;
import com.ccloudedu.common.entity.ChEthnic;
import com.ccloudedu.common.entity.ChFamily;
import com.ccloudedu.common.entity.ChForeign;
import com.ccloudedu.common.entity.ChHealthstatus;
import com.ccloudedu.common.entity.ChHomeVisite;
import com.ccloudedu.common.entity.ChOtherInfo;
import com.ccloudedu.common.entity.ChPolface;
import com.ccloudedu.common.entity.ChPosition;
import com.ccloudedu.common.entity.ChPractice;
import com.ccloudedu.common.entity.ChResume;
import com.ccloudedu.common.entity.ChReward;
import com.ccloudedu.common.entity.ChSchoolroll;
import com.ccloudedu.common.entity.ChSpecial;
import com.ccloudedu.common.entity.ChWorks;
import com.ccloudedu.student.entity.AllInfoJson;
import com.ccloudedu.student.entity.ChCommentJson;
import com.ccloudedu.student.entity.ChFamilyJson;
import com.ccloudedu.student.entity.ChHomeVisiteJson;
import com.ccloudedu.student.entity.ChOtherInfoJson;
import com.ccloudedu.student.entity.ChPositionJson;
import com.ccloudedu.student.entity.ChPracticeJson;
import com.ccloudedu.student.entity.ChResumeJson;
import com.ccloudedu.student.entity.ChRewardJson;
import com.ccloudedu.student.entity.ChSpecialJson;
import com.ccloudedu.student.entity.ChWorksJson;
import com.ccloudedu.student.service.ChClasstreeService;
import com.ccloudedu.student.service.CommentsService;
import com.ccloudedu.student.service.FamilyInfoService;
import com.ccloudedu.student.service.HomeVisiteService;
import com.ccloudedu.student.service.OtherInfoService;
import com.ccloudedu.student.service.PositionService;
import com.ccloudedu.student.service.PracticeService;
import com.ccloudedu.student.service.ResumeService;
import com.ccloudedu.student.service.RewardService;
import com.ccloudedu.student.service.SchoolRollService;
import com.ccloudedu.student.service.SpecialService;
import com.ccloudedu.student.service.StudentService;
import com.ccloudedu.student.service.WorksService;
import com.google.gson.GsonBuilder;
/**
 * 家庭信息action
 * @author Pescadito
 * 2013-07-22 17:28
 */
@Controller("student.action.FamilyInfoAction")
@Scope("prototype")
public class FamilyInfoAction extends BaseUploadFileAction<ChSchoolroll> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String id;
	private String familyId;
	private String scroId;
	private String name;
	private String age;
	private String relationship;
	private String polface;
	private String company;
	private String address;
	private String position;
	private String vacation;
	private String zip;
	private String email;
	private String phone;
	private String cell;
	private String sms;
	private String special;
	private String type;
	private String record;

	private List<ChAdminway> admwayList;
	private List<ChBloodtype> bltpList;
	private List<ChEthnic> ethnicList;
	private List<ChForeign> foreginList;
	private List<ChHealthstatus> hestList;	
	private List<ChPolface> plfaceList;
	
	@Autowired
	private FamilyInfoService familyService;
	@Autowired
	private StudentService studentService;
	
	public String addFamily(){
//		scroId = Servlets.getRequest().getParameter("scroId");
		ChFamily cf = new ChFamily(scroId, 
				relationship, 
				name, 
				age, 
				null, 
				company, 
				position, 
				phone, 
				polface, 
				null, 
				address, 
				vacation, 
				zip, 
				email, 
				cell, 
				special, 
				type, 
				record, 
				sms);
		try {
			ChFamily family = familyService.save(cf);
			if(family != null){
				Renders.renderJson(Renders.SAVE_SUCCESS);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "add";
	}
	
	/**
	 * 使用ajax批量删除记录
	 * @throws Exception
	 */
	public @ResponseBody void deleteIds() throws Exception{		
		String ids = ServletActionContext.getRequest().getParameter("ids");
		String[] idStrs = ParseString.parseBindApps(ids,",");
		List<ChFamily> deleteObjs= familyService.deleteByIds(idStrs);
		if(deleteObjs.size() != 0){
			this.sendMsg("success");
		}else{
			this.sendMsg("failed");
		}
		
	}
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
	 * 根据id查询到一个实体
	 * @return
	 * @throws Exception 
	 */
	public String findOneId() throws Exception{
	 	admwayList = studentService.findListByChAdminway();
		bltpList = studentService.findListByChBloodtype();
		ethnicList = studentService.findListByChEthnic();
		hestList = studentService.findListByChHealthstatus();
		plfaceList = studentService.findListByChPolface();
		String id = ServletActionContext.getRequest().getParameter("familyId");
		ChFamily cf = familyService.get(id);
		if(cf != null){
			this.familyId = cf.getId();
			this.scroId = cf.getChScroId(); 
			this.relationship = cf.getChFamiNickname(); 
			this.name = cf.getChFamiName(); 
			this.age = cf.getChFamiAge(); 
			this.company = cf.getChFamiWorkcompany(); 
			this.position = cf.getChFamiPostion(); 
			this.phone = cf.getChFamiPhone(); 
			this.polface = cf.getChFamiPolface();
			this.address = cf.getChFamiAddress(); 
			this.vacation = cf.getChFamiVacation();
			this.zip = cf.getChFamiZip();
			this.email = cf.getChFamiEmail();
			this.cell = cf.getChFamiCell();
			this.special = cf.getChFamiSpecial();
			this.type = cf.getChFamiServeType(); 
			this.record = cf.getChFamiServeRecord();
			this.sms = cf.getChFamiSms();
		}
		return "edit";
	}
	
	/**
	 * 更新用户家庭信息
	 * @return
	 */
	public String editFamily(){
		ChFamily cf = new ChFamily(scroId, 
				relationship, 
				name, 
				age, 
				null, 
				company, 
				position, 
				phone, 
				polface, 
				null, 
				address, 
				vacation, 
				zip, 
				email, 
				cell, 
				special, 
				type, 
				record, 
				sms);
		cf.setId(familyId);
		try {
			ChFamily family = familyService.update(cf);
			if(family != null){
				Renders.renderJson(Renders.SAVE_SUCCESS);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "update";
	}
	
	
	
	
	
	
	
	
	
	
	public String getScroId() {
		return scroId;
	}

	public void setScroId(String scroId) {
		this.scroId = scroId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getPlfaList() {
		return polface;
	}

	public void setPlfaList(String plfaList) {
		this.polface = plfaList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getVacation() {
		return vacation;
	}

	public void setVacation(String vacation) {
		this.vacation = vacation;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getPolface() {
		return polface;
	}
	
	public void setPolface(String polface) {
		this.polface = polface;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
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

	public List<ChPolface> getPlfaceList() {
		return plfaceList;
	}

	public void setPlfaceList(List<ChPolface> plfaceList) {
		this.plfaceList = plfaceList;
	}

	public String getFamilyId() {
		return familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	@Override
	public ChSchoolroll getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detail() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
