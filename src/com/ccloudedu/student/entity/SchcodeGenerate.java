package com.ccloudedu.student.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SchcodeGenerate {
	public static void main(String[] args) {
		String no=generate("000017","003");
		System.out.println("流水号"+'\n'+no);

	}
	
	public static String generateSchroll(String no){
		SimpleDateFormat format= new SimpleDateFormat("yyyyMMdd");
		String date=format.format(new Date()); 
		String lastNo=date+no; 
		String temp=lastNo.substring(lastNo.length()-3, lastNo.length());
	
		if(Integer.parseInt(temp)>=1&&Integer.parseInt(temp)<999){
			temp=String.valueOf(Integer.parseInt(temp)+1);
		}
		switch (temp.length()) {
		case 1:
			temp="00"+temp;
			break;
		case 2:
			temp="0"+temp;
			break;
		default:
			break;
		}
		lastNo=date+temp;
	return lastNo;
}
	

	public static String generate(String staticstr,String from){
			String lastNo=staticstr+from;
			String temp=lastNo.substring(lastNo.length()-3, lastNo.length());
		
			if(Integer.parseInt(temp)>=1&&Integer.parseInt(temp)<999){
				temp=String.valueOf(Integer.parseInt(temp)+1);
			}
			switch (temp.length()) {
			case 1:
				temp="00"+temp;
				break;
			case 2:
				temp="0"+temp;
				break;
			default:
				break;
			}
			lastNo=staticstr+temp;
		return lastNo;
	}
	
	public static String generate(String from){
		String lastNo=from;
		String temp=lastNo.substring(lastNo.length()-3, lastNo.length());
	
		if(Integer.parseInt(temp)>=1&&Integer.parseInt(temp)<999){
			temp=String.valueOf(Integer.parseInt(temp)+1);
		}
		switch (temp.length()) {
		case 1:
			temp="00"+temp;
			break;
		case 2:
			temp="0"+temp;
			break;
		default:
			break;
		}
		lastNo=temp;
	return lastNo;
}
}
