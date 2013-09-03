package com.ccloudedu.base.utils.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import com.ccloudedu.base.web.Servlets;
/**
 * jasperReport 导出报表工具类
 * @author wade
 */
public class JasperUtils {
	
	 //public static final String PRINT = "print";  
     public static final String EXCEL_2003 = "excel_2003";  
     public static final String EXCEL_2007 = "excel_2007";
     public static final String WORD_2003 = "word_2003"; 
     public static final String WORD_2007 = "word_2007"; 
     public static final String PDF = "pdf";
     public static final String HTML = "html";  
     
     /** 
      * 导出 
      * @param type 导出文件的类型 
      * @param jasperFilePath jasper文件的路径
      * @param parameters 参数
      * @param lists 导出的数据 
      * @param filename导出文件的名称 
      * @throws Exception 
      */  
     public static void export(String type,String jasperFilePath,
    		 Map<String,Object> parameters,List<?> lists,String filename) throws Exception{  
    	 
          File file = new File(jasperFilePath);  
          InputStream is = new FileInputStream(file); 
         
          JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);  
          prepareReport(jasperReport, type);  
          //javabean数据源
          JRDataSource ds = new JRBeanCollectionDataSource(lists, false);  
          
          //jdbc数据源
          //Connection ds = DBManager.getConnection();
          
          JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);  

          if (EXCEL_2003.equals(type) || EXCEL_2007.equals(type)) {  
	            exportExcel(type,jasperPrint,filename);  
          } else if (WORD_2003.equals(type) || WORD_2007.equals(type)) {   
                exportWord(type,jasperPrint,filename);  
          } else if (PDF.equals(type)) {  
	            exportPdf(jasperPrint,filename);  
	      } else if (HTML.equals(type)) {  
	            exportHtml(jasperPrint);  
	      } 
     }  
     
     /** 
      * 导出excel 
      */  
     private static void exportExcel(String type,JasperPrint jasperPrint,String fileName) throws IOException, JRException {  
    	 
    	   HttpServletResponse response = Servlets.getResponse();
	       response.setContentType("application/vnd.ms-excel");  
	       fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1")+((EXCEL_2003.equals(type))?".xls":".xlsx");
	       response.setHeader("Content-disposition", "attachment; filename=" + fileName);  
	       ServletOutputStream ouputStream = response.getOutputStream();  
	       JRExporter exporter = null;
	       if(EXCEL_2003.equals(type)){
	    	   exporter = new JRXlsExporter(); 
	       }else{
	    	   exporter = new JRXlsxExporter(); 
	       }
	       exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);  
	       exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,ouputStream);  
	       
	       exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES, new String[]{"Sheet1"});
	       exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);  
	       exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);  
	       exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);  
	       exporter.exportReport();  
	       ouputStream.flush();  
	       ouputStream.close();  
     }  
     
     /** 
      * 导出word 
      */  
     private static void exportWord(String type,JasperPrint jasperPrint,String fileName) throws JRException, IOException {  
    	  HttpServletResponse response = Servlets.getResponse();
	      response.setContentType("application/msword;charset=utf-8");  
	      fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1")+((WORD_2003.equals(type))?".doc":".docx");
	      response.setHeader("Content-disposition", "attachment; filename=" + fileName);  
	      JRExporter exporter = null;
	      if(WORD_2003.equals(type)){
	    	  exporter = new JRRtfExporter(); 
	      }else{
	    	  exporter = new JRDocxExporter();
	      }
	      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);  
	      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());  
	      exporter.exportReport();  
     } 
     
     /** 
      * 导出pdf，注意此处中文问题：
      * 1、在ireport的classpath中加入iTextAsian.jar 
      * 2、在ireport画jrxml时，看ireport最左边有个属性栏，下边的设置就在点字段的属性后出现。 
      * pdf font name ：STSong-Light ，pdf encoding ：UniGB-UCS2-H 
      */  
     private static void exportPdf(JasperPrint jasperPrint,String fileName) throws IOException, JRException {  
    	   HttpServletResponse response = Servlets.getResponse();
	       response.setContentType("application/pdf");  
	       fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1")+".pdf";
	       response.setHeader("Content-disposition", "attachment; filename="+ fileName);  
	       ServletOutputStream ouputStream = response.getOutputStream();  
	       JasperExportManager.exportReportToPdfStream(jasperPrint,ouputStream);  
	       ouputStream.flush();  
	       ouputStream.close();  
     }  
     
     /** 
      * 导出html 
      */  
     private static void exportHtml(JasperPrint jasperPrint) throws IOException, JRException {  
    	   HttpServletResponse response = Servlets.getResponse();
	       response.setContentType("text/html");  
	       ServletOutputStream ouputStream = response.getOutputStream();  
	       
	       JRHtmlExporter exporter = new JRHtmlExporter();  
	       exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);  
	       exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);  
	       exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");  
	       exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,ouputStream);  
	       exporter.exportReport();  
	       ouputStream.flush();  
	       ouputStream.close();  
     }  
     
     private static void prepareReport(JasperReport jasperReport, String type) {  
         /**
         * 如果导出的是excel，则需要去掉周围的margin 
         */  
         if (EXCEL_2003.equals(type) || EXCEL_2007.equals(type)) {
        	 try {  
	              Field margin = JRBaseReport.class.getDeclaredField("leftMargin");  
	              margin.setAccessible(true);  
	              margin.setInt(jasperReport, 0);  
	              margin = JRBaseReport.class.getDeclaredField("topMargin");  
	              margin.setAccessible(true);  
	              margin.setInt(jasperReport, 0);  
	              margin = JRBaseReport.class.getDeclaredField("bottomMargin");  
	              margin.setAccessible(true);  
	              margin.setInt(jasperReport, 0);  
	              Field pageHeight = JRBaseReport.class.getDeclaredField("pageHeight");  
	              pageHeight.setAccessible(true);  
	              pageHeight.setInt(jasperReport, 2147483647);  
            } catch (Exception e) {  
            	  e.printStackTrace();
            }  
         }
     } 
}
