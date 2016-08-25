$(function() {
	$(".deleteBooks").click(function() {
		var booksId = $(this).data("delete");
		DB.pull("books", booksId);
		$("#" + booksId).hide(200);
	});
});