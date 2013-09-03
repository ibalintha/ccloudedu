<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree2="true">  
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <style type="text/css">
		.left{
			float: left;
			width: 49%;
			background-color: whiteSmoke;
			text-align: left;
			padding-bottom: 9999px;
			margin-bottom: -9999px;
		}
		.middle{
			float: left;
			width: 2%;
			background-color: whiteSmoke;
			text-align: left;
			padding-bottom: 9999px;
			margin-bottom: -9999px;
		}
		.right{
			float: right;
			width: 49%;
			background-color: whiteSmoke;
			text-align: center;
			padding-bottom: 9999px;
			margin-bottom: -9999px;
		}
</style>
	<style type="text/css">.tree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
		 var treeurl="${ctx}/system/role_getMenu.do";
	     var showcheck=true;
	     var customerParam = '${id}';

	     var zTree;
			var setting = {
					isSimpleData: true,
					checkable: true,
					treeNodeKey: "id",
					treeNodeParentKey: "pId",
					addDiyDom: addDiyDom,
					callback: {
						change:	zTreeOnChange
					}
				};
				var zNodes;
				var treeNodeArray = new Array();
				var checkIds = "${checkIds}";
				
				var checkedIdArray = new Array();
				if(checkIds!=""){
					checkedIdArray = checkIds.split(",");
				}
			    <c:forEach items="${funcList}" var="func">
				    var pId = "${func.chFunc.id}";
				    var id = "${func.id}";
				    var name = "<my:i18n zhText="${func.chFuncName}" enText="${func.chFuncName}"/>";
				    var _url = "${func.chFuncPath}";
				    var checked =false;
				    if($.containObj(checkedIdArray,id)){
				    	checked = true;
					 }
				    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",checked:'+checked+',_url:"'+_url+'"}';
				    treeNodeArray.push(oneTreeNode);
			    </c:forEach>
			    var zNodeStr = '['+treeNodeArray.join(",")+']';
	 		    var zNodes = (new Function("return " + zNodeStr))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一

				$(function(){
					setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
					zTree = $("#tree").zTree(setting, zNodes);
					
					var api = frameElement.api, W = api.opener,cDG;
					
					$("#chRoleModel").bind('change',function(){
	    				addFuncContent($(this).val());
	    			});

					$("#submitBtn").submitForm({ 
						formId:"roleForm",
						resetForm:false,
						onSubmit:function(){
							 var checkedNodes = zTree.getCheckedNodes();
							 //alert($('#chRoleFlag').val());
							//modify by liuchx 20130806 begin
							//alert(window.parent.frames[1].frames[0].document.getElementById('testFrame').value);
							//alert(window.parent.frames[1].name);.window.frames[0].document.body.innerHTML
							//alert(window.parent.frames[1].frames[0].name);iframes["系统角色"].contentWindow.document  contentIframe
							//将修改的值组合成json传递给父页面
							//取出选中的role标记并传递
							var roleFlag=$("input[name='chRoleFlag']:checked").val();  
							var sendValue="({\"roleId\":"+"\""+
		   				  				  $('#id').val()+"\""+
		   				  				  ","+
		   				  				  "\"roleName\":"+"\""+
		   				  				  $('#chRoleName').val()+"\""+
		   				  				  ","+
		   				  				  "\"roleFlag\":"+"\""+
		   				  				  roleFlag+"\""+
		   				  				  ","+
		   				 				  "\"roleDesc\":"+"\""+
		   				  				  $('#roleDesc').val()+"\""+
		   								  ","+
		   								  "\"authorityModel\":"+"\""+
		   								  $('#chRoleModel').val()+"\""+
		   				 				  ","+
		   								  "\"authorityClass\":"+"\""+
		   								  $('#chRoleFunctions').val()+"\""+
		   								  "})";
							/*
							 * comment:将修改后的值传递给父页面
							 * window.parent.frames['系统角色'].frames['contentIframe']:获取弹出页面
							 * document.getElementById('testFrame'):将值放入在弹出页面建立的隐藏标签中,有在弹出页面中新建变量赋值,测试未成功。
							*/
							if (window.ActiveXObject){
								parent.window.frames["角色管理"].window.frames[0].document.getElementById('testFrame').value=sendValue;
							}else{
								window.parent.frames['系统角色'].frames['contentIframe'].document.getElementById('testFrame').value=sendValue;
							}
		   				  	//
		   				  	//modify by liuchx 20130806 end
					  		 var checkedNodeArray = [];
					  		 for(var i=0;i<checkedNodes.length;i++){
					  			 checkedNodeArray.push(checkedNodes[i].id);
						  	 }
						  	 var checkIds = checkedNodeArray.join(",");
	                         $("#checkIds").val(checkIds);
	                         return true;
						},
						onComplete:function(){
							tolisturl = "${ctx}/system/role_list.do";
							//api.reload(W,tolisturl);
				     		api.close();
							//parent.refreshTree('${id }',$("#chRoleName").val());
						}
					});
				});

	 		    function zTreeOnChange(){
		        	$("label[for='checkIds']").html("");
		        }
		        
				function addDiyDom(treeId, treeNode) {}
				
				function addFuncContent(modelId) {
			        $.ajax({
						url: "${ctx}/system/model_funcList.do?modelId="+modelId,
						type: 'GET',
						dataType:"json",
						error: function(){
							alert("获取此模型的权限范围失败");
						},
						success: function(data){
							$("#tree").empty();
							var zNodes;
							var treeNodeArray = new Array();
							var setting = {
								isSimpleData: true,
								checkable: true,
								treeNodeKey: "id",
								treeNodeParentKey: "pId",
								addDiyDom: addDiyDom,
								callback: {
									change:	zTreeOnChange
								}
							};
							if(data!=null && data.length>0) {
				                for(var i=0; i<data.length; i++) {
				                   	var func = data[i];
				                   	var pId = "";
				                   	if (func.chFunc != null)
				                   	    pId = func.chFunc.id;
								    var id = func.id;
								    var name = "<my:i18n zhText='"+func.chFuncName+"' enText='"+func.chFuncName+"'/>";
								    var _url = func.chFuncPath;
								    var checked =false;
								    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",checked:'+checked+',_url:"'+_url+'"}';
								    treeNodeArray.push(oneTreeNode);
				                }
				                var zNodeStr = '['+treeNodeArray.join(",")+']';
	 		   			 		var zNodes = (new Function("return " + zNodeStr))();
				                setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
				                $("#tree").zTree(setting, zNodes);
			            	}
						}
					});
		   		}
	</script>
