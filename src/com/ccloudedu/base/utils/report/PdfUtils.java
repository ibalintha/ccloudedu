package com.ccloudedu.base.utils.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.XMLResource;
import org.xml.sax.InputSource;

import com.ccloudedu.base.utils.file.PropertiesUtils;
import com.ccloudedu.base.utils.http.HttpClientUtils;
import com.ccloudedu.base.web.Servlets;
import com.lowagie.text.pdf.BaseFont;
/**
 * itext + flyingsaucet 生成pdf工具类
 * 
 * @author wade
 */
public class PdfUtils {
	
	/**
	 * 创建itext需要的html文件
	 * @param actionName
	 * @param targetPath
	 * @param htmlFileName
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	public static String createHtml(String actionName,String targetPath,String htmlFileName,Map<String,String> map) throws Exception{
		InputStream htmlIns = HttpClientUtils.getResponseBodyAsInputStream(actionName, map);
		File file = new File(targetPath,htmlFileName);
		OutputStream out = null;;
		try {
			out = new FileOutputStream(file);
			IOUtils.copy(htmlIns, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			IOUtils.closeQuietly(out);
		}
		return file.getAbsolutePath();
	}
	
	/**
	 * 生成pdf文件
	 * @param htmlUrl
	 * @param pdfPath
	 * @param pdfFileName
	 * @return
	 * @throws Exception
	 */
	public static String createPdf(String url,String pdfPath,String pdfFileName) throws Exception{
		
		ServletContext context = Servlets.getServletContext();
		
		 //itext
        ITextRenderer renderer = new ITextRenderer();   
        
        //itext字体 set font
        ITextFontResolver fontResolver = renderer.getFontResolver();
        String fontPath = PropertiesUtils.getPropertyValue("font.properties", "font.path");   
        fontResolver.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //fontResolver.addFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //fontResolver.addFont("ariblk.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        
        //输出生成的pdf文件 
        pdfPath = context.getRealPath(pdfPath);
        File pdfFile = new File(pdfPath);
	    if(!pdfFile.exists()){
	    	pdfFile.mkdirs();
	    }
	    File file = new File(pdfFile,pdfFileName);
	    OutputStream os = new FileOutputStream(file);
        
	    if(url.indexOf(".do")==-1){
	    	 //maybe it is a file
	        File f = new File(url);
	        if (f.exists()) {
	        	url = f.toURI().toURL().toString();
	        }
	    }
	  
        //css、图片路径 css img path
        String resUrl = new File(context.getRealPath("/")).toURI().toURL().toString();
        Document doc = XMLResource.load(new InputSource(url)).getDocument();
        
        renderer.setDocument(doc, resUrl);
        
        //创建pdf文件
        renderer.layout();          
        renderer.createPDF(os); 
        
        IOUtils.closeQuietly(os);
        
        return file.getAbsolutePath();
	}
}
