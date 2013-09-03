<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <input type="hidden" id="currentPage" name="page.currentPage"  value="${page.currentPage }"/>
	<input type="hidden" id="totalPage" name="page.totalPage" value="${page.totalPage }"/> 
	<input type="hidden" id="orderattr" name="page.orderattr" value="${page.orderattr}" >
	<input type="hidden" id="ordertype" name="page.ordertype" value="${page.ordertype}" >
	
	    第${page.currentPage }页 
	     共${page.totalPage }页  
	     共<span id="pageTotalRecords">${page.totalRecords }</span>条| 
	 
	 <c:if test="${page.previousPage<=0}">
	   <font color="#999999">首页</font>| 
	 </c:if> 
	  <c:if test="${page.previousPage>0}">
	  <a href="javascript:toPage(document.getElementById('totalPage').form,1);">首页</a> |
	 </c:if> 
	 <c:if test="${page.previousPage<=0}">
	   <font color="#999999">上一页</font>| 
	 </c:if> 
	<c:if test="${page.previousPage>0}">
	   <a href="javascript:toPage(document.getElementById('totalPage').form,'${page.previousPage }');">上一页</a> | 
	 </c:if> 
	 
	 <c:if test="${page.nextPage<=0}">
	   <font color="#999999">下一页</font>| 
	 </c:if> 
	 <c:if test="${page.nextPage>0}">
	   <a href="javascript:toPage(document.getElementById('totalPage').form,'${page.nextPage }');">下一页</a> | 
	 </c:if> 
	 <c:if test="${page.nextPage<=0}">
	    <font color="#999999">末页</font>| 
	 </c:if> 
	 <c:if test="${page.nextPage>0}">
	   <a href="javascript:toPage(document.getElementById('totalPage').form,'${page.totalPage }');">末页</a> | 
	 </c:if>
	 
	每页<s:select name="page.pageSize" list="#{'10':'10','20':'20','30':'30','50':'50','100':'100'}" onchange="toPage(document.getElementById('totalPage').form,'1');"/>条
	<%--
	<input type="text" id="pageSize" name="page.pageSize" value="${page.pageSize }" style="width: 1.7em"/>条
	 到 <input type="text" name="jump" id="jump" style="width: 1.5em"/>页
	 <img onmouseover="this.style.cursor='hand';" 
	      onclick="javascript:toPage(
		      document.getElementById('totalPage').form,
		      document.getElementById('jump').value);"
	      src="<%=request.getContextPath() %>/js_css_image/images/btn_go.gif" 
	      alt="跳转" border="0" width="20" height="18" align="absmiddle">
	 --%>
	<script type="text/javascript">
	   $(function(){
		   $("a.orderBy").click(function() {
			   $("#orderattr").val($(this).attr("rel"));
			   if($(this).attr("ordertype")==""){
				    $("#ordertype").val("desc");
			   }else{
				    $("#ordertype").val($(this).attr("ordertype"));
			   }
		       document.getElementById('totalPage').form.submit();
	       });
	   })
		function toPage(form,currentPage){
			<%--
			if(isNaN(currentPage)){
			    alert("请在跳转页栏里输入整数");
			    return false;
			}
			if(currentPage<=0){
			    alert("输入页数必须大于 0");
			    return false;
			}
			var num = 1*currentPage;
			var total = 1*form.totalPage.value;
			if(num>total){
				 alert("输入页数必须不大于总页数");
			    return false;
			}
			--%>
			document.getElementById("currentPage").value=currentPage;
			form.submit();
		}
	</script>