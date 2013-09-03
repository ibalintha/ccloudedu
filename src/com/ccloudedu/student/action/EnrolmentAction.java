package com.ccloudedu.student.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.common.entity.ChEthnic;
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
import com.ccloudedu.common.entity.ChStudent;
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
 * 学籍管理action
 * @author Pescadito
 * 2013-07-22 17:28
 */
@Controller("student.action.EnrolmentAction")
@Scope("prototype")
public class EnrolmentAction extends BaseUploadFileAction<ChSchoolroll> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ChAdminway> admwayList;
	private List<ChBloodtype> bltpList;
	private List<ChEthnic> ethnicList;
	private List<ChForeign> foreginList;
	private List<ChHealthstatus> hestList;
	private List<ChPolface> plfaList;
	private List<ChClasstree> chclasstreeList;
	private List<ChSchoolroll> chSchoolrollList;
	private ChClasstree chclasstree;
	private ChSchoolroll enrollment; 
	private String ids;
	private String id;
	
	private String chClasId;
	private String isLast;
	private String chScroSchcode;
	private String chScroName;
	private String schoolRollNum;
	private String ajaxJson;
	private String scroId;//ajax取得详细信息时选择的学生的id，需要传到新增和编辑页面
	
	private Page page = new Page(Constants.PAGE_SIZE);
	
	

	@Autowired
	private StudentService studentService;
	@Autowired
	private ChClasstreeService classtreeService;
	@Autowired
	private SchoolRollService shcoolRollService;
	@Autowired
	private FamilyInfoService familyService;
	@Autowired
	private CommentsService  commentService;
	@Autowired
	private HomeVisiteService homeVisiteService;
	@Autowired
	private OtherInfoService otherInfoService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private PracticeService practiceService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private RewardService rewardService;
	@Autowired
	private SpecialService specialService;
	@Autowired
	private WorksService worksService;

	/**
	 * 进入学籍管理页面，获得模板导航中的树列表
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Menu
	public String tree() throws Exception{
		
		chclasstreeList = studentService.findList("system.findClassTrees",null);
		return TREE;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
			if(StringUtils.isBlank(id)){
				enrollment = new ChSchoolroll();
				//enrollment.setChStudMaketime(DateUtils.getCurrentDate());
				enrollment.setChScroMaketime(DateUtils.getCurrentDate());
				//user.setCreateUser(this.UserSession.getSysUser());
			}else{
				enrollment = shcoolRollService.get(id);
				//admwayList = shcoolRollService.findListByChAdminway();
			//	bltpList = studentService.findListByChBloodtype();
			//	ethnicList = studentService.findListByChEthnic();
			//	hestList = studentService.findListByChHealthstatus();
			//	plfaList = studentService.findListByChPolface();
			}
	}
	/**
	 * 条件搜索学生
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public String queryEnrolment(){
		return "queryEnrolment";
	}
	/**
	 * 条件搜索学生
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public String addin(){
		return "addin";
	}
	/**
	 * 进入重新分班
	 * 
	 * */
	public String reOrder(){
		ids=Servlets.getRequest().getParameter("id");
		chClasId = Servlets.getRequest().getParameter("chClasId");
		try {
			chclasstreeList = studentService.findListByChClasstree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "reOrder";
	 }
	
	@SuppressWarnings("unchecked")
	public String getStudentsByAjax() throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chScroSchcode", "%"+chScroSchcode+"%")
		.set("chScroName", "%"+chScroName+"%");
		
		List<ChSchoolroll> studentList = studentService.findList("enrolment.findEnrolments", paramMap);
		List<ChSchoolroll> jsonList = new ArrayList<ChSchoolroll>();
		if(studentList!=null && studentList.size()>0){
			for(ChSchoolroll u : studentList){
				enrollment = new ChSchoolroll();
				enrollment.setId(u.getId());
				enrollment.setChScroEngname(u.getChScroName());
				//student.setChStudSex(u.getChStudSex());
				jsonList.add(enrollment);
			}
		}
		Renders.renderJson(jsonList);
		return NONE;
	}
	/**
	 * 重新分班保存
	 * 
	 * */
