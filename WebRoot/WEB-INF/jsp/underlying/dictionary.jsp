<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>   
<my:head lhgdialog="true" tree3="true">
	<link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
  
	<script type="text/javascript">
		var deleteurl = "${ctx}/underlying/dictionary_delete.do";
	
		function selModule(){
			var module = document.getElementById("module").value;
			var dictMenu = document.getElementById("dictMenu");
			if(module == "请选择"){
				dictMenu.innerHTML = "<option>请选择</option>";
				return;
			}
			$.ajax({
				url: "dictionary_menu.do",
				type: 'post',
				data: {"module" : module},				
				success: function(data) {
					var obj = $.parseJSON(data);
					dictMenu.innerHTML = "<option>请选择</option>";
					$.each(obj, function(i, item){
						dictMenu.innerHTML =dictMenu.innerHTML +
						 "<option value=\"" + item + "\">" + item + "</option>";
					});
				},
		    });
		}
		
		function selMenu(){
			var module = document.getElementById("module").value;
			var menu = document.getElementById("dictMenu").value;
			if(menu == "请选择"){
				return;
			}
			$("#dictionaryForm").submit();
		}
		
		function cancelupdate(){
			var editBody = document.getElementById("editBody");
			editBody.style.display = "none";
		}
		
	
	$(function() {
		$("#dictSyscode").blur(function(){
			var syscode = $("#dictSyscode").val();
			var dictMenu = $("#dictMenu").val();
			if(syscode == ''){
				$("#codeerror").text("请输入");
				$("#codeerror").show();
				document.getElementById("updateBtn").disabled=true;
				return;
			}
			if($("#oldSyscode").val() == syscode){
				$("#codeerror").hide();
				document.getElementById("updateBtn").disabled=false;
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
						document.getElementById("updateBtn").disabled=true;
					} else {
						$("#codeerror").hide();
						document.getElementById("updateBtn").disabled=false;
					}
				},
		    });	
		});
		
		$("#addBtn").click(function() {
			var menu = document.getElementById("dictMenu").value;
			if(menu == "请选择"){
				alert("请选择字典模块和菜单");
				return;
			}
			var module = document.getElementById("module").value;
			menu = encodeURI(encodeURI(menu));
			module = encodeURI(encodeURI(module));
			$.dialog({
				id : 'addBtn',
				title : '<my:i18n zhText="新增" enText="Add Students"/>',
				content : 'url:' + '${ctx}/underlying/dictionary_add.do?module=' + module +'&dictMenu=' + menu,
				cancelVal : '关闭',
				cancel : true,
				width : '350px',
				height : '240px'
			});
			/*  window.location.href=addnewurl; */
		});	
		
		
		$(".ltable tr td").dblclick(function() {
			var menu = document.getElementById("dictMenu").value;
			if(menu == "请选择"){
				alert("请选择字典菜单");
				return;
			}
			var theid = $(this).parent('tr').attr('id');
			var tdNum = $(this).parent().find('td').index($(this)[0])+ 1; 
			var trNum = $(this).parent().parent().find('tr').index($(this).parent()[0])+ 1;
			
			var tab = document.getElementById("dicttable");
			if(tab.rows[trNum].cells[5].innerHTML == '仅可查看'){
				alert("该系统数据不可维护");
				return;
			}
			$("#codeerror").hide();
			
			var editBody = document.getElementById("editBody");
			editBody.style.display = "block";
			editBody.style.left = "300px";
			editBody.style.top = "100px";
			$("#p").panel('open');
			$("#rowid").val(trNum);
			$("#dictId").val(theid);
			$("#oldSyscode").val(tab.rows[trNum].cells[1].innerHTML);
			$("#dictSyscode").val(tab.rows[trNum].cells[1].innerHTML);
			$("#dictName").val(tab.rows[trNum].cells[3].innerHTML);
			$("#dictEducode").val(tab.rows[trNum].cells[2].innerHTML);
			if(tab.rows[trNum].cells[4].innerHTML == '启用'){
				$("#flag").val(1);
			}else{
				$("#flag").val(2);
			}
			if(tab.rows[trNum].cells[5].innerHTML == '可维护'){
				$("#deftype").val(1);
			}else{
				$("#deftype").val(2);
			}			
		});
		
		$("#updateBtn").submitForm({ 
			formId:"editForm",
			onComplete:function(){
				
				var editBody = document.getElementById("editBody");
				editBody.style.display = "none";
				var trNum=  $("#rowid").val();	
				var tab = document.getElementById("dicttable");
				
				tab.rows[trNum].cells[1].innerHTML = $("#dictSyscode").val();
				tab.rows[trNum].cells[2].innerHTML = $("#dictEducode").val();
				tab.rows[trNum].cells[3].innerHTML = $("#dictName").val();
				if($("#flag").val() == 1){
					tab.rows[trNum].cells[4].innerHTML = '启用';
				} else {
					tab.rows[trNum].cells[4].innerHTML = '停用';
				}
				if($("#deftype").val() == 1){
					tab.rows[trNum].cells[5].innerHTML = '可维护';
				} else {
					tab.rows[trNum].cells[5].innerHTML = '仅可查看';
				}
			}
		});
	});
	

		
	</script>
