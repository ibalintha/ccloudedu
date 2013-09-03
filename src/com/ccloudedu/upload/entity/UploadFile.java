package com.ccloudedu.upload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
import com.ccloudedu.system.entity.SysUser;

@Entity
@Table(name = "UPLOAD_FILE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class UploadFile extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uploadFileName;
	private String uploadContentType;
	private String uploadFileSize;
	private String uploadFilePath;
	private String ownerId;//关联id
	
	public UploadFile() {
	}

	public UploadFile(String id) {
		super(id);
	}

	public UploadFile(String id,SysUser sysUser, String createTime,
			String uploadFileName,String uploadContentType,
			String uploadFileSize,String uploadFilePath,String ownerId) {
		super(id,sysUser,createTime);
		this.uploadFileName = uploadFileName;
		this.uploadContentType = uploadContentType;
		this.uploadFileSize = uploadFileSize;
		this.uploadFilePath = uploadFilePath;
		this.ownerId = ownerId;
	}

	@Column(name = "UPLOAD_FILE_NAME", length = 128)
	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Column(name = "UPLOAD_CONTENT_TYPE", length = 100)
	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	@Column(name = "UPLOAD_FILE_SIZE", length = 32)
	public String getUploadFileSize() {
		return uploadFileSize;
	}

	public void setUploadFileSize(String uploadFileSize) {
		this.uploadFileSize = uploadFileSize;
	}

	@Column(name = "UPLOAD_FILE_PATH", length = 128)
	public String getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	@Column(name = "OWNER_ID", length = 32)
	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
}
