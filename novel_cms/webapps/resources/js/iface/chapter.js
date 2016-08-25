$(document).ready(function(){
	$(".chapter").click(function () {
		location.href = "chapter?bookId=" + $(this).attr('data-chapter');
	});
});