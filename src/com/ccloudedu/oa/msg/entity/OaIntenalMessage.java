package com.ccloudedu.oa.msg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;
import com.ccloudedu.system.entity.SysUser;

@Entity
@Table(name = "OA_INTENAL_MESSAGE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaIntenalMessage extends BaseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msgTitle;
	private String msgContent;
	private String sendTime;
	private String readTime;
	private String isRead;
	private String isDelete;
	private SysUser sender;
	private SysUser receiver;
	
	public OaIntenalMessage() {
	}

	public OaIntenalMessage(String id) {
		super(id);
	}

	public OaIntenalMessage(String id,SysUser sysUser, String createTime,
			String uploadFileInfo,
			String msgTitle,String msgContent,String sendTime,String readTime,String isRead,SysUser sender,SysUser receiver) {
		super(id,sysUser,createTime);
		this.msgTitle = msgTitle;
		this.msgContent = msgContent;
		this.sendTime = sendTime;
		this.readTime = readTime;
		this.isRead = isRead;
		this.sender = sender;
		this.receiver = receiver;
	}

	@Lob
	@Column(name = "MSG_CONTENT")
	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	@Column(name = "MSG_TITLE", length = 256)
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	@Column(name = "SEND_TIME", length = 20)
	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "READ_TIME", length = 20)
	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}
	
	@Column(name = "IS_READ", length = 1)
	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	@Column(name = "IS_DELETE", length = 1)
	public String getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SENDER_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public SysUser getSender() {
		return sender;
	}

	public void setSender(SysUser sender) {
		this.sender = sender;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECEIVER_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public SysUser getReceiver() {
		return receiver;
	}

	public void setReceiver(SysUser receiver) {
		this.receiver = receiver;
	}
    
	@Transient
	public String getTempIsRead(){
		if("0".equals(getIsRead())){
			return "未阅读";
		}
		return "已阅读";
	}
}
