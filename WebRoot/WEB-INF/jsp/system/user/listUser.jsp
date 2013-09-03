<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" tree3="true">
	<link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css" />
    <script type="text/javascript">
		var addnewurl = "${ctx}/system/user_add.do?roleId=${roleId}";
		var deleteurl = "${ctx }/system/user_delete.do";
		$(function() {
			var id = "";
			$(".ltable tr").dblclick(function(){
				id = $(this).attr("id");
				showEdit(id);
			});
		
	  	
	  		var idsArray = new Array();
			var ids = "";
	  		$("input[name='ids']").bind("click", function(){
	  			if ($(this).attr("checked") == "checked" ) {
	  				ids +=","+$(this).val();
	  			} else {
	  				if(ids!=""){
	  					idsArray = ids.split(",");
	  					idsArray = deleteFromArray(idsArray,$(this).val());
	  					ids = idsArray.join(",");
	  				}
	  			}
	  		});
	  	
	  		$("#addnewButton").click(function(){
				if ($(this).attr("class")=="button orange") 
					//window.location.href=addnewurl;
					var roleId=document.getElementById("roleID").value;
					showAdd(roleId);
			});
	  		
	  		$("#editButton").click(function(){
					if(ids==""){
						alert("请选择需要编辑的用户");
					}else if(getCount(ids)>1){
						alert("请选择一条数据");
					}else{
						if (ids.indexOf(",")==0){
							ids=ids.substring(1);
						}
						showEdit(ids);
						ids = "," +ids;
					}
			});
			
	  		$("#lockButton").click(function(){
	  			if ($(this).attr("class")=="button orange"){	
					if(ids==""){
						alert("请选择需要锁定的用户");
					}else if(getCount(ids)>1){
						alert("请选择一条数据");
					}else{
						if (ids.indexOf(",")==0){
							ids=ids.substring(1);
						}
						var flag = $("td:eq(5)", $("tr[id='"+ids+"']")).html();
						if(flag == "正常"){
								window.location.href="${ctx}/system/user_changeUserState.do?id="+ids; 
						}else{
							alert("当前用户状态已锁定，不能再次锁定");
						}
						ids = "," +ids;
					}
						
				}
			});
			
			$("#unLockButton").click(function(){
				if ($(this).attr("class")=="button orange")
					if(ids==""){
						alert("请选择需要解锁激活的用户");
					}else if(getCount(ids)>1){
						alert("请选择一条数据");
					}else{
						if (ids.indexOf(",")==0){
							ids=ids.substring(1);
						}
						var flag = $("td:eq(5)", $("tr[id='"+ids+"']")).html();
						if(flag == "锁定"){
								window.location.href="${ctx}/system/user_changeUserState.do?id="+ids; 
						}else{
							alert("当前用户状态正常，不能再次激活");
						}
						ids = "," +ids;
					}
			});
			
			$("#PWDInitButton").click(function(){
				if ($(this).attr("class")=="button orange") 
					if(ids==""){
						alert("请选择需要初始化密码的用户");
					}else if(getCount(ids)>1){
						alert("请选择一条数据");
					}else{
						if (ids.indexOf(",")==0){
							ids=ids.substring(1);
						}
						show(ids);
						ids = "," +ids;
					}
			});
			
			$("#searchButton").click(function(){
				if ($(this).attr("class")=="button orange")
					$.dialog({id:'searchFunction',title:'查询用户',content: 'url:${ctx }/system/user_showSearch.do',cancelVal: '关闭',cancel: true,width: '500px',height: 300 });
			});
			
		
	});
	
		
		function deleteFromArray(arr, id) {
			var arrtemp = [];
			  var j=0;
			  for(var i=0;i<arr.length;i++){
			     if(arr[i] != id){
			         arrtemp[j] = arr[i];
			         j++;
			     }
			  }
			  return arrtemp;
		}
		
		function getCount(str){
			var strm = str.match(/,/g);
			if (strm)
				count = strm.length;
			else 
				count = 1;
		  	return count;
		}
	
	
		function show(id){
			$.dialog({id:'id',title:'密码初始化',content: 'url:${ctx }/system/user_setPwdRule.do?id='+id,cancelVal: '关闭',cancel: true,width: '600px',height: 300 });
		}
		function showEdit(id){
			$.dialog({id:'id',title:'用户编辑',content: 'url:${ctx }/system/user_update.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		
		function showAdd(id){
			$.dialog({id:'id',title:'添加用户',content: 'url:${ctx }/system/user_add.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		
		
	</script>
</my:head>
<body>
<div class="bodybox">
	   <div class="phead">
			<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="用户管理" enText="User Mgt"/> - <my:i18n zhText="用户列表" enText="The List Of Users"/> 
			</div>
			<div class="pheadbutton">
				   <input type="button" class="button orange"  value="<my:i18n zhText="审核" enText="Audit Users"/>"  id="AuditButton"/> 
				   <input type="button" class="button orange"  value="<my:i18n zhText="查询" enText="search"/>"  id="searchButton"/>
			</div>
			<div class="clear"></div>
		</div>
		<form action="${ctx }/system/user_list.do" method="post" id="userForm">
				<input type="hidden" name="id" value="${id }"/>
		           <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                	<th width="4%"><input type="checkbox" name="checkId" id="checkId" value=""></th>
			                  	<th width="4%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="10%"><my:i18n zhText="登录名" enText="User Login Name"/><my:order orderattr="user.chUserLogname"/></th>
			                	<th width="10%"><my:i18n zhText="姓名" enText="User Name"/><my:order orderattr="user.chUsername"/></th>
			                	<th width="25%"><my:i18n zhText="角色" enText="Role"/></th>
			                	<th width="10%"><my:i18n zhText="状态" enText="State"/><my:order orderattr="user.chUserState"/></th>
			                	<th width="10%"><my:i18n zhText="创建时间" enText="Create Time"/><my:order orderattr="user.chUserMaketime"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="7"><font color="red"><my:i18n zhText="当前没有用户" enText="No User List"/></font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="user" varStatus="status">
				              <tr id="${user.id }" param="ids=${user.id}">
									<td align="center">
										<input type="checkbox" id="ids" name="ids" value="${user.id}"/>
										<input type="hidden" id="roleID" name="roleID" value="${user.chRole.id}"/>
									</td>
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td align="center"><my:i18n zhText="${user.chUserLogname}" enText="${user.chUserLogname}"/></td>
									<td align="center"><my:i18n zhText="${user.chUsername}" enText="${user.chUsername}"/></td>
									<td class="roletd" align="center">
									   <c:if test="${user.chUserRoleids!=null}">
									   		<c:forEach items="${user.chRoles}" var="chRole" varStatus="status">
									       		<my:i18n zhText="${chRole.chRoleName}" enText="${chRole.chRoleName}"/>
									       	</c:forEach>
									   </c:if>
									</td>
									<td align="center"><my:i18n zhText="${user.chUserState}" enText="${user.chUserState}"/></td>
									<td align="center"><my:i18n zhText="${user.chUserMaketime}" enText="${user.chUserMaketime}"/></td>
				              </c:forEach>
			            </tbody>
		         </table>
		       <div class="ltablebottom">
		       		 <div style="float: left;">
			 	      	<input type="button" class="button orange"  value="<my:i18n zhText="添加用户" enText="Add A New User"/>" id="addnewButton"/>
			 	      	<input type="button" class="button orange"  value="<my:i18n zhText="编辑" enText="Edit"/>" id="editButton"/>
			 	      	<input type="button" class="button orange"  value="<my:i18n zhText="删除" enText="Delete"/>" id="batchDelete"/>
						<input type="button" class="button orange"  value="<my:i18n zhText="锁定" enText="Lock"/>" id="lockButton"/>
						<input type="button" class="button orange"  value="<my:i18n zhText="激活" enText="UnLock"/>" id="unLockButton"/>
						<input type="button" class="button orange"  value="<my:i18n zhText="密码初始化" enText="PWDInit"/>" id="PWDInitButton"/>
					</div>
			       <div class="lpage"><my:page page="${page}"/></div> 
			  </div>
			   
	       </form>
	       
	     <div id="menuContentDeptTree" class="menuContentDeptTree" style="display:none; position: absolute;">
			<ul id="deptTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:250px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
	    <div id="menuContentRoleTree" class="menuContentRoleTree" style="display:none; position: absolute;">
			<ul id="roleTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:150px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
</div>
</body>
</html>