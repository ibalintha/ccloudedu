<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true">
	<script type="text/javascript">
		var addordetail = true;
		var api = frameElement.api, W = api.opener,cDG;
		//var tolisturl = "${ctx }/workflow/leave_list.do";
		$(function(){
			$(".number").number();
			
			$("#submitBtn").submitForm({ 
				 formId:"leaveForm",
				 onComplete:function(){
				     W.reloadList();
				     api.close();
				 }
			  });
	    	$("#chooseProject").click(function(){
	    		$("label[for='projectCode']").html("");
				cDG = W.$.dialog({id:'chooseProject',title:'选择项目',content: 'url:${ctx }/oa/project_chooseProject.do',width: '600px',height: 400});
			});
	    	$("#leaveType").change(function(){
	    		$(".pfooter").hide();
	    		$("#"+$(this).val()+"Div").show();
	    	});
	    	
	    	$("#leaveTime,#leaveEndTime").bind('change', function() {
				 if($("#leaveTime").val()!="" && $("#leaveEndTime").val()){
					 alert($.differDayBetweenTwoTime($("#leaveTime").val(),$("#leaveEndTime").val()));
				 }
			});
	    	
		});
		
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 流程管理 - 请假流程 - 填写请假单</div>
	<!-- 
	<div  class="pheadbutton">
	   <input type="submit" class="button orange" value="我的请假单" id="tolistButton" onclick="window.location.href='${ctx }/workflow/leave_list.do'"/>
	</div>
	 -->
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="leaveForm" action="workflow/leave_save.do" method="post">
		   <table width="100%" class="ftable">
		   <tr>
            <th width="12%"><font color="red">*</font>请假类型：</th>
            <td colspan="3">
                <my:select pvalue="leave" name="leaveType" firstoption="----" id="leaveType" rules="[{notNull:true, message:'请选择请假类型'}]"/>
            </td>
          </tr>
           <tr>
			  <th>项目编号：</th>
			  <td>
			    <input type="hidden" value="${oaProject.id}" name="oaProject.id" id="projectId"/>
			    <input type="text" id="projectCode" value="${oaProject.projectCode}" readonly="readonly"/>
			    <a href="#" id="chooseProject">[选择]</a>
			  </td>
			  <th width="15%">项目名称：</th>
			  <td><span id="projectName">${oaProject.projectName}</span></td>
		  </tr>
          <tr>
            <th><font color="red">*</font>开始时间：</th>
            <td>
                <input type="text" name="leaveTime" value="${leaveTime }" id="leaveTime" class="Wdate" readonly="readonly" title="请输入开始时间" rules="[{notNull:true, message:'开始时间不能为空'}]" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd HH:00',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'leaveEndTime\',{d:-0});}'})"/>
            </td>
            <th width="12%"><font color="red">*</font>到岗时间：</th>
            <td>
                <input type="text" name="leaveEndTime" value="${leaveEndTime }" id="leaveEndTime" class="Wdate" readonly="readonly" title="请输入到岗时间" rules="[{notNull:true, message:'到岗时间不能为空'}]" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd HH:00',minDate:'#F{$dp.$D(\'leaveTime\',{d:0});}'});"/>
            </td>
          </tr>
          <tr>
            <th><font color="red">*</font>请假天数：</th>
            <td colspan="3"><input type="text" name="leaveDayNumber" class="number" number="2,2" value="${leaveDayNumber }" title="请输入数字天数" rules="[{notNull:true, message:'请假天数不能为空'},{isDigit:true, message:'请假天数只能是整数'}]"/></td>
            <!-- 
            <th>项目经理是否已同意：</th>
            <td>
                <my:select pvalue="yesornot" name="" firstoption="----"/>
            </td>
             -->
          </tr>
          <tr>
            <th ><font color="red">*</font>请假事由：</th>
            <td colspan="3"><textarea name="leaveContent" style="width: 600px;height: 80px" rules="[{notNull:true, message:'请假事由不能为空'}]">${leaveContent }</textarea></td>
          </tr>
          <tr>
            <th ><font color="red">*</font>执行人：</th>
            <td colspan="3">
                <s:select name="nextExecutorId" list="nextExecutors" rules="[{notNull:true, message:'请选择执行人'}]" headerKey="" headerValue="--" listKey="userId+','+wfExecuteId" listValue="userName+'('+roleName+')'"></s:select>
            </td>
          </tr>
           <tr>
			<td colspan="4" class="ftablebutton">
				<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
			</td>
	      </tr>
        </table>
        </form>
        
        <c:forEach items="${ddLeaveList}" var="ddLeave">
           <c:if test="${!empty ddLeave.remark}">
              <div class="pfooter" id="${ddLeave.ddValue}Div" style="display: none"><font color="red">注：${ddLeave.remark}</font></div>
           </c:if>
        </c:forEach> 
        
    </div>
</body>
</html>