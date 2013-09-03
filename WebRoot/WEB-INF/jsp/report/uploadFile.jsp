<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath() %>" />

<html>
	<my:head lhgdialog="true" tree3="true">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


	</my:head>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%>


	<script type="text/javascript"
		src="<%=path%>/js_css_image/js/Uploadify/swfobject.js"></script>
	<script type="text/javascript"
		src="<%=path%>/js_css_image/js/Uploadify/jquery.uploadify.v2.1.0.js"></script>

	<link href="<%=path%>/js_css_image/js/Uploadify/uploadify.css"
		rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	<script type="text/javascript"> 
        $(document).ready(function() { 
            $("#fileupload").uploadify({ 
                /*注意前面需要书写path的代码*/ 
                'uploader'       : '<%=path%>/js_css_image/js/Uploadify/uploadify.swf', 
                'script'         : '<%=path%>/report/uploadFile.do', 
                'cancelImg'      : '<%=path%>/js_css_image/js/Uploadify/cancel.png', 
                'queueID'        : 'fileQueue', //和存放队列的DIV的id一致 
                'fileDataName'   : 'fileupload', //和以下input的name属性一致 
                'auto'           : false, //是否自动开始 
                'multi'          : true, //是否支持多文件上传 
                'buttonText'     : 'Browse', //按钮上的文字 
                'simUploadLimit' : 3, //一次同步上传的文件数目 
                'sizeLimit'      : 19871202, //设置单个文件大小限制 
                'queueSizeLimit' : 2, //队列中同时存在的文件个数限制 
                'fileDesc'       : '支持格式:jpg/gif/jpeg/png/bmp.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的 
                'fileExt'        : '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式   
            onComplete: function (event, queueID, fileObj, response, data) { 
				$('<li></li>').appendTo('.files').text(response); 
				}, 
				onError: function(event, queueID, fileObj) { 
				             alert("文件:" + fileObj.name + "上传失败"); 
				       }, 
				       onCancel: function(event, queueID, fileObj){ 
				       alert("取消了" + fileObj.name); 
				       } 
				            }); 
				
				        }); 
        </script>

	<script type="text/javascript"> 
                  //必须的 
function uploadifyUpload(){ 
   $('#fileupload').uploadifyUpload(); 
} 
</script>


	<body>
		<div style="width: 100%; height: 100%; overflow: scroll;">

			<tr>
				<td>
					上传图片：
				</td>
				<td>
					<input type="file" name="fileupload" id="fileupload" />
					<div id="fileQueue"></div>
					<p>
						<a href="javascript:;" onClick="javascript:uploadifyUpload()">开始上传</a>&nbsp;
						<a href="javascript:jQuery('#fileupload').uploadifyClearQueue()">取消所有上传</a>
					</p>
					<ol class=files></ol>
				</td>
			</tr>
		</div>
	</body>
</html>