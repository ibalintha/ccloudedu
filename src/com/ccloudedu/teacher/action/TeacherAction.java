package com.ccloudedu.teacher.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.common.entity.ChClasstree;
import com.ccloudedu.common.entity.ChSchoolroll;
import com.ccloudedu.common.entity.ChTeacher;
import com.ccloudedu.student.service.ChClasstreeService;
import com.ccloudedu.student.service.SchoolRollService;
import com.ccloudedu.student.service.StudentService;
/**
 * 教职工管理action
 * @author jiangt
 * 2013-07-22 17:28
 */
@Controller("teacher.action.TeacherAction")
@Scope("prototype")
public class TeacherAction extends BaseUploadFileAction<ChTeacher> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ChClasstree> chclasstreeList;
	private List<ChSchoolroll> chSchoolrollList;
	private ChClasstree chclasstree;
	
	private String chClasId;
	private String isLast;
	private String chScroSchcode;
	private String chScroName;
	
	private Page page = new Page(Constants.PAGE_SIZE);
	


	@Autowired
	private StudentService studentService;
	@Autowired
	private ChClasstreeService classtreeService;
	@Autowired
	private SchoolRollService shcoolRollService;
	

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
	
	
	
	
	
	
	
	
	
	
	@Override
	public ChTeacher getModel() {
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
	
}
