<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" datePicker="true">
	<script type="text/javascript">
	    var list=true;
	    $(function() {
	    	$("#searchButton").click(function(){$("#cmForm").submit();});
	  		$(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});});
		});
		function show(id){
			$.dialog({
				title:'<my:i18n zhText="系统操作日志详细" enText="Details"/>',
				content: 'url:system/accesslog_detail.do?id='+id,
				cancelVal: '<my:i18n zhText="关闭" enText="Close"/>',cancel: true,width: '700px',height: 500
			});
		}
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition">
	   <my:i18n zhText="当前位置" enText="Current Position"/>： 
	   <my:i18n zhText="系统操作日志" enText="System Operated Log"/> -  <my:i18n zhText="列表" enText="List Logs"/> 
	</div>
	
	<div class="pheadbutton">
	    <input type="button" class="button orange"  id="searchButton" value="<my:i18n zhText="查询" enText="Search"/>" />
	    <input type="button" class="button orange"  id="resetButton" value="<my:i18n zhText="重置" enText="Reset"/>" />
	</div>
	
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx}/system/accesslog_list.do">
	<%--
	<div class="psearchhead">
		 <my:i18n zhText="姓名" enText="User Name"/>：<input type="text" name="accessUserName" id="accessUserName" value="${accessUserName }"/>  
		<my:i18n zhText="操作时间" enText="Operated Time"/>：<input type="text" name="startAccessTime" id="startAccessTime" value="${startAccessTime }" class="Wdate" readonly="readonly"/>
		<my:i18n zhText="至" enText="To"/><input type="text" name="endAccessTime" id="endAccessTime" value="${endAccessTime }" class="Wdate" readonly="readonly"/>
	</div>
	 --%>
   <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
		<th width="15%">日期</th>
		<th width="60%">日志文件路径</th>
		<th width="20%">操作</th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty logFileMap}">
			<tr>
				<td align="center" colspan="4"><font color="red"><my:i18n zhText="当前没有操作日志" enText="There are no Operated Logs"/></font> </td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="entry" varStatus="status">
		  <tr id="${status.index}">
				<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td>${entry.createTime}</td>
				<td>${entry.fileName}</td>
				<td align="center">
				   <a href="${ctx}/system/accesslog_detail.do?logPath=${entry.fileName}" target="_blank">查看</a> | 
				   <a href="${ctx}/system/accesslog_downLoad.do?logPath=${entry.fileName}">下载</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
 <div class="ltablebottom"  >
	<div class="lpage"><my:page page="${page}"/></div>  
</div>
</form>
</div>
</body>
</html>