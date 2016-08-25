<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CSS" value="books"></c:set>
<c:set var="JS" value="shelf"></c:set>
<c:set var="PAGE_SELECT" value="shelf"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../comm/head.jsp" %>
</head>
<body>
	<header class="bar bar-nav">
		<a class="pull-left" href="javascript:$('.deleteBooks').toggleClass('hide')">
			<span class="icon icon-gear"></span>
		</a>
		<h1 id="title" class="title">我的书架</h1>
		<a class="pull-right" data-refresh>
			<span class="icon icon-refresh"></span>
		</a>
	</header>
	<div class="content">
		<div id="grideView" class="table-view pd-5">
			<c:forEach var="books" items="${booksList}">
				<dl id="${books.id}">
					<dt>
						<a>
							<img src="${books.imagePath}">
						</a>
						<a class="icon icon-trash deleteBooks hide" data-delete="${books.id}"></a>
					</dt>
					<dd>${books.name}</dd>
				</dl>
			</c:forEach>
		</div>
	</div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>