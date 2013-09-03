package com.ccloudedu.oa.article.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.base.utils.file.FreemarkUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.oa.article.entity.OaArticle;
import com.ccloudedu.oa.article.service.OaArticleService;
/**
 * 后台信息发布--service
 * @author wade
 *
 */
@Service
@Transactional
public class OaArticleServiceImpl extends BaseServiceImpl<OaArticle> implements OaArticleService {

	public Page findPage(Page page,String categoryValue,String isDraft) throws Exception{
		Map<String,String> paramMap = new FastMap<String,String>().newHashMap().set("categoryValue", categoryValue).set("isDraft", isDraft);
		return findPage(page, "oa.findArticles",paramMap);
	}
	
	public int createStaticPage(OaArticle oaArticle, String id)throws Exception{
		 oaArticle.setReleaseDate(oaArticle.getCreateTime());
		 if(StringUtils.isBlank(id)){
			 save(oaArticle);
		 }else{
			 update(oaArticle);
		 }
		 updateContentPage("/WEB-INF/ftl/oacontent.ftl",oaArticle);
		 return 1;
	}
	
	 /**
     * 生成/更新三级页面
     * @param templetePath 三级页面模板
     * @throws Exception
     */
    private int updateContentPage(String templetePath,OaArticle oaArticle) throws Exception{
    	 String ctx = Servlets.getRequest().getContextPath();
		  String articleId = oaArticle.getId();
	      String content = oaArticle.getContent();
	      String targetPath = oaArticle.getCategoryValue()+"/"+DateUtils.getCurrentDate(DateUtils.DATE_FORMAT)+"/"; 
	      //第一页的url
	      oaArticle.setOuterUrl(ctx+"/"+targetPath+articleId+"_1.html");
	      
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
			  createContentPage(templetePath, targetPath, i, totalPage, ctx, oaArticle, eachPageNameList, contentItems);
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
 			String ctx,OaArticle oaArticle,
 			List<String> eachPageNameList,String[] contentItems) throws Exception{
     	 int currentNum = i+1;
     	 HashMap<String,Object> map = new HashMap<String,Object>(); 
 		 map.put("ctx",ctx);
 	     map.put("article", oaArticle);  
 		 map.put("eachPageNameList", eachPageNameList);
 	  	 map.put("content", contentItems[i]);//第i页的内容
 		 map.put("currentNum", currentNum);
 		 if(currentNum!=1){//前一页
 		     map.put("prePage", oaArticle.getId()+"_"+(currentNum-1)+".html");
 		 }
 		 if(currentNum!=totalPage){//后一页
 		     map.put("nextPage",oaArticle.getId()+"_"+(currentNum+1)+".html");
 		 }
 			
 		 FreemarkUtils.createStaticContent(templetePath,targetPath, eachPageNameList.get(i), map);
 		 return 1;
     }
}
