package com.ccloudedu.system.action;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.utils.file.UploadUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.system.entity.SysDept;
import com.ccloudedu.system.service.DeptService;
import com.google.common.collect.Lists;

/**
 * 部门管理action
 * @author wade
 *2009-03-23 晚
 */
@Controller("system.action.DeptAction")
@Scope("prototype")
//@Auth(value=RWType.W,roleCodes="boss,admin")
public class DeptAction extends BaseUploadFileAction<SysDept>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysDept dept;
	private SysDept sysDept;
	//部门id
    private String id;
    private List<SysDept> deptList;
	//每页显示10条记录
    private Page page = new Page(Constants.PAGE_SIZE);
    @Autowired
    private DeptService deptService;

	public SysDept getModel() {
		return dept;
	}
	@Override
	public void prepareModel() throws Exception {
		//新增部门
		if(StringUtils.isBlank(id)){
			dept = new SysDept();
			dept.setCreateTime(DateUtils.getCurrentDate());
			dept.setCreateUser(Sessions.getSysUser());
			if(StringUtils.isNotEmpty(sysDept.getId())){
				//非一级部门
				dept.setSysDept(deptService.get(sysDept.getId()));
			}
		}
		//修改部门
		else{
			dept = deptService.get(id);
		}
	}
	
	public String save() throws Exception {
	    if(StringUtils.isBlank(id)){
	    	//生成层级，层级末尾是个随机数
	    	Random random = new Random();
	    	SysDept parentDept = dept.getSysDept();
	    	String parentDeptLevel = parentDept.getDeptLevel();
	    	int maxDeptLevel = deptService.getCountSubDeptNumByParentId(parentDept.getId())+1;
	    	dept.setDeptLevel(parentDeptLevel+"_"+(maxDeptLevel+"")+"_"+Math.abs(random.nextInt()) % 100 + 1);
	    	
			deptService.save(dept);
			//updateDeptListInServletContext();
			Renders.renderJson(new EasyUiResult("0","保存成功",Lists.newArrayList(dept.getId())));
		}else{
			deptService.update(dept);
			//updateDeptListInServletContext();
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	public String add(){
		try{
			sysDept = deptService.get(id);
		}catch (Exception e) {
			addActionMessage("没有上级部门，请先选择上级部门");
		}
		return ADD;
	}
	public String update(){
		return UPDATE;
	}
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		deptService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	@Override
	public String list() throws Exception {
		setId(id);
		page = deptService.findPage(page,id);
		return SUCCESS;
	}
	
	
	/**
	 * 部门树
	 * @return
	 * @throws Exception
	 */
	@Menu
	public String tree() throws Exception {
		deptList = deptService.findListByDeptLevel();
		return TREE;
	}
	
	/**
	 * 选择部门
	 * @return
	 * @throws Exception
	 */
	public String chooseDept() throws Exception {
		deptList = deptService.findListByDeptLevel();
		return "chooseDept";
	}

	
	public String layout() throws Exception {
		//getDeptOrDeptUser("");
		return NONE;
	}
	public String getDeptAndUsers() throws Exception {
		//getDeptOrDeptUser("1");
		return NONE;
	}

	/**
	 * ajax 检查部门名是否重复
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String checkDeptName()throws Exception{

		Map<String,String> paramMap = new FastMap().newHashMap().set("deptName", Servlets.getRequest().getParameter("deptName"));
		dept = deptService.findOne("system.findDepts",paramMap);
		//存在相同名称的部门
		if(dept != null){
			Renders.renderJson("true");
		}else{
			Renders.renderJson("false");
		}
		return NONE;
	}
	
	public String toImportDept(){
		 return "toImportDept";
	 }
	
	
    public String importExcel() throws Exception {
		String msg = "导入成功";
		//Workbook wb = ExcelUtils.getWorkbook(getUpload().get(0));
		//boolean isSuccess  = true;
        //List<SysDept> deptList = new ArrayList<SysDept>();
        //List<String> propertyNames = Lists.newArrayList("enDeptName","deptName","deptPhone","deptFax","deptEmail","postAddress","webSite","remark");
       /* deptList =  ExcelUtils.readExcel2List(filePath, 0, 2, propertyNames, SysDept.class);
        for(SysDept d : deptList){
        	System.out.println(d.getDeptName());
        }*/
		Renders.renderJson(msg);
        return NONE;
	}
	
	@Override
	public String download()throws Exception{
		UploadUtils.download("部门模板.xls","/uploadfile/templete/部门模板.xls");
        return NONE;
	}

	//----------------一下是getter/setter方法-----------------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<SysDept> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<SysDept> deptList) {
		this.deptList = deptList;
	}
	public SysDept getSysDept() {
		return sysDept;
	}
	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}
}
