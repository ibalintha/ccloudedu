<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" tree3="true">
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript">
        $(function() {
			$("#submitBtn").submitForm({
				formId:"channelForm",
				onComplete:function(id){
					parent.addNode('contentIframe','${parentId }',id,$("#channelName").val(),"/cms/channel_update.do?id="+id);
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
						<li><a href="${ctx }/cms/channel_update.do?id=${id }&parentId=${id }"><span>本栏目信息</span></a></li>
						<li><a href="${ctx }/cms/channel_list.do?id=${id }"><span>下级栏目列表</span></a></li>
						<li id="current"><a href="${ctx }/cms/channel_add.do?id=${id }"><span>新增下级栏目</span></a></li>
					</ul>
				</div>
			</td>
		</tr>
	</table>
</div>
  <div id="result" align="center" style="color: red;padding-top: 10px"></div>
<form method="post" action="${ctx }/cms/channel_save.do" id="channelForm">
    <input type="hidden" name="parentId" value="${parentId}">
     <table width="100%" class="ftable"id="ftable">
		<tr>
		  <th width="15%" >上级栏目：</th>
		  <td>
		    ${parentName }
		  </td>
		  <!--<td >模型</td>
		  <td colspan="1">
		    ${cmsChannelModel.channelModelName }
		  </td>
		--></tr>
		<tr>
		  <th width="15%"><font color="red">*</font>名称：</th>
		  <td>
		    <input type="text" maxlength="100" id="channelName" name="channelName" value="${channelName }" maxlength="100" align="left" rules="[{notNull:true, message:'名称不能为空'}]"/>
		  </td>
		</tr>
		<tr>
		    <th >访问路径：</th>
		     <td>
		    <input type="text" maxlength="20" name="path" value="${path }" class="required" maxlength="20" />
		  </td>
		</tr>
		<tr>
		  <th >栏目类型：</th>
		  <td>
		      <my:select pvalue="channelType" name="channelType" value="${channelType}"/>
		  </td>
		</tr>
		<c:forEach items="${templeteList}" var="templete">
		   <tr>
			 <th >${templete.templetName}：</th>
			 <td colspan="1">
				 <select name="templeteIds"/>
				     <option value="">----</option>
					 <c:forEach items="${templete.cmsTemplets}" var="subTemplete">
					     <option value="${subTemplete.id}">${subTemplete.templetName}</option>
					 </c:forEach>
			     </select>
			 </td>
		   </tr>
		</c:forEach>
		<tr>
		  <th >首页显示笔数：</th>
		  <td>
		    <input type="text" name="indexPageNum" id="indexPageNum" value="${indexPageNum}" size="10" rules="[{isDigit:true, message:'只能是数字'}]"/>
		  </td>
		</tr>
		<tr>
		  <th >二级页面显示笔数：</th>
		  <td>
		    <input type="text" name="secondPageNum" id="secondPageNum" value="${secondPageNum}" size="10" rules="[{isDigit:true, message:'只能是数字'}]"/>
		  </td>
		</tr>
		 <%--
		 <tr>
			  <th >访问控制：</th>
			  <td colspan="1">
			   <select name="isControl"/>
				   <option value="">开放</option>
				   <option value="1">会员</option>
			   </select>
			  </td>
		 </tr>
		 <tr>
			  <th >投稿控制：</th>
			  <td colspan="1">
			     <select name="isContributeed"/>
				   <option value="">开放浏览</option>
				   <option value="1">普通会员</option>
			   </select>
			  </td>
			</tr>
			<tr>
			 <th >是否显示：</th>
			 <td colspan="3">
				<input type="radio" id="display_0" value="1" <c:if test="${empty isDisplay || isDisplay=='1'}">checked="checked"</c:if>  name="isDisplay"/>
				<label for="display_0">是</label> 
				<input type="radio" id="display_1" value="0" name="isDisplay" <c:if test="${isDisplay=='0'}">checked="checked"</c:if>/>
				<label for="display_1">否</label>
			 </td>
			 </tr>
		  --%>
        
	    <tr>
		  <th >title：</th>
		  <td>
		    <input type="text" maxlength="200" name="title" value="${title }" align="left" size="50"/>
		  </td>
		</tr>
		<tr>
		   <th >keywords：</th>
		  <td>
		    <input type="text" name="keywords" value="${keywords }"  maxlength="200" size="50"/>
		  </td>
		</tr>
		<tr>
		  <th >description：</th>
		  <td>
		    <input type="text" name="description" value="${description }" maxlength="200" align="left" size="50"/>
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