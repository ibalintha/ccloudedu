<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/main.css"  media="screen"/>
    <script src="${ctx}/js/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="${ctx}/js/jquery/jquery.easyui.min_1.0.4.js" type="text/javascript"></script>
	<script src="${ctx }/js/util.js" type="text/javascript"></script>
	<script type="text/javascript">
	var addordetail = true;
	var tolisturl = "${ctx}/system/uploadfile_list.do";
	function submitForm(){
		submitFormByAjax("#ufForm",function(){
	        return true;
		});
    }
	</script>
</head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：图片管理  - 上传图片</div>
    <div class="pheadbutton">
     <input type="button" class="button orange"  value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" name="tolistButton" id="tolistButton"/>
    </div>
	<div class="clear"></div>
</div>
<div id="result" align="center" style="color: red;"></div>
    <form method="post" action="${ctx}/system/uploadfile_upload.do" id="ufForm" enctype="multipart/form-data">
      <table width="100%" class="ftable"id="ftable">
      <tr>
		  <td width="12%" >图片：</td>
		  <td>
		    <s:file name="upload" label="输入要上传的文件"></s:file>
		  </td>
		 </tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" onclick="submitForm()" class="submitForm"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>