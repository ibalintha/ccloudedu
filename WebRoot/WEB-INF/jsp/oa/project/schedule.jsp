<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head datePicker="true" lhgdialog="true" multiFile="true">
   <script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery.autocomplete.js"></script>
   <script type="text/javascript">
        var api = frameElement.api, W = api.opener;
        var addordetail = true;
        $(function() {
			 $(".Wdate").click(function(){WdatePicker({skin:'blue',dateFmt:"yyyy-MM-dd",lang:$.i18n('lang')});});
			 $("#submitBtn").submitForm({ 
				 formId:"projectForm",
				 onSubmit:function(){
				     $("#participantTable :input[name='userIds']").each(function(i){
				    	 if($(this).val()==""){
				    		 if($(this).siblings(":input").val()==""){
				    			  $("#valideParticipant").html("").html("第"+(i+1)+"行，姓名不能为空");
				    			  $(this).attr("rules","[{notNull:true}]");
				    		 }else{
				    			 $("#valideParticipant").html("").html("第"+(i+1)+"行，姓名：“"+$(this).siblings(":input").val()+"”在系统中不存在，请确认；或重新输入姓名，进行选择");
				    			  $(this).attr("rules","[{notNull:true}]");
				    		 }
				    	 }
				     })
				 },
				 onComplete:function(){
				     //W.reloadProject();
				     // api.close();
				 }
			  });
		});
        function clearValide(){
        	 $("#valideParticipant").html("");
        }
        function deleteUploadFile(id){
		      if(confirm("删除将不可恢复，您确定要删除吗")){
		    	  $.post("${ctx}/oa/projectSchedule_deleteUploadFileByAjax.do",{"uploadFileId":id},
		    		     function(ret){
		    		    	 if(ret.code=="0"){
		    		    		 alert("文档删除成功");
		    		    		 $("#"+id+"span").remove();
		    		    	 }
		    		     }
		    	   )
	          }
	     }
        function addRow(){
        	$("#participantTable").append($("#templeteTable").html());
        }
        function copyRow($obj){
        	$("#participantTable").append($("#templeteTable").html());
        	$obj.parent("td").parent("tr").find(":input").each(function (i) {
		       $("#participantTable tr:last :input").eq(i).val($(this).val());
		    })
        }
        function deleteRow($obj){
        	if($("#participantTable tr").size()>2){
        		if(confirm("您确定要删除吗")) {
        			$obj.parent("td").parent("tr").remove();
        		}
        	}else{
        		alert("总得留一行吧");
                return false;
        	}
        }
       var obj;
       function autoComplete($obj){
    	   obj = $obj;
    	   if($obj.val().length>=2){
    		   $obj.autocomplete({ 
						ajax_get: get_look,                                       
					    callback: print_sugg,                                       
					    cache:true,
					    minchars:1
		    });
    	   }
       }
       function get_look(userName,cont){
        	 $.post("${ctx}/system/user_getUserByAjax.do",{"userName":userName},
		    		 function(json){
        		         obj.siblings(":input").val("");
		    		     var res = [];
			             for(var i=0;i<json.length;i++){
			        	     res.push({ id:json[i].id , value:json[i].userName});
			             }
			             cont(res);
			             if(json.length==1){
			            	 obj.siblings(":input").val(json[0].id);
			             }
		    		  },"json"
		     )
          }

    	function print_sugg(v){ 
    		try{
    			obj.siblings(":input").val(v.id);
    		}catch(e) {
    			alert("请先选择用户，再输入其他项");
    		}
    	}
    	function r(){
    		window.location.href="${ctx}/oa/projectSchedule_completedSchedule.do?projectId=${oaProject.id}";
    	}
	</script>
</my:head>
<body>
<div class="bodybox">
  <div class="phead"">
    <div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： 项目阶段设置 - <my:position value="${id}"/> </div>
	    <div class="pheadbutton">
			<input type="button" class="button orange"  value="返回" onclick="r();"/>
		</div>
	<div class="clear"></div>
  </div>
