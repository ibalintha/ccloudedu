<%@ page contentType="application/msword" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<%
	response.setHeader("Content-disposition","attachment; filename=" + java.net.URLEncoder.encode("系统用户信息.doc", "UTF-8"));
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
	 <table width="100%" class="ftable">
	           <tr>
	            <td colspan="4" style="padding-left: 20px"><b><my:i18n zhText="登录信息" enText="The Info Of Login"/></b></td>
	          </tr>
          <tr>
            <th width="12%">帐号：</th>
            <td colspan="3">${user.loginName}</td>
           </tr>
          <tr>
            <td colspan="4" style="padding-left: 20px"><b><my:i18n zhText="基本信息" enText="Basic Infomation"/></b></td>
          </tr>
          
           <tr>
            <th width="12%"><my:i18n zhText="中文姓名" enText="Chinese Name"/>：</th>
            <td>${user.userName}</td>
            <th width="12%"><my:i18n zhText="英文姓名" enText="English Name"/>：</th>
            <td>${user.enUserName}</td>
          </tr>
           <tr>
            <th ><my:i18n zhText="出生日期" enText="Birthday"/>：</th>
            <td>${user.birthday}</td>
            <th ><my:i18n zhText="性别" enText="Gender"/>：</th>
            <td><my:view pvalue="sex"value="${user.sex}"/></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="部门" enText="Deptment"/>：</th>
            <td><my:i18n zhText="${user.sysDept.deptName}" enText="${user.sysDept.enDeptName}"/> </td>
            <th ><my:i18n zhText="角色" enText="Role"/>：</th>
            <td><my:i18n zhText="${roleNames}" enText="${enRoleNames}"/> </td>
          </tr>
           <tr>
            <th ><my:i18n zhText="办公电话" enText="Office Telephone"/>：</th>
            <td>${user.ophone}</td>
            <th ><my:i18n zhText="手机" enText="Moblie Telephone"/>：</th>
            <td>${user.mphone}</td>
          </tr>
           <tr>
            <th ><my:i18n zhText="邮箱" enText="Email"/>：</th>
            <td>${user.mailbox}</td>
            <th >入职时间：</th>
            <td>${user.registerTime}</td>
          </tr>
          <tr>
            <th >办公地点：</th>
            <td colspan="3">${user.workPlace} </td>
          </tr>
        </table>
       
    </div>
</body>
</html>