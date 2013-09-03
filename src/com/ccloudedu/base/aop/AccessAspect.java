package com.ccloudedu.base.aop;

 
import java.lang.reflect.Method; 
import java.util.Map; 
import javax.servlet.ServletContext; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature; 
import org.springframework.stereotype.Component; 

import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.web.Servlets;
 

/**
 * service层用户访问日志记录 aspect
 * 
 * @author wade
 */
@Component
@Aspect
public class AccessAspect {

	// 记录日志文件到${catalina.base}/logs/ccloudedu/AccessRecordFile.log
	private static Log log = LogFactory.getLog("accessRecordLog");  

	// ProceedingJoinPoint is only supported for around advice
	@SuppressWarnings("unchecked")
	@Around("execution(* com.ccloudedu..service.impl.*.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		ServletContext sc = null;
		try {
			sc = Servlets.getServletContext();
		} catch (Exception e) {
			// sc==null，是启动服务器时，这时spring还没有加载struts2
		}
		if (sc != null) {
			Map<String, YN> ruleSettingMap = (Map<String, YN>) EhCacheManager
					.get(CacheConstants.CONSTANTS_DATE_CACHE,
							CacheConstants.SYS_RULE_SETTING_KEY);
			if (ruleSettingMap.get("accessLog") == YN.Y) {
				Class<?> className = jp.getTarget().getClass();
				// 当前访问的方法名
				String methodName = jp.getSignature().getName();
				// 通过反射获得拦截的method
				Method method = className.getMethod(methodName,
						((MethodSignature) jp.getSignature()).getMethod()
								.getParameterTypes());
				log.info("service method:"
						+ (className + "." + method.getName()).substring(6));
			}
		}
		Object result = jp.proceed();// 继续下面,result 是被拦截方法的返回值
		return result;// 返回其他，不继续下面
	}

	
}
