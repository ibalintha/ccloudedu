<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<my:head lhgdialog="true" tree3="true">
	<style type="text/css">
    	.ztree li a:hover {text-decoration:none;}
    </style>
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
   <script type="text/javascript" src="${ctx}/js_css_image/js/studentJS/enrollment.js"></script>
  <%--  <script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery-1.8.0.min.js"></script>
   <script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery-1.8.0.js"></script> --%>
   <script type="text/javascript">
		var list=true;
		var deleteAndRemoveTreeNode=true;
		var deleteurl = "${ctx }/student/enrolment_deleteIds.do";
/* 		$(function() {
			$("#importDept").click(function(){
				var url = '${ctx }/system/dept_toImportDept.do';
				$.dialog({id:'importDept',title:'导入部门',content: 'url:'+url,cancelVal: '关闭', cancel: true,width: '700px', height: 500});
			});
		}); */
		function reload(){
		    location.reload();
		}
  
        var addnewurl = "${ctx}/student/enrolment_addin.do";
		var deleteurl = "${ctx}/student/student_delete.do";
		//Pescadito 当表格中的行数大于十行时，需要使用滚动条
	    function getHeight() {
	    	var element =  document.getElementById("tableDiv");
	    	var table = document.getElementById("myTable");
	    	var rows = table.rows.length;
	    	if(rows > 10){
	    		element.style.height = 290 + "px";
	    		element.style.overflow = "auto";
	    	}else{
	    		element.style.height = "auto";
	    	}
	    	
	    };
	    window.onload = function() {
	    	getHeight();
	    	document.getElementById("familyInfoBtn").id ="current";	    	
	    };    
	    
		function modifyId(value){
			switch (value) {
			case 1:
				document.getElementById("current").id ="familyInfoBtn";
				
				break;
			case 2:
				document.getElementById("current").id ="resumeBtn";
				
				break;
			case 3:
				document.getElementById("current").id= "remarkBtn";
				
				break;
			case 4:
				document.getElementById("current").id="postBtn";
				
				break;
			case 5:
				document.getElementById("current").id="rewPunBtn";
				
				break;
			case 6:
				document.getElementById("current").id="worksBtn";
				
				break;
			case 7:
				document.getElementById("current").id="specialtyBtn";
				
				break;
			case 8:
				document.getElementById("current").id="practiceBtn";
				
				break;
			case 9:
				document.getElementById("current").id="homeVisBtn";
				
				break;
			case 10:
				document.getElementById("current").id="othersBtn";
				
				break;
			default:
				break;
			}
		}

		var currentPanel = 1;//该参数用来判断panel在第几个上
		$(function() {
		//页面下方的tab页的选择
		$("#familyInfoBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 1;
			document.getElementById("familyInfoBtn").id ="current";
			
			document.getElementById("familyInfoDiv").style.display ="block";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#resumeBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){				
				modifyId(va.value);
			}
			currentPanel = 2;
			document.getElementById("resumeBtn").id ="current";
		
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "block";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#remarkBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 3;
			document.getElementById("remarkBtn").id= "current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="block";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#postBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 4;
			document.getElementById("postBtn").id="current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="block";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#rewPunBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 5;
			document.getElementById("rewPunBtn").id="current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="block";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#worksBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 6;
			document.getElementById("worksBtn").id="current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="block";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#specialtyBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 7;
			document.getElementById("specialtyBtn").id="current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="block";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#practiceBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 8;
			document.getElementById("practiceBtn").id="current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="block";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#homeVisBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 9;
			document.getElementById("homeVisBtn").id="current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="block";
			document.getElementById("othersDiv").style.display="none";
		});
		$("#othersBtn").click(function(){
			var va =  document.getElementById("current");
			if(va != null){
				modifyId(va.value);
			}
			currentPanel = 10;
			document.getElementById("othersBtn").id="current";
			
			document.getElementById("familyInfoDiv").style.display ="none";
			document.getElementById("resumeDiv").style.display= "none";
			document.getElementById("remarkeDiv").style.display="none";
			document.getElementById("postDiv").style.display="none";
			document.getElementById("rwdPnsDiv").style.display="none";
			document.getElementById("worksDiv").style.display="none";
			document.getElementById("specialityDiv").style.display="none";
			document.getElementById("practiceDiv").style.display="none";
			document.getElementById("homeVisitDiv").style.display="none";
			document.getElementById("othersDiv").style.display="block";
			
		});
		
		function getHight2(){
			
	    	var element1 =  document.getElementById("familyInfoDiv");
	    	var table1 = document.getElementById("familyTable");
	    	var rows1 = table1.rows.length;
	    	if(rows1 > 10){
	    		element1.style.height = 285 + "px";
	    		element1.style.overflow = "auto";
	    	}else{
	    		element1.style.height = "auto";
	    	}
	    	
	    	var element2 =  document.getElementById("resumeDiv");
	    	var table2 = document.getElementById("resumeT");
	    	var rows2 = table2.rows.length;
	    	if(rows2 > 10){
	    		element2.style.height = 285 + "px";
	    		element2.style.overflow = "auto";
	    	}else{
	    		element2.style.height = "auto";
	    	}
	    	
	    	var element3 =  document.getElementById("remarkeDiv");
	    	var table3 = document.getElementById("remarkeT");
	    	var rows3 = table3.rows.length;
	    	if(rows3 > 10){
	    		element3.style.height = 285 + "px";
	    		element3.style.overflow = "auto";
	    	}else{
	    		element3.style.height = "auto";
	    	}
	    	
	    	var element4 =  document.getElementById("postDiv");
	    	var table4 = document.getElementById("postT");
	    	var rows4 = table4.rows.length;
	    	if(rows4 > 10){
	    		element4.style.height = 285 + "px";
	    		element4.style.overflow = "auto";
	    	}else{
	    		element4.style.height = "auto";
	    	}
	    	
	    	var element5 =  document.getElementById("rwdPnsDiv");
	    	var table5 = document.getElementById("rwdPnsT");
	    	var rows5 = table5.rows.length;
	    	if(rows5 > 10){
	    		element5.style.height = 285 + "px";
	    		element5.style.overflow = "auto";
	    	}else{
	    		element5.style.height = "auto";
	    	}
	    	
	    	var element6 =  document.getElementById("worksDiv");
	    	var table6 = document.getElementById("worksT");
	    	var rows6 = table6.rows.length;
	    	if(rows6 > 10){
	    		element6.style.height = 285 + "px";
	    		element6.style.overflow = "auto";
	    	}else{
	    		element6.style.height = "auto";
	    	}
	    	
	    	var element7 =  document.getElementById("specialityDiv");
	    	var table7 = document.getElementById("specialityT");
	    	var rows7 = table7.rows.length;
	    	if(rows7 > 10){
	    		element7.style.height = 285 + "px";
	    		element7.style.overflow = "auto";
	    	}else{
	    		element7.style.height = "auto";
	    	}
	    	
	    	var element8 =  document.getElementById("practiceDiv");
	    	var table8 = document.getElementById("practiceT");
	    	var rows8 = table8.rows.length;
	    	if(rows8 > 10){
	    		element8.style.height = 285 + "px";
	    		element8.style.overflow = "auto";
	    	}else{
	    		element8.style.height = "auto";
	    	}
	    	
	    	var element9 =  document.getElementById("homeVisitDiv");
	    	var table9 = document.getElementById("homeVisitT");
	    	var rows9 = table9.rows.length;
	    	if(rows9 > 10){
	    		element9.style.height = 285 + "px";
	    		element9.style.overflow = "auto";
	    	}else{
	    		element9.style.height = "auto";
	    	}
	    	
	    	var element10 =  document.getElementById("othersDiv");
	    	var table10 = document.getElementById("othersT");
	    	var rows10 = table10.rows.length;
	    	if(rows10 > 10){
	    		element10.style.height = 285 + "px";
	    		element10.style.overflow = "auto";
	    	}else{
	    		element10.style.height = "auto";
	    	}
		
		};

		//学籍信息中某一行单击事件
		var scroId = null;
		var strId = null;
		$(".myltable tr td").bind("click",function(){
			//$(this).find("input[name='ids']").attr("checked","checked");
			var id =  $(this).parent('tr').attr('id');
			var schoolRollNum = $(this).parent('tr').find("td").eq(2).text();//取得某一行当中某一列的值
			var str = schoolRollNum.toString();
			strId = id + "";
			scroId = id;//将学籍ID保存到全局变量中
			//根据取得的学籍好，查询用户的“家庭信息”、“简历”等十项信息
			//这里可能需要使用ajax来传递信息
			var url = '${ctx }/student/enrolment_details.do';
			var schoolRollNum = "{\"schoolRollNum\":"+schoolRollNum+"}";
			var requestJson = "{schoolRollNum:"+schoolRollNum +"}";
			$.ajax({
				url: "enrolment_details.do",
				type: 'post',
				//dataType:'json',
				data: {"id":strId},				
				success: success,//function(data){ alert(data); }
				error: error
		    });
		}); 
		//此处查询到的学生的家庭信息等要做成全局变量，方便修改的时候调用
		var chFamilyJsonList = null;//家庭信息
		var chResumeJsonList = null;//简历信息
		var chCommentJsonList = null;//评论信息
		var chPositionJsonList = null;//职位信息
		var chRewardJsonList = null;//奖惩信息
		var chWorksJsonList = null;//作品信息
		var chSpecialJsonList = null;//特长信息
		var chPracticeJsonList = null;//实践信息
		var chHomeVisiteJsonList = null;//家访信息
		var chOtherInfoJsonList = null;//其他信息
		function success(data){//解析根据取得的学籍号，查询用户的“家庭信息”、“简历”等十项信息
			var obj = parseJson(data);
			chFamilyJsonList = obj.chFamilyJsonList;
			chResumeJsonList = obj.chResumeJsonList;
			chCommentJsonList = obj.chCommentJsonList;
			chPositionJsonList = obj.chPositionJsonList;
			chRewardJsonList = obj.chRewardJsonList;
			chWorksJsonList = obj.chWorksJsonList;
			chSpecialJsonList = obj.chSpecialJsonList;
			chPracticeJsonList = obj.chPracticeJsonList;
			chHomeVisiteJsonList = obj.chHomeVisiteJsonList;
			chOtherInfoJsonList = obj.chOtherInfoJsonList;
			addFamilyInfo(chFamilyJsonList);
			addResume(chResumeJsonList);
			addComment(chCommentJsonList);
			addPosition(chPositionJsonList);
			addReward(chRewardJsonList);
			addWorks(chWorksJsonList);
			addSpecial(chSpecialJsonList);
			addPractice(chPracticeJsonList);
			addHomeVisite(chHomeVisiteJsonList);
			addOtherInfo(chOtherInfoJsonList);
			getHight2();
		};
		
		//添加家庭信息  
		function addFamilyInfo(chFamilyJsonList){ 
			       //清除表格
			    if(chFamilyJsonList.length === 0){
			    	clearTable("familyTable");
			    	$("#familyInfoTableBody").append(
			    		"<tr><td align='center' colspan='9'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("familyTable");
			    }			 				 	 
			    for(var i=0;i<chFamilyJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chFamilyJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chFamilyJsonList[i].chScroSchroll;
			    var chFamiNickname  =  chFamilyJsonList[i].chFamiNickname;
			    var chFamiName =  chFamilyJsonList[i].chFamiName; 
			    var chFamiWorkcompany  =  chFamilyJsonList[i].chFamiWorkcompany;
			    var chFamiPolface = chFamilyJsonList[i].chFamiPolface;
			    var chFamiPostion = chFamilyJsonList[i].chFamiPostion;  
			    var chFamiPhone = chFamilyJsonList[i].chFamiPhone;  
			        
			    $("#familyInfoTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4.5%'><input type='checkbox' name='familyInfoIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4.5%'>"+(i+1)+"</td>"
											+"<td width='13%'>"+ chScroSchroll +"</td>"
											+"<td width='13%'>" + chFamiName + "</td>"
											+"<td width='13%'>"+ chFamiNickname +"</td>"
											+"<td width='13%'>"+ chFamiWorkcompany+"</td>"
											+"<td width='13%'>"+ chFamiPolface+"</td>"
											+"<td width='13%'>"+ chFamiPostion+"</td>"
											+"<td width='13%'>"+ chFamiPhone+"</td>"																																							
									+"</tr>");                
			   }   
		};

		//添加简历信息  
		function addResume(chResumeJsonList){ 
			       //清除表格
			    if(chResumeJsonList.length === 0){
			    	clearTable("resumeT");
			    	$("#resumeTableBody").append(
			    		"<tr><td align='center' colspan='9'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("resumeT");
			    }			 				 	 
			    for(var i=0;i<chResumeJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chResumeJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chResumeJsonList[i].chScroSchroll;			    
			    var chScroName  =  chResumeJsonList[i].chScroName;
			    var chResumeSchool =  chResumeJsonList[i].chFamiName; 
			    var chResumeTime  =  chResumeJsonList[i].chFamiWorkcompany;
			    var chResumeBeginTime = chResumeJsonList[i].chFamiPolface;
			    var chResumeEndTime = chResumeJsonList[i].chFamiPostion;  
			    var chResumeCertifier = chResumeJsonList[i].chFamiPhone;  
			        
			    $("#resumeTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4.5%'><input type='checkbox' name='resumeIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4.5%'>"+(i+1)+"</td>"
											+"<td width='13%'>"+ chScroSchroll +"</td>"
											+"<td width='13%'>" + chScroName + "</td>"
											+"<td width='13%'>"+ chResumeSchool+"</td>"
											+"<td width='13%'>"+ chResumeTime+"</td>"
											+"<td width='13%'>"+ chResumeBeginTime+"</td>"
											+"<td width='13%'>"+ chResumeEndTime+"</td>"
											+"<td width='13%'>"+ chResumeCertifier+"</td>"																																							
									+"</tr>");                
			   }   
		};

		//添加评语信息  
		function addComment(chCommentJsonList){ 
			       //清除表格
			    if(chCommentJsonList.length === 0){
			    	clearTable("remarkeT");
			    	$("#remarkeTableBody").append(
			    		"<tr><td align='center' colspan='9'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("remarkeT");
			    }		 				 	 
			    for(var i=0;i<chCommentJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chCommentJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chCommentJsonList[i].chScroSchroll;			    
			    var chScroName  =  chCommentJsonList[i].chScroName;
			    
			    var chCommentTime =  chCommentJsonList[i].chCommentTime; 
			    var chCommentSemester  =  chCommentJsonList[i].chCommentSemester;
			    var chCommentTeacher = chCommentJsonList[i].chCommentTeacher;
			    var chCommentContent = chCommentJsonList[i].chCommentContent;  
			    var chCommentLevel = chCommentJsonList[i].chCommentLevel;  
			        
			    $("#remarkeTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4.5%'><input type='checkbox' name='remarkeIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4.5%'>"+(i+1)+"</td>"
											+"<td width='13%'>"+ chScroSchroll +"</td>"
											+"<td width='13%'>" + chScroName + "</td>"
											+"<td width='13%'>"+ chCommentTime+"</td>"
											+"<td width='13%'>"+ chCommentSemester+"</td>"
											+"<td width='13%'>"+ chCommentTeacher+"</td>"
											+"<td width='13%'>"+ chCommentContent+"</td>"
											+"<td width='13%'>"+ chCommentLevel+"</td>"																																							
									+"</tr>");                
			   }   
		};
		
		//添加职务信息  
		function addPosition(chPositionJsonList){ 
			       //清除表格
			    if(chPositionJsonList.length === 0){
			    	clearTable("postT");
			    	$("#postTableBody").append(
			    		"<tr><td align='center' colspan='11'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("postT");
			    }			 				 	 
			    for(var i=0;i<chPositionJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chPositionJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chPositionJsonList[i].chScroSchroll;			    
			    var chScroName  =  chPositionJsonList[i].chScroName;			    
			    var chPisitionTime =  chPositionJsonList[i].chPisitionTime; 
			    var chPositionClass  =  chPositionJsonList[i].chPositionClass;
			    var chPositionSemester = chPositionJsonList[i].chPositionSemester;
			    var chPositionJob = chPositionJsonList[i].chPositionJob;  
			    var chPositionPolface = chPositionJsonList[i].chPositionPolface; 
			    var chPositionMaketime = chPositionJsonList[i].chPositionMaketime;  
			    var chPositionAgent = chPositionJsonList[i].chPositionAgent; 
			        
			    $("#postTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4%'><input type='checkbox' name='postIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4%'>"+(i+1)+"</td>"
											+"<td width='12%'>"+ chScroSchroll +"</td>"
											+"<td width='10%'>" + chScroName + "</td>"											
											+"<td width='10%'>"+ chPisitionTime+"</td>"
											+"<td width='10%'>"+ chPositionClass+"</td>"
											+"<td width='10%'>"+ chPositionSemester+"</td>"
											+"<td width='10%'>"+ chPositionJob+"</td>"
											+"<td width='10%'>"+ chPositionPolface+"</td>"	
											+"<td width='10%'>"+ chPositionMaketime+"</td>"
											+"<td width='10%'>"+ chPositionAgent+"</td>"																																							
									+"</tr>");                
			   }   
		};
		
		//添加奖惩信息  
		function addReward(chRewardJsonList){ 
			       //清除表格
			    if(chRewardJsonList.length === 0){
			    	clearTable("rwdPnsT");
			    	$("#rwdPnsTBody").append(
			    		"<tr><td align='center' colspan='12'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    	
			    }else{
			    	clearTable("rwdPnsT");
			    }			 				 	 
			    for(var i=0;i<chRewardJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chRewardJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chRewardJsonList[i].chScroSchroll;//学籍号			    
			    var chScroName  =  chRewardJsonList[i].chScroName;//姓名
			    var chScroSchcode =  chRewardJsonList[i].chScroSchcode;//学号
				var chRewardTimespan =  chRewardJsonList[i].chRewardTimespan;//奖惩时间 
			    var chRewardSemester  =  chRewardJsonList[i].chRewardSemester;//奖惩学期
			    var chRewardPunishment = chRewardJsonList[i].chRewardPunishment;//奖或惩				
				var chRewardOffice = chRewardJsonList[i].chRewardOffice;//发证机关
				var chRewardName = chRewardJsonList[i].chRewardName;//奖励名称
				var chRewardCertificate = chRewardJsonList[i].chRewardCertificate;//证书
				var chRewardTime = chRewardJsonList[i].chRewardTime;//奖惩时间
				var chRewardLevel = chRewardJsonList[i].chRewardLevel;//等第名次
				var chRewardReason = chRewardJsonList[i].chRewardReason;//奖惩原因
			    var chRewardInfo = chRewardJsonList[i].chRewardInfo;//奖惩信息 
			    var chRewardWay = chRewardJsonList[i].chRewardWay;//处理方式
			    var chRewardMemo = chRewardJsonList[i].chRewardMemo;//备注
			    if(chRewardPunishment === '奖'){
			    		$("#rwdPnsTBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4.5%'><input type='checkbox' name='rwdPnsIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4.5%'>"+(i+1)+"</td>"
											+"<td width='9%'>"+ chScroSchroll +"</td>"
											+"<td width='9%'>" + chScroName + "</td>"	
											+"<td width='9%'>" + chScroSchcode + "</td>"										
											+"<td width='9%'>"+ chRewardTimespan+"</td>"
											+"<td width='9%'>"+ chRewardSemester+"</td>"
											+"<td width='9%'>"+ chRewardPunishment+"</td>"
											
											+"<td width='9%'>"+''+"</td>"
											+"<td width='9%'>"+ chRewardTime+"</td>"	
											+"<td width='9%'>"+ chRewardReason+"</td>"
											+"<td width='9%'>"+ chRewardInfo+"</td>"																																							
									+"</tr>"); 
			    }else{
			    		$("#rwdPnsTBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4.5%'><input type='checkbox' name='rwdPnsIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4.5%'>"+(i+1)+"</td>"
											+"<td width='9%'>"+ chScroSchroll +"</td>"
											+"<td width='9%'>" + chScroName + "</td>"	
											+"<td width='9%'>" + chScroSchcode + "</td>"										
											+"<td width='9%'>"+ chRewardTimespan+"</td>"
											+"<td width='9%'>"+ chRewardSemester+"</td>"
											+"<td width='9%'>"+ chRewardPunishment+"</td>"
											+"<td width='9%'>"+ chRewardWay+"</td>"
											+"<td width='9%'>"+ chRewardTime+"</td>"	
											+"<td width='9%'>"+ chRewardReason+"</td>"
											+"<td width='9%'>"+ chRewardInfo+"</td>"																																							
									+"</tr>");     
			    }
			    
			        
 
		};		}
		//添加作品信息  
		function addWorks(chWorksJsonList){ 
			       //清除表格
			    if(chWorksJsonList.length === 0){
			    	clearTable("worksT");
			    	$("#worksTableBody").append(
			    		"<tr><td align='center' colspan='9'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("worksT");
			    }		 				 	 
			    for(var i=0;i<chWorksJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chWorksJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chWorksJsonList[i].chScroSchroll;			    
			    var chScroName  =  chWorksJsonList[i].chScroName;
			    		    			    
			    var chWorksTime =  chWorksJsonList[i].chWorksTime; 
			    var chWorksSemester  =  chWorksJsonList[i].chWorksSemester;
			    var chWorksName = chWorksJsonList[i].chWorksName;
			    var chWorksDealTime = chWorksJsonList[i].chWorksDealTime;  
			    var chWorksContent = chWorksJsonList[i].chWorksContent;
			        
			    $("#worksTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4.5%'><input type='checkbox' name='worksIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4.5%'>"+(i+1)+"</td>"
											+"<td width='13%'>"+ chScroSchroll +"</td>"
											+"<td width='13%'>" + chScroName + "</td>"											
											+"<td width='13%'>"+ chWorksTime+"</td>"
											+"<td width='13%'>"+ chWorksSemester+"</td>"
											+"<td width='13%'>"+ chWorksName+"</td>"
											+"<td width='13%'>"+ chWorksDealTime+"</td>"
											+"<td width='13%'>"+ chWorksContent+"</td>"																																						
									+"</tr>");                
			   }   
		};	
		
		//添加特长信息  
		function addSpecial(chSpecialJsonList){ 
			       //清除表格
			    if(chSpecialJsonList.length === 0){
			    	clearTable("specialityT");
			    	$("#specialTableBody").append(
			    		"<tr><td align='center' colspan='10'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("specialityT");
			    }			 				 	 
			    for(var i=0;i<chSpecialJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chSpecialJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chSpecialJsonList[i].chScroSchroll;			    
			    var chScroName  =  chSpecialJsonList[i].chScroName;
			    var chScroSchcode = chSpecialJsonList[i].chScroSchcode;		    			    
			    var chSpecialTimespan =  chSpecialJsonList[i].chSpecialTimespan; 
			    var chSpecialSemester  =  chSpecialJsonList[i].chSpecialSemester;
			    var chSpecialTime = chSpecialJsonList[i].chSpecialTime;
			    var chSpecialReason = chSpecialJsonList[i].chSpecialReason;  
			    var chSpecialComment = chSpecialJsonList[i].chSpecialComment;
			        
			    $("#specialTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='5%'><input type='checkbox' name='specialityIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='5%'>"+(i+1)+"</td>"
											+"<td width='12%'>"+ chScroSchroll +"</td>"
											+"<td width='12%'>" + chScroName + "</td>"
											+"<td width='12%'>" + chScroSchcode + "</td>"											
											+"<td width='11%'>"+ chSpecialTimespan+"</td>"
											+"<td width='11%'>"+ chSpecialSemester+"</td>"
											+"<td width='11%'>"+ chSpecialTime+"</td>"
											+"<td width='11%'>"+ chSpecialReason+"</td>"
											+"<td width='11%'>"+ chSpecialComment+"</td>"																																						
									+"</tr>");                
			   }   
		};
		
		//添加实践信息  
		function addPractice(chPracticeJsonList){ 
			       //清除表格
			    if(chPracticeJsonList.length === 0){
			    	clearTable("practiceT");
			    	$("#practiceTableBody").append(
			    		"<tr><td align='center' colspan='9'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("practiceT");
			    }		 				 	 
			    for(var i=0;i<chPracticeJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chPracticeJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chPracticeJsonList[i].chScroSchroll;			    
			    var chScroName  =  chPracticeJsonList[i].chScroName;		    			    
			    var chPracticeTimespan =  chPracticeJsonList[i].chPracticeTimespan; 
			    var chPracticeSemester  =  chPracticeJsonList[i].chPracticeSemester;
			    var chPracticeTime = chPracticeJsonList[i].chPracticeTime;
			    var chPracticePlace = chPracticeJsonList[i].chPracticePlace;  
			    var chPracticeContent = chPracticeJsonList[i].chPracticeContent;
			        
			    $("#practiceTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='5%'><input type='checkbox' name='practiceIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='5%'>"+(i+1)+"</td>"
											+"<td width='12%'>"+ chScroSchroll +"</td>"
											+"<td width='12%'>" + chScroName + "</td>"												
											+"<td width='11%'>"+ chPracticeTimespan+"</td>"
											+"<td width='11%'>"+ chPracticeSemester+"</td>"
											+"<td width='11%'>"+ chPracticeTime+"</td>"
											+"<td width='11%'>"+ chPracticePlace+"</td>"
											+"<td width='11%'>"+ chPracticeContent+"</td>"																																						
									+"</tr>");                
			   }   
		};	
		
		//添加家访信息  
		function addHomeVisite(chHomeVisiteJsonList){ 
			       //清除表格
			    if(chHomeVisiteJsonList.length === 0){
			    	clearTable("homeVisitT");
			    	$("#homevisiteTableBody").append(
			    		"<tr><td align='center' colspan='8'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("homeVisitT");
			    }			 				 	 
			    for(var i=0;i<chHomeVisiteJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chHomeVisiteJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chHomeVisiteJsonList[i].chScroSchroll;			    
			    var chScroName  =  chHomeVisiteJsonList[i].chScroName;		    			    
			    var chHomeVisiteTimespan =  chHomeVisiteJsonList[i].chHomeVisiteTimespan; 
			    var chHomeVisiteSemester  =  chHomeVisiteJsonList[i].chHomeVisiteSemester;
			    var chHomeVisiteTime = chHomeVisiteJsonList[i].chHomeVisiteTime;
			    var chHomeVisiteReason = chHomeVisiteJsonList[i].chHomeVisiteReason;
			        
			    $("#homevisiteTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='5%'><input type='checkbox' name='homeVisitIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='5%'>"+(i+1)+"</td>"
											+"<td width='15%'>"+ chScroSchroll +"</td>"
											+"<td width='15%'>" + chScroName + "</td>"												
											+"<td width='15%'>"+ chHomeVisiteTimespan+"</td>"
											+"<td width='15%'>"+ chHomeVisiteSemester+"</td>"
											+"<td width='15%'>"+ chHomeVisiteTime+"</td>"
											+"<td width='15%'>"+ chHomeVisiteReason+"</td>"																																					
									+"</tr>");                
			   }   
		};	
		
		//添加其他信息  
		function addOtherInfo(chOtherInfoJsonList){ 
			       //清除表格
			    if(chOtherInfoJsonList.length === 0){
			    	clearTable("othersT");
			    	$("#othersTableBody").append(
			    		"<tr><td align='center' colspan='11'><font color='red'><my:i18n zhText='没有找到相关信息' enText='No Student List'/></font></td></tr>"
			    	);
			    }else{
			    	clearTable("othersT");
			    }			 				 	 
			    for(var i=0;i<chOtherInfoJsonList.length;i++){           
			    var id = i+1; //得一个序号
			    var realId  =  chOtherInfoJsonList[i].id;//取结点里的数据 
			    var chScroSchroll = chOtherInfoJsonList[i].chScroSchroll;			    
			    var chScroName  =  chOtherInfoJsonList[i].chScroName;		    			    
			    var chOtherInfoTimespan =  chOtherInfoJsonList[i].chOtherInfoTimespan; 
			    var chOtherInfoSemester  =  chOtherInfoJsonList[i].chOtherInfoSemester;
			    var chOtherInfoCarNum = chOtherInfoJsonList[i].chOtherInfoCarNum;
			    var chOtherInfoExtend = chOtherInfoJsonList[i].chOtherInfoExtend;			       
			    var chOtherInfoImprove  =  chOtherInfoJsonList[i].chOtherInfoImprove;
			    var chOtherInfoSport = chOtherInfoJsonList[i].chOtherInfoSport;
			    var chOtherInfoArtSchool = chOtherInfoJsonList[i].chOtherInfoArtSchool; 
			    $("#othersTableBody").append("<tr id="+ realId +">"									
											+"<td align='center' width='4.5%'><input type='checkbox' name='othersIds' value='"+ realId +"'/></td>"
											+"<td align='center' width='4.5%'>"+(i+1)+"</td>"
											+"<td width='10%'>"+ chScroSchroll +"</td>"
											+"<td width='10%'>" + chScroName + "</td>"												
											+"<td width='10%'>"+ chOtherInfoTimespan+"</td>"
											+"<td width='10%'>"+ chOtherInfoSemester+"</td>"
											+"<td width='10%'>"+ chOtherInfoCarNum+"</td>"
											+"<td width='10%'>"+ chOtherInfoExtend+"</td>"
											+"<td width='10%'>"+ chOtherInfoImprove+"</td>"	
											+"<td width='10%'>"+ chOtherInfoSport+"</td>"
											+"<td width='10%'>"+ chOtherInfoArtSchool+"</td>"																																			
									+"</tr>");                
			   }   
		};	          
          //清除表格内容
         function clearTable(id){
             var table=document.getElementById(id);
             for(var i=table.rows.length-1;i>0;i--)
             {
                 table.deleteRow(i);
             }
         };
         
         //页面下部新增按钮的单击事件
         $("#addBtn").click(function(){
         	//先判断是那个选项卡被选中
         	switch (currentPanel) {
			case 1://选中家庭信息
				if(scroId == null){
					alert("请先选择您要新增的学生");
				}else{
					var url="${ctx}/student/enrolment_addFamily.do?id="+scroId;
					openDilog(url,"dialogFamily","新增","Add Family","700px","400px");
				}
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;																																				
			default:
			
				break;
			}
         	
         });
         //该方法在dialog关闭以后调用，用来调用我的Ajax方法，刷新下面的表数据
         function myAjax(){
         	$.ajax({
				url: "enrolment_details.do",
				type: 'post',
				//dataType:'json',
				data: {"id":strId},				
				success: success,
				error: error
		    });
         }
		//加载弹出框的方法
		function openDilog(url,dialogId,btnNameCn,btNameEn,widths,height){

				$.dialog({
					id : dialogId,
					title : btnNameCn,
					content : 'url:' + url,
					cancelVal : '关闭',
					cancel : true,
					width : widths,
					height : height,
					close:myAjax//关闭时需要执行该方法
				});			
		}
		function openDilog2(url,dialogId,btnNameCn,btNameEn,widths,height){
			//var url="${ctx}/student/enrolment_queryEnrolment.do";	
					
				$.dialog({
					id : dialogId,
					title : btnNameCn,
					content : 'url:' + url,
					cancelVal : '关闭',
					cancel : true,
					width : widths,
					height : height,
					//close:function(){window.location.href="${ctx}/student/enrolment_list.do"}
				});			
		}
		
		 //页面下部删除按钮的单击事件
         $("#dropBtn").click(function(){
         	//先判断是那个选项卡被选中
         	switch (currentPanel) {
			case 1://选中家庭信息
				if(scroId == null){
					alert("请先选择您要新增的学生");
				}else{
					deleteInfos("familyInfoIds");
					
				}
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;																																				
			default:
			
				break;
			}
         	
         });
         //该函数用来进行消息删除时检查checkBox是否选中并提交删除
         function deleteInfos(checkBoxId){
         		var ids = "input[name='"+checkBoxId+"']"
         		var checked = false;
				var param = "";
				$(ids).each(function() {
					if ($(this).attr("checked") == "checked"){
						checked = true;
					}	
				});				
				if (!checked) {
					alert("请先选择学生");
					return false;
				}
				$(ids).each(function() {
					if ($(this).attr("checked") == "checked")						
						param+=$(this).val()+",";	
						
				});
	         	$.ajax({
					url: "addfamily_deleteIds.do",
					type: 'post',
					//dataType:'json',
					data: {"ids":param},				
					success: function(data){
								data === "success";
								alert("删除成功");
								myAjax();
								},
					error: function(data){ alert("删除失败")}
			    }); 
         
         }
         
         //页面下部修改按钮的单击事件
         $("#modifyBtn").click(function(){
         	//先判断是那个选项卡被选中
         	switch (currentPanel) {
			case 1://选中家庭信息
				if(scroId == null){
					alert("请先选择您要编辑的学生");
				}else{
					var familyId = editInfos("familyInfoIds");
					var url="${ctx}/student/addfamily_findOneId.do?familyId="+familyId;
					if(familyId != false){
						openDilog(url,"dialogFamily","编辑","Edit Family","700px","400px");
					}					
				}
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;																																				
			default:
			
				break;
			}
         	
         });
         //摄像按钮的单击事件
         $("#cameraBtn").click(function(){
         	//先检查复选框
         	//editInfos("ids");
         	//启动camera页面dialog
         	var schollRollId = editInfos("ids");
			var url="${ctx}/student/camera_openDialog.do?id="+schollRollId;
			if(schollRollId != false){
				openDilog2(url,"dialogCamera","摄像","Camera","1130px","540px");
			}
         	
         });
         //该函数用来进行消息删除时检查checkBox是否选中并提交删除
         function editInfos(checkBoxId){
         		var ids = "input[name='"+checkBoxId+"']"
         		var checked = false;
				var param = "";
				var selects = 0;
				$(ids).each(function() {
					if ($(this).attr("checked") == "checked"){
						checked = true;
						selects++;
					}	
				});				
				if (!checked) {
					alert("请先选择学生");
					return false;
				}
				if(selects > 1){
					alert("一次只能编辑一条记录");
					return false;
				}
				$(ids).each(function() {
					if ($(this).attr("checked") == "checked")						
						param = $(this).val();	
						
				});
         		return  param;
         }
/* 		$(function() {
			if($("#dialogFamily").dialog("isOpen")){
				alert("打开状态");
			}else{
				alert("关闭状态");
			}		
		}); */

		
		
		//自动分班
			$("#autoStudents").click(function(){
				var checked = false;
				var param = "";
				$("input[name='ids']").each(function() {
					if ($(this).attr("checked") == "checked")				
					checked = true;
			});
		
		if (!checked) {
			alert("请先选择学生");
			return false;
		}
		$("input[name='ids']").each(function() {
			if ($(this).attr("checked") == "checked")
				param+=$(this).val()+",";	
				
		});
		//alert(param);
				var url = '${ctx }/student/student_autoStudents.do?id='+param+'';
				$.dialog({id:'autoStudents',title:'<my:i18n zhText="自动分班" enText="Auto Students"/>',content: 'url:'+url,cancelVal: '关闭',cancel: true,width: '500px',height: 300});
			});
			
			/* 重新分班 */
			$("#redivideClassesBtn").click(function(){
			var checked = false;
		var param = "";
		$("input[name='ids']").each(function() {
			if ($(this).attr("checked") == "checked")
				
				checked = true;
		});
		
		if (!checked) {
			alert("请先选择学生");
			return false;
		}
		$("input[name='ids']").each(function() {
			if ($(this).attr("checked") == "checked")
				param+=$(this).val()+",";	
				
		});
		
		var chClasId = $("#chClasId").val(); 
		var isLast=$("#isLast").val();
		/* alert(param); */
				var url = '${ctx }/student/enrolment_reOrder.do?id='+param+'&chClasId='+chClasId+'&isLast='+isLast;
				$.dialog({id:'redivideClassesBtn',title:'<my:i18n zhText="重新分班" enText="NoAuto Students"/>',content: 'url:'+url,cancelVal: '关闭',cancel: true,width: '500px',height: 300});
			});
			
			
			//建立学籍
		 $("#generateStudSchroll").click(function(){
				
				var checked = false;
				var param = "";
				$("input[name='ids']").each(function() {
					if ($(this).attr("checked") == "checked")
						
						checked = true;
				});
				
				if (!checked) {
					alert("请先选择学生");
					return false;
				}
				$("input[name='ids']").each(function() {
					if ($(this).attr("checked") == "checked")
						param+=$(this).val()+",";	
						
				});
				//alert(param);
				$("#studentForm").attr("action",'${ctx }/student/student_generateStudSchroll.do?ids='+param+'&initnumber=001');		 
				  $("#studentForm").submit();  
				
			} ); 
	
			//学号生成
			$("#generateSchcode").click(function(){
			var checked = false;
			var param = "";
			$("input[name='ids']").each(function() {
				if ($(this).attr("checked") == "checked")
					
					checked = true;
			});
			if (!checked) {
				alert("请先选择学生");
				return false;
			}
			$("input[name='ids']").each(function() {
				if ($(this).attr("checked") == "checked")
					param+=$(this).val()+",";	
					
			});
			var url = '${ctx }/student/student_generateSchcode.do?id='+param+'';
			$.dialog({id:'generateSchcode',title:'<my:i18n zhText="学号生成" enText="Generate Students"/>',content: 'url:'+url,cancelVal: '关闭',cancel: true,width: '500px',height: 300});  
				});
			$("#exportExcel").click(function(){
				$("#studentForm").attr("action","${ctx}/student/student_exportPdf.do").submit();
			});
			
			
			$("#searchButton").click(function(){
				/* $("#studentForm").attr("action","${ctx}/student/enrolment_list.do").submit(); */
			
				var url="${ctx}/student/enrolment_queryEnrolment.do";		
				$.dialog({
					id : 'searchButton',
					title : '<my:i18n zhText="查询" enText="Query Students"/>',
					content : 'url:' + url,
					cancelVal : '关闭',
					cancel : true,
					width : '400px',
					height : 300
				});		
			});
		    $("#addnewButton").click(function(){window.location.href=addnewurl;});
		    
			 	$("#addnewBtn").click(function() {

				$.dialog({
					id : 'addnewBtn',
					title : '<my:i18n zhText="新增" enText="Add Students"/>',
					content : 'url:' + addnewurl,
					cancelVal : '关闭',
					cancel : true,
					width : '800px',
					height : 600
				});
				/*  window.location.href=addnewurl; */
			});
		});
	

		
		
		function reloadStudent(){
			location.href="${ctx}/student/enrolment_list.do";
		}
	</script>
	
	<script type="Text/JavaScript">  
    
    function open1(){
			$('#p').panel('open');
		}
		function close1(){
			$('#p').panel('close');
		}
	
	 $(function() {
	
			 $("#submitBtn").submitForm({ 

				 formId:"studentForm1",

				 onComplete:function(){ 
				     var ShopConfirmLayer = document.getElementById("ShopConfirmLayer");
			ShopConfirmLayer.style.display = "none";//显示内容层，显示覆盖层 
			var trNum=  $("#trNum").val();
			
			/* var tab = document.getElementById("myltablebody");
			
			tab.rows[trNum].cells[3].innerHTML = $("#chScroSchroll").val();
			tab.rows[trNum].cells[4].innerHTML = $("#chScroSchcode").val();
			tab.rows[trNum].cells[5].innerHTML = $("#chScroName").val();
			tab.rows[trNum].cells[7].innerHTML = $("#chScroEngname").val();
			tab.rows[trNum].cells[8].innerHTML = $("#chScroOldname").val();
			tab.rows[trNum].cells[9].innerHTML = $("#chScroEnrolldate").val();
			tab.rows[trNum].cells[10].innerHTML = $("#chScroGrade").val();
			tab.rows[trNum].cells[11].innerHTML = $("#chClasId").val();
			tab.rows[trNum].cells[12].innerHTML = $("#chScroType").val();
			tab.rows[trNum].cells[13].innerHTML = $("#chScroState").val();
			tab.rows[trNum].cells[14].innerHTML = $("#chScroPersontype").val();
			tab.rows[trNum].cells[15].innerHTML = $("#chScroPersonid").val();
			tab.rows[trNum].cells[16].innerHTML = $("#chScroSex").val();
			tab.rows[trNum].cells[17].innerHTML = $("#chScroBirth").val();
			tab.rows[trNum].cells[18].innerHTML = $("#chScroBirthplace").val();
			tab.rows[trNum].cells[19].innerHTML = $("#chScroOnly").val();
			tab.rows[trNum].cells[20].innerHTML = $("#chScroHometown").val();
			tab.rows[trNum].cells[21].innerHTML = $("#chScroEthnic").val();
			tab.rows[trNum].cells[22].innerHTML = $("#chScroOldschool").val();
			tab.rows[trNum].cells[23].innerHTML = $("#chScroAdmway").val();
			tab.rows[trNum].cells[24].innerHTML = $("#chScroSourareas").val();
			tab.rows[trNum].cells[25].innerHTML = $("#chScroForeign").val();
			tab.rows[trNum].cells[26].innerHTML = $("#chScroHealth").val();
			tab.rows[trNum].cells[27].innerHTML = $("#chScroBloodtype").val();
			tab.rows[trNum].cells[28].innerHTML = $("#chScroPolface").val();
			tab.rows[trNum].cells[29].innerHTML = $("#chScroAddress").val();
			tab.rows[trNum].cells[30].innerHTML = $("#chScroLocakind").val();
			tab.rows[trNum].cells[31].innerHTML = $("#chScroLocation").val();
			tab.rows[trNum].cells[32].innerHTML = $("#chScroFlowperson").val();
			tab.rows[trNum].cells[33].innerHTML = $("#chScroNational").val();
			tab.rows[trNum].cells[34].innerHTML = $("#chScroPhone").val();
			tab.rows[trNum].cells[35].innerHTML = $("#chScroTranaddress").val();
			tab.rows[trNum].cells[36].innerHTML = $("#chScroZip").val();
			tab.rows[trNum].cells[37].innerHTML = $("#chScroEmail").val();
			tab.rows[trNum].cells[38].innerHTML = $("#chScroWebsite").val();
			tab.rows[trNum].cells[39].innerHTML = $("#chScroImage").val();
			tab.rows[trNum].cells[40].innerHTML = $("#chScroCadreflag").val();
			tab.rows[trNum].cells[41].innerHTML = $("#chScroScore").val();
			tab.rows[trNum].cells[42].innerHTML = $("#chScroSpecial").val();
			tab.rows[trNum].cells[44].innerHTML = $("#chScroMemo").val(); */
			
			
			
			$('tr:nth-child('+trNum+') td:nth-child(3)').text($("#chScroSchroll").val()); 	    
			$('tr:nth-child('+trNum+') td:nth-child(4)').text($("#chScroSchcode").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(5)').text($("#chScroName").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(7)').text($("#chScroEngname").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(8)').text($("#chScroOldname").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(9)').text($("#chScroEnrolldate").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(10)').text($("#chScroGrade").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(11)').text($("#chClasId").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(12)').text($("#chScroType").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(13)').text($("#chScroState").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(14)').text($("#chScroPersontype").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(15)').text($("#chScroPersonid").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(16)').text($("#chScroSex").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(17)').text($("#chScroBirth").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(18)').text($("#chScroBirthplace").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(19)').text($("#chScroOnly").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(20)').text($("#chScroHometown").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(21)').text($("#chScroEthnic").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(22)').text($("#chScroOldschool").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(23)').text($("#chScroAdmway").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(24)').text($("#chScroSourareas").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(25)').text($("#chScroForeign").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(26)').text($("#chScroHealth").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(27)').text($("#chScroBloodtype").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(28)').text($("#chScroPolface").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(29)').text($("#chScroAddress").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(30)').text($("#chScroLocakind").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(31)').text($("#chScroLocation").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(32)').text($("#chScroFlowperson").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(33)').text($("#chScroNational").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(34)').text($("#chScroPhone").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(35)').text($("#chScroTranaddress").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(36)').text($("#chScroZip").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(37)').text($("#chScroEmail").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(38)').text($("#chScroWebsite").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(39)').text($("#chScroImage").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(40)').text($("#chScroCadreflag").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(41)').text($("#chScroScore").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(42)').text($("#chScroSpecial").val()); 
			$('tr:nth-child('+trNum+') td:nth-child(44)').text($("#chScroMemo").val()); 		
		
				 }
			  });
		}); 

		$(document).ready(function() {
			$(".myltablebody tr td").dblclick(function() {
				open1();
				ShopConfirm("sss");
				var theid = $(this).parent('tr').attr('id');
				var tdNum = $(this).parent().find('td').index($(this)[0])+ 1; 
				var trNum = $(this).parent().parent().find('tr').index($(this).parent()[0])+ 1;  
				//var au_id = $('#ltable').find('tr:eq(' + (6) + ')').find('td:eq(3)').html();
				//alert(theid);
				 $("#id").val(theid);
				 $("#trNum").val(trNum);
				//  $("#chthid").val(trNum);
				// alert( $('tr:nth-child('+trNum+') td:nth-child(5)').text());
				
			  //  alert($("#chStudSchroll").val());
			   // alert($('tr:nth-child('+trNum+') td:nth-child(2)').text());
				$("#chScroSchroll").val($('tr:nth-child('+trNum+') td:nth-child(3)').text()); 
				
                $("#chScroSchcode").val($('tr:nth-child('+trNum+') td:nth-child(4)').text()); 
                $("#chScroName").val($('tr:nth-child('+trNum+') td:nth-child(5)').text()); 
                $("#chScroEngname").val($('tr:nth-child('+trNum+') td:nth-child(7)').text()); 
                $("#chScroOldname").val($('tr:nth-child('+trNum+') td:nth-child(8)').text()); 
                $("#chScroEnrolldate").val($('tr:nth-child('+trNum+') td:nth-child(9)').text()); 
                $("#chScroGrade").val($('tr:nth-child('+trNum+') td:nth-child(10)').text()); 
                $("#chClasId").val($('tr:nth-child('+trNum+') td:nth-child(11)').text()); 
                $("#chScroType").val($('tr:nth-child('+trNum+') td:nth-child(12)').text()); 
                $("#chScroState").val($('tr:nth-child('+trNum+') td:nth-child(13)').text()); 
                $("#chScroPersontype").val($('tr:nth-child('+trNum+') td:nth-child(14)').text()); 
                $("#chScroPersonid").val($('tr:nth-child('+trNum+') td:nth-child(15)').text()); 
                $("#chScroSex").val($('tr:nth-child('+trNum+') td:nth-child(16)').text()); 
                $("#chScroBirth").val($('tr:nth-child('+trNum+') td:nth-child(17)').text()); 
                $("#chScroBirthplace").val($('tr:nth-child('+trNum+') td:nth-child(18)').text()); 
                $("#chScroOnly").val($('tr:nth-child('+trNum+') td:nth-child(19)').text()); 
                $("#chScroHometown").val($('tr:nth-child('+trNum+') td:nth-child(20)').text()); 
                $("#chScroEthnic").val($('tr:nth-child('+trNum+') td:nth-child(21)').text()); 
                $("#chScroOldschool").val($('tr:nth-child('+trNum+') td:nth-child(22)').text()); 
                $("#chScroAdmway").val($('tr:nth-child('+trNum+') td:nth-child(23)').text()); 
                $("#chScroSourareas").val($('tr:nth-child('+trNum+') td:nth-child(24)').text()); 
                $("#chScroForeign").val($('tr:nth-child('+trNum+') td:nth-child(25)').text()); 
                $("#chScroHealth").val($('tr:nth-child('+trNum+') td:nth-child(26)').text()); 
                $("#chScroBloodtype").val($('tr:nth-child('+trNum+') td:nth-child(27)').text()); 
                $("#chScroPolface").val($('tr:nth-child('+trNum+') td:nth-child(28)').text()); 
                $("#chScroAddress").val($('tr:nth-child('+trNum+') td:nth-child(29)').text()); 
                $("#chScroLocakind").val($('tr:nth-child('+trNum+') td:nth-child(30)').text()); 
                $("#chScroLocation").val($('tr:nth-child('+trNum+') td:nth-child(31)').text()); 
                $("#chScroFlowperson").val($('tr:nth-child('+trNum+') td:nth-child(32)').text()); 
                $("#chScroNational").val($('tr:nth-child('+trNum+') td:nth-child(33)').text()); 
                $("#chScroPhone").val($('tr:nth-child('+trNum+') td:nth-child(34)').text()); 
                $("#chScroTranaddress").val($('tr:nth-child('+trNum+') td:nth-child(35)').text()); 
                $("#chScroZip").val($('tr:nth-child('+trNum+') td:nth-child(36)').text()); 
                $("#chScroEmail").val($('tr:nth-child('+trNum+') td:nth-child(37)').text()); 
                $("#chScroWebsite").val($('tr:nth-child('+trNum+') td:nth-child(38)').text()); 
                $("#chScroImage").val($('tr:nth-child('+trNum+') td:nth-child(39)').text()); 
                $("#chScroCadreflag").val($('tr:nth-child('+trNum+') td:nth-child(40)').text()); 
                $("#chScroScore").val($('tr:nth-child('+trNum+') td:nth-child(41)').text()); 
                $("#chScroSpecial").val($('tr:nth-child('+trNum+') td:nth-child(42)').text()); 
                $("#chScroMemo").val($('tr:nth-child('+trNum+') td:nth-child(44)').text()); 
							});
		});

       
		function ShopConfirm(str) {
			var ShopConfirmLayer = document.getElementById("ShopConfirmLayer");
			ShopConfirmLayer.style.display = "block";//显示内容层，显示覆盖层
					ShopConfirmLayer.style.left = "65px";
					ShopConfirmLayer.style.top="0px";
		}

		function cancelupdate() {
			var ShopConfirmLayer = document.getElementById("ShopConfirmLayer");
			ShopConfirmLayer.style.display = "none";//显示内容层，显示覆盖层
		}
	</script>
</my:head>
<body>
	<Page class="bodybox" >
	   <div class="phead">
	   <div class="pheadposition">
			<my:i18n zhText="当前位置" enText="Current Position"/>:<my:i18n zhText="学生管理" enText="Student Mgt"/> - <my:i18n zhText="学籍管理" enText="Enrollment Information"/> 
	   </div><br><br>
	   <div class="pMenuHead">
			<my:auth fixedValue="W" value="${auth}">
				<input type="button" class="button orange"  value="<my:i18n zhText="查询" enText="Search"/>" id="searchButton" />
				<input type="button" class="button orange"  value="<my:i18n zhText="统计" enText="Statistic"/>" id="statisticalButton"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="新增" enText="Add A New Enrollment"/>"  id="addnewBtn"/>
				<%-- <input type="button" class="button orange"  value="<my:i18n zhText="编辑" enText="Edit"/>"  id="editBtn"/>  --%>
				<input type="button" class="button orange"  value="<my:i18n zhText="批量修改" enText="Bulk Editing"/>"  id="bulkEditBtn"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="删除" enText="Delete"/>"  id="batchDelete"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="异动" enText="Variation"/>"  id="variationBtn" />
				<input type="button" class="button orange"  value="<my:i18n zhText="摄像" enText="Camera"/>"  id="cameraBtn"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="照片导入" enText="Image Import"/>"  id="imgImpBtn"/> 
				<input type="button" class="button orange"  value="<my:i18n zhText="照片导出" enText="Image Export"/>"  id="imgExpBtn"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="导出Excel" enText="Export Excel"/>"  id="expExcelBtn"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="重新分班" enText="Redivide Classes"/>"  id="redivideClassesBtn" />
				<input type="button" class="button orange"  value="<my:i18n zhText="学籍上传" enText="Enrollment Upload"/>"  id="enrollmentUploadBtn"/>
				<input type="button" class="button orange"  value="<my:i18n zhText="审核" enText="Verify"/>"  id="verifyBtn" />
				
			</my:auth>
		</div>
	   <div id="formDiv">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" id="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" id="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="tableDiv" style="width:100%;overflow-x: auto;">
			   	 <table class="myltable" id="myTable"  style="width:600%;">
			            <thead class="ltablehead">
			                <tr id="tab tr">
			                	<th width="20 px"><input type="checkbox" name="checkId" id="checkId" value=""></th>
			                  	<th width="20 px"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="50 px"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="50 px"><my:i18n zhText="学号" enText="chStudSchcode"/><my:order orderattr="student.chStudSchcode"/></th>
			                	<th width="50 px"><my:i18n zhText="姓名" enText="chStudName"/></th>
			                	<th width="50 px"><my:i18n zhText="姓名拼音" enText="chStudPinyin"/></th>
			                	<th width="50 px"><my:i18n zhText="英文姓名" enText="chScroEngname"/></th>
			                	<th width="50 px"><my:i18n zhText="曾用名" enText="chScroOldname"/></th>
			                	<th width="50 px"><my:i18n zhText="入学年月" enText="chStudEnrolldate"/></th>
			                	<th width="50 px"><my:i18n zhText="年级" enText="chScroGrade"/></th>							
								<th width="50 px"><my:i18n zhText="班号" enText="chClasId"/></th>
								
								
								<th width="50 px"><my:i18n zhText="学生类别" enText="chScroType"/></th>
			                	<th width="50 px"><my:i18n zhText="学籍状态" enText="chScroState"/></th>
			                	<th width="50 px"><my:i18n zhText="身份证件类型" enText="chScroPersontype"/></th>
			                	<th width="50 px"><my:i18n zhText="身份证件号码" enText="chScroPersonid"/></th>
			                	<th width="50 px"><my:i18n zhText="性别" enText="chScroSex"/></th>
			                	<th width="50 px"><my:i18n zhText="出生日期" enText="chScroBirth"/></th>
								<th width="50 px"><my:i18n zhText="出生地" enText="chScroBirthplace"/></th>
								
								<th width="50 px"><my:i18n zhText="独生子女" enText="chScroOnly"/></th>
			                	<th width="50 px"><my:i18n zhText="籍贯" enText="chScroHometown"/></th>
			                	<th width="50 px"><my:i18n zhText="民族" enText="chScroEthnic"/></th>
			                	<th width="50 px"><my:i18n zhText="原学校" enText="chScroOldschool"/></th>
			                	<th width="50 px"><my:i18n zhText="入学方式" enText="chScroAdmway"/></th>
			                	<th width="50 px"><my:i18n zhText="来源地区" enText="chScroSourareas"/></th>
								<th width="50 px"><my:i18n zhText="港澳台侨外" enText="chScroForeign"/></th>	
								
								<th width="50 px"><my:i18n zhText="健康状况" enText="chScroHealth"/></th>
			                	<th width="50 px"><my:i18n zhText="血型" enText="chScroBloodtype"/></th>
			                	<th width="50 px"><my:i18n zhText="政治面貌" enText="chScroPolface"/></th>
			                	<th width="50 px"><my:i18n zhText="现住址" enText="chScroAddress"/></th>
			                	<th width="50 px"><my:i18n zhText="户口性质" enText="chScroLocakind"/></th>
			                	<th width="50 px"><my:i18n zhText="户口所在地" enText="chScroLocation"/></th>
								<th width="50 px"><my:i18n zhText="流动人口" enText="chScroFlowperson"/></th>
								
								<th width="50 px"><my:i18n zhText="国籍" enText="chScroNational"/></th>
			                	<th width="50 px"><my:i18n zhText="联系电话" enText="chScroPhone"/></th>
			                	<th width="50 px"><my:i18n zhText="通信地址" enText="chScroTranaddress"/></th>
			                	<th width="50 px"><my:i18n zhText="邮政编码" enText="chScroZip"/></th>
			                	<th width="50 px"><my:i18n zhText="电子信箱" enText="chScroEmail"/></th>
			                	<th width="50 px"><my:i18n zhText="主页地址" enText="chScroWebsite"/></th>
								<th width="50 px"><my:i18n zhText="照片" enText="chScroImage"/></th>
								
								<th width="60 px"><my:i18n zhText="是否当过班干部" enText="chScroCadreflag"/></th>
			                	<th width="50 px"><my:i18n zhText="入学成绩" enText="chScroScore"/></th>
			                	<th width="50 px"><my:i18n zhText="特长" enText="chScroSpecial"/></th>
			                	<th width="50 px"><my:i18n zhText="修改状态" enText="chScroUpdateflag"/></th>
			                	<th width="50 px"><my:i18n zhText="备注" enText="chScroMemo"/></th>	
			                	<th width="50 px" style="display: none;"><my:i18n zhText="操作" enText="Action" /></th>
			                </tr>
			            </thead>
			            
			            <tbody class="myltablebody" id = "myltablebody">
				            <c:if test="${empty page.list}">
					            <tr>
									<td align="center" colspan="9"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
				           </c:if>
				           <c:forEach items="${page.list}" var="ChSchoolroll" varStatus="status">
				              <tr id="${ChSchoolroll.id }">									
										<td align="center" width="20 px"><input type="checkbox" name="ids" onclick="window.event.cancelBubble=true;" value="${ChSchoolroll.id}"/></td>
										<td align="center" width="20 px"><my:rowNum page="${page}" rowIndex="${status.index}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroSchroll}" enText="${ChSchoolroll.chScroSchroll}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroSchcode}" enText="${ChSchoolroll.chScroSchcode}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroName}" enText="${ChSchoolroll.chScroName}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroPinyin}" enText="${ChSchoolroll.chScroPinyin}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroEngname}" enText="${ChSchoolroll.chScroEngname}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroOldname}" enText="${ChSchoolroll.chScroOldname}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroEnrolldate}" enText="${ChSchoolroll.chScroEnrolldate}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroGrade}" enText="${ChSchoolroll.chScroGrade}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chClasId}" enText="${ChSchoolroll.chClasId}"/></td>
										
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroType}" enText="${ChSchoolroll.chScroType}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroState}" enText="${ChSchoolroll.chScroState}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroPersontype}" enText="${ChSchoolroll.chScroPersontype}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroPersonid}" enText="${ChSchoolroll.chScroPersonid}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroSex}" enText="${ChSchoolroll.chScroSex}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroBirth}" enText="${ChSchoolroll.chScroBirth}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroBirthplace}" enText="${ChSchoolroll.chScroBirthplace}"/></td>
										
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroOnly}" enText="${ChSchoolroll.chScroOnly}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroHometown}" enText="${ChSchoolroll.chScroHometown}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroEthnic}" enText="${ChSchoolroll.chScroEthnic}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroOldschool}" enText="${ChSchoolroll.chScroOldschool}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroAdmway}" enText="${ChSchoolroll.chScroAdmway}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroSourareas}" enText="${ChSchoolroll.chScroSourareas}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroForeign}" enText="${ChSchoolroll.chScroForeign}"/></td>
										
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroHealth}" enText="${ChSchoolroll.chScroHealth}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroBloodtype}" enText="${ChSchoolroll.chScroBloodtype}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroPolface}" enText="${ChSchoolroll.chScroPolface}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroAddress}" enText="${ChSchoolroll.chScroAddress}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroLocakind}" enText="${ChSchoolroll.chScroLocakind}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroLocation}" enText="${ChSchoolroll.chScroLocation}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroFlowperson}" enText="${ChSchoolroll.chScroFlowperson}"/></td>
										
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroNational}" enText="${ChSchoolroll.chScroNational}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroPhone}" enText="${ChSchoolroll.chScroPhone}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroTranaddress}" enText="${ChSchoolroll.chScroTranaddress}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroZip}" enText="${ChSchoolroll.chScroZip}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroEmail}" enText="${ChSchoolroll.chScroEmail}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroWebsite}" enText="${ChSchoolroll.chScroWebsite}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroImage}" enText="${ChSchoolroll.chScroImage}"/></td>
										
										<td width="60 px"><my:i18n zhText="${ChSchoolroll.chScroCadreflag}" enText="${ChSchoolroll.chScroCadreflag}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroScore}" enText="${ChSchoolroll.chScroScore}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroSpecial}" enText="${ChSchoolroll.chScroSpecial}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroUpdateflag}" enText="${ChSchoolroll.chScroUpdateflag}"/></td>
										<td width="50 px"><my:i18n zhText="${ChSchoolroll.chScroMemo}" enText="${ChSchoolroll.chScroMemo}"/></td>
										<td width="50 px" style="display: none;"><my:auth fixedValue="W" value="${auth}">
											<a href="javascript:edit('${ChSchoolroll.id}');" id="edit"><my:i18n
												zhText="编辑" enText="Edit" /> </a>
											<a href="javascript:" class="deleteOne"
												param="ids=${ChSchoolroll.id}"><my:i18n zhText="删除"
												enText="Delete" /> </a>
											</my:auth>
										</td>
								</tr>
				              </c:forEach>
			            </tbody>
		         </table>
			   	</div>
		       	<div class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div>			  	
	       	</form>		       		   
		   </div> 
	   <br>
	   <div id="panel" class="bodybox">
			 <div>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" id="tabs1" >
					<tr>
						<td>
							<div align="center" id="uldiv">
								 <ul id="ul">
									<li id="familyInfoBtn" value="1" class="familyInfoBtn"><a href="javascript:void(0);" id="a1"><span id="s1"><my:i18n zhText="家庭信息" enText="Family Info"/></span></a></li>
									<li id="resumeBtn" value="2" class="resumeBtn"><a href="javascript:void(0);" id="a2"><span id="s2"><my:i18n zhText="简历" enText="Resume"/></span></a></li>
									<li id="remarkBtn" value="3" class="remarkBtn"><a href="javascript:void(0);" id="a3"><span id="s3"><my:i18n zhText="评语" enText="Remark"/></span></a></li>
									<li id="postBtn" value="4" class="postBtn"><a href="javascript:void(0);" id="a4"><span id="s4"><my:i18n zhText="职务" enText="Post"/></span></a></li>
									<li id="rewPunBtn" value="5" class="rewPunBtn"><a href="javascript:void(0);" id="a5"><span id="s5"><my:i18n zhText="奖惩" enText="Rewardand Punishment"/></span></a></li>
									<li id="worksBtn" value="6" class="worksBtn"><a href="javascript:void(0);" id="a6"><span id="s6"><my:i18n zhText="作品" enText="Works"/></span></a></li>
									<li id="specialtyBtn" value="7" class="specialtyBtn"><a href="javascript:void(0);" id="a7"><span id="s7"><my:i18n zhText="特长" enText="Specialty"/></span></a></li>
									<li id="practiceBtn" value="8" class="practiceBtn"><a href="javascript:void(0);" id="a8"><span id="s8"><my:i18n zhText="综合实践记录" enText="Practice"/></span></a></li>
									<li id="homeVisBtn" value="9" class="homeVisBtn"><a href="javascript:void(0);" id="a9"><span id="s9"><my:i18n zhText="家访信息" enText="Home Visits"/></span></a></li>
								  	<li id="othersBtn" value="10" class="othersBtn"><a href="javascript:void(0);" id="a10"><span id="s10"><my:i18n zhText="其他信息" enText="Others"/></span></a></li>
								  </ul>
							</div>
						 </td>
						</tr>
					</table>
			  </div>
			  
			  <div>
			  <!--家庭信息 -->
			  <div>
			  	<div id="familyInfoDiv" style="display:block;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="familyInfoTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="familyTable">
			            <thead class="ltablehead">
			                <tr id="familyInfoTr">
			                	<th width="4.5%"><input type="checkbox" name="familyInfoCheckId" id="familyInfoCheckId" value=""></th>
			                  	<th width="4.5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="13%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="13%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="13%"><my:i18n zhText="与本人关系" enText="chStudPinyin"/>
			                	<th width="13%"><my:i18n zhText="工作单位" enText="chScroEngname"/>
			                	<th width="13%"><my:i18n zhText="政治面貌" enText="chScroOldname"/>
			                	<th width="13%"><my:i18n zhText="职务" enText="chStudEnrolldate"/>
			                	<th width="13%"><my:i18n zhText="联系电话" enText="chScroGrade"/>	                	
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="familyInfoTableBody">				        	
					         <tr>
								<td align="center" colspan="9"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							 </tr>
			            </tbody>
		         </table>
			   	</div>
		       				  	
	       	</form>		       		   
		   </div>
