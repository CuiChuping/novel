$(document).ready(function(){
	$("#loginForm").submit(function() {
    	var id = $("input[name=id]").val();
    	var password = $("input[name=password]").val();
    	if(id == "" || id == null){
    		$msg("账号为空,请填写账号");
    		return false;
    	}
    	if(password  == "" || password == null){
    		$msg("密码为空,请填写密码");
    		return false;
    	}
    });
    $("#loginForm input[type=submit]").mousedown(function(){
        $(this).css("background-position","0 -48px");
    }).mouseup(function(){
        $(this).css("background-position","0 0");
    });
    var $msg = function(_m) {
    	if(_m != undefined) {
    		var _msg = $("#msg");
    		_msg.html(_m);
    		_msg.css("margin-left", -_msg.width()/2);
    		_msg.show();
    	}
    };
    $msg();
});