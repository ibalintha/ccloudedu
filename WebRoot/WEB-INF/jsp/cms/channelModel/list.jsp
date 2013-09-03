<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript">
		var list=true;
		var deleteurl = "${ctx }/cms/channelModel_delete.do";
		var addnewurl = "${ctx}/cms/channelModel_add.do";
		$(function() {
			$("#addnewButton").click(function(){window.location.href=addnewurl;});
			//$("a[name='deptDetail']").colorbox({width:"90%", height:"90%", iframe:true});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：信息发布管理 - 栏目类型 - 列表</div>
	<div class="pheadbutton">
	  <input type="button" class="button orange"  value="添加" id="addnewButton"/>
	</div>
	<div class="clear"></div>
</div>
<c:if test="${!empty actionMessages}">
     <div id="result" align="center" style="color: red;height: 16px;padding-top: 9px"><s:actionmessage/></div>
</c:if>
<form id="cmForm" method="post" action="cms/channelModel_list.action">
<table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="25px">
		<input type="checkbox" id="checkId"/></th>
		<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
		<th>名称</th>
		<th>编码</th>
		<th>备注</th>
		<th><my:i18n zhText="操作" enText="Action"/></th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td align="center" colspan="8"><font color="red">当前尚未添加栏目类型</font> </td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="channelModel" varStatus="status">
	     	<tr id="${id}">
				<td><input type="checkbox" name="ids" value="${channelModel.id }"/></td>
				<td><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td>${channelModel.channelModelName }</td>
				<td>${channelModel.shortName }</td>
				<td>${channelModel.remark }</td>
				<td>
					<a href="${ctx}/cms/channelModel_update.do?id=${channelModel.id}">修改</a>
					<a href="javascript:" class="deleteOne" param="ids=${channelModel.id}"><my:i18n zhText="删除" enText="Delete"/></a>	
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
 <div class="ltablebottom">
    <div style="float: left;"><input type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" id="batchDelete"/></div>
	<div class="lpage"><my:page page="${page}"/></div>  
</div>
</form>
</div>
</body>
</html>