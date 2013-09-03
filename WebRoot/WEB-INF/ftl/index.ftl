<!DOCTYPE html>
<html>
<head>
    <#include "/WEB-INF/ftl/includes/js_css.html">
    <title>ccloudedue-叶书俊的个人网站 </title>
    <meta name="keywords" content="ccloudedue，wade，个人工作室 " />
    <meta name="description" content="叶书俊的个人工作室 ，旨在开发更好的web软件，oa，网站等等，热线QQ：372566232" />
</head>
<body>
     <#--头部开始-->
     <#include "/WEB-INF/ftl/includes/head.html">
     <#--头部结束-->
	
     <#--正文开始-->
     <div class="section">
	 <#--右侧开始-->
         <div class="yex-mnlayout">
           <#--最新照片开始-->
           <#include "/front/home/zuixinzhaopian.html">
           <#--最新照片结束-->
           
           <#--日志开始-->
           <#include "/front/home/rizhi.html">
           <#--日志结束-->
           
           <#--说说开始-->
           <#include "/front/home/shuoshuo.html">
           <#--说说结束-->
           
           <#--留言开始-->
           <#include "/front/home/liuyan.html">
           <#--留言结束-->
        
           <#--照片开始-->
           <#include "/front/home/zhaopian.html">
           <#--照片结束-->
      </div>
      <#--右侧结束-->
      
      <#--左侧开始-->
      <div class="yex-aside">
         <div class="category">
           <#--我的承诺开始-->
           <#include "/WEB-INF/ftl/home/chengnuo.ftl">
           <#--我的承诺结束-->
            
            <#--我的动态开始-->
           <#include "/front/home/dongtai.html">
           <#--我的动态结束-->
        </div>
    </div>
      <#--左侧结束-->
   </div>
   <#--正文结束-->
	
   <#--底部开始-->
   <#include "/WEB-INF/ftl/includes/footer.html">
   <#--底部结束-->
</body>
</html>
