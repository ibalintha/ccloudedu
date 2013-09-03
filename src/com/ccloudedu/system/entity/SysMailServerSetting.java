package com.ccloudedu.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.entity.IDEntity;

/**
 * 邮箱服务器规则设置
 * @author wade
 */
@Entity
@Table(name = "SYS_MAIL_SERVER_SETTING")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SysMailServerSetting extends IDEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String protocol;  
	private String host;
	private int port;
	private String username; 
	private String password;
	private YN sslYn;//是否ssl加密 Y:加密，N：不加密
	
	@Column(name = "protocol", length = 10)
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	@Column(name = "host", length = 20)
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	@Column(name = "port")
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	@Column(name = "username", length = 20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password", length = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "ssl_yn", length = 10)
	@Enumerated(EnumType.STRING)
	public YN getSslYn() {
		return sslYn;
	}
	public void setSslYn(YN sslYn) {
		this.sslYn = sslYn;
	}
}
