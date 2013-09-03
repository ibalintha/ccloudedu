<%@ page contentType="application/msword" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<%
	response.setHeader("Content-disposition","attachment; filename=" + java.net.URLEncoder.encode("系统用户列表.doc", "UTF-8"));
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"/>
<link type="text/css" href="js_css_image/css/main.css" rel="stylesheet" />
</head>
<body>
<div class="bodybox">
	 <table class="ltable" width="100%">
			            <thead class="ltablehead">
				             <tr>
				 				<th height="40" align="center" colspan="9">
				 					<h3><my:i18n zhText="用户列表" enText="The List Of Users"/></h3>
				 				</th>
				 			</tr>
			                <tr>
							    <th><my:i18n zhText="中文姓名" enText="Chinese Name"/></th>
							    <th><my:i18n zhText="英文姓名" enText="English Name"/></th>
							    <th><my:i18n zhText="出生日期" enText="Birthday"/></th>
							    <th width="5%"><my:i18n zhText="性别" enText="Gender"/></th>
							    <th><my:i18n zhText="办公电话" enText="Office Telephone"/></th>
							    <th><my:i18n zhText="手机" enText="Moblie Telephone"/></th>
							    <th width="18%"><my:i18n zhText="邮箱" enText="Email"/></th>
							    
							    <th><my:i18n zhText="部门" enText="Department"/></th>
							    <th><my:i18n zhText="角色" enText="Role"/></th>
							</tr>
			            </thead>
			            <tbody class="ltablebody">
				           <c:forEach items="${page.list}" var="user" varStatus="status">
				              <tr>
								<td>${user.userName}</td>
								<td>${user.enUserName}</td>
								<td>${user.birthday}</td>
								<td><my:view value="${user.sex}" pvalue="sex"/> </td>
								<td>${user.ophone}</td>
								<td>${user.mphone}</td>
								<td>${user.mailbox}</td>
								<td><my:i18n zhText="${user.sysDept.deptName}" enText="${user.sysDept.enDeptName}"/></td>
								<td>
									<c:if test="${user.sysRoles!=null}">
										<c:forEach items="${user.sysRoles}" var="role">
											<my:i18n zhText="${role.roleName}" enText="${role.enRoleName}"/><br/>
										</c:forEach>
									</c:if>
								</td>
							   </tr>
				              </c:forEach>
			            </tbody>
		         </table>
</div>
</body>
</html>