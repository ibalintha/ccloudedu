<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
     <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>	
     <script type="text/javascript">
      function moveToList(from, to) {
				var fromList = document.getElementById(from);//
				var toList = document.getElementById(to);//
				for ( var i = 0; i < fromList.options.length; i++) {//
					var current = fromList.options[i];//
					if (current.selected) {//
						var txt = current.text;		//				
						var val = current.value;//
												
						var isexist = 0;//默认不存在
						for(var j = 0;j < toList.options.length;j++)//
						{//
							var to = toList.options[j];//
							if(to.text == txt && to.value == val)//
							{//
								isexist++;//
								break;//
							}
						}
						//
						if(isexist == 0){							//
							toList.options[toList.length] = new Option(txt,val);//
							fromList.options[i] = null;//
							i--;//
						}
					}

				}
			}
			
			
			function  inputValue(){
			var list = document.getElementById("belongToList");			
			
			var tempList = "";
			for ( var i = 0; i < list.options.length; i++) {
				
				if (tempList == "") {
					tempList = list.options[i].value;
				} else {
					tempList = tempList + "," + list.options[i].value;
				}

			}
			document.getElementById("idList").value = tempList;//最终修改后的选中班级
			}
			
        var tolisturl = "${ctx}/student/student_list.do";
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;      
       $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"studentForm",
				 onComplete:function(){
				     W.reloadStudent();
				     api.close();
				     window.location.href = tolisturl;
				 }
			  });
		}); 
		function cancel(){
	var api = frameElement.api;
	  api.close();
	}  
     </script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="新生管理" enText="User Mgt"/> - <my:i18n zhText="自动分班" enText="Add A New User"/></div>
	
	<div class="clear"></div>
</div>


	    <div id="result" align="center" style="color: red"></div>
		  <form id="studentForm" action="student/student_autoSave.do" method="post">
		  <input type="hidden" id="ids"name="ids"value="${ids}"> 
		   <table style="width:100% "class="ftable">
	          <tr>
	          <td style="width:40%">
	                          可选择班级列表：
	          <select style="width:100%" multiple="multiple" size="10" name="notBelongToList" id="notBelongToList" >
					<c:forEach items="${chclasstreeList}" var="chclasstreeList">
						<option value="${chclasstreeList.id}">${chclasstreeList.name}</option>
					</c:forEach>
				</select>
	          </td>
	          <td style="width:20%"style="text-align:center">
	           <input name="" type="button" style="width:50px; vertical-align:middle; margin-top:0px;" value=">" onclick="moveToList('notBelongToList','belongToList')"/><br/>
               <!-- <input name="" type="button" style="width:50px; vertical-align:middle; margin-top:0px;" value=">>" /><br/> -->
               <input name="" type="button" style="width:50px; vertical-align:middle; margin-top:0px;" value=" &lt;" onclick="moveToList('belongToList','notBelongToList')"/><br/>
               <!-- <input name="" type="button" style="width:50px; vertical-align:middle; margin-top:0px;" value=" &lt; &lt;" /> -->
	          </td>
	          <td style="width:40%">
	                           选中班级列表：
	          <select style="width:100%" multiple="multiple" size="10" name="belongToList" id="belongToList" >
					
				</select>
				  <input type="hidden" name="idList"  id="idList"  /> 
	          </td>
	          </tr>
       
           <tr>
                 <td colspan="3" style="text-align:center">
                 <input name="chStudSex" type="checkbox" value="1">性别
            <input name="chStudCadreflag" type="checkbox" value="2">    是否担任过班干部
                 <input name="chStudAdmway" type="checkbox" value="3">入学方式
            <input name="chStudScore" type="checkbox" value="4">     入学成绩
                 </td>
           </tr>
      
           <tr>
			<td colspan="4" class="ftablebutton">
				
				   <input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn" onclick="inputValue()" /> &nbsp; 
				   <input type="reset" class="button orange"  class="button orange" value="<my:i18n zhText="取消" enText="Cancel"/>"onclick="cancel();"/>
				
			</td>
	      </tr>
        </table>
        </form>
        
         <div id="menuContentDeptTree" class="menuContentDeptTree" style="display:none; position: absolute;">
			<ul id="deptTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:300px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
	    <div id="menuContentRoleTree" class="menuContentRoleTree" style="display:none; position: absolute;">
			<ul id="roleTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:200px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
    </div>
</body>
</html>