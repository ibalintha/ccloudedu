<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript">
		var list=true;
		var deleteAndRemoveTreeNode=true;
		var deleteurl = "${ctx }/system/dept_delete.do";
		$(function() {
			$("#importDept").click(function(){
				var url = '${ctx }/system/dept_toImportDept.do';
				$.dialog({id:'importDept',title:'导入部门',content: 'url:'+url,cancelVal: '关闭', cancel: true,width: '700px', height: 500});
			});
		});
		function reload(){
		    location.reload();
		}
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
						<li id="current"><a href="${ctx }/system/dept_list.do?id=${id }"><span><my:i18n zhText="下级部门列表" enText="Sub Dept List"/></span></a></li>
						<li><a href="${ctx }/system/dept_add.do?id=${id }"><span><my:i18n zhText="新增下级部门" enText="Add A New Dept"/></span></a></li>
					  </ul>
				</div>
			 </td>
			</tr>
		</table>
  </div>
           <my:auth fixedValue="W" value="${auth}">
			<div class="phead">
				<div class="pheadbutton">
					   <input type="button" class="button orange"  value="导入部门"  id="importDept"/>
				</div>
			</div>
		   </my:auth>
		   <form action="${ctx }/system/dept_list.do" method="post" id="deptForm">
		          <input type="hidden" name="id" value="${id }"/>
		           <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                	<th width="5%">
			                	  <input type="checkbox" name="checkId" id="checkId" value="">
			                	 </th>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<%--<th width="20%">上级部门<my:order orderattr="dept.sysDept.deptName"/></th> --%>
			                	<th width="20%"><my:i18n zhText="部门名称" enText="Dept Name"/><my:order orderattr="dept.deptName"/></th>
			                	<th width="15%"><my:i18n zhText="部门电话" enText="Dept Telephone"/><my:order orderattr="dept.deptPhone"/></th>
			                	<th><my:i18n zhText="备注" enText="Remark"/><my:order orderattr="dept.remark"/></th>
			                	<th width="10%"><my:i18n zhText="操作" enText="Action"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="6"><font color="red"><my:i18n zhText="当前部门没有下级部门" enText="There are no Sub Depts"/></font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="dept" varStatus="status">
				             <tr id="${dept.id }">
									<td align="center"><input type="checkbox" name="ids" id="ids" value="${dept.id}"/></td>
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<%--<td>${dept.sysDept.deptName}</td> --%>
									<td>
									   <a href="${ctx }/system/dept_update.do?id=${id}"><my:i18n zhText="${dept.deptName}" enText="${dept.enDeptName}"/></a>
							    	</td>
									<td>${dept.deptPhone}</td>
									<td>${dept.remark}</td>
									<td align="center">	
									   <my:auth fixedValue="W" value="${auth}"><a href="javascript:" class="deleteOne" param="ids=${dept.id}"><my:i18n zhText="删除" enText="Delete"/></a></my:auth>
									</td>
								</tr>
				           </c:forEach>
			            </tbody>
		         </table>
		         <div class="ltablebottom">
		           <div style="float: left;"><my:auth fixedValue="W" value="${auth}"><input type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" id="batchDelete"/></my:auth></div>
			       <div class="lpage"><my:page page="${page}"/></div>  
			  </div>
	       </form>
	    </div>
	</body>
</html>