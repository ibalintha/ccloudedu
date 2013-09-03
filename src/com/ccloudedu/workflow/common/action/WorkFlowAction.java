package com.ccloudedu.workflow.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.jbpm.api.model.ActivityCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.struts2.action.BaseAuthAction;
import com.ccloudedu.workflow.common.service.JbpmService;
import com.opensymphony.xwork2.Preparable;

/**
 * 工作流部署action
 * @author wade
 */
@Controller("workflow.common.action.WorkFlowAction")
@Scope("prototype")
public class WorkFlowAction extends BaseAuthAction implements Preparable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File upload; //附件
    private String uploadFileName;//附件名
    private String uploadContentType;//附件类型
    private String deployId;
    
    private String processDefinitionId;
	private String processInstanceId;
	
    //当前执行步骤
	private ActivityCoordinates activityCoordinate;
	private int x;
	private int y;
	private int width;
	private int heigth;
	
    @Autowired
    private JbpmService jbpmService;
	
	public void prepare() throws Exception {
		
		
	}
	
	public String showWorkFlowPic(){
		activityCoordinate = jbpmService.getActivityCoordinates(processInstanceId);
		x = activityCoordinate.getX();
		y = activityCoordinate.getY();
		width = activityCoordinate.getWidth();
		heigth = activityCoordinate.getHeight();
		return "prcessPic";
	}
	
	/**
	 * 查看流程图
	 * @return
	 * @throws IOException
	 */
	public String getWorkFlowPic() throws IOException{
		byte[] imgdata = jbpmService.getPicStream(processDefinitionId);
		HttpServletResponse response = Servlets.getResponse();
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream(); 
        out.write(imgdata); 
        out.flush(); 
        out.close();
		return NONE;
	}
	
	/**
	 * /workflow/deploy_toDeploy.do
	 * @return
	 */
	public String toDeploy(){
		return "deploy";
	}
	
	/**
	 * 部署
	 * @return
	 * @throws FileNotFoundException
	 */
	public String deploy() throws FileNotFoundException{
		jbpmService.deploy(new FileInputStream(upload)); 
		addActionMessage("部署成功");
		return "deploy";
	}
	
	/**
	 * 删除
	 * 
	 * /workflow/deploy_removeDeploy.do?deployId=
	 * 
	 * @return
	 */
	public String removeDeploy(){
		jbpmService.deleteDeployment(deployId);
		addActionMessage("删除成功");
		return "deploy";
	}
	
	public String getDeployId() {
		return deployId;
	}

	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public ActivityCoordinates getActivityCoordinate() {
		return activityCoordinate;
	}

	public void setActivityCoordinate(ActivityCoordinates activityCoordinate) {
		this.activityCoordinate = activityCoordinate;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
}
