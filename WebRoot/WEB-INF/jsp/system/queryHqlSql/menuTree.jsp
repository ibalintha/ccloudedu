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
		    <c:forEach items="${menuList}" var="menu">
			    var pId = "${menu.sysMenu.id}";
			    var id = "${menu.id}";
			    var name = "<my:i18n zhText="${menu.menuName}" enText="${menu.enMenuName}"/>";
			    if(name=="系统菜单"){name = "系统功能";}
			    var menuPath = "${menu.menuPath}";
			    var url = "/system/querySqlHql_list.do?menuId="+id;
			    if(menuPath==""){
			    	url="";
			    }
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
				<c:forEach items="${menuList}" var="menu" end="0">
 		           $.loadIframe("contentIframe","/system/querySqlHql_list.do")
 		        </c:forEach>
			});
	 </script>
 </my:head>
<body class="easyui-layout">
   <div region="west" split="true" title="<my:i18n zhText="系统功能" enText="系统功能"/>" border="false" style="width:200px;padding-top:1px;">
		<ul id="tree" class="ztree" style="width:185px; overflow:auto;height: 98%"></ul>
	  </div>
    <div region="center" border="false">
         <iframe id="contentIframe" style="width:100%;height:98%;"  frameborder="0"></iframe>
	 </div>
</body>
</html>