<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统首页</title>
<%@ include file="/common/head.jsp"%>


<script type="text/javascript">
	$(document).ready(function (){
	});
</script>
</head>
<body>

<div class="navbar" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-inner">
				<div class="container-fluid">
					<a href="#" class="brand">
						<small>
							<i class="icon-leaf"></i>
							<span class="light-orange">虹信</span>
							<span class="white">教育管理平台</span>
						</small>
					</a><!--/.brand-->

					<ul class="nav ace-nav pull-right">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-tasks"></i>
								<span class="badge badge-grey">4</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
								<li class="nav-header">
									<i class="icon-ok"></i>
									4 Tasks to complete
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">Software Update</span>
											<span class="pull-right">65%</span>
										</div>

										<div class="progress progress-mini ">
											<div style="width:65%" class="bar"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">Hardware Upgrade</span>
											<span class="pull-right">35%</span>
										</div>

										<div class="progress progress-mini progress-danger">
											<div style="width:35%" class="bar"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">Unit Testing</span>
											<span class="pull-right">15%</span>
										</div>

										<div class="progress progress-mini progress-warning">
											<div style="width:15%" class="bar"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">Bug Fixes</span>
											<span class="pull-right">90%</span>
										</div>

										<div class="progress progress-mini progress-success progress-striped active">
											<div style="width:90%" class="bar"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										See tasks with details
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>

							<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-closer">
								<li class="nav-header">
									<i class="icon-warning-sign"></i>
									8 Notifications
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-mini no-hover btn-pink icon-comment"></i>
												New Comments
											</span>
											<span class="pull-right badge badge-info">+12</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<i class="btn btn-mini btn-primary icon-user"></i>
										Bob just signed up as an editor ...
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-mini no-hover btn-success icon-shopping-cart"></i>
												New Orders
											</span>
											<span class="pull-right badge badge-success">+8</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-mini no-hover btn-info icon-twitter"></i>
												Followers
											</span>
											<span class="pull-right badge badge-info">+11</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										See all notifications
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
								<li class="nav-header">
									<i class="icon-envelope-alt"></i>
									5 Messages
								</li>

								<li>
									<a href="#">
										<img src="${ctx}/images/avatar.png" class="msg-photo" alt="Alex's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Alex:</span>
												Ciao sociis natoque penatibus et auctor ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>a moment ago</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img src="${ctx}/images/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Susan:</span>
												Vestibulum id ligula porta felis euismod ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>20 minutes ago</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img src="${ctx}/images/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Bob:</span>
												Nullam quis risus eget urna mollis ornare ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>3:15 pm</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										See all messages
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${ctx}/images/user.jpg" alt="Photo" />
								<span class="user-info">
									<small>欢迎你,</small>
									root
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="">
										<i class="icon-user"></i>
										修改密码
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!--/.ace-nav-->
				</div><!--/.container-fluid-->
			</div><!--/.navbar-inner-->
		</div>

<div class="main-container container-fluid">
	<a class="menu-toggler" id="menu-toggler" href="#">
		<span class=""></span>
	</a>

	<div class="sidebar" id="sidebar">
		<script type="text/javascript">
			try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
		</script>

		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
				<button class="btn btn-small btn-success">
					<i class="icon-signal"></i>
				</button>

				<button class="btn btn-small btn-info">
					<i class="icon-pencil"></i>
				</button>

				<button class="btn btn-small btn-warning">
					<i class="icon-group"></i>
				</button>

				<button class="btn btn-small btn-danger">
					<i class="icon-cogs"></i>
				</button>
			</div>

			<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
				<span class="btn btn-success"></span>

				<span class="btn btn-info"></span>

				<span class="btn btn-warning"></span>

				<span class="btn btn-danger"></span>
			</div>
		</div><!--#sidebar-shortcuts-->
		
		
		
