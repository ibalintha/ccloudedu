<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="net.sf.jasperreports.engine.util.*"%>
<%@ page import="net.sf.jasperreports.engine.export.*"%>
<%@ page import="net.sf.jasperreports.j2ee.servlets.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">


		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<%
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu",
					"sa", "changhong_406");
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("where", "四川省");
			parameters.put("school", "青川高级中学XX班");
			parameters.put("grade", "高一508");
			parameters.put("clas_id", "4");

			File reportFile = new File(application
					.getRealPath("/jasper/stu-msg.jasper"));
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(reportFile.getPath());

			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, conn);

			JRHtmlExporter exporter = new JRHtmlExporter();

			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, "pt"); //默认情况下用的是px,会导致字体缩小
			exporter.setParameter(
					JRHtmlExporterParameter.FRAMES_AS_NESTED_TABLES, false); //线条不对齐的解决方法: 

			//exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
			//exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "/ireport/ireport_html.Image?image=");
			//exporter.setParameter(JRHtmlExporterParameter.BETWEEN_PAGES_HTML, "");
			exporter.setParameter(
					JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
					Boolean.FALSE);
			exporter.exportReport();
			//out.flush();
			conn.close();
		%>
	</body>

</html>
