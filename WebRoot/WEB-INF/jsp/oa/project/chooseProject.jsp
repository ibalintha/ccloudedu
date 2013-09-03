<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head>
	<script type="text/javascript">
	     var list=true;
	     var api = frameElement.api, W = api.opener, D = W.document;
	    $(function() {
	    	
		});
	     api.button(
				{
					name: '确定',
					callback: function(){
					    var projectId = "";
					    var projectCode="";
					    var projectName="";
					    $("input[name='ids']:checked").each(function(){
					    	var v = $(this).val().split(",");
							projectId = v[0];
							projectCode = v[1];
							projectName = v[2];
						});
					     api.get('dialog').document.getElementById('projectId').value = projectId;//给父窗口赋值
				         api.get('dialog').document.getElementById('projectCode').value = projectCode;//给父窗口赋值
				         api.get('dialog').document.getElementById('projectName').innerHTML = projectName;//给父窗口赋值
				         try{
				        	  api.close();
				         }catch(e){
				        	 
				         }
				        
				         return false;
					},
					focus: true
				},
				{
					name: '取消'
				}
	           );
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：选择项目 </div>
	<div class="pheadbutton">
	</div>
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx}/oa/project_chooseProject.do">
   <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
	    <th width="5%"></th>
		<th>项目编号<my:order orderattr="project.projectCode"/></th>
		<th>项目名称<my:order orderattr="project.projectName"/></th>
		<th>开始日期<my:order orderattr="project.createTime"/></th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:forEach items="${page.list}" var="project" varStatus="status">
		  <tr }">
		        <td><input type="radio" name="ids" value="${project.id},${project.projectCode },${project.projectName}"/></td>
				<td align="center">${project.projectCode }</td>
				<td align="center">${project.projectName}</td>
				<td align="center">${project.createTime}</td>
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