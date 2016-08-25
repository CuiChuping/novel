<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CSS" value="relief"></c:set>
<c:set var="PAGE_SELECT" value="my"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../comm/head.jsp" %>
</head>
<body>
	<header class="bar bar-nav">
		<a class="pull-left" href="my/aboutSoftWare">
			<span class="icon icon-left-nav pull-left"></span>
		</a>
		<h1 id="title" class="title">免责声明</h1>
	</header>
		<div class="device-content">
			<div id="iwindow"><div id="popover" class="popover">
			  <header class="bar bar-nav">
			    <h1 class="title">Popover title</h1>
			  </header>
			  <ul class="table-view">
			    <li class="table-view-cell">Item1</li>
			    <li class="table-view-cell">Item2</li>
			    <li class="table-view-cell">Item3</li>
			    <li class="table-view-cell">Item4</li>
			    <li class="table-view-cell">Item5</li>
			    <li class="table-view-cell">Item6</li>
			    <li class="table-view-cell">Item7</li>
			    <li class="table-view-cell">Item8</li>
			  </ul>
			</div>
			<header class="bar bar-nav">
			  <a href="#myPopover">
			    <h1 class="title">
			      Tap title
			      <span class="icon icon-caret"></span>
			    </h1>
			  </a>
			</header>
			</div>
        </div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>