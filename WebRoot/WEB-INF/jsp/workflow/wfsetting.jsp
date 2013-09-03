<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/mytags"%>
<c:set var="ctx" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true" multiFile="true">
		<script type="text/javascript">
			var addordetail = true;
			$(function() {
				$("#submitBtn").submitForm( {
					formId : "wfsettingForm",
					resetForm:false,
					onComplete : function() {
						//W.reloadProject();
					// api.close();
				    }
				});
			});
			
			function addRow() {
				$("#wfsetttingTable").append($("#templeteTable").html());
			}
			 function copyRow($obj){
	        	$("#wfsetttingTable").append($("#templeteTable").html());
	        	$obj.parent("td").parent("tr").find(":input").each(function (i) {
			       $("#wfsetttingTable tr:last :input").eq(i).val($(this).val());
			    })
	        }
			function deleteRow($obj) {
				if ($("#wfsetttingTable tr").size() > 2) {
					if (confirm("您确定要删除吗")) {
						$obj.parent("td").parent("tr").remove();
					}
				} else {
					alert("总得留一行吧");
					return false;
				}
			}
			function changeWfsetting(){
				window.location.href="${ctx }/workflow/wfsetting_list.do?wfCat="+$("#wfCat").val();
			}
			</script>
</my:head>
<body>
	<div class="bodybox">
		<div class="phead"">
			<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position" />： 流程管理 - 流程设置 - 流程执行设置</div>
			<div class="clear"></div>
		</div>
		<form method="post" action="${ctx }/workflow/wfsetting_save.do" id="wfsettingForm">
				<div class="phead"">
					归属流程：<my:select pvalue="wfCat" name="wfCat" nullValue="false" value="${wfCat}" id="wfCat" onchange="changeWfsetting()"/>
				</div>
				<table width="100%">
					<tr>
						<td style="text-align: center;">
							<table class="ftable" style="text-align: center;" width="100%" id="wfsetttingTable">
								<tr>
									<th style="text-align: center">归属流程</th>
									<th style="text-align: center">当前执行人角色</th>
									<th style="text-align: center">当前流程转向</th>
									<th style="text-align: center">下一步执行人角色</th>
									<th style="text-align: center">下一步执行人操作类型</th>
									<th style="text-align: center">下一步执行人在流程中的变量名</th>
									<th style="text-align: center"><my:i18n zhText="操作" enText="Action"/></th>
								</tr>
								<c:forEach items="${wfExecuteSettingList}" var="cp">
									<tr>
										<td><my:view value="${cp.wfCat}" pvalue="wfCat"/></td>
										<td>
											<select style="width: 110px" name="curExecutorRoles">
												<c:forEach items="${roleList}" var="role">
													<option value="${role.id}" <c:if test="${cp.curRoleId==role.id}">selected="selected"</c:if>>${role.roleName}</option>
												</c:forEach>
											</select>
										</td>
										<td><input type="text" name="transitions" value="${cp.transition}"/></td>
										<td>
											<select style="width: 110px" name="nextExecutorRoles">
											    <option value="">----</option>
												<c:forEach items="${roleList}" var="role">
													<option value="${role.id}" <c:if test="${cp.nextRoleId==role.id}">selected="selected"</c:if>>${role.roleName}</option>
												</c:forEach>
											</select>
										</td>
										<td>
										  <my:select pvalue="${wfCat}" value="${cp.operateType}" name="operateTypes"/>
                                        </td>
										<td><input type="text" name="variableNames" value="${cp.variableName}"/></td>
										<td style="text-align: center;" width="15%">
											<a href="javascript:" title="新增" onclick="addRow()">[新增]</a>
											<a href="javascript:" title="复制" onclick="copyRow($(this))">[复制]</a>
											<a href="javascript:" title="删除" onclick="deleteRow($(this))">[删除]</a>
										</td>
									</tr>
								</c:forEach>
								<c:if test="${empty wfExecuteSettingList}">
									<tr>
										<td><my:view value="${wfCat}" pvalue="wfCat"/></td>
										<td>
											<select style="width: 110px" name="curExecutorRoles">
												<c:forEach items="${roleList}" var="role">
													<option value="${role.id}">${role.roleName}</option>
												</c:forEach>
											</select>
										</td>
                                        <td><input type="text" name="transitions" value=""/></td>
                                        <td>
											<select style="width: 110px" name="nextExecutorRoles">
											    <option value="">----</option>
												<c:forEach items="${roleList}" var="role">
													<option value="${role.id}">${role.roleName}</option>
												</c:forEach>
											</select>
										</td>
										<td>
						                   <my:select pvalue="${wfCat}" name="operateTypes"/>
                                         </td>
                                        <td><input type="text" name="variableNames" value=""/></td>
										<td style="text-align: center;" width="15%">
											<a href="javascript:" title="新增" onclick="addRow()">[新增]</a>
											<a href="javascript:" title="复制" onclick="copyRow($(this))">[复制]</a>
											<a href="javascript:" title="删除" onclick="deleteRow($(this))">[删除]</a>
										</td>
									</tr>
								</c:if>
							</table>
						</td>
					</tr>
					<tr>
						<td class="ftablebutton">
							<input type="button" class="button orange" value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn" />
							&nbsp;
							<input type="reset" class="button orange" value="<my:i18n zhText="重置" enText="Reset"/>" />
						</td>
					</tr>
				</table>
			</form>
			 <c:forEach items="${ddExecuteSettingList}" var="ddes">
	           <c:if test="${!empty ddes.remark && ddes.ddValue==wfCat}">
	              <div class="pfooter" id="${ddes.ddValue}Div"><font color="red">注：${ddes.remark}</font></div>
	           </c:if>
	        </c:forEach> 
		</div>
		<table id="templeteTable" style="display: none">
			<tr>
				<td><my:view value="${wfCat}" pvalue="wfCat"/> </td>
				<td>
					<select style="width: 110px" name="curExecutorRoles">
						<c:forEach items="${roleList}" var="role">
							<option value="${role.id}">${role.roleName}</option>
						</c:forEach>
					</select>
				</td>
				<td><input type="text" name="transitions" value=""/></td>
				<td>
					<select style="width: 110px" name="nextExecutorRoles">
					    <option value="">----</option>
						<c:forEach items="${roleList}" var="role">
							<option value="${role.id}">${role.roleName}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<my:select pvalue="${wfCat}" name="operateTypes"/>
				</td>
                <td><input type="text" name="variableNames" value=""/></td>
				<td style="text-align: center;" width="15%">
					<a href="javascript:" title="新增" onclick="addRow()">[新增]</a>
					<a href="javascript:" title="复制" onclick="copyRow($(this))">[复制]</a>
					<a href="javascript:" title="删除" onclick="deleteRow($(this))">[删除]</a>
				</td>
			</tr>
		</table>
	</body>
</html>