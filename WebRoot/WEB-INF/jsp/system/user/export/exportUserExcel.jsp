<%@ page contentType="application/msexcel" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<%
	response.setHeader("Content-disposition","attachment; filename=" + java.net.URLEncoder.encode("系统用户.xls", "UTF-8"));
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>"/>
<link type="text/css" href="js_css_image/css/main.css" rel="stylesheet" />
</head>
<body>
<div class="bodybox">
	  <table style="text-align:center;" width="100%" cellspacing="1" cellpadding="0" border="1">
			            <thead class="ltablehead">
				             <tr>
				 				<th height="40" align="center" colspan="5">
				 					<h3>系统<my:i18n zhText="用户列表" enText="The List Of Users"/></h3>
				 				</th>
				 			</tr>
			                <tr>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                	<th>用户姓名</th>
			                	<th><my:i18n zhText="性别" enText="Gender"/></th>
			                	<th><my:i18n zhText="部门" enText="Deptment"/></th>
			                	<th><my:i18n zhText="角色" enText="Role"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				           <c:forEach items="${page.list}" var="user" varStatus="status">
				              <tr id="${id }">
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td align="center">${user.userName}</td>
									<td align="center">${user.tempSex }</td>
									<td align="center">${user.sysDept.deptName }</td>
									<td align="center">
									   <c:if test="${user.sysRoles!=null}">
									       <c:forEach items="${user.sysRoles}" var="role">
									          ${role.roleName}&nbsp;
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