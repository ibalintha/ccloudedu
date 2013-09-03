var _SiteUrl = '';
$(function () {
    //图片延时加载，放着最上面执行。
    //$("img.lazy").lazyload();

    //焦点图
    //theme:number/title/thumb
    $.fn.YEXfocus = function (opts) {
        var opt = $.extend({
            speed: 5000,
            direction: 'top',
            eventType: 'click',
            theme: 'number',
            isPre: false,
            isOpacity: false,
            isTotal: false
        }, opts || {});
        return this.each(function () {
            var o = $(this);
            var sWidth = o.width(); //获取焦点图的宽度（显示面积）
            var len = $("ul li", o).length; //获取焦点图个数
            if (len < 2) { return; }
            var lis = $("img", o);
            var index = 0;
            var picTimer;

            //添加数字按钮和按钮后的半透明条，还有上一页、下一页两个按钮
            var btn = "<ol class='btn'>";
            for (var i = 0; i < len; i++) {
                switch (opt.theme) {
                    case 'title':
                        btn += '<li>' + lis.eq(i).attr('alt') + '</li>';
                        break;
                    case 'thumb':
                        btn += '<li><img src="' + lis.eq(i).attr('src') + '"/></li>';
                        break;
                    case 'number':
                        btn += '<li>' + (i + 1) + '</li>';
                        break;
                }
            }
            btn += "</ol>";
            if (opt.isPre) {
                btn += '<div class="preNext pre"></div><div class="preNext next"></div>';
            }
            if (opt.isPre) {
                btn += '<div class="total">/'+len+'</div>';
            }
            o.append(btn);

            //为小按钮添加鼠标滑入事件，以显示相应的内容
            $(".btn li", o).mouseenter(function () {
                index = $(".btn li", o).index(this);
                showPics(index);
            }).eq(0).trigger("mouseenter");

            //上一页、下一页按钮透明度处理
            if (opt.opacity) {
                $(".preNext", o).css("opacity", opt.opacity).hover(function () {
                    $(this).stop(true, false).animate({ "opacity": "0.5" }, 300);
                }, function () {
                    $(this).stop(true, false).animate({ "opacity": "0.2" }, 300);
                });
            }
            //上一页按钮
            $(".pre", o).click(function () {
                index -= 1;
                if (index == -1) { index = len - 1; }
                showPics(index);
            });

            //下一页按钮
            $(".next", o).click(function () {
                index += 1;
                if (index == len) { index = 0; }
                showPics(index);
            });

            //本例为左右滚动，即所有li元素都是在同一排向左浮动，所以这里需要计算出外围ul元素的宽度
            $("ul", o).css("width", sWidth * (len));

            //鼠标滑上焦点图时停止自动播放，滑出时开始自动播放
            o.hover(function () {
                clearInterval(picTimer);
            }, function () {
                picTimer = setInterval(function () {
                    showPics(index);
                    index++;
                    if (index == len) { index = 0; }
                }, opt.speed); 
            }).trigger("mouseleave");

            //显示图片函数，根据接收的index值显示相应的内容
            function showPics(index) { //普通切换
                var nowLeft = -index * sWidth; //根据index值计算ul元素的left值
                $("ul", o).stop(true, false).animate({ "left": nowLeft }, 300); //通过animate()调整ul元素滚动到计算出的position
                $(".btn li", o).stop(true, false).removeClass('select').eq(index).addClass('select')
            }

        })
    }

    //tab切换效果
    function fnTabs() {
        var $this = $(this);
        var onePanels = $this.parents(".Jtab:first").find('.Jtab-panel:first');
        var panels = onePanels.siblings('.Jtab-panel').add(onePanels);
        $this.siblings("li").removeClass("select");
        $this.addClass("select");
        panels.removeClass('select');
        panels.eq($this.index()).addClass("select");
        if ($this.parents('.regist').length > 0) {
            reloadVCode('img[name=imgEcode]');
        }
        return false;
    }
    //展开关闭层
    function fnSlideUpDown(e) {
        var btn = $(this);
        var area = $(this).parents('*[role="slide-area"]');
        var index = 0;
        if (area.length === 0) { area = $('body') };
        var con;
        if ($(this).attr('slideIndex')) {
            index = $(this).attr('slideIndex');
            con = area.find('*[role="slide-con"][slideIndex="' + index + '"]');
        } else {
            con = area.find('*[role="slide-con"]')
        }
        if (con.is(':hidden')) {
            con.show()
            //con.slideDown();
            btn.addClass('slide-btn-close').removeClass('slide-btn-open');
        } else {
            con.hide();
            //con.slideUp();			
            btn.removeClass('slide-btn-close').addClass('slide-btn-open');
        }
        if ($(this).is('a')) {
            return false;
        }
    }

    $('.attraction').YEXfocus({ theme: 'title' });
    $('.cmnfocus').YEXfocus({ theme: 'title' });
    $('.trip-fcs').YEXfocus({ isPre: true });
    $('.dest-focus').YEXfocus({ isPre: true,isTotal:true });
    $('.theme-focus').YEXfocus({ theme: 'thumb' });
    $('.slide-btn').click(fnSlideUpDown);
    $(".Jtab-control > li").click(fnTabs);
    $(".Jtab-control > li").hover(function () {
        $(this).toggleClass('hover')
    });
    $('#header .favorite').click(AddFavorite);

    //获取400电话
    load('.phone400', '/api/phone400');
    //加载登录信息
    load('.login-info', '/account/loginfo');
    //动态加载价格
    showPrices();
})

