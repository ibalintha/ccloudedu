<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="/mytags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" tree3="true">
	<style type="text/css">
.ztree li a:hover {
	text-decoration: none;
}
.fixedtd{ 
position: relative; 
z-index: 1; 
text-align: center; 
} 

 </style>

	<script type="text/javascript">
		var addnewurl = "${ctx}/student/student_add.do";
		var deleteurl = "${ctx}/student/student_delete.do";
		var exportManageurl = "${ctx}/student/student_exportManage.do";
		
		$(function() {

			//自动分班
			$("#autoStudents")
					.click(
							function() {
								var checked = false;
								var param = "";
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")

										checked = true;
								});

								if (!checked) {
									alert("请先选择学生");
									return false;
								}
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")
										param += $(this).val() + ",";

								});
								//alert(param);
								var url = '${ctx }/student/student_autoStudents.do?id='
										+ param + '';
								$
										.dialog({
											id : 'autoStudents',
											title : '<my:i18n zhText="自动分班" enText="Auto Students"/>',
											content : 'url:' + url,
											cancelVal : '关闭',
											cancel : true,
											width : '500px',
											height : 300
										});
							});

			/* 手动分班 */
			$("#noautoStudents")
					.click(
							function() {
								var checked = false;
								var param = "";
								
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")

										checked = true;
								});

								if (!checked) {
									alert("请先选择学生");
									return false;
								}
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")
									{
										param += $(this).val() + ",";	
 			                            	
										}																				
								});
								
								
								/* alert(param); */
								var url = '${ctx }/student/student_noautoStudents.do?id='
										+ param + '';
								$
										.dialog({
											id : 'noautoStudents',
											title : '<my:i18n zhText="手动分班" enText="NoAuto Students"/>',
											content : 'url:' + url,
											cancelVal : '关闭',
											cancel : true,
											width : '500px',
											height : 300
										});
							});
