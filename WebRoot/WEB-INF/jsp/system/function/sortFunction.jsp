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
		var deleteurl = "${ctx }/system/func_delete.do";
		$(function() {
			$("#funcSelect").change(function(){
				var id = $(this).children('option:selected').val();
				var name = $(this).children('option:selected').text();
				if (id=="0" && name=="全部父菜单")
					window.location.href="${ctx}/system/func_sort.do";
				else
					window.location.href="${ctx}/system/func_subSort.do?parentFuncId="+id;
			});
			
			var pheadbutton = "";
		  	var ltablebottom = "";
		  	<c:forEach items="${chRolebuttons}" var="roleButton">
		  		var name = "${roleButton.chRobuButton}";
		  		var id = "${roleButton.id}";
		  		var flag = "${roleButton.chRobuFlag}";
		  			
		  		var content;
		  		if (flag == "是"){
		  			content = "<input type='button' class='button orange'  id='${roleButton.chRobuId }' value='<my:i18n zhText='${roleButton.chRobuButton }' enText=''/>' />";
		  				ltablebottom += content;
		  		} else {
		  			content = "<input type='button' class='button grey'  id='${roleButton.chRobuId }' value='<my:i18n zhText='${roleButton.chRobuButton }' enText=''/>' />";
		  				ltablebottom += content;
		  		}
		  	</c:forEach>
		    $(".pheadbutton").append(pheadbutton);
		  	$(".ltablebottom").append(ltablebottom);
	  		
			$("#submitBtn").click(function(){
			$("#funcForm").form('submit', {
				type:"post",
				dataType:"json",
				onSubmit:function(){
				    if ($("#submitBtn").attr("class")=="button orange") {
					 	var idValueArray = [];
						$(".ltable tr :text").each(function(){
							var idvalue=$(this).parents("tr").attr("id")+","+$(this).val();
							idValueArray.push(idvalue);
						});
						var funcIdSortNo = idValueArray.join(" ");
						$("#funcIdSortNo").val(funcIdSortNo);
					    return true;
					} else {
						return false;
					}
				},
				success:function(data){
					try{
						data = $.parseJSON(data);
					}catch(e){
						$("body").html(data);
						return;
					}
					alert(data.msg);
				}
			});
		});
	});
	</script>
</my:head>
<body>
<div class="bodybox">
		<form action="${ctx }/system/func_sortSave.do" method="post" id="funcForm">
		      <input type="hidden" name="id" value="${id }"/>
		      <input type="hidden" id="funcIdSortNo" name="funcIdSortNo" value=""/>
			  <table class="ltable" width="100%">
			        <thead class="ltablehead">
			        	<tr><td colspan="4" align="center">
			        		<select id="funcSelect" name="parentFuncId">
			        			<option value="0">全部父菜单</option>
			        			<option value="1">一级菜单</option>
			        			<c:forEach items="${funcList}" var="func">
				        			<c:choose>
											<c:when test="${id eq func.id}">
												<option value="${func.id}" selected="selected" >${func.chFuncName}</option>
											</c:when>
											<c:otherwise>
												<option value="${func.id}">${func.chFuncName}</option>
											</c:otherwise>
									</c:choose>	
			        			</c:forEach>
                			</select>
			        	</td></tr>
			                <tr>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                	<th width="30%"><my:i18n zhText="菜单名称" enText="Menu Name"/></th>
			                	<th width="30%"><my:i18n zhText="权限范围" enText="Function Range"/></th>
			                	<th width="15%"><my:i18n zhText="显示顺序" enText="No."/></th>
			                </tr>
			            </thead>
			              <tbody class="ltablebody">
			            <c:if test="${empty page.list}">
				            <tr>
								<td align="center" colspan="6"><font color="red"><my:i18n zhText="当前菜单没有下级菜单" enText="There are no Sub Menus"/></font> </td>
						    </tr>
			           </c:if>
			           <c:forEach items="${page.list}" var="subFunc" varStatus="status">
			               <tr id="${subFunc.id }">
								<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
								<td align="center"><my:i18n zhText="${subFunc.chFuncName}" /></td>
								<td align="center"><my:i18n zhText="" /></td>
								<td align="center">
									<input type="text" name="chFuncSortno" id="chFuncSortno" value="${subFunc.chFuncSortno }" style="width: 50%">
								</td>
							</tr>
			           </c:forEach>
		             </tbody>
		         </table>
		         <div class="ltablebottom"><input type="button" class="button orange" id="submitBtn" value="<my:i18n zhText="重置" enText="Reset"/>"/></div>
	       </form>
	  </div>
	 </body>
</html>