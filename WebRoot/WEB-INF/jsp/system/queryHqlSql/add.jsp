<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;
        $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"hqlsqlForm",
				 onComplete:function(){
				     W.reloadToList();
				     api.close();
				 }
			  });
			 
			 $("#queryName").blur(function(){
				 $.post("${ctx}/system/querySqlHql_valideQueryName.do", {'querySqlHql.queryName':$("#queryName").val()}, function(data){
				     if(data.msg=="existed"){
				    	 $("#valideMsg").text("该查询名称已存在，不可重复");
				    	 $(":button").attr("disabled","disabled");
				     }else{
				    	 $("#valideMsg").text("");
				    	 $(":button").removeAttr("disabled");
				     }
				 });
			 });
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>：sql/hql语句管理 - <my:position value="${id}"/></div>
	<div class="clear"></div>
</div>
<form method="post" action="${ctx }/system/querySqlHql_save.do" id="hqlsqlForm" >
   <input type="hidden" value="${menuId}" id="menuId" name="menuId"/>
   <table width="100%" class="ftable"id="ftable">
	  <tr>
		  <th width="13%"><font color="red">*</font>查询名称：</th>
		  <td>
		     <input type="text" id="queryName" name="queryName" value="${queryName}" size="80" rules="[{notNull:true, message:'请输入查询名称'}]"/>
		     <font color="red"><span id="valideMsg"></span></font>
		  </td>
	  </tr>
	  <tr>
		  <th><font color="red">*</font>描述/说明：</th>
		  <td>
		     <input type="text" name="description" value="${description}" size="80" rules="[{notNull:true, message:'请输入描述/说明'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th><font color="red">*</font>hql/sql语句：</th>
		  <td>
		      <textarea rows="18" cols="100" name="sqlHql" rules="[{notNull:true, message:'请输入hql/sql语句'}]"></textarea>
		  </td>
	  </tr>
	  <tr>
		<td colspan="2" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
			<input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div>
</body>
</html>