package com.ccloudedu.upload.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.utils.file.UploadUtils;
import com.ccloudedu.upload.entity.UploadFile;
import com.ccloudedu.upload.service.UploadFileService;
@Service
@Transactional
public class UploadFileServiceImpl extends BaseServiceImpl<UploadFile> implements UploadFileService {
	/**
	 * 根据附件拥有方，查询附件列表
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<UploadFile> findByOwnerId(String ownerId) throws Exception {
		return findList("system.findUploadFiles",new FastMap().newHashMap().set("ownerId",ownerId ));
	}
	
	/**
	 * 通过附件id删除附件
	 * 删除数据库中的记录，同时删除磁盘上附件
	 * @throws Exception 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteById(String uploadFileId) throws Exception{
		UploadFile uploadFile = get(uploadFileId);
		String uploadFilePath = uploadFile.getUploadFilePath();
		//删除附件在数据库的记录
		delete(uploadFile);
		//删除磁盘上的附件
		UploadUtils.deleteFile(uploadFilePath);
		return 1;
	}
	
	/**
	 * 通过附件关联的业务id，删除附件
	 * 删除数据库中的记录，同时删除磁盘上附件
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteByOwnerId(String ownerId) throws Exception{
		List<UploadFile> uploadFiles = findByOwnerId(ownerId);
		if(uploadFiles!=null && uploadFiles.size()>0){
			for(UploadFile uploadFile : uploadFiles){
				String uploadFilePath = uploadFile.getUploadFilePath();
				
				delete(uploadFile);
				
				UploadUtils.deleteFile(uploadFilePath);
			}
		}
		return 1;
	}
	/**
	 * 上传附件到磁盘，并在数据库中插入记录
	 * @throws Exception 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<UploadFile> upload(String ownerId,String uploadPath,List<File> upload,List<String> uploadFileName, List<String> uploadContentType) throws Exception{
		//上传附件到磁盘
		List<UploadFile> uploadFiles = UploadUtils.upload(ownerId, uploadPath, upload, uploadFileName, uploadContentType);
		//保存附件信息到数据库
		if(uploadFiles!=null && uploadFiles.size()>0){
			for(UploadFile uploadFile :uploadFiles){
				save(uploadFile);
			}
		}
		return uploadFiles;
	}
}
