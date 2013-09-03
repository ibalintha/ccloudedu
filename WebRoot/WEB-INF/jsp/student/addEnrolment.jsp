<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
    <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
	var tolisturl = "${ctx}/student/enrolment_list.do";
	function reloadStudent(){
			location.href="${ctx}/student/enrolment_list.do";
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
		    var tolisturl = "${ctx}/student/enrolment_list.do?chClasId="+chClasId;
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;      
       $(function() {
			 $("#submitBtn").submitForm({ 
				 formId:"studentForm1",
				 onComplete:function(){
				    api.reload(W,tolisturl);
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
	<div class="pheadposition"> <my:i18n zhText="新生管理" enText="User Mgt"/> - 添加</div>
	<%-- <div  class="pheadbutton">
	   <input type="button" class="button orange" value="<my:i18n zhText="返回列表" enText="Return To List Page"/>" id="tolistButton"/>
	</div> --%>
	<div class="clear"></div>
</div>
	    <div id="result" align="center" style="color: red"></div>
		 <form id="studentForm1" name="studentForm1"

					action="{ctx }/student/enrolment_save.do" method="post">


					<input type="hidden" name="id" id="id" value="${id}" />

					<table width="100%" class="ftable">
                        <tr>
							<th width="12%"><my:i18n zhText="学籍号" />：</th>
							<td><input type="text" name="chScroSchroll"
								value="${enrollment.chScroSchroll}" id="chScroSchroll" /></td>
							<th width="12%"><my:i18n zhText="学籍状态" />：</th>
							<td><input type="text" name="chScroState"
								value="${enrollment.chScroState}" id="chScroState" /></td>
							<th width="12%"><my:i18n zhText="出生地" />：</th>
							<td><input type="text" name="chScroBirthplace"
								value="${enrollment.chScroBirthplace}" id="chScroBirthplace" /></td>
							<td rowspan="4" width="12%">照片</td>
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="学号" />：</th>
							<td><input type="text" name="chScroSchcode"
								value="${enrollment.chScroSchcode}" id="chScroSchcode" /></td>
							<th width="12%"><my:i18n zhText="学生类别" />：</th>
							<td><input type="text" name="chScroType"
								value="${enrollment.chScroType}" id="chScroType" /></td>
							<th width="12%"><my:i18n zhText="国籍" />：</th>
							<td><input type="text" name="chScroNational"
								value="${enrollment.chScroNational}" id="chScroNational" /></td>
						   
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="姓名" />：</th>
							<td><input type="text" name="chScroName"
								value="${enrollment.chScroName}" id="chScroName" /></td>
							<th width="12%"><font color="red">*</font> <my:i18n
									zhText="入学方式" />：</th>
							<td><select name="chScroAdmway" id="chScroAdmway"
								style="width:100px;">
									<option value="">请选择</option>
									<c:forEach items="${admwayList}" var="admwayList"
										varStatus="status">
										<c:choose>
											<c:when test="${chScroAdmway == admwayList.id}">
												<option value="${admwayList.id}" selected="selected">${admwayList.chAdwaName}</option>
											</c:when>
											<c:otherwise>
												<option value="${admwayList.id}">${admwayList.chAdwaName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
							</td>

							<th width="12%"><my:i18n zhText="籍贯" />：</th>
							<td><input type="text" name="chScroHometown"
								value="${enrollment.chScroHometown}" id="chScroHometown" /></td>
							
						</tr>

						<tr>
							<th width="12%"><my:i18n zhText="英文名" />：</th>
							<td><input type="text" name="chScroEngname"
								value="${enrollment.chScroEngname}" id="chScroEngname" /></td>
							<th width="12%"><my:i18n zhText="入学年月" />：</th>
							<td><input type="text" name="chScroEnrolldate"
								id="chScroEnrolldate" value="${enrollment.chScroEnrolldate}"
								class="Wdate" readonly="readonly" /></td>
							<th width="12%"><my:i18n zhText="健康状况" />：</th>
							<td><input type="text" name="chScroHealth"
								value="${enrollment.chScroHealth}" id="chScroHealth" /></td>
								
						</tr>

						<tr>
							<th width="12%"><my:i18n zhText="曾用名" />：</th>
							<td><input type="text" name="chScroOldname"
								value="${enrollment.chScroOldname}" id="chScroOldname" /></td>
							<th width="12%"><my:i18n zhText="来源地区" />：</th>
							<td><input type="text" name="chScroSourareas"
								value="${enrollment.chScroSourareas}" id="chScroSourareas" /></td>
							<th width="12%"><my:i18n zhText="照片" />：</th>
							<td colspan="2">
								
							</td>

						</tr>
						<tr>
							<th width="12%"><font color="red">*</font> <my:i18n
									zhText="性别" />：</th>
							<td><select type="select" name="chScroSex" id="chScroSex">
									<option value="">请选择</option>
									<option value="0"
										<c:if test="${enrollment.chScroSex eq '0'}">selected="selected"</c:if>>
										男</option>
									<option value="1"
										<c:if test="${enrollment.chScroSex eq '1'}">selected="selected"</c:if>>
										女</option>
							</select>
							</td>
							<th width="12%"><my:i18n zhText="原学校" />：</th>
							<td><input type="text" name="chScroOldschool"
								value="${enrollment.chScroOldschool}" id="chScroOldschool" /></td>
							<th width="12%"><my:i18n zhText="民族" />：</th>
									<td colspan="2">
								<div style="position:relative;">
									<span style="margin-left:100px;width:18px;overflow:hidden;">

										<select style="HEIGHT: 22px; WIDTH: 122px; margin-left:-99px;"
										name="chScroEthnic" id="chScroEthnic"
										onchange="SelectValue(this)">
											<option value="" Selected>请选择</option>
											<c:forEach items="${ethnicList}" var="ethnicList"
												varStatus="status">

												<c:choose>
													<c:when test="${chScroEthnic == ethnicList.id}">
														<option value="${chScroEthnic.id}" selected="selected">${ethnicList.chEthnName}</option>
													</c:when>
													<c:otherwise>
														<option value="${ethnicList.id}">${ethnicList.chEthnName}</option>
													</c:otherwise>
												</c:choose>


											</c:forEach>
									</select> </span> <input name="box2" id="box2"
										style="width:100px;position:absolute;left:0px;"
										onkeyup="InputValue(this)" onblur="NoMsg()"
										onfocus="this.select();InputValue(this);doChange(this,chScroEthnic)"
										onchange="doChange(this,chScroEthnic)"
										value="${enrollment.chScroEthnic}">
									<div id="msg"
										style="border:1px  solid green;  font-size :14PX;white-space:nowrap;overflow:hidden;
width:100px;position:absolute;left:0px;top:20px;display:none"></div>
								</div> <Input Type="Hidden" Name="txtSection" id="txtSection">
							</td>
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="出生日期" />：</th>
							<td><input type="text" name="chScroBirth" id="chScroBirth"
								value="${enrollment.chScroBirth}" class="Wdate" readonly="readonly"
								title="请选择出生时间" /></td>
							<th width="12%"><my:i18n zhText="年级" />：</th>
							<td><input type="text" name="chScroGrade"
								value="${enrollment.chScroGrade}" id="chScroGrade" /></td>
							<th width="12%"><my:i18n zhText="血型" />：</th>
							<td colspan="2"><select name="chScroBloodtype" id="chScroBloodtype"
								style="width:100px;">
									<option value="">请选择</option>
									<c:forEach items="${bltpList}" var="bltpList"
										varStatus="status">

										<c:choose>
											<c:when test="${chScroBloodtype == bltpList.id}">
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
							<td><input type="text" name="chScroPersontype"
								value="${enrollment.chScroPersontype}" id="chScroPersontype" /></td>
							<th width="12%"><my:i18n zhText="班号" />：</th>
							<td><input type="text" name="chClasId"
								value="${enrollment.chClasId}" id="chClasId" /></td>
							<th width="12%"><my:i18n zhText="现住址" />：</th>
							<td colspan="2"><input type="text" name="chScroAddress"
								value="${enrollment.chScroAddress}" id="chScroAddress" /></td>
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="身份证件号码" />：</th>
							<td><input type="text" name="chScroPersonid"
								value="${enrollment.chScroPersonid}" id="chScroPersonid" /></td>
							<th width="12%"><font color="red">*</font> <my:i18n
									zhText="入学成绩" />：</th>
							<td><input type="text" name="chScroScore"
								value="${enrollment.chScroScore}" id="chScroScore" /></td>
							<th width="12%"><my:i18n zhText="户口性质" />：</th>
							<td colspan="2"><input type="text" name="chScroLocakind"
								value="${enrollment.chScroLocakind}" id="chScroLocakind" /></td>
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="联系电话" />：</th>
							<td><input type="text" name="chScroPhone"
								value="${enrollment.chScroPhone}" id="chScroPhone" /></td>
							<th width="12%"><my:i18n zhText="是否当过班干部" />：</th>
							<td><select type="select" name="chScroCadreflag"
								id="chScroCadreflag">
									<option value="">请选择</option>
									<option value="0"
										<c:if test="${enrollment.chScroCadreflag eq '0'}">selected="selected"</c:if>>
										是</option>
									<option value="1"
										<c:if test="${enrollment.chScroCadreflag eq '1'}">selected="selected"</c:if>>
										否</option>
							</select>
							</td>
							<th width="12%"><my:i18n zhText="户口所在地" />：</th>
							<td colspan="2"><input type="text" name="chScroLocation"
								value="${enrollment.chScroLocation}" id="chScroLocation" /></td>
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="通信地址" />：</th>
							<td><input type="text" name="chScroTranaddress"
								value="${enrollment.chScroTranaddress}" id="chScroTranaddress" />
							</td>
							<th width="12%"><my:i18n zhText="特长" />：</th>
							<td><input type="text" name="chScroSpecial"
								value="${enrollment.chScroSpecial}" id="chScroSpecial" /></td>
							<th width="12%"><my:i18n zhText="流动人口" />：</th>
							<td colspan="2"><select type="select" name="chScroFlowperson"
								id="chScroFlowperson">
									<option value="">请选择</option>
									<option value="0"
										<c:if test="${enrollment.chScroFlowperson eq '0'}">selected="selected"</c:if>>
										是</option>
									<option value="1"
										<c:if test="${enrollment.chScroFlowperson eq '1'}">selected="selected"</c:if>>
										否</option>
							</select>
							</td>
						</tr>

						<tr>
							<th width="12%"><my:i18n zhText="邮政编码" />：</th>
							<td><input type="text" name="chScroZip"
								value="${enrollment.chScroZip}" id="chScroZip" /></td>
							<th width="12%"><my:i18n zhText="政治面貌" />：</th>
							<td><select name="chScroPolface" id="chScroPolface"
								style="width:100px;">
									<option value="">请选择</option>
									<c:forEach items="${plfaList}" var="plfaList"
										varStatus="status">

										<c:choose>
											<c:when test="${chScroPolface == plfaList.id}">
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
							<td colspan="2"><input type="text" name="chScroForeign"
								value="${enrollment.chScroForeign}" id="chScroForeign" /></td>
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="电子信箱" />：</th>
							<td><input type="text" name="chScroEmail"
								value="${enrollment.chScroEmail}" id="chScroEmail" /></td>
							<th width="12%"><my:i18n zhText="独生子女" />：</th>
							<td><select type="select" name="chScroOnly" id="chScroOnly">
									<option value="">请选择</option>
									<option value="0"
										<c:if test="${enrollment.chScroOnly eq '0'}">selected="selected"</c:if>>
										是</option>
									<option value="1"
										<c:if test="${enrollment.chScroOnly eq '1'}">selected="selected"</c:if>>
										否</option>
							</select>
							</td>
							<th width="12%"><my:i18n zhText="主页地址" />：</th>
							<td colspan="2"><input type="text" name="chScroWebsite"
								value="${enrollment.chScroWebsite}" id="chScroWebsite" /></td>
						</tr>
						<tr>
							<th width="12%"><my:i18n zhText="备注" />：</th>
							<td colspan="6"><input type="text" name="chScroMemo"
								value="${enrollment.chScroMemo}" id="chScroMemo" style="width:80%" />
							</td>
						</tr>
						<tr>
							<td colspan="7" class="ftablebutton"><input type="button"
								class="button orange" class="button orange"
								value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"
								 /> &nbsp; <input
								type="button" onclick="cancelupdate();" class="button orange"
								class="button orange"
								value="<my:i18n zhText="取消" enText="Cancel"/>" />
							</td>
						</tr>

					</table>
					
			
			</form>
	   
    </div>
</body>
