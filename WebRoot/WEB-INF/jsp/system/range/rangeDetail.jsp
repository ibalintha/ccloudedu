<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head>
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<script type="text/javascript">
		var addordetail = true;
		var tolisturl = "${ctx}/system/range_list.do?roleId=${roleId}";
		var api = frameElement.api,W = api.opener;
		var rangeArr=new Array();
		 $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"rangeForm",
				 resetForm:false,
				 onSubmit:function(event){
				 		 var ids="";
						 $("input[name='deptIds']").each(function(){
							if ($(this).attr("checked") == "checked")
								ids += ","+$(this).val();
							});
							ids = ids.substring(1);
							$("#checkId").val(ids);
							rangeArr=ids.split(",");
							if(ids==""||rangeArr.length>1){
								alert("权限范围当且只能选一个");
								event.preventDefault();
							}else
						return true;
				 
				 },
				 onComplete:function(){
						api.reload(W,tolisturl);
						api.close();
						window.location.href = tolisturl;
				 }
			 });
			 
			 $("#tolistButton").click(function() {
					api.close();
					window.location.href = tolisturl;
			});
	 });
	</script>
</my:head>
<body>
<div class="bodybox">
	<div class="phead">
				<div class="pheadposition">
					<my:i18n zhText="当前位置" enText="Current Position" />
					：
					<my:i18n zhText="权限管理" enText="Range Mgt" />
					- 新增
				</div>
				<div class="pheadbutton">
					<input type="button" class="button orange"
						value="<my:i18n zhText="返回列表" enText="Return To List Page"/>"
						id="tolistButton" />
				</div>
				<div class="clear"></div>
		</div>
		<div id="result" align="center" style="color: red"></div>
			<form id="rangeForm" action="system/range_save.do" method="post">
				<input type="hidden" name="id" id="id" value="${id }" />
				<input type="hidden" name="checkId" id="checkId" value="">
				<table width="100%" class="ftable">
					<tr>
						<th width="12%">
							<font color="red">*</font>所属角色：
						</th>
						<td colspan="3">
							<select id="roleId" name="roleId" style="width: 140px">
								<c:forEach items="${roleList}" var="role">
									<option value="${role.id }"
										<c:if test="${chRange.chRole.chRoleName eq role.chRoleName}">selected="selected"</c:if> />${role.chRoleName}
									</option>
								</c:forEach>
							</select>
						</td>
						
						<th width="12%">
							<font color="red"></font>备注：
						</th>
						<td colspan="3">
							<input type="text" name="chRangMemo" value="${chRange.chRangMemo}" id="chRangMemo"></input>
						</td>
					</tr>
				</table>
				<table width="100%" class="ftable">
					<tr>
						<th width="12%" align="center"><font color="red">*</font>选择权限范围：</th>
						<td>
							<table width="100%" class="ftable">
								<tr>
									<th width="12%" align="center"><my:i18n zhText="部门" enText="Dept"/>：</th>
									<td id="range" colspan="3" width="78%">
										<c:forEach items="${deptList}" var="dept"> 
						            			<input type="checkbox" name="deptIds" value="${dept.id}"
						            					<c:if test="${dept.chDepaName eq chRange.chRangDesc}" >checked="checked"</c:if>
						            			 />${dept.chDepaName}
						            	 </c:forEach>
						            </td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table width="100%" class="ftable">
					<tr>
						<td colspan="4" class="ftablebutton">
							<my:auth fixedValue="W" value="${auth}">
								<input type="button" class="button orange" class="button orange"
									value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn" /> &nbsp; 
					   <input type="reset" class="button orange" class="button orange"
									value="<my:i18n zhText="重置" enText="Reset"/>" />
							</my:auth>
						</td>
					</tr>
				</table>
			</form>
		
</div>
</body>
</html>