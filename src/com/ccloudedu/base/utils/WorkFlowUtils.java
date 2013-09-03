package com.ccloudedu.base.utils;

import java.util.ArrayList;
import java.util.List;

import com.ccloudedu.workflow.common.entity.WfExecutor;
/**
 * 创建该类的原因，是因为没有找到更好的方法
 * @author wade
 */
public class WorkFlowUtils {

	/**
	 * 根据条件过滤流程执行人
	 * @param decisions 条件
	 * @param allWfExecutors 
	 * @return
	 */
	public static List<WfExecutor> filterNextExecutors(List<String> decisions,List<WfExecutor> allWfExecutors){
		
		List<WfExecutor> wfExecutorlist = new ArrayList<WfExecutor>();
		
		if((decisions!=null && decisions.size()>0) && (allWfExecutors!=null && allWfExecutors.size()>=2)){
			for(WfExecutor wfExecutor : allWfExecutors){
				for(String decision : decisions){
					if(decision.equals(wfExecutor.getTransition())){
						wfExecutorlist.add(wfExecutor);
					}
				}
			}
		}else{
			wfExecutorlist = allWfExecutors;
		}
		return wfExecutorlist;
	}
}
