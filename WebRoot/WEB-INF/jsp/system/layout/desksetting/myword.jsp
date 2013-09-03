<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<ul>
  <li>操作系统：<%= System.getProperty("os.name") %></li>
  <li>CPU：<%= System.getProperty("sun.cpu.isalist")%></li>
  <li>JVM：<%= System.getProperty("java.version") %></li>
  <li>数据库：mysql5.1</li>
  <li>服务器：tomcat6.0</li>
</ul>