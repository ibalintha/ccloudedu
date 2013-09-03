<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
   String queryType = request.getParameter("queryType");
   request.setAttribute("queryType",queryType);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/main.css"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/colorbox_1.css"  media="screen" />
    <script src="${ctx}/js/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery/jquery.colorbox.js" type="text/javascript"></script>
	<script src="${ctx }/js/util.js" type="text/javascript"></script>
	<script type="text/javascript">
		var list=true;
		var addnewurl = "${ctx}/system/uploadfile_add.do";
		var refreashurl= "${ctx}/system/uploadfile_list.do";
		$(function(){
			if($("#queryType").val()=="1"){
				//$("a[rel='example1']").colorbox({current: "{current}/{total}"});
			}else{
				//$("a[rel='example1']").colorbox({current: "{current}/{total}",width:"80%", height:"85%"});
		    }
			$("#fullscream").click(function(){
				window.location.href="${ctx}/system/uploadfile_list.do?queryType=1";
		    })
		    $("#fitscream").click(function(){
				window.location.href="${ctx}/system/uploadfile_list.do";
		    })
		});
	</script>
</head>
<body>
<input type="hidden" name="queryType" id="queryType" value="${queryType }">
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 图片管理 - 列表 </div>
	<div class="pheadbutton">
    	<input type="button" class="button orange"  value="刷新" id="refreashButton"/>
	    <input type="button" class="button orange"  value="上传图片" id="addnewButton"/>
	    <input type="button" class="button orange"  value="原始大小显示" id="fullscream"/>
	    <input type="button" class="button orange"  value="按比例显示" id="fitscream"/>
	</div>
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx}/system/uploadfile_list.do">
    <h1>图片列表</h1>
       <c:if test="${empty page.list}">
			<h2>没有图片</h2>
		</c:if>
		<s:iterator value="page.list" status="status">
			<p><a href="${ctx}/system/uploadfile_download.do?id=${id}" rel="example1" title="${uploadFileName }">${uploadFileName } [${UploadFileSize }]</a></p>
		</s:iterator>
</form>
</div>
</body>
</html>