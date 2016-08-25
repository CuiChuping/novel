$(document).ready(function(){
	$("nav .pageTab").click(function () {
		_form = $(this).closest('form');
		_form.find('input[name=pageNo]').val($(this).attr('data-page'));
		_form.submit();
	});
});