<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<script type="text/javascript">
		var addordetail = true;
		var tolisturl = "${ctx}/cms/article_list.do?channelId=${channel.id}";
		$(function() {
			$(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});});
			var isDraft = "${isDraft}";
			if(isDraft==""){
				$(":radio[value='1']").attr("checked","checked");
			}
		});
		function submitForm(){
			submitFormByAjax("#articleForm",function(){
				
		        return true;
			});
	    }
		 function deleteUploadFile(id){
		        if(confirm("您确定要删除吗")){
		        	 var url = "${ctx}/cms/article_deleteUploadFile.do?articleId="+id;
		             jQuery.post(url,function(data){
		           	   if (data=='0'){
		   				   alert("删除成功");
		   				   $("#contentImgTr2").hide();
		   				   $("#contentImgTr1").show();
		   			    } else {
		   				   alert("对不起，删除失败");
		   			    }
		             });
	           }
	        }
	</script>
</head>
<body>
<div>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 文章系统 - 文章内容  - 添加/修改</div>
	<div class="pheadbutton" >
		   <input type="button" class="button orange"  value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div>
	<div class="clear"></div>
</div>
  <div id="result" align="center" style="color: red;padding-top: 10px"></div>
<form method="post" action="cms/article_save.do" id="articleForm" enctype="multipart/form-data">
     <input type="hidden" name="articleId" value="${articleId}">
     <input type="hidden" name="channelId" value="${channel.id}">
     <input type="hidden" name="filePath" value='uploadfile/cms/content/${channel.path}'/>
  	 <table width="100%" class="ftable">
		<tr>
		  <td width="10%" >所属栏目：</td>
		  <td colspan="3" width="35%">
		    ${channel.channelName }
		  </td>
		</tr>
		<tr>
		  <td width="10%" ><font color="red">*</font>标题：</td>
		  <td>
		    <input type="text" name="title" value="${title }" class="required" maxlength="100" align="left"/>
		  </td>
		   <td width="10%" >来源：</td>
		 <td width="35%">
			 <input type="text" name="origin" value="${origin }" maxlength="100" align="left"/>
		 </td>
		</tr>
		 <tr>
		  <td width="10%" >作者：</td>
		  <td colspan="1" width="35%">
		      <input type="text" name=author value="${author }" maxlength="100" align="left"/>
		  </td>
		  <td width="10%" >发布时间：</td>
		  <td colspan="1" width="35%">
		    <input type="text" name="releaseDate" value="${releaseDate }" maxlength="100" align="left" class="Wdate" readonly="readonly"/>
		  </td>
		</tr>
		 <tr>
		  <td width="10%" >是否草稿：</td>
		  <td colspan="3" width="35%">
		    <my:radio pvalue="yesornot" name="isDraft" value="${isDraft}"/>
		  </td>
		</tr>
		<tr id="contentImgTr1" <c:if test="${!empty ContentImg}"> style="display: none" </c:if>>
			  <td width="10%" >上传图片： </td>
			  <td colspan="3" width="35%">
			    <s:file name="upload"  cssClass="multi" label="输入要上传的文档" id="upload" size="40" maxlength="1" accept="gif|jpg|png|bmp|jpeg"></s:file>
			  </td>
		</tr>
		<c:if test="${!empty ContentImg}">
			<tr id="contentImgTr2">
			 <td width="10%" >已上传的图片： </td>
		     <td colspan="3" width="35%">
			    <img alt="图片" src="${ctx }/${contentImg}" width="150px" height="150px"></img>
		  	    <a href="javascript:" title="删掉" onclick="deleteUploadFile('${id}')"><img alt="删除" src="${ctx}/js_css_image/images/deletefile.gif"> </a>
		  	</td>
			</tr>
		</c:if>
	  <tr>
		<td colspan="4" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" onclick="submitForm()" class="submitForm"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</div>
</body>
</html>