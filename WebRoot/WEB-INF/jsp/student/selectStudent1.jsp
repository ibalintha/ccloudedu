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
        alert(W);
        $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"Form",
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
						<li ><a href="${ctx }/student/student_select.do"><span><my:i18n zhText="普通查询" enText="Student Info"/></span></a></li>
						<li id="current"><a href="${ctx }/student/student_select1.do"><span><my:i18n zhText="高级查询" enText="Sub Student"/></span></a></li>
					  </ul>
				</div>
			 </td>
			</tr>
		</table>
<div id="result" align="center" ></div>
  <form id="Form" action="${ctx }/student/student_list.do" method="post">
  <table  class="ftable">
         <thead class="ltablehead">
             <tr>
             	<th ><my:i18n zhText="查询类别" enText="chStudSchcode"/></th>
             	<th ><my:i18n zhText="具体关键字" enText="chStudName"/></th>
             </tr>
         </thead>
       <tbody class="ltablebody">
         <tr>
            <th><my:i18n zhText="学号" enText="Dept Telephone"/>：</th>
            <td><input type="text" name="chStudSchcode" value="${chStudSchcode }"></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="姓名" enText="Dept Fax"/>：</th>
            <td><input type="text" name="chStudName" value="${chStudName }"></td>
          </tr>
          <tr>
			<td colspan="4" class="ftablebutton">
				<input type="button" class="button orange"  value="<my:i18n zhText="查询" enText="Save"/>" id=submitBtn/> &nbsp; 
				<input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
			</td>
	      </tr>
         </tbody>
      </table>
      </form>
      </div>
</body>
</html>