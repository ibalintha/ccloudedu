<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<script type="text/javascript">
		var list=true;
		var addnewurl = "${ctx}/oa/intenalMassage_add.do";
		var refreashurl= "${ctx}/oa/intenalMassage_list.do?queryType=${queryType}";
		var searchurl = "${ctx}/oa/intenalMassage_list.do";
		$(function() {
			$("a[name='msgTitle']").colorbox({
				width:"90%", height:"90%", iframe:true,
				onCleanup:function(){window.location.href="${ctx}/oa/intenalMassage_list.do?queryType=${queryType}";}
			});
		});
		function batchDelete(){
			var ids = "";
			$("input[name=ids]:checked").each(function(){ids+=","+$(this).val();});
			ids = ids.substring(1);
			deleteByIds("${ctx}/oa/intenalMassage_delete.do?ids="+ids,ids,"请选择要移动的数据","您确定要移至回收箱吗","操作成功","服务器出现错误，操作失败");
	    }
	</script>
</head>
<body>
<c:if test="${queryType=='1'}"><c:set value="发件箱" var="currentMsgbox"></c:set></c:if>
<c:if test="${queryType=='2'}"><c:set value="收件箱" var="currentMsgbox"></c:set></c:if>
<c:if test="${queryType=='3'}"><c:set value="回收箱" var="currentMsgbox"></c:set></c:if>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 信息管理 - ${currentMsgbox }- 列表 </div>
	<div class="pheadbutton">
    	<input type="button" class="button orange"  value="刷新" id="refreashButton"/>
	    <c:if test="${queryType=='1'}">
	        <input type="button" class="button orange"  value="新建信息" id="addnewButton"/>
	    </c:if>
	     <input type="button" class="button orange"  id="searchButton" value="<my:i18n zhText="查询" enText="Search"/>" />
	     <input type="button" class="button orange"  id="resetButton" value="<my:i18n zhText="重置" enText="Reset"/>" />
	</div>
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx}/oa/intenalMassage_list.do">
    <div class="psearchhead">
        <input type="hidden" name="queryType" value="${queryType }"/>
		标题：<input type="text" name="msgTitle" id="msgTitle" value="${msgTitle }"/>&nbsp;
		<c:if test="${queryType=='1'}">接收人：<input type="text" name="receiverName" id="receiverName" value="${receiverName }" />&nbsp;</c:if>
		<c:if test="${queryType=='2'}">发信人：<input type="text" name="senderName" id="senderName" value="${senderName }" />&nbsp;</c:if>
		是否阅读：<select name="isRead" id="isRead">
		            <option value="">----</option>
		             <option value="1" <c:if test="${isRead=='1'}">selected="selected"</c:if>>已阅读</option>
		             <option value="0" <c:if test="${isRead=='0'}">selected="selected"</c:if>>未阅读</option>
		         </select>
	</div>
   <input type="hidden" name="queryType" value="${queryType }"/>
   <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="5%"><input type="checkbox" id="checkId"/></th>
		<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
		<th >标题</th>
		<th width="10%">发信人</th>
		<th width="15%">发送时间</th>
		<th width="10%">接收人</th>
		<th width="15%">是否阅读</th>
		<th width="15%">阅读时间</th>
		<th width="5%"><my:i18n zhText="操作" enText="Action"/></th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td colspan="9" >当前${currentMsgbox }中没有信息</td>
			</tr>
		</c:if>
		<s:iterator value="page.list" status="status">
			<tr id="${id }">
				<td align="center"><input type="checkbox" name="ids" id="ids" value="${id}"/></td>
				<td align="center"><s:property value="#status.index+1"/></td>
				<td>
				  <a href="${ctx}/oa/intenalMassage_update.do?id=${id}&queryType=${queryType}&openInPopup=1" title="${msgTitle}" name="msgTitle"><u>${msgTitle }</u></a>
				</td>
				<td>${sender.userName }</td>
				<td>${sendTime }</td>
				<td>${receiver.userName }</td>
				<td>${tempIsRead }</td>
				<td>${readTime }</td>
				<td>
					<a href="${ctx}/oa/intenalMassage_update.do?id=${id}&queryType=${queryType}">
						<c:if test="${queryType=='2'}">阅读</c:if>
					    <c:if test="${queryType=='1' || queryType=='3'}">查看</c:if>
					</a>
                </td>
			</tr>
		</s:iterator>
		
	</tbody>
</table>
 <div class="ltablebottom">
	 <c:if test="${queryType=='1' || queryType=='2'}">
	 <div style="float: left;"><input type="button" class="button orange"  value="移至回收箱" onclick="batchDelete()"/></div>
	 </c:if>
	<div class="lpage"><my:page page="${page}"/></div>  
</div>
</form>
</div>
</body>
</html>