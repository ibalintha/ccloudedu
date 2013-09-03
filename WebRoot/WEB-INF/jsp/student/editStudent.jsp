<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
    <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
	var tolisturl = "${ctx}/student/student_list.do";
	function reloadStudent(){
			location.href="${ctx}/student/student_list.do";
		}
	function cancel(){
	var api = frameElement.api;

	  api.close();
	}   
		$(function(){
			$(".number").number();
	    	$(".Wdate").click(function(){
	    		WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd',lang:$.i18n("lang")});
	        });
	    	//$("#showPassword").click(function(){$(".passWord").showHidePassword();});
	    	
	    	//setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
			//zTree = $("#tree").zTree(setting, zNodes);修改成功
			var chClasId= $("#chClasId").val();
		    var tolisturl = "${ctx}/student/student_list.do?chClasId="+chClasId;
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;      
       $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"studentForm",
				 resetForm:false,
						onSubmit:function(){
							// var checkedNodes = zTree.getCheckedNodes();
							 //alert($('#chRoleFlag').val());
							//modify by liuchx 20130806 begin
							//alert(window.parent.frames[1].frames[0].name);
							//alert(window.parent.document.iframes["角色管理"].document.body.innerHTML);
							//将修改的值组合成json传递给父页面
							//取出选中的role标记并传递
							var sendValue="({\"ID\":"+"\""+
		   				  				  $('#id').val()+"\""+
		   				  				  ","+
		   				  				  "\"chStudBirthplace\":"+"\""+
		   				  				  $('#chStudBirthplace').val()+"\""+
		   				  				  ","+
                                          "\"chStudName\":"+"\""+
		   				  				  $('#chStudName').val()+"\""+
		   				  				  ","+
                                          "\"chStudAdmway\":"+"\""+
		   				  				  $('#chStudAdmway').val()+"\""+
		   				  				  ","+
                                          "\"chStudNational\":"+"\""+
		   				  				  $('#chStudNational').val()+"\""+
		   				  				  ","+
                                          "\"chStudEngname\":"+"\""+
		   				  				  $('#chStudEngname').val()+"\""+
		   				  				  ","+
                                          "\"chStudEnrolldate\":"+"\""+
		   				  				  $('#chStudEnrolldate').val()+"\""+
		   				  				  ","+
                                          "\"chStudHometown\":"+"\""+
		   				  				  $('#chStudHometown').val()+"\""+
		   				  				  ","+
                                         "\"chStudOldname\":"+"\""+
		   				  				  $('#chStudOldname').val()+"\""+
		   				  				  ","+
                                          "\"chStudSourareas\":"+"\""+
		   				  				  $('#chStudSourareas').val()+"\""+
		   				  				  ","+
                                          "\"chStudEthnic\":"+"\""+
		   				  				  $('#chStudEthnic').val()+"\""+
		   				  				  ","+
                                          "\"chStudSex\":"+"\""+
		   				  				  $('#chStudSex').val()+"\""+
		   				  				  ","+
                                          "\"chStudOldschool\":"+"\""+
		   				  				  $('#chStudOldschool').val()+"\""+
		   				  				  ","+
                                          "\"chStudHealth\":"+"\""+
		   				  				  $('#chStudHealth').val()+"\""+
		   				  				  ","+
                                          "\"chStudBirth\":"+"\""+
		   				  				  $('#chStudBirth').val()+"\""+
		   				  				  ","+
                                          "\"chStudGrade\":"+"\""+
		   				  				  $('#chStudGrade').val()+"\""+
		   				  				  ","+
                                          "\"chStudBloodtype\":"+"\""+
		   				  				  $('#chStudBloodtype').val()+"\""+
		   				  				  ","+
                                          "\"chStudPersontype\":"+"\""+
		   				  				  $('#chStudPersontype').val()+"\""+
		   				  				  ","+
                                          "\"chClasId\":"+"\""+
		   				  				  $('#chClasId').val()+"\""+
		   				  				  ","+
                                          "\"chStudAddress\":"+"\""+
		   				  				  $('chStudAddress').val()+"\""+
		   				  				  ","+
                                          "\"chStudPersonid\":"+"\""+
		   				  				  $('#chStudPersonid').val()+"\""+
		   				  				  ","+
                                          "\"chStudScore\":"+"\""+
		   				  				  $('#chStudScore').val()+"\""+
		   				  				  ","+
                                          "\"chStudLocakind\":"+"\""+
		   				  				  $('#chStudLocakind').val()+"\""+
		   				  				  ","+
                                          "\"chStudPhone\":"+"\""+
		   				  				  $('#chStudPhone').val()+"\""+
		   				  				  ","+
                                          "\"chStudCadreflag\":"+"\""+
		   				  				  $('#chStudCadreflag').val()+"\""+
		   				  				  ","+
                                          "\"chStudLocation\":"+"\""+
		   				  				  $('#chStudLocation').val()+"\""+
		   				  				  ","+
                                          "\"chStudTranaddress\":"+"\""+
		   				  				  $('#chStudTranaddress').val()+"\""+
		   				  				  ","+
                                          "\"chStudSpecial\":"+"\""+
		   				  				  $('#chStudSpecial').val()+"\""+
		   				  				  ","+
                                          "\"chStudFlowperson\":"+"\""+
		   				  				  $('#chStudFlowperson').val()+"\""+
		   				  				  ","+
                                          "\"chStudZip\":"+"\""+
		   				  				  $('#chStudZip').val()+"\""+
		   				  				  ","+
                                          "\"chStudPolface\":"+"\""+
		   				  				  $('#chStudPolface').val()+"\""+
		   				  				  ","+
                                          "\"chStudForeign\":"+"\""+
		   				  				  $('#chStudForeign').val()+"\""+
		   				  				  ","+
		   				  				  "\"chStudEmail\":"+"\""+
		   				  				  $('#chStudEmail').val()+"\""+
		   				  				  ","+
		   				 				  "\"chStudOnly\":"+"\""+
		   				  				  $('#chStudOnly').val()+"\""+
		   								  ","+
		   								  "\"chStudWebsite\":"+"\""+
		   								  $('#chStudWebsite').val()+"\""+
		   				 				  ","+
		   								  "\"chStudMemo\":"+"\""+
		   								  $('#chStudMemo').val()+"\""+
		   								  "})";
							/*
							 * comment:将修改后的值传递给父页面
							 * window.parent.frames['系统角色'].frames['contentIframe']:获取弹出页面
							 * document.getElementById('testFrame'):将值放入在弹出页面建立的隐藏标签中,有在弹出页面中新建变量赋值,测试未成功。
							*/
		   					//window.parent.frames['新生管理'].frames['contentIframe'].document.getElementById('studentframe').value=sendValue;
						  	if (window.ActiveXObject){
								parent.window.frames['新生管理'].window.frames[0].document.getElementById('studentframe').value=sendValue;
							}else{
								//alert(sendValue);
								window.parent.frames['未分配'].frames['contentIframe'].document.getElementById('studentframe').value=sendValue;
							}
						  	//modify by liuchx 20130806 end
					  	/*	 var checkedNodeArray = [];
					  		 for(var i=0;i<checkedNodes.length;i++){
					  			 checkedNodeArray.push(checkedNodes[i].id);
						  	 }
						  	 var checkIds = checkedNodeArray.join(",");
	                         $("#checkIds").val(checkIds);*/
	                         return true;
						},
				 onComplete:function(){

				    //tolisturl = "${ctx}/system/student_list.do";
				    api.close();
				   // api.reload(W,tolisturl);
				 }
			  });
		}); 	
			
			/* $("#submitBtn").submitForm({ 
				formId:"studentForm",
				onComplete:function(){
				    window.location.href = tolisturl;
				}
			}); */
			if(document.all.box2.value==""){
		document.all.box2.value = "汉族";
		}
	        
	       
		});
		
		
		var TempArr=[];//存贮option

		function Init(){
		var SelectObj=document.studentForm.elements["chStudAdmway"];
		/*先将数据存入数组*/
		with(SelectObj)
		 for(i=0;i<length;i++)TempArr[i]=[options[i].text,options[i].value];
		}
		
		function SelectTip(flag){
		var TxtObj=document.studentForm.elements["txt"];
		var SelectObj=document.getElementById("chStudAdmway");
		var Arr=[];
		with(SelectObj){
		 var SelectHTML=innerHTML.match(/<[^>]*>/)[0];
		 for(i=0;i<TempArr.length;i++)
		 if(TempArr[i][0].indexOf(TxtObj.value)==0||flag)//若找到以txt的内容开头的，添option。若flag为true,对下拉框初始化
		 Arr[Arr.length]="<option value='"+TempArr[i][1]+"'>"+TempArr[i][0]+"</option>"
		 innerHTML=SelectHTML+Arr.join()+"</SELECT>"
		}
		}

	</script>
	
	
	 <script Language="Javascript">
