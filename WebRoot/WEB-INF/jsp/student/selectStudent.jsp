<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head multiFile="true">
<link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;
        $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"studentForm",
				 onComplete:function(){
				     W.reloadStudent();
				     api.close();
				 }
			  });
		});
	</script>
</my:head>
<body>
<div class="bodybox">
     <table width="100%" border="0" cellpadding="0" cellspacing="0" id="tabs1" >
		<tr>
			<td>
				<div id="uldiv">
					<ul>
						<li id="current"><a href="${ctx }/student/student_generateSchcode.do"><span><my:i18n zhText="生成学号" enText="Student Info"/></span></a></li>
					  </ul>
				</div>
			 </td>
			</tr>
	</table>
<div id="result" align="center" ></div>
  <form id="Form" action="${ctx }/student/student_generateSchcodeSave.do" method="post">
        <table width="100%" class="ftable">
         <tr>
            <input type="radio" name="state" value="ok" checked="true" />正常
			<input type="radio" name="state" value="history"/>历史 
          </tr>
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="英文部门名称" enText="English Dept Name"/>：</th>
            <td><input type="text" id="enDeptName" name="enDeptName" value="${enDeptName }" rules="[{notNull:true, message:'<my:i18n zhText="请输入部门名称" enText="Please Enter Dept Name"/>'}]"></td>
          </tr>
        </table>
      </form>
      </div>
</body>
</html>