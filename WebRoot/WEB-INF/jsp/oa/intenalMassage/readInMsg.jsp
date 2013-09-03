<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
	<script type="text/javascript">
		var addordetail = true;
		$(function(){
	    	
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 收件箱- 阅读信息 </div>
	<div class="clear"></div>
</div>
<div id="result" align="center" style="color: red;"></div>
      <table width="100%" class="ftable"id="ftable">
       <tr>
		  <th width="12%" >标题：</th>
		  <td>${msgTitle }</td>
		 </tr>
		<tr>
		  <th width="12%" >发送时间：</th>
		  <td>${sendTime }</td>
		 </tr>
		 <tr>
		  <th >发信人：</th>
		  <td>${sender.userName}</td>
		</tr>
			<%--
			 <tr>
			  <th >接收人：</th>
			  <td>${receiver.userName}</td>
			</tr>
			<c:if test="${isRead=='0'}">
				<tr>
				  <th width="12%" >是否阅读：</th>
				  <td>未阅读</td>
				 </tr>
			</c:if>
		 --%>
		<c:if test="${isRead=='1'}">
			<tr>
			  <th width="12%" >阅读时间：</th>
			  <td>${readTime }</td>
			 </tr>
		</c:if>
	  <tr>
		  <th >信息内容：</th>
		  <td>
		    <div style="width: 90%;">${msgContent }</div>
		  </td>
		</tr>
		<tr>
		  <th >附件：</th>
		  <td>
		    <c:forEach items="${uploadFileList}" var="upfile">
		        <a href="${ctx}/oa/intenalMassage_download.do?id=${id}&uploadFileId=${upfile.id}" title="下载">${upfile.uploadFileName }[${upfile.uploadFileSize}]</a><br/>
		     </c:forEach>
		  </td>
		</tr>
		
	</table>
</div>
</body>
</html>