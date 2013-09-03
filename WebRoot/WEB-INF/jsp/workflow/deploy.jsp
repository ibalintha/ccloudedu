<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
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
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：流程部署</div>
	<div class="clear"></div>
</div>
<div id="result" align="center" style="color: red;"></div>
    <form method="post" action="${ctx}/workflow/deploy_deploy.do" id="ufForm" enctype="multipart/form-data">
      <table width="100%" class="ftable"id="ftable">
	  <tr>
		  <td width="12%" >流程zip包：</td>
		  <td>
		      <s:file name="upload"  cssClass="label" id="upload" size="40" ></s:file>
		  </td>
	  </tr>
	  <tr>
		  <td colspan="2"><s:actionmessage/> </td>
	  </tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<input type="submit" class="button orange" value="部署"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>