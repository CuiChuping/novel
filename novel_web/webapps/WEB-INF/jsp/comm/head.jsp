<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<title>我的书窝</title>
<base href="${pageContext.request.contextPath}/">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<!-- libs -->
<link rel="stylesheet" href="libs/ratchet/css/ratchet.min.css">
<link rel="stylesheet" href="libs/ratchet/css/ratchet-theme-ios.min.css">
<link rel="stylesheet" href="libs/foundation/css/foundation-icons.css">
<script src="libs/jquery/jquery.js"></script>
<script src="libs/jquery/jquery.cookie.js"></script>
<script src="libs/ratchet/js/ratchet.js"></script>
<!-- resources -->
<script src="resources/js/cookie.js"></script>
<script src="resources/js/comm.js"></script>
<c:if test="${not empty CSS}">
	<link rel="stylesheet" href="resources/css/${CSS}.css">
</c:if>
<c:if test="${not empty JS}">
	<script src="resources/js/${JS}.js"></script>
</c:if>