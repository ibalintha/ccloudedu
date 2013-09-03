<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>快速开发功能演示</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link  type="text/css" rel="stylesheet" href="${ctx}/js_css_image/css/login.css"/>
<script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/js_css_image/js/base/jquery.ccloudedu.utils-1.0.js"></script>
<script type="text/javascript"> 
  $(function(){ 
       $("#filterName").keyup(function(){ 
          $("table tbody tr") 
                    .hide() 
                    .filter(":contains('"+( $(this).val() )+"')") 
                    .show(); 
       }).keyup(); 
  }); 
</script> 
</head> 
<body> 
<div> 
<br/> 
筛选： 
<input id="filterName" /> 
<br/> 
  
</div> 
  
<table> 
    <thead> 
        <tr><th>姓名</th><th>性别</th><th>暂住地</th></tr> 
    </thead> 
    <tbody> 
        <tr><td>张山</td><td>男</td><td>浙江宁波</td></tr> 
        <tr><td>李四</td><td>女</td><td>浙江杭州</td></tr> 
        <tr><td>王五</td><td>男</td><td>湖南长沙</td></tr> 
        <tr><td>找六</td><td>男</td><td>浙江温州</td></tr> 
        <tr><td>Rain</td><td>男</td><td>浙江杭州</td></tr> 
        <tr><td>MAXMAN</td><td>女</td><td>浙江杭州</td></tr> 
        <tr><td>王六</td><td>男</td><td>浙江杭州</td></tr> 
        <tr><td>李字</td><td>女</td><td>浙江杭州</td></tr> 
        <tr><td>李四</td><td>男</td><td>湖南长沙</td></tr> 
    </tbody> 
</table> 
  
</body> 
</html>
