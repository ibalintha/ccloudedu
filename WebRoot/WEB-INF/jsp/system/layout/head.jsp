<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<div id="head">
	<form action="${ctx }/system/layout_layout.do" method="post" id="changeRoleForm">
	   <input type="hidden" value="${locale }" name="request_locale" id="request_locale"/>
	   <div style="float: left;margin-left: 10px">
		   <my:i18n zhText="欢迎您" enText="Welcome You"/> <my:i18n zhText="${user.userName}" enText="${user.enUserName}"/>
		   <select id="changeRoleId" name="changeRoleId">
		       <c:forEach items="${user.sysRoles}" var="role" varStatus="status">
		           <option value="${role.id }" <c:if test="${role.id==changeRoleId}">selected="selected"</c:if>> 
		              <my:i18n zhText="${role.roleName}" enText="${role.enRoleName}"/>
		           </option>
		       </c:forEach>
		   </select>
		</div>
	</form>
	<div style="float: right;margin-right: 20px;">
		<a href="${ctx }/system/layout_layout.do"><my:i18n zhText="桌面" enText="My Desk"/></a> |
		<a href="#" id="onlineUser">
		   <my:i18n zhText="当前在线" enText="Online"/>
		   <span id="loginUserCount">0</span> 
		   <my:i18n zhText="人" enText="People"/>
		</a> |
		
		<%--<a href="#" id="onlineChat">在线聊天</a> | --%>
		<a href="#" id="messageBoard"><my:i18n zhText="我要留言" enText="My Message Board"/></a> |
		<%--<a href="#" id="readme">readme</a> | 
		<a href="#" id="updatePassword">修改密码</a> |
		<a href="#" id="deskSet">桌面设置</a> |--%>
		 
		   <select name="request_locale" id="change_request_locale">
		       <option value="zh_CN" <c:if test="${locale=='zh_CN'}">selected="selected"</c:if>><my:i18n zhText="中文版" enText="Chinese"/></option>
               <option value="en_US" <c:if test="${locale=='en_US'}">selected="selected"</c:if>><my:i18n zhText="英文版" enText="English"/></option>
		   </select>
		 | 
		<a href="${ctx }/login/login_logout.do"><my:i18n zhText="注销" enText="Logout"/></a>
 </div>

</div>
 <div class="customer1" style="display: none"> 
	  <img id="headUpDown" border="0" src="${ctx }/js_css_image/images/up.png" alt="" />
</div>