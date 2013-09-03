<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>系统登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>

<script type="text/javascript" src="${ctx}/js_css_image/js/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/js_css_image/js/base/jquery.ccloudedu.utils-1.0.js"></script>
</head>
<body class="login-layout">
		<div class="main-container container-fluid">
			<div class="main-content">
				<div class="row-fluid">
					<div class="span12">
						<div class="login-container">
							<div class="row-fluid">
								<div class="center">
									<h1>
										<i class="icon-leaf green"></i>
										<span class="red">虹信</span>
										<span class="white">教育管理平台</span>
									</h1>
									<h4 class="blue">&copy; 虹信软件</h4>
								</div>
							</div>

							<div class="space-6"></div>

							<div class="row-fluid">
								<div class="position-relative">
									<div id="login-box" class="login-box visible widget-box no-border">
										<div class="widget-body">
											<div class="widget-main">
												<h4 class="header blue lighter bigger">
													<i class="icon-coffee green"></i>
													请输入你的用户名和密码
												</h4>

												<div class="space-6"></div>

												<form id="loginForm" method="post" action="${ctx}/login/login_login.do">
													<fieldset>
														<label>
															<span class="block input-icon input-icon-right">
																<input type="hidden" name="forceLogin" id="forceLogin" value="N"/>
																<input type="text" class="span12" id="loginName" name="loginName" value="admin" placeholder="Username"/>
																<i class="icon-user"></i>
															</span>
														</label>

														<label>
															<span class="block input-icon input-icon-right">
																<input type="password" class="span12" id="passwordTemp" value="111111" placeholder="Password"/>
																<input type="password" class="span12" style="display: none" id="password" name="password" value="111111" onkeydown="if(event.keyCode==13||event.which==13)submitLogin();"/>
																<i class="icon-lock"></i>
															</span>
														</label>
														<label>
															<span class="errtips label" id="tips">${loginMessage}</span>
														</label>
														
														<div class="space"></div>

														<div class="clearfix">
															<label class="inline">
																<input type="checkbox" class="ace" />
																<span class="lbl"> 下次自动登录</span>
															</label>
															<button type="button" onclick="submitLogin()" id="submitBtn" class="width-35 pull-right btn btn-small btn-primary">
																<i class="icon-key"></i>
																登录
															</button>
														</div>

														<div class="space-4"></div>
													</fieldset>
												</form>

											</div><!--/widget-main-->

											<div class="toolbar clearfix">
												<div>
													<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
														<i class="icon-arrow-left"></i>
														忘记密码
													</a>
												</div>
											</div>
										</div><!--/widget-body-->
									</div><!--/login-box-->

									<div id="forgot-box" class="forgot-box widget-box no-border">
										<div class="widget-body">
											<div class="widget-main">
												<h4 class="header red lighter bigger">
													<i class="icon-key"></i>
													取回密码
												</h4>

												<div class="space-6"></div>
												<p>
													请输入你的邮箱地址
												</p>

												<form>
													<fieldset>
														<label>
															<span class="block input-icon input-icon-right">
																<input type="email" class="span12" placeholder="Email" />
																<i class="icon-envelope"></i>
															</span>
														</label>

														<div class="clearfix">
															<button onclick="return false;" class="width-35 pull-right btn btn-small btn-danger">
																<i class="icon-lightbulb"></i>
																发送!
															</button>
														</div>
													</fieldset>
												</form>
											</div><!--/widget-main-->

											<div class="toolbar center">
												<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
													回到登录
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div><!--/widget-body-->
									</div><!--/forgot-box-->

									<div id="signup-box" class="signup-box widget-box no-border">
										<div class="widget-body">
											<div class="widget-main">
												<h4 class="header green lighter bigger">
													<i class="icon-group blue"></i>
													New User Registration
												</h4>

												<div class="space-6"></div>
												<p> Enter your details to begin: </p>

												<form>
													<fieldset>
														<label>
															<span class="block input-icon input-icon-right">
																<input type="email" class="span12" placeholder="Email" />
																<i class="icon-envelope"></i>
															</span>
														</label>

														<label>
															<span class="block input-icon input-icon-right">
																<input type="text" class="span12" placeholder="Username" />
																<i class="icon-user"></i>
															</span>
														</label>

														<label>
															<span class="block input-icon input-icon-right">
																<input type="password" class="span12" placeholder="Password" />
																<i class="icon-lock"></i>
															</span>
														</label>

														<label>
															<span class="block input-icon input-icon-right">
																<input type="password" class="span12" placeholder="Repeat password" />
																<i class="icon-retweet"></i>
															</span>
														</label>

														<label>
															<input type="checkbox" class="ace" />
															<span class="lbl">
																I accept the
																<a href="#">User Agreement</a>
															</span>
														</label>

														<div class="space-24"></div>

														<div class="clearfix">
															<button type="reset" class="width-30 pull-left btn btn-small">
																<i class="icon-refresh"></i>
																Reset
															</button>

															<button onclick="return false;" class="width-65 pull-right btn btn-small btn-success">
																Register
																<i class="icon-arrow-right icon-on-right"></i>
															</button>
														</div>
													</fieldset>
												</form>
											</div>

											<div class="toolbar center">
												<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
													<i class="icon-arrow-left"></i>
													Back to login
												</a>
											</div>
										</div><!--/widget-body-->
									</div><!--/signup-box-->
								</div><!--/position-relative-->
							</div>
						</div>
					</div><!--/.span-->
				</div><!--/.row-fluid-->
			</div>
		</div><!--/.main-container-->
	</body>
	<script type="text/javascript">
        var ctx = "${ctx}";
        jQuery(function($) {
	    	if($("#password").val()!=""){
	    		$("#password").show();
	    		$("#passwordTemp").hide();
	    	}
	    	//cookie自动登录
	    	var loca = window.location.href+"";
	    	var cookie_rememberme = $.cookie("cookie.rememberme");
	    	if(loca.indexOf("login.jsp")>0 && loca.indexOf("logout")<=0 && cookie_rememberme!=null){
	    		$.post("${ctx}/login/login_login.do", 
		    		  {"cookieRememberme": cookie_rememberme},
				      function(data){
		    			  loginSuccess(data);
				      }
		        );
	    	}
	    	$("#loginName,#passwordTemp,#password").focus(function(){$(".errtips").hide();$(this).addClass("focus")}).blur(function(){$(this).removeClass("focus")});
	    
	    	$("#loginName,#passwordTemp,#password").textRemindAuto();
	    	
	    	$("#passwordTemp").focus(function(){
	    		$(this).hide();
	    		$("#password").show().focus();
	    	});
	    	$("#password").blur(function(){
	    		if($(this).val()==""){
	    			$(this).hide();
	    		    $("#passwordTemp").show();
	    		}
	    	});
	    	var logout = "<%=request.getParameter("logout")%>";
	    	if(logout!=""){
	    		if(logout=="timeout"){
	    			$(".errtips").html("您已经登录超时，请重新登录").show();
	    		}else if(logout=="repeatlogin"){
	    			$(".errtips").html("您的账号已经在别处登录， 不可重复登录").show();
	    		}
	    	}
	    });
	    
	     function submitLogin(){
	          if($("#loginName").val()!="" && $("#loginName").val()!="请输入账号" && $("#password").val()!="" && $("#password").val()!="请输入密码"){
	    		$("#submitBtn").val("登录中...").removeClass("green").addClass("grey").attr("disabled","disabled");
		    	$.post("${ctx}/login/login_login.do", 
		    		  {"loginName": $("#loginName").val(),"password":$("#password").val(),"forceLogin":$("#forceLogin").val()},
				      function(data){
		    			loginSuccess(data);
				      }
				 );
	        }
         }
	     
	     //登录成功
	     function loginSuccess(data){
	    	  // $.cookie('ccloudedu_login_info', $("#loginName").val()+"_"+$("#password").val(), {expires: 7, path: '/ccloudedu', domain: '127.0.0.1'});
		     var msg = data.msg;
			 if(msg=="success"){
				    window.location.href="${ctx}/system/layout_layout.do";
			 }else{
				 $("#submitBtn").val("登录").removeClass("grey").addClass("green").removeAttr("disabled");
				 if(msg!="repeatLogin"){
				      $(".errtips").html(msg).show();
				 }else{
				     $(".errtips").html("您的账号已经在别处登录， 不可重复登录&nbsp;[<a href=\"#\" onclick=\"fLogin()\">强行登录</a>]").show();
				}
			}
	     }
	     function fLogin(){
	    	 if(confirm("\"强行登录\"将迫使该账号在别处自动注销，您确定要强行登录吗？")){
	    		 $("#forceLogin").val("Y");
	    	     submitLogin();
	    	 }
	     }
 </script>
</html> 