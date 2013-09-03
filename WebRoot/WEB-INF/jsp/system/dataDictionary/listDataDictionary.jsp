<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head>
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<script type="text/javascript">
		var list=true;
		var deleteAndRemoveTreeNode=true;
		var deleteurl = "${ctx }/system/datadictionary_delete.do";
		$(function() {
			
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
						<li><a href="${ctx }/system/datadictionary_update.do?id=${id }"><span><my:i18n zhText="当前参数信息" enText="Current Param Info"/></span></a></li>
						<li id="current"><a href="${ctx }/system/datadictionary_list.do?id=${id }"><span><my:i18n zhText="下级各项列表" enText="Sub Param List"/></span></a></li>
						<li><a href="${ctx }/system/datadictionary_add.do?id=${id }"><span><my:i18n zhText="新增下级参数" enText="Add A New Param"/></span></a></li>
					</ul>
				</div>
			 </td>
			</tr>
		</table>
  </div>
		   <form action="${ctx }/system/datadictionary_list.do" method="post" id="scoreForm">
		          <input type="hidden" name="id" value="${id }"/>
		           <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                	<th width="5%">
			                	  <input type="checkbox" name="checkId" id="checkId" value="">
			                	 </th>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                	<th><my:i18n zhText="参数名" enText="The Name Of The Param"/></th>
			                	<th><my:i18n zhText="参数值" enText="The Value Of The Param"/></th>
			                	<th><my:i18n zhText="操作" enText="Action"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
			            <c:if test="${empty page.list}">
			                <td colspan="5" align="center"><font color="red"><my:i18n zhText="当前没有数据" enText="No Data Now"/></font></td>
			            </c:if>
			            <c:forEach items="${page.list}" var="dd" varStatus="status">
			                <tr id="${dd.id }">
									<td align="center"><input type="checkbox" name="ids" id="ids" value="${dd.id}"/></td>
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td><my:i18n zhText="${dd.ddName}" enText="${dd.enDdName}"/></td>
									<td>${dd.ddValue}</td>
									<td align="center">	
									   <my:auth fixedValue="W" value="${auth}"><a href="javascript:" class="deleteOne" param="ids=${dd.id}"><my:i18n zhText="删除" enText="Delete"/></a></my:auth>
									</td>
							</tr>
			            </c:forEach>
			            </tbody>
		         </table>
		         <div class="ltablebottom">
		           <div style="float: left;"><my:auth fixedValue="W" value="${auth}"><input type="button" class="button orange" value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" id="batchDelete"/></my:auth></div>
			       <div class="lpage"><my:page page="${page}"/></div>  
			  </div>
	       </form>
	    </div>
	</body>
</html>