//写cookies
function setCookie(value, name, key) {
    var Days = 2;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    if (key == null || key == "") {
        document.cookie = name + "=" + encodeURI(value) + ";expires=" + exp.toGMTString() + ";path=/";
    }
    else {
        var nameValue = getCookie(name);
        if (nameValue == "") {
            document.cookie = name + "=" + key + "=" + encodeURI(value) + ";expires=" + exp.toGMTString() + ";path=/";
        }
        else {
            var keyValue = getCookie(name, key);
            if (keyValue != "") {
                nameValue = nameValue.replace(key + "=" + keyValue, key + "=" + encodeURI(value));
                document.cookie = name + "=" + nameValue + ";expires=" + exp.toGMTString() + ";path=/";
            }
            else {
                document.cookie = name + "=" + nameValue + "&" + key + "=" + encodeURI(value) + ";expires=" + exp.toGMTString() + ";path=/";
            }
        }
    }
}

//读取cookies
function getCookie(name, key) {
    var nameValue = "";
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)) {
        nameValue = decodeURI(arr[2]);
    }
    if (key != null && key != "") {
        reg = new RegExp("(^| |&)" + key + "=([^(;|&|=)]*)(&|$)");
        if (arr = nameValue.match(reg)) {
            alert(decodeURI(arr[2])); return decodeURI(arr[2]);
        }
        else return "";
    }
    else {
        return nameValue;
    }
}

//删除cookies
function deleteCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

//加载页面html片段
function load(element, url, data) {
    var r = '?';
    if (url.indexOf('?') > 0) {
        r = '&';
    }
    url += r + 'randomnumber=' + Math.random();
    $.getJSON(_SiteUrl + url, data, function (d) {
        $(element).html(d);
    });
}

//显示提示信息
function showMessage(msg) {
    alert(msg);
}

//显示确认
function showConfirm(msg) {
    return confirm(msg);
}

//显示页面上的提示信息
function showPageAlart(eleId) {
    var msg = $('#' + eleId).val();
    if (msg.length > 0) {
        showMessage(msg);
    }
}

//动态加载价格
function showPrices() {
    var ids = '';
    $("span[name^='price-']").each(function (i, ele) {
        ids += $(ele).attr('name').replace('price-', ',');
    });
    if (ids.length == 0) {
        return;
    }

    $.getJSON(_SiteUrl + '/api/prices', { id: ids.substr(1) }, function (d) {
        for (var i = 0; i < d.length; i++) {
            $('span[name="price-' + d[i].id + '"]').html(d[i].price);
        }
    });
}

//加载验证码图片
function reloadVCode(ele, l) {
    if ((typeof l) == undefined) {
        l = '';
    }
    $(ele).attr('src', _SiteUrl + '/account/validate/' + l + '?d=' + Math.random());
}


