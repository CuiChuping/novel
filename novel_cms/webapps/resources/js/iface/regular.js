$(document).ready(function(){
	$(".cgstatus").click(function () {
		location.href = "changeRegstu?id=" + $(this).attr('data-regular')+'&status=' + $(this).attr('data-status');
	});
});