package com.ccloudedu.base.constants.enums;
/**
 * @author wade
 */
public enum YN {
	Y("是"),
	N("否");
	
	private String desc; 

	YN(String desc){
	   this.desc = desc;
    }
	public String getDesc(){
	   return this.desc;
	}
}
