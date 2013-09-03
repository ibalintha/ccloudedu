<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/main.css"/>
    <script src="${ctx}/js/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery/jquery.easyui.min_1.0.4.js" type="text/javascript"></script>
	<script src="${ctx }/js/util.js"  type="text/javascript"></script>
	<script type="text/javascript">
	function yl(){
		 window.open("http://127.0.0.1:8080/materail_g/system/layout_layout.do");
    }
	</script>
</head>
<body>
<div>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 首页管理</div>
	<div class="pheadbutton" >
		   <input type="button" class="button orange"  value="预览" id="ylButton" onclick="yl()"/>
		   <input type="button" class="button orange"  value="发布" id="tolistButton"/>
	</div>
	<div class="clear"></div>
</div>
 </div>
 </div>
</body>
</html>