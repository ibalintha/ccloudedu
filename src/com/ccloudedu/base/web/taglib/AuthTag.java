package com.ccloudedu.base.web.taglib;

import java.util.Arrays;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * 自定义权限标签
 * @author wade
 */
public class AuthTag extends BodyTagSupport{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//封装属性  
    private String fixedValue=""; //常量值，多个值时用,分割 
    private String value="";//值，多个值时用,分割
      
    public int doStartTag(){  
       boolean auth = false;
       try{
    	   fixedValue = ExpressionEvaluatorManager.evaluate(fixedValue+"", fixedValue.toString(), Object.class, this, pageContext).toString();
    	   value = ExpressionEvaluatorManager.evaluate(value+"", value.toString(), Object.class, this, pageContext).toString();
    	   String[] fixedValues = fixedValue.split(",");
    	   String[] values = value.split(",");
    	   
    	   //如果values是fixedValues的子集
    	   if(Arrays.asList(fixedValues).containsAll(Arrays.asList(values))){
    		   auth = true;
    	   }
    	   
	   }catch (JspException e) {
		   e.printStackTrace();
	   }
	   if(auth){//具有权限
            return EVAL_BODY_INCLUDE;  
        }  
        return Tag.SKIP_BODY;  
    }

	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static void main(String[] a){
		 String[] fixedValues = {"2","d","b","c"};
  	   String[] values = {"c"};
  	   if(Arrays.asList(fixedValues).containsAll(Arrays.asList(values))){
  		 System.out.println("aaaaaaaaaaaaaaaaaaa");
  	   }
	}
}
