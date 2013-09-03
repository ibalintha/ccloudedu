package com.ccloudedu.base.web.struts2.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.struts2.action.BaseAuthAction;
import com.ccloudedu.system.entity.SysUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 记录用户访问的action及参数，到日志文件
 * @author wade
 */
public class ActionAccessLogInterceptor extends AbstractInterceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//记录日志文件到${catalina.base}/logs/ccloudedu/AccessRecordFile.log
	private static Log log = LogFactory.getLog("accessRecordLog");
	
	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		 Object action = invocation.getAction();
		 Map<String, YN> ruleSettingMap = (Map<String, YN>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.SYS_RULE_SETTING_KEY);
		 if(Sessions.getSysUser()!=null && action instanceof BaseAuthAction && ruleSettingMap.get("accessLog")==YN.Y){
	    	 SysUser user = Sessions.getSysUser();
	    	 Class<?> actionClass = action.getClass();
	    	 String methodName = invocation.getProxy().getMethod();
		     Method method = actionClass.getMethod(methodName);
		     log.info("本次请求访问的方法有：");
		     log.info("ip:"+Servlets.getClientIp()+",user:"+user.getUserName()+"|"+user.getId());
		     log.info("action:"+(actionClass+"."+method.getName()).substring(6));
		     Map<String,Object> params = (Map<String, Object>) Servlets.getParameters("page");
		     if(params!=null && params.size()>0){
		    	 log.info("parameter："+params.toString());
		     }
		     
		     String result = invocation.invoke();
		     
		     log.info("本次请求结束\n");
		    
		     return result;
	     }
	    
	     return invocation.invoke();
	}
}
