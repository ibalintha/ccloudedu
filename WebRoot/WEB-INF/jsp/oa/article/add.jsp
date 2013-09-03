<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head fck="true" datePicker="true" multiFile="true">
	<script type="text/javascript">
		var addordetail = true;
		var tolisturl = "${ctx}/oa/article_list.do?categoryValue=${categoryValue}";
		$(function() {
			$(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});});
			if("${isDraft}"==""){$(":radio[value='N']").attr("checked","checked");}
			$("#submitBtn").submitForm({
				formId:"articleForm",
				onComplete:function(){
				    window.location.href = tolisturl;
				}
			});
			$("#tolistButton").click(function(){window.location.href=tolisturl;});
		});
		
		 function deleteUploadFile(uploadFileId,id){
		        if(confirm($.i18n("deleteConfrimMsg"))){
		        	 var url = "${ctx}/oa/article_deleteImg.do?uploadFileId="+uploadFileId+"&id="+id;
		             jQuery.post(url,function(data){
		           	   if (data=='0'){
		   				   alert($.i18n("deleteSuccessMsg"));
		   				   $("#contentImgTr2").hide();
		   				   $("#contentImgTr1").show();
		   			    } else {
		   				   alert($.i18n("deleteFailMsg"));
		   			    }
		             });
	           }
	        }
	</script>
</my:head>
<body>
<div>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：<my:i18n zhText="文章内容" enText="Article Content"/>  - <my:position value="${id}"/> </div>
	<div class="pheadbutton" >
		   <input type="button" class="button orange"  value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div>
	<div class="clear"></div>
</div>
  <div id="result" align="center" style="color: red;padding-top: 10px"></div>