<%-- 		   <div  id="familyInfoPage" style="display:block;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div> --%>
		    </div>  
		   
		   	  <!-- 简历 -->
		   	  <div>
		   	<div id="resumeDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="resumeTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="resumeT">
			            <thead class="ltablehead">
			                <tr id="resumeTr">
			                	<th width="4.5%"><input type="checkbox" name="resumeCheckId" id="resumeCheckId" value=""></th>
			                  	<th width="4.5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="13%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="13%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="13%"><my:i18n zhText="学校" enText="chStudPinyin"/>
			                	<th width="13%"><my:i18n zhText="时间段" enText="chScroEngname"/>
			                	<th width="13%"><my:i18n zhText="入校时间" enText="chScroOldname"/>
			                	<th width="13%"><my:i18n zhText="毕业时间" enText="chStudEnrolldate"/>
			                	<th width="13%"><my:i18n zhText="证明人" enText="chScroGrade"/>	                	
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="resumeTableBody">
					            <tr>
									<td align="center" colspan="9"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>			  	
	       	</form>       		   
		   </div>		   			       	
<%-- 		       	<div id="resumePage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div>	 --%>
		   </div> 
		   	  <!-- 评语 -->
		   	  <div>
		  <div id="remarkeDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="remarkeTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="remarkeT">
			            <thead class="ltablehead">
			                <tr id="remarkeTr">
			                	<th width="4.5%"><input type="checkbox" name="remarkeCheckId" id="remarkeCheckId" value=""></th>
			                  	<th width="4.5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="13%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="13%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="13%"><my:i18n zhText="时间段" enText="chStudPinyin"/>
			                	<th width="13%"><my:i18n zhText="学期" enText="chScroEngname"/>
			                	<th width="13%"><my:i18n zhText="班主任" enText="chScroOldname"/>
			                	<th width="13%"><my:i18n zhText="评语" enText="chStudEnrolldate"/>
			                	<th width="13%"><my:i18n zhText="品德总评等第" enText="chScroGrade"/>	                	
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="remarkeTableBody">
					            <tr>
									<td align="center" colspan="9"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>		  	
	       	</form>			       		   
		   </div> 		   			       	
