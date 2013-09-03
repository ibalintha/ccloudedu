<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head multiFile="true">
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener;
        $(function() {
			$("#submitBtn").submitForm({ 
				formId:"form",
				onComplete:function(){
				    W.reload();
				    api.close();
				}
			});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：导入部门</div>
	<div class="clear"></div>
</div>
<div id="result" align="center" style="color: red;"></div>
    <form method="post" action="${ctx }/system/dept_importExcel.do" id="form" enctype="multipart/form-data">
     <table width="100%" class="ftable">
	  <tr>
		  <th width="20%">excel文件：</th>
		  <td><input type="file" id="upload" name="upload" size="50" value="" class="multi" maxlength="1" accept="xls|xlsx"/></td>
	  </tr>
	  <tr>
		  <th><my:i18n zhText="部门" enText="Deptment"/>模板：</th>
		  <td><a href="${ctx }/system/dept_download.do">点击下载</a></td>
	  </tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<input type="submit" class="button orange" value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>