<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="JS" value="detail"></c:set>
<c:set var="CSS" value="detail"></c:set>
<c:set var="PAGE_SELECT" value="books"></c:set>
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
		<h1 id="title" class="title">书籍详情</h1>
		<a class="pull-right" data-refresh>
			<span class="icon icon-refresh"></span>
		</a>
	</header>
	<div class="content">
		<div id="bg_detail" style="background-image: url('${books.imagePath}');"></div>
		<div id="detail" >
			<div class="head">
				<div class="image">
					<img id="detail_img" src="${books.imagePath}">
				</div>
				<div class="detail">
					<div>
						<div>
							<span id="booksName">${books.name}</span>
							<span id="categoryName">[${books.categoryId}]</span>
						</div>
						<div>
							<span id="author" class="pull-left">${books.author}</span>
							<span id="word" class="pull-right">${books.wordCount/10000}W</span>
							<div style="clear: both;"></div>
						</div>
						<div>
							<p id="desc"><c:out value="${books.desc}"/></p>
						</div>
					</div>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>
		<div class=button-group>
			<button class="btn btn-primary btn-inline-block">开始阅读</button>
			<button data-add="${books.id}" class="btn btn-primary btn-inline-block btn-outlined">+ 书架</button>
			<button class="btn btn-primary btn-inline-block btn-outlined">下载全本</button>
		</div>
	</div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>