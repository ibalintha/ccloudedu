<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
	<script type="text/javascript">
		var addordetail = true;
		var tolisturl = "${ctx}/workflow/leave_listHistory.do";
		$(function(){
			$("#tolistButton").click(function(){window.location.href=tolisturl;});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 流程管理 - 请假流程 - 查看请假单</div>
	<!-- 
	<div  class="pheadbutton">
	   <input type="submit" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div>
	 -->
	<div class="clear"></div>
</div>
	<div id="result" align="center" style="color: red"></div>
		<table width="100%" class="ftable">
		  <tr>
            <td colspan="4" style="padding-left: 20px"><b>请假信息</b></td>
          </tr>
           <tr>
            <th width="12%">请假人：</th>
            <td>${leave.leaveUser.userName}</td>
            <th width="15%">请假类型：</th>
            <td><my:view value="${leave.leaveType}" pvalue="leave"/></td>
          </tr>
          <c:if test="${!empty leave.oaProject.id}">
	           <tr>
				  <th>项目编号：</th>
				  <td>${leave.oaProject.projectCode}</td>
				  <th width="15%">项目名称：</th>
				  <td>${leave.oaProject.projectName}</td>
			  </tr>
		  </c:if>
          <tr>
            <th>开始时间：</th>
            <td>${leave.leaveTime }</td>
            <th width="12%">到岗时间：</th>
            <td>${leave.leaveEndTime }</td>
          </tr>
          <tr>
            <th>请假天数：</th>
            <td colspan="3">${leave.leaveDayNumber }</td>
          </tr>
          <tr>
            <th >请假事由：</th>
            <td colspan="3">
            
            ${leave.leaveContent}
            
            </td>
          </tr>
     
          <c:if test="${!empty leave.leaveAudtis}">
            <tr>
             <td colspan="4" style="padding-left: 20px"><b>意见内容</b></td>
            </tr>
            <c:forEach items="${leave.leaveAudtis}" var="laudit" varStatus="status">
	             <tr>
		            <th><font color="red">执行人${status.index+1}</font>：</th>
		            <td>${laudit.audtiUser.userName}</td>
		            <th>执行时间：</th>
		            <td>${laudit.auditTime}</td>
		          </tr>
		          <tr>
		            <th>是否同意：</th>
		            <td colspan="3"><my:view value="${laudit.auditState}" pvalue="wfcode"/> </td>
		          </tr>
		         <tr>
		            <th>意见内容：</th>
		            <td colspan="3">${laudit.auditContent}</td>
		          </tr>
            </c:forEach>
          </c:if>
        </table>
    </div>
</body>
</html>