//弹窗
function showDialog(opt) {
    var opts = $.extend({
        width: 600,
        height: 500,
        className: null,
        el: null,
        title: null,             //标题
        param: null,             //ajax附加参数
        callback: null,          //数据加载完成回调函数
        time: null               //自动消失时间
    }, opt || {});
    var htmls = '';
    var str = '<div class="dialog"><div class="hd"><h4>' + (opts.title == null ? '' : opts.title) + '</h4><a class="ico-close"></a></div><div class="bd"></div></div>';
    $('body').append(str);
    var de = document.documentElement;
    var w = self.innerWidth || (de && de.clientWidth) || document.body.clientWidth;
    var h = self.innerHeight || (de && de.clientHeight) || document.body.clientHeight;
    $(".dialog").css({ width: opts.width + 'px', height: opts.height + 'px', left: ((w - opts.width) / 2) + "px", top: ((h - opts.height) / 2 + de.scrollTop) + "px" });
    if (opts.className != null) { $(".dialog").addClass(opts.className) };
    showMask();
    if (opts.el.constructor == String) {
        $.post(opts.el, opts.param, function (d) {
            htmls = d;
            $('.dialog .bd').append(htmls);
            if (opts.callback != null) {
                opts.callback();
            }
        })
    } else {
        htmls = opts.el;
        htmls.show();
        $('.dialog .bd').append(htmls);
        if (opts.callback != null) {
            opts.callback();
        }
    }
    $('.dialog .ico-close').unbind('click').click(closeDialog);
    $('.dialog .btn-close').unbind('click').click(closeDialog);
    if (opts.time != null) {
        setTimeout(closeDialog, opts.time)
    }
    return false;
}
//关闭弹窗
function closeDialog() {
    $('.dialog').fadeOut('fast');
    closeMask();
    return false;
}
//显示遮挡层
function showMask() {
    if ($('.dialog-mask').length == 0) {
        var str = '<div class="dialog-mask"></div>';
        if (window.innerHeight && window.scrollMaxY) {
            yScroll = window.innerHeight + window.scrollMaxY;
        } else if (document.body.scrollHeight > document.body.offsetHeight) {
            yScroll = document.body.scrollHeight;
        } else {
            yScroll = document.body.offsetHeight;
        }
        $('body').append(str);
        $(".dialog-mask").css({ height: yScroll + "px", opacity: 0.5 });
    } else {
        $('.dialog-mask').show();
    }
}
//关闭遮挡层
function closeMask() {
    $(".dialog-mask").hide();
}

//登录
function login() {
    var loginUrl = '/account/login';
    var url = window.location.href.toLowerCase();
    if (url.indexOf(loginUrl) > 0) {
        return;
    }

    window.location.href = _SiteUrl + loginUrl + '?url=' + decodeURI(url);
}

//退出登录
function logout() {
    load('.login-info', '/account/logout');
}

//加入收藏
function AddFavorite() { if (document.all) { window.external.addFavorite(location.href, document.title); } else if (window.sidebar) { window.sidebar.addPanel(document.title, location.href, ""); } return false; }


/*商品对比*/
function deletePro(productId) {
    var url = location.href.split('#')[0];
    var num = url.substring(url.indexOf('=') + 1, url.length);
    var ids = num.split(','); //ids存放比较的所有产品ID
    if (ids.length <= 2) {
        alert("不能删除，已经是最后一个比较的产品!");
        return;
    }
    var methodUrl = location.href.split('=')[0] + '=';
    var rewriteUrl = methodUrl;
    if (productId == ids[0]) {
        rewriteUrl += (ids[1] + "," + ids[2]);
    }
    else {
        for (i = 1; i < ids.length; i++) {
            if (productId != ids[i]) rewriteUrl += (ids[0] + ("," + ids[i]));
        }
    }
    window.location.href = rewriteUrl;
    return false;
}
//打印
function doPrint() {

    window.print();

}
//邮箱验证
function checkEmail(val) {
    var result = true;
    var reg = new RegExp(/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/i);
    if (!reg.test(val)) {
        result = false;
    }
    return result;
}
//显示浮层
//元素添加自定义属性 tip="img/text" tipcnt="图片地址/提示文字" 【可选 tipleft='与当前元素横向偏移值' tiptop='与当前元素纵向偏移值' imgw='图片宽度' imgh="图片高度"】
function showTip() {
    var tips = null, $this = $(this), top = $this.offset().top, left = $this.offset().left;
    if ($('.dialog-tips').length == 0) {
        $('body').append('<div class="dialog-tips"></div>');
    }
    tips = $('.dialog-tips');
    if ($this.attr('tip', 'img')) {
        w = $this.attr('imgw') == undefined ? 'auto' : $this.attr('imgw');
        h = $this.attr('imgh') == undefined ? 'auto' : $this.attr('imgh');
        tips.html('<img src="' + $this.attr('tipcnt') + '" width="' + w + '" height="' + h + '">');
    } else {
        tips.html($this.attr('tipcnt'));
    }
    if ($this.attr('tipleft') != undefined && parseInt($this.attr('tipleft')) != NaN) {
        left += parseInt($this.attr('tipleft'));
    } else {
        left += $this.width();
    }
    if ($this.attr('tiptop') != undefined && parseInt($this.attr('tiptop')) != NaN) {
        top += parseInt($this.attr('tiptop'));
    } else {
        top += $this.height();
    }
    tips.show().css('position', 'absolute').offset({ left: left, top: top });
    return false;
}
//关闭浮层
function closeTip() {
    $('.dialog-tips').hide();
}

