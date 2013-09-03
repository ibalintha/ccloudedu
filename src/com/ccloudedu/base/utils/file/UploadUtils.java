package com.ccloudedu.base.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.string.StringEncodeUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.upload.entity.UploadFile;
import com.google.common.collect.Lists;
/**
 * 1、上传附件到磁盘、
 * 2、从磁盘上下载、
 * 3、从磁盘上删除
 * @author wade
 */
public class UploadUtils {
	
	/**
	 * 上传一个附件到磁盘
	 * @param ownerId 附件关联的业务id，当ownerId为空时，仅上传附件到磁盘，不保存附件信息到数据库
	 * @param uploadPath 附件保存到磁盘的路径
	 * @param upload File的List
	 * @param uploadFileName 附件名称
	 * @param uploadContentType 附件类型
	 * @return
	 * @throws Exception
	 */
	public static UploadFile upload(String ownerId,String uploadPath,
			File upload,String uploadFileName,String uploadContentType) throws Exception{
		
		List<File> uploads = Lists.newArrayList(upload);
		List<String> uploadFileNames = Lists.newArrayList(uploadFileName);
		List<String> uploadContentTypes = Lists.newArrayList(uploadContentType);
		
		List<UploadFile> uploadFiles = upload(ownerId, uploadPath, uploads, uploadFileNames, uploadContentTypes);
		
		if(uploadFiles!=null && uploadFiles.size()>0){
			return uploadFiles.get(0);
		}
		return null;
	}
	/**
	 * 同时上传多个附件到磁盘
	 * @param ownerId 附件关联的业务id，当ownerId为空时，仅上传附件到磁盘，不保存附件信息到数据库
	 * @param uploadPath 附件保存到磁盘的路径
	 * @param upload File的list
	 * @param uploadFileName 附件名称
	 * @param uploadContentType 附件类型
	 * @return
	 * @throws Exception
	 */
	public static List<UploadFile> upload(String ownerId,String uploadPath,
			List<File> upload,List<String> uploadFileName, List<String> uploadContentType) throws Exception{
		
		List<UploadFile> uploadFileList= new ArrayList<UploadFile>();
	    if(upload != null && upload.size()>0){   
			  String fileUploadPath = Servlets.getServletContext().getRealPath(uploadPath); 
			  File file = new File(fileUploadPath);   
			  if(!file.exists()){
				   file.mkdirs();
		      }
	          for(int i=0; i<upload.size(); i++){   
	        	   
	        	  String fileName = uploadFileName.get(i);
	        	  if(fileName.lastIndexOf(".")==-1){
	        	       	throw new Exception("请设置附件后缀名");
	        	  }
	        	  //修改附件名为uuid.后缀
	        	  String[] temp =  fileName.split("\\.");//[0] [doc]
	        	  String tempFileName = (UUID.randomUUID().toString()+"."+temp[temp.length-1]);
	        	    
	        	  //附件大小
	        	  double fileSize = 0;
	        	  
	        	  //上传附件到磁盘
	        	  InputStream input = null;
	        	  OutputStream output = null;
	        	  try {
	        	    	input = new FileInputStream(upload.get(i));
			            output = new FileOutputStream(fileUploadPath+"/"+tempFileName);  
			            fileSize = IOUtils.copyLarge(input, output);
				  } catch (Exception e) {
						throw e;
				  } finally{
						IOUtils.closeQuietly(input);
						IOUtils.closeQuietly(output);
				  }
					
				  String tempFileSize = "";
				  
				  //如果有关联的业务id，则将保存附件信息到数据库
	              if(StringUtils.isNotBlank(ownerId)){
	            	  //保存附件信息到数据库
	            	  if((fileSize/1024)<1024){//单位为kb
	            		  fileSize = fileSize/1024;
		   				   DecimalFormat df = new DecimalFormat("#"); 
		   				   tempFileSize = df.format(fileSize)+"KB";
		   			  }else{//单位为M
		   				   fileSize = fileSize/(1024*1024);
		   				   DecimalFormat df = new DecimalFormat("#.00"); 
		   				   tempFileSize = df.format(fileSize)+"M";
		   			  }
		   			   
	            	  //将附件信息封装到实体UploadFile，待保存到数据库
	            	  UploadFile ufile = new UploadFile();
		   			
		   			  ufile.setCreateTime(DateUtils.getCurrentDate());
		   			  ufile.setCreateUser(Sessions.getSysUser());
		   			
		   			  ufile.setUploadFileName(fileName);
		   			  ufile.setUploadFilePath(uploadPath+"/"+tempFileName);
		   			  if(uploadContentType!=null && uploadContentType.size()>0){
			   			   ufile.setUploadContentType(uploadContentType.get(i));
			   		  }
		   			  ufile.setUploadFileSize(tempFileSize);
		   			  ufile.setOwnerId(ownerId);
		   			 
		   			  uploadFileList.add(ufile);
	               }
	            }   
	      }   
	      return uploadFileList;
      }
	
	/**
	 * 下载附件
	 * @param fileName 附件名
	 * @param fileDownloadPath 附件路径
	 */
	public static void download(String fileName,String fileDownloadPath){
		File file = new File(Servlets.getServletContext().getRealPath("")+"/"+fileDownloadPath); 
		download(file,fileName);
	}
	
	/**
	 * 下载附件
	 * @param file 附件
	 * @param fileName 附件名
	 */
	public static void download(File file,String fileName){
		InputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		download(input, fileName);
	}
	
	/**
	 * 下载附件
	 * @param input 附件流
	 * @param fileName 附件名
	 */
	public static void download(InputStream input,String fileName){
		HttpServletResponse response = Servlets.getResponse();
		response.setCharacterEncoding("GBK");
		response.setHeader("Content-Type","application/octet-stream; charset=GBK");//
		response.setHeader("Content-Disposition","attachment; filename=" + StringEncodeUtils.gbkToIso88591(fileName));
//		response.setContentType("application/pdf");
//		response.setHeader("Content-Disposition", "inline; filename=\"persons.pdf\"");
		OutputStream output = null;
		try {
			output = response.getOutputStream();
			IOUtils.copyLarge(input, output);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(output);
		}
	}
	
	
	/**
	 * 从磁盘上删除附件
	 * @param filePath 附件路径/附件名称
	 * @return
	 */
	public static void deleteFile(String filePath){
		List<String> filePaths = Lists.newArrayList(filePath);
		deleteFile(filePaths);
	}
	
	/**
	 * 从磁盘上删除附件
	 * @param filePaths 附件路径/附件名称的List
	 * @return
	 */
	public static void deleteFile(List<String> filePaths){
		if(filePaths!=null && filePaths.size()>0){
			for(String filePath : filePaths){
				try {
					File file = new File(Servlets.getServletContext().getRealPath("/"+filePath));   
					if(file.exists()){
						 file.delete();
					}else{
						 throw new Exception("附件不存在，路径："+filePath);
					}
				} catch (Exception e) {
					 e.printStackTrace();
				}
			}
		}
	}
}
