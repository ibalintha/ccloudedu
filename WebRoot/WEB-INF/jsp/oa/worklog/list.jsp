<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
	<script type="text/javascript">
	    var list=true;
	    var deleteurl="${ctx }/oa/worklog_delete.do";
	    $(function() {
	    	$("#searchButton").click(function(){$("#cmForm").submit();});
	    	$("#addnewButton").click(function(){
				$.dialog({id:'dialog',title:'填写今日工作日志',content: 'url:${ctx }/oa/worklog_update.do',cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
			});
		});
		function update(id){
			$.dialog({id:'dialog',title:'修改工作日志',content: 'url:${ctx }/oa/worklog_update.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		function show(id){
			$.dialog({id:'dialog',title:'查看工作日志',content: 'url:${ctx }/oa/worklog_detail.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		function reloadworklog(){
			location.href="${ctx}/oa/worklog_list.do";
		}
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 工作管理 - 工作日志 </div>
	<div class="pheadbutton">
	    <my:auth fixedValue="W" value="${auth}">
	        <c:if test="${empty isLeaderRead}">
			  <input type="button" class="button orange"  value="填写今日工作日志"  id="addnewButton"/>
			  <input type="button" class="button orange"  value="补填往日工作日志" />
			</c:if>
		</my:auth>
	</div>
	
	<div class="clear"></div>
</div>
<form id="cmForm" method="post" action="${ctx}/oa/worklog_list.do">
   <input type="hidden" name="isLeaderRead" id="isLeaderRead" value="${isLeaderRead}"/>
   <table class="ltable" width="100%">
	<thead class="ltablehead">
	<tr>
		<th width="4%" nowrap="nowrap"><my:i18n zhText="序号" enText="No."/></th>
		<th nowrap="nowrap">项目编号<my:order orderattr="worklog.oaProject.projectCode"/></th>
		<c:if test="${!empty isLeaderRead && isLeaderRead=='Y'}">
		   <th nowrap="nowrap">姓名<my:order orderattr="worklog.creator.userName"/></th>
		</c:if>
		<th nowrap="nowrap">日期<my:order orderattr="worklog.workDate"/></th>
		<th nowrap="nowrap">工作主题<my:order orderattr="worklog.workTheme"/></th>
		<c:if test="${empty isLeaderRead}">
		   <th nowrap="nowrap">是否草稿<my:order orderattr="worklog.isDraft"/></th>
		</c:if>
		<th nowrap="nowrap">开始时间<my:order orderattr="worklog.startTime"/></th>
		<th nowrap="nowrap">结束时间<my:order orderattr="worklog.endTime"/></th>
		<th nowrap="nowrap">历时（H）<my:order orderattr="worklog.duringLlong"/></th>
		<th width="8%" nowrap="nowrap"><my:i18n zhText="操作" enText="Action"/></th> 
	</tr>
	</thead>
	<tbody class="ltablebody">
		<c:if test="${empty page.list}">
			<tr>
				<td colspan="10" align="center"><font color="red">当前没有工作日志</font></td>
			</tr>
		</c:if>
		<c:forEach items="${page.list}" var="worklog" varStatus="status">
		  <tr id="${worklog.id }">
				<td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				<td>${worklog.oaProject.projectCode }</td>
				<c:if test="${!empty isLeaderRead && isLeaderRead=='Y'}">
				   <td>${worklog.creator.userName}</td>
				</c:if>
				<td>${worklog.workDate}(星期${worklog.weekDay})</td>
				<td>${worklog.workTheme}</td>
				<c:if test="${empty isLeaderRead}">
				  <td><my:view value="${worklog.isDraft}" pvalue="yesornot"/> </td>
				</c:if>
				<td>${worklog.startTime}</td>
				<td>${worklog.endTime}</td>
				<td>${worklog.duringLlong}</td>
				<td align="center">
				   <c:if test="${empty isLeaderRead && worklog.isDraft=='Y'}">
				      <a href="#" onclick="update('${worklog.id}')">修改</a>
				      <my:auth fixedValue="W" value="${auth}"><a href="javascript:" class="deleteOne" param="ids=${worklog.id}"><my:i18n zhText="删除" enText="Delete"/></a></my:auth>
				   </c:if>
				    <c:if test="${(!empty isLeaderRead && isLeaderRead=='Y') || worklog.isDraft=='N'}">
				       <a href="#" onclick="show('${worklog.id}')">查看</a>
				    </c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
  </table>
  <div class="ltablebottom">
      <div style="float: left;"></div>
	  <div class="lpage"><my:page page="${page}"/></div> 
  </div>
</form>
  <div class="pfooter"><font color="red">注：工作日志需每日填写。系统根据每日填写的工作日志统计考勤信息。</font></div>

</div>
</body>
</html>