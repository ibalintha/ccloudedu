<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
 .bordered {
	  border: solid #ccc 1px;
	  -moz-border-radius: 6px;
	  -webkit-border-radius: 6px;
	  border-radius: 6px;
	  -webkit-box-shadow: 0 1px 1px #ccc; 
	  -moz-box-shadow: 0 1px 1px #ccc; 
	  box-shadow: 0 1px 1px #ccc;         
  }
</style>
</head>
<body>

   <img alt="" src="<%=request.getContextPath() %>/workflow/deploy_getWorkFlowPic.do?processDefinitionId=${processDefinitionId}" style="position:absolute;left:0px;top:0px;">
   
   <div class="bordered" style="position:absolute;border:3px solid red;left:${x }px;top:${y}px;width:${width-5}px;height:${heigth-5}px;"></div>

</body>
</html>