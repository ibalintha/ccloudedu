<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
    <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
	    var checkSetting;
	    var radioSetting;
		var addordetail = true;
		var tolisturl = "${ctx}/student/student_list.do?deptId=${deptId}&roleId=${roleId}";
		
		//dept数据
		var curDeptId = "${user.sysDept.id}";
		var treeNodeArrayDept = new Array();
		<c:forEach items="${deptList}" var="dept">
				 var pId = "${dept.sysDept.id}";
				 var id = "${dept.id}";
				 var name = "<my:i18n zhText="${dept.deptName}" enText="${dept.enDeptName}"/>";
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
			    var name = "<my:i18n zhText="${role.roleName}" enText="${role.enRoleName}"/>";
			    var checked =false;
				if($.containObj(checkedIdArray,id)){
					checked = true;
				}
			    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",checked:'+checked+', open:true}';
			    treeNodeArrayRole.push(oneTreeNode);
        </c:forEach>
        var zNodeStrRole = '['+treeNodeArrayRole.join(",")+']';
        var zNodesRole = (new Function("return " + zNodeStrRole))();//;eval('(' + zNodeStrRole + ')'); 两种方式转化成json，选其一
        
		$(function(){
			$(".number").number();
	    	$(".Wdate").click(function(){
	    		WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});
	        });
	    	//$("#showPassword").click(function(){$(".passWord").showHidePassword();});
	    	
	    	//setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
			//zTree = $("#tree").zTree(setting, zNodes);
			$.fn.zTree.init($("#deptTree"), radioSetting, zNodesDept);
			$.fn.zTree.init($("#roleTree"), checkSetting, zNodesRole);
			
			$("#submitBtn").submitForm({ 
				formId:"userForm",
				onComplete:function(){
				    window.location.href = tolisturl;
				}
			});
			
			$("#tolistButton").click(function(){window.location.href=tolisturl;});
			
	        $("#selectDept").click(function(){
				var url = 'system/dept_chooseDept.do?id='+$("#deptId").val();
				$.dialog({
					title:'选择部门',
					content: 'url:'+url,
				    width: '700px',
				    height: 500 ,
				    data:$("#deptId").val()
				});
				$("label[for='deptName']").html("");
			});
	        
	        $("#exportExcel").click(function(){
				$("#userForm").attr("action","${ctx }/system/userreport_exportExcelDetail.do").submit();
			});
			$("#exportWord").click(function(){
				$("#userForm").attr("action","${ctx }/system/userreport_exportWordDetail.do").submit();
			});
			$("#exportPdf").click(function(){
				$("#userForm").attr("action","${ctx }/system/userreport_exportPdfDetail.do").submit();
			});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="用户管理" enText="User Mgt"/> - 用户信息</div>
	<div  class="pheadbutton">
	   <input type="button" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="userForm" action="student/student_save.do" method="post">
		    <input type="hidden" name="id" id="id" value="${id }"/>
		    <table width="100%" class="ftable">
	           <tr>
	            <td colspan="4" style="padding-left: 20px"><b><my:i18n zhText="登录信息" enText="The Info Of Login"/></b></td>
	          </tr>
          <tr>
            <th width="12%"><font color="red">*</font>帐号：</th>
            <td colspan="3">
              <input type="text" name="loginName" value="${loginName}" id="loginName"  rules="[{notNull:true, message:'<my:i18n zhText="请输入账号" enText="Please Enter Account"/>'}]"></input>
            </td>
           </tr>
          <tr>
            <td colspan="4" style="padding-left: 20px"><b><my:i18n zhText="基本信息" enText="Basic Infomation"/></b></td>
          </tr>
          
           <tr>
            <th width="12%"><font color="red">*</font><my:i18n zhText="中文姓名" enText="Chinese Name"/>：</th>
            <td><input type="text" name="userName" value="${userName}" id="userName" rules="[{notNull:true, message:'<my:i18n zhText="请输入姓名" enText="Please Enter User Name"/>'}]"/></td>
            <th width="12%"><font color="red">*</font><my:i18n zhText="英文姓名" enText="English Name"/>：</th>
            <td><input type="text" name="enUserName" value="${enUserName}" id="enUserName"/></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="出生日期" enText="Birthday"/>：</th>
            <td><input type="text" name="birthday" value="${birthday}" id="birthday" class="Wdate"/></td>
            <th ><font color="red">*</font><my:i18n zhText="性别" enText="Gender"/>：</th>
            <td><my:radio pvalue="sex"  name="sex" value="${sex}"/></td>
          </tr>
          <!-- 
           <tr>
            <th >是否在职：</td>
            <td><input type="radio" name="status" value="1" checked="checked">在职
	            <input type="radio" name="status" value="2" >离职
	            <input type="radio" name="status" value="3" >退休
	            <input type="radio" name="status" value="4" >临时离岗
            </td>
          </tr>
          <tr>
            <th >入职时间：</td>
            <td><input type="text" name="entranceTime" value="${entranceTime }" class="Wdate" readonly="readonly"></td>
          </tr>
           <tr>
            <th >离职时间：</td>
            <td><input type="text" name="dimissionTime" value="${dimissionTime }" class="Wdate" readonly="readonly"></td>
          </tr>
           -->
           <tr>
            <th ><font color="red">*</font><my:i18n zhText="部门" enText="Deptment"/>：</th>
            <td>
                <input id="deptName" type="text" readonly="readonly" value="<my:i18n zhText="${user.sysDept.deptName}" enText="${user.sysDept.enDeptName}"/>"  rules="[{notNull:true, message:'部门不能为空'}]" onclick="showTreeList('deptTree'); return false;"/>
                <%--
                 <my:auth fixedValue="W" value="${auth}">&nbsp;<a id="menuBtnDept" style="cursor: pointer;" onclick="showTreeList('deptTree'); return false;">选择</a></my:auth>
                 <my:auth fixedValue="W" value="${auth}"><a style="cursor: pointer;" id="selectDept">另一种方式选择部门</a></my:auth>
                 --%>
                <input type="hidden" name="deptId" id="deptId" value="${user.sysDept.id}"/>
            </td>
            <th ><font color="red">*</font><my:i18n zhText="角色" enText="Role"/>：</th>
            <td>
                <input id="roleNames" type="text" readonly="readonly" value="<my:i18n zhText="${roleNames}" enText="${enRoleNames}"/>"  rules="[{notNull:true, message:'角色不能为空'}]" onclick="showTreeList('roleTree'); return false;"/>
               <%-- <my:auth fixedValue="W" value="${auth}">&nbsp;<a id="menuBtnRole" style="cursor: pointer;" onclick="showTreeList('roleTree'); return false;">选择</a></my:auth> --%>
                <input type="hidden" name="roleIds" id="roleIds" value="${roleIds}"/>
                <%--
                   <select name="roleId"> 
	                 <c:forEach items="${roleList}" var="role">
	                   <option value="${role.id }">${role.roleName }</option>
	                  </c:forEach>
	             </select>
                 --%>
            </td>
          </tr>
           <tr>
            <th ><my:i18n zhText="办公电话" enText="Office Telephone"/>：</th>
            <td><input type="text" name="ophone" value="${ophone}" id="ophone" class="number" number="20" rules="[{isDigit:true, message:'只能是数字'}]"/></td>
            <th ><my:i18n zhText="手机" enText="Moblie Telephone"/>：</th>
            <td><input type="text" name="mphone" value="${mphone}" id="mphone" class="number" number="11" rules="[{isDigit:true, message:'只能是数字'}]"/></td>
          </tr>
           <tr>
            <th ><font color="red">*</font><my:i18n zhText="邮箱" enText="Email"/>：</th>
            <td><input type="text" name="mailbox" value="${mailbox}" id="mailbox" rules="[{notNull:true, message:'<my:i18n zhText="请输入公司邮箱" enText="Please Enter Email"/>'},{isEmail:true,message:'电子邮件格式不正确'}]"/></td>
            <th ><font color="red">*</font>入职时间：</th>
            <td><input type="text" name="registerTime" value="${registerTime}" class="Wdate" readonly="readonly" title="请选择入职时间" rules="[{notNull:true, message:'入职时间不能为空'}]"/></td>
          </tr>
          <tr>
            <th >超级管理员：</th>
            <td colspan="3">
              <my:radio pvalue="yesornot" name="userRoleType" value="${userRoleType}"/>
            </td>
          </tr>
          <tr>
            <th >办公地点：</th>
            <td colspan="3">
              <input type="text" name="workPlace" value="${workPlace}" id="workPlace" size="50"/>
            </td>
          </tr>
          <%--
          <tr>
            <th>用户类型：</th>
             <td>
                <input type="radio" name="userRoleType" value="1" <c:if test="${userRoleType=='1'}">checked="checked"</c:if>/>系统管理员&nbsp;&nbsp;&nbsp;
                <input type="radio" name="userRoleType" value="2" <c:if test="${userRoleType=='2'}">checked="checked"</c:if>/>普通用户
            </td>
          </tr>
          
          <tr>
            <th >桌面设置：</th>
            <td colspan="3">
              <my:checkbox pvalue="zmsz" name="myselfDesk" value="${myselfDesk}"/>
            </td>
          </tr>
          --%>
           <tr>
			<td colspan="4" class="ftablebutton">
				<my:auth fixedValue="W" value="${auth}">
				   <input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
				   <input type="reset" class="button orange"  class="button orange" value="<my:i18n zhText="重置" enText="Reset"/>"/>
				   <!--
				   <input type="button" class="button orange"  value="<my:i18n zhText="导出excel" enText="Export Excel"/>"  id="exportExcel"/>
				   <input type="button" class="button orange"  value="<my:i18n zhText="导出word" enText="Export Word"/>"  id="exportWord"/>
				   <input type="button" class="button orange"  value="<my:i18n zhText="导出pdf" enText="Export Pdf"/>"  id="exportPdf"/>
				   -->
				</my:auth>
			</td>
	      </tr>
        </table>
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