$('.see-group').click(showDatePrice);
$('.ico-date').click(showDatePrice);
//切换城市
var citylayer = $('.logo-city');
$('#header .yex-logo-info img').click(function () {
    citylayer.show();
    return false;
})
citylayer.click(function (e) { e.stopPropagation(); })

$(document).click(function () { citylayer.hide() })

//出发日期价格弹层
function showDatePrice() {
    var now = new Date(), lineId = $(this).attr('pid') == undefined ? $(this).parents('li:first').attr('pid') : $(this).attr('pid'), date = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
    showDialog({ el: '/tour/GetDatePrice', param: { lineId: lineId, date: date }, title: '出发日期及价格', callback: function () { bindNextDatePrice(lineId) } });
    return false;
}
//绑定换月
function bindNextDatePrice(lineId) {
    $('.dialog .calendar').attr('pid', lineId);
    $('.nextDatePrice').click(changeMonthDatePrice);
    $('.preDatePrice').click(changeMonthDatePrice);
}
//浮层查看下一组月份
function changeMonthDatePrice(date) {
    var $this = $(this);
    var lineId = $this.parents('.calendar:first').attr('pid'), date = $this.attr('date');
    $.post('/tour/GetDatePrice', { lineId: lineId, date: date }, function (d) {
        $this.parents('.bd:first').html(d);
        bindNextDatePrice(lineId)
    })
}
// 检测 placeholder 支持
var supportPlaceholder = 'placeholder' in document.createElement('input');
$.fn.placeholder = function () {
    var fnFocus = function () {
        $(this).addClass('ph-wrap-focus').find('input').focus();
    }
    var fnKey = function () {
        this.value != '' ? $(this).parent().addClass('ph-wrap-has') : '';
    }
    var fnBlur = function () {
        if ($.trim(this.value) == '') {
            $(this).parent().removeClass('ph-wrap-has ph-wrap-focus')
            this.value = '';
        }
    }
    return this.each(function () {
        var $this = $(this), dSpan = $('<span/>', { 'class': 'placeholder', text: $this.attr('placeholder') });
        dWrap = $('<div/>', { 'class': 'ph-wrap', click: fnFocus });
        $this.wrap(dWrap)
        $this.before(dSpan);
        $this.bind({ keyup: fnKey, blur: fnBlur });
        if ($.trim(this.value) != '') {
            $this.parent().addClass('ph-wrap-has');
        }
    })
}
if (!supportPlaceholder) {
    $('input:text[placeholder]').placeholder();
}

/*logo更换通知*/
function changelogo() {
    if (getCookie('closelogochange') != 'closelogochange') {
        //$('body').prepend('<div class="sitetop-ad"><div><img src="/images/upfile/ad-logochange-s.jpg"/><span><img src="/images/upfile/sitetop-ad-close.jpg"/></span></div></div>')
    }
    $('.sitetop-ad span').click(function () {
        $('.sitetop-ad').hide();
        setCookie('closelogochange', 'closelogochange');

    })
}
changelogo();


