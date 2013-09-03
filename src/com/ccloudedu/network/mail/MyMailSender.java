package com.ccloudedu.network.mail;

import java.util.List;

/**
 * 邮件发送器
 * @author wade
 */
public interface MyMailSender{

	/**
	 * 
	 * @param from 发送方邮箱地址
	 * @param to 接收人
	 * @param title 邮件主题
	 * @param ontent 邮件内容
	 * @param filePaths 附件
	 * @return 
	 */
	public String sendMail(String from,String[] to,String title,String content,List<String> filePaths) throws Exception;
}
