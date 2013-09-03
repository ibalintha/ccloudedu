<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>民族选择</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link  type="text/css" rel="stylesheet" href="${ctx}/js_css_image/css/login.css"/>
<script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/js_css_image/js/base/jquery.ccloudedu.utils-1.0.js"></script>
<script type="text/javascript"> 
  $(function(){ 
       $("#filterName").keyup(function(){ 
          $("table tbody tr td") 
                    .hide() 
                    .filter(":contains('"+( $(this).val() )+"')") 
                    .show(); 
       }).keyup(); 
  }); 
  function returna(a){
     document.all.filterName.value=a.className;
     document.all.filterId.value=a.title;
  }
   function setvalue() {
            
            var str=document.all.filterName.value+"&" + document.all.filterId.value;
           
             window.returnValue = str;  //返回值到选择的那个页面 vv就是你要传过去的值 
             window.close();
         }
    </script> 
</head> 
<body> 
       <div> 
		<br/> 
		民族： 
		<input id="filterName" value="" /> 
		<input id="filterId" type="hidden" value=""/>
		<input id="ethnic" type="button" class="button orange" onclick="setvalue()" value="确定" />
		<br/> 
  
	   </div> 
  
<table> 
    
    <tbody>
    <tr>
     <c:forEach items="${ethnicList}" var="ethnicList" varStatus="status">
     <td> <a href="javascript:void(0);" onclick="returna(this);" class="${ethnicList.chEthnName}" title="${ethnicList.id}"  > ${ethnicList.chEthnName}</a></td>
     </c:forEach>
     </tr>
       
    </tbody> 
</table> 
  
</body> 
</html>
