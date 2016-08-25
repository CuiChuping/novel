$(document).ready(function() {

	$("#add").click(function() {
		_toAdd('#searchForm');
    });

	$("#edit").click(function() {
        _toEdit('#searchForm');
    });

	$("#detail").click(function() {
		$(".result").hide();
        $(".sure").removeAttr("id").attr("id","detail_sure");        
        $('.modal-title').text("详情");
        $("input[name=_method]").attr("disabled", "disabled");
        $.ajax({
			type: 'put',
			url: '?' + $('#searchForm').serialize(),
			async: true,
			success: function(data) {
				$("input[name=_method]").removeAttr("disabled");
				$('.modal-body').html(data);
				$('#modal').modal({
					backdrop: 'static'
				});
			},
			error: function () {
				$("input[name=_method]").removeAttr("disabled");
				$('.modal-body').html("请求超时！");
				$('#modal').modal({
					backdrop: 'static'
				});
			}
		});
        $(document).on('click', '#detail_sure', function() {
        	$('#modal').modal('hide');
        });
    });

	$("#delete").click(function() {
		dialog({
            title: "删除",
            width: 460,
            content: "确定删除所选的记录吗？",
            okValue: "删除",
            ok: function () {
                var _this = this;
                _this.content("正在提交..");
                $("input[name=_method]").attr("disabled", "disabled");
                $.ajax({
        			type: 'delete',
        			url: '?' + $("#searchForm").serialize(),
        			async: true,
        			dataType: 'json',
        			success: function(data) {
        				$("input[name=_method]").removeAttr("disabled");
        				if(data == true) {
        					_this.content("删除成功！");
        					setTimeout(function () { location.reload(); }, 500);
        				} else {
        					_this.content("删除失败！");
        					setTimeout(function () { _this.close().remove(); }, 500);
        				}
        			},
        			error: function() {
        				$("input[name=_method]").removeAttr("disabled");
        				_this.content("请求超时！");
        				setTimeout(function () { _this.close().remove(); }, 500);
        			}
                });
                return false;
            },
            cancelValue: "取消",
            cancel: function () {}
        }).show();
	});

	$("#search").click(function () {
		$("input[name=_method]").show();
		$("#searchForm").submit();
	});

	$(".regionMenu li").click(function () {
		_form = $(this).closest('form');
		_form.find('input[name=regionCode]').val($(this).find("a").attr('data-code'));
		_form.submit();
	});

	$(".statusMenu li").click(function () {
		_form = $(this).closest('form');
		_form.find('input[name=status]').val($(this).find("a").attr('data-status'));
		_form.submit();
	});
	

	var _toAdd = function (_form) {
		$(".result").hide();
        $(".sure").removeAttr("id").attr("id","edit_sure");
        $('.modal-title').text("添加");
		$(_form + " input[name=_method]").attr("disabled", "disabled");
		$(_form + " input[name=marked]").attr("disabled", "disabled"); 
		$.ajax({
			type: 'put',
			url: '?' + $(_form).serialize(),
			async: true,
			success: function(data) {
				$(_form + " input[name=_method]").removeAttr("disabled");
				$(_form + " input[name=marked]").removeAttr("disabled");
				$('.modal-body').html(data);
				$('#modal').modal({
					backdrop: 'static'
				});
				_add('#edit_sure');
			},
			error: function () {
				$(_form + "input[name=_method]").removeAttr("disabled");
				$(_form + " input[name=marked]").removeAttr("disabled");
				$('.modal-body').html("请求超时！");
				$('#modal').modal({
					backdrop: 'static'
				});
				$(document).on('click', '#edit_sure', function() {
		        	$('#modal').modal('hide');
		        });
			}
		});
	}; 
	
	var _toEdit = function (_form) {
		$(".result").hide();
        $(".sure").removeAttr("id").attr("id","edit_sure");
        $('.modal-title').text("编辑");
		$(_form + " input[name=_method]").attr("disabled", "disabled");
		console.log($(_form).serialize());
		$.ajax({
			type: 'put',
			url: '?' + $(_form).serialize(),
			async: true,
			success: function(data) {
				$(_form + " input[name=_method]").removeAttr("disabled");
				$('.modal-body').html(data);
				$('#modal').modal({
					backdrop: 'static'
				});
				_edit('#edit_sure');
			},
			error: function () {
				$(_form + "input[name=_method]").removeAttr("disabled");
				$('.modal-body').html("请求超时！");
				$('#modal').modal({
					backdrop: 'static'
				});
				$(document).on('click', '#edit_sure', function() {
		        	$('#modal').modal('hide');
		        });
			}
		});
	}; 
	
	var _add = function (_tag) {
		var _this = $(_tag);
		var _loading = $(".loading");
		var _result = $(".result");
		$(document).on('click', _tag, function() {
			_this.attr('disabled', 'disabled');
			_loading.stop().fadeIn();
			$("#addForm").ajaxSubmit({
				async: true,
				dataType: 'json',
				success: function(data) {
					if(data == true) {
						_loading.css('display', 'none');
						_result.html("添加成功").css("margin-left", -_result.width()/2);
						_result.fadeIn();
						_this.removeAttr('disabled');
                        location.reload();
					} else {
						_loading.css('display', 'none');
						_result.html("添加失败").css("margin-left",-_result.width()/2);
						_result.fadeIn();
						_this.removeAttr('disabled');
					}
				}
			});
		});
	};
	
	var _edit = function (_tag) {
		var _this = $(_tag);
		var _loading = $(".loading");
		var _result = $(".result");
		$(document).on('click', _tag, function() {
			_this.attr('disabled', 'disabled');
			_loading.stop().fadeIn();
			$("#editForm").ajaxSubmit({
				async: true,
				dataType: 'json',
				success: function(data) {
					if(data == true) {
						_loading.css('display', 'none');
						_result.html("编辑成功").css("margin-left", -_result.width()/2);
						_result.fadeIn();
						_this.removeAttr('disabled');
                        location.reload();
					} else {
						_loading.css('display', 'none');
						_result.html("编辑失败").css("margin-left",-_result.width()/2);
						_result.fadeIn();
						_this.removeAttr('disabled');
					}
				}
			});
		});
	};
});