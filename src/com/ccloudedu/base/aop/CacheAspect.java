package com.ccloudedu.base.aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.dao.utils.QueryParser;
import com.ccloudedu.base.dao.utils.builder.SqlBuilder;
import com.ccloudedu.base.entity.IDEntity;
import com.ccloudedu.base.entity.Page;
import com.google.common.collect.Lists;

/**
 * dao层缓存aspect
 * 此aop适用于：
 * 1、使用sql方式查询，并将结果集放入缓存
 * 2、使用hibernate进行增、删、改，并清除对应的缓存
 * 3、在某些情况下，可能会无法清除缓存，这时更加关键字手工清除下
 * 
 * 如果：
 * 1、使用sql的方式进行增、删、改，将无法同步缓存
 * 2、hibernate dao中，新增、修改、删除数据时，传递的数据不是实体对象，也将无法同步缓存
 * 
 * 由于：
 * 整个架构只有一个dao，所以上面的问题2一般不会出现
 * 而对于问题1，不建议采用sql的方式，进行增、删、改操作
 * 
 * 哎，缓存sql方式查询结果集，还有其他问题，目前建议还是都采用hql方式查询，不要用sql方式查询了
 * 或者sql查询结果不缓存。
 * 
 * @author wade
 */
@Component
@Aspect
public class CacheAspect {
	
	private final static Log log = LogFactory.getLog(CacheAspect.class);
	//@Autowired
	//private EhCacheManager cacheManager;
    
    //缓存标签
	@Pointcut("execution(* com.ccloudedu..dao.hibernate.impl.*.*(..))")
    private void hibernateCache(){}
	
	@Pointcut("execution(* com.ccloudedu..dao.dbutils.impl.*.*(..))")
    private void dbutilsCache(){}
    
	@Before("hibernateCache()")
	public void removeFromCache(JoinPoint jp){
		//BaseHibernateDaoImpl中的方法名称，当前访问的方法是下面的方法时，清除缓存
		List<String> methods = Lists.newArrayList("save","update","saveOrUpdate","delete","batchUpdateOrDelete");
		String methodName = jp.getSignature().getName(); 
		if(methods.contains(methodName)){
			Object[] argValues = jp.getArgs(); 
			if(argValues!=null && argValues.length>0){
	    		for(int i=0;i<argValues.length;i++){
	    			if(argValues[i] instanceof IDEntity){
	    				IDEntity entity = (IDEntity) argValues[i];
	    				Table table = entity.getClass().getAnnotation(Table.class);
	    				String tableName = table.name().toLowerCase();
	    				//根据表名清除缓存
	    				EhCacheManager.remove("dbutilsCache",tableName);
	    			}
	    		}
	    	}
		}
	}
	
    @SuppressWarnings("unchecked")
	@Around("dbutilsCache()")
    public Object putToCache(ProceedingJoinPoint jp) throws Throwable{
        Class<?> className = jp.getTarget().getClass();
    	String methodName = jp.getSignature().getName(); 
    	Object[] argValues = jp.getArgs();  
	    //Class[] argClazzs = ((MethodSignature)jp.getSignature()).getMethod().getParameterTypes();
    	String values = "";
    	Map<String,?> paramMap = null;
    	String queryName = "";
    	String keyPropertyName = "";
    	if(argValues!=null && argValues.length>0){
    		for(int i=0;i<argValues.length;i++){
    			if(argValues[i] instanceof Class){//实体参数
    				Class clazz = (Class) argValues[i];
    				values += clazz.toString();
    			}else if(argValues[i] instanceof SqlBuilder){//SqlBuilder参数
    				SqlBuilder sqlBuilder = (SqlBuilder) argValues[i];
    				values += sqlBuilder.getQuerySql()+"_"+sqlBuilder.getValues().toString();
    			}else if(argValues[i] instanceof Object[]){//数组参数
    				Object[] objs = (Object[]) argValues[i];
    				values += Arrays.asList(objs).toString();
    			}else if(argValues[i] instanceof Collection){//集合参数
    				values += ((Collection)argValues[i]).toString();
    			}else if(argValues[i] instanceof Page){//分页参数
    				Page page =  (Page) argValues[i];
    				values += (page.getCurrentPage()+page.getPageSize()+page.getOrderattr()+page.getOrdertype());
    			}else if(argValues[i] instanceof Map){//Map参数
    				paramMap = (Map) argValues[i];
    				for(Object o : paramMap.keySet()){
    					values += (o+"_"+paramMap.get(o));
    				}
    			}else if(argValues[i] instanceof String){//String 参数
    				//是String时，可能有2种情况：1、queryName，2：返回Map时的key
    				if(StringUtils.isBlank(queryName)){
    					queryName = argValues[i].toString();
    				}
    				if(StringUtils.isBlank(keyPropertyName)){
    					keyPropertyName = argValues[i].toString();
    				}
    				values += argValues[i];
    			}else{
    				values += argValues[i];
    			}
    		}
    	}
    	
    	//获得所有的表名
    	List<String> tableNameList = new ArrayList<String>();
    	if(StringUtils.isNotBlank(queryName)){
    		String sql = QueryParser.getQueryString(queryName, paramMap);
    		if(StringUtils.isNotBlank(sql)){
    			sql = sql.toLowerCase();
    			//获得sql中的所有表名 from tableName1 join tableName2 union tableName3
    	    	String fm = "(from)\\s*\\w+";
    	    	Pattern p = Pattern.compile(fm);
    	    	Matcher matcher = p.matcher(sql);  
    	    	while (matcher.find()) {
    	    		tableNameList.add(matcher.group().replace("from", "").trim());
    	        }
    	    	
    	    	matcher = Pattern.compile("(join)\\s*\\w+").matcher(sql);  
    	    	while (matcher.find()) {
    	    		tableNameList.add(matcher.group().replace("join", "").trim());
    	        }
    	    	
    	    	matcher = Pattern.compile("(union)\\s*\\w+").matcher(sql);  
    	    	while (matcher.find()) {
    	    		tableNameList.add(matcher.group().replace("union","").trim());
    	        }
    		}
    	}
    	
        String key = tableNameList.toString()+"_"+className+"_"+methodName+"_"+values;
           
        Object object = EhCacheManager.get("dbutilsCache",key);   
  
        if (object == null) {   
        	 log.info("put to cache,the key:"+key);
             object = jp.proceed();   
             EhCacheManager.put("dbutilsCache",key, object);
             
             return object;
        }   
        log.info("get from cache,the key:"+key);
        return object;   
    }

}