</my:head>
<body>
	<div class="bodybox">
		<div class="phead">
			<div class="pheadposition">
				<my:i18n zhText="当前位置" enText="Current Position"/>:<my:i18n zhText="基础数据" enText="Student Mgt"/> - <my:i18n zhText="数据字典" enText="Enrollment Information"/> 
		    </div><br><br>
			
		</div>
		<div id="formDiv" >
		<form action="${ctx }/underlying/dictionary_list.do" method="post" id="dictionaryForm">
		<div class="pSearchHead">
				<span>&nbsp</span>
				<my:i18n zhText="模块" enText="chModule"/>：
				<select name="module" id="module" style="width: 80px" onchange="selModule();">
					<option>请选择</option>
					<c:forEach items="${modules}" var="module" varStatus="status">			
					<option value="${module}" <c:if test="${module eq selectedModule}">selected</c:if> >${module}</option>		
					</c:forEach>
					<option value="all" <c:if test="${selectedModule eq 'all'}">selected</c:if>>所有模块</option>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;
				<my:i18n zhText="字典菜单" enText="chDictMenu"/>：
				<select name="dictMenu" id="dictMenu" style="width: 80px" onchange="selMenu();">
					<option>请选择</option>
					<c:forEach items="${dictMenus}" var="menu" varStatus="status">
					<option value="${menu}" <c:if test="${menu eq selectedMenu}">selected</c:if> >${menu}</option>		
					</c:forEach>
				</select>&nbsp;&nbsp;
			</div>

				
			
				<div id="tableDiv" style="width:99%;overflow-x: auto;"">
				 	<table id="dicttable" class="ltable" width="99%" id="myTable">
						<thead class="ltablehead">
					    	<tr id="tab tr">
					        	<th width="10 px"><input type="checkbox" name="checkId" id="checkId" value=""></th>
					            <th width="20 px"><my:i18n zhText="代码编号" enText="syscode" /></th>
					            <th width="20 px"><my:i18n zhText="教育局代码" enText="educode"/></th>
					            <th width="50 px"><my:i18n zhText="代码名称" enText="name"/></th>
					            <th width="20 px"><my:i18n zhText="状态" enText="flag"/></th>
					            <th width="50 px"><my:i18n zhText="维护" enText="deftype"/></th>
								<th width="10 px" style="display:none"><my:i18n zhText="操作" enText="Action" />
						</th>
							</tr>
						</thead>
						<tbody class="ltablebody">
							<c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="7"><font color="red"><my:i18n zhText="当前没有数据" enText="No Dictionary List"/></font> </td>
							    </tr>
				        	</c:if>
				        	<c:forEach items="${page.list}" var="ChDataDict" varStatus="status">
				              <tr id="${ChDataDict.id}">
				              	<td align="center" width="10 px"><input type="checkbox" name="ids" value="${ChDataDict.id}"></td>
					            <td align="center" width="20 px"><my:i18n zhText="${ChDataDict.chDadtSyscode}" enText="${ChDataDict.chDadtSyscode}"/></td>
					            <td align="center" width="20 px"><my:i18n zhText="${ChDataDict.chDadtEducode}" enText="${ChDataDict.chDadtEducode}"/></td>
					            <td align="center" width="50 px"><my:i18n zhText="${ChDataDict.chDadtName}" enText="${ChDataDict.chDadtName}"/></td>
					            <c:choose>
					            	<c:when test="${ChDataDict.chDadtFlag eq 1}">
					            		<td align="center" width="20 px"><my:i18n zhText="启用" enText="used"/></td>
					            	</c:when>
					            	<c:otherwise>
					            		<td align="center" width="20 px"><my:i18n zhText="停用" enText="unused"/></td>            		
					            	</c:otherwise>
					            </c:choose>
					            <c:choose>
					            	<c:when test="${ChDataDict.chDadtDeftype eq 1}">
					            		<td align="center" width="20 px"><my:i18n zhText="可维护" enText="can maintenance"/></td>
					            	</c:when>
					            	<c:otherwise>
					            		<td align="center" width="20 px"><my:i18n zhText="仅可查看" enText="only can view"/></td>            		
					            	</c:otherwise>
					            </c:choose>
					            
					            <td align="center" style="display:none">
									<a href="javascript:edit('${ChDataDict.id}');" id="edit"><my:i18n
											zhText="编辑" enText="Edit" /> </a>
									<a href="javascript:" class="deleteOne"
										param="ids=${ChDataDict.id}"><my:i18n zhText="删除"
											enText="Delete" /> </a>					
								</td>
					          </tr>
				            </c:forEach>
						</tbody>
					</table>
				</div>
				<div class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div>	
				<div class="pMenuHead">
				
						<input type="button" class="button orange"  value="<my:i18n zhText="新增" enText="AddNew"/>"  id="addBtn"/>
						<input type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Delete"/>"  id="batchDelete" name="batchDelete"/>
				
				</div>
			</form>
		</div>		
	</div>
	
	<div id="editBody" style="position:fixed;background-color:#fff;z-index:900;border:0px #fff solid;width:350px;display:none">
	<div id="p" class="easyui-panel" style="width:350px;height:240px;padding:0px;"
				data-options="title:'编辑数据字典',iconCls:'icon-save',
						collapsible:true,minimizable:false,maximizable:false,closable:true">

	<div class="bodybox" style="top:0px;background-color:#fff;left:0px;z-index:300;border:0px #fff solid;width:350px;">
	
	<div style="height:440px;background:#fafafa;padding:5px;">
		  <form id="editForm" name="editForm" action="underlying/dictionary_update.do" method="post">
		    <input type="hidden" name="module" id="module" value="${selectedModule}"/>
		    <input type="hidden" name="dictMenu" id="dictMenu" value="${selectedMenu}"/>
		    <input type="hidden" name="dictId" id="dictId" value=""/>
		    <input type="hidden" name="rowid" id="rowid" value=""/>
		    <input type="hidden" name="oldSyscode" id="oldSyscode" value=""/>
		    <table width="100%" class="ftable">     
				<tr>
					<th width="35%"><my:i18n zhText="代码编号" />：</th>
		            <td><input type="text" name="dictSyscode" value="" id="dictSyscode" />
		   				<font color="red" id="codeerror" style="display: none;"></font>
		            </td>
					
				</tr>
	           	<tr>
	           		<th width="35%"><my:i18n zhText="教育局代码" />：</th>
	            	<td><input type="text" name="dictEducode" value="" id="dictEducode"/></td>   
				</tr>
				<tr>
		           	<th width="35%"><my:i18n zhText="代码名称" />：</th>
		            <td><input type="text" name="dictName" value="" id="dictName"/></td>
	           	</tr>
				<tr>
	           		<th width="35%"><my:i18n zhText="状态" />：</th>
	           		<td>
	           			<select name="flag" id="flag" style="width: 80px">
							<option value="1"
								<c:if test="${ChDataDict.chDadtFlag eq 1}">selected</c:if>>
								启用</option>
							<option value="2"
								<c:if test="${ChDataDict.chDadtFlag eq 2}">selected</c:if>>
								停用</option>
	           			</select>
	           		</td>
				</tr>
				<tr>
	           		<th width="35%"><my:i18n zhText="维护" />：</th>
	           		<td>
		           		<select name="deftype" id="deftype" style="width: 80px">
		           			<option value="1"
								<c:if test="${ChDataDict.chDadtDeftype eq 1}">selected</c:if>>
								可维护</option>
							<option value="2"
								<c:if test="${ChDataDict.chDadtDeftype eq 2}">selected</c:if>>
								仅可查看</option>
		           		</select>
	           		</td>
				</tr>
	           <tr>
				<td colspan="6" class="ftablebutton">
					<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="updateBtn"/> &nbsp; 
					<input type="button" onclick="cancelupdate();" class="button orange" value="<my:i18n zhText="取消" enText="Cancel"/>"/>
				</td>
		      </tr>
	      
        </table>
        </form>
	</div>
    </div>
	</div>
	</div>

	
  </body>
</html>
