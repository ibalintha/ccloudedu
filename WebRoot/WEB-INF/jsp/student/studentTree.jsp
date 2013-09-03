<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>

<!DOCTYPE html>
<html>
<my:head easyui="true" tree3="true">
 <script type="text/javascript">
	    var ctx = '${ctx}';
	   var setting = {data: {simpleData: {enable: true}}};
			var treeNodeArray = new Array();
			<c:forEach items="${chclasstreeList}" var="cct">
			    var pId = "${cct.chclasstree.id}";
			    var id = "${cct.id}";
			    var name = "${cct.name}";
			    var isLast = "${cct.isLast}";
			    var url = "/student/student_list.do?chClasId="+id+"&isLast="+isLast;
			    var click="javascript:$.loadIframe('contentIframe','"+url+"')";
			    var open = false;
			    if(pId==""){open = true; }
			    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",click:"'+click+'",open:'+open+'}';
			    treeNodeArray.push(oneTreeNode);
		    </c:forEach>
		    var zNodeStr = '['+treeNodeArray.join(",")+']';
 		    var zNodes = (new Function("return " + zNodeStr))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
			$(function(){
				$.fn.zTree.init($("#tree"), setting, zNodes);
				<c:forEach items="${chclasstreeList}" var="cct" end="0">
 		           $.loadIframe("contentIframe","/student/student_list.do?chClasId=${cct.id}&isLast=${cct.isLast}");
 		        </c:forEach>
			});
	 </script>
</my:head>
<body class="easyui-layout">
   <div region="west" split="true" title="模板导航" border="false" style="width:144px;padding-top:1px;">
	  <ul id="tree" class="ztree" style="width:230px; overflow:auto;"></ul>
   </div>
  <div region="center" border="false">
         <iframe id="contentIframe" style="width:100%;height:98%;"  frameborder="0"></iframe>
			<!-- 
			<div id="main-center" fit="true"  border="false">
			  <div title="功能介绍" style="padding:20px;">
			      
			 </div>
			 </div>	
			 -->
	 </div>
 </body>
</html>