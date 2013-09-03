<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" tree3="true">

   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<script type="text/javascript">
		var list=true;

		
		var deleteAndRemoveTreeNode=true;
		var deleteurl = "${ctx }/system/role_delete.do";
		$(function() {
			var id = "";
			$(".ltable tr").dblclick(function(){
				id = $(this).attr("id");
				$.dialog({id:'editFunction',title:'编辑角色',content: 'url:${ctx }/system/role_update.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 400
				 ,close: function(event, ui) {
							        var sendValue=eval($('#testFrame').val());
									if(sendValue!=null){
							        	var roleId=sendValue.roleId;
							        	var tr =$("tr[id="+roleId+"]");
							        	$("td:eq(2)", $(tr)).html(sendValue.roleName);
							        	$("td:eq(3)", $(tr)).html(sendValue.authorityModel);
							        	$("td:eq(4)", $(tr)).html(sendValue.roleFlag);
							        	$("td:eq(5)", $(tr)).html(sendValue.roleDesc);
							        }
				} });
			});
			
			var idsArray = new Array();
			var ids = "";
			var msg="";
	  		$("input[name='ids']").bind("click", function(){
	  			if ($(this).attr("checked") == "checked" ) {
	  				ids += "," + $(this).val();
	  			} else {
	  				if(ids!=""){
	  					idsArray = ids.split(",");
	  					idsArray = deleteFromArray(idsArray,$(this).val());
	  					ids = idsArray.join(",");
	  				}
	  			}
	  			//ids = ids.substring(1);
	  		});
	  		
	  		
	  			
	  		
	  		$("#lockButton").click(function(){
				if ($(this).attr("class")=="button orange") {
					if(ids=="")
						alert("请选择需要锁定的数据");
					else {
						if (ids.indexOf(",")>0)
							alert("请选择一条数据");
						else {
							if (ids.indexOf(",")==0)
								ids=ids.substring(1);									
		  					var flag = $("td:eq(4)", $("tr[id='"+ids+"']")).html();
		  					if (flag == "Y")
								window.location.href="${ctx}/system/role_changeRoleState.do?ids="+ids;
							else
								alert("选择当前行时此按钮不可用");
							ids = "," +ids;
						}
					}
				}
			});
			
			$("#unLockButton").click(function(){
				if ($(this).attr("class")=="button orange")
					if(ids=="")
						alert("请选择需要解锁的数据");
					else {
						if (getCount(ids)>1)
							alert("请选择一条数据");
						else {
							if (ids.indexOf(",")==0)
								ids=ids.substring(1);
									
		  					var flag = $("td:eq(4)", $("tr[id='"+ids+"']")).html();
		  					if (flag == "N")
								window.location.href="${ctx}/system/role_changeRoleState.do?ids="+ids;
							else
								alert("选择当前行时此按钮不可用");
							ids = "," +ids;
						}
					}
			});
			
			$("#editButton").click(function(){
				if ($(this).attr("class")=="button orange") {
					if(ids=="")
						alert("请选择需要编辑的数据");
					else {
						if (getCount(ids)>1)
							alert("请选择一条数据");
						else {
							if (ids.indexOf(",")==0)
								ids=ids.substring(1);
							$.dialog(
							{id:'editFunction',title:'编辑角色',content: 'url:${ctx }/system/role_update.do?id='+ids,cancelVal: '关闭',cancel: true,width: '900px',height: 400 
							  ,close: function(event, ui) {
							        var sendValue=eval($('#testFrame').val());
									if(sendValue!=null){
							        	var roleId=sendValue.roleId;
							        	var tr =$("tr[id="+roleId+"]");
							        	$("td:eq(2)", $(tr)).html(sendValue.roleName);
							        	$("td:eq(3)", $(tr)).html(sendValue.authorityModel);
							        	$("td:eq(4)", $(tr)).html(sendValue.roleFlag);
							        	$("td:eq(5)", $(tr)).html(sendValue.roleDesc);
							        }
							   }
							});
							ids = "," +ids;
						}
					}
				}
			});
			
			$("#addButton").click(function(){
				var id = $("input[name='id']").val();
				if ($(this).attr("class")=="button orange")
					$.dialog({id:'addFunction',title:'新增角色',content: 'url:${ctx }/system/role_add.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 400 });
			});
			
			$("#searchButton").click(function(){
				if ($(this).attr("class")=="button orange")
					$.dialog({id:'searchFunction',title:'查询角色',content: 'url:${ctx }/system/role_showSearch.do',cancelVal: '关闭',cancel: true,width: '500px',height: 300 });
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
			$.dialog({id:'showFunction',title:'查看角色权限',content: 'url:${ctx }/system/role_showFunc.do?id='+id,cancelVal: '关闭',cancel: true,width: '500px',height: 300 });
		}
	</script>
</my:head>
<body>
<div class="bodybox">
		
		<div class="phead">
		<div class="pheadbutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="新增" enText="Batch Delete"/>" id="addButton"/>
			<input type="button" class="button orange"  value="<my:i18n zhText="查询" enText="Batch Delete"/>" id="searchButton"/>
		</div></div>
		<!--<c:if test="${!empty actionMessages}">
		       <div id="result" align="center" style="color: red;height: 16px;padding-top: 9px"></div>
		    </c:if>-->
		    <form action="${ctx }/system/role_list.do" method="post" id="roleForm">
		          <input type="hidden" name="id" value="${id }"/>
		          <table class="ltable" width="100%">
			        <thead class="ltablehead">
			                <tr>
			                	<th width="5%"><input type="checkbox" name="checkId" id="checkId" value=""></th>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                	<th><my:i18n zhText="角色名称" enText="Role Name"/><my:order orderattr="role.chRoleName"/></th>
			                	<th><my:i18n zhText="授权模型" enText="Role Model"/><my:order orderattr="role.chRoleModel"/></th>
			                	<th><my:i18n zhText="是否激活" enText="Role Flag"/><my:order orderattr="role.chRoleFlag"/></th>
			                	<th><my:i18n zhText="描述" enText="Role Description"/><my:order orderattr="role.chRoleDesc"/></th>
			                	<%--<th><my:i18n zhText="备注" enText="Remark"/></th> --%>
			                </tr>
			            </thead>
			             <tbody class="ltablebody">
			            <c:if test="${empty page.list}">
				            <tr>
								<td align="center" colspan="7"><font color="red"><my:i18n zhText="当前角色没有下级角色" enText="There are no Sub Roles"/></font> </td>
						    </tr>
			           </c:if>
			           <c:forEach items="${page.list}" var="role" varStatus="status">
			               <tr id="${role.id }">
								<td align="center"><input type="checkbox" name="ids" id="ids" value="${role.id}"/></td>
								<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
								<td>
								 <my:i18n zhText="${role.chRoleName}" enText="${role.chRoleName}"/>
								</td>
								<td><my:i18n zhText="${role.chRoleModelName}" enText="${role.chRoleModelName}"/></td>
								<td><my:i18n zhText="${role.chRoleFlag}" enText="${role.chRoleFlag}"/></td>
								<td><my:i18n zhText="${role.chRoleDesc}" enText="${role.chRoleDesc}"/></td>
							</tr>
			           </c:forEach>
		             </tbody>
		         </table>
	        <div class="ltablebottom">
	 	      <div style="float: left;">
	 	      	<input type="button" class="button orange"  value="<my:i18n zhText="编辑" enText="Batch Delete"/>" id="editButton"/>
	 	      	<input type="button" class="button orange"  value="<my:i18n zhText="删除" enText="Batch Delete"/>" id="batchDelete"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="锁定" enText="Batch Delete"/>" id="lockButton"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="激活" enText="Batch Delete"/>" id="unLockButton"/>
				</div>
			  <div class="lpage"><my:page page="${page}"/></div>  
		    </div>
	       </form>
	       <input id="testFrame" type="hidden"/>
	    </div>
	 </body>
</html>