/**
 * 创建一个悬浮层，支持上、下、左、右、右中、左中浮动
 * $(".customer").tinyFloat({position:"rm"}); //右中位置浮动
   <div class="customer"><a href=""><img width="105" height="205" border="0" src="kefu.png" alt="" /></a></div>
 */
(function($) {  
	$.fn.tinyFloat= function(options){
		  var defaults = {     
		   delay : 1000,//延迟
			offset : {//位置偏移
				left : 0,
				right : 0,
				top : 0,
				bottom : 0
			},
			style : null, //样式
			width:100,  //宽度
			height:200, //高度
			position:"rm" //位置
		};     
		var opts = $.extend(defaults, options); 
		var winW = $(window).width();
		var winH = $(window).height();
		 //根据参数获取位置数值
		function getPosition($applyTo,position){
			var _pos = null;
			switch(position){
				case "rm" : //右侧中间
					$applyTo.data("offset","right");
					$applyTo.data("offsetPostion",opts.offset.right);
					_pos = {right:opts.offset.right,top:winH/2-$applyTo.innerHeight()/2};
				break;
				case "lm" ://左侧中间
					$applyTo.data("offset","left");
					$applyTo.data("offsetPostion",opts.offset.left);
					_pos = {left:opts.offset.left,top:winH/2-$applyTo.innerHeight()/2};
				break;
				case "rb" ://右侧底部
					_pos = {right:opts.offset.right,top:winH - $applyTo.innerHeight()};
				break;
				case "lb" ://左侧底部
					_pos = {left:opts.offset.left,top:winH - $applyTo.innerHeight()};
				break;
				case "l" : 
					_pos = {left:opts.offset.left,top:opts.offset.top};
				break;
				case "r" : 
					_pos = {right:opts.offset.right,top:opts.offset.top};
				break;				
				case "t" :
					$applyTo.data("offset","top");
					$applyTo.data("offsetPostion",opts.offset.top);					
					_pos = {left:opts.offset.left,top:opts.offset.top};
				break;
				case "b" :
					$applyTo.data("offset","bottom");
					$applyTo.data("offsetPostion",opts.offset.bottom);					
					_pos = {left:opts.offset.left,top:winH - $applyTo.innerHeight()};				
				break;
			}
			return _pos;
		}
		//设置容器位置
		function setPosition($applyTo,position,isUseAnimate){
			var scrollTop = $(window).scrollTop();
			var scrollLeft = $(window).scrollLeft();
			var _pos = getPosition($applyTo,position);
			_pos.top += scrollTop;
			isUseAnimate && $applyTo.stop().animate(_pos,opts.delay) || $applyTo.css(_pos);
		} 
		return this.each(function(){
			var $this =  $(this);
			$this.css("position","absolute");
			opts.style && $this.css(opts.style);
			setPosition($this,opts.position);
			$(this).data("isAllowScroll",true);
			$(window).scroll(function(){
				$this.data("isAllowScroll") && setPosition($this,opts.position,true);
			});
		})	
  }
})(jQuery); 