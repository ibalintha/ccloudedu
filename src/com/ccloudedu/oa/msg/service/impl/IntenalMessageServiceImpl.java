package com.ccloudedu.oa.msg.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.oa.msg.entity.OaIntenalMessage;
import com.ccloudedu.oa.msg.service.IntenalMessageService;
import com.ccloudedu.upload.service.UploadFileService;

import edu.emory.mathcs.backport.java.util.Arrays;

@Service
@Transactional
public class IntenalMessageServiceImpl extends BaseServiceImpl<OaIntenalMessage> implements IntenalMessageService {
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(List<OaIntenalMessage> iMsgList, String uploadPath,List<File> upload, List<String> uploadFileName,List<String> uploadContentType) throws Exception {
		for(OaIntenalMessage iMsg : iMsgList){
			save(iMsg);
			//上传用户图片到磁盘
			uploadFileService.upload(iMsg.getId(), uploadPath, upload, uploadFileName, uploadContentType);
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void update(OaIntenalMessage intenalMessage, String uploadPath,
			List<File> upload, List<String> uploadFileName,
			List<String> uploadContentType) throws Exception {
	
		//上传附件到磁盘、保存附件信息到数据库
		uploadFileService.upload(intenalMessage.getId(), uploadPath, upload, uploadFileName, uploadContentType);
		
		update(intenalMessage);
	}

	@SuppressWarnings("unchecked")
	public List<OaIntenalMessage> findList(Map<String, String> paramMap) throws Exception{
		return findList("oa.findIntenalMessages",paramMap);
	}
	
	public Page findPage(Page page,Map<String,String> paramMap)throws Exception {
		return findPage(page,"oa.findIntenalMessages",paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public int batchUpdateOrDelete(String[] ids)throws Exception {
		return batch("oa.updateIntenalMessage",new FastMap().newHashMap().set("ids", Arrays.asList(ids)));
	}
}
