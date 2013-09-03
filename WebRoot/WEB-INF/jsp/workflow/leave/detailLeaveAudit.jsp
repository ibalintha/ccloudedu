<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
	<script type="text/javascript">
		var addordetail = true;
		var api = frameElement.api, W = api.opener,cDG;
		var tolisturl = "${ctx}/workflow/leave_listAudit.do";
		$(function(){
			//$("#tolistButton").click(function(){window.location.href=tolisturl;});
			$("#submitBtn").submitForm({ 
				formId:"leaveAuditForm",
				onComplete:function(){
				     W.reloadList();
				     api.close();
				 }
			});
			////$('textarea').autoResize({extraSpace : 0});
			$("input[name='leaveAudit.auditState']").click(function(){
				$("label[for='nextExecutorId']").html("");
				if($(this).attr("checked") && $(this).val()=='agree'){
					$("#nextExecutorId").attr("disabled",false);
				}else{
					$("#nextExecutorId").val("").attr("disabled",true);
				}
			});
			
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 流程管理 - 请假流程 - 审核请假单</div>
	<div  class="pheadbutton">
	    <%--<input type="submit" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/> --%>
	</div>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="leaveAuditForm" action="workflow/leave_saveAudit.do" method="post">
		  <input type="hidden" name="id" value="${id}"/>
		  <input type="hidden" name="processInstanceId" value="${processInstanceId}"/>
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
          <c:if test="${operateType=='lshenhe'}">
               <tr>
	             <td colspan="4" style="padding-left: 20px"><b>我的意见</b></td>
	            </tr>
	           <tr>
	            <td align="right" ><font color="red">*</font>意见内容：</td>
	            <td colspan="3"><textarea style="width: 600px;height: 80px" rules="[{notNull:true, message:'意见内容不能为空'}]" name="leaveAudit.auditContent">${leaveAudit.auditContent}</textarea> </td>
	          </tr>
	           <tr>
	            <td align="right"><font color="red">*</font>是否同意：</td>
	            <td colspan="3"><my:radio pvalue="wfcode" name="leaveAudit.auditState"  value="agree"/> </td>
	          </tr>
          </c:if>
         <c:if test="${operateType=='kaoqing'}">
              <tr>
	             <td colspan="4" style="padding-left: 20px"><b>考情统计</b></td>
	          </tr>
	          <tr>
	            <td align="right">考情统计：</td>
	            <td colspan="3">
	               <a href>点击这里，统计考情</a> 
	               <input type="hidden" name="leaveAudit.auditContent" value="完成考情统计"/>
	               <input type="hidden" name="leaveAudit.auditState" value="agree"/>
	            </td>
	          </tr>
         </c:if>
          <c:if test="${operateType=='caiwu'}">
              <tr>
	             <td colspan="4" style="padding-left: 20px"><b>财务统计</b></td>
	          </tr>
	          <tr>
	            <td align="right">财务统计：</td>
	            <td colspan="3">
	               <a href>点击这里，统计财务</a>
	               <input type="hidden" name="leaveAudit.auditContent" value="完成考财务统计"/>
	               <input type="hidden" name="leaveAudit.auditState" value="agree"/> 
	            </td>
	          </tr>
         </c:if>
          <c:if test="${!empty nextExecutors}">
	         <tr >
	            <td align="right" ><font color="red">*</font>下一步执行人：</td>
	            <td colspan="3">
	                <s:select name="nextExecutorId" list="nextExecutors"  rules="[{notNull:true, message:'下一步执行人不能为空'}]" headerKey="" headerValue="--" listKey="userId+','+wfExecuteId" listValue="userName+'('+roleName+')'"></s:select>
	            </td>
	          </tr>
          </c:if>
           <tr>
			<td colspan="4" class="ftablebutton">
				<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Submit"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
			</td>
	      </tr>
        </table>
        </form>
    </div>
</body>
</html>