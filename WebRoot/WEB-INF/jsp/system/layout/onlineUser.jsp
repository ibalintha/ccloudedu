<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
   <script type="text/javascript">
		var list=true;
		var api = frameElement.api, W = api.opener;
		function showUserInfo(userId){
			var url = '${ctx }/system/user_showUserInfo.do?id='+userId;
			W.$.dialog({title:'查看用户',content: 'url:'+url,cancelVal: '关闭',cancel: true,width: '600px',height: 400});
		}
		$(function(){
			$(".roletd").each(function(){
				var t = $.trim($(this).text());
				$(this).html(t.substring(0,t.length-1));
			});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 在线用户- 列表 </div>
	<div class="pheadbutton">
    	<!-- <input type="button" class="button orange"  value="关闭" name="closePopup" id="closePopup" /> -->
	</div>
	<div class="clear"></div>
</div>
    <form action="${ctx }/system/layout_listOnlineUser.do" method="post" id="userForm">
		<table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                    <th width="8%"><my:i18n zhText="序号" enText="No."/></th>
			                	<th><my:i18n zhText="用户姓名" enText="User Name"/></th>
			                	<th><my:i18n zhText="部门" enText="Department"/></th>
			                	<th><my:i18n zhText="角色" enText="Role"/></th>
			                	<th width="20%"><my:i18n zhText="操作" enText="Action"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				           <c:forEach items="${page.list}" var="user" varStatus="status">
								<tr>
								    <td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td><my:i18n zhText="${user.userName}" enText="${user.enUserName}"/></td>
									<td><my:i18n zhText="${user.sysDept.deptName}" enText="${user.sysDept.enDeptName}"/></td>
									<td class="roletd">
									   <c:if test="${user.sysRoles!=null}">
									       <c:forEach items="${user.sysRoles}" var="role" varStatus="status2" ><my:i18n zhText="${role.roleName}" enText="${role.enRoleName}"/>,</c:forEach>
									   </c:if>
									</td>
									<td>
									<a href="${ctx }/oa/intenalMassage_add.do?receiverId=${user.id}&openInPopup=1">发送短信</a>
									&nbsp;
									<a href="${ctx }/system/user_showUserInfo.do?id=${user.id}">查看个人信息</a>
									</td>
								</tr>
			             </c:forEach>
			            </tbody>
		         </table>
		      </form>
        </div>
	</body>
</html>