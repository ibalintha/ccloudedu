<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
     <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>	
     <script type="text/javascript">
      
   var tolisturl = "${ctx}/student/student_list.do";
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;
        $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"studentForm",
				 onComplete:function(){
				     W.reloadStudent();
				     api.close();
				     window.location.href = tolisturl;
				 }
			  });
		});
		function cancel(){
	var api = frameElement.api;
	  api.close();
	}  
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>n： <my:i18n zhText="新生管理" enText="User Mgt"/> - <my:i18n zhText="手动分班" enText="Add A New User"/></div>
	
	<div class="clear"></div>
</div>


	    <div id="result" align="center" style="color: red"></div>
		  <form id="studentForm" action="student/student_noautoSave.do" method="post">
		  <input type="hidden" id="ids"name="ids"value="${ids}"> 
		   <table style="width:100% "class="ftable">
	          <tr>
	             <td style="text-align:center">
	                                      选择班级 ： <select name="chClasId" size=1>
	                <c:forEach items="${chclasstreeList}" var="chclasstreeList">
						<option value="${chclasstreeList.id}">${chclasstreeList.name}</option>
					</c:forEach>

                             </select>
	             </td>
	              
	          </tr>
         
           <tr>
                 <td colspan="3" >
                                                       注意事项：<br/>
                                                                  一、<br/>
                                                                  二、<br/>
                                                                  三、<br/>
                                                                  四、
                
                 </td>
           </tr>
      
           <tr>
			<td colspan="4" class="ftablebutton">
				
				   <input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
				   <input type="reset" class="button orange"  class="button orange" value="<my:i18n zhText="取消" enText="Cancel"/>"onclick="cancel()"/>
				
			</td>
	      </tr>
        </table>
        </form>
        
         <div id="menuContentDeptTree" class="menuContentDeptTree" style="display:none; position: absolute;">
			<ul id="deptTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:300px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
	    <div id="menuContentRoleTree" class="menuContentRoleTree" style="display:none; position: absolute;">
			<ul id="roleTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:200px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
    </div>
</body>
</html>