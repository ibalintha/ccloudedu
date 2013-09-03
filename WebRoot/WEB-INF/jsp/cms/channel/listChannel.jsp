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
		var deleteAndRemoveTreeNode=true;
		var deleteurl = "${ctx }/cms/channel_delete.do";
		$(function() {
			//$("a[name='deptDetail']").colorbox({width:"90%", height:"90%", iframe:true});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="tabs1" >
		<tr>
			<td>
				<div align="center" id="uldiv">
					<ul>
						<li><a href="${ctx }/cms/channel_update.do?id=${id }"><span>本栏目信息</span></a></li>
						<li id="current"><a href="${ctx }/cms/channel_list.do?id=${id }"><span>下级栏目列表</span></a></li>
						<li><a href="${ctx }/cms/channel_add.do?id=${id }"><span>新增下级栏目</span></a></li>
					</ul>
				</div>
			</td>
		</tr>
	</table>
</div>

<form id="cmForm" method="post" action="cms/channel_list.do">
     <input type="hidden" value="${id}" name="id"/>
     <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="25px">
		<input type="checkbox" id="checkId"/></th>
		<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
		<th>名称</th>
		<th>路径</th>
		<th>文档数量</th>
		<th>点击次数</th>
		<th>是否显示</th>
		<th><my:i18n zhText="操作" enText="Action"/></th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td align="center" colspan="8" ><font color="red">当前尚未添加栏目</font> </td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="channel" varStatus="status">
			<tr id="${id }">
				<td><input type="checkbox" name="ids" id="ids" value="${channel.id }"/></td>
				<td><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td>${channel.channelName }</td>
				<td>${channel.path }</td>
				<td>${channel.visitToday }</td>
				<td>${channel.visitTotal }</td>
				<td>${channel.isDisplay }</td>
				<td>
					<a href="javascript:" class="deleteOne" param="ids=${channel.id}"><my:i18n zhText="删除" enText="Delete"/></a>
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