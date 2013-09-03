<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<%@ taglib prefix="my" uri="/mytags"  %>
<style type="text/css">
.article_point{
	padding-left:5px;
	height:24px;
	line-height:24px;
	margin:0 0 0 2px;
}

</style>
<table  border="0" cellspacing="0" cellpadding="0" width="100%">
	<tbody>
		<c:forEach items="${page.list}" var="article" varStatus="status">
		   <c:if test="${status.index<8}">
			 <tr>
			    <td>
			       <div class="article_point">
			          ${status.index+1 }.
			          <a class="article_title" href="${article.outerUrl }" title='<my:i18n zhText="${article.title }" enText="${article.enTitle }"/>' target="_blank"><my:i18n zhText="${article.title }" enText="${article.enTitle }"/></a>
					</div>
				  </td>
				  <td align="right">${article.releaseDate }&nbsp;</td>
		     </tr>	
		     </c:if>
		     <c:if test="${status.index==8}">
			      <tr>
		            <td height="26"></td>
		            <td align="right"> <a href="${ctx }/oa/article_list.do?categoryValue=gonggao" class="more" target="_blank">更多...&nbsp;</a></td>
		         </tr>   
		     </c:if> 
	     </c:forEach>     
   </tbody>
</table>
