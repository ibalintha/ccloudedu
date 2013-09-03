<!DOCTYPE html>
<html>
<head>
    <#include "/WEB-INF/ftl/includes/js_css.html">
    <title>ccloudedue</title>
    <meta name="keywords" content="ccloudedue，wade，个人工作室 " />
    <meta name="description" content="叶书俊的个人工作室 ，旨在开发更好的web软件，oa，网站等等，热线QQ：372566232" />
</head>
<body>
     <#--头部开始-->
     <#include "/WEB-INF/ftl/includes/head.html">
     <#--头部结束-->
	<div class="breadcrumb">
	    您当前的位置：<a href="/">首页</a> <span>> <h1>${channel.channelName}</h1> </span>
	</div>
	<div style="width:948px;margin:10px auto 0;overflow:hidden;background:#fff;padding:10px 26px;">
	    <div class="srch-mnlayout">
	       <div class="selection">
	         <div class="hd">
	            <a href="" class="select">全部（12）</a>
	            <a href="" >我的日志（6）</a>
	            <a href="" >私密日志（6）</a>
	            <a href="" >生活记录（6）</a>
	            <a href="" >记事本（6）</a>
	            <a href="" >好友日志（6）</a>        
	         </div>
	       </div>
	
	      <div class="srch-item" >
		   <div class="hd"><h3>全部</h3></div>
		   <div class="bd clearfix">
		     <#--文章列表开始-->
		      <div class="srch-thumb">
		        <ul>
		          <#list articleList as article>
	        	     <li>

                                         
   <div class="img"><#if article.contentImg??> 
    <a href="${article.outerUrl}" target="_blank">
       <img src="${ctx}${article.contentImg}"/>
    </a></#if>
   </div>


		                 <div class="cnt">
		                   <h4 class="tt ico-tuan"><a href="${article.outerUrl}" target="_blank">${article.title}</a></h4>
		                   <div class="txt123">
		                     <p>${article.content}</p><p> </p><p> </p>
		                   </div>
		                </div>
		               <p style="clear:both;"></p>
	        	     </li>
			     </#list>
		      </ul>
		    </div>
		    <#--文章列表结束-->
		    
		    <#--分页开始-->      
		    <div class="filter-tools clearfix">
		      <div class="pagination">
		            <#include "/WEB-INF/ftl/includes/listpage.flt">
		     </div> 
		     <#--分页结束--> 
		   </div>
		  </div>
		 </div>
	  </div>    
	</div>

   <#--底部开始-->
   <#include "/WEB-INF/ftl/includes/footer.html">
   <#--底部结束-->
</body>
</html>
