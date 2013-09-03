<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
   <script type="text/javascript">
		var addordetail = true;
		$(function() {
			$("#submitBtn").submitForm({ formId:"userForm"});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 个人中心 - 修改密码</div>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="userForm" action="system/user_updatePassword.do" method="post">
		   <table width="100%" class="ftable">
          <tr>
            <th width="18%" ><font color="red">*</font>旧密码：</th>
            <td><input type="password" name="oldPassword" value="" id="oldPassword" style="width: 148px;height: 16px" rules="[{notNull:true, message:'旧<my:i18n zhText="请输入密码" enText="Please Enter Password"/>'}]"></td>
          </tr>
          <tr>
            <th width="18%"><font color="red">*</font>新密码：</th>
            <td><input type="password" name="newPassword" value="" id="newPassword" style="width: 148px;height: 16px" rules="[{notNull:true, message:'新<my:i18n zhText="请输入密码" enText="Please Enter Password"/>'}]"></td>
          </tr>
           <tr>
            <th width="18%"><font color="red">*</font>确认新密码：</th>
            <td><input type="password" name="conNewPassword" value="" id="conNewPassword" style="width: 148px;height: 16px" rules="[{notNull:true, message:'确认新<my:i18n zhText="请输入密码" enText="Please Enter Password"/>'},{equalWith:'newPassword',message:'确认密码需等于新密码'}]"></td>
          </tr>
           <tr>
			<td colspan="4" class="ftablebutton">
				<input type="button" class="button orange"  value="确定" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
			</td>
	      </tr>
        </table>
        </form>
    </div>
</body>
</html>