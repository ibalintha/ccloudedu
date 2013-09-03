<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
    <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
		
		function reloadDict(){
			location.href="${ctx}/underlying/dictionary_list.do";
		}
		$(function(){
			var api = frameElement.api, W = api.opener,cDG;
			var module = document.getElementById("module").value;
			var menu = document.getElementById("dictMenu").value;
			module = encodeURI(encodeURI(module));
			menu = encodeURI(encodeURI(menu));
			var tolisturl = "${ctx}/underlying/dictionary_list.do?module=" + module +"&dictMenu=" + menu;
			
			$("#submitBtn").submitForm({
				
				 formId:"dictForm",
				 onComplete:function(){

				 	api.reload(W,tolisturl);
    
				 }
			});
			
			$("#dictSyscode").blur(function(){
				var syscode = $("#dictSyscode").val();
				var dictMenu = $("#dictMenu").val();
				if(syscode == ''){
					$("#codeerror").text("请输入");
					$("#codeerror").show();
					document.getElementById("submitBtn").disabled=true;
					return;
				}
				$.ajax({
					url: "dictionary_validate.do",
					type: 'post',
					data: {"syscode" : syscode , "dictMenu" : dictMenu},				
					success: function(data) {
						var exist = $.parseJSON(data);
						if(exist == true){
							$("#codeerror").text("代码重复");
							$("#codeerror").show();
							document.getElementById("submitBtn").disabled=true;
						} else {
							$("#codeerror").hide();
							document.getElementById("submitBtn").disabled=false;
						}
					},
		    });	
		});
		});

	</script>

</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"> <my:i18n zhText="数据字典" enText="User Mgt"/> - 添加 - ${selectedMenu}</div>
	<%-- <div  class="pheadbutton">
	   <input type="button" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div> --%>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="dictForm" name="dictForm" action="underlying/dictionary_save.do" method="post">
		    <input type="hidden" name="module" id="module" value="${selectedModule}"/>
		    <input type="hidden" name="dictMenu" id="dictMenu" value="${selectedMenu}"/>
		    
		    <table width="100%" class="ftable">     
				<tr>
					<th width="35%"><my:i18n zhText="代码编号" />：</th>
		            <td><input type="text" name="dictSyscode" value="" id="dictSyscode" />
		            	<font color="red" id="codeerror" style="display: none;"></font>	            	
		            </td>
				</tr>
	           	<tr>
		           	<th width="35%"><my:i18n zhText="代码名称" />：</th>
		            <td><input type="text" name="dictName" value="" id="dictName"/></td>
	           	</tr>
	           	<tr>
	           		<th width="35%"><my:i18n zhText="教育局代码" />：</th>
	            	<td><input type="text" name="dictEducode" value="" id="dictEducode"/></td>   
				</tr>
				<tr>
	           		<th width="35%"><my:i18n zhText="状态" />：</th>
	           		<td>
	           			<select name="flag" id="flag" style="width: 80px">
	           				<option value="1">启用</option>
	           				<option value="2">停用</option>
	           			</select>
	           		</td>
				</tr>
				<tr>
	           		<th width="35%"><my:i18n zhText="维护" />：</th>
	           		<td>
		           		<select name="deftype" id="deftype" style="width: 80px">
		           				<option value="1">可维护</option>
		           				<option value="2">仅可查看</option>
		           		</select>
	           		</td>
				</tr>

	           <tr>
				<td colspan="6" class="ftablebutton">
					<input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
					<input type="button" onclick="cancel();" class="button orange"  class="button orange" value="<my:i18n zhText="取消" enText="Cancel"/>"/>
				</td>
		      </tr>
	      
        </table>
        </form>
	   
    </div>
</body>
