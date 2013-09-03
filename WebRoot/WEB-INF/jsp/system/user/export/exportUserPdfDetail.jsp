<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link type="text/css" rel="stylesheet" href="js_css_image/css/pdf.css"/>
</head>
<body>
<div class="bodybox">
	 <table width="100%" class="ftable">
	           <tr>
	            <td colspan="5" style="padding-left: 20px"><b><my:i18n zhText="登录信息" enText="The Info Of Login"/></b></td>
	          </tr>
          <tr>
            <th width="12%">帐号：</th>
            <td colspan="4">${user.loginName}</td>
           </tr>
          <tr>
            <td colspan="5" style="padding-left: 20px"><b><my:i18n zhText="基本信息" enText="Basic Infomation"/></b></td>
          </tr>
          
           <tr>
            <th width="12%"><my:i18n zhText="中文姓名" enText="Chinese Name"/>：</th>
            <td>${user.userName}</td>
            <th width="12%"><my:i18n zhText="英文姓名" enText="English Name"/>：</th>
            <td>${user.enUserName}</td>
            <td width="20%" rowspan="6" align="left">
                <c:if test="${empty uploadFileList}">
			       <img src="js_css_image/images/nophoto.gif" width="130px" height="130px" border="0"/>
			    </c:if>
			    <c:forEach items="${uploadFileList}" var="upfile">
			      <img src="${upfile.uploadFilePath}" width="130px" height="130px" border="0"/>
			    </c:forEach>
            </td>
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