<%-- 		       	<div id="remarkePage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div> --%>
		   </div>
		   	  <!-- 职务 -->
		   	  <div>
		   <div id="postDiv"  style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="postTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="postT">
			            <thead class="ltablehead">
			                <tr id="postTr">
			                	<th width="4%"><input type="checkbox" name="postCheckId" id="postCheckId" value=""></th>
			                  	<th width="4%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="12%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="10%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="10%"><my:i18n zhText="时间段" enText="chStudPinyin"/>
			                	<th width="10%"><my:i18n zhText="班级" enText="chScroEngname"/>
			                	<th width="10%"><my:i18n zhText="学期" enText="chScroOldname"/>
			                	<th width="10%"><my:i18n zhText="职务" enText="chStudEnrolldate"/>
			                	<th width="10%"><my:i18n zhText="政治面貌" enText="chScroGrade"/>	                	
			                    <th width="10%"><my:i18n zhText="变化日期" enText="chScroGrade"/>
			                    <th width="10%"><my:i18n zhText="经办人" enText="chScroGrade"/>
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="postTableBody">
					            <tr>
									<td align="center" colspan="11"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>		       				  	
	       	</form>		       		   
		   </div> 
<%-- 		   		<div  id="postPage"  style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div> --%>
		</div>
		   	  <!-- 奖惩 -->
		   	  <div>		   	  
		   <div id="rwdPnsDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="rwdPnsTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="rwdPnsT">
			            <thead class="ltablehead">
			                <tr id="rwdPnsTr">
			                	<th width="4.5%"><input type="checkbox" name="rwdPnsCheckId" id="rwdPnsCheckId" value=""></th>
			                  	<th width="4.5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="9%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="9%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="9%"><my:i18n zhText="学号" enText="chStudPinyin"/>
			                	<th width="9%"><my:i18n zhText="时间段" enText="chScroEngname"/>
			                	<th width="9%"><my:i18n zhText="学期" enText="chScroOldname"/>
			                	<th width="9%"><my:i18n zhText="奖/惩" enText="chStudEnrolldate"/>
			                	<th width="9%"><my:i18n zhText="处罚方式" enText="chScroGrade"/>	                	
			                	<th width="9%"><my:i18n zhText="奖惩时间" enText="chScroGrade"/>
			                	<th width="9%"><my:i18n zhText="奖惩原因" enText="chScroGrade"/>
			                	<th width="9%"><my:i18n zhText="奖惩信息" enText="chScroGrade"/>			                	
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="rwdPnsTBody">
					            <tr>
									<td align="center" colspan="12"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>		       			  	
	       	</form>		       		   
		   </div> 
