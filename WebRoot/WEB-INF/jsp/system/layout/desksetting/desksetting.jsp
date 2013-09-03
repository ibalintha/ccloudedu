<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
<script type="text/javascript">
	$(function() {
		  $("span.zmsz").each(function(){
			  var zmsz = $(this).attr("zmsz");
			  if(zmsz!=""){
				   $.post("${ctx}/system/desksetting_"+zmsz+".do",function(ret) {
				       $("#"+zmsz+"Content").html(ret);
			      }, "html");
			  }
		  });
		//$(".itemContent").jscroll();//设置了滚动条宽度
	});
</script>
</my:head>
<body>
<div id="bottomNav" style="text-align: center;display: none" ><b><a href="">我要留言</a></b></div>
<div class="bodybox" style="padding-top: 10px">

<c:forEach items="${zmszs}" var="zmsz">
   <div style="margin-bottom: 5px;">
	<div class="groupItem" style="float: left;">
		<div class="itemHeader"><span class="zmsz" zmsz="${zmsz.zmszCol1}"><my:view value="${zmsz.zmszCol1}" pvalue="zmsz"/></span> <a href="#" class="closeEl" style="display: none">[收起]</a></div>
		<div class="itemContent" id="${zmsz.zmszCol1}Content"><img alt="" src="${ctx }/js_css_image/images/loading.gif"/> </div>
	</div>
	<c:if test="${!empty zmsz.zmszCol2}">
		<div class="groupItem" style="float: right;">
		<div class="itemHeader"><span class="zmsz" zmsz="${zmsz.zmszCol2}"><my:view value="${zmsz.zmszCol2}" pvalue="zmsz"/></span> <a href="#" class="closeEl" style="display: none">[收起]</a></div>
		<div class="itemContent" id="${zmsz.zmszCol2}Content"><img alt="" src="${ctx }/js_css_image/images/loading.gif"/></div>
	</div>
	</c:if>
</div>
</c:forEach>
</div>
</body>
</html>