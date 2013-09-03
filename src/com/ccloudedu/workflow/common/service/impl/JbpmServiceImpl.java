package com.ccloudedu.workflow.common.service.impl;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.Execution;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.model.ActivityCoordinates;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.workflow.common.service.JbpmService;

/**
 * jbpm 
 * @author wade
 * http://yy629.iteye.com/blog/465637
 * 
 */
@Service
@Transactional
public class JbpmServiceImpl implements JbpmService{
	
	private static final Log log = LogFactory.getLog(JbpmServiceImpl.class);
	
	//@Autowired
	//private ProcessEngine processEngine;  
	@Autowired
	private RepositoryService repositoryService; 
	@Autowired
	private ExecutionService executionService;  
	@Autowired
	private TaskService taskService; 
	
	@Autowired
	@SuppressWarnings("unchecked")
	private BaseHibernateDao baseDao;
	//private HistoryService historyService;  
	//private ManagementService managementService;  
	/** 
	   * 创建一个新的流程实例 
	   *  
	   * @param processDefinitionKey  (process.jpdl.xml中process标签的key) 
	   * @param processInstanceKey (用户给的key，比如一个请假单的id) 
	   * @return 流程实例 
	   */  
	  public ProcessInstance addProcessInstance(String processDefinitionKey,  String processInstanceKey) {  
		  ProcessInstance processInstance  = executionService.startProcessInstanceByKey(processDefinitionKey,  processInstanceKey);
	      return processInstance;  

	  }  
	    
	  /** 
	   * 创建一个新的流程实例 
	   * @param processDefinitionKey(process.jpdl.xml中process标签的key) 
	   * @param variables 该流程实例要用到的变量 
	   * @param processInstanceKey(用户给定的业务key) 
	   * @return 
	   */  
	  public ProcessInstance addProcessInstance(String processDefinitionKey,Map<String, ?> variables,  String processInstanceKey){  
		  ProcessInstance processInstance  =  executionService.startProcessInstanceByKey(processDefinitionKey, variables, processInstanceKey);  
	      return processInstance;
	  }  
	    
	  /** 
	   * 提交任务 
	   * @param taskId 任务id 
	   */  
	  public void completeTask(String taskId){  
	      taskService.completeTask(taskId);  
	  }  
	    
	  public void completeTask(String taskId,String outcome,Map<String, ?> variables){  
	      taskService.completeTask(taskId, outcome,variables);
	  }  
	  /** 
	   * 将任务流转到指定名字的流程中去 
	   * @param taskId 
	   * @param outcome 
	   */  
	  public void completeTask(String taskId,String outcome){  
	      taskService.completeTask(taskId, outcome);
	  } 

	  /** 
	   * 根据key获取流程实例(这里使用的uuid) 
	   *  
	   * @param key (对应于数据库表jbpm4_execution中的KEY_字段) 
	   * @return 返回查找到得流程实例，没有返回null 
	   */  
	  public ProcessInstance getProcessInstance(String key) {  
	      return executionService.createProcessInstanceQuery().processInstanceKey(key).uniqueResult();  
	  }  
	    
	    
	  /** 
	   * 根据executionId获取指定的变量值 
	   * @param executionId 
	   * @param variableName 
	    * @return 
	    */  
	   public Object getVariableByexecutionId(String executionId,String variableName){  
	       return executionService.getVariable(executionId, variableName);  
	   }  
	     
	     
	   /** 
	    * 根据任务id获取指定变量值 
	    * @param taskId 
	    * @param variableName 
	    * @return 
	    */  
	   public Object getVariableByTaskId(String taskId,String variableName){  
	       return taskService.getVariable(taskId, variableName);  
	   }  
	     
	   /** 
	    * 获取指定用户名字的任务 
	    * @param userId 
	    * @return 
	    */  
	   public List<Task> findPersonalTasks(String userId){ 
		   List<Task> tasks = taskService.findPersonalTasks(userId);
	       return tasks;  
	   }  
	   
