<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul style="margin-left: 17px;">
  <c:forEach items="${page.list}" var="mb" varStatus="status">
	<li style="padding: 3px">${mb.messageContent }&nbsp;[${mb.createTime }]</li>
</c:forEach>
</ul>