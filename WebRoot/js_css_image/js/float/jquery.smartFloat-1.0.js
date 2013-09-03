/**
 * divc始终在一个固定的位置
 * $("#float").smartFloat();
 *  <div id="float" style="margin:50px 1% 0 1%"></div>
 */
$.fn.smartFloat = function() {
	var position = function(element) {
		var top = element.position().top, pos = element.css("position");
		$(window).scroll(function() {
			var scrolls = $(this).scrollTop();
			if (scrolls > top) {
				if (window.XMLHttpRequest) {
					element.css({
						position: "fixed",
						top: 0
					});	
				} else {
					element.css({
						top: scrolls
					});	
				}
			}else {
				element.css({
					position: pos,
					top: top
				});	
			}
		});
    };
	return $(this).each(function() {
		alert("22");
		position($(this));						 
	});
};