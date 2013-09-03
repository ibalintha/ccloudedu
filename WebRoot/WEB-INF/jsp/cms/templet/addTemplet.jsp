<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript">
        var addordetail = true;
        $(function() {
			$("#submitBtn").submitForm({ 
				formId:"templetForm",
				onComplete:function(id){
					parent.addNode('contentIframe','${parentId }',id,$("#templetName").val(),"/cms/templet_update.do?id="+id);
				}
			});
		});
	</script>
</my:head>

<body>
<div class="bodybox">
<div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="tabs1" >
		<tr>
			<td>
				<div align="center" id="uldiv">
					<ul>
						<li><a href="${ctx }/cms/templet_update.do?id=${id }"><span>本模板信息</span></a></li>
						<li><a href="${ctx }/cms/templet_list.do?id=${id }"><span>下级模板列表</span></a></li>
						<li  id="current"><a href="${ctx }/cms/templet_add.do?id=${id }"><span>新增下级模板</span></a></li>
					</ul>
				</div>
			</td>
		</tr>
	</table>
</div>
  <div id="result" align="center" style="color: red;padding-top: 10px"></div>
<form method="post" action="cms/templet_save.do" id="templetForm">
    <input type="hidden" name="id" value="">
    <input type="hidden" name="parentId" value="${parentId}">
    <input type="hidden" name="channelIds" id="channelIds" value=""/>
	<table width="100%" class="ftable"id="ftable">
		<tr>
		  <th width="12%" >上级模板：</th>
		  <td>
		    ${parentName}
		  </td>
		</tr>
		<!--<tr>
		 <td >所属栏目</td>
		 <td>
		    <div id="tree"></div>
		  </td>
	  </tr>
		--><tr>
		  <th >模板名称：</th>
		  <td>
		    <input type="text" maxlength="128" size="30" id="templetName" name="templetName" value="${templetName }" class="required" align="left"/>
		  </td>
		 </tr><!--
		 <tr>
		  <td >模板文件名称：</td>
		  <td>
		    <input type="text" maxlength="128" size="30" name="templetFileName" value="${templetFileName }" class="required" align="left"/>
		  </td>
		 </tr>
		 -->
		 <c:if test="${empty cmsTemplets}">
			 <tr>
			  <th >模板类型：</th>
			  <td>
			      <my:select pvalue="templeteType" name="templeteType" value="${templeteType}"/>
			  </td>
			</tr>
		</c:if>
		 <tr>
		  <th >模板路径：</th>
		  <td>
		    <input type="text"  maxlength="128" size="50" name="templetPath" value="${templetPath }" class="required"/>
		  </td>
		</tr>
	  <tr>
		  <th >模板内容：</th>
		  <td>
		    <textarea id="fckContent" name="fckContent" style="width: 750px; height: 300px;"><c:if test="${!empty templetPath}"><c:import url="${templetPath}" charEncoding="utf-8"></c:import></c:if></textarea>
		   <%--
		    <script type="text/javascript">
		          var oFCKeditor = new FCKeditor('fckContent');
		          oFCKeditor.BasePath = "${ctx}/fckeditor/";
		          oFCKeditor.Config["CustomConfigurationsPath"]="${ctx}/fckeditor/myconfig.js";
		          oFCKeditor.ToolbarSet='noFormAttr';
		          oFCKeditor.Height=300;
		          oFCKeditor.ReplaceTextarea();
		    </script>
		    --%>
		  </td>
		</tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>