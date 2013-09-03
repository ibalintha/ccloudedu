<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
   <script type="text/javascript">
		var addordetail = true;
		var api = frameElement.api,W = api.opener;
		var tolisturl="${ctx}/system/user_list.do?roleId=${roleId}";
		$(function() {
			$("#submitBtn").submitForm({ 
				formId:"userForm",
				onComplete : function() {
					api.reload(W,tolisturl);
					api.close();
					window.location.href = tolisturl;
				}
			});
		});
	</script>
</my:head>
<body>
	<div class="bodybox">
			<div class="phead">
				<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 用户管理 - 密码初始化</div>
			</div>
		    <div id="result" align="center" style="color: red"></div>
			<form id="userForm" action="system/user_initPassword.do" method="post">
			   <input type="hidden" value="${id}" id="id" name="id"/>
			   <table width="100%" class="ftable">
			   <tr>
			   		<th width="30%"><font color="red"></font>密码生成规则：为密码的生成，提供统一的生成方式</th>
				   	<td>
				   		<table width="100%" class="ftable">
				   			<tr>
				   				<td>
									<input type="radio" name="setInitPwd" value = "0" checked="checked">采用固定方式<br>
				   				</td>
				   			</tr>
				   			<tr>
				   				<td>
				   					<input type="radio" name="setInitPwd" value = "1">以身份证后8位作为密码<br>
				   				</td>
				   			</tr>
				   			<tr>
				   				<td>
				   					<input type="radio" name="setInitPwd" value = "2">随机密码<br>
				   				</td>
				   			</tr>
				   			<tr>
				   				<td>
				   					<input type="radio" name="setInitPwd" value = "3">以登录账号作为密码<br>
				   				</td>
				   			</tr>
				   		</table>
				   	</td>
			   </tr>
	         	<tr>
				<td colspan="4" class="ftablebutton">
					<input type="button" class="button orange"  value="确定" id="submitBtn"/> &nbsp;
				</td>
		      </tr>
	        </table>
	        </form>
	</div>
</body>
</html>