function isIdCardNo(num) {
    var retMeg = '';
    var len = num.length, re;
    if (len == 15) {
        if (!isData(num)) { retMeg = "身份证号码输入的不是数字"; return retMeg; }
    }
    else if (len == 18) {
        if (num.substring(17, 18) != "X" && !isData(num.substring(17, 18)) && num.substring(17, 18) != "0") {
            retMeg = "18位身份证中最后一位请输入数字或大写X"; return retMeg;
        }
        else if (!isDigit(num.substring(0, 17))) {
            retMeg = "18位身份证中前17位请输入数字"; return retMeg;
        }
    }
    if (len == 15)
        re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
    else if (len == 18)
        re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d|X)$/);
    else { retMeg = "身份证号码输入的数字位数不对"; return retMeg; }


    var aCity = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏",
        33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南",
        50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾",
        81: "香港", 82: "澳门", 91: "国外"
    };
    if (aCity[parseInt(num.substr(0, 2))] == null) { retMeg = "身份证地区非法"; return retMeg; }

    var a = num.match(re), F;
    var today = new Date();
    if (a != null) {
        var D = null;
        if (len == 15) {
            D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);
            var B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5];
        }
        else {
            D = new Date(a[3] + "/" + a[4] + "/" + a[5]);
            var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5];
        }
        var StartDate = new Date("1900/01/01");
        if (D < StartDate)
        { retMeg = "您的出生日期输入有误"; return retMeg; }
        if (B) {
            if (a[3] == today.getFullYear()) {
                if (a[4] < (today.getMonth() + 1) && a[5] < today.getDate()) {
                    F = true;
                }
                else {
                    F = false;
                }
            }
            else if (a[3] < today.getFullYear()) {
                F = true;
            }
            else {
                F = false;
            }

            if (!F) {
                retMeg = "您的出生日期输入有误";
                return retMeg;
            }
        }
        else {
            retMeg = "您的出生日期输入有误";
            return retMeg;
        }
    }
    return retMeg;
}

function goMail(to) {
    if (to != "") {
        var email = "http://";
        if (to.toLowerCase().indexOf("yahoo") != -1)
            email += "mail.cn." + to.split("@")[1];
        else if (to.toLowerCase().indexOf("gmail") != -1)
            email += "mail.google.com";
        else if (to.toLowerCase().indexOf("hotmail") != -1)
            email += "www.hotmail.com";
        else
            email += "mail." + to.split("@")[1];

        window.open(email);
    }
}


//是否数字
function isData(s) {
    if (isNaN(parseInt(s)) == true) {
        return false;
    } else {
        var pattern = /(^[0-9]*[1-9][0-9]*$)/;
        return pattern.exec(s);
    }
}




//手机验证

function checkMobile(obj) {
    var tmp = /^1[3-9]\d{9}$/;     //支持11位手机号码验证
    return tmp.test(obj);
}
//固定电话
function checkPhone(obj) {
    var pattern = new RegExp(/^[0-9-+]+$/);
    return pattern.test(obj);
}

function checkUsername(obj) {
    //标签名称只能包含英文字母，数字,下滑线“_”和横杠“-”,且只能以字母开头
    if (obj.length < 2 || obj.length > 20)
        return false;
    var pat = /^(?!_)(?!.*?_$)[a-zA-Z\u4e00-\u9fa5]+$/;
    return pat.test(obj);

}

//校验是否全由数字组成
function isDigit(s) {
    var patrn = /^[0-9]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串
function isRegisterUserName(s) {
    var patrn = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验用户姓名：只能输入1-30个以字母开头的字串
function isTrueName(s) {
    var patrn = /^[a-zA-Z]{1,30}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验密码：只能输入6-12个字母、数字、下划线
function isPasswd(s) {
    var patrn = /^(\w){6,16}$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验普通电话、传真号码：可以“+”开头，除数字外，可含有“-”
function isTel(s) {
    var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验手机号码：必须以数字开头，除数字外，可含有“-”
function isMobil(s) {
    var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}

//校验邮政编码
function isPostalCode(s) {
    if (s == "")
        return true;
    var patrn = /^\d{6}$/;
    if (!patrn.exec(s)) return false
    return true
}