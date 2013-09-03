<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head easyui="true" tree3="true">
 <script type="text/javascript">
	    var ctx = '${ctx}';
	    
	    	    var zTree;
		var setting = {
				isSimpleData: true,
				treeNodeKey: "id",
				treeNodeParentKey: "pId"
			};
		
			var treeNodeArray1 = new Array();
			<c:forEach items="${deptList}" var="dept">
			    var pId = "${dept.sysDept.id}";
			    var id = "${dept.id}";
			    var name = "${dept.deptName}";
			    var url = "/system/user_list.do?deptId="+id;
			    var click="javascript:$.loadIframe('contentIframe','"+url+"')";
			    var open = false;
			    if(pId==""){open = true; }
			    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",click:"'+click+'", open:'+open+'}';
			    treeNodeArray1.push(oneTreeNode);
		    </c:forEach>
		    var zNodeStr1 = '['+treeNodeArray1.join(",")+']';
 		    var zNodes1 = (new Function("return " + zNodeStr1))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
 		    
			var treeNodeArray2 = new Array();
		   <c:forEach items="${roleList}" var="role">
			    var pId = "${role.sysRole.id}";
			    var id = "${role.id}";
			    var name = "${role.roleName}";
			    var url = "/system/user_list.do?roleId="+id
			    var click="javascript:$.loadIframe('contentIframe','"+url+"')";
			    var open = false;
			    if(pId==""){open = true; }
			    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",click:"'+click+'",open:'+open+'}';
			    treeNodeArray2.push(oneTreeNode);
		    </c:forEach>
		    var zNodeStr2 = '['+treeNodeArray2.join(",")+']';

 		    var zNodes2 = (new Function("return " + zNodeStr2))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
	    
	    $(function(){
	    	setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
			$("#tree1").zTree(setting, zNodes1);
			$("#tree2").zTree(setting, zNodes2);
       	    $('#tt').tabs();
       	 });
	 </script>
</my:head>
<body class="easyui-layout">
   <div region="west" split="true" title="用户导航" border="false" style="width:196px;padding:10px;padding-top:1px;">
		<div id="tt" border="false" fit="true"> 
		    <div title="按部门显示" style="display:none;">
		       <ul id="tree1" class="tree" ></ul>
		    </div>
		      <div title="按角色显示"  style="display:none">
		       <ul id="tree2" class="tree"></ul>
		    </div>
		</div>
	  </div>
    <div region="center" border="false" split="false">
		<div id="main-center" fit="true">
		 </div>			
	 </div>
</body>
</html>