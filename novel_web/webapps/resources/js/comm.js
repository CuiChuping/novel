/**
 * common method
 */
"use strict";
var initImageEvent = function() {
	$("img").one('error', function() {
		this.src = "http://www.lingdiankanshu.com/img/0/527/527s.jpg";
	});
	$(window).resize(function() {
		$("img.books").height(function() {
			return $(this).width() / 3 * 4;
		});
	}).resize();
};
var initButtonEvent = function() {
	$("[data-refresh]").click(function() {
		location.reload();
	});
};

/**
 * common init
 */
$(function() {
	initImageEvent();
	initButtonEvent();
});
