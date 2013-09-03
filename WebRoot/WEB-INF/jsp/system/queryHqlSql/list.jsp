<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head lhgdialog="true">
    <script type="text/javascript">
	    var list=true;
	    var deleteurl="${ctx}/system/querySqlHql_delete.do";
	    var addurl = "${ctx}/system/querySqlHql_add.do?menuId=${menuId}"
	    $(function() {
	    	$("#addnewButton").click(function(){
				$.dialog({id:'dialog',title:'新增sql/hql语句',content: 'url:'+addurl,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
			});
		});
		
		function detail(id){
			$.dialog({id:'dialog',title:'查看sql/hql语句管理',content: 'url:${ctx}/system/querySqlHql_detail.do?id='+id,cancelVal: '关闭',cancel: true,width: '900px',height: 500 });
		}
		function reloadToList(){
			window.location.href="${ctx}/system/querySqlHql_list.do?menuId=${menuId}";
		}
		
	</script>

</my:head>
<body>
<div class="bodybox">
  <div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： sql/hql语句管理- 
	<c:if test="${!empty menu.menuPath}">${menu.menuName } - </c:if>列表</div>
	<div class="pheadbutton">
	   <c:if test="${!empty menu.menuPath}">
	       <input type="button" class="button orange"  id="addnewButton" value="新增sql/hql语句" />
	   </c:if>
	</div>
	<div class="clear"></div>
  </div>
  <form action="${ctx }/system/querySqlHql_list.do" method="post" id="querySqlHqlForm">
	 <input type="hidden" name="menuId" value="${menuId }"/>
	 <table class="ltable" width="100%">
		<thead class="ltablehead">
			<tr>
			  <th width="5%"><input type="checkbox" name="checkId" id="checkId" value=""></th>
			  <th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			  <th width="30%">查询名称</th>
			  <th>描述/说明</th>
			  <th width="15%">操作</th>
			</tr>
		</thead>
		<tbody class="ltablebody">
			<c:if test="${empty page.list}">
			   <tr><td align="center" colspan="6"><font color="red">该功能没有sql/hql语句</font> </td></tr>
			</c:if>
			<c:forEach items="${page.list}" var="q" varStatus="status">
			   <tr id="${q.id }">
				  <td align="center"><input type="checkbox" name="ids"  value="${q.id}"/></td>
				  <td align="center"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
				  <td><a style="cursor: pointer;" onclick="detail('${q.id}')">${q.queryName}</a></td>
				  <td>${q.description}</td>
				  <td align="center">
				     <a style="cursor: pointer;" onclick="detail('${q.id}')">查看</a>
				     <my:auth fixedValue="W" value="${auth}">
				      |
				      <a style="cursor: pointer;" class="deleteOne" param="ids=${q.id}">删除</a>
				     </my:auth>
				  </td>
				</tr>
			  </c:forEach>
		</tbody>
	 </table>
	 <div class="ltablebottom">
	    <div style="float: left;">
	       <my:auth fixedValue="W" value="${auth}">
	         <input type="button" class="button orange"  value="<my:i18n zhText="批量删除" enText="Batch Delete"/>" id="batchDelete"/>
	       </my:auth>
	    </div>
		<div class="lpage"><my:page page="${page}"/></div>  
	 </div>
	</form>
	 <div class="pfooter" id="qingjiaDiv">
	 <font color="red">
	      注：架构采用两种方式管理sql/hql：<br/>
	  1、xml文件方式：sql、hql语句写在xml文件中；<br/>
	  2、sql、hql语句写在数据库中；<br/>
	  3、两种方式选其一。
	  </font>
	 </div>
</div>
</body>
</html>