<ul class="nav nav-list">
		<c:forEach items="${menuList}" var="menu">
			<li>
				<a href="#" class="dropdown-toggle">
					<i class="icon-dashboard"></i>
					<span class=""><my:i18n zhText="${menu.chFuncName}" enText="${menu.chFuncName}"/></span>
					<b class="arrow icon-angle-down"></b>
				</a>
			   		<c:set value="${menu.subList}" var="subList"></c:set>
			           <% 
			              List list = (List)pageContext.getAttribute("subList"); ; 
			              if(list!=null && list.size()>0){
			           %>
			          	<ul class="submenu">
			          	<%
			              }
			           %>	
		          		 <c:forEach items="${menu.subList}" var="subMenu">
			           	
							 	<li>									<c:set value="${subMenu.subList}" var="subSubList"></c:set>
							 	
							 	<% 
						              List sublist = (List)pageContext.getAttribute("subSubList"); ; 
						              if(sublist!=null && sublist.size()>0){
						           %>
						          	
									<a href="#" class="dropdown-toggle">
						          	<%
						              }else{
						           %>
						           	<a href="#">
						           <%} %>
										<i class="icon-double-angle-right"></i>
										<my:i18n zhText="${subMenu.chFuncName}" enText="${subMenu.chFuncName}"/>
									</a>
									<% 
						              if(sublist!=null && sublist.size()>0){
						           %>
						          	<ul class="submenu">
						          	<%
						              }
						           %>
									<c:forEach items="${subMenu.subList}" var="subSubMenu">
						           
						           <li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										<my:i18n zhText="${subSubMenu.chFuncName}" enText="${subSubMenu.chFuncName}"/>
									</a>
									</li>
									</c:forEach>
										<% 
							              if(sublist!=null && sublist.size()>0){
							           %>
							          	</ul>
							          	<%
							              }
							           %>
								</li>
						
				     	</c:forEach>
						<% 
			              if(list!=null && list.size()>0){
			           %>
			          	</ul>
			          	<%
			              }
			           %>
	            
			  </li>
		  </c:forEach>
</ul>
		<!--/.nav-list-->
		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
		</div>

		<script type="text/javascript">
			try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
		</script>
	</div>

	<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>

			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="{% url 'index' %}">首页</a>

					<span class="divider">
						<i class="icon-angle-right arrow-icon"></i>
					</span>
				</li>

				<li>
					<a href="#">系统管理</a>

					<span class="divider">
						<i class="icon-angle-right arrow-icon"></i>
					</span>
				</li>
				<li class="active">资源管理</li>
			</ul><!--.breadcrumb-->

			<div class="nav-search" id="nav-search">
				<form class="form-search">
					<span class="input-icon">
						<input type="text" placeholder="Search ..." class="input-small nav-search-input" id="nav-search-input" autocomplete="off" />
						<i class="icon-search nav-search-icon"></i>
					</span>
				</form>
			</div><!--#nav-search-->
		</div>


		<div class="page-content">
			<div class="row-fluid">
				<div class="span12">
					<!--PAGE CONTENT BEGINS-->
						<decorator:body></decorator:body>
					<!--PAGE CONTENT ENDS-->
				</div><!--/.span-->
			</div><!--/.row-fluid-->
		</div><!--/.page-content-->

		<div class="ace-settings-container" id="ace-settings-container">
			<div class="btn btn-app btn-mini btn-warning ace-settings-btn" id="ace-settings-btn">
				<i class="icon-cog bigger-150"></i>
			</div>

			<div class="ace-settings-box" id="ace-settings-box">
				<div>
					<div class="pull-left">
						<select id="skin-colorpicker" class="hide">
							<option data-skin="default" value="#438EB9">#438EB9</option>
							<option data-skin="skin-1" value="#222A2D">#222A2D</option>
							<option data-skin="skin-2" value="#C6487E">#C6487E</option>
							<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
						</select>
					</div>
					<span>&nbsp; Choose Skin</span>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
					<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
					<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
					<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
					<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
				</div>
			</div>
		</div><!--/#ace-settings-container-->
	</div><!--/.main-content-->
</div><!--/.main-container-->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
	<i class="icon-double-angle-up icon-only bigger-110"></i>
</a>
 </body>
</html>