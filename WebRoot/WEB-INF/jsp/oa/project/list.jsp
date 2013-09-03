<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
	<script type="text/javascript">
	    var list=true;
	    var deleteurl="${ctx }/oa/project_delete.do";
	    $(function() {
	    	$("#searchButton").click(function(){$("#cmForm").submit();});
	    	
	    	$("#addnewButton").click(function(){
				$.dialog({id:'addProject',title:'新增项目',content: 'url:${ctx }/oa/project_update.do',cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
			});
		});
		function show(id){
			$.dialog({id:'updateProject',title:'修改项目',content: 'url:${ctx }/oa/project_update.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		function schedule(id){
			$.dialog({id:'addProject',title:'项目阶段设置',content: 'url:${ctx }/oa/projectSchedule_update.do?projectId='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		
		function completedSchedule(id){
			$.dialog({id:'addProject',title:'项目阶段设置',content: 'url:${ctx }/oa/projectSchedule_completedSchedule.do?projectId='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		
		function reloadProject(){
			location.href="${ctx}/oa/project_list.do";
		}
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 工作管理 - 项目维护 </div>
	<div class="pheadbutton">
	    <my:auth fixedValue="W" value="${auth}">
			<input type="button" class="button orange"  value="新增项目"  id="addnewButton"/>
			<input type="button" class="button orange"  value="<my:i18n zhText="导出excel" enText="Export To A Excel"/>"  id="exportExcel"/>
		</my:auth>
	</div>
	
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx}/oa/project_list.do">
   <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
	    <th width="4%"  style="display: none"><input type="checkbox" name="checkId" id="checkId" value=""></th>
		<th width="4%"  nowrap="nowrap"><my:i18n zhText="序号" enText="No."/></th>
		<th nowrap="nowrap">项目编号<my:order orderattr="project.projectCode"/></th>
		<th nowrap="nowrap">项目名称<my:order orderattr="project.projectName"/></th>
		<th nowrap="nowrap">项目重要性<my:order orderattr="project.urgencyDegree"/></th>
		<th nowrap="nowrap">开始日期<my:order orderattr="project.createTime"/></th>
		<th width="18%" nowrap="nowrap"><my:i18n zhText="操作" enText="Action"/></th> 
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td colspan="6" >当前没有项目</td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="project" varStatus="status">
		  <tr id="${project.id }">
		        <td  style="display: none"><input type="checkbox" name="ids" value="${project.id}"/></td>
				<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td>${project.projectCode }</td>
				<td>${project.projectName}</td>
				<td><my:view value="${project.urgencyDegree }" pvalue="projectimportant"/></td>
				<td>${project.createTime}</td>
				<td align="center">
				    <a href="#" onclick="show('${project.id}')">修改</a>
				    <a href="javascript:" class="deleteOne" param="ids=${project.id}"  style="display: none"><my:i18n zhText="删除" enText="Delete"/></a>
				    <%--<a href="#" onclick="schedule('${project.id}')">项目阶段设置</a> --%>
				    <a href="#" onclick="completedSchedule('${project.id}')">项目阶段设置</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
  </table>
  <div class="ltablebottom">
      <div style="float: left;"><my:auth fixedValue="W" value="${auth}"><input style="display: none" type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" id="batchDelete"/></my:auth></div>
	  <div class="lpage"><my:page page="${page}"/></div> 
  </div>
</form>
</div>
</body>
</html>