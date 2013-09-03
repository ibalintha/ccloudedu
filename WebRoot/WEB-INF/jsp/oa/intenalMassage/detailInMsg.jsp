<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String openInPopup = request.getParameter("openInPopup");
   if("1".equals(openInPopup)){
	   request.setAttribute("openInPopup","1");
   }
%>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<script type="text/javascript">
		var addordetail = true;
		var tolisturl = "${ctx}/oa/intenalMassage_list.do?queryType=${queryType}";
		$(function(){
	    	 $(":input[name='closePopup']").click(function(){ parent.$.fn.colorbox.close();});
		});
		function submitForm(){
			submitFormByAjax("#inmsgForm",function(){
		        return true;
			});
	    }
	</script>
</head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition">
	    <c:if test="${queryType=='1'}"> <my:i18n zhText="当前位置" enText="Current Position"/>： 信息管理 - 发件箱- 阅读信息</c:if>
		<c:if test="${queryType=='2'}"><my:i18n zhText="当前位置" enText="Current Position"/>： 信息管理 - 收件箱- 阅读信息</c:if>
		<c:if test="${queryType=='3'}"><my:i18n zhText="当前位置" enText="Current Position"/>： 信息管理 - 回收箱- 阅读信息</c:if>
    </div>
    <div class="pheadbutton">
       <c:if test="${!empty openInPopup && empty fromMsgtip && openInPopup=='1'}"><input type="button" class="button orange"  value="关闭" name="closePopup"/></c:if>
       <c:if test="${!empty fromMsgtip && fromMsgtip=='1'}"><input type="button" class="button orange"  value="关闭" onclick="window.close();"/></c:if>
       <c:if test="${empty openInPopup && empty fromMsgtip}"><input type="button" class="button orange"  value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" name="tolistButton" id="tolistButton"/></c:if>
    </div>
	<div class="clear"></div>
</div>
<div id="result" align="center" style="color: red;"></div>
    <form method="post" action="oa/intenalMassage_save.do" id="inmsgForm">
      <table width="100%" class="ftable"id="ftable">
       <tr>
		  <td width="12%" >标题：</td>
		  <td>${msgTitle }</td>
		 </tr>
		<tr>
		  <td width="12%" >发送时间：</td>
		  <td>${sendTime }</td>
		 </tr>
		 <tr>
		  <td >发信人：</td>
		  <td>${sender.userName}</td>
		</tr>
		 <tr>
		  <td >接收人：</td>
		  <td>${receiver.userName}</td>
		</tr>
		<c:if test="${isRead=='0'}">
			<tr>
			  <td width="12%" >是否阅读：</td>
			  <td>未阅读</td>
			 </tr>
		</c:if>
		<c:if test="${isRead=='1'}">
			<tr>
			  <td width="12%" >阅读时间：</td>
			  <td>${readTime }</td>
			 </tr>
		</c:if>
	  <tr>
		  <td >信息内容：</td>
		  <td>
		    <div style="width: 90%">${msgContent }</div>
		  </td>
		</tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<c:if test="${!empty openInPopup && empty fromMsgtip && openInPopup=='1'}"><input type="button" class="button orange"  value="关闭" name="closePopup"/></c:if>
			<c:if test="${!empty fromMsgtip && fromMsgtip=='1'}"><input type="button" class="button orange"  value="关闭" onclick="window.close();"/></c:if>
            <c:if test="${empty openInPopup && empty fromMsgtip}"><input type="button" class="button orange"  value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" name="tolistButton"/></c:if>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>