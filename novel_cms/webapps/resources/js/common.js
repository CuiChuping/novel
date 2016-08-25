/**
 * 公共类
 */
$(document).ready(function(){

	var _draw = function() {
        var windowHeight=$(window).innerHeight();
        var leftNavHeight=windowHeight-$(".header").height()-20;
        $(".left_nav").height(leftNavHeight);
        $(".right-content").height(leftNavHeight+8);
        $('.tableDiv').height($(".right-content").height()-$('.lujing').outerHeight()-$('.handleBtn').outerHeight(true)-79);
        //固定表头
        var $oriTh=$(".originalTr>th");
        var $fixTh=$(".fixedTr>th");
        $oriTh.each(function(index,ele){
            $fixTh.eq(index).width( $(this).width());
        });
        $(".fixedThead").show();
    };

    var _dropDownMenu = function (_this) {
    	var _img = $(_this).prev("img");
        _img.attr("src", Core.path("./.." + _img.attr("data-down-icon")));
        $(_this).attr("data-selected", "true");
        $(_this).parent().removeClass("close-up").addClass("drop-down");
    };

    var _closeUpMenu = function (_this) {
    	var _img = $(_this).prev("img");
        _img.attr("src", Core.path("./.." + _img.attr("data-up-icon")));
        $(_this).removeAttr("data-selected");
        $(_this).parent().removeClass("drop-down").addClass("close-up");
    };

    var _btnToggle = function() {
        $(".btnToggle").click(function(){
            var $NavToggle=$('.NavToggle');
            var $img=$NavToggle.css("background-image");
            var imgName=$img.substring( $img.length - 11, $img.length-1);
            var exg=/ne01/;
            var $title=$(".panel-title");
            var $leftNav=$(".left_nav");
            if(exg.test(imgName)){
                $title.hide();
                $NavToggle.css("background-image","url(" + Core.path("./img/line02.png") + ")").width(70);
                $leftNav.width(70);
                $(".subMenu").removeClass("in");
                $title.each(function() {
                    if($(this).attr("choose")){
                    	_closeUpMenu(this);
                    }
                });
            } else {
                $title.show();
                $NavToggle.css("background-image","url(" + Core.path("./img/line01.png") + ")").width(212);
                $leftNav.width(212);
            }
        });
    };

    var _menu = function() {
        $(".left_nav li").click(function () {
        	$(".left_nav li").removeClass('activeStyle');
        	$(this).addClass('activeStyle');
        });

        $(".panel-title").click (function () {
        	if($(this).attr("data-selected") == 'true'){
            	_closeUpMenu(this);
            } else {
            	$(".panel-title").each(function() {
                    if($(this).attr("data-selected") == 'true') _closeUpMenu(this);
                });
            	_dropDownMenu(this);
            }
        });
    };

    var _markedAll = function() {
    	$("input[name=markedAll]").click(function () {
    	   if (this.checked) {
    		   $("input[name=marked]").each(function () {
    			   this.checked = true;
    			   $(this).parent().parent('tr').addClass('success');
    		   });
    	   } else {
    		   $("input[name=marked]").each(function () {
    			   this.checked = false;
    			   $(this).parent().parent('tr').removeClass('success');
    		   });
    	   }
    	});
    	$("input[name=marked]").click(function () {
    		if(this.checked){
                $(this).parent().parent('tr').addClass('success');
            }else{
                $(this).parent().parent('tr').removeClass('success');
            }
    	});
    };

    (function () {
    	$(window).resize(function() {
        	_draw();
        });
        _draw();
        _btnToggle();
        _menu();
        _markedAll();
    })();
});