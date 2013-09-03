var _SiteUrl = '';
$(function () {
    //ͼƬ��ʱ���أ�����������ִ�С�
    //$("img.lazy").lazyload();

    //����ͼ
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
            var sWidth = o.width(); //��ȡ����ͼ�Ŀ�ȣ���ʾ�����
            var len = $("ul li", o).length; //��ȡ����ͼ����
            if (len < 2) { return; }
            var lis = $("img", o);
            var index = 0;
            var picTimer;

            //������ְ�ť�Ͱ�ť��İ�͸������������һҳ����һҳ������ť
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

            //ΪС��ť�����껬���¼�������ʾ��Ӧ������
            $(".btn li", o).mouseenter(function () {
                index = $(".btn li", o).index(this);
                showPics(index);
            }).eq(0).trigger("mouseenter");

            //��һҳ����һҳ��ť͸���ȴ���
            if (opt.opacity) {
                $(".preNext", o).css("opacity", opt.opacity).hover(function () {
                    $(this).stop(true, false).animate({ "opacity": "0.5" }, 300);
                }, function () {
                    $(this).stop(true, false).animate({ "opacity": "0.2" }, 300);
                });
            }
            //��һҳ��ť
            $(".pre", o).click(function () {
                index -= 1;
                if (index == -1) { index = len - 1; }
                showPics(index);
            });

            //��һҳ��ť
            $(".next", o).click(function () {
                index += 1;
                if (index == len) { index = 0; }
                showPics(index);
            });

            //����Ϊ���ҹ�����������liԪ�ض�����ͬһ�����󸡶�������������Ҫ�������ΧulԪ�صĿ��
            $("ul", o).css("width", sWidth * (len));

            //��껬�Ͻ���ͼʱֹͣ�Զ����ţ�����ʱ��ʼ�Զ�����
            o.hover(function () {
                clearInterval(picTimer);
            }, function () {
                picTimer = setInterval(function () {
                    showPics(index);
                    index++;
                    if (index == len) { index = 0; }
                }, opt.speed); 
            }).trigger("mouseleave");

            //��ʾͼƬ���������ݽ��յ�indexֵ��ʾ��Ӧ������
            function showPics(index) { //��ͨ�л�
                var nowLeft = -index * sWidth; //����indexֵ����ulԪ�ص�leftֵ
                $("ul", o).stop(true, false).animate({ "left": nowLeft }, 300); //ͨ��animate()����ulԪ�ع������������position
                $(".btn li", o).stop(true, false).removeClass('select').eq(index).addClass('select')
            }

        })
    }

    //tab�л�Ч��
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
    //չ���رղ�
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

    //��ȡ400�绰
    load('.phone400', '/api/phone400');
    //���ص�¼��Ϣ
    load('.login-info', '/account/loginfo');
    //��̬���ؼ۸�
    showPrices();
})

//дcookies
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

//��ȡcookies
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

//ɾ��cookies
function deleteCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

//����ҳ��htmlƬ��
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

//��ʾ��ʾ��Ϣ
function showMessage(msg) {
    alert(msg);
}

//��ʾȷ��
function showConfirm(msg) {
    return confirm(msg);
}

//��ʾҳ���ϵ���ʾ��Ϣ
function showPageAlart(eleId) {
    var msg = $('#' + eleId).val();
    if (msg.length > 0) {
        showMessage(msg);
    }
}

//��̬���ؼ۸�
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

//������֤��ͼƬ
function reloadVCode(ele, l) {
    if ((typeof l) == undefined) {
        l = '';
    }
    $(ele).attr('src', _SiteUrl + '/account/validate/' + l + '?d=' + Math.random());
}


