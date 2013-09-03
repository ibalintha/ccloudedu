<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
    <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
	var tolisturl = "${ctx}/underlying/campus_list.do";
//隐藏框的编辑
		window.onload = function() {
	    	if(document.getElementById("checkflag1").value == "Y"){
    			$("input[name='chCampShowflag']").attr("checked","checked");
    		}	    	
		};	
	   
		$(function(){
//隐藏框的增加
			$("#checkId").click(function(){
    			if($("input[name='chCampShowflag']").attr("checked") == "checked"){
	    			document.getElementById("checkflag").value = "Y";
	    		}else{
	    			document.getElementById("checkflag").value = "N";
	    		}
    		});  
		

		
			$(".number").number();
	    	$(".Wdate").click(function(){
	    		WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});
	        });
	    	//$("#showPassword").click(function(){$(".passWord").showHidePassword();});
	    	
	    	//setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
			//zTree = $("#tree").zTree(setting, zNodes);
			
			 var api = frameElement.api, W = api.opener,cDG;
			$("#submitBtn").submitForm({ 
				formId:"campusForm",
				onComplete:function(){
			     api.close();
				 api.reload(W,tolisturl);
				}
			}); 
		});  
		
		
		
	
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"> <my:i18n zhText="校区信息" enText="Campus"/> - 添加</div>
	<%-- <div  class="pheadbutton">
	   <input type="button" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div> --%>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="campusForm" action="underlying/campus_save.do" method="post">
		    <input type="hidden" id= "id" name="id" value="${id}" /> 
	
		         
		    <table width="100%" class="ftable">
	          
           <tr>
            <th width="12%"><font color="red">*</font><my:i18n zhText="校区编号" />：</th>
            <td><input type="text" name="chCampCode" value="${campus.chCampCode}" id="chCampCode" /></td> 
          </tr>
          
           <tr>
             <th width="12%"><font color="red">*</font><my:i18n zhText="校区名称" />：</th>
            <td><input type="text" name="chCampName" value="${campus.chCampName}" id="chCampName" /></td> 
           </tr>
        
           <tr>
             <th width="12%"><my:i18n zhText="校区地址" />：</th>
            <td><input type="text" name="chCampAddress" value="${campus.chCampAddress}" id="chCampAddress" /></td>
            </tr>
            
            <tr>
             <th width="12%"><my:i18n zhText="校区介绍" />：</th>
            <td><input type="text" name="chCampDesc" value="${campus.chCampDesc}" id="chCampDesc" /></td>
            </tr>
          
          
             <tr>
             <th width="12%"><my:i18n zhText="隐藏标识" />：</th> 	
                   
            <td><input type="checkbox" name="chCampShowflag" value="${campus.chCampShowflag}" id="checkId" />
            	  
		      <!-- 为checkBox增加而设置的一个隐藏input框 --> 
             <input type="hidden" type="text" value="${campus.chCampShowflag}" id="checkflag" name="checkflag"/>
              <!-- 为checkBox编辑而设置的一个隐藏input框 --> 
             <input type="hidden" type="text" value="${campus.chCampShowflag}" id="checkflag1" name="checkflag1"/>
            </td>
                 
             </tr>
            
            
              <tr>
             <th width="12%"><my:i18n zhText="备注" />：</th>
            <td><input type="text" name="chCampMemo" value="${campus.chCampMemo}" id="chCampMemo" /></td>
            </tr>


           <tr>
			<td colspan="7" class="ftablebutton">
				<input type="button" class="button orange" value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; 
		   </td>
	      </tr>
        </table>
        </form>
	   
    </div>
</body>
