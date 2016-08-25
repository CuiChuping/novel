$(document).ready(function(){

	$(".statusBtn").click(function () {
		var _url = "?_method=head&id=" + $(this).attr("data-id") + "&current=" + $(this).attr("data-current") + "&next=" + $(this).attr("data-next");
        $.ajax({
			url: _url,
			async: true,
			dataType: 'json',
			success: function(data) {
				if(data == true) {
					dialog({ content: '修改状态成功！' }).show();
					setTimeout(function () { location.reload(); }, 500);
				} else {
					var _dialog = dialog({ content: '修改状态失败！' });
					_dialog.show();
					setTimeout(function () { _dialog.close().remove(); }, 500);
				}
			},
			error: function() {
				var _dialog = dialog({ content: '请求失败！' });
				_dialog.show();
				setTimeout(function () { _dialog.close().remove(); }, 500);
			}
        });
	});
});