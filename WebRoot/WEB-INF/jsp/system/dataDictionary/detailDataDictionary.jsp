<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<script type="text/javascript">
		 $(function() {
		   $("#submitBtn").submitForm({
			   formId:"ddForm",
			   resetForm:false,
			   onComplete:function(){
					parent.refreshTree('${id }',$("#${locale.language}DdName").val());
			   }
		   });
	    });
	</script>
</my:head>
<body>
<div class="bodybox">
 <div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="tabs1" >
		<tr>
			<td>
				<div align="center" id="uldiv">
					<ul>
						<li id="current"><a href="${ctx }/system/datadictionary_update.do?id=${id }"><span><my:i18n zhText="当前参数信息" enText="Current Param Info"/></span></a></li>
						<li><a href="${ctx }/system/datadictionary_list.do?id=${id }"><span><my:i18n zhText="下级各项列表" enText="Sub Param List"/></span></a></li>
						<li><a href="${ctx }/system/datadictionary_add.do?id=${id }"><span><my:i18n zhText="新增下级参数" enText="Add A New Param"/></span></a></li>
					</ul>
				</div>
			 </td>
			</tr>
		</table>
  </div>
		  <div id="result" align="center" style="color: red"></div>
		  <form id="ddForm" action="system/datadictionary_save.do" method="post">
		   <input type="hidden" name="id" id="id" value="${id }">
		  <table width="100%" class="ftable">
          <c:if test="${!empty parentDD.ddName }">
	         <tr>
	            <th width="18%"><my:i18n zhText="上级参数名" enText="Parent Param Name"/>：</th>
	            <td><my:i18n zhText="${parentDD.ddName }" enText="${parentDD.enDdName }"/></td>
	          </tr>
          </c:if>
           <tr>
           <th width="18%"><font color="red">*</font><my:i18n zhText="中文参数名" enText="Chinese Param Name "/>：</th>
            <td><input type="text" size="50" id="zhDdName" name="ddName" value="${ddName }" class="required" rules="[{notNull:true, message:'<my:i18n zhText="请输入参数名" enText="Please Enter A Chinese Name Of The Param"/>'}]"></td>
          </tr>
          <tr>
            <th><font color="red">*</font><my:i18n zhText="英文参数名" enText="English Param Name"/>：</th>
            <td><input type="text" size="50" id="enDdName" name="enDdName" value="${enDdName }" class="required" rules="[{notNull:true, message:'<my:i18n zhText="请输入参数名" enText="Please Enter A Chinese Name Of The Param"/>'}]"></td>
          </tr>
           <tr>
            <th><my:i18n zhText="参数值" enText="Param Value Of"/>：</th>
            <td><input type="text" name="ddValue" value="${ddValue }"/></td>
          </tr>
           <tr>
            <th><my:i18n zhText="备注" enText="Remark"/>：</th>
            <td><textarea rows="4" cols="80" name="remark">${remark}</textarea></td>
          </tr>
           <tr>
			<td colspan="2" class="ftablebutton">
				<my:auth fixedValue="W" value="${auth}"><input type="button" class="button orange"  value="<my:i18n zhText="更新" enText="Update"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/></my:auth>
			</td>
	      </tr>
        </table>
        </form>
        </div>
	</body>
</html>