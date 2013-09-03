<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
		var addnewurl = "${ctx}/underlying/campus_add.do";
		var deleteurl = "${ctx}/underlying/campus_delete.do";
		var exportManageurl = "${ctx}/underlying/campus_exportManage.do";
		
		
	$(function(){

			//导出excel
			$("#exportExcel")
					.click(
							function() {
								$("#campusForm").attr("action",
										"${ctx}/underlying/campus_exportPdf.do")
										.submit();
							});
			$("#exportManage").click(function(){window.location.href=exportManageurl;});
			
			$("#searchButton").click(
					function() {//实现增加和查询
						/* $("#studentForm").attr("action",
								"${ctx}/student/student_list.do").submit(); */
				var url="${ctx}/underlying/campus_queryCampus.do";		
				$.dialog({
					id : 'searchButton',
					title : '<my:i18n zhText="查询" enText="Query Campus"/>',
					content : 'url:' + url,
					cancelVal : '关闭',
					cancel : true,
					width : '400px',
					height : 300
				});		
					});
			$("#addBtn").click(function() {
               alert("进入添加环节");
				$.dialog({
					id : 'addBtn',
					title : '<my:i18n zhText="新增" enText="Add Campus"/>',
					content : 'url:' + addnewurl,
					cancelVal : '关闭',
					cancel : true,
					width : '800px',
					height : 600
				});
				/*  window.location.href=addnewurl; */
			});
      });
		
		
		function edit() { //实现编辑
		alert("进入编辑环节");
			/*  alert(n); */
			/*  var editid = $("#editid").val();  */
			var checked = false;
								var param = "";
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")

										checked = true;
								});

								if (!checked) {
									alert("请先选择校区");
									return false;
								}
								$("input[name='ids']").each(function() {
									if ($(this).attr("checked") == "checked")
										param += $(this).val();

								});
			var url = '${ctx }/underlying/campus_edit.do?id=' + param + '';
			$.dialog({
				id : 'edit',
				title : '<my:i18n zhText="编辑" enText="Edit Campus"/>',
				content : 'url:' + url,
				cancelVal : '关闭',
				cancel : true,
				width : '800px',
				height : 600
			});
		}
		function reloadCampus() {
			location.href = "${ctx}/underlying/campus_list.do";
		}
	</script>

	<script type="Text/JavaScript">  
    function init() {
    alert(document.getElementById("theadrow").style.top);
    document.getElementById("theadrow").style.top = document.getElementById("tableContainer").scrollTop+"px";
    alert(document.getElementById(document.getElementById("tableContainer").scrollLeft); 
    document.getElementById("ltablebottom").style.left=document.getElementById("tableContainer").scrollLeft+"px";
   }
    function open1(){
			$('#p').panel('open');
		}
		function close1(){
			$('#p').panel('close');
		}
	
	 $(function() {
	
			 $("#submitBtn").submitForm({ 

				 formId:"campusForm1",

				 onComplete:function(){ 
				     var ShopConfirmLayer = document.getElementById("ShopConfirmLayer");
			ShopConfirmLayer.style.display = "none";//显示内容层，显示覆盖层 
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
		}); 

		$(document).ready(function() {
			$(".ltable tr td").dblclick(function() {
				open1();
				ShopConfirm("sss");
				var theid = $(this).parent('tr').attr('id');
				var tdNum = $(this).parent().find('td').index($(this)[0])+ 1; 
				var trNum = $(this).parent().parent().find('tr').index($(this).parent()[0])+ 1;  
				//var au_id = $('#ltable').find('tr:eq(' + (6) + ')').find('td:eq(3)').html();
				 $("#id").val(theid);
				  $("#chthid").val(trNum);
				// alert( $('tr:nth-child('+trNum+') td:nth-child(5)').text());
				 $("#chStudSchcode1").val($('tr:nth-child('+trNum+') td:nth-child(3)').text()); 
				$("#chStudType1").val($('tr:nth-child('+trNum+') td:nth-child(8)').text());
				$("#chStudBirthplace").val($('tr:nth-child('+trNum+') td:nth-child(8)').text());
				$("#chStudName1").val($('tr:nth-child('+trNum+') td:nth-child(5)').text());
				$("#chStudAdmway").val($('tr:nth-child('+trNum+') td:nth-child(22)').text());
				$("#chStudNational").val($('tr:nth-child('+trNum+') td:nth-child(32)').text());
				$("#chStudEngname").val($('tr:nth-child('+trNum+') td:nth-child(9)').text());
				$("#chStudEnrolldate").val($('tr:nth-child('+trNum+') td:nth-child(7)').text());
				$("#chStudHometown").val($('tr:nth-child('+trNum+') td:nth-child(17)').text());
				$("#chStudOldname").val($('tr:nth-child('+trNum+') td:nth-child(10)').text());
				$("#chStudSourareas").val($('tr:nth-child('+trNum+') td:nth-child(24)').text());
				$("#chStudEthnic").val($('tr:nth-child('+trNum+') td:nth-child(20)').text());
				$("#chStudSex1").val($('tr:nth-child('+trNum+') td:nth-child(15)').text());
				$("#chStudOldschool").val($('tr:nth-child('+trNum+') td:nth-child(21)').text()); 
				$("#chStudHealth").val($('tr:nth-child('+trNum+') td:nth-child(25)').text()); 
				$("#chStudBirth").val($('tr:nth-child('+trNum+') td:nth-child(16)').text());
				$("#chStudGrade").val($('tr:nth-child('+trNum+') td:nth-child(12)').text());
				$("#chStudBloodtype").val($('tr:nth-child('+trNum+') td:nth-child(26)').text()); 
				$("#chStudPersontype").val($('tr:nth-child('+trNum+') td:nth-child(13)').text()); 
				$("#chClasId").val($('tr:nth-child('+trNum+') td:nth-child(12)').text());
				$("#chStudAddress").val($('tr:nth-child('+trNum+') td:nth-child(28)').text());
				$("#chStudPersonid").val($('tr:nth-child('+trNum+') td:nth-child(14)').text());
				$("#chStudScore").val($('tr:nth-child('+trNum+') td:nth-child(40)').text());
				$("#chStudLocakind").val($('tr:nth-child('+trNum+') td:nth-child(29)').text());
				$("#chStudPhone").val($('tr:nth-child('+trNum+') td:nth-child(33)').text());
				$("#chStudCadreflag").val($('tr:nth-child('+trNum+') td:nth-child(38)').text());
				$("#chStudLocation").val($('tr:nth-child('+trNum+') td:nth-child(30)').text());
				$("#chStudTranaddress").val($('tr:nth-child('+trNum+') td:nth-child(34)').text());
				$("#chStudSpecial").val($('tr:nth-child('+trNum+') td:nth-child(41)').text());
				$("#chStudFlowperson").val($('tr:nth-child('+trNum+') td:nth-child(31)').text());
				$("#chStudZip").val($('tr:nth-child('+trNum+') td:nth-child(35)').text());
				$("#chStudPolface").val($('tr:nth-child('+trNum+') td:nth-child(27)').text());
				$("#chStudForeign").val($('tr:nth-child('+trNum+') td:nth-child(23)').text());
				$("#chStudEmail").val($('tr:nth-child('+trNum+') td:nth-child(36)').text());
				$("#chStudOnly").val($('tr:nth-child('+trNum+') td:nth-child(18)').text()); 
				$("#chStudWebsite").val($('tr:nth-child('+trNum+') td:nth-child(37)').text()); 
				$("#chStudMemo").val($('tr:nth-child('+trNum+') td:nth-child(43)').text()); 
				//var url='${ctx }/student/student_update.do?id='+theid+'';   
				//$.dialog({id:'edit',title:'<my:i18n zhText="编辑" enText="Add Students"/>',content: 'url:'+url,cancelVal: '关闭',cancel: true,width: '800px',height: 600}); 
			});
		})

		function ShopConfirm(str) {
			var ShopConfirmLayer = document.getElementById("ShopConfirmLayer");
			ShopConfirmLayer.style.display = "block";//显示内容层，显示覆盖层
			//ShopConfirmLayer.style.left = parseInt((document.documentElement.scrollWidth - ShopConfirmLayer.offsetWidth) / 2)
					//+ document.documentElement.scrollLeft + "px";
					ShopConfirmLayer.style.left =   "50px";
					ShopConfirmLayer.style.top="100px";
		//	ShopConfirmLayer.style.top = Math
			//		.abs(parseInt((document.documentElement.clientHeight - ShopConfirmLayer.offsetHeight) / 2))
				//	+ document.documentElement.scrollTop 
				//	+ "px"; //为内容层设置位置
				
			// 	webBgLayer.style.display=""; 
			// 	webBgLayer.style.height=document.documentElement.scrollHeight+"px"; //为覆盖层设置高度 
		}

		function cancelupdate() {
			var ShopConfirmLayer = document.getElementById("ShopConfirmLayer");
			ShopConfirmLayer.style.display = "none";//显示内容层，显示覆盖层
		}
	</script>

</my:head>
<body>
<div class="bodybox">
  <div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="基础数据" enText="underlying"/> - <my:i18n zhText="校区信息" enText="chCampus"/>  
	<c:if test="${!empty menu.menuPath}">${menu.menuName }</c:if></div>
	<div class="pheadbutton">
	   <c:if test="${!empty menu.menuPath}">
	       <input type="button" class="button orange"  id="addnewButton" value="新增sql/hql语句" />
	   </c:if>
	</div>
	<div class="clear"></div>
  </div>
  <form action="${ctx }/underlying/campus_list.do" method="post" id="querySqlHqlForm">
	 <input type="hidden" name="menuId" value="${menuId }"/>
	 <table class="ltable" width="100%">
		<thead class="ltablehead">
			<tr>
			  <th width="5%"><input type="checkbox" name="checkId" id="ids" value=""></th>
			  <th width="10%"><my:i18n zhText="校区编号" enText="chCampCode"/></th>
			  <th width="10%"><my:i18n zhText="校区名称" enText="chCampName"/></th>
			  <th width="20%"><my:i18n zhText="校区介绍" enText="chCampDesc"/></th>
			  <th width="20%"><my:i18n zhText="备注" enText="chCampMemo"/></th>
			  <th width="5%"><my:i18n zhText="隐藏标识" enText="chCampFlag"/></th>
			  <th width="20%"><my:i18n zhText="地址" enText="chCampAddress"/></th>
			  
			</tr>
		</thead>
		<tbody class="ltablebody">
			<c:if test="${empty page.list}">
			   <tr><td align="center" colspan="7"><font color="red">暂无校区信息</font> </td></tr>
			</c:if>
			<c:forEach items="${page.list}" var="q" varStatus="status">
			   <tr id="${q.id }">
				  <td align="center"><input type="checkbox" name="ids"  value="${q.id}"/></td>
				 <td><a style="cursor: pointer;" onclick="detail('${q.id}')">${q.chCampCode}</a></td>
				  <td><a style="cursor: pointer;" onclick="detail('${q.id}')">${q.chCampName}</a></td>
				  <td><a style="cursor: pointer;" onclick="detail('${q.id}')">${q.chCampDesc}</a></td>
				  <td><a style="cursor: pointer;" onclick="detail('${q.id}')">${q.chCampMemo}</a></td>
				  
				  <td align="center">

            <c:if test="${q.chCampShowflag=='Y'}">
               <input type="checkbox" name="chCampShowflag" checked="checked" id="checkId" />
           </c:if> 
           <c:if test="${q.chCampShowflag=='N'}">
               <input type="checkbox" name="chCampShowflag"  id="checkId" />
          </c:if> 
           <c:if test="${q.chCampShowflag==''}">
               <input type="checkbox" name="chCampShowflag"  id="checkId" />
          </c:if> 
          
                  </td>
				  
				  
				  <td><a style="cursor: pointer;" onclick="detail('${q.id}')">${q.chCampAddress}</a>
				   <a type="hidden" style="cursor: pointer;" class="deleteOne" param="ids=${q.id}"></a> 
				  </td>   
				</tr>
			  </c:forEach>
		</tbody>
	 </table>
	 <div class="ltablebottom">
	    <div style="float: left;">
	    
	       <my:auth fixedValue="W" value="${auth}">
	    
	    <input type="button" class="button orange"  value="<my:i18n zhText="新增" enText="AddNew"/>"  id="addBtn"/>
		<input type="button" class="button orange"  value="<my:i18n zhText="编辑" enText="Modify"/>"  id="modifyBtn" onclick="edit();"/> 
        <input type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" id="batchDelete"/>
	       </my:auth>
	          
	    </div>
		<div class="lpage"><my:page page="${page}"/></div>  
	 </div>
	</form>
	 
</div>
</body>
</html>