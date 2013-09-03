<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
	<style type="text/css">
.ztree li a:hover {
	text-decoration: none;
}
</style>
	<script type="text/javascript">
	var tolisturl = "${ctx}/student/student_list.do";
	function reportPreview(n) { 
			/*  alert(n); */
			/*  var editid = $("#editid").val();  */
			var url = '${ctx }/report/report_reportlayout.do?exportId=' + n ;
			$.dialog({
				id : 'reportPreview',
				title : '<my:i18n zhText="预览" enText="reportPreview"/>',
				content : 'url:' + url,
				cancelVal : '关闭',
				cancel : true,
				width : '1000px',
				height : '600px'
			});
		}
	
	function reloadStudent(){
			location.href="${ctx}/student/student_list.do";
		}
		
		//预览报表
		function exportPreview(n){
		
				window.location.href="report_exportPdf.do?exportId="+n;
				 method = "post";  				

		}
		//报表的不同导出方法
		function exportexcel(n){

			if('1' == n)
			{
				//alert("相等1");
				window.location.href="report_exportExcelStuAll.do";

			}
			else if('2' == n)
			{
				window.location.href="report_exportExcel.do";
			}
			else if('3' == n)
			{
				window.location.href="report_exportExcelCount.do";
			}
		}
	</script>
</my:head>
<body>
	<div class="bodybox">
		<div class="phead">
			<div class="pheadposition">
				<my:i18n zhText="报表管理" enText="User Mamager" />
				- 报表导出
			</div>
			<%-- <div  class="pheadbutton">
	   <input type="button" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div> --%>
			<div class="clear"></div>
		</div>
		<div id="result" align="center" style="color: red"></div>
		<form id="studentForm" action="student/student_save.do" method="post">
			<input type="hidden" name="id" id="id" value="${id }" />
			<!-- <table width="100%" class="ftable">
				<tr>
					<th width="12%"><my:i18n zhText="年级" />：</th>
					<td><select name="studentList" id="grade_id"
						style="width:100px;">
							<option value="">--请选择--</option>
							<c:forEach items="${studentList}" var="studentList"
								varStatus="status">

								<c:choose>
									<c:when test="${grade_id == studentList.id}">
										<option value="${studentList.id}" selected="selected">${studentList.chStudGrade}</option>
									</c:when>
									<c:otherwise>
										<option value="${studentList.id}">${studentListt.chStudGrade}</option>
									</c:otherwise>
								</c:choose>


							</c:forEach>
					</select></td>
					<th width="12%"><my:i18n zhText="班级" />：</th>
					<td><select name="chclasstreeList" id="clas_id"
						style="width:100px;">
							<option value="">--请选择--</option>
							<c:forEach items="${chclasstreeList}" var="chclasstreeList"
								varStatus="status">

								<c:choose>
									<c:when test="${clas_id == chclasstreeList.id}">
										<option value="${chclasstreeList.id}" selected="selected">${chclasstreeList.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${chclasstreeList.id}">${chclasstreeList.name}</option>
									</c:otherwise>
								</c:choose>


							</c:forEach>
					</select></td>
					<th width="12%"><my:i18n zhText="姓名" />：</th>
					<td><select name="studentList" id="reportList_id"
						style="width:100px;">
							<option value="">--请选择--</option>
							<c:forEach items="${studentList}" var="studentList"
								varStatus="status">

								<c:choose>
									<c:when test="${reportList_id == studentList.id}">
										<c:if test="${studentList.chStudName!=null}">
											<option value="${studentList.id}" selected="selected">${studentList.chStudName}</option>
										</c:if>
									</c:when>

									<c:otherwise>
										<option value="${studentList.id}">${studentList.chStudName}</option>
									</c:otherwise>
								</c:choose>


							</c:forEach>
					</select></td>
				</tr>
				<tr>

				</tr>

			</table>
			 -->
			<table class="ltable" width="100%">
				<thead class="ltablehead">
					<tr>

						<th width="24%"><my:i18n zhText="序号" enText="No." />
						</th>
						<th width="24%"><my:i18n zhText="报表名称" enText="Department" />
						</th>
						<th width="24%"><my:i18n zhText="报表描述" enText="Role" />
						</th>
						<%--<th>入职日期<my:order orderattr="user.registerTime"/></th> --%>
						<th style="width: 24%"><my:i18n zhText="操作" enText="Action" />
						</th>
					</tr>
				</thead>
				
				<tbody class="ltablebody">
					<c:if test="${empty reportList}">
						<tr>
							<td align="center" colspan="7"><font color="red"><my:i18n
										zhText="当前没有报表" enText="No User List" />
							</font></td>
						</tr>
					</c:if>
					<c:forEach items="${reportList}" var="reportList"
						varStatus="status">
						<tr id="${reportList.id }">
							<td align="center"><my:rowNum page="${page}"
									rowIndex="${status.index}" />
							</td>
							<td align="center"><my:i18n zhText="${reportList.chReportName}" />
							</td>
							<td align="center" class="chReportDesc"><c:if
									test="${reportList.chReportDesc!=null}">
									<c:forEach items="${reportList.chReportDesc}">
										<my:i18n zhText="${reportList.chReportDesc}" />
									</c:forEach>
								</c:if></td>
							<%--<td>${user.registerTime}</td> --%>
							<td align="center">
								<my:auth fixedValue="W" value="${auth}">
								<!--
									<input type="button" 
										value="<my:i18n zhText="预览" enText="exportPreview"/>"
										 onclick="exportPreview(${reportList.id });"/>
																	
									<input type="button" 
										value="<my:i18n zhText="报表加载" enText="exportexcel"/>"
										id="exportExcel" onclick="reportPreview${reportList.id });"/> 	 
								-->	
								<!-- 下划线出现 提示操作 -->
								<style>
									a { color blue; text-decoration:none; padding:0px; } 
									a:hover { border-bottom:1px solid red; }
									</style>
																	
									<a href="javascript:reportPreview('${reportList.id}');" id="reportPreview"><my:i18n
											zhText="报表加载" enText="preview" /> </a>
											

								</my:auth>
							
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<tr>
				<td align="center" colspan="6" class="ftablebutton"><input
					type="button" onclick="javascript:reloadStudent(this);"
					class="button orange" class="button orange"
					value="<my:i18n zhText="返回" enText="Reset"/>" /></td>
			</tr>
		</form>

	</div>
</body>