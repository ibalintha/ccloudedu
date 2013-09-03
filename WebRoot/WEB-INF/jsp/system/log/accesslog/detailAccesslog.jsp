<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.io.FileUtils" %>
<!DOCTYPE html>
<html>
<title>查看操作日志</title>
<my:head>
</my:head>
<body>
<div class="bodybox">
   <%
   String logPath = request.getParameter("logPath");
    File file = new File(logPath);
    List<String> list = FileUtils.readLines(file);
    int i=1;
	for(String s : list){
		if(s!=null && !"".equals(s.trim())){
			out.print(i+"、   "+s+"<br/>");
			i++;
		}else{
			out.print("<br/>");
		}
	}
   
   %>
    <%--
    
    <div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 系统操作日志 - 详细</div>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		   <table width="100%" class="ftable">
		  <tr>
            <th align="right" width="15%" nowrap="nowrap">操作用户：</th>
            <td>${accessLog.accessUser.userName}</td>
          </tr>
          <tr>
            <th nowrap="nowrap">操作ip：</th>
            <td>${accessLog.acccessIp}</td>
          </tr>
          <tr>
            <th nowrap="nowrap">操作时间：</th>
            <td>${accessLog.accessTime}</td>
          </tr>
          <tr>
            <th nowrap="nowrap">操作方法：</th>
            <td>${accessLog.accessMethod}</td>
          </tr>
          <tr style="height: 50px">
            <th align="right" >操作参数：</th>
            <td>${accessLog.operateArg}</td>
          </tr>
        </table>
     --%>
</div>
</body>
</html>