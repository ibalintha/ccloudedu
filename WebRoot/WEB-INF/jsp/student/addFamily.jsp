<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
     <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>	
     <script type="text/javascript">
	    
    var api = frameElement.api, W = api.opener,cDG;
    var addordetail = true;  
    $(function() {
    	//var scroId = $("#scroId").value;
    	
    	$("#smsc").click(function(){
    		if($("input[name='smsc']").attr("checked") == "checked"){
	    		document.getElementById("sms").value = "是";
	    	}else{
	    		document.getElementById("sms").value = "否";
	    	}
    	});   	

    	
	    $("#submitBtn").submitForm({	    	    
	    	formId:"familyForm",
			onComplete:function(){				
				api.close();
			}
		});   
    });

	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="学籍管理" enText="Enrollment Manage"/> - <my:i18n zhText="新增家庭信息" enText="Add Family Information"/></div>	
	<div class="clear"></div>
</div>
<div>	    
	<form id="familyForm" action="student/addfamily_addFamily.do?" method="post">
		<input type="hidden" name="scroId" id="scroId" value="${scroId}"/>
		<table width="100%" class="ftable">	                 
           <tr style="width: 100%">
            <th width="12%"><my:i18n zhText="姓名" />：</th>
            <td>
            	<input type="text" name="name" value="" id="name" />
            	<font color="red">*</font>
            </td>
            <th width="12%"><my:i18n zhText="年龄" />：</th>
            <td><input type="text" name="age" value="" id="age" /></td>
            </tr>
            <tr>
            <th width="12%"><my:i18n zhText="与本人关系" />：</th>
            <td><select type="select" name="relationship" id="relationship" style="width:71%">                       
                 	<option value="父亲">父亲</option>
                 	<option value="母亲">母亲</option>
                 	<option value="哥哥">哥哥</option>
                 	<option value="姐姐">姐姐</option>
                 	<option value="弟弟">弟弟</option>
                 	<option value="妹妹">妹妹</option>
                 	<option value="其他">其他</option>
               	</select> 
            </td>
            <th width="12%"><my:i18n zhText="政治面貌" />：</th>
            <td><select type="select" name="polface" id="polface" style="width:40%">                       
                 	<c:forEach items="${plfaList}" var="plfa" varStatus="status">
						<option value="${plfa.id}">${plfa.chPlfaName}</option>
					</c:forEach>
               	</select> 
            </td>
          </tr>
          <tr>
            <th width="12%"><my:i18n zhText="工作单位" />：</th>
            <td><input type="text" name="company" value="" id="company" /></td>
            <th width="12%"><my:i18n zhText="单位地址" />：</th>
            <td><input type="text" name="address" value="" id="address"/></td>
          </tr>        
          <tr>
             <th width="12%"><my:i18n zhText="职务" />：</th>
            <td><input type="text" name="position" value="" id="position" /></td>
            <th width="12%"><my:i18n zhText="休 息 日" />：</th>
            <td><input type="text" name="vacation" id= "vacation" value=""/></td>
          </tr>          
          <tr>
            <th width="12%"><my:i18n zhText="邮政编码" />：</th>
            <td><input type="text" name="zip" value="" id="zip"/></td>
            <th width="12%"><my:i18n zhText="电子邮件" />：</th>
            <td><input type="text" name="email" value="" id="email"/></td>
          </tr>
          <tr>
            <th width="12%"><my:i18n zhText="联系电话" />：</th>
            <td><input type="text" name="phone" value="" id="phone"/></td>
            <th width="12%"><my:i18n zhText="联系手机" />：</th>
            <td>
            	<input type="text" name="cell" value="" id="cell"/>
            	<input type="checkbox" name="smsc" id="smsc"/>
            	<input type="hidden" name="sms" id="sms" value=""/>
            	<label>是否订购短信服务</label>            	
            </td>
          </tr> 
          <tr>
             <th width="12%"><my:i18n zhText="特长" />：</th>
          	 <td colspan="5">  <input type="text" name="special" value="" id="special" style="width:80%" /></td>
          </tr>
           <tr>
             <th width="12%"><my:i18n zhText="志愿服务意向" />：</th>
          	 <td colspan="5">  <input type="text" name="type" value="" id="type" style="width:80%" /></td>
          </tr>
          <tr>
             <th width="12%"><my:i18n zhText="志愿服务记录" />：</th>
          	 <td colspan="5">  <input type="text" name="record" value="" id="record" style="width:80%" /></td>
          </tr>
           <tr>
			  <td colspan="6" class="ftablebutton">
				 <input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="提交" enText="Save"/>" id="submitBtn"/> &nbsp; 
				 <input type="reset" class="button orange"  class="button orange" value="<my:i18n zhText="重置" enText="Reset"/>"/>				  		
			</td>
	      </tr>
	      
        </table>
        
    </form>     
  </div>  
</div>		 
</body>
</html>