huan<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/mytags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<my:head lhgdialog="true" tree3="true">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


	</my:head>
	<script type="text/javascript">
	
	var selectfunId ="${exportId}";
	
	function gradegetSelectedOption(){
		//value = obj.options[obj.options.selectedIndex].text;
		var grade = document.getElementById("grade_id").value;
		$.ajax({
				url: "report_classmenu.do",
				type: 'post',
				data: {"grade" : grade},				
				success: function(data) {
					var obj = $.parseJSON(data);
					//alert(obj);
					var classid = document.getElementById("class_id");
						//人数统计表
					if(selectfunId == '3')	
						$('#myframe').attr("src","report_exportByStuCount.do");		
					else{	
						classid.innerHTML = "<option>--请选择--</option>";
						$.each(obj, function(i, item){
							classid.innerHTML = classid.innerHTML +
							 "<option value=\"" + item + "\">" + item + "</option>";
						});
					}
					
				},
		 });
	}
	function classgetSelectedOption(obj){
	
	var valueclass = obj.options[obj.options.selectedIndex].text;

		$.ajax({
						url: "report_classReport.do",
						type: 'post',
						data: {"valueclass" : valueclass},				
						success: function(data) {
							var obj = $.parseJSON(data);	
							//alert(selectfunId);	
							var nameid = document.getElementById("name_id");
							if(selectfunId == '1')	
								$('#myframe').attr("src","report_exportByclass.do");
							else{	
								nameid.innerHTML = "<option>--请选择--</option>";
								$.each(obj, function(i, item){
									 nameid.innerHTML = nameid.innerHTML +
									 "<option value=\"" + item + "\">" + item + "</option>";
								});
							}	
						},
				});
	}
	function namegetSelectedOption(obj){
		//value = obj.options[obj.options.selectedIndex].text;
		var valuename = obj.options[obj.options.selectedIndex].text;
		
		$.ajax({
				url: "report_nameReport.do",
				type: 'post',
				data: {"valuename" : valuename},				
				success: function(data) {
					var obj = $.parseJSON(data);
					//alert(obj);	
					//如果弹出的窗口是导出学籍卡
					if(selectfunId == '2')				
					$('#myframe').attr("src","report_exportByname.do");
				},
		 });
	}

	
  		//预览报表
		function exportPreview(n){
		
				//window.location.href="report_exportByIdPdf.do?exportId="+n;
				//method = "post";  		
				//document.frames["myframe"].location.href="student_exportPdf.do?exportId="+n;	

		}
  		//报表的不同导出方法
		function exportexcel(n){

			if('1' == n)
			{
				//alert("相等1");
				window.location.href="report_exportStuByclassExcel.do";
				//$('#myframe').attr("src","www.baidu.com");
								 
		
								 
		
			}
			else if('2' == n)
			{
				window.location.href="report_exportStuCardExcel.do";
				//$('#myframe').attr("src","student_exportExcel.do");
			}
			else if('3' == n)
			{
				window.location.href="report_exportStuCountExcel.do";
			}
		}
  
  </script>
	<body>
		<div style="width: 100%; height: 100%; overflow: scroll;">
			<table bgcolor="#ffffff" border="2px" cellspacing="2px"
				style="width: 100%; height: 100%; border: #b4cfcf 1px solid;">
				<tr>
					<td width="20%" style="border: 2px;">
						<table bgcolor="#EFEFEF" width="100%" height="100%">
							<tr height="30px">
								<th width="40%">
									<my:i18n zhText="年级" />
									：
								</th>
								<td width="60%">
									<select style="width: 100px;" name="chgradetreeList"
										id="grade_id" onchange="gradegetSelectedOption();">
										<option value="">
											--请选择--
										</option>
										<option value="高2013级"
											<c:if test="${ChSchoolroll.chStudSex eq '0'}">selected="selected"</c:if>>
											高2013级
										</option>
										<option value="初2013级"
											<c:if test="${ChSchoolroll.chStudSex eq '1'}">selected="selected"</c:if>>
											初2013级
										</option>
									</select>
								</td>
							</tr>
							<tr height="30px">
								<th width="40%">
									<my:i18n zhText="班级" />
									：
								</th>
								<td width="60%">
									<select name="chclasstreeList" id="class_id"
										onchange="classgetSelectedOption(this);" style="width: 100px;">
										<option value="">
											--请选择--
										</option>

									</select>
								</td>
							</tr>
							<tr height="30px">
								<th width="40%">
									<my:i18n zhText="学生" />
									：
								</th>
								<td width="60%">
									<select name="studentList" id="name_id"
										onchange="namegetSelectedOption(this);" style="width: 100px;">
										<option value="">
											--请选择--
										</option>
										<!-- 
										<c:forEach items="${studentList}" var="studentList"
											varStatus="status">

											<c:choose>
												<c:when test="${reportList_id == studentList.id}">
													<c:if test="${studentList.chStudName!=null}">
														<option value="${studentList.id}" selected="selected">
															${studentList.chStudName}
														</option>
													</c:if>
												</c:when>

												<c:otherwise>
													<option value="${studentList.id}">
														${studentList.chStudName}
													</option>
												</c:otherwise>
											</c:choose>


										</c:forEach>
										 -->
									</select>
								</td>
							</tr>

							<tr height="80px">
								<td colspan="7" align="center">
									<input type="button" class="button orange" id="previewButton"
										value="<my:i18n zhText="打印预览" enText="Preview"/>"
										onclick="exportPreview(${exportId});" />
									&nbsp;
									<input type="button" " class="button orange"
										value="<my:i18n zhText="Excel导出" enText="Output"/>"
										onclick="exportexcel(${exportId});" />
								</td>
							</tr>
							<tr height="400px">
								<td></td>
								<td></td>
							</tr>
						</table>
					</td>

					<td width="80%" bgcolor="#EFEFEF">

						<div style="height: 100%; width: 100%;">

							<iframe src="" id="myframe" frameborder="0" scrolling="auto"
								height="100%" width="100%" style="border: solid 1px #56BFEC;"></iframe>

						</div>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
