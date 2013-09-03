<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
     <style type="text/css">
	     .ztree li a:hover {text-decoration:none;}
	     #Canvas{position: relative;border:2px solid #888888;overflow:hidden;cursor:pointer;}
		#bar{
			width: 211px;
			height: 18px;
			background-image: url("${ctx}/js_css_image/images/camera/track.gif");
			background-repeat: no-repeat;
			position: relative;
		}
		.child{width: 11px;height: 16px;background-image: url('${ctx}/js_css_image/images/camera/grip.gif');background-repeat: no-repeat;left: 0;top:3px;position: absolute;left:100px;}
		#IconContainer{position:relative;left:0px;}  
		#IconContainer img{FILTER:alpha(opacity=40);opacity:0.6;background-color:#fff;}
		#ImageDragContainer {border: 1px solid #ccc;cursor: pointer;position: relative;overflow: hidden;z-index:1;}   
     </style>	
     <script src="${ctx}/js_css_image/js/studentJS/jquery.pack.js"></script>
	 <script type="text/javascript" src="${ctx}/js_css_image/js/studentJS/ui.core.packed.js" ></script> 
	 <script type="text/javascript" src="${ctx}/js_css_image/js/studentJS/ui.draggable.packed.js" ></script>
 	 <script type="text/javascript" src="${ctx}/js_css_image/js/studentJS/ImgHandle.js" ></script>
     <script type="text/javascript">
	    
    var api = frameElement.api, W = api.opener,cDG;
    var addordetail = true;
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="学籍管理" enText="Enrollment Manage"/> - <my:i18n zhText="摄像" enText="Add Family Information"/></div>
</div>
	<div class="phead">
		<button id="open" class="button orange" style="width: 9%">打开摄像头</button>
		<button id="shoot" class="button orange" style="width: 9%">拍照</button>
		<button id="contranst" onclick="contranst();" class="button orange" style="width: 9%">对比度</button>
		<button id="light" onclick="light();" class="button orange" style="width: 9%">亮度</button>
		<button id="reset" onclick="reset();" class="button orange" style="width: 9%">复位</button>
<!-- 		<button id="cutAgain" name="cutAgain" onclick="submitSrc2();" style="width:9%" class="button orange">重新裁切</button> -->				
		<button id="cutSave" name="cutSave"  onclick="submitSrc();" class="button orange" style="width: 9%">完成裁切</button>
	</div>
