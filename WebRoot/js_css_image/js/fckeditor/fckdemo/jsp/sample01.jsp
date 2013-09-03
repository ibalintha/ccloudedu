<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>FCKeditor - JSP Sample</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="robots" content="noindex, nofollow" />
		<link href="../sample.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/fckeditor/fckeditor.js"></script>
	</head>
	<body>
		<h1>FCKeditor - JSP - Sample 1</h1>
		<p>This sample displays a normal HTML form with an FCKeditor with
		full features enabled.</p>
		<p>Basic FCKeditor informations:</p>
	
		<hr />
		<form action="" method="post" target="_blank" enctype="multipart/form-data">
		    <textarea rows="6" cols="60" name="contentwewewewe" id="contentwewewewe"></textarea>
		    <script type="text/javascript">
		          var oFCKeditor = new FCKeditor('contentwewewewe');
		          oFCKeditor.BasePath = "<%=request.getContextPath()%>/fckeditor/";
		          oFCKeditor.ReplaceTextarea();
		    </script>
		<br />
		<input type="submit" value="Submit" /></form>
	</body>
</html>