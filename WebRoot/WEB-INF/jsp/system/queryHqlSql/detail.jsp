<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true" multiFile="true">

</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：sql/hql语句管理 - <my:position value="${id}"/></div>
	<div class="clear"></div>
</div>
<table width="100%" class="ftable"id="ftable">
	  <tr>
		  <th width="13%"><font color="red">*</font>查询名称：</th>
		  <td>${queryName}</td>
	  </tr>
	  <tr>
		  <th>描述/说明：</th>
		  <td>${description}</td>
	  </tr>
	  <tr>
		  <th>hql/sql语句：</th>
		  <td><pre>${sqlHql}</pre></td>
	  </tr>
	 
</table>
</div>
</body>
</html>