<div>   
		<input type="hidden" name="id" id="id" value="${id}"/>
	
	<table style="width: 700;border: 0;cellpadding:3;cellspacing:1">
		<tr>
			<td td width="250" valign="top" bgcolor="#FFFFFF">
				<div class="title">
					<b> 视频取景</b>
				</div>
				<div STYLE="border-style:solid;border-width:3pt; border-color:blue">
					<video id="video_stream" width="480" height="360" autoplay="autoplay">Video</video>
				</div>
				<!-- 该表单用来提交照相后生成的图片 -->						
				<form action="shoot" method="post" target=_blank id="shootForm">
					<input type="hidden" id="picData1" name="picData1" />
					<input type="hidden" id="picExt1" name="picExt1"/>
					<!-- <p>
						<input type="button" value="Submit" onclick="javascript:submit();" />
					</p> -->
				</form>
				<button id="open" style="visibility: hidden;">open camera</button>
				<button id="shoot" style="visibility: hidden;">Shoot</button>
				<button id="shut" style="visibility: hidden;">Shut</button>
				<div id="result"></div>
			</td>
			<td width="250" valign="top" bgcolor="#FFFFFF">
				<div id="">
					<div class="title">
						<b> 裁切头像</b>
					</div>
					
					<div class="uploadtooltip"></div>
					
					<div id="Canvas" class="uploaddiv">
						<!-- 图片拖拽容器 -->
						<div id="ImageDragContainer">
							<img src='' id='ImageDrag'>
						</div>
						<!-- 图标容器 -->
						<div id="IconContainer">
							<img src='' id='ImageIcon'>
						</div>
					</div>
					
					<div class="uploaddiv">
						<table style="width: 250; align:center;">
							<tr>
							<!-- 缩小图片的放大镜图标 -->
								<td width="23" id="Min">
									<img alt="缩小" src="${ctx}/js_css_image/images/camera/_c.gif"
									onMouseOver="this.src='${ctx}/js_css_image/images/camera/_c.gif';"
									onMouseOut="this.src='${ctx}/js_css_image/images/camera/_h.gif';" 
									id="moresmall"
									class="smallbig" />
								</td>
								<!-- 滑动条 -->
								<td width="216">
									<div id="bar">
										<div class="child"></div>
									</div>
								</td>
							<!-- 放大图片的放大镜图标 -->
								<td id="Max">
									<img alt="放大" src="${ctx}/js_css_image/images/camera/c.gif"
									onMouseOver="this.src='${ctx}/js_css_image/images/camera/c.gif';"
									onMouseOut="this.src='${ctx}/js_css_image/images/camera/h.gif';" 
									id="morebig"
									class="smallbig" />
								</td>
							</tr>
						</table>
					</div>
				</div>
			</td>
			
			<td valign="top" bgcolor="#FFFFFF">
				<form action="ajax" method="post" target="_blank"
					onSubmit="">
					<div style="display: inherit;">	
						<div class="title">
							<b>裁切后头像</b>
						</div>				
						<input name="smallImage" type="image" id="smallImage" src="" width="120" height="160"/><br>
				   		<input name="left" id="left" type="hidden" value="" /><br> 
				  		<input name="top" id="top" type="hidden" value="" /><br>
				  		<input name="img_x" id="img_x" type="hidden" value="" /><br>
				  		<input name="img_y" id="img_y" type="hidden" value="" /><br>
				  		<input name="img_w" id="img_w" type="hidden" value="" /><br>
				  		<input name="img_h" id="img_h" type="hidden" value="" /><br>
				  		<input name="dst_x" id="dst_x" type="hidden" value="" /><br>
				  		<input name="dst_y" id="dst_y" type="hidden" value="" /><br>
				  		<input name="dst_w" id="dst_w" type="hidden" value="" /><br>
				  		<input name="dst_h" id="dst_h" type="hidden" value="" /><br>
				        <input name="f" id="f" type="hidden" value="" /><br> 
				        <input name="width" id="width" type="hidden" value="" /><br> 
				        <input name="height" id="height" type="hidden" value="" /><br>
					</div>
					<div style="display: none;">
						<input name="imgForHidden" type="image" id="imgForHidden" src="" /><br>
					</div>
				</form>
			</td>
		</tr>
	</table>

</div>
  
</div>
     <script type="text/javascript">
	    
    var api = frameElement.api, W = api.opener,cDG;
    var addordetail = true;  
