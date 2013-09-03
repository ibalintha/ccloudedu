package com.ccloudedu.oa.msg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;
import com.ccloudedu.system.entity.SysUser;
/**
 * 简易留言板
 * @author wade
 */
@Entity
@Table(name = "OA_MESSAGE_BOARD")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OaMessageBoard extends IDEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysUser messager;
	private String userName;
	private String email;
	private String telephone;
	private String qq;
	private String messageContent;
	private String createTime;
	
	public OaMessageBoard(){
		
	}
    public OaMessageBoard(String id){
		super(id);
	}
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public SysUser getMessager() {
		return messager;
	}
	public void setMessager(SysUser messager) {
		this.messager = messager;
	}
	
	@Column(name = "USER_NAME", length = 10)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "EMAIL", length = 32)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "TELEPHONE", length = 11)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(name = "QQ", length = 20)
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Lob
	@Column(name = "MESSAGE_CONTENT")
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	@Column(name = "CREATE_TIME", length = 20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
