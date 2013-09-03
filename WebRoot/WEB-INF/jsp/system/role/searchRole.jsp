<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
     <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>	
     <script type="text/javascript">
      
 
	   function cancel(){
			var api = frameElement.api;
			api.close();
		}  
	    
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;    
        function submite(){
	        var roleName = $("#roleName").val();      
	        var roleModel=$("#roleModel").val()

	        var tolisturl = "${ctx}/system/role_list.do?roleName="+roleName+"&roleModel="+roleModel;
	        api.reload(W,tolisturl);
        }  
     
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="角色管理" enText="Role Mgt"/> - <my:i18n zhText="查询" enText="Query"/></div>
	<div class="clear"></div>
</div>


	    <div id="result" align="center" style="color: red"></div>
		  <form id="studentForm" action="${ctx}/student/student_list.do" method="post">
		   <input type="hidden" id="chClasId"name="chClasId"value="1">
		  
		   <table style="width:100% "class="ltable">
		    <thead class="ltablehead">
			                <tr id="postTr" align="center">
			                    <th width="30%" align="center"><my:i18n zhText="查询类别" enText="chScroGrade"/></th>
			                    <th width="70%"><my:i18n zhText="具体关键字" enText="chScroGrade"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
	          <tr>
                  <td>角色名称</td>
	              <td>
	               <input type="text" name="roleName" id="roleName"
					value="" />
	              </td>
	          </tr>
           <tr>
                  <td>权限模型  </td>
	              <td>
	               <input type="text" name="roleModel" id="roleModel"
					value="" />
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
			<td colspan="2" class="ftablebutton">
				
				   <input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="查询" enText="Serch"/>" onclick="submite()"/> &nbsp; 
				   <input type="reset" class="button orange"  class="button orange" value="<my:i18n zhText="取消" enText="Cancel"/>"onclick="cancel()"/>
				
			</td>
	      </tr>
	      </tbody>
        </table>
        </form>
	    </div>
	 </body>
</html>