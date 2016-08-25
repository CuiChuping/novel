(function($) {
	"use strict";
	var initImageEvent = function() {
		$("#detail_img").one('error', function() {
			this.src = "http://www.lingdiankanshu.com/img/0/527/527s.jpg";
		});
		$(window).resize(function() {
			$("#detail_img").height(function() {
				return $(this).width() / 3 * 4;
			});
			$("#bg_detail").height($("#detail_img").height() + 30);
			$(".detail").height($("#detail_img").height());
		}).resize();
	};

	var initButtonEvent = function() {
		$("[data-refresh]").click(function() {
			location.reload();
		});
	};
	
	$(function() {
		initImageEvent();
		initButtonEvent();
		$("[data-add]").click(function() {
			var id = $(this).data("add");
			DB.addToSet("books", $(this).data("add"));
			alert("已添加到书架！");
		});
	});
	
})($);