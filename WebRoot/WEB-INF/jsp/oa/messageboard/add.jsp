<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
	<script type="text/javascript">
		 var addordetail = true;
		 var api = frameElement.api, W = api.opener;
		 $(function() {
			////$('textarea').autoResize({extraSpace : 0});
			$("input[number]").number();
			 $("#submitBtn").submitForm({ 
				 formId:"messageboardForm",
				 onComplete:function(){
				    //api.get('messageBoard').document.frames('menuIframe').location.reload();
				     W.reloadIframe();
				     api.close();
				    
				 }
			  });
			 
		});
	</script>
</my:head>
<body>
<div class="bodybox">
		  <form id="messageboardForm" action="oa/messageboard_save.do" method="post">
		   <table width="100%" class="ftable">
	          <tr>
	            <th align="right"  width="15%">姓名：</th>
	            <td><input type="text" name="userName" value="" id="userName" ></input></td>
	          </tr>
	          <tr>
	            <th align="right"  width="15%">email：</th>
	            <td><input type="text" name="email" value="" id="email"></input></td>
	          </tr>
	          
	          <tr>
	            <th align="right"  width="15%">手机：</th>
	            <td><input type="text" name="telephone" value="" id="telephone"></input></td>
	          </tr>
	          
	          <tr>
	            <th align="right"  width="15%">qq：</th>
	            <td><input type="text" name="qq" value="" id="qq" number="15,2"></input></td>
	          </tr>
	          
	          <tr>
	            <th align="right"  width="15%"><font color="red">*</font>留言内容：</th>
	            <td><textarea style="width: 450px; height: 100px;" name="messageContent" id="messageContent" title="请输入留言内容" rules="[{notNull:true, message:'留言内容不能为空'}]"></textarea></td>
	          </tr>
	          
	           <tr>
				<td colspan="4" class="ftablebutton">
					<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
				</td>
		      </tr>
        </table>
        </form>
    </div>
</body>
</html>