/*     $(function() {
	    $("#submitBtn").submitForm({	    	    
	    	formId:"familyForm",
			onComplete:function(){				
				api.close();
			}
		});   
    }); */


		//Normalizes window.URL
	var winUrl = window.URL;
	window.URL = window.URL || window.webkitURL || window.msURL
			|| window.oURL;

	// Normalizes navigator.getUserMedia
	navigator.getUserMedia = navigator.getUserMedia
			|| navigator.webkitGetUserMedia || navigator.mozGetUserMedia
			|| navigator.msGetUserMedia;

    function isChromiumVersionLower() {
        var ua = navigator.userAgent;
        var testChromium = ua.match(/AppleWebKit\/.* Chrome\/([\d.]+).* Safari\//);
        if (!testChromium) return false;

        var rltArray = testChromium[1].split('.');
        return ((parseInt(rltArray[0]) < 18) || ((parseInt(rltArray[0]) == 18) && (parseInt(rltArray[1]) == 0) && (parseInt(rltArray[2]) < 966)));
      }

    if (isChromiumVersionLower()) {
        alert('内核版本较低，可能无法支持 getUserMedia 接口');
      } else if (!navigator.getUserMedia) {
        alert('不支持 getUserMedia 接口');
      } else {
        document.getElementById('open').addEventListener('click', accessLocalWebCam, false);
        document.getElementById('shoot').addEventListener('click', shoot, false);
        document.getElementById('shut').addEventListener('click', shut, false);
      }


	//打开本地摄像头
	function accessLocalWebCam() {
		try {
			// Tries it with spec syntax
			navigator.getUserMedia({video : true}, successsCallback, errorCallback);
		} catch (err) {
			console.log(err);
			// Tries it with old spec of string syntax
			navigator.getUserMedia('video', successsCallback, errorCallback);
		}
	}

	function shutCam(){
		//关闭摄像头，貌似现在还没有办法实现
	}
	//成功启动摄像头的回调方法
	function successsCallback(stream) {
		document.getElementById('video_stream').src = 
			(window.URL && window.URL.createObjectURL) ? window.URL.createObjectURL(stream)	: stream;
	}
	//错误时的回调方法
	function errorCallback(err) {
		console.log(err);
	}	

	//拍照
	var imgData;
	function shoot(){
		var video = document.getElementById('video_stream');
        var canvas = capture(video);
        //document.getElementById('result');
        //document.getElementById('result').appendChild(canvas);
        imgData = canvas.toDataURL("image/jpeg");
        var data = imgData.substr(22);

        document.getElementById('ImageDrag').src = imgData;
        document.getElementById('ImageIcon').src = imgData;	
        
		console.log(data);
		//var data = document.getElementById('canvas').jpegBase64Data;
		document.getElementById('picData1').value = data;
		document.getElementById('picExt1').value = '.jpeg';		
		//document.forms[0].submit();
		//var id = document.getElementById('id').value;
		//var msg = id+"@"+data+"@"+".jpeg";
		//myAjax("camera_saveBigPic.do",msg);
		run(0,0);
	}
	//使用ajax提交图片数据
	function myAjax(action,msg){
		  $.ajax({
				url: action,
				type: 'post',
				//dataType:'json',
				data: {"msg":msg},				
				success: success,
				error: error
		    });
	}
	function success(data){
		if(data === "ok"){
			//alert("save img success");
		}else{
			alert("取景失败，请重新点击照相按钮");
		}
	}
	function error(data){
		alert(data);
	}
	
	//从video元素抓取图像到canvas
	var imgW = 0;
	var imgH = 0;
	var dataImg = null;
    function capture(video) { 
        var canvas = document.createElement('canvas'); //建立canvas js DOM元素
        canvas.width = video.videoWidth;
        canvas.height = video.videoHeight;
        imgW = video.videoWidth;
        imgH = video.videoHeight;
        //canvas.width = 320;
        //canvas.height = 240;
        var ctx = canvas.getContext('2d');
        //ctx.drawImage(video, 0, 0,320,240);
        ctx.drawImage(video, 0, 0);
        dataImg = ctx.getImageData(0,0,imgW,imgH);
        return canvas;
    }
	
	var CANVAS_WIDTH = 480; //画布的宽
	var CANVAS_HEIGHT = 360; //画布的高
	var ICON_WIDTH = 120;  //截取框的宽
	var ICON_HEIGHT = 160;  //截取框的高
	var LEFT_EDGE = (CANVAS_WIDTH - ICON_WIDTH) / 2;//截取框与画布左右边缘之间的距离 
	var TOP_EDGE = (CANVAS_HEIGHT - ICON_HEIGHT) / 2; //截取框与画布顶部和底部之间的距离 

	var scaleFactor;
	var factor;
	var minFactor;
	var oldWidth;
	var oldHeight;
	$(window).load(function() {		
		run(0,0);

		//设置拖动条可拖动
		$(".child").draggable({
	      cursor: "move",
	      containment: $("#bar"),
	      drag: function(e, ui) {
	      var left = parseInt($(this).css("left"));
	          //前面讲过了y=factor（x），此处是知道x求y的值，即知道滑动条的位置，获取缩放率
	          scaleFactor = Math.pow(factor, (left / 100 - 1));
	          if (scaleFactor < minFactor) {
	              scaleFactor = minFactor;
	          }
	          if (scaleFactor > factor) {
	              scaleFactor = factor;
	          }
	          //以下代码同初始化过程，因为用到局部变量所以没有
	          var iconElement = $("#ImageIcon");
	          var imagedrag = $("#ImageDrag");

	          var image = new Image();
	          image.src = iconElement.attr("src");
	          var realWidth = image.width;
	          var realHeight = image.height;
	          image = null;

	          //图片实际尺寸
	          var currentWidth = Math.round(scaleFactor * realWidth);//放大缩小后的图片的实际尺寸四舍五入
	          var currentHeight = Math.round(scaleFactor * realHeight);//放大缩小后的图片的实际尺寸四舍五入

	          //图片相对CANVAS的初始位置（坐标）
	          var originLeft = parseInt(iconElement.css("left"));
	          var originTop = parseInt(iconElement.css("top"));

	          originLeft -= Math.round((currentWidth - oldWidth) / 2);
	          originTop -= Math.round((currentHeight - oldHeight) / 2);
	          dragleft = originLeft - LEFT_EDGE;
	          dragtop = originTop - TOP_EDGE;

	          //（设置）图片当前尺寸和位置
	          iconElement.css({ width: currentWidth + "px", height: currentHeight + "px", left: originLeft + "px", top: originTop + "px" });
	          imagedrag.css({ width: currentWidth + "px", height: currentHeight + "px", left: dragleft + "px", top: dragtop + "px" });
	        
			  valuewrite(originLeft,originTop,currentWidth,currentHeight);
			  valuewrite(dragleft,dragtop,currentWidth,currentHeight);
			  oldWidth = currentWidth;
			  oldHeight = currentHeight;
	      }
	  });
	    var SilderSetValue = function(i) {
	        var left = parseInt($(".child").css("left"));
	        left += i;

	        if (left < 0) {
	            left = 0;
	        }
	        if (left > 200) {
	            left = 200;
	        }

	        scaleFactor = Math.pow(factor, (left / 100 - 1));
	        if (scaleFactor < minFactor) {
	            scaleFactor = minFactor;
	        }
	        if (scaleFactor > factor) {
	            scaleFactor = factor;
	        }
	        var iconElement = $("#ImageIcon");
	        var imagedrag = $("#ImageDrag");

	        var image = new Image();
	        image.src = iconElement.attr("src");
	        var realWidth = image.width;
	        var realHeight = image.height;
	        image = null;

	        //图片实际尺寸
	        var currentWidth = Math.round(scaleFactor * realWidth);
	        var currentHeight = Math.round(scaleFactor * realHeight);

	        //图片相对CANVAS的初始位置
	        var originLeft = parseInt(iconElement.css("left"));
	        var originTop = parseInt(iconElement.css("top"));

	        originLeft -= Math.round((currentWidth - oldWidth) / 2);
	        originTop -= Math.round((currentHeight - oldHeight) / 2);
	        dragleft = originLeft - LEFT_EDGE;
	        dragtop = originTop - TOP_EDGE;

	        //图片当前尺寸和位置
	        $(".child").css("left", left + "px");
	        iconElement.css({ width: currentWidth + "px", height: currentHeight + "px", left: originLeft + "px", top: originTop + "px" });
	        imagedrag.css({ width: currentWidth + "px", height: currentHeight + "px", left: dragleft + "px", top: dragtop + "px" });

	        valuewrite(originLeft,originTop,currentWidth,currentHeight);
			valuewrite(dragleft,dragtop,currentWidth,currentHeight);
			oldWidth = currentWidth;
			oldHeight = currentHeight;
	    }
	    //点击加减号
	    $("#moresmall").click(function() {
	        SilderSetValue(-20);
	    });
	    $("#morebig").click(function() {
	        SilderSetValue(20);
	    });
	});
	
	function run(i_width,i_height){
		//页面加载时运行，用来绘制截取图片画布（canvas），#Canvas是一个DIV
		$("#Canvas").css({width:CANVAS_WIDTH+ "px",height:CANVAS_HEIGHT+ "px"});
		//图片截取框的位置
		$("#ImageDragContainer").css({width:ICON_WIDTH+ "px",height:ICON_HEIGHT+ "px",top:TOP_EDGE+1+ "px",left:LEFT_EDGE-1+ "px"});
		//图标容器（这里设置ImageDragContainer和IconContainer重叠）
		$("#IconContainer").css({top:"-"+ICON_HEIGHT+"px"});
		//图片拖拽容器中的iamge容器
    	$iconElement = $("#ImageIcon");
		//图标容器中的image容器
   		$imagedrag = $("#ImageDrag");
   		//创建一个新的图片对象
    	/*var image = new Image();
		//图片对象来自#ImageIcon 
		image.src = $iconElement.attr("src");
		image.onload = function(){  
			console.log("image loading");	        	
        };
        if(image.readyState == 'complete' || image.complete == true){
        	console.log("image loading complete");
		}
		var img1 = document.getElementById('ImageDrag');
		var img2 = document.getElementById('ImageIcon');
		if(imgData != undefined){
			img1.onload = function(){  
				document.getElementById('ImageDrag').src = imgData;  
	        };
	        img2.onload = function(){  
	        	document.getElementById('ImageIcon').src = imgData;	        	
	        };
		}else{
			image.src = $iconElement.attr("src");
		}
		if(img1.readyState == 'complete' || img1.complete == true){
			image.src = document.getElementById('ImageDrag').src;
		}
		if(img2.readyState == 'complete' || img2.complete == true){
			image.src = document.getElementById('ImageIcon').src;
		}
		
		//判断图片是不是为空，并取得图片的大小
		var realWidth;
		var realHeight;
		if(image.width==0 && image.height==0){
			realWidth = i_width;
			realHeight = i_height;
		}else{
		 	realWidth = image.width;
			realHeight = image.height; 
		}
    	image=null;*/
    	realWidth = imgW;
    	realHeight = imgH;
		minFactor = Math.min(ICON_WIDTH / realWidth,ICON_HEIGHT/realHeight);
		console.log("minFactor:"+minFactor);
    	if (ICON_WIDTH > realWidth && ICON_HEIGHT > realHeight) {
        	minFactor = 1;
    	}
    	factor = minFactor > 0.25 ? 8.0 : 4.0 / Math.sqrt(minFactor);

		scaleFactor = 1;
    	if (realWidth > CANVAS_WIDTH && realHeight > CANVAS_HEIGHT) {
        	if (realWidth / CANVAS_WIDTH > realHeight / CANVAS_HEIGHT) {
            	scaleFactor = CANVAS_HEIGHT / realHeight;
        	}
        	else {
            	scaleFactor = CANVAS_WIDTH / realWidth;
        	}
    	}
   		$(".child").css("left", 100 * (Math.log(scaleFactor * factor) / Math.log(factor)) + "px");


		//alert(realWidth+"|"+scaleFactor+"|"+i_width);

    	var currentWidth = Math.round(scaleFactor * realWidth);
    	var currentHeight = Math.round(scaleFactor * realHeight);
		var originLeft = Math.round((CANVAS_WIDTH - currentWidth) / 2) ;
    	var originTop = Math.round((CANVAS_HEIGHT - currentHeight) / 2);
  
    	//计算截取框中的图片的位置
    	var dragleft = originLeft - LEFT_EDGE;
    	var dragtop = originTop - TOP_EDGE;

    	//设置图片当前尺寸和位置
    	$iconElement.css({ width: currentWidth + "px", height: currentHeight + "px", left: originLeft + "px", top: originTop + "px" });
    	$imagedrag.css({ width: currentWidth + "px", height: currentHeight + "px", left: dragleft + "px", top: dragtop + "px" });
	
		oldWidth = currentWidth;
    	oldHeight = currentHeight;
		valuewrite(dragleft,dragtop,oldWidth,oldHeight);
	
  		$("#ImageDrag").draggable(
    		{
        		cursor: 'move',
        		drag: function(e, ui) {
            	var self = $(this).data("draggable");
            	var drop_img = $("#ImageIcon");
            	var top = drop_img.css("top").replace(/px/, ""); //取出截取框到顶部的距离
           		var left = drop_img.css("left").replace(/px/, ""); //取出截取框到左边的距离
            	drop_img.css({left: (parseInt(self.position.left) + LEFT_EDGE) + "px", top: (parseInt(self.position.top) + TOP_EDGE) + "px" }); //同时移动
           
				valuewrite(parseInt(self.position.left),parseInt(self.position.top),oldWidth,oldHeight);        }
    		}
    	);
  		
    	//设置图片可拖拽，并且拖拽一张图片时，同时移动另外一张图片
    	$("#ImageIcon").draggable(
    		{
        		cursor: 'move',
        		drag: function(e, ui) {
           		var self = $(this).data("draggable");
            	var drop_img = $("#ImageDrag");
            	var top = drop_img.css("top").replace(/px/, ""); //取出截取框到顶部的距离
            	var left = drop_img.css("left").replace(/px/, ""); //取出截取框到左边的距离
            	drop_img.css({ left: (parseInt(self.position.left) - LEFT_EDGE) + "px", top: (parseInt(self.position.top) - TOP_EDGE) + "px" }); //同时移动
				valuewrite(parseInt(self.position.left) - LEFT_EDGE,parseInt(self.position.top) - TOP_EDGE,oldWidth,oldHeight);
        		}
    		}
    	);
	}


	function valuewrite(left,top,currentWidth,currentHeight){

		var img_x=left>0 && left<ICON_WIDTH?0:0-left;
		var dst_x=left<=0 || left>=ICON_WIDTH?0:left;

		var img_y=top>0 && top<ICON_HEIGHT?0:0-top;
		var dst_y=top<=0 || top>=ICON_HEIGHT?0:top;

		var img_w='';
		var dst_w='';


		if(ICON_WIDTH>currentWidth){
			if(left>0 && left<ICON_WIDTH-currentWidth){
				img_w=currentWidth;
				dst_w=currentWidth;
			}else if(left>ICON_WIDTH || left<-currentWidth){
				//alert("d");
				img_w=0;
				dst_w=ICON_WIDTH;
			}else if(left>0 && left<ICON_WIDTH){
				img_w=ICON_WIDTH-left;
				
				dst_w=ICON_WIDTH-left;
			}else{
				img_w=currentWidth+left;
				
				dst_w=currentWidth+left;
			}
		}else{
			if(left<=0 && left>=0-(currentWidth-ICON_WIDTH)){
				img_w=ICON_WIDTH;
				dst_w=ICON_WIDTH;
			}else if(left>ICON_WIDTH || left<0-currentWidth){
				img_w=0;
				dst_w=ICON_WIDTH;
			}else if(left>0 && left<ICON_WIDTH){
				img_w=ICON_WIDTH-left;
				
				dst_w=ICON_WIDTH-left;
			}else{
				img_w=currentWidth+left;
				
				dst_w=currentWidth+left;
			}
		}

		var img_h='';
		var dst_h='';

		if(ICON_HEIGHT>currentHeight){
			if(top>0 && top<ICON_HEIGHT-currentHeight){
				img_h=currentHeight;
				dst_h=currentHeight;
			}else if(top>ICON_WIDTH || top<0-currentHeight){
				img_h=0;
				dst_h=ICON_HEIGHT;
			}else if(top>0 && top<ICON_HEIGHT){
				img_h=ICON_HEIGHT-top;
				
				dst_h=ICON_HEIGHT-top;
			}else{
				img_h=currentHeight+top;
				
				dst_h=currentHeight+top;
			}
		}else{
			if(top<=0 && top>=0-(currentHeight-ICON_HEIGHT)){
				img_h=ICON_HEIGHT;
				dst_h=ICON_HEIGHT;
			}else if(top>ICON_WIDTH || top<0-currentHeight){
				img_h=0;
				dst_h=ICON_HEIGHT;
			}else if(top>0 && top<ICON_HEIGHT){
				img_h=ICON_HEIGHT-top;
				
				dst_h=ICON_HEIGHT-top;
			}else{
				img_h=currentHeight+top;
				
				dst_h=currentHeight+top;
			}
		}

		$("#left").val(left);
		$("#top").val(top);
		$("#f").val(scaleFactor);
		$("#width").val(currentWidth);
		$("#height").val(currentHeight);

		$("#img_x").val(img_x/scaleFactor);
		$("#img_y").val(img_y/scaleFactor);
		$("#img_w").val(img_w/scaleFactor);
		$("#img_h").val(img_h/scaleFactor);
		$("#dst_x").val(dst_x);
		$("#dst_y").val(dst_y);
		$("#dst_w").val(dst_w);
		$("#dst_h").val(dst_h);

	}
	function ckeckThumb(){
		if($("#left").val()>ICON_WIDTH || $("#left").val()<-$("#width").val() || $("#top").val()>ICON_HEIGHT || $("#top").val()<-$("#height").val() ){
			alert("没有选取任何图像！");
			return false;
		}
	}
	function submitSrc2(){
/* 		document.getElementById('cutSave').style.display = "block";
		document.getElementById('cutAgain').style.display = "none";	
		document.getElementById('uploadtooltip').style.display = "none";
		document.getElementById('Canvas').style.display = "block";
		document.getElementById('mirDiv').style.display = "block"; */	
	} 
	//图片上传
	function submitSrc() {		
		//document.forms[0].action="http://localhost:8080/JspCamera/ajax";
		var src1 = document.getElementById('ImageDrag').src;
        var src2 = document.getElementById('ImageIcon').src;
        var src3 = document.getElementById('imgForHidden').src;        
		if(src1===src3 || src2 ===src3 || $("#left").val()>ICON_WIDTH || $("#left").val()<-$("#width").val() || $("#top").val()>ICON_HEIGHT || $("#top").val()<-$("#height").val() ){
			alert("没有选取任何图像！");
		}else{
			var data = document.getElementById('picData1').value;
			var id = document.getElementById('id').value;
			var msg1 = id+"@"+data+"@"+".jpeg";
			//myAjax("camera_saveBigPic.do",msg);
			
			//document.forms[0].submit();
			var id = document.getElementById('id').value;
			var x = document.getElementById('img_x').value;
			var y = document.getElementById('img_y').value;
			var w = document.getElementById('img_w').value;
			var h = document.getElementById('img_h').value;
			var msg = id + "@" + x + "@" + y + "@" + w + "@"+h;
			$.ajax({
				url: "camera_saveCutPic.do",
				type: 'post',
				//dataType:'json',
				data: {"msg":msg,"msg1":msg1},				
				success: function(data){
					if(data === "error"){
						alert("保存失败，请重新提交");
					}
					document.getElementById('smallImage').src = "";
					document.getElementById('smallImage').src = data;
/* 					document.getElementById('uploadtooltip').style.display = "block";
					document.getElementById('Canvas').style.display = "none";
					document.getElementById('mirDiv').style.display = "none";
					document.getElementById('cutSave').style.display = "none";
					document.getElementById('cutAgain').style.display = "block"; */			 
					
				},
				error: function(data){
					alert("剪切图片失败，请重试");
				}
		    });
		}		
	}
	//调整图片的灰度
	function gray(){
		 var canvas = document.createElement('canvas'); //建立canvas js DOM元素
	     canvas.width = 640;
	     canvas.height = 480;
	     var ctx = canvas.getContext('2d');
	     var data = PS.gray(ctx,dataImg);
	     console.log("gray data:" + data);
	     ctx.putImageData(data, 0, 0);
	     dataURL = canvas.toDataURL("image/jpeg");
	     document.getElementById('ImageDrag').src = dataURL;
	     document.getElementById('ImageIcon').src = dataURL;
	}
	//调整图片的亮度
	var times = 0;
	var dataImage = null;
	function light(){	
		 if(times===0){
			 dataImage = dataImg;
		}		
		 var canvas = document.createElement('canvas'); //建立canvas js DOM元素
	     canvas.width = 640;
	     canvas.height = 480;
	     var ctx = canvas.getContext('2d');
	     var data = PS.highlight(ctx,dataImage,5);	    
	     ctx.putImageData(data, 0, 0);
	     dataURL = canvas.toDataURL("image/jpeg");
	     console.log("light dataURL:" + dataURL);
	     document.getElementById('ImageDrag').src = '';
	     document.getElementById('ImageIcon').src = '';
	     document.getElementById('ImageDrag').src = dataURL;
	     document.getElementById('ImageIcon').src = dataURL;
	     document.getElementById('picData1').value = "";
	     document.getElementById('picData1').value = dataURL.substr(22);
	     dataImage = ctx.getImageData(0,0,imgW,imgH);
	     //ctx.clearRect(0,0,imgW,imgH);
	     times=1;
	}
	//调整图片的对比度
	//var times1 = 0;
	var dataImage = null;
	function contranst(){	
		 if(times===0){
			 dataImage = dataImg;
			}		
		 var canvas = document.createElement('canvas'); //建立canvas js DOM元素
	     canvas.width = 640;
	     canvas.height = 480;
	     var ctx = canvas.getContext('2d');
	     var data = PS.contranst(ctx,dataImage,1.1);
	     console.log("gray data:" + data);
	     ctx.putImageData(data, 0, 0);
	     dataURL = canvas.toDataURL("image/jpeg");
	     document.getElementById('ImageDrag').src = dataURL;
	     document.getElementById('ImageIcon').src = dataURL;
	     document.getElementById('picData1').value = "";
	     document.getElementById('picData1').value = dataURL.substr(22);	     
	     dataImage = ctx.getImageData(0,0,imgW,imgH);
	     times=1;
	     //times1=1;
	}
	//重置剪切框中的图片为原始图片
	function reset(){
		document.getElementById('ImageDrag').src = imgData;
	    document.getElementById('ImageIcon').src = imgData;
	    document.getElementById('picData1').value = "";
	    document.getElementById('picData1').value = imgData.substr(22);
	    times = 0;
	    times1 = 0;
	    dataImage = null;
	    dataImage1 = null;
	}
	</script>		 
</body>
</html>