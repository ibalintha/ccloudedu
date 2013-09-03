<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript">
        $(function() {
			$("#submitBtn").submitForm({ 
				formId:"deptForm",
				onComplete:function(id){
					parent.addNode('contentIframe',$("#parentDeptId").val(),id,$("#${locale.language}DeptName").val(),"/system/dept_update.do?id="+id);
				}
			});
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
						<li><a href="${ctx }/system/dept_update.do?id=${id }"><span><my:i18n zhText="本部门信息" enText="Dept Info"/></span></a></li>
						<li><a href="${ctx }/system/dept_list.do?id=${id }"><span><my:i18n zhText="下级部门列表" enText="Sub Dept List"/></span></a></li>
						<li id="current"><a href="${ctx }/system/dept_add.do?id=${id }"><span><my:i18n zhText="新增下级部门" enText="Add A New Dept"/></span></a></li>
					  </ul>
				</div>
			 </td>
			</tr>
		</table>
  </div>
		  <div id="result" align="center" style="color: red"></div>
		  <form id="deptForm" action="system/dept_save.do" method="post">
		  <input type="hidden" name="sysDept.id" id="parentDeptId" value="${sysDept.id }">
		  <table width="100%" class="ftable">
          <c:if test="${!empty sysDept.deptName}">
			    <tr>
		            <th width="18%"><my:i18n zhText="上级部门" enText="Parent Dept"/>：</th>
		            <td>
		               <my:i18n zhText="${sysDept.deptName}" enText="${sysDept.enDeptName}"/>
		            </td>
	          </tr>
		   </c:if>
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="中文部门名称" enText="Chinese Dept Name"/>：</th>
            <td><input type="text" id="zhDeptName" name="deptName" value="${deptName }" rules="[{notNull:true, message:'<my:i18n zhText="请输入部门名称" enText="Please Enter Dept Name"/>'}]"></td>
          </tr>
        
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="英文部门名称" enText="English Dept Name"/>：</th>
            <td><input type="text" id="enDeptName" name="enDeptName" value="${enDeptName }" rules="[{notNull:true, message:'<my:i18n zhText="请输入部门名称" enText="Please Enter Dept Name"/>'}]"></td>
          </tr>
          
           <tr>
            <th><my:i18n zhText="部门电话" enText="Dept Telephone"/>：</th>
            <td><input type="text" name="deptPhone" value="${deptPhone }"></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="部门传真" enText="Dept Fax"/>：</th>
            <td><input type="text" name="deptFax" value="${deptFax }"></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="部门邮箱" enText="Dept Email"/>：</th>
            <td><input type="text" name="deptEmail" value="${deptEmail }" class="email" ></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="联系地址" enText="Address"/>：</th>
            <td><input type="text" name="postAddress" value="${postAddress }"></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="网址" enText="Website"/>：</th>
            <td><input type="text" name="webSite" value="${webSite }"></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="备注" enText="Remark"/>：</th>
            <td><textarea style="width: 600px;height: 60px" name="remark">${remark }</textarea></td>
          </tr>
           <tr>
			<td colspan="2" class="ftablebutton">
				<my:auth fixedValue="W" value="${auth}"><input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/></my:auth>
			</td>
	      </tr>
        </table>
        </form>
        </div>
	</body>
</html>