var j = 0;
function SelectValue(obj)
{
	var input = obj.parentNode.nextSibling;
	//alert("document.all.box2.value:"+obj.options[obj.selectedIndex].text);
	document.all.box2.value = obj.options[obj.selectedIndex].text;
	
	document.getElementById("txtSection").value=obj.options[obj.selectedIndex].value;
	//alert(document.getElementById("txtSection").value);
}

function InputValue(obj)
{
	var n = 1;	
	var tmpObj;
	var src = document.all.chStudEthnic;
	var msg = document.all.msg;
	if(event.keyCode != 40 && event.keyCode != 38 && event.keyCode != 13){
		if(obj.value!=""){
			 msg.style.display="";
			 msg.innerHTML="";
			 if(msg.hasChildNodes()) 
			 { 
				msg.childNodes[0].parentNode.removeChild(msg.childNodes[0]); 
			 }
			 
			 for (var i=0;i<src.length;i++){
			   var selValue = document.createElement("div");
			   var selText = document.createElement("div");
			   selText.value = src(i).value;
			   selText.innerHTML = src(i).text;		  

			   if (src(i).text.toLowerCase().indexOf(obj.value.toLowerCase())==0){ 
					selText.setAttribute("id","selText"+n);
					selText.onmouseover=function (){   
					this.style.backgroundColor='#003399';   
					this.style.color ='#ffffff'; 
				   }
				   selText.onmouseout=function (){   
					this.style.backgroundColor='#ffffff'; 
					this.style.color ='#000000';
				   }
				   selText.onclick=function (){   
					document.all.box2.value = this.innerHTML;
					msg.style.display="none";
					document.getElementById("txtSection").value=this.value;
				   }
					msg.appendChild(selText);
					n++;
			   }
			 }
		}
		else {
			document.all.msg.style.display="none";
		}
	}
	else {
		//press down key
		if(event.keyCode==40){
			j++;
			for (var i=0; i<src.length; i++)
			{
				tmpObj = document.getElementById("selText"+i);
				if(tmpObj != null){
					tmpObj.style.backgroundColor='#ffffff'; 
					tmpObj.style.color ='#000000';
				}				
			}
			tmpObj = document.getElementById("selText"+j);
			if(tmpObj != null){
				tmpObj.style.backgroundColor='#003399';   
				tmpObj.style.color ='#ffffff'; 
			}else{
				j = 0;
			}			
		}
		//press up key
		if (event.keyCode==38){
			j--;
			for (var i=0; i<src.length; i++)
			{
				tmpObj = document.getElementById("selText"+i);
				if(tmpObj != null){
					tmpObj.style.backgroundColor='#ffffff'; 
					tmpObj.style.color ='#000000';
				}				
			}
			tmpObj = document.getElementById("selText"+j);
			if(tmpObj != null){
				tmpObj.style.backgroundColor='#003399';   
				tmpObj.style.color ='#ffffff'; 
			}else{
				j = 2;
			}		
		}
		//press enter key
		if (event.keyCode==13){
			tmpObj = document.getElementById("selText"+j);
			document.all.box2.value = tmpObj.innerHTML;
			msg.style.display="none";
			document.getElementById("txtSection").value=tmpObj.value;
		}
	}
}

