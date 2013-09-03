<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
	<script type="text/javascript">
	  //var api = frameElement.api, W = api.opener;
	   $(function() {
		    $("input[name='myselfDesk']").click(function(){
		    	$("label[for='checkIds']").html("");
		    });
			$("#submitBtn").submitForm({
				formId:"userForm",
				resetForm:false,
				onSubmit:function(){
				   if($("input[name='myselfDesk']:checked").size()==0){
					   $("#checkIds").val("");
				   }else{
					   $("#checkIds").val("zmsz");
				   }
				   return true;
				}
				/*,
				onComplete:function(){
				     W.reloadIframe();
				     api.close();
				}*/
			});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 个人中心 - 桌面设置</div>
	<div  class="pheadbutton" >
	  
	</div>
	<div class="clear"></div>
</div>
  <div id="result" align="center" style="color: red"></div>
		  <form id="userForm" action="{ctx}/system/user_setDesk.do" method="post">
		  <input type="hidden" name="id" id="id" value="${userSession.id }">
		  <table width="100%" class="ftable">
          <tr style="display: none">
            <th align="right" width="12%">姓名：</th>
            <td>${user.userName }</td>
          </tr>
           <tr>
            <th align="right" width="18%">我的桌面：</th>
            <td id="desks">
              <my:checkbox pvalue="zmsz" name="myselfDesk" value="${user.myselfDesk}" scope="${user.sysRole.deskSetting}" br="true"/>
              <input type="hidden" name="checkIds" id="checkIds" value="" rules="[{notNull:true, message:'请至少选择一个'}]"/>
            </td>
          </tr>
          <tr>
			<td colspan="4" class="ftablebutton">
				<input type="button" class="button orange"  value="设置新桌面" id="submitBtn"/> 
			</td>
	      </tr>
        </table>
        </form>
       </div>
	</body>
</html>