<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
		<style type="text/css">.ztree li a:hover {text-decoration: none;}
		</style>
<script type="text/javascript">
 
	var checkSetting;
	var radioSetting;
	var addordetail = true;
	var tolisturl = "${ctx}/system/user_list.do?roleId=${roleId}";
	var api = frameElement.api,W = api.opener;
	
	$(function() {
        	$("#submitBtn").submitForm( {
			formId : "userForm",
			onComplete : function() {
				api.reload(W,tolisturl);
				api.close();
				window.location.href = tolisturl;
			}
		});
	});
	

	$(function() {

		$("#tolistButton").click(function() {
			//api.reload(W,tolisturl);
			api.close();
			window.location.href = tolisturl;
		});

		//$.fn.zTree.init($("#deptTree"), radioSetting, zNodesDept);
		//$.fn.zTree.init($("#roleTree"), checkSetting, zNodesRole);

		$("#selectDept").click(function() {
			var url = 'system/dept_chooseDept.do?id=' + $("#deptId").val();
			$.dialog( {
				title : '选择部门',
				content : 'url:' + url,
				width : '700px',
				height : 500,
				data : $("#deptId").val()
			});
			$("label[for='deptName']").html("");
		});

		$("#tree :checkbox").change(function() {
			$("label[for='roleIds']").html("");
		})
		
		var rangeId = "";
		var rangeDescription = "";
		var content = "";
		$("#source li").unbind("click").bind("click", function() {
			 rangeDescription = $(this).text();
			 if ($(this).find("input[type=checkbox]:checked").val() != undefined) {
			 	roleId = $(this).attr("id");
			 	addRangeContent(roleId, rangeDescription);
			 } else {
			 	$("tr[id=\'"+roleId+"\']").remove();   
			 }
        });
	});
	
	function zTreeOnChange() {
		$("label[for='roleIds']").html("");
	}
	
	function addRangeContent(roleId,rangeDescription) {
        $.ajax({
			url: "${ctx}/system/user_getRangeByRoleId.do?roleId="+roleId,
			type: 'GET',
			dataType:"json",
			error: function(){
				alert("获取角色的权限范围失败");
			},
			success: function(data){
				if(data!=null && data.length>0) {
					content = "<tr id='"+roleId+"'><td width='20%'>"+rangeDescription+"</td><td  width='80%'>";
	                for(var i=0; i<data.length; i++) {
	                   	var range = data[i];
	                    content += "<input type='checkbox' name='funcIds' id='funcIds' value='"+range.id+"'/>"+range.chRangDesc;
	                }
	                $("#range").append(content+"</td></tr>");
            	}
			}
		});
    }
    
    function checkExistName(){
		var userName=document.getElementById("chUserLogname").value;
		if(userName!=""){
	    	$.ajax({
				url: "${ctx}/system/user_findUserByLogName.do?userName="+userName,
				type: 'POST',
				dataType:"json",
				error: function(){
					alert("查找用户失败");
				},
				success: function(data){
					if(data!=null&&data.length>0){
						alert("该用户已经存在");
						document.getElementById("chUserLogname").value="";
					}
				}
			});
		}
    }
    
    
</script>
	</my:head>
	<body>
		<div class="bodybox">
			<div class="phead">
				<div class="pheadposition">
					<my:i18n zhText="当前位置" enText="Current Position" />
					：
					<my:i18n zhText="用户管理" enText="User Mgt" />
					- 新增用户
				</div>
				<div class="pheadbutton">
					<input type="button" class="button orange"
						value="<my:i18n zhText="返回列表" enText="Return To List Page"/>"
						id="tolistButton" />
				</div>
				<div class="clear"></div>
			</div>
			<div id="result" align="center" style="color: red"></div>
			<form id="userForm" action="system/user_save.do" method="post">
				<input type="hidden" name="id" id="id" value="${id }" />
				<table width="100%" class="ftable">
					<tr>
						<th width="12%">
							<font color="red"></font>关联职工：
						</th>
						<td colspan="3">
							<select id="teacherId" name="teacherId" style="width: 140px">
								<c:forEach items="${teacherList}" var="teacher">
									<option value="${teacher.id }">
										${teacher.chTeacName }
									</option>
								</c:forEach>
							</select>
						</td>
						<th width="12%">
							<font color="red"></font>排序编号：
						</th>
						<td colspan="3">
							<input type="text" name="chUserSortno" value="" id="chUserSortno"></input>
						</td>
					</tr>
					<tr>
						<th width="12%">
							<font color="red">*</font>用户登录名：
						</th>
						<td colspan="3">
							<input type="text" name="chUserLogname" value=""
								id="chUserLogname" onblur="checkExistName()"
								rules="[{notNull:true, message:'<my:i18n zhText="请输入账号" enText="Please Enter Account"/>'}]"></input>
						</td>
						<th width="12%">
							<font color="red">*</font>真实名称：
						</th>
						<td colspan="3">
							<input type="text" name="chUsername" value="" id="chUsername"
								rules="[{notNull:true, message:'<my:i18n zhText="请输入用户名" enText="Please Enter Account"/>'}]"></input>
						</td>
					</tr>
					<tr>
						<th width="12%">
							<font color="red">*</font>登录密码：
						</th>
						<td colspan="3">
							<input type="text" name="chUserPassword" id="chUserPassword"
								value=""
								rules="[{notNull:true, message:'<my:i18n zhText="请输入密码" enText="Please Enter Password"/>'}]"></input>
						</td>
						<th width="12%">
							<font color="red">*</font>用户状态：
						</th>
						<td colspan="3">
							<!--<input type="text" name="chUserState" value="" id="chUserState"  rules="[{notNull:true, message:'<my:i18n zhText="请输入用户状态" enText="Please Enter UserState"/>'}]"></input>
		            -->
							<select id="chUserState" name="chUserState" style="width: 140px">
								<option value="正常">
									正常
								</option>
								<option value="锁定">
									锁定
								</option>
							</select>
						</td>
					</tr>				
				</table>
				
				<table width="100%" class="ftable">
					<tr>
						<td width="20%">
							<span class="targetspanstyle">角色列表</span>
							<div class="divborderstyle">
								<ul id="source">
									<c:forEach items="${roleList}" var="role">
										<li id="${role.id }">
											<input type="checkbox" name="roleIds" id="roleIds" value="${role.id}" />
											${role.chRoleName }
										</li>
									</c:forEach>
								</ul>
							</div>
							<div id="lifeEventToolTips" style="">
							</div>
						</td>
						<td width="2%">
						</td>
						<td width="78%">
							<table id="range" width="100%">
								<tr>
									<td colspan="2" style="text-align: center">
										权限选择
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