function SelMatch(src)
{
    
	var currSel = document.all.box2.value;
	for (var i=0;i<src.length;i++){
		if (src(i).text==currSel)
		{
			src.options(i).selected = true;
		}		
	}
}

function doChange(objText, objDrop){
alert(objText.value);
      var str = document.getElementById("box2").value;
      for(var i = 0; i < objDrop.length; i++){
            if(objDrop(i).text == str){
            objDrop.options(i).selected = true;
            }
      }

}


function NoMsg()
{	
	if(document.activeElement.id=="msg") 
		return false; 
	else
		document.all.msg.style.display='none';
}

function selctEthinc() {
      
            var url = "${ctx}/student/student_ethnic.do";
            
            var value = window.showModalDialog(url,  "dialogwidth:200px;   dialogheight:200px;   center:yes;   Help:No;   Resizable:No;   Status:Yes;   Scroll:Yes;   Status:no;   resizable:no "); //弹出窗口，选择后跳转的界面
            var strs = new Array();
            if (value != null && value != "") {
            var ss=value;
            
            strs=value.split("&");
           
                window.document.getElementById("box2").value =  strs[0]; 
                 window.document.getElementById("chStudEthnic").value =  strs[1]; 
                
            }

        }
  </script>
  
</my:head>
<body onload="Init()">
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"> <my:i18n zhText="新生管理" enText="User Mgt"/> - 编辑</div>
	<%-- <div  class="pheadbutton">
	   <input type="button" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div> --%>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		  <form id="studentForm" name="studentForm" action="student/student_save.do" method="post">
		    <input type="hidden" name="id" id="id" value="${id }"/>
		    <table width="100%" class="ftable">
	                 
           <tr>
            <th width="12%"><my:i18n zhText="学号" />：</th>
            <td><input type="text" name="chStudSchcode" value="${student.chStudSchcode}" id="chStudSchcode" /></td>
            <th width="12%"><my:i18n zhText="学生类别" />：</th>
            <td><input type="text" name="chStudType" value="${student.chStudType}" id="chStudType"/></td>
            <th width="12%"><my:i18n zhText="出生地" />：</th>
            <td><input type="text" name="chStudBirthplace" value="${student.chStudBirthplace}" id="chStudBirthplace"/></td>
          </tr>
           <tr>
             <th width="12%"><my:i18n zhText="姓名" />：</th>
            <td><input type="text" name="chStudName" value="${student.chStudName}" id="chStudName" /></td>
            <th width="12%"><font color="red">*</font><my:i18n zhText="入学方式" />：</th>
            <td>
            <select name="chStudAdmway" id="chStudAdmway"  style="width:100px;">
					<option value="">请选择</option>
					<c:forEach items="${admwayList}" var="admwayList" varStatus="status">
						<c:choose>
							<c:when test="${chStudAdmway == admwayList.id}">
								<option value="${admwayList.id}" selected="selected">${admwayList.chAdwaName}</option>
							</c:when>
							<c:otherwise>
								<option value="${admwayList.id}">${admwayList.chAdwaName}</option>
							</c:otherwise>
						</c:choose>			
					</c:forEach>
		</select>
            </td>
            
             <th width="12%"><my:i18n zhText="国籍" />：</th>
            <td><input type="text" name="chStudNational" value="${student.chStudNational}" id="chStudNational"/></td>
          </tr>
        
           <tr>
             <th width="12%"><my:i18n zhText="英文名" />：</th>
            <td><input type="text" name="chStudEngname" value="${student.chStudEngname}" id="chStudEngname" /></td>
            <th width="12%"><my:i18n zhText="入学年月" />：</th>
            <td><input type="text" name="chStudEnrolldate" id= "chStudEnrolldate" value="${student.chStudEnrolldate}" class="Wdate" readonly="readonly" /></td>
            <th width="12%"><my:i18n zhText="籍贯" />：</th>
            <td><input type="text" name="chStudHometown" value="${student.chStudHometown}" id="chStudHometown"/></td>
          </tr>
          
          <tr>
             <th width="12%"><my:i18n zhText="曾用名" />：</th>
            <td><input type="text" name="chStudOldname" value="${student.chStudOldname}" id="chStudOldname"/></td>
            <th width="12%"><my:i18n zhText="来源地区" />：</th>
            <td><input type="text" name="chStudSourareas" value="${student.chStudSourareas}" id="chStudSourareas"/></td>
            <th width="12%"><my:i18n zhText="民族" />：</th>
            <td>
            <div style="position:relative;">   
