<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<title><my:i18n zhText="ccloudedu，java 快速开发功能演示" enText="My Project Demo"/></title>

<my:head easyui="true" lhgdialog="true">
    <!-- 导航菜单 -->
    <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/menu.css" media="screen" />
	<script type="text/javascript" src="${ctx }/js_css_image/js/jquery/ddaccordion-2.0.js"></script>
	<script type="text/javascript" src="${ctx }/js_css_image/js/base/initDdaccordion.js"></script>
    <script type="text/javascript">
       <%---
	    function window.onbeforeunload(){  
	    	 if(event.clientX>document.body.clientWidth && event.clientY<0 || event.altKey ){   
                 window.event.returnValue="确定要退出本页吗?";   
                 window.location.href=ctx+"/bm/login/login_logout.do";
             }
        }  
	    --%>
	    var ctx = '${ctx}';
	    $(function(){
	    	
	    	if ($.browser.msie && ($.browser.version == "6.0") && !$.support.style) {
				$.dialog.notice({ 
				   id: 'msgTip',title:$.i18n("dialogMyMessage"),content: "您还在使用IE6，建议您升级为IE7/8/9/10，或其他浏览器", width: 200, height: 50, left: '100%', top: '100%',  fixed: true,  drag: false, resize: false 
			    });
            }
	    	$("#changeRoleId").change(function(){
	    		$("#changeRoleForm")[0].submit();
	    	});
	    	$("#change_request_locale").change(function(){
	    		$("#request_locale").val($(this).val());
	    		$("#changeRoleForm")[0].submit();
	    	});
	    	
	    	onlineUserCount();
	    	setInterval(onlineUserCount,120000);//2分钟检查一次是否用有新用户登录
	    	
	    	newMessgage();
	    
	    	$("#onlineUser").click(function(){
				var url = '${ctx }/system/layout_listOnlineUser.do';
				$.dialog({
					id:'onlineUser',title:$.i18n("dialogOnlineUser"),content: 'url:'+url,cancelVal:$.i18n("close"),cancel: true,width: '700px',height: 450 
				});
			});
	    	 
	    	 $("#onlineChat").click(function(){
				var url = '${ctx }/system/layout_onlineChart.do';
				$.dialog({
					id:'onlineChat',title:$.i18n("dialogOnlineChat"),content: 'url:'+url,cancelVal:$.i18n("close"),cancel: true,width: '700px',height: 450 
				}).max();
			});
	    	
			$("#messageBoard").click(function(){
				var url = '${ctx }/oa/messageboard_add.do';
				$.dialog({
					id:'messageBoard',title:$.i18n("dialogMessageBoard"),content: 'url:'+url,cancelVal:$.i18n("close"),cancel: true,width: '700px', height: 450 
				});
			});
			
			$("#readme").click(function(){
				var url = '${ctx }/readme/index.html';
				var readme = $.dialog({
					id:'readme',title:'readme',content: 'url:'+url, cancelVal:$.i18n("close"),cancel: true,lock:true ,width: '900px',height: 450 
				});//.max()
			});
			
			$("#updatePassword").click(function(){
				var url = '${ctx }/system/user_toUpdatePassword.do';
				var updatePassword = $.dialog({
					id:'updatePassword',title:$.i18n("dialogUpdatePassword"),content: 'url:'+url,cancelVal:$.i18n("close"),cancel: true,lock:true ,width: '700px',height: 450 
				});//.max()
			});
			$("#deskSet").click(function(){
				var url = '${ctx }/system/user_toSetDesk.do';
				var deskSet = $.dialog({
					id:'deskSet',title:$.i18n("dialogDeskSetting"),content: 'url:'+url, cancelVal:$.i18n("close"),cancel: true,lock:true ,width: '700px',height: 450 
				});//.max()deskSet
			});
		
	    	//setInterval(newMessgage,60000);//1分钟检查一次
	    	//setInterval(loginUserCount,10000);//1秒 = 1000 毫秒     1分钟=60秒=60000毫秒
		});
	    
	    //当前在线人数
	    function onlineUserCount(){
            $.post("${ctx}/system/layout_getOnlineUserCount.do",function(ret) {
				      $("#loginUserCount").text("").text(ret);
			      }, "html");
		}
	    
	    var msgTip;
	    function newMessgage(){
	    	
	    	$.post("${ctx }/oa/intenalMassage_getNewMessage.do",function(data){
		    	if(data!=null && data.msg!=""){
			    	var td = data.msg.split("|");
		    		//var msg = '<a href="${ctx}/oa/intenalMassage_update.do?id='+td[0]+'&queryType=2&fromMsgtip=1" '+
		    		//          'title="'+td[1]+'" name="msgtip" id="msgtip" target="_blank">'+td[1]+'</a>';
		    		 var msg = "<a style=\"cursor: pointer;\" title='"+td[1]+"' name=\"msgtip\" id=\"msgtip\" onclick=\"readMsg('"+td[0]+"')\">"+td[1]+"</a>";
		    		 msgTip = $.dialog.notice({ 
						    id: 'msgTip',title:$.i18n("dialogMyMessage"),content: msg, width: 200, height: 50, left: '100%', top: '100%',  fixed: true,  drag: false, resize: false 
					});
		    		//$.messager.show({title:'新消息',msg:msg,timeout:10000,showType:'slide'});
			    }
	    	}); 
		}
	    function readMsg(msgId){
	    	$.dialog({
	    		    id: 'readMsg', title:$.i18n("dialogReadMessage"),content: 'url:${ctx}/oa/intenalMassage_read.do?id='+msgId,cancelVal:$.i18n("close"),cancel: true,width: '700px',height: 450 
				});
	    	msgTip.close();
	    	//msgD.show();
	    }
	    
	    function reloadIframe(){
	    	$("#menuIframeId").attr("src","${ctx }/system/desksetting.do");
	    }
	    
	    function focusMenu(id){
	        
			$('li').removeClass('ahover');
			$('#'+id).addClass('ahover');
		}
	    
	    $.dialog.notice = function( options ){
			    var opts = options || {},
			        api, aConfig, hide, wrap, top,
			        duration = opts.duration || 800;
			    var config = {
			        id: 'Notice',
			        left: '100%',
			        top: '100%',
			        fixed: true,
			        drag: false,
			        resize: false,
			        init: function(here){
			            api = this;
			            aConfig = api.config;
			            wrap = api.DOM.wrap;
			            top = parseInt(wrap[0].style.top);
			            hide = top + wrap[0].offsetHeight;
			                        
			            wrap.css('top', hide + 'px')
			            .animate({top: top + 'px'}, duration, function(){
			                opts.init && opts.init.call(api, here);
			            });
			        },
			        close: function(here){
			            wrap.animate({top: hide + 'px'}, duration, function(){
			                opts.close && opts.close.call(this, here);
			                aConfig.close = $.noop;
			                api.close();
			            });
			            return false;
			        }
			    };
			        
			    for(var i in opts) {
			        if( config[i] === undefined ) config[i] = opts[i];
			    }
			    return $.dialog( config );
			};
       //=========2013-7-25 tabs
 	   function addTab(title, url,frameName){
 	   
	if ($('#tabs').tabs('exists', title)){
		$('#tabs').tabs('select', title);//选中并刷新
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url,frameName)
				}
			});
		}
	} else {
		var content = createFrame(url,frameName);
		$('#tabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
	tabClose();
   } 
    function createFrame(url,frameName) {
    //alert('123123');
    //alert(frameName);
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;" id="'+frameName+'" name="'+frameName+'"></iframe>';
	return s;
    } 
 
$(function() {


	$('.aa').click(function() {
	   
	
		var $this = $(this);
		var href = ctx+$this.attr('src');
		var title = $this.text();
		var frameName=$this.attr('frameName');
		addTab(title, href,frameName);
	}); 
	});
		
	  //1.倒计定时器：timename=setTimeout("function();",delaytime);   单位是毫秒
	  //2.循环定时器：timename=setInterval("function();",delaytime); 
   </script>
</my:head>
<body class="easyui-layout">
  <%--
   <body class="easyui-layout">
		<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	    <div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">west content</div>
	    <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	    <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	    <div data-options="region:'center',title:'Main Title'"></div>
   </body>
   --%>
	
	<div data-options="region:'north',border:false" style="height:35px;padding:5px;background:url(${ctx}/js_css_image/images/bg_logo.gif)"> 
	   <%@include file="head.jsp" %>
	</div>
   <div data-options="region:'west',split:true,title:'<my:i18n zhText="菜单导航" enText="Menu Navigation"/>'" style="width:211px;padding-left:2px;padding-top:1px;">
		<div class="arrowlistmenu">
			<c:forEach items="${menuList}" var="menu">
		    <h3 class="menuheader expandable"><my:i18n zhText="${menu.menuName}" enText="${menu.enMenuName}"/></h3>
			  <ul class="categoryitems" style="border: 0">
			     <c:forEach items="${menu.subList}" var="subMenu">
			        <c:set value="${subMenu.subList}" var="subList"></c:set>
			           <% 
			              List list = (List)pageContext.getAttribute("subList"); ; 
			              if(list!=null && list.size()>0){
			           %>
			              <li>
			                <a style="cursor: pointer;" class="subexpandable">
			                  <img src="${ctx }/js_css_image/images/1.gif" alt="1" width="4" height="6" /><my:i18n zhText="${subMenu.menuName}" enText="${subMenu.enMenuName}"/>
			                </a>
			                 <ul class="subcategoryitems" style="margin-left:5px"> 
			                      <c:forEach items="${subMenu.subList}" var="subSubMenu">
			                         <li id="${subSubMenu.id }">
			                            <a href="javascript:void(0)"style="cursor: pointer;" onclick="focusMenu('${subSubMenu.id}');" src="${subSubMenu.menuPath}" class="aa" frameName="${subMenu.menuName}">
					                      &nbsp;&nbsp;&nbsp;<img src="${ctx }/js_css_image/images/4.gif" alt="1" width="4" height="6" /><my:i18n zhText="${subSubMenu.menuName}" enText="${subSubMenu.enMenuName}"/>
					                    </a>
				                    </li> 
			                      </c:forEach>
			                 </ul>
			              </li>
			           <%
			              }else{
			           %>
				           <li id="${subMenu.id}">
					        <a  href="javascript:void(0)" style="cursor: pointer;" onclick="focusMenu('${subMenu.id}');" src="${subMenu.menuPath}" class="aa" frameName="${subMenu.menuName}">
					         <img src="${ctx }/js_css_image/images/1.gif" alt="1" width="4" height="6" /><my:i18n zhText="${subMenu.menuName}" enText="${subMenu.enMenuName}"/>
					        </a>
					      </li> 
			           <%
			              }
			           %>
			     </c:forEach>
			    </ul>
		    <div class="leftmar"></div>
		</c:forEach>
		</div> 
	</div>
	
    <div data-options="region:'center',title:'<my:i18n zhText="桌面" enText="My Desk"/>'" id="deskTitle"> 
		<div id="tabs" class="easyui-tabs"  fit="true" border="false" >
                <div title="Home">
				<iframe id="menuIframeId" name="menuIframeId" frameborder="0" src="${ctx }/system/desksetting.do" width="100%" height="99%"></iframe>
				</div>
        </div>
		 <%-- <iframe id="menuIframeId" name="menuIframeId" frameborder="0" src="${ctx }/system/desksetting.do" width="100%" height="99%"></iframe>  --%>
	 </div>
	 

	<%-- 
	
	<div region="center" border="false">
		<div id="main-center" fit="true">
		     <iframe id="menuIframeId" name="menuIframeId" frameborder="0" src="system/user_list.do" style="width:100%;height:100%;"></iframe>
		 </div>		
	 </div>
	//------------------------------------------------------
	 <div region="center" border="false">
		<div id="main-center" fit="true">
		<%@include file="center.jsp" %>
		 </div>			
	 </div> --%>
	
 </body>
</html>