	   /**
	    * 获得当前流程，指定用户的活动中的任务
	    * @param processInstanceId
	    * @param assignee
	    * @return
	    */
	   @SuppressWarnings("unchecked")
	   public Task findPersonalTasks(String processInstanceId, String assignee) throws Exception{
		   Map<String,String> paramMap = new FastMap().newHashMap()
		   .set("processInstanceId", processInstanceId)
		   .set("assignee", assignee)
		   .set("state", ExecutionImpl.STATE_SUSPENDED);
		  
           List<Task> tasks = baseDao.findList("workflow.findPersonalTasks",paramMap);
           Task task = null;
           if(tasks!=null && tasks.size()==1){
        	   task = tasks.get(0);
           }else if(tasks!=null && tasks.size()>1){
        	   throw new Exception("当前流程、当前用户同时存在多个task，这种情况一般是不可能出现的");
           }else{
        	   throw new Exception("当前流程、当前用户的任务不存在，流程出现了问题");
           }
	       return task;  
	   }
	   /** 
	    * 根据任务id获取任务 
	    * @param taskId 
	    * @return 
	    */  
	   public Task getTask(String taskId) {  
	       return taskService.getTask(taskId);  
	         
	   }  
	     
	   /** 
	    * 根据流程实例id获取 
	    * @param executionId 
	    * @return 
	    */  
	   public Execution findExecutionById(String executionId) {  
	       return executionService.findExecutionById(executionId);  
	   }  
	 
	   /**
	    * 部署流程
	    * @param inputStream 流程定义文件*.jpdl.xml 和 对应的*.png图片打包为*.zip文件
	    * @return
	    */
	    public String deploy(InputStream inputStream){  
	    	ZipInputStream zipInputStream = new ZipInputStream(inputStream);
	        String deployId =repositoryService.createDeployment().addResourcesFromZipInputStream(zipInputStream).deploy();
	        log.info("流程部署成功，流程部署id："+deployId);
	        return deployId;
	    }  
	    
	    /**删除流程定义 及其相关数据 
	     * @param deployId 
	     */  
	    public void deleteDeployment(String deployId){
	    	repositoryService.deleteDeploymentCascade(deployId);  
	    }  
	    
	    /**
	     * 获取当前节点位置 
	     * @param piId
	     * @return
	     */
	    public ActivityCoordinates getActivityCoordinates(String piId){  
	    	ProcessInstance pi = getInstanceById(piId);
	        return repositoryService.getActivityCoordinates(pi.getProcessDefinitionId(),pi.findActiveActivityNames().iterator().next());  
	    }  
	    
	    /**
	     * 获取流程图片流  
	     */
	    public byte[] getPicStream(String definitionId) throws IOException{  
	    	ProcessDefinition pd = getDefinitionByPiId(definitionId);
	        InputStream imageInpustStream =repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getImageResourceName());  
	        byte imgdata[] =IOUtils.toByteArray(imageInpustStream);
	        return imgdata;
	    }  
	
	    /**获取流程定义 
	     * @return 
	     */  
	    public List<ProcessDefinition> getDefinition(){  
	        return repositoryService.createProcessDefinitionQuery().list();  
	    }  
	    
	    /**获取流程定义 
	     * @return 
	     */  
	    public ProcessDefinition getDefinitionByPiId(String id){  
	        return repositoryService.createProcessDefinitionQuery().processDefinitionId(id).uniqueResult();  
	    }  
	    
	    /**
	     * 触发流程流转
	     * @param processInstance
	     * @param activityName
	     * @param parameters
	     * @return
	     */
	    public void signalExecution(ProcessInstance processInstance,String activityName,Map<String,Object> parameters){
	    	Execution execution = processInstance.findActiveExecutionIn(activityName);
	    	executionService.signalExecutionById(execution.getId(), parameters);
	    }
	    
	    /**获取流程实例 
	     * @return 
	     */  
	    public List<ProcessInstance> getInstance(){  
	        return executionService.createProcessInstanceQuery().list();  
	    } 
	    
	    /**获取流程实例 
	     * @return 
	     */  
	    public ProcessInstance getInstanceById(String id){  
	        return executionService.findProcessInstanceById(id);  
	    }
}
