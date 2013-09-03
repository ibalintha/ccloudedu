<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
	<script type="text/javascript">
		var list=true;
		function showPic(process_instance_id,process_definition_id){
			var url = "${ctx }/workflow/deploy_showWorkFlowPic.do?processInstanceId="+process_instance_id+"&processDefinitionId="+process_definition_id;
			$.dialog({
				title:'查看流程图',
				content: 'url:'+url,
			    cancelVal: '关闭',
			    cancel: true ,
			    width: '700px',
			    height: 500
			});
		}
		function audit(id,processInstanceId){
			var param = "id="+id+"&processInstanceId="+processInstanceId;
			$.dialog({id:'dialog',title:'审核请假单',content: 'url:${ctx }/workflow/leave_detailAudit.do?'+param,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		function reloadList(){
			window.location.href="${ctx }/workflow/leave_listAudit.do";
		}
	</script>
</my:head>
<body>
<div class="bodybox">
	   <div class="phead">
			<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 流程管理 - 请假流程 - 审核请假单</div>
			<div class="clear"></div>
			</div>
		   <form action="workflow/leave_listAudit.do" method="post" id="leaveForm">
		           <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                  	<th width="4%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th>请假人</th>
			                    <th>请假类型<my:order orderattr="lea.leave_type"/></th>
			                	<th>请假时间<my:order orderattr="lea.leave_time"/></th>
			                	<th>到岗时间<my:order orderattr="lea.leave_end_time"/></th>
			                	<th>请假天数（天）<my:order orderattr="lea.leave_day_number"/></th>
			                	<th>请假原因<my:order orderattr="lea.leave_content"/></th>
			                	<%--
			                	<th>当前执行人</th>
			                	<th>审核状态</th>
			                	 --%>
			                	<th><my:i18n zhText="操作" enText="Action"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="8"><font color="red">当前没有待审核请假单</font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="lea" varStatus="status">
								<tr id="${lea.id }">
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td>${lea.leave_user_name}</td>
									<td><my:view value="${lea.leave_type}" pvalue="leave"/></td>
									<td>${lea.leave_time}</td>
									<td>${lea.leave_end_time}</td>
									<td>${lea.leave_day_number}</td>
									<td>${lea.leave_content}</td>
									<%--
									<td>${lea.task_user_name}</td>
									<td>${lea.task_name}</td>
									 --%>
									<td align="center">
									   <a href="#" onclick="audit('${lea.id}','${lea.process_instance_id}');">审核</a>
									   <a style="cursor: pointer;" onclick="showPic('${lea.process_instance_id}','${lea.process_definition_id}')">查看流程图</a>	
									   <!-- 
									   <a href="${ctx }/workflow/leave_update.do"><my:i18n zhText="编辑" enText="Edit"/></a>	
									   <a href="javascript:" title="deletesigle" onclick="deleteOne('${id}')"><my:i18n zhText="删除" enText="Delete"/></a>	
									    -->
									</td>
								</tr>
			             </c:forEach>
			            </tbody>
		         </table>
		          <div class="ltablebottom">
			       <div class="lpage"><my:page page="${page}"/></div>  
			  </div>
	       </form>
</div>
</body>
</html>