<%-- <span style="margin-left:100px;width:18px;overflow:hidden;">  

            <select style="HEIGHT: 22px; WIDTH: 122px; margin-left:-99px;" name="chStudEthnic" id="chStudEthnic"  
            onchange="SelectValue(this)" >
					 
					<c:forEach items="${ethnicList}" var="ethnicList" varStatus="status">
												
						<c:choose>
										<c:when test="${chStudEthnic == ethnicList.id}">
											<option value="${ethnicList.id}" selected="selected">${ethnicList.chEthnName}</option>
										</c:when>
										<c:otherwise>
											<option value="${ethnicList.id}">${ethnicList.chEthnName}</option>
										</c:otherwise>
						</c:choose>			
								
							
						</c:forEach>
		    </select>
            </span> --%>
         <input name="box2" id="box2" style="width:100px;left:0px;" value="${student.chethnic.chEthnName}"/>
         <input id="selectEthinc" type="button" class="button orange" onclick="selctEthinc()" value="选择"/>
           <%--  <input name="box2" id="box2" style="width:100px;position:absolute;left:0px;" onkeyup="InputValue(this)"  onblur="NoMsg()" 
            onfocus="this.select();InputValue(this);" onchange="doChange(this,chStudEthnic)" value="${student.chethnic.chEthnName}"> 
          --%>
           
