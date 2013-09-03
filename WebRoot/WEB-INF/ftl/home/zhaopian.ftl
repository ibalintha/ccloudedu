<div class="channel-item" style="margin-top:10px">
    <div class="hd"><h3>${channel.channelName}</h3></div>
     <div class="ft clearfix">
        <ul>
            <#list articleList as article>
              <li> 
                 <a href="${article.outerUrl}">
                   <img width="315" height="155" src="" alt="${article.title}" />
                 </a>
                <h4><a href="${article.outerUrl}">${article.title}</a></h4>
              </li>   
           </#list>      
        </ul>
    </div>
</div>