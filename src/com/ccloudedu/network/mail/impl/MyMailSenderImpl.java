package com.ccloudedu.network.mail.impl;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.network.mail.MyMailSender;
import com.ccloudedu.system.entity.SysMailServerSetting;
import com.ccloudedu.system.service.MailServerSettingService;
/**
 * 我的邮件发送器
 * @author wade
 */
@Service
public class MyMailSenderImpl implements MyMailSender {
	
	@Autowired
	private MailServerSettingService mailServerSettingService;
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public String sendMail(String from,String[] to,String title,String content,List<String> filePaths) throws Exception{
		
		 SysMailServerSetting mailServerSetting = mailServerSettingService.findOne("system.findMailServerSettings",null);
		 MimeMessage mime = mailSender.createMimeMessage();   
		 MimeMessageHelper helper;   
		   
		 try {   
			  Properties javaMailProperties = new Properties();
			  
			  String protocol = mailServerSetting.getProtocol();
			  String host = mailServerSetting.getHost();
			  
			  mailSender.setProtocol(protocol);
			  mailSender.setHost(checkHost(protocol, host));
			  mailSender.setPort(mailServerSetting.getPort());
			  mailSender.setUsername(mailServerSetting.getUsername());
			  mailSender.setPassword(mailServerSetting.getPassword());
			  
			  if("smtp".equals(protocol.toLowerCase())){
				  javaMailProperties.put("mail.smtp.auth", true);
				  //ssl加密
				  if(mailServerSetting.getSslYn()==YN.Y){
					  javaMailProperties.put("mail.smtp.starttls.enable", true);
					  javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				  }
			  }else if("pop3".equals(protocol.toLowerCase())){
				  
			  }
			  mailSender.setJavaMailProperties(javaMailProperties);
			  
		      helper = new MimeMessageHelper(mime,true,"UTF-8");  
		      //发件人
		      helper.setFrom(from);
		      //收件人
		      helper.setTo(to);
		      //标题
		      helper.setSubject(title); 
		      //正文
		      helper.setText(content,true);  
		      //附件
		      if(filePaths!=null && filePaths.size()>0){
		       for(String filePath : filePaths){
		        String[] arr = filePath.split("/");
		        String fileName = arr[arr.length-1];
		        helper.addAttachment(fileName, new File(filePath));
		       }
		      }
		   } catch (MessagingException e) {   
		       e.printStackTrace();   
		   }   
		          
		   //发送
		   mailSender.send(mime); 
		   
		   System.out.println("mail send success...");
		
		return "0";//0:success,1:fail
	}
	
	/**
	 * 检查是ip还是域名
	 * @param host
	 * @return
	 */
	private String checkHost(String protocol,String host){
		
		String ret = "";
		//域名后缀，这里写了一部分
		String reg = ".com|.cn|.org|.net|.hk|.tv|.mobi|.cc";
		
		if(host.indexOf(reg)==-1){//ip
			ret = host;
		}else{//域名
			ret = protocol+"."+host;
		}
		return ret;
	}
}
