<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CSS" value="my"></c:set>
<c:set var="PAGE_SELECT" value="my"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../comm/head.jsp" %>
</head>
<body>
	<header class="bar bar-nav">
		<a class="pull-left" href="books" data-transition="slide-out">
			<span class="icon icon-left-nav pull-left"></span>
		</a>
		<h1 id="title" class="title">用户中心</h1>
		<a class="pull-right" data-refresh>
			<span class="icon icon-refresh"></span>
		</a>
	</header>
	<div class="content">
		<div class="my_photo">
			<span class="icon icon-person personicon"></span>
		</div>
		<div class="my_login">
			<button class="btn btn-positive">登陆/注册</button>
		</div>
		<div class="my_center">
			<ul class="table-view">
			  <li class="table-view-cell media">
			    <a class="navigate-right">
			      <span class="media-object pull-left icon icon-gear"></span>
			        设置
			    </a>
			  </li>
			  <li class="table-view-cell media">
			    <a href="my/suggestion" class="navigate-right">
			      <span class="media-object pull-left icon icon-compose"></span>
			       意见反馈
			    </a>
			  </li>
			  <li class="table-view-cell media">
			    <a href="my/aboutSoftWare" class="navigate-right">
			      <span class="media-object pull-left icon icon-info"></span>
			        关于软件
			    </a>
			  </li>
			</ul>
			<ul class="table-view">
			  <li class="table-view-cell media">
			    <a href="my/callus" class="navigate-right">
			      <span class="media-object pull-left icon icon-home"></span>
			        联系我们
			    </a>
			  </li>
			</ul>
		</div>
	</div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>