<%-- 		   		<div id="rwdPnsPage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div>	 --%>
		   </div>
		   	  <!-- 作品 -->
		   	  <div>
		   	  <div id="worksDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="worksTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="worksT">
			            <thead class="ltablehead">
			                <tr id="worksTr">
			                	<th width="4.5%"><input type="checkbox" name="worksCheckId" id="worksCheckId" value=""></th>
			                  	<th width="4.5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="13%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="13%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="13%"><my:i18n zhText="时间段" enText="chStudPinyin"/>
			                	<th width="13%"><my:i18n zhText="学期" enText="chScroEngname"/>
			                	<th width="13%"><my:i18n zhText="作品名称" enText="chScroOldname"/>
			                	<th width="13%"><my:i18n zhText="完成时间" enText="chStudEnrolldate"/>
			                	<th width="13%"><my:i18n zhText="作品内容" enText="chScroGrade"/>	                	
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="worksTableBody">
					            <tr>
									<td align="center" colspan="9"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>		       				  	
	       	</form>		       		   
		   </div> 
<%-- 		   		<div  id="worksPage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div> --%>
		   </div>
		   	  <!-- 特长 -->
		   	  <div>
		   	  <div id="specialityDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="specialityTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="specialityT">
			            <thead class="ltablehead">
			                <tr id="specialityTr">
			                	<th width="5%"><input type="checkbox" name="specialityCheckId" id="specialityCheckId" value=""></th>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="12%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="12%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="11%"><my:i18n zhText="学号" enText="chStudPinyin"/>
			                	<th width="11%"><my:i18n zhText="时间段" enText="chScroEngname"/>
			                	<th width="11%"><my:i18n zhText="学期" enText="chScroOldname"/>
			                	<th width="11%"><my:i18n zhText="获证时间" enText="chStudEnrolldate"/>
			                	<th width="11%"><my:i18n zhText="获证原因" enText="chScroGrade"/>	                	
			                	<th width="11%"><my:i18n zhText="备注" enText="chScroGrade"/>
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="specialTableBody">
					            <tr>
									<td align="center" colspan="10"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>		  	
	       	</form>		       		   
		   </div> 		   		
	<%-- 	       	<div  id="specialityPage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div>	 --%>
		   </div>
		   	  <!-- 综合实践记录 -->
		   	  <div>
		   	  <div id="practiceDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="practiceTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="practiceT">
			            <thead class="ltablehead">
			                <tr id="practiceTr">
			                	<th width="4.5%"><input type="checkbox" name="practiceCheckId" id="practiceCheckId" value=""></th>
			                  	<th width="4.5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="13%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="13%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="13%"><my:i18n zhText="时间段" enText="chStudPinyin"/>
			                	<th width="13%"><my:i18n zhText="学期" enText="chScroEngname"/>
			                	<th width="13%"><my:i18n zhText="实践时间" enText="chScroOldname"/>
			                	<th width="13%"><my:i18n zhText="实践地址" enText="chStudEnrolldate"/>
			                	<th width="13%"><my:i18n zhText="实践内容" enText="chScroGrade"/>	                	
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="practiceTableBody">
					            <tr>
									<td align="center" colspan="9"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
		         </table>
			   	</div>		  	
	       	</form>		       		   
		   </div>		   		
