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
				formId:"buttonForm",
			});
			
			var roleName = $(":input[name='roleName']").val();
			var funcName = $(":input[name='funcName']").val();
			$("#tolistButton").click(function(){
				window.location.href="${ctx}/system/button_list.do?roleName="+roleName+"&funcName="+funcName;
			});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
				<div class="pheadbutton">
					<input type="button" class="button orange"
						value="<my:i18n zhText="返回列表" enText="Return To List Page"/>"
						id="tolistButton" />
				</div>
				<div class="clear"></div>
				</div>
		  <form id="buttonForm" action="system/button_save.do" method="post">
		  <input type="hidden" name="roleName" value="${roleName}"/>
		  <input type="hidden" name="funcName" value="${funcName}"/>
		   <table width="100%" class="ftable">
			    <tr>
		            <th width="18%"><my:i18n zhText="角色名称" enText="Parent Menu"/>：</th>
		            <td>
		               <my:i18n zhText="${roleName}" enText="${roleName}"/>
		            </td>
	          </tr>
			    <tr>
		            <th width="18%"><my:i18n zhText="菜单名称" enText="Parent Menu"/>：</th>
		            <td>
		               <my:i18n zhText="${funcName}" enText="${funcName}"/>
		            </td>
	          </tr>
		   <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="按钮名称" enText="Chinese Menu Name"/>：</th>
                <td><input type="text" id="chRobuButton" name="chRobuButton" value="${chRobuButton }" class="required" rules="[{notNull:true, message:'<my:i18n zhText="请输入按钮名称" enText="Please Enter Menu Name"/>'}]"></td>
          </tr>
          <tr>
            <th ><font color="red">*</font><my:i18n zhText="id" enText="Id"/>：</th>
            <td><input type="text" name="chRobuId" value="${chRobuId }" class="required" rules="[{notNull:true, message:'<my:i18n zhText="请输入按钮id" enText="Please Enter Menu Name"/>'}]"></td>
          </tr>
          <tr>
            <th><font color="red">*</font><my:i18n zhText="是否激活" enText="Name"/>：</th>
            <td><input name="chRobuFlag" type="radio" value="是" checked="checked"/>是 <input name="chRobuFlag" type="radio" value="否" />否 </td>
          </tr>
        <tr>
			<td colspan="2" class="ftablebutton">
				<my:auth fixedValue="W" value="${auth}"><input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/></my:auth>
			</td>
	      </tr>
        </table>
        </form>
	</div>
	</body>
</html>