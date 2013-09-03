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
		    <c:forEach items="${ddList}" var="dd">
			    var pId = "${dd.parentDD.id}";
			    var pValue = "${dd.parentDD.ddValue}";
			    var hasChild = "${dd.undefined2}";
			    var id = "${dd.id}";
			    var name = "<my:i18n zhText="${dd.ddName }" enText="${dd.enDdName }"/>";
			    var url = "/system/datadictionary_update.do?id="+id;
			    var click="javascript:$.loadIframe('contentIframe','"+url+"')";
			    var open = false;
			    if(pId==""){
			    	open = true;
			    }else if(pValue=="root" && hasChild=="hasChild"){
			    	open=true;
			    }
			    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",click:"'+click+'",open:'+open+'}';
			    treeNodeArray.push(oneTreeNode);
		    </c:forEach>
		    var zNodeStr = '['+treeNodeArray.join(",")+']';

 		    var zNodes = (new Function("return " + zNodeStr))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
			$(function(){
				$.fn.zTree.init($("#tree"), setting, zNodes);
				
				<c:forEach items="${ddList}" var="dd" end="0">
 		           $.loadIframe("contentIframe","/system/datadictionary_update.do?id=${dd.id}")
 		        </c:forEach>
				
			});
	 </script>
 </my:head>
<body class="easyui-layout">
       <div region="west" split="true" title="<my:i18n zhText="参数导航" enText="Param Navigation"/>" border="false" style="width:200px;padding-top:1px;">
        <ul id="tree" class="ztree" style="width:185px; overflow:auto;height: 98%"></ul>
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