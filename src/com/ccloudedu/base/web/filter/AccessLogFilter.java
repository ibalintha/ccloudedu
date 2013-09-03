package com.ccloudedu.base.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.system.entity.SysUser;

public class AccessLogFilter implements Filter {
	
	//记录日志文件到${catalina.base}/logs/ccloudedu/AccessRecordFile.log
	private static Log log = LogFactory.getLog("accessRecordLog");
	
	public void destroy() {
	
	}
	
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest)arg0;
		 HttpServletResponse response = (HttpServletResponse)arg1;
		 
		 SysUser user = (SysUser) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		 
		 if(user!=null){
			 Map<String, YN> ruleSettingMap = (Map<String, YN>) EhCacheManager.get(CacheConstants.CONSTANTS_DATE_CACHE, CacheConstants.SYS_RULE_SETTING_KEY);
			 if(ruleSettingMap.get("accessLog")==YN.Y){
				 log.info("本次请求访问的方法有：");
			     try {
					//log.info("ip:"+Servlets.getClientIp()+",user:"+user.getUserName()+"|"+user.getId());
					log.info(("action:"+request.getRequestURI()));
				    log.info("parameter："+Servlets.getParameters().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			     
			     arg2.doFilter(request, response); 
				    
			     log.info("本次请求结束\n");
			 }
		 }
		 
        
		  arg2.doFilter(request, response); 
	     
	}
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}

