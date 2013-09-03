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
		var tolisturl = "${ctx}/cms/channelModel_list.do";
        $(function() {
			$("#submitBtn").submitForm({ 
				formId:"channelModelForm",
				onComplete:function(){
				    window.location.href = tolisturl;
				}
				
			});
			$("#tolistButton").click(function(){window.location.href=tolisturl;});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 栏目模型 - 栏目类型 - <my:position value="${id}"/></div>
	<div  class="pheadbutton" >
		 <input type="button" class="button orange"  value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" name="tolistButton" id="tolistButton"/>
	</div>
	<div class="clear"></div>
</div>
  <div id="result" align="center" style="color: red;padding-top: 10px"></div>
<form method="post" action="cms/channelModel_save.do" id="channelModelForm">
    <input type="hidden" name="id" value="${id }">
	<table width="100%" class="ftable">
		<tr>
		  <th width="15%" ><font color="red">*</font>名称：</th>
		  <td>
		    <input type="text" maxlength="100" name="channelModelName" value="${channelModelName }" rules="[{notNull:true, message:'名称不能为空'}]"/>
		  </td>
		</tr>
		<tr>
		<th width="15%" ><font color="red">*</font>编码：</th>
		  <td>
		    <input type="text" maxlength="20" name="shortName" value="${shortName }" rules="[{notNull:true, message:'编码不能为空'}]" <c:if test="${!empty shortName}">readonly="readonly"</c:if>/>
		  </td>
		</tr>
		<tr>
		<th width="15%" >备注：</th>
		  <td>
		    <textarea rows="6" cols="60" name="remark">${remark }</textarea>
		  </td>
		</tr>
		<!--<tr>
		  <td width="15%" >栏目模板前缀：</td>
		  <td>
		   <input type="text" maxlength="20" value="${tplPrefixContent }" name="tplPrefixChannel" maxlength="20"/>
		  </td>
		  <td width="15%" >内容模板前缀：</td>
		  <td>
		    <input type="text" maxlength="20" value="${tplPrefixContent }" name="tplPrefixContent" maxlength="20"/>
		  </td>
		 </tr>
	   <tr>
		 <td width="15%" >是否显示：</td>
		 <td>
			<input type="radio" id="display_0" value="1" <c:if test="${empty isDisplay || isDisplay=='1'}">checked="checked"</c:if>  name="isDisplay"/>
			<label for="display_0">是</label> 
			<input type="radio" id="display_1" value="0" name="isDisplay" <c:if test="${isDisplay=='0'}">checked="checked"</c:if>/>
			<label for="display_1">否</label>
		 </td>
		 <td width="15%" >所属系统：</td>
		 <td>
			 <select name="sysType"/>
				 <option value="">所有系统共用</option>
				 <option value="article" <c:if test="${sysType=='article'}">selected="selected"</c:if>>文章系统</option>
				 <option value="download" <c:if test="${sysType=='download'}">selected="selected"</c:if>>下载系统</option>
				 <option value="picture" <c:if test="${sysType=='picture'}">selected="selected"</c:if>>图片系统</option>
			 </select>
		 </td>
	  </tr>
	  --><tr>
		<td colspan="4" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>