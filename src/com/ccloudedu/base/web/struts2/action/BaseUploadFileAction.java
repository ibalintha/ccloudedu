package com.ccloudedu.base.web.struts2.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccloudedu.base.utils.file.UploadUtils;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.upload.entity.UploadFile;
import com.ccloudedu.upload.service.UploadFileService;

/**
 * 附件上传基类
 * 
 * 涉及附件的上传、下载、删除操作
 * 
 * 如果没有涉及附件上传，action继承ActionSupport或BaseAuthAction或BaseCurdAction
 * 
 * @author wade
 */
public abstract class BaseUploadFileAction<T> extends BaseCrudAction<T>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<File> upload; //附件
    private List<String> uploadFileName;//附件名
    private List<String> uploadContentType;//附件类型
    
    private String uploadFileId;//UploadFile 的id，下载或删除附件时使用
    private List<UploadFile> uploadFileList;//附件列表，一个或多个附件，用于在页面上显示
    
    @Autowired
	private UploadFileService uploadFileService;//附件service
    
    /**
     * 下载附件
     */
    public String download()throws Exception{
    	UploadFile uploadFile = uploadFileService.get(uploadFileId);
		UploadUtils.download(uploadFile.getUploadFileName(),uploadFile.getUploadFilePath());
        return NONE;
	}
	/**
	 * 删除附件
	 * @return
	 * @throws Exception
	 */
	public String deleteUploadFile() throws Exception {
		uploadFileService.deleteById(uploadFileId);
        return NONE;
	}
	/**
	 * ajax方式删除附件
	 * @return
	 * @throws Exception
	 */
	public String deleteUploadFileByAjax() throws Exception {
		uploadFileService.deleteById(uploadFileId);
		Renders.renderJson(Renders.DELETE_SUCCESS);
        return NONE;
	}

	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileId() {
		return uploadFileId;
	}
	public void setUploadFileId(String uploadFileId) {
		this.uploadFileId = uploadFileId;
	}
	public void setUploadFileService(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}
	public UploadFileService getUploadFileService() {
		return uploadFileService;
	}
	public List<UploadFile> getUploadFileList() {
		return uploadFileList;
	}
	public void setUploadFileList(List<UploadFile> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}
}
