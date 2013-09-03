package com.ccloudedu.base.utils.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import com.ccloudedu.base.web.Servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * freemark 工具类
 * @author wade
 */
public class FreemarkUtils {
	/**
	 * 加载模板
	 * @return
	 * @throws IOException
	 */
	public static Template loadTemplate(String templetePath) throws IOException{
		 Configuration cfg = new Configuration();   
		 cfg.setServletContextForTemplateLoading(Servlets.getServletContext(), "/");   
		 cfg.setEncoding(Locale.getDefault(), "UTF-8");   
		 Template template = cfg.getTemplate(templetePath,"UTF-8");   
		 template.setEncoding("UTF-8");  
		 return template;
	}
	
	/**
	 * 生成静态文件
	 * 
	 * @param templatePath 模板文件路径 如 /WEB-INF/ftl/fckcontent.ftl
	 * @param targetPath 静态文件存放路径 cms/news/
	 * @param fileName 静态文件存放路径 1.html,1.txt......
	 * @param Map<String,Object> map 模板中的动态数据
	 * @throws Exception
	 */
	public static String createStaticContent(String templetePath,String targetPath,String fileName,Map<String,Object> map) throws Exception{
		
		ServletContext context = Servlets.getServletContext();
		
		//创建静态文件存放路径
		targetPath = context.getRealPath(targetPath);
		//生成静态文件存放路径
	    File targetFile = new File(targetPath);
	    if(!targetFile.exists()){
	    	targetFile.mkdirs();
	    }
	    File file = new File(targetFile,fileName);
	    /*File file = new File(targetPath);   
	    if(!file.exists()){
	    	file.mkdirs();
	    }
	    if(StringUtils.isNotEmpty(fileName)){
	    	 file = new File(targetPath+"/"+fileName);  
	    }else{
	    	 file = new File(targetPath);  
	    }*/
	    
	    //加载模板
		Template template = loadTemplate(templetePath);
		
	    //生成文件
	    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")); 
	    template.process(map, out);   
	    out.flush();   
	    out.close(); 
	    
	    return file.getAbsolutePath();
	}
}
