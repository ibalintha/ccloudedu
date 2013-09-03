package com.ccloudedu.workflow.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.jbpm.api.Execution;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.model.ActivityCoordinates;
import org.jbpm.api.task.Task;

public interface JbpmService {
	/** 
	   * 创建一个新的流程实例 
	   *  
	   * @param processDefinitionKey  (process.jpdl.xml中process标签的key) 
	   * @param processInstanceKey (用户给的key，比如一个请假单的id) 
	   * @return 流程实例 
	   */  
	  public ProcessInstance addProcessInstance(String processDefinitionKey,  String processInstanceKey) ;
	    
	  /** 
	   * 创建一个新的流程实例 
	   * @param processDefinitionKey(process.jpdl.xml中process标签的key) 
	   * @param variables 该流程实例要用到的变量 
	   * @param processInstanceKey(用户给定的业务key) 
	   * @return 
	   */  
	  public ProcessInstance addProcessInstance(String processDefinitionKey,Map<String, ?> variables,  String processInstanceKey);
	    
	  /** 
	   * 提交任务 
	   * @param taskId 任务id 
	   */  
	  public void completeTask(String taskId);
	    
	  /** 
	   * 将任务流转到指定名字的流程中去 
	   * @param taskId 
	   * @param outcome 
	   */  
	  public void completeTask(String taskId,String outcome);

	  public void completeTask(String taskId,String outcome,Map<String, ?> variables);
	  /** 
	   * 根据key获取流程实例(这里我使用的uuid) 
	   *  
	   * @param key 
	   *            (对应于数据库表jbpm4_execution中的KEY_字段) 
	   * @return 返回查找到得流程实例，没有返回null 
	   */  
	  public ProcessInstance getProcessInstance(String key);
	    
	    
	  /** 
	   * 根据executionId获取指定的变量值 
	   * @param executionId 
	   * @param variableName 
	    * @return 
	    */  
	   public Object getVariableByexecutionId(String executionId,String variableName);
	     
	     
	   /** 
	    * 根据任务id获取指定变量值 
	    * @param taskId 
	    * @param variableName 
	    * @return 
	    */  
	   public Object getVariableByTaskId(String taskId,String variableName);
	     
	   /** 
	    * 获取指定用户名字的任务 
	    * @param userId 
	    * @return 
	    */  
	   public List<Task> findPersonalTasks(String userId);
	     
	   /** 
	    * 根据任务id获取任务 
	    * @param taskId 
	    * @return 
	    */  
	   public Task getTask(String taskId) ;
	     
	   /** 
	    * 根据流程实例id获取 
	    * @param executionId 
	    * @return 
	    */  
	   public Execution findExecutionById(String executionId);
	 
	   /**
	    * 部署流程
	    * @param inputStream 流程定义文件*.jpdl.xml 和 对应的*.png图片打包为*.zip文件
	    * @return
	    */
	    public String deploy(InputStream inputStream);
	    
	    /**删除流程定义 及其相关数据 
	     * @param deployId 
	     */  
	    public void deleteDeployment(String deployId);
	    
	    /**
	     * 获取当前节点位置 
	     * @param piId
	     * @return
	     */
	    public ActivityCoordinates getActivityCoordinates(String piId);
	    
	    /**获取流程图片流 
	     * @param userId 
	     * @return 
	     * @throws IOException 
	     */  
	    public byte[] getPicStream(String id) throws IOException;
	
	    /**获取流程定义 
	     * @return 
	     */  
	    public List<ProcessDefinition> getDefinition();
	    
	    /**获取流程定义 
	     * @return 
	     */  
	    public ProcessDefinition getDefinitionByPiId(String id);
	    
	    /**
	     * 触发流程流转
	     * @param processInstance
	     * @param activityName
	     * @param parameters
	     * @return
	     */
	    public void signalExecution(ProcessInstance processInstance,String activityName,Map<String,Object> parameters);
	    
	    /**获取流程实例 
	     * @return 
	     */  
	    public List<ProcessInstance> getInstance();
	    /**获取流程实例 
	     * @return 
	     */  
	    public ProcessInstance getInstanceById(String id);

	    /**
	     * 获得当前流程，指定用户的活动中的任务
	     * @param processInstanceId
	     * @param assignee
	     * @return
	     */
		public Task findPersonalTasks(String processInstanceId, String assignee) throws Exception;
	    
}