<form method="post" action="${ctx }/oa/projectSchedule_save.do" id="projectForm" enctype="multipart/form-data">
      <input type="hidden" value="${oaProject.id}" name="projectId"/>
      <input type="hidden" value="${id}" name="id"/>
      
      <table width="100%" class="ftable"id="ftable">
       <tr>
	       <td colspan="4" style="padding-left: 20px"><b>本阶段信息</b></td>
	  </tr>
      <tr>
		  <th width="15%">项目编号：</th>
		  <td>${oaProject.projectCode }</td>
		  <th width="12%">项目名称：</th>
		  <td>${oaProject.projectName}</td>
	  </tr>
	  <tr>
		  <th><font color="red">*</font>目前阶段：</th>
		  <td colspan="3">
		    <my:select pvalue="jieduan" name="scheduleCode" value="${scheduleCode}" rules="[{notNull:true, message:'请选择目前阶段'}]"/>
		  </td>
	  </tr>
	  <tr>
		  <th width="15%"><font color="red">*</font>开始日期：</th>
		  <td><input type="text" name="startDt" value="${startDt }" class="Wdate" readonly="readonly" rules="[{notNull:true, message:'请选择开始日期'}]"/></td>
		  <th width="12%"><font color="red">*</font>结束日期：</th>
		  <td><input type="text" name="endDt" value="${endDt }" class="Wdate" readonly="readonly" rules="[{notNull:true, message:'请选择结束日期'}]"/></td>
	  </tr>
	  <tr>
		  <th ><font color="red">*</font>阶段描述：</th>
		  <td colspan="3">
		    <textarea name="description" style="width: 510px;height: 75px" rules="[{notNull:true, message:'阶段描述不能为空'}]">${description}</textarea>
		  </td>
		</tr>
		<tr>
		  <th>相关文档：</th>
		 <td colspan="3">
		    <input type="file" name="upload" size="41" value="" id="upload" class="multi"/>
		    <c:forEach items="${uploadFileList}" var="upfile">
		        <span id="${upfile.id}span">
		            <a href="${ctx}/oa/projectSchedule_download.do?id=${id}&uploadFileId=" title="下载">${upfile.uploadFileName }[${upfile.uploadFileSize}]</a>
		            <a href="javascript:" title="删掉" onclick="deleteUploadFile('${upfile.id}')">[删除]</a>
		            <br/>
		         </span>
		     </c:forEach>
		  </td>
	  </tr>
	  <tr>
	       <td colspan="4" style="padding-left: 20px"><b>本阶段参与人员</b>&nbsp;&nbsp<span style="color: red" id="valideParticipant"></span> </td>
	  </tr>
	  <tr>
	      <td colspan="4" style="text-align: center;">
	        <table class="ftable" style="text-align:center;" width="98%" cellspacing="1" cellpadding="0" border="0" id="participantTable">
				<tr>
					<th style="text-align: center;" width="13%"><my:i18n zhText="角色" enText="Role"/></th>
					<th style="text-align: center;" width="13%">姓名</th>
					<th style="text-align: center;" width="13%">开始时间</th>
					<th style="text-align: center;" width="13%">结束时间</th>
					<th style="text-align: center;" nowrap="nowrap">责任描述</th>
					<th style="text-align: center;" width="15%" nowrap="nowrap"><my:i18n zhText="操作" enText="Action"/></th> 
				</tr>
				<c:forEach items="${oaProjectParticipant}" var="cp">
				    <tr>
						<td style="text-align: center;" nowrap="nowrap">
						   <select style="width: 110px" name="roleIds">
						       <c:forEach items="${roleList}" var="role">
						          <option value="${role.id}" <c:if test="${cp.sysRole.id==role.id}">selected="selected"</c:if>>${role.roleName}</option>
						       </c:forEach>
						   </select> 
						</td>
						<td style="text-align: center;" nowrap="nowrap">
						    <input type="text" size="12" name="participantUserName" value="${cp.sysUser.userName}" onfocus="clearValide();" onkeyup="autoComplete($(this))"/>
						    <input type="hidden" name="userIds" value="${cp.sysUser.id}"/>
						</td>
						<td style="text-align: center;" nowrap="nowrap"><input type="text" size="12" name="startDts" value="${cp.startDt}" readonly="readonly" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n('lang')})" /></td>
						<td style="text-align: center;" nowrap="nowrap"><input type="text" size="12" name="endDts" value="${cp.startDt}" readonly="readonly" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n('lang')})" /></td>
						<td style="text-align: center;" nowrap="nowrap"><input type="text" size="41" name="descriptions" value="${cp.description}"/></td>
						<td style="text-align: center;" width="15%" nowrap="nowrap">
	                       <a href="javascript:" title="新增" onclick="addRow()">[新增]</a>
	                       <a href="javascript:" title="复制" onclick="copyRow($(this))">[复制]</a>
			               <a href="javascript:" title="删除" onclick="deleteRow($(this))">[删除]</a>
	                    </td> 
					</tr>
				</c:forEach>
				<c:if test="${empty oaProjectParticipant}">
					<tr>
						<td style="text-align: center;" nowrap="nowrap">
						   <select style="width: 110px" name="roleIds">
						       <c:forEach items="${roleList}" var="role">
						          <option value="${role.id}">${role.roleName}</option>
						       </c:forEach>
						   </select> 
						</td>
						<td style="text-align: center;" nowrap="nowrap">
						    <input type="text" size="12" name="participantUserName"  onfocus="clearValide();" onkeyup="autoComplete($(this))"/>
						    <input type="hidden" name="userIds" value=""/>
						</td>
						<td style="text-align: center;" nowrap="nowrap"><input type="text" size="12" name="startDts" readonly="readonly" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n('lang')})" /></td>
						<td style="text-align: center;" nowrap="nowrap"><input type="text" size="12" name="endDts" readonly="readonly" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n('lang')})" /></td>
						<td style="text-align: center;" nowrap="nowrap"><input type="text" size="41" name="descriptions"/></td>
						<td style="text-align: center;" width="15%" nowrap="nowrap">
	                       <a href="javascript:" title="新增" onclick="addRow()">[新增]</a>
	                       <a href="javascript:" title="复制" onclick="copyRow($(this))">[复制]</a>
			               <a href="javascript:" title="删除" onclick="deleteRow($(this))">[删除]</a>
	                    </td> 
					</tr>
				</c:if>
	          </table>
	      </td>
	  </tr>
	  <tr>
		<td colspan="4" class="ftablebutton">
			<input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
			<input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/>
		</td>
	 </tr>
	</table>
