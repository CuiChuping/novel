(function($) {
	"use strict";
	var initScrollEvent = function() {
		$(".content").scroll(function(e) {
			var $content = $(this).children(":first-child");
			if($(this).scrollTop() + $(this).outerHeight() >= $content.outerHeight() && !$content.data("loading")) {
				$content.data("loading", true);
				$("#title").data("title", $("#title").text());
				$("#title").text("正在加载...");
				var pageNum = $content.data("pageNum");
				pageNum = pageNum ? pageNum + 1 : 2;
				$content.data("pageNum", pageNum);
				$.get("books/fragment?index=" + pageNum, function(data, status) {
					if("success" == status) {
						$content.data("loading", false);
						$("#title").text($("#title").data("title"));
						$content.append(data);
						initImageEvent();
					}
				});
			}
		});
	};
	$(function() {
		initScrollEvent();
	});
})($);