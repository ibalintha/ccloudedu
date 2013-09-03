<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true" multiFile="true">
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;
        $(function() {
        	$(".number").number();
        	if("${isDraft}"==""){$(":radio[value='N']").attr("checked","checked");}//minDate:'%y-%M-{%d-5}'
			 $(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:"yyyy-MM-dd HH:mm",minDate:'%y-%M-%d 00:00:00',maxDate:'%y-%M-%d'});});
			 $("#submitBtn").submitForm({ 
				 formId:"worklogForm",
				 onComplete:function(){
				     W.reloadworklog();
				     api.close();
				 }
			  });
			 
			 $("#chooseProject").click(function(){
				 $("label[for='projectCode']").html("");
				 cDG = W.$.dialog({id:'chooseProject',title:'选择项目',content: 'url:${ctx }/oa/project_chooseProject.do',width: '600px',height: 400});
			});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：工作日志 - <my:position value="${id}"/></div>
	<div class="clear"></div>
</div>
<form method="post" action="${ctx }/oa/worklog_save.do" id="worklogForm" enctype="multipart/form-data">
      <input type="hidden" value="${id}" id="id" name="id"/>
      <input type="hidden" value="${oaProject.id}" name="projectId" id="projectId"/>
      <table width="100%" class="ftable"id="ftable">
      <tr>
		  <th width="15%"><font color="red">*</font>项目编号：</th>
		  <td>
		    <input type="text" id="projectCode" value="${oaProject.projectCode}" readonly="readonly" rules="[{notNull:true, message:'项目编号不能为空'}]"/>
		    <a href="#" id="chooseProject">[选择]</a>
		  </td>
		  <th width="15%">项目名称：</th>
		  <td><span id="projectName">${oaProject.projectName}</span></td>
	  </tr>
	  <tr>
		  <th><font color="red">*</font>开始时间：</th>
		  <td>
		     <input type="text" name="startTime" value="${startTime}" readonly="readonly" class="Wdate" rules="[{notNull:true, message:'开始时间不能为空'}]"/>
		  </td>
		  <th><font color="red">*</font>结束时间：</th>
		  <td>
		    <input type="text" name="endTime" value="${endTime}" readonly="readonly" class="Wdate" rules="[{notNull:true, message:'结束时间不能为空'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th><font color="red">*</font>历时（H）：</th>
		  <td>
		     <input type="text" name="duringLlong" value="${duringLlong}" maxlength="5" class="number" number="2,2" rules="[{notNull:true, message:'历时不能为空'}]"/>
		  </td>
		  <th><font color="red">*</font>工作类型：</th>
		  <td>
		      <my:select pvalue="worktype" name="workType" value="${workType}" rules="[{notNull:true, message:'工作类型不能为空'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th><font color="red">*</font>工作地点：</th>
		  <td colspan="3">
		     <my:select pvalue="workplace" name="workPlace" value="${workPlace}" rules="[{notNull:true, message:'工作地点不能为空'}]"/>
		  </td>
	  </tr>
	   <tr>
		  <th><font color="red">*</font>工作主题：</th>
		  <td colspan="3">
		    <input type="text" size="95" name="workTheme" value="${workTheme}" rules="[{notNull:true, message:'工作主题不能为空'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th ><font color="red">*</font>工作内容：</th>
		  <td colspan="3">
		    <textarea name="workContent" style="width: 600px;height: 100px" rules="[{notNull:true, message:'工作内容不能为空'}]">${workContent}</textarea>
		  </td>
		</tr>
		<tr>
		  <th>是否草稿：</th>
		  <td colspan="3">
		     <my:radio pvalue="yesornot" name="isDraft"  value="${isDraft}"/>
		  </td>
	  </tr>
	  <tr>
		<td colspan="4" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
			<input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>