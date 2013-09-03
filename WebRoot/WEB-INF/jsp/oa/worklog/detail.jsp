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
        	if("${isDraft}"==""){$(":radio[value='N']").attr("checked","checked");}
			 $(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:"yyyy-MM-dd HH:mm"});});
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
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：工作日志 - 查看</div>
	<div class="clear"></div>
</div>
 <table width="100%" class="ftable"id="ftable">
      <tr>
		  <th width="15%">姓名：</th>
		  <td>${creator.userName}</td>
		  <th width="15%">部门：</th>
		  <td>${creator.sysDept.deptName}</td>
	  </tr>
	   <tr>
		  <th>所在项目编号：</th>
		  <td>${oaProject.projectCode}</td>
		  <th>所在项目名称：</th>
		  <td>${oaProject.projectName}</td>
	  </tr>
	  <tr>
		  <th>日期：</th>
		  <td>${workDate}</td>
		  <th>星期：</th>
		  <td>星期${weekDay}</td>
	  </tr>
	  <tr>
		  <th>开始时间：</th>
		  <td>${startTime}</td>
		  <th>结束时间：</th>
		  <td>${endTime}</td>
	  </tr>
	  <tr>
		  <th>历时（H）：</th>
		  <td>${duringLlong}</td>
		  <th>工作类型：</th>
		  <td><my:view value="${workType}" pvalue="worktype"/></td>
	  </tr>
	  <tr>
		  <th>工作地点：</th>
		  <td colspan="3"><my:view value="${workPlace}" pvalue="workplace"/> </td>
	  </tr>
	   <tr>
		  <th>工作主题：</th>
		  <td colspan="3">${workTheme}</td>
	  </tr>
	  <tr>
		  <th >工作内容：</th>
		  <td colspan="3">${workContent}</td>
		</tr>
  </table>
</div>
</body>
</html>