<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head tree3="true">
    <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>
     <script type="text/javascript">
        var api = frameElement.api, W = api.opener, D = W.document;
		var list=true;
		//dept数据
		var curDeptId = "${deptId}";
		var treeNodeArrayDept = new Array();
		<c:forEach items="${deptList}" var="dept">
				 var pId = "${dept.sysDept.id}";
				 var id = "${dept.id}";
				 var name = "${dept.deptName}";
				 var checked =false;
				 var open = false;
				 if(pId==""){open = true; }
			     if(curDeptId==id){checked = true; open = true;}
				 var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",checked:'+checked+',open:'+open+'}';
				 treeNodeArrayDept.push(oneTreeNode);
		</c:forEach>
	    var zNodeStrDept = '['+treeNodeArrayDept.join(",")+']';
	 	var zNodesDept = (new Function("return " + zNodeStrDept))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
		
		//role 数据
		var checkIds = "${roleIds}";
		var checkedIdArray = new Array();
		if(checkIds!=""){checkedIdArray = checkIds.split(",");}
	    var treeNodeArrayRole = new Array();
        <c:forEach items="${roleList}" var="role">
			    var pId = "${role.sysRole.id}";
			    var id = "${role.id}";
			    var name = "${role.roleName}";
			    var checked =false;
				if($.containObj(checkedIdArray,id)){
					checked = true;
				}
			    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",checked:'+checked+', open:true}';
			    treeNodeArrayRole.push(oneTreeNode);
        </c:forEach>
        var zNodeStrRole = '['+treeNodeArrayRole.join(",")+']';
        var zNodesRole = (new Function("return " + zNodeStrRole))();//;eval('(' + zNodeStrRole + ')'); 两种方式转化成json，选其一
		
        
		$(function() {
			$.fn.zTree.init($("#deptTree"), radioSetting, zNodesDept);
			$.fn.zTree.init($("#roleTree"), radioSetting, zNodesRole);
			
			$("#searchButton").click(function(){$("#userForm").submit();});
			
			$("#clearDept").click(function(){
				$("#deptName,#deptId").val("");
			});
			$("#clearRole").click(function(){
				$("#roleNames,#roleIds").val("");
			});
			
			//var receiverId = api.get('onlineUser').document.getElementById('receiverId').value;
			
		});
              api.button(
				{
					name: '确定',
					callback: function(){//deptName deptId
						 //receiverNames receiverIds
	                     //api.close();
					    var receiverName="";
					    var receiverId="";
					    $("input[name=ids]:checked").each(function(){
					    	var v = $(this).val();
							receiverName += v.split(",")[1]+",";
							receiverId += v.split(",")[0]+",";
						});
					    if (receiverName.length > 0 ) receiverName = receiverName.substring(0, receiverName.length-1);
			            if (receiverId.length > 0 ) receiverId = receiverId.substring(0, receiverId.length-1);
			            
				         api.get('onlineUser').document.getElementById('receiverName').value = receiverName;//给父窗口赋值
				         api.get('onlineUser').document.getElementById('receiverId').value = receiverId;//给父窗口赋值
				         api.close();
				         return false;
					},
					focus: true
				},
				{
					name: '取消'
				}
	           );
	</script>
</my:head>
<body>
<div class="bodybox">
	   <div class="phead">
			<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：选择用户 - <my:i18n zhText="用户列表" enText="The List Of Users"/> 
			</div>
			<div class="pheadbutton">
			   <input type="button" class="button orange"  id="searchButton" value="<my:i18n zhText="查询" enText="Search"/>" />
			</div>
			<div class="clear"></div>
			</div>
		   <form action="${ctx }/system/user_chooseUser.do" method="post" id="userForm">
			   <div class="psearchhead">
				姓名：<input type="text" name="userName" id="userName" value="${userName }" size="10"/>&nbsp;&nbsp;
				部门：<input id="deptName" type="text" name="deptName" readonly="readonly"size="15"  value="${deptName}"  onclick="showTreeList('deptTree'); return false;"/>&nbsp;<a style="cursor: pointer;" id="clearDept">[清空]</a>&nbsp;
                <input type="hidden" name="deptId" id="deptId" value="${deptId}"/> 
                                          角色：<input id="roleNames" type="text" readonly="readonly" name="roleNames" size="15" value="${roleNames}" onclick="showTreeList('roleTree'); return false;"/>&nbsp;<a style="cursor: pointer;" id="clearRole">[清空]</a>
                <input type="hidden" name="roleIds" id="roleIds" value="${roleIds}" />
			  </div>
		           <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                	<th width="5%">
			                	  <input type="checkbox" name="checkId" id="checkId" value="">
			                	 </th>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                	<th width="10%">用户姓名<my:order orderattr="user.userName"/></th>
			                	<th width="10%"><my:i18n zhText="性别" enText="Gender"/><my:order orderattr="user.sex"/></th>
			                	<th width="15%"><my:i18n zhText="部门" enText="Deptment"/><my:order orderattr="user.sysDept.deptName"/></th>
			                	<th width="15%"><my:i18n zhText="角色" enText="Role"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="7"><font color="red">当前没有用户</font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="user" varStatus="status">
				              <tr id="${id }">
									<td><input type="checkbox" name="ids" value="${user.id},${user.userName}"/></td>
									<td><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td>${user.userName}</td>
									<td><my:view value="${user.sex}" pvalue="sex"/> </td>
									<td>${user.sysDept.deptName }</td>
									<td>
									   <c:if test="${user.sysRoles!=null}">
									       <c:forEach items="${user.sysRoles}" var="role">
									          ${role.roleName}&nbsp;
									       </c:forEach>
									   </c:if>
									</td>
								</tr>
				              </c:forEach>
			            </tbody>
		         </table>
		       <div class="ltablebottom">
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