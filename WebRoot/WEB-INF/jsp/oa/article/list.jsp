<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true" >
	<script type="text/javascript">
	   	var list=true;
		var addnewurl = "${ctx}/oa/article_add.do?categoryValue=${categoryValue}";
		var deleteurl = "${ctx}/oa/article_delete.do";
		$(function() {
				$("#addnewButton").click(function(){window.location.href=addnewurl;});
				$("#searchButton").click(function(){$("#cmForm").submit();});
		});
	</script>
</my:head>
<body>
<div class="phead">
	<div class="pheadposition">
	<my:i18n zhText="当前位置" enText="Current Position"/>： 
	<my:i18n zhText="信息发发布" enText="Infomation Release"/> -
	<my:i18n zhText="文章列表  " enText="Article List"/>
	<c:if test="${!empty categoryValue}">- <my:view value="${categoryValue}" pvalue="oaarticle"/></c:if> </div>
	<div class="pheadbutton">
	  <!--  <input type="button" class="button orange"  id="searchButton" value="<my:i18n zhText="查询" enText="Search"/>" /> -->
	   <c:if test="${!empty categoryValue}">
	     <input type="button" class="button orange"  value="<my:i18n zhText="新建文章" enText="Add New A Article"/>" id="addnewButton"/>
	   </c:if>
	</div>
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx }/oa/article_list.do">
    <input type="hidden" name="categoryValue" value="${categoryValue }"/>
    <!-- 
    <div class="psearchhead">
		标题：<input type="text" name="title" id="title" value="${title }"/>&nbsp;&nbsp;
		是否草稿：<my:select pvalue="yesornot" name="isDraft" value="${isDraft}" firstoption="--"/>
	</div>
     -->
<table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="5%"><input type="checkbox" id="checkId"/></th>
		<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
		<th width="40%"><my:i18n zhText="标题" enText="Title"/><my:order orderattr="article.title"/></th>
		<th><my:i18n zhText="发布时间" enText="Release Time"/><my:order orderattr="article.releaseDate"/></th>
		<th><my:i18n zhText="浏览次数" enText="Visit Number"/><my:order orderattr="article.visitQuarter"/></th>
		<th><my:i18n zhText="是否草稿" enText="Is Draft"/><my:order orderattr="article.isDraft"/></th>
		<!-- 
		<th>来源<my:order orderattr="article.origin"/></th>
		<th>作者<my:order orderattr="article.author"/></th>
		
		 -->
		<th><my:i18n zhText="操作" enText="Action"/></th>
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td colspan="7" align="center"><font color="red"><my:i18n zhText="当前尚未添加文章" enText="No Article Now"/></font></td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="article" varStatus="status">
			<tr id="${article.id }">
				<td align="center"><input type="checkbox" name="ids" value="${article.id }" isDraft="${article.isDraft }"/></td>
				<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td><a href="${article.outerUrl }" target="_blank"><my:i18n zhText="${article.title }" enText="${article.enTitle }"/></a></td>
				<td>${article.releaseDate }</td>
				<td>${article.visitQuarter }</td>
				<td><my:view value="${article.isDraft }" pvalue="yesornot"/></td>
				<!-- 
				<td>${article.origin }</td>
				<td>${article.author }</td>
				 -->
				<td>
					<a href="${ctx}/oa/article_update.do?id=${article.id }&categoryValue=${article.categoryValue}" ><my:i18n zhText="修改" enText="Modify"/></a>
					<a href="javascript:" class="deleteOne" param="ids=${article.id}"><my:i18n zhText="删除" enText="Delete"/></a>
				</td>
			</tr>
		  </c:forEach>
	</tbody>
</table>
 <div class="ltablebottom">
		<!--<div style="float: left;"><input type="button" class="button orange"  value="发布" onclick="batchRelease('1')"/>&nbsp;&nbsp;&nbsp;</div>
		<div style="float: left;"><input type="button" class="button orange"  value="取消发布" onclick="batchRelease('0')"/>&nbsp;&nbsp;&nbsp;</div>
	    --><div style="float: left;"><input type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" id="batchDelete"/></div>
		<div class="lpage"><my:page page="${page}"/></div>  
	 </div>
</form>
</body>
</html>