public String reOrderSave() throws Exception{
		
		String[] idstr =  ids.split(",");
		for(int i=0;i<idstr.length;i++){
			Map<String,String> paramMap = new FastMap().newHashMap()
			.set("id", ""+idstr[i]+"");
			ChSchoolroll cst = new ChSchoolroll();
			cst = shcoolRollService.findOne("enrolment.findEnrolments", paramMap);
			cst.setChClasId(chClasId);
			shcoolRollService.update(cst);
		}
		Renders.renderJson(Renders.SAVE_SUCCESS);
		return NONE;
	}
	/**
	 * 获取学籍信息列表
	 */
	@Override
	@Menu
	public String list() throws Exception {
		
		 HttpServletRequest req = Servlets.getRequest();
		 HttpSession hs = req.getSession();
		 //将现在所在的树节点写入到session中
		 hs.setAttribute("TheClasId",chClasId);
		 //查询条件，学号
		 if(chScroSchcode==null||chScroSchcode.equals("")){
			 chScroSchcode = null;
		 }
		 //查询条件，学生姓名
		 if(chScroName==null||chScroName.equals("")){
			 chScroName = null;
		 }
		 //查询姓名为中文时，将格式转为utf-8
		 if(chScroName!=null){
			 chScroName = java.net.URLDecoder.decode(chScroName,"UTF-8");
			 }
		 if(!"1".equals(chClasId)){//如果树节点不是1，说明是按照子节点查询，例如初高中或者班级
			 if(isLast!=null&&isLast.equals("Y")){//islast=Y,表示是终节点
				 page = shcoolRollService.findSchoolRolls(page, chScroSchcode, chScroName, chClasId);
			 }else{
				 page = shcoolRollService.findSchoolRolls2(page, chScroSchcode,chScroName, chClasId);
			 }
		  }else{//如果树节点是1，说明是根节点，表示全校学生
			  page = shcoolRollService.findSchoolRolls(page,chScroSchcode,chScroName, "");
		  }
		 
		 chclasstree = classtreeService.get(chClasId);		
		
		return LIST;
	}
	
	//Ajax学籍管理中的详细信息查询
	public @ResponseBody void details() throws Exception{
		//学籍号
		String chScroId = ServletActionContext.getRequest().getParameter("id");
		//查询学籍信息
		ChSchoolroll chSchoolroll = shcoolRollService.get(chScroId);
		String chScroSchroll = chSchoolroll.getChScroSchroll();//学籍号
		String chScroName = chSchoolroll.getChScroName();//学生姓名
		String chScroSchcode = chSchoolroll.getChScroSchcode();//学号
				
		List<ChFamily> famlilyList = familyService.getFamilyById(chScroId);
		List<ChComment> chCommentList = commentService.getCommentById(chScroId);
		List<ChHomeVisite> chHomeVisiteList = homeVisiteService.getList(chScroId);
		List<ChOtherInfo> chOtherInfoList = otherInfoService.getList(chScroId);
		List<ChPosition> chPositionList = positionService.getList(chScroId);
		List<ChPractice> chPracticeList = practiceService.getList(chScroId);
		List<ChResume> chResumeList = resumeService.getList(chScroId);
		List<ChReward> chRewardList = rewardService.getList(chScroId);
		List<ChSpecial> chSpecialList = specialService.getList(chScroId);
		List<ChWorks> chWorksList = worksService.getList(chScroId);

		List<ChFamilyJson> chFamilyJsonList = new ArrayList<ChFamilyJson>();
		for(ChFamily cf:famlilyList){
			ChFamilyJson chFamilyJson = new ChFamilyJson(cf.getId(),
					chScroId,
					chScroSchroll,
					chScroName,
					cf.getChFamiNickname(),
					cf.getChFamiName(),
					cf.getChFamiAge(),
					cf.getChFamiPersonid(),
					cf.getChFamiWorkcompany(),
					cf.getChFamiPostion(),
					cf.getChFamiPhone(),
					cf.getChFamiPolface(),
					cf.getChFamiMemo(),
					cf.getChFamiAddress(),
					cf.getChFamiVacation(),
					cf.getChFamiZip(),
					cf.getChFamiEmail(),
					cf.getChFamiCell(),
					cf.getChFamiSpecial(),
					cf.getChFamiServeType(),
					cf.getChFamiServeRecord(),
					cf.getChFamiSms());
			chFamilyJsonList.add(chFamilyJson);
		}		
		List<ChCommentJson> chCommentJsonList = new ArrayList<ChCommentJson>();
		for(ChComment cc:chCommentList){
			ChCommentJson chCommentJson = new ChCommentJson(cc.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName, 
					cc.getChCommentTime(), 
					cc.getChCommentSemester(), 
					cc.getChCommentTeacher(), 
					cc.getChCommentContent(), 
					cc.getChCommentLevel());
			chCommentJsonList.add(chCommentJson);
		}		
		List<ChHomeVisiteJson> chHomeVisiteJsonList = new ArrayList<ChHomeVisiteJson>();
		for(ChHomeVisite cv:chHomeVisiteList){
			ChHomeVisiteJson chHomeVisiteJson = new ChHomeVisiteJson(cv.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName, 
					cv.getChHomeVisiteTimespan(), 
					cv.getChHomeVisiteSemester(), 
					cv.getChHomeVisiteTime(), 
					cv.getChHomeVisiteReason());
			chHomeVisiteJsonList.add(chHomeVisiteJson);
		}
		List<ChOtherInfoJson> chOtherInfoJsonList = new ArrayList<ChOtherInfoJson>();
		for(ChOtherInfo co:chOtherInfoList){
			ChOtherInfoJson chOtherInfoJson = new ChOtherInfoJson(co.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName, 
					co.getChOtherInfoTimespan(), 
					co.getChOtherInfoSemester(), 
					co.getChOtherInfoCarNum(), 
					co.getChOtherInfoExtend(), 
					co.getChOtherInfoImprove(), 
					co.getChOtherInfoSport(), 
					co.getChOtherInfoArtSchool(),
					co.getChOtherInfoInterest(),
					co.getChOtherInfoOthers());
			chOtherInfoJsonList.add(chOtherInfoJson);
		}		
		List<ChPositionJson> chPositionJsonList = new ArrayList<ChPositionJson>();
		for(ChPosition cp:chPositionList){
			ChPositionJson chPositionJson = new ChPositionJson(cp.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName, 
					cp.getChPisitionTime(), 
					cp.getChPositionClass(), 
					cp.getChPositionSemester(), 
					cp.getChPositionJob(), 
					cp.getChPositionPolface(), 
					cp.getChPositionMaketime(), 
					cp.getChPositionAgent());
			chPositionJsonList.add(chPositionJson);
		}		
		List<ChPracticeJson> chPracticeJsonList = new ArrayList<ChPracticeJson>();
		for(ChPractice cp:chPracticeList){
			ChPracticeJson chPracticeJson = new ChPracticeJson(cp.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName, 
					cp.getChPracticeTimespan(), 
					cp.getChPracticeSemester(), 
					cp.getChPracticeTime(), 
					cp.getChPracticePlace(), 
					cp.getChPracticeContent(),
					cp.getChPracticeMemo());
			chPracticeJsonList.add(chPracticeJson);
		}
		List<ChResumeJson> chResumeJsonList = new ArrayList<ChResumeJson>();
		for(ChResume cr:chResumeList){
			ChResumeJson chResumeJson = new ChResumeJson(cr.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName, 
					cr.getChResumeSchool(), 
					cr.getChResumeTime(), 
					cr.getChResumeBeginTime(), 
					cr.getChResumeEndTime(), 
					cr.getChResumeCertifier(),
					cr.getChResumeSemester(),
					cr.getChResumeMemo());
			chResumeJsonList.add(chResumeJson);
		}		
		List<ChRewardJson> chRewardJsonList = new ArrayList<ChRewardJson>();
		for(ChReward cr:chRewardList){
			ChRewardJson chRewardJson = new ChRewardJson(cr.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName, 
					chScroSchcode,
					cr.getChRewardTimespan(),
					cr.getChRewardSemester(),
					cr.getChRewardPunishment(),
					cr.getChRewardOffice(),
					cr.getChRewardName(),
					cr.getChRewardCertificate(),
					cr.getChRewardTime(),
					cr.getChRewardLevel(),
					cr.getChRewardReason(),
					cr.getChRewardInfo(),
					cr.getChRewardWay(),
					cr.getChRewardMemo());
			chRewardJsonList.add(chRewardJson);
		}		
		List<ChSpecialJson> chSpecialJsonList = new ArrayList<ChSpecialJson>();
		for(ChSpecial cs:chSpecialList){
			ChSpecialJson chSpecialJson = new ChSpecialJson(cs.getId(), 
					chScroId, 
					chScroSchroll, 
					chScroName,
					chScroSchcode,
					cs.getChSpecialTimespan(), 
					cs.getChSpecialSemester(), 
					cs.getChSpecialTime(), 
					cs.getChSpecialReason(), 
					cs.getChSpecialComment(),
					cs.getChSpecialLevel(),
					cs.getChSpecialOffice(),
					cs.getChSpecialContent(),
					cs.getChSpecialCertificate());
			chSpecialJsonList.add(chSpecialJson);
		}		
		List<ChWorksJson> chWorksJsonList = new ArrayList<ChWorksJson>();
		for(ChWorks cw:chWorksList){
			ChWorksJson chWorksJson = new ChWorksJson(cw.getId(),
					chScroId, 
					chScroSchroll, 
					chScroName, 
					cw.getChWorksTime(), 
					cw.getChWorksSemester(), 
					cw.getChWorksName(), 
					cw.getChWorksDealTime(), 
					cw.getChWorksContent(),
					cw.getChWorksMemo());
			chWorksJsonList.add(chWorksJson);
		}

		AllInfoJson allinfoJson = new AllInfoJson(chCommentJsonList, 
				chFamilyJsonList, chHomeVisiteJsonList, 
				chOtherInfoJsonList, chPositionJsonList, 
				chPracticeJsonList, chResumeJsonList, 
				chRewardJsonList, chSpecialJsonList, chWorksJsonList);
		
		GsonBuilder builder = new GsonBuilder();		
		String ajaxJson = builder.create().toJson(allinfoJson);
		System.out.println("ajaxJson==="+ajaxJson);
		this.sendMsg(ajaxJson);
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
	
	public String save() throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(id)){
			//String aa=Servlets.getRequest().getParameter("chScroEthnic");
			/*if(aa.equals("")){
				aa = "1";
			}
			ChEthnic dd = new ChEthnic();
			dd.setId(aa);*/
			//enrollment.setChScroEthnic(aa);
			shcoolRollService.save(enrollment);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
//			String aa=Servlets.getRequest().getParameter("chScroEthnic");
//			if(aa.equals("")){
//				aa = "1";
//			}
			//ChEthnic dd = new ChEthnic();
			//dd.setId(aa);
			//enrollment.setChScroEthnic(aa);
			shcoolRollService.update(enrollment);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	/**
	 * 返回到新增家庭信息的弹出窗口
	 * @return
	 * @throws Exception 
	 */
	public String addFamily() throws Exception{
	 	admwayList = studentService.findListByChAdminway();
		bltpList = studentService.findListByChBloodtype();
		ethnicList = studentService.findListByChEthnic();
		hestList = studentService.findListByChHealthstatus();
		plfaList = studentService.findListByChPolface();
		scroId = ServletActionContext.getRequest().getParameter("id");
		return "addFamily";
	}
	/**
	 * 批量删除action
	 * @throws Exception 
	 */
	public String deleteIds() throws Exception{
		String scroIds = ServletActionContext.getRequest().getParameter("ids");
		String[] ids = scroIds.split(",");
		familyService.deleteFamilyByScroIds(ids);
		commentService.deleteCommentByScroIds(ids);
		homeVisiteService.deleteHomeVisiteByScroIds(ids);
		otherInfoService.deleteOtherInfoByScroIds(ids);
		positionService.deletePostionByScroIds(ids);
		practiceService.deletePracticeByScroIds(ids);
		resumeService.deleteResumeByScroIds(ids);
		rewardService.deleteRewardByScroIds(ids);
		specialService.deleteSpecialByScroIds(ids);
		worksService.deleteWorksByScroIds(ids);
		shcoolRollService.deleteByIds(ids);
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}
	
	@Override
	public ChSchoolroll getModel() {
		
			return enrollment;
		
	
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
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ChClasstree> getChclasstreeList() {
		return chclasstreeList;
	}
	public void setChclasstreeList(List<ChClasstree> chclasstreeList) {
		this.chclasstreeList = chclasstreeList;
	}

	public List<ChSchoolroll> getChSchoolrollList() {
		return chSchoolrollList;
	}

	public void setChSchoolrollList(List<ChSchoolroll> chSchoolrollList) {
		this.chSchoolrollList = chSchoolrollList;
	}

	public ChClasstree getChclasstree() {
		return chclasstree;
	}

	public void setChclasstree(ChClasstree chclasstree) {
		this.chclasstree = chclasstree;
	}

	public String getChClasId() {
		return chClasId;
	}

	public void setChClasId(String chClasId) {
		this.chClasId = chClasId;
	}

	public String getIsLast() {
		return isLast;
	}

	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getChScroSchcode() {
		return chScroSchcode;
	}

	public void setChScroSchcode(String chScroSchcode) {
		this.chScroSchcode = chScroSchcode;
	}

	public String getChScroName() {
		return chScroName;
	}

	public void setChScroName(String chScroName) {
		this.chScroName = chScroName;
	}

	public String getSchoolRollNum() {
		return schoolRollNum;
	}

	public void setSchoolRollNum(String schoolRollNum) {
		this.schoolRollNum = schoolRollNum;
	}

	public String getAjaxJson() {
		return ajaxJson;
	}

	public void setAjaxJson(String ajaxJson) {
		this.ajaxJson = ajaxJson;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
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
	public String getScroId() {
		return scroId;
	}
	public void setScroId(String scroId) {
		this.scroId = scroId;
	}

	public ChSchoolroll getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(ChSchoolroll enrollment) {
		this.enrollment = enrollment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
