<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/main.css"/>
    <script src="${ctx }/js/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
	<script src="${ctx }/js/jquery/jquery.tablesorter.js" type="text/javascript"></script>
	<script src="${ctx }/js/util.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function() {
		changeTrColor("#sorttable tr");
		changeTableColor("#sorttable tr:even");
		sortTable("#sorttable");
		selectOrUnSelectCheckbox("#checkId","ids");
	});
	function deleteCM(id){
         if(confirm("您真的要删除吗？")){
        	window.location.href="${ctx}/cms/articleAttr_delete.do?id="+id;
          }
	}
	function batchDelete(){
		var batchChecks = document.getElementsByName('ids');
		var targetForm = $("#cmForm")[0];
		var deleteUrl = "${ctx}/cms/articleAttr_delete.do";
		batchDeleteByIds(batchChecks,targetForm,deleteUrl);
    }
	</script>
</head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：文章内容  - 内容属性 - 列表 </div>
	<div class="pheadbutton">
	   <form action="${ctx}/cms/articleAttr_add.do" method="post">
		<input type="submit" class="button orange" value="添加文章属性"/>
	   </form>
	</div>
	<div class="clear"></div>
</div>
<c:if test="${!empty actionMessages}">
     <div id="result" align="center" style="color: red;height: 16px;padding-top: 9px"><s:actionmessage/></div>
</c:if>
<form id="cmForm" method="post" action="cms/articleAttr_list.do">
<table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="25px">
		<input type="checkbox" id="checkId"/></th>
		<th>调用标识</th>
		<th>属性名称</th>
		<th>标题图宽度</th>
		<th>标题图高度</th>
		<th>是否有缩略图</th>
		<th>是否使用</th>
		<th><my:i18n zhText="操作" enText="Action"/></th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td align="center" colspan="8"><font color="red">当前尚未添加文章属性</font> </td>
			</tr>
		</c:if>
		<s:iterator value="page.list" status="status">
			<tr>
				<td><input type="checkbox" name="ids" value="${id }"/></td>
				<td>${key }</td>
				<td>${name }</td>
				<td>${imgWidth }</td>
				<td>${imgHeight }</td>
				<td>${isHasTitleimg }</td>
				<td>${isDisabled }</td>
				<td class="ftablebutton">
					<a href="${ctx}/cms/articleAttr_update.do?id=${id }" >修改</a>
					<a href="#" onclick="deleteCM('${id }')" ><my:i18n zhText="删除" enText="Delete"/></a>
				</td>
			</tr>
		</s:iterator>
		
	</tbody>
</table>
	<div class="ltablebottom">
		<input type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" onclick="batchDelete()"/>
		<div class="lpage"><my:page page="${page}"/></div>  
	</div>
</form>
</div>
</body>
</html>