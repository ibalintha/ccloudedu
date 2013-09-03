<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<%
   String openInPopup = request.getParameter("openInPopup");
   if("1".equals(openInPopup)){
	   request.setAttribute("openInPopup","1");
   }
%>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true" multiFile="true">
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener;
        var addordetail = true;
		//var tolisturl = "${ctx}/oa/intenalMassage_list.do?queryType=1";
        $(function() {
			$(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:"yyyy-MM-dd HH:mm:ss"});});
			 $("#onlineUser").click(function(){
					var url = 'system/user_chooseUser.do';
					W.$.dialog({
						title:'选择用户',
						content: 'url:'+url,
					    //lock:true,
					    width: '600px',
					    height: 400
					});
			  });
			 $("#submitBtn").submitForm({ 
				 formId:"inmsgForm",
				 onComplete:function(){
				    location.reload();
				 }
			  });
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 发送信息</div>
    <div class="pheadbutton">
      <c:if test="${!empty openInPopup && openInPopup=='1'}">
      <!-- <input type="button" class="button orange"  value="关闭" name="closePopup"/> -->
      <input type="button" class="button orange"  value="返回" name="ret" onclick="javascript:history.go(-1)"/>
      </c:if>
      <c:if test="${empty openInPopup}"><input type="button" class="button orange"  value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" name="tolistButton" id="tolistButton"/></c:if>
    </div>
	<div class="clear"></div>
</div>
<div id="result" align="center" style="color: red;"></div>
    <form method="post" action="${ctx }/oa/intenalMassage_save.do" id="inmsgForm" enctype="multipart/form-data">
      <table width="100%" class="ftable"id="ftable">
      <tr>
		  <th width="12%" >标题：</th>
		  <td>
		    <input type="text" maxlength="256" size="50" name="msgTitle" value="${msgTitle }"  class="required" align="left"/>
		  </td>
		 </tr>
		<%--
		
		<tr>
		  <th width="12%" >发送时间：</th>
		  <td>
		    <input type="text" maxlength="100" name="sendTime" value="${sendTime }" size="30" class="required Wdate" align="left" readonly="readonly"/>
		  </td>
		 </tr>
		  --%>
		 <tr>
		  <th >接收人：</th>
		  <td>
		    <input type="text" class="required" size="50" name="receiverNames"  id="receiverName" value="${receiver.userName }" readonly="readonly">
            <input type="hidden" class="required" size="50" name="receiverIds" id="receiverId" value="${receiver.id }">
		    <a style="cursor: pointer;" title="选择接收人" id="onlineUser">选择接收人</a>
		    <%-- <a href="${ctx }/system/user_tree.do?userInPopup=1" title="选择接收人" id="onlineUser">选择接收人</a> --%>
		  </td>
		</tr>
	  <tr>
		  <th ><font color="red">*</font>信息内容：</th>
		  <td>
		    <textarea name="msgContent" style="width: 480px;height: 80px" rules="[{notNull:true, message:'信息内容不能为空'}]"></textarea>
		     <%--<script type="text/javascript">
		          var oFCKeditor = new FCKeditor('msgContent');
		          oFCKeditor.BasePath = "${ctx}/fckeditor/";
		          oFCKeditor.Config["CustomConfigurationsPath"]="${ctx}/fckeditor/myconfig.js";
		          oFCKeditor.ToolbarSet='simpleBar';
		          oFCKeditor.Height=230;
		          oFCKeditor.ReplaceTextarea();
		    </script> --%>
		  </td>
		</tr>
		<tr>
		  <th >附件：</th>
		  <td >
		    <input type="file" name="upload" size="40" value="" id="upload" class="multi"/>
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