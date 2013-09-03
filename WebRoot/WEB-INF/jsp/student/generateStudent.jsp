<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>

<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head multiFile="true">
<link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript">
      
   var tolisturl = "${ctx}/student/student_list.do";
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;
        $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"studentForm",
				 onComplete:function(){
				     W.reloadStudent();
				     api.close();
				     window.location.href = tolisturl;
				 }
			  });
		});
		function cancel(){
	var api = frameElement.api;
	  api.close();
	}  
	</script>
</my:head>
<body>
<div class="bodybox">
<div id="result" align="center" ></div>
       <form id="studentForm" action="${ctx }/student/student_generateSchcodeSave.do?" method="post">
         <input type="hidden" id="ids"name="ids"value="${ids}"> 
        <table style="width:100% " class="ftable">
         <tr>
         <td >
            <input type="radio" name="state" value="1" checked="true" />班级编号+流水号
            <br>
            流水号<input type="text" id="SerialNumber" name="SerialNumber" value="${SerialNumber }" >
		</td>
		</tr>
		
		
		<tr>
		<td>
			<br>
			<input type="radio" name="state" value="2"/>自定义规则：固定+流水号
			<br>
            固定部分<input type="text" id="staticstr" name="staticstr" value="${staticstr }">+流水号<input type="text" id="SerialNumber2" name="SerialNumber2" value="${SerialNumber2 }">
          </td>
          </tr>
          <tr>
			<td colspan="4" class="ftablebutton">
				  <input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="生成" enText="Save"/>" id="submitBtn"/> &nbsp; 
				 <input type="reset" class="button orange"  value="<my:i18n zhText="取消" enText="Cancel"/>"onclick="cancel()"/>
			</td>
	      </tr>
        </table>
      </form>
      </div>
</body>
</html>