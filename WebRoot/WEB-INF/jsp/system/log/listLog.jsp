<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="my" uri="/mytags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true" tree3="true">
	<link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
 	<style type="text/css">.ztree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
		var deleteurl = "${ctx}/system/log_delete.do";
		$(function() {
			$("#searchButton").click(function(){
				if(($("#startLoginTime").val()!=""&& $("#endLoginTime").val()=="")||($("#startLoginTime").val()==""&& $("#endLoginTime").val()!="")){
					alert("日志的起止时间不能为空！");
					return;
					}
				$("#cmForm").submit();
			});
			$(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
	<div class="phead">
		<div class="pheadposition">
			<my:i18n zhText="当前位置" enText="Current Position"/>： 
			<my:i18n zhText="日志管理" enText="User Login Log"/> -
			<my:i18n zhText="列表" enText="List Logs"/>
		</div>
		<div class="pheadbutton">
			   <my:auth fixedValue="W" value="${auth}">
	   			 <input type="button" class="button orange"  id="searchButton" value="<my:i18n zhText="查询" enText="Search"/>" />
			   </my:auth>
		 </div>
		<div class="clear"></div>
	</div>
	<form id="cmForm" method="post" action="${ctx}/system/log_list.do">
		<div class="psearchhead">
			<my:i18n zhText="日志时间从" enText="Login Time"/>：
				<input type="text" name="startLoginTime" id="startLoginTime" value="${startLoginTime}" class="Wdate" readonly="readonly" />
			<my:i18n zhText="至" enText="To"/>
				<input type="text" name="endLoginTime" id="endLoginTime" value="${endLoginTime}" class="Wdate" readonly="readonly" />
			&nbsp;&nbsp;
			<my:i18n zhText="模块" enText="Function Module"/>
				<select id="chRecdModule" name="chRecdModule" style="width: 140px">
						<option value="" selected="selected">所有模块</option>
						<c:forEach items="${funcList}" var="func" varStatus="status">
								<option value="${func.chFuncName}">
										${func.chFuncName}
								</option>
						</c:forEach>
				</select>
			&nbsp;&nbsp;
			<my:i18n zhText="日志类型" enText="Log Type"/>
				<select id="chRecdType" name="chRecdType" style="width: 140px">
						<option value="">所有类型</option>
						<option value="新增">新增</option>
						<option value="删除">删除</option>
						<option value="系统错误">系统错误</option>
						<option value="其他">其他</option>
				</select>
		</div>
		 <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                	<th width="5%"><input type="checkbox" name="checkId" id="checkId" value=""></th>
			                  	<th width="5%"><my:i18n zhText="选择" enText="No."/></th>
			                  	<th width="10%"><my:i18n zhText="功能模块" enText="Function Module"/><my:order orderattr="recd.chRecdModule"/></th>
			                	<th width="20%"><my:i18n zhText="日志描述" enText="Log Desc"/></th>
			                	<th width="15%"><my:i18n zhText="日志类型" enText="Log Type"/></th>
			                	<th width="10%"><my:i18n zhText="操作用户" enText="Operator User"/></th>
			                	<th width="10%"><my:i18n zhText="日志时间" enText="Create Time"/><my:order orderattr="recd.chRecdTime"/></th>
			                </tr>
			            </thead>
			             <tbody class="ltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="7"><font color="red"><my:i18n zhText="当前没有日志" enText="No Log List"/></font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="recd" varStatus="status">
				              <tr id="${recd.id}" param="ids=${recd.id}">
									<td align="center"><input type="checkbox" name="ids" value="${recd.id}"/></td>
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td align="center"><my:i18n zhText="${recd.chRecdModule}" enText="${recd.chRecdModule}"/></td>
									<td align="center"><my:i18n zhText="${recd.chRecdDesc}" enText="${recd.chRecdDesc}"/></td>
									<td align="center"><my:i18n zhText="${recd.chRecdType}" enText="${recd.chRecdType}"/></td>
									<td align="center"><my:i18n zhText="${recd.chUser.chUsername}(${recd.chUser.chUserIp})" enText="${recd.chUser.chUsername}(${recd.chUser.chUserIp})"/></td>
									<td align="center"><my:i18n zhText="${recd.chRecdTime}" enText="${recd.chRecdTime}"/></td>
								</tr>
				           </c:forEach>
			            </tbody>
		 </table>
	 <div class="ltablebottom">
			 <div style="float: left;"><my:auth fixedValue="W" value="${auth}"><input type="button" class="button orange"  value="<my:i18n zhText="清除日志" enText="Batch Delete"/>" id="batchDelete"/></my:auth></div>
			 <div class="lpage"><my:page page="${page}"/></div> 
	</div>
	</form>
	<div id="menuContentDeptTree" class="menuContentDeptTree" style="display:none; position: absolute;">
			<ul id="deptTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:250px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
	<div id="menuContentRoleTree" class="menuContentRoleTree" style="display:none; position: absolute;">
			<ul id="roleTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:150px;overflow-y:scroll;overflow-x:auto;"></ul>
	</div>
</div>
</body>
</html>