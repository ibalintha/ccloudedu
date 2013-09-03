package com.ccloudedu.system.entity;
 

 
public class SysAccessLogFile   implements java.io.Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private String fileName;  
	private String createTime;
	
	public SysAccessLogFile() {
	}
	 
	public SysAccessLogFile(String fileName, String createTime) {
		this.fileName = fileName; 
		this.createTime = createTime;
	} 
	 
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
