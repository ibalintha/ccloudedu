<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" datePicker="true">
	<script type="text/javascript">
	    var list=true;
	    var deleteurl = "${ctx }/system/button_delete.do";
	    var ids = "";
	    $(function() {
	    
	    var pheadbutton = "";
	  	var ltablebottom = "";
	  	<c:forEach items="${chRolebuttons}" var="roleButton">
	  		var name = "${roleButton.chRobuButton}";
	  		var id = "${roleButton.id}";
	  		var flag = "${roleButton.chRobuFlag}";
	  			
	  		var content;
	  		if (flag == "是"){
	  			content = "<input type='button' class='button orange'  id='${roleButton.chRobuId }' value='<my:i18n zhText='${roleButton.chRobuButton }' enText=''/>' />";
	  			if (name=="删除" || name=="批量删除" || name=="编辑" || name=="激活" || name=="锁定")
	  				ltablebottom += content;
	  			else
	  				pheadbutton += content;
	  		} else {
	  			content = "<input type='button' class='button grey'  id='${roleButton.chRobuId }' value='<my:i18n zhText='${roleButton.chRobuButton }' enText=''/>' />";
	  			if (name=="删除" || name=="批量删除" || name=="编辑" || name=="激活" || name=="锁定")
	  				ltablebottom += content;
	  			else
	  				pheadbutton += content;
	  		}
	  		</c:forEach>
	    	$(".pheadbutton").append(pheadbutton);
	  		$(".ltablebottom").append(ltablebottom);
	  		
	  		
	    	var roleName;
	    	var funcName;
	    	$("#searchButton").click(function(){
		    	roleName = $("#roleName").val();
		    	if (roleName == "")
		  			alert("请选择角色");
		  		else 
	    			$("#buttonForm").submit();
	    	});
	    	
	    	$("#roleName").bind('change',function(){
	    		addFuncContent($(this).val());
	    	});
	    	
	  		$(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});});
	  		
	  		$("#addButton").click(function(){
		  		if ($(this).attr("class")=="button orange") {
		  			roleName = $("#roleName").val();
		  			funcName = $("#funcName").val();
		  			if (roleName == "")
		  				alert("请选择角色");
		  			else 
		  				window.location.href="${ctx}/system/button_add.do?roleName="+roleName+"&funcName="+funcName;
		  		}
	  		});
	  		
	  		var id;
	  		$("input[name='ids']").bind("click", function(){
	  			ids += $(this).val();
	  			if ($(this).attr("checked") == "checked" && $("#unLockButton").attr("class") != "button grey" || $("#lockButton").attr("class") != "button grey"){
	  				id=$(this).val();
	  				var tr = $("tr").has($(this));
	  				var flag = $("td:eq(4)", $(tr)).html();
	  				if (flag == "是"){
	  					$("#unLockButton").attr("class", "button grey");
	  					$("#lockButton").attr("class", "button orange");
	  				} else {
	  					$("#unLockButton").attr("class", "button orange");
	  					$("#lockButton").attr("class", "button grey");
	  				}
	  			}
	  		});
	  		
	  		var roleName = $("#roleName").val();
			var funcName = $("#funcName").val();
	  		$("#lockButton").click(function(){
	  			if ($(this).attr("class")=="button orange") {
	  				
	  				window.location.href="${ctx}/system/button_update.do?id="+ids+"&roleName="+roleName+"&funcName="+funcName;
	  			}
	  		});
	  		
	  		$("#unLockButton").click(function(){
	  			if ($(this).attr("class")=="button orange") {
	  				window.location.href="${ctx}/system/button_update.do?id="+ids+"&roleName="+roleName+"&funcName="+funcName;
	  			}
	  		});
	  		
		});
				
		function addFuncContent(roleName) {
	        $.ajax({
				url: "${ctx}/system/button_funcList.do?roleName="+roleName,
				type: 'GET',
				dataType:"json",
				error: function(){
					alert("获取角色的权限范围失败");
				},
				success: function(data){
					$("#funcName").empty();
					var content = "";
					if(data!=null && data.length>0) {
		                for(var i=0; i<data.length; i++) {
		                   	var func = data[i];
		                    content += "<option value='"+func.chFuncName+"'>"+func.chFuncName+"</option>";
		                }
		                $("#funcName").append(content);
	            	}
				}
			});
   		}
	</script>
</my:head>
<body>
<div class="bodybox">
<form id="buttonForm" method="post" action="${ctx}/system/button_list.do">
<div class="phead">
	<my:i18n zhText="角色" enText="Role"/>：
		<select name="roleName" id="roleName">
			<option value="" selected="selected" >请选择角色</option>
			<c:forEach items="${roleList}" var="role">
				<c:choose>
					<c:when test="${roleName eq role.chRoleName}">
						<option value="${role.chRoleName}" selected="selected" >${role.chRoleName}</option>
					</c:when>
					<c:otherwise>
						<option value="${role.chRoleName }">${role.chRoleName }</option>
					</c:otherwise>
				</c:choose>	
			</c:forEach>
		</select>
	<my:i18n zhText="菜单" enText="Function"/>：
		<select name="funcName" id="funcName">
			<option value="" selected="selected" >请选择菜单</option>
			<c:if test="${empty funcList}">
				<option value="">此角色没有功能菜单</option>
			</c:if>
			<c:forEach items="${funcList}" var="func">
				<c:choose>
					<c:when test="${funcName eq func.chFuncName}">
						<option value="${func.chFuncName}" selected="selected" >${func.chFuncName}</option>
					</c:when>
					<c:otherwise>
						<option value="${func.chFuncName }">${func.chFuncName }</option>
					</c:otherwise>
				</c:choose>	
			</c:forEach>
		</select>
	<div class="pheadbutton">
	</div>
	<div class="clear"></div>
</div>

   <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="5%"><input type="checkbox" name="checkId" id="checkId" value=""></th>
		<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
		<th width="40%">按钮名称</th>
		<th width="40%">按钮id</th>
		<th width="10%">按钮是否可用</th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td align="center" colspan="5"><font color="red"><my:i18n zhText="当前角色的菜单没有功能按钮" enText="There are no Button"/></font></td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="button" varStatus="status">
		  <tr id="${button.id }">
		  		<td align="center"><input type="checkbox" name="ids" value="${button.id}"/></td>
				<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td align="center">${button.chRobuButton }</td>
				<td align="center">${button.chRobuId }</td>
				<td align="center" id="buttonFlag">${button.chRobuFlag }</td>
		  </tr>
		</c:forEach>
	</tbody>
</table>

<div class="ltablebottom"><div style="float: left;"><input type="button" class="button orange"  value="<my:i18n zhText="删除" enText="Batch Delete"/>" id="batchDelete"/></div></div>
</form>
</div>
</body>
</html>