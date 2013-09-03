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
	        var userName = $("#userName").val();      
	        var chUserLogName=$("#chUserLogName").val()

	        var tolisturl = "${ctx}/system/user_list.do?userName="+userName+"&chUserLogName="+chUserLogName;
	        api.reload(W,tolisturl);
        }  
     
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="用户管理" enText="User Mgt"/> - <my:i18n zhText="查询" enText="Query"/></div>
	<div class="clear"></div>
</div>


	    <div id="result" align="center" style="color: red"></div>
		  <form id="searchForm" action="${ctx}/system/user_list.do" method="post">
		
		   <table style="width:100% "class="ltable">
		    <thead class="ltablehead">
			                <tr id="postTr" align="center">
			                    <th width="30%" align="center"><my:i18n zhText="查询类别" enText="chScroGrade"/></th>
			                    <th width="70%" align="center"><my:i18n zhText="具体关键字" enText="chScroGrade"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
	          <tr>
                  <td align="center">姓名</td>
	              <td align="center">
	               <input type="text" name="userName" id="userName"
					value="" />
	              </td>
	          </tr>
           <tr>
                  <td align="center">登录名  </td>
	              <td align="center">
	               <input type="text" name="chUserLogName" id="chUserLogName"
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