<form method="post" action="oa/article_save.do" id="articleForm" enctype="multipart/form-data">
     <input type="hidden" name="id" value="${id}">
     <input type="hidden" name="categoryValue" value="${categoryValue}">
     <input type="hidden" name="filePath" value='uploadfile/oa/content/${categoryValue}'/>
  	 <table width="100%" class="ftable">
		<tr>
		  <th width="14%"><my:i18n zhText="信息类别" enText="Info Category"/>：</th>
		  <td>
		     <my:view value="${categoryValue}" pvalue="oaarticle"/>
		  </td>
		</tr>
		
		<tr>
		  <th><my:i18n zhText="中文标题" enText="Chinese Title"/>：</th>
		  <td>
		    <input type="text" name="title" value="${title }" class="required" maxlength="100" align="left" size="60"/>
		    &nbsp;<my:i18n zhText="标题颜色" enText="Title Color"/>
		    <select name="titleColor"  onchange="this.blur();">
				<option value="">--<my:i18n zhText="默认" enText="Default Color"/>--</option>
				<%--<option value="#FFFFFF" style="background-color:#FFFFFF"></option> --%>
				<option value="#FF0000" style="background-color:#FF0000;" <c:if test="${titleColor=='#FF0000'}">selected="selected"</c:if>></option>
				<option value="#FFFF00" style="background-color:#FFFF00" <c:if test="${titleColor=='#FFFF00'}">selected="selected"</c:if>></option>
				<option value="#00FF00" style="background-color:#00FF00" <c:if test="${titleColor=='#00FF00'}">selected="selected"</c:if>></option>
				<option value="#00FFFF" style="background-color:#00FFFF" <c:if test="${titleColor=='#00FFFF'}">selected="selected"</c:if>></option>
				<option value="#0000FF" style="background-color:#0000FF" <c:if test="${titleColor=='#0000FF'}">selected="selected"</c:if>></option>
				<option value="#FF00FF" style="background-color:#FF00FF" <c:if test="${titleColor=='#FF00FF'}">selected="selected"</c:if>></option>
				<option value="#808080" style="background-color:#808080" <c:if test="${titleColor=='#808080'}">selected="selected"</c:if>></option>
				<option value="#C0C0C0" style="background-color:#C0C0C0" <c:if test="${titleColor=='#C0C0C0'}">selected="selected"</c:if>></option>
				<option value="#800000" style="background-color:#800000" <c:if test="${titleColor=='#800000'}">selected="selected"</c:if>></option>
				<option value="#808000" style="background-color:#808000" <c:if test="${titleColor=='#808000'}">selected="selected"</c:if>></option>
				<option value="#008000" style="background-color:#008000" <c:if test="${titleColor=='#008000'}">selected="selected"</c:if>></option>
				<option value="#008080" style="background-color:#008080" <c:if test="${titleColor=='#008080'}">selected="selected"</c:if>></option>
				<option value="#000080" style="background-color:#000080" <c:if test="${titleColor=='#000080'}">selected="selected"</c:if>></option>
				<option value="#800080" style="background-color:#800080" <c:if test="${titleColor=='#800080'}">selected="selected"</c:if>></option>
				<option value="#000000" style="background-color:#000000" <c:if test="${titleColor=='#000000'}">selected="selected"</c:if>></option>
             </select>
             <!-- <input type="checkbox" value="1" id="isBold" name="isBold" <c:if test="${isBold=='1'}">checked="checked"</c:if>/>加粗 -->
		  </td>
		 </tr>
		 <tr>
		  <th><my:i18n zhText="英文标题" enText="English Title"/>：</th>
		  <td>
		    <input type="text" name="enTitle" value='${enTitle }' class="required" maxlength="100" align="left" size="60"/>
		  </td>
		 </tr>
		<tr>
		   <th><my:i18n zhText="来源" enText="Info Origin"/>：</th>
		   <td>
			 <input type="text" name="origin" value="${origin }" maxlength="100" align="left" size="60"/>
		   </td>
		</tr>
		<tr>
		 <th><my:i18n zhText="摘要" enText="Description"/>：</th>
		 <td>
			 <input type="text" name="description" value="${description }" maxlength="100" align="left" size="60"/>
		 </td>
		</tr>
		 <tr>
		  <%--<th>作者：</th>
		  <td colspan="1" width="35%">
		      <input type="text" name=author value="${author }" maxlength="100" align="left"/>
		  </td> --%>
		  <th><my:i18n zhText="是否草稿" enText="Is Draft"/>：</th>
		  <td >
		    <my:radio pvalue="yesornot" name="isDraft" value="${isDraft}"/>
		  </td>
		  <%--<th>发布时间：</th>
		  <td colspan="1" width="35%">
		    <input type="text" name="releaseDate" value="${releaseDate }" maxlength="100" align="left" class="Wdate" readonly="readonly"/>
		  </td> --%>
		</tr>
		<!-- 
		
	   <tr>
		 <td>简短标题：</td>
		 <td>
			 <input type="text" name="shortTitle" value="${shortTitle }" maxlength="100" align="left"/>
			 <span class="fhelp">在文章列表中显示，不填写则显示完整标题</span>
		 </td>
		</tr>

		
		<tr>
		 <td>tag标签：</td>
		 <td>
			 <input type="text" name="tags" value="${tags }" maxlength="100" align="left"/>
			 <span class="fhelp">关键字，用“,”分割</span>
		 </td>
		</tr>
		<tr>
		 <td>相关文章：</td>
		 <td>
			 <input type="text" name="relatedIds" value="${relatedIds }" maxlength="100" align="left"/>
			 <span class="fhelp">填写文章ID，多篇文章用,分割</span>
		 </td>
		</tr>
		 -->
		 <!-- 
		<tr>
		  <td>指定模板：</td>
		  <td>
			  <select name="tplContent"/>
				<option value="" selected="selected">使用栏目选择的模板</option>
				<c:forEach var="oaTemplet" items="${channel.oaTemplets}">
				      <option value="${oaTemplet.templetPath }${oaTemplet.templetFileName}">${oaTemplet.templetPath }${oaTemplet.templetFileName}</option>
				</c:forEach>
			</select>
		  </td>
		 
		    <td>置顶级别：</td>
		    <td colspan="1">
		     <select name="topLevel"/>
			     <option value="0"></option>
			     <option value="24">置顶一天</option>
			     <option value="48">置顶二天</option>
			     <option value="72">置顶三天</option>
			     <option value="168">置顶一周</option>
			     <option value="720">置顶一月</option>
			     <option value="2160">置顶三月</option>
			     <option value="4320">置顶半年</option>
			     <option value="8760">置顶一年</option>
		     </select>
		    </td>
		  
		</tr>
		 -->
		<!-- 
		<tr>
		  <td>阅读权限：</td>
		  <td colspan="1">
			 <input type="radio" value="0" checked="checked" name="isReject"/>不受限制
		     <input type="radio" value="1" name="isReject"/>普通会员
		  </td>
		  <td>允许评论：</td>
		  <td colspan="1">
		     <input type="radio" value="1" checked="checked" name="isAllowComment"/>是
		     <input type="radio" value="0" name="isAllowComment"/>否
		  </td>
		</tr>
		
		 <tr>
		  <th>是否草稿：</th>
		  <td>
		    <my:radio pvalue="yesornot" name="isDraft" value="${isDraft}"/>
		  </td>
		 
		   <th>是否推荐：</th>
		   <td colspan="1">
		     <input type="radio" value="1" name="isRecommend"/>是
             <input type="radio" value="0" checked="checked" name="isRecommend"/>否
		   </td>
		   
		</tr>-->
		<tr>
		  <th><my:i18n zhText="内容" enText="Content"/>：</th>
		  <td>
		    <textarea id="fckContent" name="content" rows="15" cols="80">${content}</textarea>
		    <%--<c:if test="${!empty id}"><c:import url="${fckContentPath}${id}.txt" charEncoding="utf-8"></c:import></c:if>--%>
		    <script type="text/javascript">
		          var oFCKeditor = new FCKeditor('fckContent');
		          oFCKeditor.BasePath = "${ctx}/js_css_image/js/fckeditor/";
		          oFCKeditor.Config["CustomConfigurationsPath"]="${ctx}/js_css_image/js/fckeditor/myconfig.js";
		          oFCKeditor.ToolbarSet='noFormAttr';
		          oFCKeditor.Height=400;
		          oFCKeditor.ReplaceTextarea();
		    </script>
		  </td>
		</tr>
		<tr id="contentImgTr1" <c:if test="${!empty ContentImg}"> style="display: none" </c:if>>
			  <th><my:i18n zhText="上传图片" enText="Upload A Img"/>： </th>
			  <td>
			     <input type="file" class="multi" id="upload" name="upload" size="40" maxlength="1" accept="gif|jpg|png|bmp|jpeg"/>
			  </td>
		</tr>
		<c:if test="${!empty ContentImg}">
			<tr id="contentImgTr2">
			 <th><my:i18n zhText="已上传的图片" enText="Existed Img"/>： </th>
		     <td>
		  	     <c:forEach items="${uploadFileList}" var="upfile">
			        <img alt="照片" src="${ctx}/${upfile.uploadFilePath}" width="150px" height="150px" border="0">
			        <a href="javascript:" title="删掉" onclick="deleteUploadFile('${upfile.id}','${id}')">[<my:i18n zhText="删除" enText="Delete"/>]</a>
			    </c:forEach>
		  	</td>
			</tr>
		</c:if>
	  <tr>
		<td colspan="4" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>"  id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</div>
</body>
</html>