<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" multiFile="true">
	<script type="text/javascript">
		var addordetail = true;
		
		$(function(){
		
			$(".number").number();
	    	$(".Wdate").click(function(){
	    		WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});
	        });
	    	
			$("#submitBtn").submitForm({ 
				formId:"userForm",
				onComplete:function(){
				    window.location.href="system/user_toUserBasicInfo.do";
				}
			});
			
			$("#tolistButton").click(function(){window.location.href=tolisturl;});
	       
		});
		function deleteUploadFile(id){
		      if(confirm("您确定要删除吗")){
		          window.location.href="${ctx}/system/user_deleteUserPicture.do?uploadFileId="+id;
	          }
	     }
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 个人中心 - 个人信息</div>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="userForm" action="system/user_updateUserBasicInfo.do" method="post" enctype="multipart/form-data">
		    <input type="hidden" name="id" id="id" value="${user.id }">
		    <table width="100%" class="ftable">
	           <tr>
	            <td colspan="5" style="padding-left: 20px"><b><my:i18n zhText="登录信息" enText="The Info Of Login"/></b></td>
	          </tr>
          <tr>
            <th width="12%"><font color="red">*</font>帐号：</th>
            <td width="24%" colspan="4">
              <input type="text" name="loginName" value="${user.loginName}" id="loginName"  rules="[{notNull:true, message:'<my:i18n zhText="请输入账号" enText="Please Enter Account"/>'}]"></input>
            </td>
           </tr>
          <tr>
            <td colspan="5" style="padding-left: 20px"><b><my:i18n zhText="基本信息" enText="Basic Infomation"/></b></td>
          </tr>
          <tr>
            <th width="12%">姓名：</th>
            <td width="24%">${user.userName}</td>
            <th width="12%"><my:i18n zhText="性别" enText="Gender"/>：</th>
            <td><my:view value="${user.sex}" pvalue="sex"/></td>
            <td width="25%" rowspan="6" align="left" style="border: none;">
                <c:if test="${empty uploadFileList}">
			       <img alt="照片" src="${ctx}/js_css_image/images/nophoto.gif" width="160px" height="160px" border="0">
			    </c:if>
			    <c:forEach items="${uploadFileList}" var="upfile">
			      <img alt="照片" src="${ctx}/${upfile.uploadFilePath}" width="160px" height="160px" border="0">
			      <a href="javascript:" title="删掉" onclick="deleteUploadFile('${upfile.id}')">[删除]</a>
			    </c:forEach>
            </td>
          </tr>
         
           <tr>
            <th ><my:i18n zhText="部门" enText="Deptment"/>：</th>
            <td>
                ${user.sysDept.deptName}
                <input type="hidden" name="deptId" id="deptId" value="${user.sysDept.id}"/>
            </td>
            <th ><my:i18n zhText="角色" enText="Role"/>：</th>
            <td>
               ${roleNames}
                <input type="hidden" name="roleIds" id="roleIds" value="${roleIds}"/>
            </td>
          </tr>
           <tr>
            <th >入职时间：</th>
            <td>${user.registerTime}</td>
            <th >生日：</th>
            <td><input type="text" name="birthday" value="${user.birthday}" id="birthday" maxlength="30" readonly="readonly" class="Wdate"/></td>
          </tr>
            <tr>
            <th >办公电话：</th>
            <td><input type="text" name="ophone" value="${user.ophone}" id="ophone" class="number" number="20" rules="[{isDigit:true, message:'只能是数字'}]"/></td>
            <th >手机：</th>
            <td><input type="text" name="mphone" value="${user.mphone}" id="mphone" class="number" number="11" rules="[{isDigit:true, message:'只能是数字'}]"/></td>
          </tr>
           <tr>
            <th >QQ：</th>
            <td><input type="text" name="qq" value="${user.qq}" id="qq" class="number" number="15" rules="[{isDigit:true, message:'只能是数字'}]"/></td>
            <th >MSN：</th>
            <td><input type="text" name="msn" value="${user.msn}" id="msn" maxlength="30"/></td>
          </tr>
           <tr>
            <th ><a class="trigger" href="javascript:;" rel="targetBox" style="text-decoration: underline">公司邮箱</a>：</th>
            <td colspan="3"><input type="text" name="mailbox" value="${user.mailbox}" id="mailbox" maxlength="30"/></td>
            <%--
            <th ><a class="trigger" href="javascript:;" rel="targetBox" style="text-decoration: underline">邮箱密码</a>：</th>
            <td><input type="text" name="mailboxPassword" value="${user.mailboxPassword}" id="mailboxPassword" maxlength="30"/></td>
             --%>
          </tr>
          <tr>
            <th >办公地点：</th>
            <td colspan="4">
              <input type="text" name="workPlace" value="${user.workPlace}" id="workPlace" size="50"/>
            </td>
          </tr>
          <tr>
		     <th width="15%" >上传照片：</th>
		     <td colspan="4">
		       <input type="file"  class="multi" <c:if test="${!empty uploadFileList}">disabled="disabled"</c:if> id="upload" name="upload" size="50" maxlength="1" accept="gif|jpg|png|bmp|jpeg"/>
		    </td>
	      </tr>
          <%-- 
          <tr>
            <th >我的桌面：</th>
            <td colspan="4">
              <my:checkbox pvalue="zmsz" name="myselfDesk" value="${user.myselfDesk}"/>
            </td>
          </tr> --%>
           <tr>
			<td colspan="5" class="ftablebutton">
				<my:auth fixedValue="W" value="${auth}">
				   <input type="button" class="button orange" class="button orange"  value="确认修改" id="submitBtn"/> &nbsp; 
				</my:auth>
			</td>
	      </tr>
        </table>
        </form>
    </div>
    
    <div id="targetBox" class="shadow target_box dn" style="display: none">
		<div class="target_list">
	    	邮箱信息：系统的一些功能会自动发送邮件，如工作提醒等，这时需要接收方的邮箱地址。
	    </div>
   </div>
</body>
</html>