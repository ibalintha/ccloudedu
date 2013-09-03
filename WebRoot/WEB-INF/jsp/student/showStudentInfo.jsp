<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 个人信息</div>
    <div class="pheadbutton">
      <input type="button" class="button orange"  value="返回" name="ret" onclick="javascript:history.go(-1)"/>
    </div>
	<div class="clear"></div>
</div>
	<table width="100%" class="ftable">
          <tr>
            <td colspan="5" style="padding-left: 20px"><b>个人信息</b></td>
          </tr>
          <tr>
            <th>姓名：</th>
            <td>${user.userName}</td>
            <th><my:i18n zhText="性别" enText="Gender"/>：</th>
            <td><my:view value="${user.sex}" pvalue="sex"/></td>
            <td width="20%" rowspan="6" align="left" style="border: none;">
                <c:if test="${empty uploadFileList}">
			       <img alt="照片" src="${ctx}/js_css_image/images/nophoto.gif" width="160px" height="160px" border="0">
			    </c:if>
			    <c:forEach items="${uploadFileList}" var="upfile">
			      <img alt="照片" src="${ctx}/${upfile.uploadFilePath}" width="160px" height="160px" border="0">
			    </c:forEach>
            </td>
          </tr>
         
           <tr>
            <th ><my:i18n zhText="部门" enText="Deptment"/>：</th>
            <td>${user.sysDept.deptName}</td>
            <th ><my:i18n zhText="角色" enText="Role"/>：</th>
            <td>${roleNames} </td>
          </tr>
           <tr>
            <th >公司邮箱：</th>
            <td>${user.mailbox}</td>
            <th >入职时间：</th>
            <td>${user.registerTime}</td>
          </tr>
            <tr>
            <th >办公电话：</th>
            <td>${user.ophone}</td>
            <th >手机：</th>
            <td>${user.mphone}</td>
          </tr>
           <tr>
            <th >QQ：</th>
            <td>${user.qq}</td>
            <th >MSN：</th>
            <td>${user.msn}</td>
          </tr>
          <tr>
            <th >办公地点：</th>
            <td colspan="3">${user.workPlace}</td>
          </tr>
        </table>
    </div>
</body>
</html>