</form>
</div> 
              <table id="templeteTable" style="display: none">
                <tr>
					<td style="text-align: center;" nowrap="nowrap">
					   <select style="width: 110px" name="roleIds">
					       <c:forEach items="${roleList}" var="role">
					          <option value="${role.id}">${role.roleName}</option>
					       </c:forEach>
					   </select> 
					</td>
					<td style="text-align: center;" nowrap="nowrap">
					    <input type="text" size="12" name="participantUserName"  onfocus="clearValide();" onkeyup="autoComplete($(this))"/>
					    <input type="hidden" name="userIds" value=""/>
					</td>
					<td style="text-align: center;" nowrap="nowrap"><input type="text" size="12" name="startDts" readonly="readonly" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n('lang')})" /></td>
					<td style="text-align: center;" nowrap="nowrap"><input type="text" size="12" name="endDts" readonly="readonly" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n('lang')})" /></td>
					<td style="text-align: center;" nowrap="nowrap"><input type="text" size="41" name="descriptions"/></td>
					<td style="text-align: center;" width="15%" nowrap="nowrap">
                       <a href="javascript:" title="新增" onclick="addRow()">[新增]</a>
                       <a href="javascript:" title="复制" onclick="copyRow($(this))">[复制]</a>
		               <a href="javascript:" title="删除" onclick="deleteRow($(this))">[删除]</a>
                    </td> 
				</tr>
			</table>  
</body>
</html>