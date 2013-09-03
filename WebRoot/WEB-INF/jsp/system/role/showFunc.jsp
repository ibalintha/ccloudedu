<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree2="true">  
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<style type="text/css">.tree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
		 var treeurl="${ctx}/system/role_getMenu.do";
	     var showcheck=true;
	     var customerParam = '${id}';
	     var zTree;
			var setting = {
					isSimpleData: true,
					checkable: false,
					treeNodeKey: "id",
					treeNodeParentKey: "pId",
					addDiyDom: addDiyDom,
					callback: {
						change:	zTreeOnChange
					}
				};
				var zNodes;
				var treeNodeArray = new Array();
				
			    <c:forEach items="${roleFuncList}" var="roleFunc">
				    var pId = "${roleFunc.chFunc.chFunc.id}";
				    var id = "${roleFunc.chFunc.id}";
				    var name = "<my:i18n zhText="${roleFunc.chFunc.chFuncName}" enText="${roleFunc.chFunc.chFuncName}"/>";
				    var _url = "${roleFunc.chFunc.chFuncPath}";
				   
				    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",_url:"'+_url+'"}';
				    treeNodeArray.push(oneTreeNode);
			    </c:forEach>
			    var zNodeStr = '['+treeNodeArray.join(",")+']';
	 		    var zNodes = (new Function("return " + zNodeStr))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
				$(function(){
					setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
					zTree = $("#tree").zTree(setting, zNodes);
				});

	 		    function zTreeOnChange(){
		        	$("label[for='checkIds']").html("");
		        }
		        
				function addDiyDom(treeId, treeNode) {}
	</script>
</my:head>
<body>
  <my:select pvalue="qxsz" name="authTree" nullValue="false" style="display: none" />
  <div class="bodybox">
		  <input type="hidden" name="id" id="id" value="${id }">
		  <table width="100%" class="ftable"id="stripe_tb">
		  <tr>
  				<th colspan="2" width="100%" style="text-align:left;"><my:i18n zhText="查看 ${chRole.chRoleName} 的权限" enText="Parent Role"/></th>
  			</tr>
		  	         <c:if test="${!empty chRole.chRoleName }">
	          <tr>
	            <th width="18%"><my:i18n zhText="可访问权限" enText="Limits Of Permissions"/>：</th>
	            <td >
	              <ul id="tree" class="tree" style="margin-left: 0px"></ul>
	              <input type="hidden" name="checkIds" id="checkIds" value="" rules="[{notNull:true, message:'<my:i18n zhText="请选择可访问的菜单" enText="Please Choose Some Limits Of Authority"/>'}]"/>
	            </td>
	         </tr>
          </c:if>
		  	 </table>
        </div>
	</body>
</html>