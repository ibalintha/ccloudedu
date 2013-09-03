package com.ccloudedu.base.web.render;

import java.util.Collection;

/**
 * js插件 easyui渲染json数据，server返回json时，contentType需为text/html，否则将提示下载内容
 * @author wade
 */
public class EasyUiResult extends JsonResult {

    public EasyUiResult(){
	     super();
    }
   
    public EasyUiResult(Object msg){
    	 super(msg);
    }
    public EasyUiResult(String code,Object msg){
	     super(code,msg);
    }
    public EasyUiResult(String code,Collection<?> msgs){
   	     super(code,msgs);
   }
   public EasyUiResult(String code,Object msg,Collection<?> msgs){
   	     super(code,msg,msgs);
   }


}
