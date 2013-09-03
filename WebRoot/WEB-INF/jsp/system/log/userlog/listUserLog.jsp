<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true">
	<script type="text/javascript">
		var list=true;
		$(function() {
			$("#searchButton").click(function(){$("#cmForm").submit();});
			$(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition">
		<my:i18n zhText="当前位置" enText="Current Position"/>： 
		<my:i18n zhText="用户登录日志" enText="User Login Log"/> -
		<my:i18n zhText="列表" enText="List Logs"/>
	</div>
	<div class="pheadbutton">
	    <input type="button" class="button orange"  id="searchButton" value="<my:i18n zhText="查询" enText="Search"/>" />
	    <input type="button" class="button orange"  id="resetButton" value="<my:i18n zhText="重置" enText="Reset"/>" />
	</div>
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx}/system/userlog_list.do">
	<div class="psearchhead">
		<my:i18n zhText="姓名" enText="User Name"/>：<input type="text" name="loginUserName" id="loginUserName" value="${loginUserName }"/>  
		<my:i18n zhText="登录时间" enText="Login Time"/>：<input type="text" name="startLoginTime" id="startLoginTime" value="${startLoginTime }" class="Wdate" readonly="readonly"/>
		<my:i18n zhText="至" enText="To"/><input type="text" name="endLoginTime" id="endLoginTime" value="${endLoginTime }" class="Wdate" readonly="readonly"/>
	</div>
   <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="4%"><input type="checkbox" id="checkId"/></th>
		<th width="4%"><my:i18n zhText="序号" enText="No."/></th>
		<th width="15%"><my:i18n zhText="登录用户" enText="User Name"/><my:order orderattr="log.loginUser.userName"/></th>
		<th width="13%"><my:i18n zhText="登录ip" enText="Login Ip"/><my:order orderattr="log.loginIp"/></th>
		<th width="13%"><my:i18n zhText="登录时间" enText="Login Time"/><my:order orderattr="log.loginTime"/></th>
		<th width="13%"><my:i18n zhText="退出时间" enText="Logout Time"/><my:order orderattr="log.logoutTime"/></th>
		<th width="18%"><my:i18n zhText="在线时长(分)" enText="Online Time Length(Minute)"/><my:order orderattr="log.onlineTimeLength"/></th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td align="center" colspan="7"><font color="red"><my:i18n zhText="当前没有登录日志" enText="No Data Now"/></font></td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="log" varStatus="status">
		   <tr id="${log.id }">
				<td align="center"><input type="checkbox" name="ids" id="ids" value="${log.id}"/></td>
				<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td><my:i18n zhText="${log.loginUser.userName }" enText="${log.loginUser.enUserName }"/></td>
				<td>${log.loginIp}</td>
				<td>${log.loginTime }</td>
				<td>${log.logoutTime}</td>
				<td>${log.onlineTimeLength }</td>
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