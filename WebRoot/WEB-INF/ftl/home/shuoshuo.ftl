<div class="channel-item" style="margin-top:10px">
    <div class="hd"><h3>${channel.channelName}</h3></div>
    <div class="bd clearfix">
       <ul>
         <#list articleList as article>
           <li class="ico-zi">
             <p>[${article.releaseDate}]<a href="${article.outerUrl}">${article.title}</a></p>
           </li>
         </#list>
       </ul>
     </div>
</div>