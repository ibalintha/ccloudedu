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
		<c:forEach items="${deptList}" var="dept">
			  var pId = "${dept.sysDept.id}";
			  var id = "${dept.id}";
			  var name = "<my:i18n zhText="${dept.deptName}" enText="${dept.enDeptName}"/>";
			  var url = "/system/dept_update.do?id="+id;
			  var click="javascript:$.loadIframe('contentIframe','"+url+"')";
			  var open = false;
			  if(pId==""){open = true; }
			  var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",click:"'+click+'", open:'+open+'}';
			  treeNodeArray.push(oneTreeNode);
		  </c:forEach>
		   var zNodeStr = '['+treeNodeArray.join(",")+']';
 		   var zNodes = (new Function("return " + zNodeStr))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
	
		   $(function(){
				$.fn.zTree.init($("#tree"), setting, zNodes);
				<c:forEach items="${deptList}" var="dept" end="0">
 		           $.loadIframe("contentIframe","/system/dept_update.do?id=${dept.id}")
 		        </c:forEach>
		   });
	 </script>
</my:head>
<body class="easyui-layout">
     <div region="west" split="true" title="<my:i18n zhText="部门导航" enText="Dept Navigation"/>" border="false" style="width:200px;padding-top:1px;">
		<ul id="tree" class="ztree" style="width:185px; overflow:auto;height: 98%"></ul>
	  </div>
    <div region="center" border="false">
         <iframe id="contentIframe" style="width:100%;height:98%;"  frameborder="0"></iframe>
			<!-- 
			<div id="main-center" fit="true"  border="false">
			  <div title="功能介绍" style="padding:20px;">
			       这里是部门管理模块的功能介绍
			 </div>
			 </div>	
			 -->
	 </div>
</body>
</html>