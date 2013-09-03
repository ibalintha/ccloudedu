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
			$("#submitBtn").submitForm({formId:"loginRuleSettingForm",resetForm:false});
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
						<li id="current"><a href="${ctx}/system/systemSetting_addRuleSetting.do?ruleType=login"><span><my:i18n zhText="登录规则设置" enText="Login Rule Setting"/></span></a></li>
						<li><a href="${ctx}/system/systemSetting_addRuleSetting.do?ruleType=loginLog"><span><my:i18n zhText="登录日志设置" enText="Login Log Setting"/></span></a></li>
						<li><a href="${ctx}/system/systemSetting_addRuleSetting.do?ruleType=accessLog"><span><my:i18n zhText="系统访问日志设置" enText="System Access Log Setting"/></span></a></li>
					    <li><a href="${ctx}/system/systemSetting_addMailServerSetting.do"><span><my:i18n zhText="邮箱服务器设置" enText="Mail Server Setting"/></span></a></li>
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
		<my:i18n zhText="登录规则设置" enText="Login Rule Setting"/>
	</div>
  </div>
  <div id="result" align="center" style="color: red"></div>
		  <form id="loginRuleSettingForm" action="{ctx}/system/systemSetting_saveRuleSetting.do" method="post">
		  <input type="hidden" name="ruleSetting.id" id="id" value="${ruleSetting.id }">
		   <input type="hidden" name="ruleSetting.ruleType" value="login">
		  <table width="100%" class="ftable">
           <tr>
            <th align="right" width="20%"><my:i18n zhText="同一账号是否可以重复登录" enText="Repeat Login"/>：</th>
            <td id="desks">
                <my:radio pvalue="yesornot" name="ruleSetting.ruleCode" value="${ruleSetting.ruleCode}" br="true"/>
            </td>
          </tr>
          <tr>
			<td colspan="4" class="ftablebutton">
				<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> 
			</td>
	      </tr>
        </table>
        </form>
       </div>
	</body>
</html>