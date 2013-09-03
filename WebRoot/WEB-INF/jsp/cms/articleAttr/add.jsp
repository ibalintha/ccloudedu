<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/main.css"/>
    <script src="${ctx}/js/jquery/jquery-1.8.0.min.js"></script>
	<script src="${ctx}/js/jquery/jquery.easyui.min_1.0.4.js"></script>
	<script src="${ctx }/js/util.js" type="text/javascript"></script>
	<script type="text/javascript">
	function submitForm(){
		submitFormByAjax("#articleAttrForm",function(){
	        return true;
		});
    }
	</script>
</head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：文章内容  - 内容属性  - 添加/修改</div>
	<div  class="pheadbutton" >
		<form action="${ctx}/cms/articleAttr_list.do" method="post">
			<input type="submit" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" />
		</form>
	</div>
	<div class="clear"></div>
</div>
  <div id="result" align="center" style="color: red;padding-top: 10px"></div>
<form method="post" action="cms/articleAttr_save.do" id="articleAttrForm">
    <input type="hidden" name="id" value="${id }">
	<table width="100%" class="ftable">
		<tr>
		  <td width="15%" ><font color="red">*</font>调用标识：</td>
		  <td colspan="1" width="35%">
		    <input type="text" maxlength="100" name="key" value="${key }" class="required" maxlength="100" align="left"/>
		  </td>
		</tr>
		<tr>
		 <td width="15%" ><font color="red">*</font>属性名称：</td>
		  <td colspan="1" width="35%">
		    <input type="text" maxlength="20" name="name" value="${name }" class="required" maxlength="20"/>
		  </td>
		</tr>
		<tr>
		  <td width="15%" >标题图宽度：</td>
		  <td colspan="1" width="35%">
		   <input type="text" maxlength="20" value="${imgWidth }" name="imgWidth" maxlength="20"/>
		  </td>
		  </tr>
		  <tr>
		  <td width="15%" >标题图高度：</td>
		  <td colspan="1" width="35%">
		    <input type="text" maxlength="20" value="${imgHeight }" name="imgHeight" maxlength="20"/>
		  </td>
		 </tr>
		 <tr>
		 <td width="15%" >是否有缩略图：</td>
		  <td colspan="1" width="35%">
			<input type="radio"  value="1" <c:if test="${empty isHasTitleimg || isHasTitleimg=='1'}">checked="checked"</c:if>  name="isHasTitleimg"/>
			<label for="display_0">是</label> 
			<input type="radio"  value="0" <c:if test="${isHasTitleimg=='0'}">checked="checked"</c:if> name="isHasTitleimg" />
			<label for="display_1">否</label>
		 </td>
	  </tr>
	   <tr>
		 <td width="15%" >是否使用：</td>
		 <td colspan="1" width="35%">
			<input type="radio"  value="1" <c:if test="${empty isDisabled || isDisabled=='1'}">checked="checked"</c:if>  name="isDisabled"/>
			<label for="display_0">是</label> 
			<input type="radio"  value="0" <c:if test="${isDisabled=='0'}">checked="checked"</c:if> name="isDisabled"/>
			<label for="display_1">否</label>
		 </td>
		 </tr>
	  <tr>
		<td colspan="4" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" onclick="submitForm()" class="submitForm"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>