var ModelUtil = {
		show : function (_html) {
			$('.modal-body').html(_html);
			$('#modal').modal({
				backdrop: 'static'
			});
		},
		clickHide : function (_div) {
			$(document).on('click', _div, function() {
	        	$('#modal').modal('hide');
	        });
		}
};