function validateForm(){
		
		//是否验证通过
		 var valide = true;
	     $(":input[type='text'],:input[type='password'],:input[type='hidden'],select,textarea").each(function(){
			var val = $(this).val();
			var isDisabled = $(this).attr("disabled");
			//验证规则
			var rules = $(this).attr("rules");
			
			if(rules!="undefined" && typeof(rules)!="undefined" && !isDisabled){
				//alert(val+"  "+rules);
				//转化成json
				rules = (new Function("return " + rules))();
				if(rules!=null){
					var labelId = $(this).attr("id");
					if(typeof(labelId)=="undefined"){labelId = $(this).attr("name");}
					if($("label[for='"+labelId+"']").size()==0){
						$(this).after("<label for='"+labelId+"' style=\"color: red\"></label>");
					}
					$("label[for='"+labelId+"']").html("");
						for(var i = 0; i < rules.length; i++) {
							var rule = rules[i];
							if(rule.notNull) {
								if(/^\s*$/i.test(val)) {//非空
									if(typeof(rule.message)!="undefined"){
										$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									}
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							}else if(rule.isNumber) {//只能是浮点数
								if(!$.isNumber(val) && val!="") {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							} else if(rule.isDigit) {//只能是整数
								if(!$.isDigit(val) && val!="") {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							}  else if(rule.isEmail) {//email
								if(!$.isEmail(val) && val!="") {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							} else if(rule.minLength) {//最小长度
								if((val.length <= rule.minLength) && val!="") {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
							    }else{
									$("label[for='"+labelId+"']").html("");
								}
							} else if(rule.maxLength) {//最大长度
								if((val.length >= rule.maxLength)&& val!="") {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							}
							 else if(rule.equalWith) {
								var compareNode = rule.equalWith;
								if(compareNode!="" && val != $("#"+compareNode).val()) {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							} 
							else if(rule.regExp) {//自定义正则表达式
								if(!rule.regExp.test(val) && val!="") {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							} else if(rule.fn) {
								if(rule.fn.call(this, val)) {
									$("label[for='"+labelId+"']").html("").html("&nbsp;&nbsp;"+rule.message);
									valide = false;
									return;
								}else{
									$("label[for='"+labelId+"']").html("");
								}
							}
						}
				   }
			}
		  });
	     if(valide){
	    	 $(":button,:submit,:reset").attr("disabled","disabled");
	     }
		 return valide;
	}
  			function aa(options) {     
				   var defaults = {  
				    	formId:"",
				    	resetForm:true,        /**保存成功后，是否reset Form*/
					    onSubmit:null,        /**提交前的回调函数*/
					    onComplete:null      /**响应完成后的回调函数*/
					};     
					var opts = $.extend(defaults, options); 
					
						if(opts.formId==""){
							alert("请设置form id");
							return;
						}
						$("#"+opts.formId).form('submit', {
				type:"post",
				dataType:"json",
				onSubmit:function(){
				    if (opts.onSubmit!=null) {
				    	opts.onSubmit();
					};
			    	return validateForm();
				},
				error:function(){
					alert($.i18n("errorMsg"));
				},
				success:function(data){//easyui form,server返回json时，contentType需为text/html，否则将提示下载内容
					  //将json字符串转化成json
					  try{
						  data = $.parseJSON(data);
					  }catch(e){
						  //不能解析成json的数据，都当作异常处理
						  $("body").html(data);
						  return;
					  }
					  
					  //不存在msg时，当作异常处理
					  if(data.msg==undefined){
						   $("body").html(data);
						   return;
					   }
					       
					  //data.code不是0时，后台操作失败
					  if(data.code!="0"){
						   var msgtemp = "";
						   if(data.msg!=""){
							   msgtemp = data.msg;
						   }
						   if(data.msgs!=null){
							   msgtemp += data.msgs;
						   }
						   alert(msgtemp);
					  }else{
					       //json主信息
					        alert(data.msg);
					        
						    $(":button,:submit,:reset").removeAttr("disabled");
				      
					        //提交成功后，额外调用的方法
					        if(opts.onComplete!=null) {
					    	    //server传回的其他数据，传递到onComplete方法中,多个数据时，用,号分隔
							    opts.onComplete(data.msgs);
							    //return;
					         }
					      
					         if(opts.resetForm){
						        $("#"+opts.formId)[0].reset();
					         }
					  }
				}
			});
	        
	}
			//建立学籍
			$("#generateStudSchroll").click(
					function() {
						
						var checked = false;
						var param = "";
						var studentid="";
						$("input[name='ids']").each(function() {
							if ($(this).attr("checked") == "checked")

								checked = true;
						});

						if (!checked) {
							alert("请先选择学生");
							return false;
						}
						$("input[name='ids']").each(function() {
							if ($(this).attr("checked") == "checked")
								{
								param += $(this).val() + ",";
								 var bb=	$(this).parent().parent('tr').find("td").eq(2).text();  
								 studentid += bb;	
								}

						});
						if(studentid != ""){
								alert("有学生已存在学籍，请重新选择");
								return false;
								}
						//alert(param);
						 $("#studentForm").attr(
								"action",
								'${ctx }/student/student_generateStudSchroll.do?ids='
										+ param + '&initnumber=001');
		var chClasId = $("#chClasId").val();
		var isLast=$("#isLast").val(); 
		var tolisturl = "${ctx}/student/student_list.do?chClasId="+chClasId+"&isLast="+isLast;
      //  var api = frameElement.api, W = api.opener,cDG;
							aa({ 
				 formId:"studentForm",
				 onComplete:function(){
				    window.location.href=tolisturl;
				 }
			  });
					//	$("#studentForm").submit(); 
						
				

					/* 	 $("#generateStudSchroll").submitForm({ 

				 formId:"studentForm",

				 onComplete:function(){ }
				 }); */

					});

			//学号生成
			$("#generateSchcode")
					.click(
							function() {
								var checked = false;
								var param = "";
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")

										checked = true;
								});
								if (!checked) {
									alert("请先选择学生");
									return false;
								}
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")
										param += $(this).val() + ",";

								});
								var url = '${ctx }/student/student_generateSchcode.do?id='
										+ param + '';
								$
										.dialog({
											id : 'generateSchcode',
											title : '<my:i18n zhText="学号生成" enText="Generate Students"/>',
											content : 'url:' + url,
											cancelVal : '关闭',
											cancel : true,
											width : '500px',
											height : 300
										});
							});
			$("#exportExcel")
					.click(
							function() {
								$("#studentForm").attr("action",
										"${ctx}/student/student_exportPdf.do")
										.submit();
							});
			$("#exportManage").click(function(){window.location.href=exportManageurl;});
			
			$("#searchButton").click(
					function() {
						/* $("#studentForm").attr("action",
								"${ctx}/student/student_list.do").submit(); */
				var url="${ctx}/student/student_queryStudents.do";		
				$.dialog({
					id : 'searchButton',
					title : '<my:i18n zhText="查询" enText="Query Students"/>',
					content : 'url:' + url,
					cancelVal : '关闭',
					cancel : true,
					width : '400px',
					height : 300
				});		
					});
			$("#addnewButton").click(function() {

				$.dialog({
					id : 'addnewButton',
					title : '<my:i18n zhText="新增" enText="Add Students"/>',
					content : 'url:' + addnewurl,
					cancelVal : '关闭',
					cancel : true,
					width : '800px',
					height : 600
				});
				/*  window.location.href=addnewurl; */
			});

		});
		function edit(n) { 
			/*  alert(n); */
			/*  var editid = $("#editid").val();  */
			var url = '${ctx }/student/student_update.do?id=' + n + '';
			$.dialog({
				id : 'edit',
				title : '<my:i18n zhText="编辑" enText="Add Students"/>',
				content : 'url:' + url,
				cancelVal : '关闭',
				cancel : true,
				width : '800px',
				height : 600
			});
		}
		function reloadStudent() {
			location.href = "${ctx}/student/student_list.do";
		}
	</script>

	<script type="Text/JavaScript"> 

	/* $(function() {
	
			 $("#submitBtn").submitForm({ 

				 formId:"studentForm1",

				 onComplete:function(){ 
			//	     var ShopConfirmLayer = document.getElementById("ShopConfirmLayer");
		//	ShopConfirmLayer.style.display = "none";//显示内容层，显示覆盖层 
		 //   close1();
			var trNum=  $("#chthid").val();
			alert(trNum); 
			$('tr:nth-child('+trNum+') td:nth-child(17)').text( $("#chStudBirthplace").val());
			$('tr:nth-child('+trNum+') td:nth-child(5)').text( $("#chStudName1").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(22)').text( $("#chStudAdmway").val()); 
		 	$('tr:nth-child('+trNum+') td:nth-child(32)').text( $("#chStudNational").val()); 
					$('tr:nth-child('+trNum+') td:nth-child(9)').text( $("#chStudEngname").val());  
				   			$('tr:nth-child('+trNum+') td:nth-child(7)').text( $("#chStudEnrolldate").val());  
		 	$('tr:nth-child('+trNum+') td:nth-child(20)').text( $("#chStudHometown").val());  
		  	$('tr:nth-child('+trNum+') td:nth-child(10)').text( $("#chStudOldname").val());  
			$('tr:nth-child('+trNum+') td:nth-child(24)').text( $("#chStudSourareas").val());  
		
	 	$('tr:nth-child('+trNum+') td:nth-child(19)').text( $("#chStudEthnic").val());  
		$('tr:nth-child('+trNum+') td:nth-child(15)').text( $("#chStudSex1").val());  
		$('tr:nth-child('+trNum+') td:nth-child(21)').text( $("#chStudOldschool").val());  
		$('tr:nth-child('+trNum+') td:nth-child(25)').text( $("#chStudHealth").val());  
			$('tr:nth-child('+trNum+') td:nth-child(16)').text( $("#chStudBirth").val());  
	
		$('tr:nth-child('+trNum+') td:nth-child(11)').text( $("#chStudGrade").val());  
	
		$('tr:nth-child('+trNum+') td:nth-child(26)').text( $("#chStudBloodtype").val());  
	
	$('tr:nth-child('+trNum+') td:nth-child(13)').text( $("#chStudPersontype").val());  
	
	$('tr:nth-child('+trNum+') td:nth-child(12)').text( $("#chClasId").val());  
	
	$('tr:nth-child('+trNum+') td:nth-child(28)').text( $("#chStudAddress").val());  
	$('tr:nth-child('+trNum+') td:nth-child(14)').text( $("#chStudPersonid").val());  
	
	$('tr:nth-child('+trNum+') td:nth-child(40)').text( $("#chStudScore").val());  
	
	$('tr:nth-child('+trNum+') td:nth-child(29)').text( $("#chStudLocakind").val());  
	$('tr:nth-child('+trNum+') td:nth-child(33)').text( $("#chStudPhone").val());  
	
	$('tr:nth-child('+trNum+') td:nth-child(38)').text( $("#chStudCadreflag").val());  
	$('tr:nth-child('+trNum+') td:nth-child(30)').text( $("#chStudLocation").val());  
	$('tr:nth-child('+trNum+') td:nth-child(34)').text( $("#chStudTranaddress").val());  
	$('tr:nth-child('+trNum+') td:nth-child(41)').text( $("#chStudSpecial").val());  
	$('tr:nth-child('+trNum+') td:nth-child(31)').text( $("#chStudFlowperson").val());  
	$('tr:nth-child('+trNum+') td:nth-child(35)').text( $("#chStudZip").val());  
	
	$('tr:nth-child('+trNum+') td:nth-child(27)').text( $("#chStudPolface").val());  
	$('tr:nth-child('+trNum+') td:nth-child(23)').text( $("#chStudForeign").val());  
	$('tr:nth-child('+trNum+') td:nth-child(36)').text( $("#chStudEmail").val());  
	$('tr:nth-child('+trNum+') td:nth-child(18)').text( $("#chStudOnly").val());  
	$('tr:nth-child('+trNum+') td:nth-child(37)').text( $("#chStudWebsite").val());  
	$('tr:nth-child('+trNum+') td:nth-child(43)').text( $("#chStudMemo").val());  
	  
			 
				 }
			  });
		}); */

		$(document).ready(function() {
			$(".ltable tr td").dblclick(function() {
			//	open1();
			
			var theid = $(this).parent('tr').attr('id');
			var tdNum = $(this).parent().find('td').index($(this)[0])+ 1; 
			var trNum = $(this).parent().parent().find('tr').index($(this).parent()[0])+ 1;  
			var url='${ctx }/student/student_update.do?id='+theid+'';   
				$.dialog({id:'edit',title:'<my:i18n zhText="编辑" enText="Edit Students"/>',content: 'url:'+url,cancelVal: '关闭',cancel: true,width: '800px',height: 600
				 ,close: function(event, ui) {
							       
							        var sendValue=eval($('#studentframe').val());
									if(sendValue!=null){
							        	var ID=sendValue.ID;
							        	var tr =$("tr[id="+ID+"]");
			                            $("td:eq(4)", $(tr)).html(sendValue.chStudName); 
			   			  $("td:eq(6)", $(tr)).html(sendValue.chStudEnrolldate); 
					          $("td:eq(8)", $(tr)).html(sendValue.chStudEngname); 
		  	                          $("td:eq(9)", $(tr)).html(sendValue.chStudOldname);  
		                                  $("td:eq(10)", $(tr)).html(sendValue.chStudGrade); 
	                                       $("td:eq(11)", $(tr)).html(sendValue.chClasId);  
	                                          $("td:eq(12)", $(tr)).html(sendValue.chStudPersontype);  
	                                          $("td:eq(13)", $(tr)).html(sendValue.chStudPersonid);   
		                                  $("td:eq(14)", $(tr)).html(sendValue.chStudSex);  
			                          $("td:eq(15)", $(tr)).html(sendValue.chStudBirth); 
			                          alert("chStudBirth:"+sendValue.chStudBirth);
                                              //    $("td:eq(16)", $(tr)).html.text(sendValue.chStudBirthplace); 
                                              //   alert("chStudBirthplace:"+sendValue.chStudBirthplace);
	                                          $("td:eq(17)", $(tr)).html(sendValue.chStudOnly); 
                                                  $("td:eq(18)", $(tr)).html(sendValue.chStudHometown);     
		 	                          $("td:eq(19)", $(tr)).html(sendValue.chEthnName);
		                                  $("td:eq(20)", $(tr)).html(sendValue.chStudOldschool); 
			                          $("td:eq(21)", $(tr)).html(sendValue.chStudAdmway); 
	                                          $("td:eq(22)", $(tr)).html(sendValue.chStudForeign); 
			                          $("td:eq(23)", $(tr)).html(sendValue.chStudSourareas);  
		                                  $("td:eq(24)", $(tr)).html(sendValue.chStudHealth); 
                                                  $("td:eq(25)", $(tr)).html(sendValue.chStudBloodtype);  
	                                         $("td:eq(26)", $(tr)).html(sendValue.chStudPolface); 
	                                     //    $("td:eq(27)", $(tr)).html(sendValue.chStudAddress);
                                                $("td:eq(28)", $(tr)).html(sendValue.chStudLocakind);  
	                                       $("td:eq(29)", $(tr)).html(sendValue.chStudLocation);  
	                                       $("td:eq(30)", $(tr)).html(sendValue.chStudFlowperson);	
                                              $("td:eq(31)", $(tr)).html(sendValue.chStudNational); 
	                                      $("td:eq(32)", $(tr)).html(sendValue.chStudPhone);  
	                                      $("td:eq(33)", $(tr)).html(sendValue.chStudTranaddress); 
	                                      $("td:eq(34)", $(tr)).html(sendValue.chStudZip);  
	                                      $("td:eq(35)", $(tr)).html(sendValue.chStudEmail); 
	                                      $("td:eq(36)", $(tr)).html(sendValue.chStudWebsite); 
	                                      $("td:eq(37)", $(tr)).html(sendValue.chStudCadreflag);  
                                          $("td:eq(39)", $(tr)).html(sendValue.chStudScore); 
	                                     // $("td:eq(40)", $(tr)).html.text(sendValue.chStudSpecial);  
	                                      //  alert("sendValue.chStudSpecial:"+sendValue.chStudSpecial); 
	                                      $("td:eq(42)", $(tr)).html(sendValue.chStudMemo);  
	                                        alert("sendValue.chStudMemo:"+sendValue.chStudMemo);

			                          
							        }
				} });
				
				//var au_id = $('#ltable').find('tr:eq(' + (6) + ')').find('td:eq(3)').html();
				 $("#id").val(theid);
				  $("#chthid").val(trNum);
				// alert( $('tr:nth-child('+trNum+') td:nth-child(5)').text());
			
				//var url='${ctx }/student/student_update.do?id='+theid+'';   
				//$.dialog({id:'edit',title:'<my:i18n zhText="编辑" enText="Add Students"/>',content: 'url:'+url,cancelVal: '关闭',cancel: true,width: '800px',height: 600}); 
			});
		})

		function selctEthinc() {
      
            var url = "${ctx}/student/student_ethnic.do";
            
            var value = window.showModalDialog(url,  "dialogwidth:200px;   dialogheight:200px;   center:yes;   Help:No;   Resizable:No;   Status:Yes;   Scroll:Yes;   Status:no;   resizable:no "); //弹出窗口，选择后跳转的界面
            var strs = new Array();
            if (value != null && value != "") {
            var ss=value;
            
            strs=value.split("&");
           
                window.document.getElementById("box2").value =  strs[0]; 
                 window.document.getElementById("chStudEthnic").value =  strs[1]; 
                
            }}
            
          
	</script>

</my:head>
<body >
	<div>
		<div class="phead" style=" position:fixed;width:100%">
			<div class="pheadposition">
				<my:i18n zhText="当前位置" enText="Current Position" />
				：
				<my:i18n zhText="学生管理" enText="Student Mgt" />
				-
				<my:i18n zhText="学生列表" enText="The List Of Students" />
			</div>
			<div class="pheadbutton">
			
				<my:auth fixedValue="W" value="${auth}">
					<input type="button" class="button orange" id="searchButton"
					value="<my:i18n zhText="查询" enText="Search"/>" />
					<input type="button" class="button orange"
						value="<my:i18n zhText="新增" enText="Add A New Student"/>"
						id="addnewButton" />
					<input type="button" class="button orange"
						value="<my:i18n zhText="自动分班" enText="Import Students"/>"
						id="autoStudents" />
					<input type="button" class="button orange"
						value="<my:i18n zhText="手动分班" enText="Export Excel"/>"
						id="noautoStudents" />
					<input type="button" class="button orange"
						value="<my:i18n zhText="学号生成" enText="Export Word"/>"
						id="generateSchcode" />
					<input type="button" class="button orange"
						value="<my:i18n zhText="建立学籍" enText="Export Pdf"/>"
						id="generateStudSchroll" />
					<input type="button" class="button orange"  value="<my:i18n zhText="报表管理" enText="Export Manager"/>"  
					id="exportManage"/>
					
				   
				</my:auth>
			</div>
			<div class="clear"></div>
		</div>
		<form action="${ctx }/student/student_list.do" method="post"
			id="studentForm">
			<input type="hidden" id="chthid" value="${thid}" />
			<input type="hidden" name="chClasId" id="chClasId" value="${chclasstree.id }" /> <input
				type="hidden" name="isLast" id="isLast" value="${chclasstree.isLast }" />
				<input type="hidden" name="chStudSchcode" id="chStudSchcode"
					value="${chStudSchcode }" />			
				<input type="hidden" name="chStudName" id="chStudName"
					value="${chStudName }" />
				<input type="hidden" name="chStudSex" id="chStudSex" value="${chStudSex}" /> 
				
<div  style="position:absolute;top:35px;">
   <div  id="tableContainer"  style="overflow-y: scroll; overflow-x: hidden; height:500px; width:4500px">
			<table id="studentlist" class="ltable" width="4500px">
			
				<thead class="ltablehead" style="width:4500px;">
					<tr id="theadrow">
						<th  width="1%"><input type="checkbox" name="checkId"
							id="checkId" value=""></th>
						<th width="1%"><my:i18n zhText="序号" enText="No." /></th>
						<th  width="2%"><my:i18n zhText="学籍号" enText="chStudSchroll" />
							<my:order orderattr="student.chStudSchroll" /></th>
						<th  width="2%"><my:i18n zhText="学号" enText="chStudSchcode" />
							<my:order orderattr="student.chStudSchcode" /></th>
						<th  width="2%"><my:i18n zhText="姓名" enText="chStudName" /> </th>
						<th  width="2%"><my:i18n zhText="姓名拼音" enText="chStudPinyin" /> </th>
						<th  width="2%"><my:i18n zhText="入学年月"
								enText="chStudEnrolldate" /></th>
						<th  width="2%"><my:i18n zhText="学生类别" enText="chStudType" />
						</th>
						<th  width="2%"><my:i18n zhText="英文姓名" enText="chStudEngname" />
						</th>
						<th  width="2%"><my:i18n zhText="曾用名" enText="chStudOldname" />
						</th>
						<th  width="2%"><my:i18n zhText="年级" enText="chStudGrade" />
						</th>
						<th width="2%"><my:i18n zhText="班级" enText="chClasId" /></th>
						<th  width="2%"><my:i18n zhText="身份证类型"
								enText="chStudPersontype" /></th>
						<th  width="2%"><my:i18n zhText="身份证号码"
								enText="chStudPersonid" /></th>
						<th  width="2%"><my:i18n zhText="性别" enText="chStudSex" />
						</th>
						<th  width="2%"><my:i18n zhText="出生日期" enText="chStudBirth" />
						</th>
						<th  width="2%"><my:i18n zhText="出生地"
								enText="chStudBirthplace" />
						</th>
						<th  width="2%"><my:i18n zhText="独生子女" enText="chStudOnly" />
						</th>
						<th  width="2%"><my:i18n zhText="籍贯"
								enText="chethnic.chEthnName" /></th>
						<th  width="2%"><my:i18n zhText="民族" enText="chStudHometown" />
						</th>
						<th  width="2%"><my:i18n zhText="原学校" enText="chStudOldschool" />
						</th>
						<th  width="2%"><my:i18n zhText="入学方式" enText="chStudAdmway" />
						</th>
						<th  width="2%"><my:i18n zhText="港澳台侨外" enText="chStudForeign" />
						</th>
						<th  width="2%"><my:i18n zhText="来源地区"
								enText="chStudSourareas" />
						</th>
						<th  width="2%"><my:i18n zhText="健康状况" enText="chStudHealth" />
						</th>
						<th  width="2%"><my:i18n zhText="血型" enText="chStudBloodtype" />
						</th>
						<th  width="2%"><my:i18n zhText="政治面貌" enText="chStudPolface" />
						</th>
						<th  width="2%"><my:i18n zhText="现住址" enText="chStudAddress" />
						</th>
						<th  width="2%"><my:i18n zhText="户口性质" enText="chStudLocakind" />
						</th>
						<th width="2%"><my:i18n zhText="户口所在地"
								enText="chStudLocation" />
						</th>
						<th  width="2%"><my:i18n zhText="流动人口"
								enText="chStudFlowperson" />
						</th>
						<th  width="2%"><my:i18n zhText="国籍" enText="chStudNational" />
						</th>
						<th  width="2%"><my:i18n zhText="联系电话" enText="chStudPhone" />
						</th>
						<th  width="2%"><my:i18n zhText="通信地址"
								enText="chStudTranaddress" />
						</th>
						<th  width="2%"><my:i18n zhText="邮政编码" enText="chStudZip" />
						</th>
						<th  width="2%"><my:i18n zhText="电子信箱" enText="chStudEmail" />
						</th>
						<th  width="2%"><my:i18n zhText="主页地址" enText="chStudWebsite" />
						</th>
						<th  width="3%"><my:i18n zhText="是否当过班干部"
								enText="chStudCadreflag" />
						</th>
						<th  width="2%"><my:i18n zhText="照片" enText="chStudImage" />
						</th>
						<th  width="2%"><my:i18n zhText="入学成绩" enText="chStudScore" />
						</th>
						<th  width="2%"><my:i18n zhText="特长" enText="chStudSpecial" />
						</th>
						<th  width="2%"><my:i18n zhText="修改状态"
								enText="chStudUpdateflag" />
						</th>
						<th  width="2%"><my:i18n zhText="备注" enText="chStudMemo" /></th>
						<th  width="3%"><my:i18n zhText="创建时间" enText="chStudMaketime" />
						</th>
						<th  style="width: 2%"><my:i18n zhText="操作" enText="Action" />
						</th>
					</tr>
				</thead>
				
				<tbody class="ltablebody">
					<c:if test="${empty page.list}">
						<tr>
							<td align="center" colspan="7"><font color="red"><my:i18n
										zhText="当前没有学生" enText="No Student List" /> </font>
							</td>
						</tr>
					</c:if>
					<c:forEach items="${page.list}" var="student" varStatus="status">
						<tr id="${student.id }">
							<td align="center"><input type="checkbox" name="ids"
								value="${student.id}" /></td>
							<td align="center"><my:rowNum page="${page}"
									rowIndex="${status.index}" /></td>
							<td><my:i18n zhText="${student.chStudSchroll}"
									enText="${student.chStudSchroll}" /></td>
							<td><my:i18n zhText="${student.chStudSchcode}"
									enText="${student.chStudSchcode}" /></td>
							<td><my:i18n zhText="${student.chStudName}"
									enText="${student.chStudName}" /></td>
							<td><my:i18n zhText="${student.chStudPinyin}"
									enText="${student.chStudPinyin}" /></td>
							<td><my:i18n zhText="${student.chStudEnrolldate}"
									enText="${student.chStudEnrolldate}" /></td>
							<td><my:i18n zhText="${student.chStudType}"
									enText="${student.chStudType}" /></td>
							<td><my:i18n zhText="${student.chStudEngname}"
									enText="${student.chStudEngname}" /></td>
							<td><my:i18n zhText="${student.chStudOldname}"
									enText="${student.chStudOldname}" /></td>
							<td><my:i18n zhText="${student.chStudGrade}"
									enText="${student.chStudGrade}" /></td>
							<td><my:i18n zhText="${student.chClasId}"
									enText="${student.chClasId}" /></td>
							<td><my:i18n zhText="${student.chStudPersontype}"
									enText="${student.chStudPersontype}" /></td>
							<td><my:i18n zhText="${student.chStudPersonid}"
									enText="${student.chStudPersonid}" /></td>
							<td><my:i18n zhText="${student.chStudSex}"
									enText="${student.chStudSex}" /></td>
							<td><my:i18n zhText="${student.chStudBirth}"
									enText="${student.chStudBirth}" /></td>
							<td><my:i18n zhText="${student.chStudBirthplace}"
									enText="${student.chStudBirthplace}" /></td>
							<td><my:i18n zhText="${student.chStudOnly}"
									enText="${student.chStudOnly}" /></td>
							<td><my:i18n zhText="${student.chStudHometown}"
									enText="${student.chStudHometown}" /></td>
							<td><my:i18n zhText="${student.chethnic.chEthnName}"
									enText="${student.chethnic.chEthnName}" /></td>
							<td><my:i18n zhText="${student.chStudOldschool}"
									enText="${student.chStudOldschool}" /></td>
							<td><my:i18n zhText="${student.chStudAdmway}"
									enText="${student.chStudAdmway}" /></td>
							<td><my:i18n zhText="${student.chStudForeign}"
									enText="${student.chStudForeign}" /></td>
							<td><my:i18n zhText="${student.chStudSourareas}"
									enText="${student.chStudSourareas}" /></td>
							<td><my:i18n zhText="${student.chStudHealth}"
									enText="${student.chStudHealth}" /></td>
							<td><my:i18n zhText="${student.chStudBloodtype}"
									enText="${student.chStudBloodtype}" /></td>
							<td><my:i18n zhText="${student.chStudPolface}"
									enText="${student.chStudPolface}" /></td>
							<td><my:i18n zhText="${student.chStudAddress}"
									enText="${student.chStudAddress}" /></td>
							<td><my:i18n zhText="${student.chStudLocakind}"
									enText="${student.chStudLocakind}" /></td>
							<td><my:i18n zhText="${student.chStudLocation}"
									enText="${student.chStudLocation}" /></td>
							<td><my:i18n zhText="${student.chStudFlowperson}"
									enText="${student.chStudFlowperson}" /></td>
							<td><my:i18n zhText="${student.chStudNational}"
									enText="${student.chStudNational}" /></td>
							<td><my:i18n zhText="${student.chStudPhone}"
									enText="${student.chStudPhone}" /></td>
							<td><my:i18n zhText="${student.chStudTranaddress}"
									enText="${student.chStudTranaddress}" /></td>
							<td><my:i18n zhText="${student.chStudZip}"
									enText="${student.chStudZip}" /></td>
							<td><my:i18n zhText="${student.chStudEmail}"
									enText="${student.chStudEmail}" /></td>
							<td><my:i18n zhText="${student.chStudWebsite}"
									enText="${student.chStudWebsite}" /></td>
							<td><my:i18n zhText="${student.chStudCadreflag}"
									enText="${student.chStudCadreflag}" /></td>
							<td><my:i18n zhText="${student.chStudImage}"
									enText="${student.chStudImage}" /></td>
							<td><my:i18n zhText="${student.chStudScore}"
									enText="${student.chStudScore}" /></td>
							<td><my:i18n zhText="${student.chStudSpecial}"
									enText="${student.chStudSpecial}" /></td>
							<td><my:i18n zhText="${student.chStudUpdateflag}"
									enText="${student.chStudUpdateflag}" /></td>
							<td><my:i18n zhText="${student.chStudMemo}"
									enText="${student.chStudMemo}" /></td>
							<td><my:i18n zhText="${student.chStudMaketime}"
									enText="${student.chStudMaketime}" /></td>




							<td align="center"><my:auth fixedValue="W" value="${auth}">
									<a href="javascript:edit('${student.id}');" id="edit"><my:i18n
											zhText="编辑" enText="Edit" /> </a>
									<a href="javascript:" class="deleteOne"
										param="ids=${student.id}"><my:i18n zhText="删除"
											enText="Delete" /> </a>
								</my:auth>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div  class="ltablebottom" style="position:relative;">
				<div style="float: left;">
					<my:auth fixedValue="W" value="${auth}">
						<input type="button" class="button orange"
							value="<my:i18n zhText="批量删除" enText="Batch Delete"/>"
							id="batchDelete" name="batchDelete" />
					</my:auth>
				</div>
				<div class="lpage">
					<my:page page="${page}" />
				</div>
			</div>
	</div>
</div>	
		</form>
	 <input id="studentframe" type="hidden"/>
	</div></body>
</html>