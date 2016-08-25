<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CSS" value="suggestion"></c:set>
<c:set var="PAGE_SELECT" value="my"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../comm/head.jsp" %>
</head>
<body>
	<header class="bar bar-nav">
		<a class="pull-left" href="my">
			<span class="icon icon-left-nav pull-left"></span>
		</a>
		<h1 id="title" class="title">意见反馈</h1>
	</header>
	<div class="content">
		<form action="my/suggestionSubmit" method="post">
			<textarea rows="5" placeholder="欢迎吐槽拍砖提意见~" name="suggestion"></textarea>
			<input type="text" placeholder="联系方式: QQ/手机/邮箱(选填)" name="contactWay">
			<button class="btn btn-positive btn-block">提交</button>
		</form>
	</div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>