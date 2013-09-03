package com.ccloudedu.base.web.struts2.interceptor;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.ccloudedu.base.annotation.LoginValidation;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.system.entity.SysUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录检查拦截器
 * @author wade
 * 2009-03-21
 */
public class LoginInterceptor extends AbstractInterceptor {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {  
  
        HttpServletRequest request= Servlets.getRequest();
        SysUser sysUser = Sessions.getSysUser();
        
        String methodName = invocation.getProxy().getMethod();
  	    Method method = invocation.getAction().getClass().getMethod(methodName);
  	  
        LoginValidation loginValidation = method.getAnnotation(LoginValidation.class);
        
        if(loginValidation==null || loginValidation.validate()==YN.Y){
            //如果用户已经登录
            if (sysUser!= null && StringUtils.isNotEmpty(sysUser.getId())){ 
            	 HttpSession session = request.getSession();
            	 String mySessionId = session.getId();
            	 String userId = sysUser.getId();
            	 Date myLoginTime = DateUtils.parseDate(sysUser.getLoginTime(), DateUtils.DATE_TIME_FORMAT);
        		 
     	        //查询登录规则
    	        //SysRuleSetting loginRuleSetting = LoginRuleSettingService.findOne("login");
    	       	 //同一个账号不可重复登录
            	 Map<String, YN> ruleSettingMap = (Map<String, YN>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.SYS_RULE_SETTING_KEY);
    	       	 if(ruleSettingMap.get("login")==YN.N){
    	       		 Map<String,SysUser> onlineUserMap = (Map<String, SysUser>) EhCacheManager.getAll(CacheConstants.HTTP_SESSION_CACHE);
    	       		 if(onlineUserMap!=null && onlineUserMap.size()>0){
    	       			  Map<String,String> sessionMap = new HashMap<String,String>();
    	       			  for(String sessionId : onlineUserMap.keySet()){
    	       				  sysUser = onlineUserMap.get(sessionId);
    	       				  if(userId.equals(sysUser.getId())){
    	       					  sessionMap.put(sessionId, sysUser.getLoginTime());
    	       				  }
    	       			  }
    	       			  if(sessionMap.size()>=2){//同一个账号登录了多次，
    	       				 for(String sessionId : sessionMap.keySet()){
    	       					 if(!sessionId.equals(mySessionId)){
    	       						Date loginTime = DateUtils.parseDate(sessionMap.get(sessionId), DateUtils.DATE_TIME_FORMAT);//1,2,1
    	       						if(myLoginTime!=null && loginTime!=null){
    	       							if(myLoginTime.getTime()>=loginTime.getTime()){
           		       						 return invocation.invoke();   
           		       					 }else{//先登录的用户，清除session
           		       						  session.removeAttribute(Constants.USER_SESSION_KEY);   
           		       			              session.invalidate();
           		       			              
           		       			              request.setAttribute("logout", "repeatlogin");
           		       			              return "sessionTimeout";
           		       					 }
    	       						}
    	       					 }
    		       			 }
    	       			  }
    	       		 }
    	       	 }

            	//继续下面的拦截器
                return invocation.invoke();   
            }else{
            	request.setAttribute("logout", "timeout");
        		return "sessionTimeout";
            }
        }else{
        	//继续下面的拦截器
            return invocation.invoke();   
        }
    }   
}
