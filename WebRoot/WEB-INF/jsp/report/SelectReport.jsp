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
		<script type="text/javascript" language="javascript">
		
			function saveReport(){
			var checkboxId = "";
		
				//这里我们获取input为checkbox,name为StuL而且是选中的，
				$('input:checkbox[name=StuL][checked]').each(function() {
					checkboxId += $(this).val()+",";
				
				});
		
			//这里我们获取input为checkbox,name为TeachG而且是选中的，
				$('input:checkbox[name=TeachG][checked]').each(function() {
					checkboxId += $(this).val()+",";
				
				});
			
			//这里我们获取input为checkbox,name为SelfV而且是选中的，
				$('input:checkbox[name=SelfV][checked]').each(function() {
					checkboxId += $(this).val()+",";
					
				});
		
			//这里我们获取input为checkbox,name为TeachE而且是选中的，
				$('input:checkbox[name=TeachE][checked]').each(function() {
					checkboxId += $(this).val()+",";
					
				});
				alert(checkboxId);
				window.location.href="${ctx}/report/report_saveReport.do?checkbox="+checkboxId;
		}
		

	/*------判断radio是否有选中，获取选中的值--------*/
	$(function() {
		/*-----全选-----*/
		$('#rdo_checked_all_1').click(function() {
			var is_checked = $('#rdo_checked_all_1').attr('checked');
			if (is_checked == "checked") {
				$('input[name=StuL]').attr('checked', true);
			} else {
				$('input[name=StuL]').attr('checked', false);
			}
		});
		$('#rdo_checked_all_2').click(function() {
			var is_checked = $('#rdo_checked_all_2').attr('checked');
			if (is_checked == "checked") {
				$('input[name=TeachG]').attr('checked', true);
			} else {
				$('input[name=TeachG]').attr('checked', false);
			}
		});
		$('#rdo_checked_all_3').click(function() {
			var is_checked = $('#rdo_checked_all_3').attr('checked');
			if (is_checked == "checked") {
				$('input[name=SelfV]').attr('checked', true);
			} else {
				$('input[name=SelfV]').attr('checked', false);
			}
		});
		$('#rdo_checked_all_4').click(function() {
			var is_checked = $('#rdo_checked_all_4').attr('checked');
			if (is_checked == "checked") {
				$('input[name=TeachE]').attr('checked', true);
			} else {
				$('input[name=TeachE]').attr('checked', false);
			}
		});
		
	});//document ready
</script>

	</my:head>
	<body>

		<div class="phead">
			<div class="pheadposition">
				当前位置： 常用报表类型设置
			</div>
		</div>
		<div id="result" align="center" style="color: red"></div>
		<form id="loginRuleSettingForm"
			action="${ctx}/student/student_saveRep.do" method="post">
			<input type="hidden" name="ruleSetting.id" id="id"
				value="4028823c3b6e9256013b6e9a089c0001">
			<input type="hidden" name="ruleSetting.ruleType" value="login">
			<table width="100%" class="ftable">
				<tr>
					<th align="right" width="20%">
						学习结构水平：
					</th>
					<td id="desks">

					<input type="checkbox"  id="rdo_checked_all_1" />
						<label for="rdo_checked_all_1">
							全选
						</label>
						<br />

						<input type="checkbox" name="StuL" value="StuCard" id="rdo_red" />
						学生学籍卡
						<br />
						<input type="checkbox" name="StuL" value="standardRate"
							id="rdo_yellow" />
						综合档次优良率
						<br />
						<input type="checkbox" name="StuL" value="averageAly"
							id="rdo_blue" />
						平均分分析
						<br />
						<input type="checkbox" name="StuL" value="HLAly" id="rdo_green" />
						高低分分析
						<br />
						<input type="checkbox" name="StuL" value="PlaceCome"
							id="rdo_black" />
						生源类别分析
						<br />
					</td>
				</tr>

				<!-- 第二个 -->
				<tr>
					<th align="right" width="20%">
						教学目标：
					</th>
					<td id="desks">

					<input type="checkbox" id="rdo_checked_all_2" />
						<label for="rdo_checked_all_2">
							全选
						</label>
						<br />

						<input type="checkbox" name="TeachG" value="StuCord" id="rdo_red" />
						试卷成绩查询

						<br />
						<input type="checkbox" name="TeachG" value="standardRate"
							id="rdo_yellow" />
						综合档次优良率
						<br />
						<input type="checkbox" name="TeachG" value="illBack" id="rdo_blue" />
						诊断反馈
						<br />
						<input type="checkbox" name="TeachG" value="BBack" id="rdo_green" />
						反馈汇总
						<br />
						<input type="checkbox" name="TeachG" value="paperAly"
							id="rdo_black" />
						试卷综合分析
						<br />
				
					</td>
				</tr>

				<!-- 第三个 -->
				<tr>
					<th align="right" width="20%">
						自我发展性评价：
					</th>
					<td id="desks">

						<input type="checkbox" name="display" id="rdo_checked_all_3" />
						<label for="rdo_checked_all_3">
							全选
						</label>
						<br />

						<input type="checkbox" name="SelfV" value="StuPgoad" id="rdo_red" />
						个人成绩追踪

						<br />
						<input type="checkbox" name="SelfV" value="StupassRate"
							id="rdo_yellow" />
						及格率系数
						<br />
						<input type="checkbox" name="SelfV" value="StuPrang" id="rdo_blue" />
						班级个人名次追踪
						<br />
						<input type="checkbox" name="SelfV" value="StuBB" id="rdo_green" />
						比值系数
						<br />
						<input type="checkbox" name="SelfV" value="StuWLgoad"
							id="rdo_black" />
						文理历届考分对比
						<br />
				
					</td>
				</tr>
				<!-- 第四个 -->
				<tr>
					<th align="right" width="20%">
						教学有效性分析：
					</th>
					<td id="desks">

						<input type="checkbox" id="rdo_checked_all_4" />
						<label for="rdo_checked_all_4">
							全选
						</label>
						<br />

						<input type="checkbox" name="TeachE" value="TeacherJGG" id="rdo_red" />
						九宫格分析

						<br />
						<input type="checkbox" name="TeachE" value="TeacherST"
							id="rdo_yellow" />
						ST表分析
						<br />
						<input type="checkbox" name="TeachE" value="TeacherBCG"
							id="rdo_blue" />
						BCG表分析
						<br />
						<input type="checkbox" name="TeachE" value="TeacherKGT"
							id="rdo_green" />
						客观题分析
						<br />

					</td>
				</tr>


				<tr>
					<td colspan="4" class="ftablebutton">
						<input type="button" onclick="javascript:saveReport(this);" class="button orange" value="保存"
							id="submitBtn" />
					</td>
				</tr>
			</table>
		</form>

	</body>
</html>