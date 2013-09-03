package com.ccloudedu.cms.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.utils.builder.HqlBuilder;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.file.FreemarkUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.cms.entity.CmsArticle;
import com.ccloudedu.cms.entity.CmsChannel;
import com.ccloudedu.cms.entity.CmsTemplet;
import com.ccloudedu.cms.service.ArticleService;

import edu.emory.mathcs.backport.java.util.Arrays;
@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<CmsArticle> implements ArticleService {

	@SuppressWarnings("unchecked")
	public Page findPage(Page page,Map<String,String> paramMap) throws Exception {
		HqlBuilder hqlBuilder = new HqlBuilder("select article from CmsArticle article where 1=1");
		
		   if(StringUtils.isNotEmpty(paramMap.get("channelId"))){
			   hqlBuilder.append(" and article.cmsChannel.id=:channelId").setParam("channelId", paramMap.get("channelId"));
		   }
		   if(StringUtils.isNotEmpty(paramMap.get("notinc"))){
			   hqlBuilder.append(" and article.cmsChannel.path not in (:notinc)").setParamList("notinc", Arrays.asList(paramMap.get("notinc").split(";")));
		   }
		   if(StringUtils.isNotEmpty(paramMap.get("path"))){
			   hqlBuilder.append(" and article.cmsChannel.path=:path").setParam("path", paramMap.get("path"));
		   }
		   if(StringUtils.isNotEmpty(paramMap.get("preCreateTime"))){
			   hqlBuilder.append(" and article.releaseDate>:preCreateTime").setParam("preCreateTime", paramMap.get("preCreateTime"));
		   }
		   if(StringUtils.isNotEmpty(paramMap.get("nextCreateTime"))){
			   hqlBuilder.append(" and article.releaseDate<:nextCreateTime").setParam("nextCreateTime", paramMap.get("nextCreateTime"));
		   }
		   if(StringUtils.isNotEmpty(paramMap.get("title"))){
			   hqlBuilder.append(" and article.title like:title").setParam("title", "%"+paramMap.get("title")+"%");
		   }
		   if(StringUtils.isNotEmpty(paramMap.get("isDraft"))){
			   hqlBuilder.append(" and article.isDraft=:isDraft").setParam("isDraft", paramMap.get("isDraft"));
		   }
		   if(StringUtils.isNotEmpty(paramMap.get("contentImg"))){
			   hqlBuilder.append(" and article.contentImg is not null and article.contentImg !=''");
		   }
		   if(StringUtils.isNotBlank(page.getOrderattr())){
			   hqlBuilder.append("order by ").append(page.getOrderattr()).append(" ").append(StringUtils.isBlank(page.getOrdertype())?"desc":page.getOrdertype());
			}else{
				 if(StringUtils.isNotEmpty(paramMap.get("preCreateTime"))){
					   hqlBuilder.append(" order by article.releaseDate asc");
				   }else{
					   if(StringUtils.isNotEmpty(paramMap.get("visitQuarter"))){//按点击率排序
						   hqlBuilder.append(" order by article.visitQuarter desc");
					   }else{
						   hqlBuilder.append(" order by article.releaseDate desc");//按创建时间排序
					   }
				   }
			}
		
		return this.findPage(page, hqlBuilder);
	}
    /**
     * 创建 或更新 文章
     */
	@Transactional(propagation=Propagation.REQUIRED)
	public int createStaticPage(CmsArticle article,long id) throws Exception{
		 if(id==0){
			 save(article);
		 }else{
			 update(article);
		 }
		 
		 CmsChannel channel = article.getCmsChannel();
       	 Set<CmsTemplet> templets = channel.getCmsTemplets();
       	 if(templets!=null && templets.size()>0){
       		//当前栏目下的文章，拥有的模板
       		for(CmsTemplet t : templets){
           		String templeteType = t.getTempleteType();
           		String templetePath = t.getTempletPath();
           		System.out.println(templetePath);
           		if("3".equals(templeteType)){//三级页面
           			updateContentPage(templetePath,article,channel);
           		}
           		else if("2".equals(templeteType)){//二级页面
           			updateChannelPage(templetePath,channel);		
    			}
           		else if("1".equals(templeteType)){//首页中的每个栏目块
           			updateIndexChanenlContent(templetePath,channel);
    	        }
           		else if("0".equals(templeteType)){//首页
            	   createIndexPage(templetePath);
     	        }
           	 }
       	 }
		return 1;
	}
	/**
	 * 删除文章，并更新静态页面
	 * @throws Exception 
	 */
	public int deleteAndUpdatePage(String[] strids) throws Exception{
		 //从数据库删除
		 Long[] ids = new Long[strids.length];
		 int i=0;
		 for(String strid :strids){
			 ids[i] = Long.parseLong(strid);
			 i++;
		 }
		 CmsChannel channel = get(ids[0]).getCmsChannel();
		 
		 deleteByIds(ids);
		 
		 //删除静态html文件
		 
		 //更新静态html文件
       	 Set<CmsTemplet> templets = channel.getCmsTemplets();
       	 if(templets!=null && templets.size()>0){
       		for(CmsTemplet t : templets){
           		String templeteType = t.getTempleteType();
           		String templetePath = t.getTempletPath();
           		if("2".equals(templeteType)){//更新二级页面
           			updateChannelPage(templetePath,channel);		
    			}
           		else if("1".equals(templeteType)){//更新首页中的每个栏目块
           			updateIndexChanenlContent(templetePath,channel);
    	        }
           		else if("0".equals(templeteType)){//更新首页
           			createIndexPage(templetePath);
     	        }
           	 }
       	 }
		
		return 1;
	}
	 /**
     * 生成/更新三级页面
     * @param templetePath 三级页面模板
     * @throws Exception
     */
    private int updateContentPage(String templetePath,CmsArticle article,CmsChannel channel) throws Exception{
    	 String ctx = Servlets.getRequest().getContextPath();
		  long articleId = article.getId();
	      String content = article.getContent();
	      String targetPath = channel.getPath()+"/"+DateUtils.getCurrentDate(DateUtils.DATE_FORMAT)+"/"; 
	      //第一页的url
	      article.setOuterUrl(ctx+"/"+targetPath+articleId+"_1.html");
	      
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
		  for(int i=0;i<totalPage;i++){
			  createContentPage(templetePath, targetPath, i, totalPage, ctx, article, channel, eachPageNameList, contentItems);
		  }
		  return 1;
 	     /*Map<String,String> paramMap = new HashMap<String, String>();
 	     //更新后一篇
 	     Page page = new Page(1);
 		 CmsArticle preArticle = null;
 		 paramMap = new HashMap<String, String>();
 		 //paramMap.put("isDraft", "1");
 		 paramMap.put("channelId", channel.getId());
 		 paramMap.put("nextCreateTime", article.getCreateTime());
 		 page = findPage(page,paramMap);
 		 if(page!=null && page.getList()!=null && page.getList().size()>0){
 			 preArticle = (CmsArticle) page.getList().get(0);
 		    StaticHtmlGeneration.createContentPage(templetePath, preArticle, channel);
 		}*/
    }
    
    /**
     * 生成/更新二级页面模板
     * @param firstPageList 文件页面-第一页数据list
     * @param templetePath 二级页面模板
     * @return firstPageList
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	private int updateChannelPage(String templetePath,CmsChannel channel) throws Exception{
    	 Map<String,String> paramMap = new HashMap<String, String>();
    	 
    	 //二级页面每页显示的文章条数
		 Page page = new Page(Integer.parseInt(channel.getSecondPageNum()));
		 paramMap = new HashMap<String, String>();
		 //paramMap.put("isDraft", "1");
		 paramMap.put("channelId", channel.getId());
		 //查询二级页面内容list（文章、图片、视频等）
		 page = findPage(page,paramMap);
    	
		//更新栏目第一页
		 if(page!=null && page.getList()!=null && page.getList().size()>0){
				createChannelPage(templetePath, 1, page, channel, page.getList());
		  }
		//更新栏目其他页
		 int currentPage = page.getCurrentPage();//1 2 3
		 int totalPage = page.getTotalPage();//3 
		 currentPage = 2;
		 while(currentPage<=totalPage){
			 page.setCurrentPage(currentPage);
			 page = findPage(page,paramMap);
			 if(page!=null && page.getList()!=null && page.getList().size()>0){
					List<CmsArticle> list = page.getList();
				    createChannelPage(templetePath, currentPage, page, channel, list);
			  }
			 currentPage = currentPage+1;
		 }
		 return 1;
   }
    
    /**
     * 生成/更新首页中的栏目块
     * @param firstPageList
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	private int updateIndexChanenlContent(String templetePath,CmsChannel channel) throws Exception{
    	//首页栏目块显示的文章条数
    	 Page page = new Page(Integer.parseInt(channel.getIndexPageNum()));
    	 Map<String, String> paramMap = new HashMap<String, String>();
		 //paramMap.put("isDraft", "1");
		 paramMap.put("channelId", channel.getId());
		 //查询二级页面内容list（文章、图片、视频等）
		 page = findPage(page,paramMap);
		 
		 createIndexChanenlContent(templetePath, channel, page.getList());
		 return 1;
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------
   /**
    * 生成内容页
    * @param templetePath
    * @param targetPath
    * @param i
    * @param totalPage
    * @param ctx
    * @param article
    * @param channel
    * @param eachPageNameList
    * @param contentItems
    * @return
    * @throws Exception
    */
	private int createContentPage(String templetePath,String targetPath,int i,int totalPage,
			String ctx,CmsArticle article,CmsChannel channel,
			List<String> eachPageNameList,String[] contentItems) throws Exception{
    	 int currentNum = i+1;
    	 HashMap<String,Object> map = new HashMap<String,Object>(); 
		 map.put("ctx",ctx);
	     map.put("article", article);  
		 map.put("eachPageNameList", eachPageNameList);
	  	 map.put("content", contentItems[i]);//第i页的内容
		 map.put("currentNum", currentNum);
		 if(currentNum!=1){//前一页
		     map.put("prePage", article.getId()+"_"+(currentNum-1)+".html");
		 }
		 if(currentNum!=totalPage){//后一页
		     map.put("nextPage",article.getId()+"_"+(currentNum+1)+".html");
		 }
			
		 FreemarkUtils.createStaticContent(templetePath,targetPath, eachPageNameList.get(i), map);
		 return 1;
    }
	/**
	 * 生成栏目页静态页面
	 * @throws Exception
	 */
	private void createChannelPage(String templetePath,int currentPage,Page page,CmsChannel channel,List<CmsArticle> articleList) throws Exception{
	    Map<String,Object> map = new HashMap<String, Object>();
	    map.put("ctx", Servlets.getRequest().getContextPath());
	    map.put("channel", channel);
	    map.put("articleList", articleList);
	    map.put("page", page);
	    FreemarkUtils.createStaticContent(templetePath,channel.getPath()+"/", "index_"+currentPage+".html", map);
	}
	/**
	 * 更新或创建首页栏目列表内容（首页中的每个栏目块）
	 * @throws IOException 
	 */
	public void createIndexChanenlContent(String templetePath,CmsChannel channel,List<CmsArticle> articleList) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ctx", Servlets.getRequest().getContextPath());
		map.put("channel", channel);
		map.put("articleList", articleList);
		
	    FreemarkUtils.createStaticContent(templetePath, "front/home/", channel.getPath()+".html", map);
	}
	/**
	 * 更新或创建首页index.html
	 * @throws Exception
	 */
	public static void createIndexPage(String templetePath) throws Exception{
	    Map<String,Object> map = new HashMap<String, Object>();
	    map.put("ctx", Servlets.getRequest().getContextPath());
	    FreemarkUtils.createStaticContent(templetePath, "", "index.html", map);
	}
}