<%-- 		       	<div  id="practicePage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div> --%>
		   </div>
		   	  <!-- 家访信息 -->
		   	  <div>
		   	  <div id="homeVisitDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="homeVisitTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="homeVisitT">
			            <thead class="ltablehead">
			                <tr id="homeVisitTr">
			                	<th width="5%"><input type="checkbox" name="homeVisitCheckId" id="homeVisitCheckId" value=""></th>
			                  	<th width="5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="15%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="15%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="15%"><my:i18n zhText="时间段" enText="chStudPinyin"/>
			                	<th width="15%"><my:i18n zhText="学期" enText="chScroEngname"/>
			                	<th width="15%"><my:i18n zhText="家访时间" enText="chScroOldname"/>
			                	<th width="15%"><my:i18n zhText="家访原因" enText="chStudEnrolldate"/>			                		                	
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="homevisiteTableBody">
					            <tr>
									<td align="center" colspan="8"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>		       				  	
	       	</form>		       		   
		   </div>
<%-- 		   		<div  id="homeVisitPage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div> --%>
		   </div>
		   	  <!-- 其他信息 -->
		   	  <div>
		   <div id="othersDiv" style="display: none;">
		   		<form action="${ctx }/student/enrolment_list.do" method="post" id="studentForm">
		   			<input type="hidden" name="chClasId" value="${chclasstree.id }"/>
		   			<input type="hidden" name="isLast" value="${chclasstree.isLast }"/>
			   	 		   	 	   	 
			   	<div id="othersTable" style="width:100%;">
			   	 <table class="ltable" width="100%" id="othersT">
			            <thead class="ltablehead">
			                <tr id="othersTr">
			                	<th width="4.5%"><input type="checkbox" name="othersCheckId" id="othersCheckId" value=""></th>
			                  	<th width="4.5%"><my:i18n zhText="序号" enText="No."/></th>
			                  	<th width="10%"><my:i18n zhText="学籍号" enText="chStudSchroll"/><my:order orderattr="student.chStudSchroll"/></th>
			                	<th width="10%"><my:i18n zhText="姓名" enText="chStudName"/>
			                	<th width="10%"><my:i18n zhText="时间段" enText="chStudPinyin"/>
			                	<th width="10%"><my:i18n zhText="学期" enText="chScroEngname"/>
			                	<th width="10%"><my:i18n zhText="校车号" enText="chScroOldname"/>
			                	<th width="10%"><my:i18n zhText="延长班" enText="chStudEnrolldate"/>
			                	<th width="10%"><my:i18n zhText="提高班" enText="chScroGrade"/>	                	
			                	<th width="10%"><my:i18n zhText="体锻达标" enText="chScroGrade"/>
			                	<th width="10%"><my:i18n zhText="艺校" enText="chScroGrade"/>
			                </tr>
			            </thead>
			            
			            <tbody class="ltablebody" id="othersTableBody">
					            <tr>
									<td align="center" colspan="11"><font color="red"><my:i18n zhText="没有找到相关信息" enText="No Student List"/></font> </td>
							    </tr>
			            </tbody>
		         </table>
			   	</div>		       				  	
	       	</form>		       		   
		   </div>
