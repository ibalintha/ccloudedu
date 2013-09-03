<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true" multiFile="true">
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener;
        var addordetail = true;
        $(function() {
			 $(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:"yyyy-MM-dd"});});
			 $("#submitBtn").submitForm({ 
				 formId:"projectForm",
				 onComplete:function(){
				     W.reloadProject();
				     api.close();
				 }
			  });
		});
        function deleteUploadFile(id){
		      if(confirm("删除将不可恢复，您确定要删除吗")){
		    	  $.post("${ctx}/oa/project_deleteUploadFileByAjax.do",{"uploadFileId":id},
		    		     function(ret){
		    		    	 if(ret.code=="0"){
		    		    		 alert("文档删除成功");
		    		    		 $("#"+id+"span").remove();
		    		    	 }
		    		     }
		    	   )
	          }
	     }
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:position value="${id}"/>项目</div>
	<div class="clear"></div>
</div>
<form method="post" action="${ctx }/oa/project_save.do" id="projectForm" enctype="multipart/form-data">
      <input type="hidden" value="${id}" id="id" name="id"/>
      <table width="100%" class="ftable"id="ftable">
      <tr>
		  <th width="15%"><font color="red">*</font>项目编号：</th>
		  <td>
		    <input type="text" name="projectCode" size="40" value="${projectCode }" rules="[{notNull:true, message:'项目编号不能为空'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th width="12%"><font color="red">*</font>项目名称：</th>
		  <td>
		    <input type="text" name="projectName" size="40" value="${projectName }" rules="[{notNull:true, message:'项目名称不能为空'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th><font color="red">*</font>重要程度：</th>
		  <td>
		    <my:select pvalue="projectimportant" name="urgencyDegree" value="${urgencyDegree}" rules="[{notNull:true, message:'请选择重要程度'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th ><font color="red">*</font>项目描述：</th>
		  <td>
		    <textarea name="projectDesc" style="width: 500px;height: 120px" rules="[{notNull:true, message:'项目描述不能为空'}]">${projectDesc}</textarea>
		  </td>
		</tr>
		<tr>
		  <th><font color="red">*</font>项目日期：</th>
		  <td>
		    <input type="text" name="createTime" value="${createTime }" class="Wdate" readonly="readonly" rules="[{notNull:true, message:'请选择项目日期'}]"/>
		  </td>
	  </tr>
		<tr>
		  <th>项目文档：</th>
		  <td >
		    <input type="file" name="upload" size="40" value="" id="upload" class="multi"/>
		    <c:forEach items="${uploadFileList}" var="upfile">
		        <span id="${upfile.id}span">
		            <a href="${ctx}/oa/project_download.do?id=${id}&uploadFileId=${upfile.id}" title="下载">${upfile.uploadFileName }[${upfile.uploadFileSize}]</a>
		            <a href="javascript:" title="删掉" onclick="deleteUploadFile('${upfile.id}')">[删除]</a>
		            <br/>
		         </span>
		     </c:forEach>
		  </td>
	  </tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
			<input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>