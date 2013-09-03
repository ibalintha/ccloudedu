<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true">
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener;
        var addordetail = true;
        $(function() {
			
		});
        function schedule(){
			window.location.href="${ctx}/oa/projectSchedule_update.do?projectId=${oaProject.id}";
		}
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 项目阶段设置  - 当前项目：${oaProject.projectName}[${oaProject.projectCode}]</div>
    	<div class="pheadbutton">
			<input type="button" class="button orange"  value="新增项目阶段" onclick="schedule();"/>
	    </div>
	<div class="clear"></div>
</div>

       <table class="ltable" width="100%">
	         <thead class="ltablehead">
				<tr>
					<th style="text-align: center;" width="13%">项目所属阶段</th>
					<th style="text-align: center;" width="13%">开始日期</th>
					<th style="text-align: center;" width="13%">结束日期</th>
					<th style="text-align: center;" nowrap="nowrap">描述</th>
					<th style="text-align: center;" width="15%" nowrap="nowrap"><my:i18n zhText="操作" enText="Action"/></th> 
				</tr>
				</thead>
				<tbody class="ltablebody">
				    <c:if test="${empty oaProjectScheduleList}">
				        <tr><td colspan="5" align="center"><font color="red">当前没有已完成的项目阶段</font></td></tr>
				    </c:if>
				    <c:forEach items="${oaProjectScheduleList}" var="ps">
					    <tr>
							<td align="center" nowrap="nowrap"><my:view value="${ps.scheduleCode}" pvalue="jieduan"/> </td>
							<td align="center" nowrap="nowrap">${ps.startDt}</td>
							<td align="center" nowrap="nowrap">${ps.endDt}</td>
							<td align="center" nowrap="nowrap">${ps.description}</td>
							<td align="center" nowrap="nowrap">
							    <a href="${ctx }/oa/projectSchedule_update.do?id=${ps.id}&projectId=${projectId}">详细</a>
							</td>
						</tr>
				</c:forEach>
				</tbody>
	    </table>
	          
</div> 
</body>
</html>