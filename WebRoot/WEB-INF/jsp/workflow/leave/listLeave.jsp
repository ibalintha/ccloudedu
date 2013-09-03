<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
	<script type="text/javascript">
		var list=true;
		$(function() {
		   // $("#addnewButton").click(function(){window.location.href="${ctx}/workflow/leave_add.do";});
		    $("#addnewButton").click(function(){
				$.dialog({id:'dialog',title:'填写请假单申请',content: 'url:${ctx}/workflow/leave_add.do',cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
			});
		});
		
		function show(id){
			$.dialog({id:'dialog',title:'查看请假单申请',content: 'url:${ctx }/workflow/leave_detail.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
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
		
		function reloadList(){
			window.location.href="${ctx }/workflow/leave_list.do";
		}
		/**
		 * function dd(){
			$.dialog({
				lock: true,
				title:'我是新标题',
				content: '如果定义了回调函数才会出现相应的按钮',
			    ok: function(){
			        this.title('3秒后自动关闭').time(3);
			        return false;
			    },
			    cancelVal: '关闭',
			    cancel: true ,
			    width: '700px',
			    height: 500,
			});
		}
		 */
	</script>
</my:head>
<body>
<div class="bodybox">
	   <div class="phead">
			<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 流程管理 - 请假流程 - 我的请假单</div>
			<div class="pheadbutton">
			   <!--   <input type="button" class="button orange"  value="刷新" id="refreashButton"/> -->
			   <input type="button" class="button orange"  value="填写请假单" id="addnewButton"/>
			</div>
			<div class="clear"></div>
			</div>
		   <form action="${ctx }/workflow/leave_list.do" method="post" id="leaveForm">
		           <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                	
			                  	<th width="4%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th>请假类型<my:order orderattr="lea.leave_type"/></th>
			                	<th>请假时间<my:order orderattr="lea.leave_time"/></th>
			                	<th>到岗时间<my:order orderattr="lea.leave_end_time"/></th>
			                	<th>请假天数（天）<my:order orderattr="lea.leave_day_number"/></th>
			                	<th>请假原因<my:order orderattr="lea.leave_content"/></th>
			                	<th>当前状态<my:order orderattr="et.user_name"/></th>
			                	<!-- <th>审核状态</th> -->
			                	<th><my:i18n zhText="操作" enText="Action"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="8"><font color="red">当前没有请假单</font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="leave" varStatus="status">
				              <tr id="${leave.id }">
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td><my:view value="${leave.leave_type}" pvalue="leave"/></td>
									<td>${leave.leave_time}</td>
									<td>${leave.leave_end_time}</td>
									<td>${leave.leave_day_number}</td>
									<td>${leave.leave_content}</td>
									<td>
									  <c:if test="${!empty leave.task_user_name}">${leave.task_user_name}审核中 </c:if>
									  <c:if test="${empty leave.task_user_name}">已结束 </c:if>
									</td>
									<!-- <td align="center">${leave.task_name}</td> -->
									<td align="center">
									   <a href="#" onclick="show('${leave.id}');">查看</a>
									   <c:if test="${!empty leave.task_user_name}"><a style="cursor: pointer;" onclick="showPic('${leave.process_instance_id}','${leave.process_definition_id}')">查看流程图</a></c:if>	
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