<%-- 		   		<div  id="othersPage" style="display: none;" class="ltablebottom">
		           <div class="lpage"><my:page page="${page}"/></div> 
			  	</div> --%>
		   </div>
		   
			  </div>
			  
			  <div class="pMenuHead">
				<my:auth fixedValue="W" value="${auth}">
					<input type="button" class="button orange"  value="<my:i18n zhText="新增" enText="Add A New Enrollment"/>"  id="addBtn"/>
					<input type="button" class="button orange"  value="<my:i18n zhText="编辑" enText="Modify"/>"  id="modifyBtn"/> 
					<input type="button" class="button orange"  value="<my:i18n zhText="删除" enText="Delete"/>"  id="dropBtn"/>
				</my:auth>
			</div>
	   </div>
	</div>
 <!-- 学籍信息编辑 -->
<div id="ShopConfirmLayer" 
		style="position:fixed; background-color:#fff; z-index:900; border:0px #fff solid; width:900px; display:none;  ">
		<div id="p" class="easyui-panel" style="width:902px;height:470px;padding:0px;"
				data-options="title:'编辑学籍信息',iconCls:'icon-save',
						collapsible:true,minimizable:false,maximizable:false,closable:true">
		<div id="ShopConfirmLayer1"
		style="top:0px;background-color:#fff;left:0px;z-index:900;border:0px #fff solid;width:900px;">
		

		<div class="bodybox"><div style="height:470px;background:#fafafa;padding:5px;z-index:900;">
               <div class="pheadposition"> <my:i18n zhText="学籍管理" enText="User Mgt"/> - 编辑</div>
				<form id="studentForm1" name="studentForm1"

					action="{ctx }/student/enrolment_save.do" method="post">


					<input type="hidden" name="id" id="id" value="${id}" />
					<input type="hidden" name="trNum" id="trNum" value="" />
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

		
	
	   </div>
	 </div>
	</div>
</div>

</body>
</html>