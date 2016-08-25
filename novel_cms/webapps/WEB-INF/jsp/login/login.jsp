<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>内容管理系统</title>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	 <meta charset="utf-8" />
	 <script src="libs/th2w.core.js" type="text/javascript"></script>
	 <script src="libs/jquery/jquery.js" type="text/javascript"></script>
	 <script type="text/javascript">
		Core.init ({
			url : 'resources',
			css	: ['bootstrap/css/bootstrap.min', './css/login'],
			js  : ['bootstrap/js/bootstrap.min', './js/login']
		});
 </script>
</head>

<body>
 <div class="header">
  <p class="logo">LOGO</p>
 </div>
 <div class="login">
	<div class="left"></div><div class="center">
		<form id="loginForm" action="/novel_cms/confirmLogin" method="post">
	        <input type="text" name="id" required="required" autofocus="autofocus"/>
	        <input type="password" name="password" required="required" />
	        <input type="submit" value="登录" />
		</form>
		<div id="msg"></div>
	</div><div class="right"></div>
</div>
</body>
</html>