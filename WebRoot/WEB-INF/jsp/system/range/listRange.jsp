<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" tree3="true">
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<script type="text/javascript">
		var list=true;
		var deleteurl = "${ctx }/system/range_delete.do";
		$(function() {
			var id = "";
			$(".ltable tr").dblclick(function(){
				id = $(this).attr("id");
				showEdit(id);
			});
			
	  		var idsArray = new Array();
			var ids = "";
	  		$("input[name='ids']").bind("click", function(){
	  			if ($(this).attr("checked") == "checked" ) {
	  				ids +=","+$(this).val();
	  			} else {
	  				if(ids!=""){
	  					idsArray = ids.split(",");
	  					idsArray = deleteFromArray(idsArray,$(this).val());
	  					ids = idsArray.join(",");
	  				}
	  			}
	  		});
	  	
	  		$("#addnewButton").click(function(){
				var id = $("input[name='id']").val();
				if ($(this).attr("class")=="button orange")
					$.dialog({id:'addFunction',title:'新增',content: 'url:${ctx }/system/range_add.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 400 });
			});
			
			$("#editButton").click(function(){
					if(ids==""){
						alert("请选择需要编辑的用户");
					}else if(getCount(ids)>1){
						alert("请选择一条数据");
					}else{
						if (ids.indexOf(",")==0){
							ids=ids.substring(1);
						}
						showEdit(ids);
						ids = "," +ids;
					}
			});
			$("#searchButton").click(function(){
				if ($(this).attr("class")=="button orange")
					$.dialog({id:'searchFunction',title:'查询权限',content: 'url:${ctx }/system/range_showSearch.do',cancelVal: '关闭',cancel: true,width: '500px',height: 300 });
			});
			
		});
		function deleteFromArray(arr, id) {
			var arrtemp = [];
			  var j=0;
			  for(var i=0;i<arr.length;i++){
			     if(arr[i] != id){
			         arrtemp[j] = arr[i];
			         j++;
			     }
			  }
			  return arrtemp;
		}
		
		function getCount(str){
			var strm = str.match(/,/g);
			if (strm)
				count = strm.length;
			else 
				count = 1;
		  	return count;
		}
		
		function showEdit(id){
			$.dialog({id:'id',title:'权限编辑',content: 'url:${ctx }/system/range_update.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		
		
	</script>
</my:head>
<body>
<div class="bodybox">
	<div class="phead">
			<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="权限范围管理" enText="Range Mgt"/> - <my:i18n zhText="权限范围列表" enText="The List Of Ranges"/> 
			</div>
			<div class="pheadbutton">
				   <input type="button" class="button orange"  value="<my:i18n zhText="查询" enText="search"/>"  id="searchButton"/>
			</div>
			<div class="clear"></div>
	</div>
		<form action="${ctx }/system/range_list.do" method="post" id="rangeForm">
				<input type="hidden" name="id" value="${id }"/>
		           <table class="ltable" width="100%">
			            <thead class="ltablehead">
			                <tr>
			                	<th width="4%"><input type="checkbox" name="checkId" id="checkId" value=""></th>
			                  	<th width="4%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="10%"><my:i18n zhText="权限名称" enText="Range Name"/><my:order orderattr="range.chRangDesc"/></th>
			               		<th width="25%"><my:i18n zhText="所属角色" enText="Role"/></th>
			               		<th width="10%"><my:i18n zhText="备注" enText="Role Name"/><my:order orderattr="range.chRole.chRoleName"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="7"><font color="red"><my:i18n zhText="当前没有权限" enText="No User List"/></font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="user" varStatus="status">
				              <tr id="${user.id }" param="ids=${user.id}">
									<td align="center">
										<input type="checkbox" id="ids" name="ids" value="${user.id}"/>
										<input type="hidden" id="roleId" name="roleId" value="${user.chRole.id}"/>
									</td>
									<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
									<td align="center"><my:i18n zhText="${user.chRangDesc}" enText="${user.chRangDesc}"/></td>
				             		<td class="roletd" align="center">
									   <my:i18n zhText="${user.chRole.chRoleName}" enText="${user.chRole.chRoleName}"/>
									</td>
									<td align="center"><my:i18n zhText="${user.chRangMemo}" enText="${user.chRangMemo}"/></td>
								</tr>
				              </c:forEach>
			            </tbody>
		         </table>
		       <div class="ltablebottom">
		       		 <div style="float: left;">
			 	      	<input type="button" class="button orange"  value="<my:i18n zhText="新增" enText="Add A New Range"/>" id="addnewButton"/>
			 	      	<input type="button" class="button orange"  value="<my:i18n zhText="编辑" enText="Edit"/>" id="editButton"/>
			 	      	<input type="button" class="button orange"  value="<my:i18n zhText="删除" enText="Delete"/>" id="batchDelete"/>
					</div>
			       <div class="lpage"><my:page page="${page}"/></div> 
			  </div>
			   
	       </form>
	       
	     <div id="menuContentDeptTree" class="menuContentDeptTree" style="display:none; position: absolute;">
			<ul id="deptTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:250px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
	    <div id="menuContentRoleTree" class="menuContentRoleTree" style="display:none; position: absolute;">
			<ul id="roleTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:150px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>	
</div>
</body>
</html>