<div class="cmnfocus">
   <ul class="slide-img">
     <#list picArticleList as picartile>
       <li>
         <a href="${ctx}/${picartile.contentImg}" target="_blank" title="${picartile.title}">
           <img width="753" height="365" src="${ctx}/${picartile.contentImg}" alt="{picartile.title}" />
         </a>
        </li>
      </#list>     
   </ul>
</div>