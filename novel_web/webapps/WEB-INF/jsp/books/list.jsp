<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CSS" value="books"></c:set>
<c:set var="JS" value="books"></c:set>
<c:set var="PAGE_SELECT" value="books"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../comm/head.jsp" %>
</head>
<body>
	<header class="bar bar-nav">
		<a class="pull-left">
			<span class="icon icon-search"></span>
		</a>
		<h1 id="title" class="title">书城</h1>
		<a class="pull-right" data-refresh>
			<span class="icon icon-refresh"></span>
		</a>
	</header>
	<div class="content">
		<div id="grideView" class="table-view pd-5">
			<c:import url="/books/fragment"></c:import>
		</div>
	</div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>