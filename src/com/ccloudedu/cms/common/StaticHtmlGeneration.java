package com.ccloudedu.cms.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.file.FreemarkUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.cms.entity.CmsArticle;
import com.ccloudedu.cms.entity.CmsChannel;

/**
 * 网站 静态页面生成器
 * @author wade
 */
public class StaticHtmlGeneration {
	private static final Log log = LogFactory.getLog(StaticHtmlGeneration.class);

	/**
	 * 更新或创建首页index.html
	 * @throws Exception
	 */
	public static void updateIndexPage(String templetePath) throws Exception{
	    Map<String,Object> map = new HashMap<String, Object>();
	    map.put("ctx", Servlets.getRequest().getContextPath());
	    
	    FreemarkUtils.createStaticContent(templetePath, "", "index.html", map);
	}
	
	/**
	 * 更新或创建首页栏目列表内容（首页中的每个栏目块）
	 * @throws IOException 
	 */
	public static  void updateIndexChanenlContent(String templetePath,CmsChannel channel,List<CmsArticle> articleList) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ctx", Servlets.getRequest().getContextPath());
		map.put("channel", channel);
		map.put("articleList", articleList);
		
	    FreemarkUtils.createStaticContent(templetePath, "front/home/", channel.getPath()+".html", map);
	}
	
	/**
	 * 生成栏目页静态页面
	 * @throws Exception
	 */
	public static  void createChannelPage(String templetePath,int currentPage,Page page,CmsChannel channel,List<CmsArticle> articleList) throws Exception{
	    Map<String,Object> map = new HashMap<String, Object>();
	    map.put("ctx", Servlets.getRequest().getContextPath());
	    map.put("channel", channel);
	    map.put("articleList", articleList);
	    map.put("page", page);
	 
	    FreemarkUtils.createStaticContent(templetePath,channel.getPath()+"/", "index_"+currentPage+".html", map);
	}
	/**  
	 * 网站文章 生成内容页静态页面
	*/  
	public static  void createContentPage(String templetePath,CmsArticle article,CmsChannel channel)throws Exception{   
		    //准备数据   
		    long articleId = article.getId();
	        String content = article.getContent();//Servlets.getRequest().getParameter("fckContent");
	        String targetPath = channel.getPath()+"/"+DateUtils.getCurrentDate(DateUtils.DATE_FORMAT)+"/"; 
		    /*
	         * 计算本篇文章的总页数
	         */
		    //分页符
			String pageBreak = "<div style=\"page-break-after: always\"><span style=\"display: none\">&nbsp;</span></div>";
			String[] contentItems = content.split(pageBreak);
			//总页数
			int totalPage = contentItems.length;
			//每页的的文件名
			List<String> eachPageNameList = new ArrayList<String>();
			for(int i=0;i<totalPage;i++){
				eachPageNameList.add(articleId+"_"+(i+1)+".html");//如3页：1_1.html、1_2.html、1_3.html
			}
			
			Map<String,Object> map = null;
			for(int i=0;i<totalPage;i++){
				int currentNum = i+1;
				String ctx = Servlets.getRequest().getContextPath();
				map = new HashMap<String,Object>(); 
				map.put("ctx",ctx);
				map.put("article", article);  
				map.put("eachPageNameList", eachPageNameList);
				map.put("content", contentItems[i]);//第i页的内容
				map.put("currentNum", currentNum);
				if(currentNum!=1){//前一页
				    map.put("prePage", articleId+"_"+(currentNum-1)+".html");
				}
				if(currentNum!=totalPage){//后一页
				    map.put("nextPage",articleId+"_"+(currentNum+1)+".html");
				}
				
				FreemarkUtils.createStaticContent(templetePath,targetPath, eachPageNameList.get(i), map);
			}
	}
	/**
	 * 上一篇/下一篇
	 * @param map
	 */
	/*public void getPreAndNextArticle(Map<String,Object> map){
		//上一篇
		Page page = new Page(1);
		CmsArticle temp = null;
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("isDraft", "1");
		paramMap.put("channelId", channel.getId());
		paramMap.put("preCreateTime", article.getReleaseDate());
		
		page = articleService.findPage(page,paramMap);
		if(page!=null && page.getList()!=null && page.getList().size()>0){
			temp = (CmsArticle) page.getList().get(0);
			map.put("preArticleTitle", temp.getTitle());
			map.put("preArticleUrl", temp.getOuterUrl());
		}
			
		//下一篇
		page = new Page(1);
		paramMap = new HashMap<String, String>();
		paramMap.put("isDraft", "1");
		paramMap.put("channelId", channel.getId());
		paramMap.put("nextCreateTime", article.getReleaseDate());
		page = articleService.findPage(page,paramMap);
		if(page!=null && page.getList()!=null && page.getList().size()>0){
			temp = (CmsArticle) page.getList().get(0);
			map.put("nextArticleTitle", temp.getTitle());
			map.put("nextArticleUrl", temp.getOuterUrl());
		}
	}*/
}
