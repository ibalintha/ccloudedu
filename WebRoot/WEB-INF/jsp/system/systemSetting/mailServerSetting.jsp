<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
    <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<script type="text/javascript">
        $(function() {
			$("#submitBtn").submitForm({formId:"mailServerSetting",resetForm:false});
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
						<li><a href="${ctx}/system/systemSetting_addRuleSetting.do?ruleType=login"><span><my:i18n zhText="登录规则设置" enText="Login Rule Setting"/></span></a></li>
						<li><a href="${ctx}/system/systemSetting_addRuleSetting.do?ruleType=loginLog"><span><my:i18n zhText="登录日志设置" enText="Login Log Setting"/></span></a></li>
						<li><a href="${ctx}/system/systemSetting_addRuleSetting.do?ruleType=accessLog"><span><my:i18n zhText="系统访问日志设置" enText="System Access Log Setting"/></span></a></li>
					    <li id="current"><a href="${ctx}/system/systemSetting_addMailServerSetting.do"><span><my:i18n zhText="邮箱服务器设置" enText="Mail Server Setting"/></span></a></li>
					  </ul>
				</div>
			 </td>
			</tr>
	</table>
  </div>
  
  <div class="phead">
	<div class="pheadposition">
		<my:i18n zhText="当前位置" enText="Current Position"/>： 
		<my:i18n zhText="系统设置" enText="Syetem Setting"/> - 
		<my:i18n zhText="邮箱服务器设置" enText="Mail Server Setting"/>	
	</div>
  </div>
  <div id="result" align="center" style="color: red"></div>
		  <form id="mailServerSetting" action="{ctx}/system/systemSetting_saveMailServerSetting.do" method="post">
		  <input type="hidden" name="mailServerSetting.id" id="id" value="${mailServerSetting.id }">
		  <table width="100%" class="ftable">
           <tr>
            <th align="right" width="18%"><my:i18n zhText="协议(protocol)" enText="Protocol"/>：</th>
            <td>
                <select name="mailServerSetting.protocol">
                    <option value="smtp" <c:if test="${mailServerSetting.protocol=='smtp'}">selected="selected"</c:if>>smtp</option>
                    <option value="pop" <c:if test="${mailServerSetting.protocol=='pop'}">selected="selected"</c:if>>pop3</option>
                </select>
            </td>
          </tr>
          <tr>
            <th><my:i18n zhText="主机(host)" enText="Host"/>：</th>
            <td><input type="text" name="mailServerSetting.host" value="${mailServerSetting.host}" maxlength="20"/><my:i18n zhText="[注：ip地址或域名]" enText="[tip：ip or realm name]"/></td>
          </tr>
           <tr>
            <th><my:i18n zhText="端口(port)" enText="Port"/>：</th>
            <td><input type="text" id="port" name="mailServerSetting.port" value="${mailServerSetting.port}" maxlength="10"/></td>
          </tr>
           <tr>
            <th><my:i18n zhText="账号(username)" enText="Username"/>：</th>
            <td><input type="text" name="mailServerSetting.username" value="${mailServerSetting.username}" maxlength="20"/></td>
          </tr>
           <tr>
            <th><my:i18n zhText="密码(password)" enText="Password"/>：</th>
            <td><input type="text" name="mailServerSetting.password" value="${mailServerSetting.password}" maxlength="20"/></td>
          </tr>
           <tr>
            <th><my:i18n zhText="是否加密(ssl)" enText="Ssl"/>：</th>
            <td><my:radio pvalue="yesornot" name="mailServerSetting.sslYn" value="${mailServerSetting.sslYn}"/> </td>
          </tr>
          <tr>
            <th><my:i18n zhText="说明" enText="Remark"/>：</th>
            <td>
                <my:i18n zhText="通过设置，系统的一些功能将通过该服务器，自动发送邮件。  这些功能包括提醒事项、待办任务、审核通知等。"
                enText="zhe ge wo bu hui fan yi le."/>
            </td>
          </tr>
          <tr>
			<td colspan="2" class="ftablebutton">
			   <input type="button" class="button orange" value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/>
			</td>
	      </tr>
        </table>
        </form>
       </div>
	</body>
</html>