</my:head>
<body>
  <my:select pvalue="qxsz" name="authTree" nullValue="false" style="display: none" />
  <div class="bodybox">
		  <form id="roleForm" action="system/role_save.do" method="post">
		  <input type="hidden" name="id" id="id" value="${id }">
		  <div style="margin: 0 auto; width: 100%; overflow: hidden;">
		  <div class="left">
		  	<table width="100%" class="ftable"id="stripe_tb">
		  <c:if test="${!empty chRole.chRoleName}">
			    <tr>
		            <th width="18%"><my:i18n zhText="上级角色" enText="Parent Role"/>：</th>
		            <td>
		               <my:i18n zhText="${chRole.chRoleName}" enText="${chRole.chRoleName}"/>
		            </td>
	          </tr>
		   </c:if>
           <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="角色名称" enText="Chinese Role Name"/>：</th>
            <td><input type="text" id="chRoleName" name="chRoleName" value="${chRoleName }" class="required" rules="[{notNull:true, message:'<my:i18n zhText="请输入角色名称" enText="Please Enter Role Name"/>'}]"></td>
          </tr>
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="是否激活" enText="English Role Name"/>：</th>
            <td><my:radio pvalue="yesornot" id="chRoleFlag" name="chRoleFlag" value="${chRoleFlag}"/></td>
          </tr>
         <tr>
            <th width="18%"><my:i18n zhText="角色描述" enText="Description"/>：</th>
            <td><textarea style="width: 98%;height: 60px" name="chRoleDesc" id="roleDesc">${chRoleDesc }</textarea></td>
          </tr>
          <tr>
            <th width="18%"><my:i18n zhText="权限模型" enText="Authority Model"/>：</th>
            <td>
            	<select name="chRoleModel" id="chRoleModel">
            	<c:forEach items="${chModelfs}" var="model">
            		<option value="${model.id}" <c:if test="${chRoleModel eq model.chModlName}">selected="selected"</c:if> />${model.chModlName }
            	</c:forEach>
                </select>
            </td>
          </tr>
          <tr>
            <th width="18%"><my:i18n zhText="权限组" enText="Authority Class"/>：</th>
            <td><textarea style="width: 98%;height: 60px" name="chRoleFunctions" id="chRoleFunctions">${chRoleFunctions }</textarea></td>
          </tr>
        </table>
		  </div>
		  <div class="middle"> </div>
		  <div class="right">
		  <table width="100%" class="ftable"id="stripe_tb">
		  <tr>
  				<th colspan="2" width="100%" style="text-align:center;"><my:i18n zhText="权限选择" enText="Parent Role"/></th>
  			</tr>
		  	         <c:if test="${!empty chRole.chRoleName }">
	          <tr>
	            <th width="25%"><font color="red">*</font><my:i18n zhText="可访问权限" enText="Limits Of Permissions"/>：</th>
	            <td >
	              <ul id="tree" class="tree" style="margin-left: 0px"></ul>
	              <input type="hidden" name="checkIds" id="checkIds" value="" rules="[{notNull:true, message:'<my:i18n zhText="请选择可访问的菜单" enText="Please Choose Some Limits Of Authority"/>'}]"/>
	            </td>
	         </tr>
          </c:if>
		  	 </table>
		  </div>
		  </div>
		  <div class="ltablebottom">
		   	<input type="button" class="button orange" value="<my:i18n zhText="更新" enText="Update"/>" id="submitBtn"/> &nbsp;
			<input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		   </div>
        </form>
        </div>
	</body>
</html>