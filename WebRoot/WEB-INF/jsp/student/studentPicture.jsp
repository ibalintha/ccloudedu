<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head multiFile="true">
	<script type="text/javascript">
		var addordetail = true;
		$(function(){
			$("#submitBtn").submitForm({ formId:"userForm"});
	       
		});
		 function deleteUploadFile(id){
		      if(confirm("您确定要删除吗")){
		          window.location.href="${ctx}/student/student_deleteUserPicture.do?pictureOnly=yes&uploadFileId="+id;
	          }
	     }
		 function chaKanYuanTu(imgSrc){
			 alert(imgSrc)
		 }
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 个人中心 - 图像照片</div>
	<div class="clear"></div>
</div>
<div id="result" align="center" style="color: red;"></div>
    <form method="post" action="${ctx}/student/student_uploadUserPicture.do" id="ufForm" enctype="multipart/form-data">
      <input type="hidden" name="user.id" value="${userSession.id }">
      <table width="100%" class="ftable"id="ftable">
      <tr>
		  <th width="15%" >上传照片：</th>
		  <td nowrap="nowrap">
		    <span><input type="file" class="multi" <c:if test="${!empty uploadFileList}">disabled="disabled"</c:if> id="upload" name="upload" size="30" maxlength="1" accept="gif|jpg|png|bmp|jpeg"/></span>
		  </td>
	  </tr>
	   <tr>
		  <th>查看：</th>
		  <td>
		    <c:if test="${empty uploadFileList}">
		       <img alt="照片" src="${ctx}/js_css_image/images/nophoto.gif" width="150px" height="150px" border="0">
		    </c:if>
		    <c:forEach items="${uploadFileList}" var="upfile">
		      <img alt="照片" src="${ctx}/${upfile.uploadFilePath}" width="150px" height="150px" border="0"/>
		      <a href="javascript:" title="删掉" onclick="deleteUploadFile('${upfile.id}')">[删除]</a>
		      <!--  &nbsp;<a href="javascript:" title="查看原图" onclick="chaKanYuanTu('${ctx}/${upfile.uploadFilePath}')">[查看原图]</a> -->
		    </c:forEach>
		  </td>
	  </tr>
	  <tr>
	    <th>注：</th>
		<td>
			建议上传150px*150px的照片，格式为：gif、jpg、png、bmp、jpeg
		</td>
	 </tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<input type="submit" class="button orange"  value="上传" id="submitBtn"/> 
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>