<div id="msg" style="border:1px  solid green;  font-size :14PX;white-space:nowrap;overflow:hidden;
width:100px;position:absolute;left:0px;top:20px;display:none"></div>
</div>

	<Input Type="Hidden" Name="chStudEthnic" id="chStudEthnic">
	
            </td>
             
          </tr>
            <tr>
             <th width="12%"><font color="red">*</font><my:i18n zhText="性别" />：</th>
            <td>
                <select type="select" name="chStudSex" id="chStudSex"> 
                      <option value="">
                                                                      请选择
                      </option>
                       <option value="0"
                           <c:if test="${student.chStudSex eq '0'}">selected="selected"</c:if>>   男
                       </option>
                       <option value="1"
                            <c:if test="${student.chStudSex eq '1'}">selected="selected"</c:if>>   女
                       </option>
               </select> 
            </td>
            <th width="12%"><my:i18n zhText="原学校" />：</th>
            <td><input type="text" name="chStudOldschool" value="${student.chStudOldschool}" id="chStudOldschool"/></td>
            <th width="12%"><my:i18n zhText="健康状况" />：</th>
            <td><input type="text" name="chStudHealth" value="${student.chStudHealth}" id="chStudHealth"/></td>
          </tr>
           <tr>
             <th width="12%"><my:i18n zhText="出生日期" />：</th>
            <td><input type="text" name="chStudBirth" id="chStudBirth" value="${student.chStudBirth}" class="Wdate" readonly="readonly" title="请选择出生时间"/></td>
            <th width="12%"><my:i18n zhText="年级" />：</th>
            <td><input type="text" name="chStudGrade" value="${student.chStudGrade}" id="chStudGrade"/></td>
            <th width="12%"><my:i18n zhText="血型" />：</th>
            <td>
            <select name="chStudBloodtype" id="chStudBloodtype"  style="width:100px;">
					<option value="">请选择</option>
					<c:forEach items="${bltpList}" var="bltpList" varStatus="status">
												
						<c:choose>
										<c:when test="${chStudBloodtype == bltpList.id}">
											<option value="${bltpList.id}" selected="selected">${bltpList.chBdtpName}</option>
										</c:when>
										<c:otherwise>
											<option value="${bltpList.id}">${bltpList.chBdtpName}</option>
										</c:otherwise>
						</c:choose>			
								
							
						</c:forEach>
		</select>
		</td>
           
          </tr>
           
          <tr>
             <th width="12%"><my:i18n zhText="身份证件类型" />：</th>
            <td><input type="text" name="chStudPersontype" value="${student.chStudPersontype}" id="chStudPersontype" /></td>
            <th width="12%"><my:i18n zhText="班号" />：</th>
            <td><input type="text" name="chClasId" value="${student.chClasId}" id="chClasId"/></td>
            <th width="12%"><my:i18n zhText="现住址" />：</th>
            <td><input type="text" name="chStudAddress" value="${student.chStudAddress}" id="chStudAddress"/></td>
          </tr>
         <tr>
             <th width="12%"><my:i18n zhText="身份证件号码" />：</th>
            <td><input type="text" name="chStudPersonid" value="${student.chStudPersonid}" id="chStudPersonid" /></td>
            <th width="12%"><font color="red">*</font><my:i18n zhText="入学成绩" />：</th>
            <td><input type="text" name="chStudScore" value="${student.chStudScore}" id="chStudScore"/></td>
            <th width="12%"><my:i18n zhText="户口性质" />：</th>
            <td><input type="text" name="chStudLocakind" value="${student.chStudLocakind}" id="chStudLocakind"/></td>
          </tr>
          <tr>
             <th width="12%"><my:i18n zhText="联系电话" />：</th>
            <td><input type="text" name="chStudPhone" value="${student.chStudPhone}" id="chStudPhone" /></td>
            <th width="12%"><my:i18n zhText="是否当过班干部" />：</th>
            <td><select type="select" name="chStudCadreflag" id="chStudCadreflag"> 
                      <option value="">
                                                                      请选择
                      </option>
                       <option value="0"  <c:if test="${student.chStudCadreflag eq '0'}">selected="selected"</c:if>>
                                                                          是
                       </option>
                       <option value="1"  <c:if test="${student.chStudCadreflag eq '1'}">selected="selected"</c:if>>
                                                                          否
                       </option>
               </select> 
            </td>
            <th width="12%"><my:i18n zhText="户口所在地" />：</th>
            <td><input type="text" name="chStudLocation" value="${student.chStudLocation}" id="chStudLocation"/></td>
          </tr>
           <tr>
             <th width="12%"><my:i18n zhText="通信地址" />：</th>
            <td><input type="text" name="chStudTranaddress" value="${student.chStudTranaddress}" id="chStudTranaddress" /></td>
            <th width="12%"><my:i18n zhText="特长" />：</th>
            <td><input type="text" name="chStudSpecial" value="${student.chStudSpecial}" id="chStudSpecial"/></td>
            <th width="12%"><my:i18n zhText="流动人口" />：</th>
            <td>
              <select type="select" name="chStudFlowperson" id="chStudFlowperson"> 
                      <option value="">
                                                                      请选择
                      </option>
                       <option value="0" <c:if test="${student.chStudFlowperson eq '0'}">selected="selected"</c:if>>
                                                                          是
                       </option>
                       <option value="1" <c:if test="${student.chStudFlowperson eq '1'}">selected="selected"</c:if>>
                                                                          否
                       </option>
               </select> 
              </td>
          </tr>
          
           <tr>
             <th width="12%"><my:i18n zhText="邮政编码" />：</th>
            <td><input type="text" name="chStudZip" value="${student.chStudZip}" id="chStudZip" /></td>
            <th width="12%"><my:i18n zhText="政治面貌" />：</th>
            <td>
            <select name="chStudPolface" id="chStudPolface"  style="width:100px;">
					<option value="">请选择</option>
					<c:forEach items="${plfaList}" var="plfaList" varStatus="status">
												
						<c:choose>
										<c:when test="${chStudPolface == plfaList.id}">
											<option value="${plfaList.id}" selected="selected">${plfaList.chPlfaName}</option>
										</c:when>
										<c:otherwise>
											<option value="${plfaList.id}">${plfaList.chPlfaName}</option>
										</c:otherwise>
						</c:choose>			
								
							
						</c:forEach>
		</select>
            
            
            
            
            
            </td>
            <th width="12%"><my:i18n zhText="港澳台侨外" />：</th>
            <td><input type="text" name="chStudForeign" value="${student.chStudForeign}" id="chStudForeign"/></td>
          </tr>
           <tr>
             <th width="12%"><my:i18n zhText="电子信箱" />：</th>
            <td><input type="text" name="chStudEmail" value="${student.chStudEmail}" id="chStudEmail" /></td>
            <th width="12%"><my:i18n zhText="独生子女" />：</th>
            <td><select type="select" name="chStudOnly" id="chStudOnly"> 
                      <option value="">
                                                                      请选择
                      </option>
                       <option value="0" <c:if test="${student.chStudOnly eq '0'}">selected="selected"</c:if>>
                                                                          是
                       </option>
                       <option value="1" <c:if test="${student.chStudOnly eq '1'}">selected="selected"</c:if>>
                                                                          否
                       </option>
               </select> 
          </td>
            <th width="12%"><my:i18n zhText="主页地址" />：</th>
            <td><input type="text" name="chStudWebsite" value="${student.chStudWebsite}" id="chStudWebsite"/></td>
          </tr>
           <tr>
             <th width="12%"><my:i18n zhText="备注" />：</th>
          <td colspan="5">  <input type="text" name="chStudMemo" value="${student.chStudMemo}" id="chStudMemo" style="width:80%" />
          </td>
          </tr>
           <tr>
			<td colspan="6" class="ftablebutton">
				<input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn" onclick="doChange(box2,chStudEthnic)"/> &nbsp; 
				<input type="button" onclick="cancel();" class="button orange"  class="button orange" value="<my:i18n zhText="取消" enText="Cancel"/>"/>
			</td>
	      </tr>
	      
        </table>
        </form>
	   
    </div>
</body>