//����
function showDialog(opt) {
    var opts = $.extend({
        width: 600,
        height: 500,
        className: null,
        el: null,
        title: null,             //����
        param: null,             //ajax���Ӳ���
        callback: null,          //���ݼ�����ɻص�����
        time: null               //�Զ���ʧʱ��
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
//�رյ���
function closeDialog() {
    $('.dialog').fadeOut('fast');
    closeMask();
    return false;
}
//��ʾ�ڵ���
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
//�ر��ڵ���
function closeMask() {
    $(".dialog-mask").hide();
}

//��¼
function login() {
    var loginUrl = '/account/login';
    var url = window.location.href.toLowerCase();
    if (url.indexOf(loginUrl) > 0) {
        return;
    }

    window.location.href = _SiteUrl + loginUrl + '?url=' + decodeURI(url);
}

//�˳���¼
function logout() {
    load('.login-info', '/account/logout');
}

//�����ղ�
function AddFavorite() { if (document.all) { window.external.addFavorite(location.href, document.title); } else if (window.sidebar) { window.sidebar.addPanel(document.title, location.href, ""); } return false; }


/*��Ʒ�Ա�*/
function deletePro(productId) {
    var url = location.href.split('#')[0];
    var num = url.substring(url.indexOf('=') + 1, url.length);
    var ids = num.split(','); //ids��űȽϵ����в�ƷID
    if (ids.length <= 2) {
        alert("����ɾ�����Ѿ������һ���ȽϵĲ�Ʒ!");
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
//��ӡ
function doPrint() {

    window.print();

}
//������֤
function checkEmail(val) {
    var result = true;
    var reg = new RegExp(/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/i);
    if (!reg.test(val)) {
        result = false;
    }
    return result;
}
//��ʾ����
//Ԫ������Զ������� tip="img/text" tipcnt="ͼƬ��ַ/��ʾ����" ����ѡ tipleft='�뵱ǰԪ�غ���ƫ��ֵ' tiptop='�뵱ǰԪ������ƫ��ֵ' imgw='ͼƬ���' imgh="ͼƬ�߶�"��
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
//�رո���
function closeTip() {
    $('.dialog-tips').hide();
}

$('.see-group').click(showDatePrice);
$('.ico-date').click(showDatePrice);
//�л�����
var citylayer = $('.logo-city');
$('#header .yex-logo-info img').click(function () {
    citylayer.show();
    return false;
})
citylayer.click(function (e) { e.stopPropagation(); })

$(document).click(function () { citylayer.hide() })

//�������ڼ۸񵯲�
function showDatePrice() {
    var now = new Date(), lineId = $(this).attr('pid') == undefined ? $(this).parents('li:first').attr('pid') : $(this).attr('pid'), date = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
    showDialog({ el: '/tour/GetDatePrice', param: { lineId: lineId, date: date }, title: '�������ڼ��۸�', callback: function () { bindNextDatePrice(lineId) } });
    return false;
}
//�󶨻���
function bindNextDatePrice(lineId) {
    $('.dialog .calendar').attr('pid', lineId);
    $('.nextDatePrice').click(changeMonthDatePrice);
    $('.preDatePrice').click(changeMonthDatePrice);
}
//����鿴��һ���·�
function changeMonthDatePrice(date) {
    var $this = $(this);
    var lineId = $this.parents('.calendar:first').attr('pid'), date = $this.attr('date');
    $.post('/tour/GetDatePrice', { lineId: lineId, date: date }, function (d) {
        $this.parents('.bd:first').html(d);
        bindNextDatePrice(lineId)
    })
}
// ��� placeholder ֧��
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

/*logo����֪ͨ*/
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
        if (!isData(num)) { retMeg = "���֤��������Ĳ�������"; return retMeg; }
    }
    else if (len == 18) {
        if (num.substring(17, 18) != "X" && !isData(num.substring(17, 18)) && num.substring(17, 18) != "0") {
            retMeg = "18λ���֤�����һλ���������ֻ��дX"; return retMeg;
        }
        else if (!isDigit(num.substring(0, 17))) {
            retMeg = "18λ���֤��ǰ17λ����������"; return retMeg;
        }
    }
    if (len == 15)
        re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
    else if (len == 18)
        re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d|X)$/);
    else { retMeg = "���֤�������������λ������"; return retMeg; }


    var aCity = { 11: "����", 12: "���", 13: "�ӱ�", 14: "ɽ��", 15: "���ɹ�", 21: "����", 22: "����", 23: "������", 31: "�Ϻ�", 32: "����",
        33: "�㽭", 34: "����", 35: "����", 36: "����", 37: "ɽ��", 41: "����", 42: "����", 43: "����", 44: "�㶫", 45: "����", 46: "����",
        50: "����", 51: "�Ĵ�", 52: "����", 53: "����", 54: "����", 61: "����", 62: "����", 63: "�ຣ", 64: "����", 65: "�½�", 71: "̨��",
        81: "���", 82: "����", 91: "����"
    };
    if (aCity[parseInt(num.substr(0, 2))] == null) { retMeg = "���֤�����Ƿ�"; return retMeg; }

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
        { retMeg = "���ĳ���������������"; return retMeg; }
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
                retMeg = "���ĳ���������������";
                return retMeg;
            }
        }
        else {
            retMeg = "���ĳ���������������";
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


//�Ƿ�����
function isData(s) {
    if (isNaN(parseInt(s)) == true) {
        return false;
    } else {
        var pattern = /(^[0-9]*[1-9][0-9]*$)/;
        return pattern.exec(s);
    }
}




//�ֻ���֤

function checkMobile(obj) {
    var tmp = /^1[3-9]\d{9}$/;     //֧��11λ�ֻ�������֤
    return tmp.test(obj);
}
//�̶��绰
function checkPhone(obj) {
    var pattern = new RegExp(/^[0-9-+]+$/);
    return pattern.test(obj);
}

function checkUsername(obj) {
    //��ǩ����ֻ�ܰ���Ӣ����ĸ������,�»��ߡ�_���ͺ�ܡ�-��,��ֻ������ĸ��ͷ
    if (obj.length < 2 || obj.length > 20)
        return false;
    var pat = /^(?!_)(?!.*?_$)[a-zA-Z\u4e00-\u9fa5]+$/;
    return pat.test(obj);

}

//У���Ƿ�ȫ���������
function isDigit(s) {
    var patrn = /^[0-9]{1,20}$/;
    if (!patrn.exec(s)) return false
    return true
}

//У���¼����ֻ������5-20������ĸ��ͷ���ɴ����֡���_������.�����ִ�
function isRegisterUserName(s) {
    var patrn = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s)) return false
    return true
}

//У���û�������ֻ������1-30������ĸ��ͷ���ִ�
function isTrueName(s) {
    var patrn = /^[a-zA-Z]{1,30}$/;
    if (!patrn.exec(s)) return false
    return true
}

//У�����룺ֻ������6-12����ĸ�����֡��»���
function isPasswd(s) {
    var patrn = /^(\w){6,16}$/;
    if (!patrn.exec(s)) return false
    return true
}

//У����ͨ�绰��������룺���ԡ�+����ͷ���������⣬�ɺ��С�-��
function isTel(s) {
    var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}

//У���ֻ����룺���������ֿ�ͷ���������⣬�ɺ��С�-��
function isMobil(s) {
    var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s)) return false
    return true
}

//У����������
function isPostalCode(s) {
    if (s == "")
        return true;
    var patrn = /^\d{6}$/;
    if (!patrn.exec(s)) return false
    return true
}