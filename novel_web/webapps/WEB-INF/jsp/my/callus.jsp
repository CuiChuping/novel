<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CSS" value="callus"></c:set>
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
		<h1 id="title" class="title">联系我们</h1>
	</header>
	<div class="content">
		<div id="contectWay">
			<span>联系方式</span>
		</div>
		<div>
			<ul class="table-view">
				<li class="table-view-cell media">
					<span class="media-object pull-left icon">
						<img class="item_image" src="resources/img/QQ.png">
					</span>
					<div id="qq_number" class="media-body">
						123456789&nbsp;&nbsp;(商务QQ)
					</div>
				</li>
				<li class="table-view-cell media">
					<span class="media-object pull-left icon">
						<img class="item_image" src="resources/img/wechat.png">
					</span>
					<div id="qq_number" class="media-body">
						远古学渣&nbsp;&nbsp;(公众微信号)
					</div>
				</li>
				<li class="table-view-cell media">
					<span class="media-object pull-left" id="publicNum">
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎使用么么哒电子阅读器,如果您在使用的过程中遇到任何问题或者对产品有建议,
					 都可以通过微信公众号 [么么哒]联系我们,我们会在第一时间为您提供服务,如果觉
					 得软件不错,请在应用商店给予[么么哒]好评,您的鼓励是我们前进的最大动力!
					</span>
					<div id="findPublic">
						如何关注微信公众号?
					</div>
					<div id="publicFind">
						1.主动搜索"么么哒"并关注
					</div>
					<img id="erweimaplu" src="resources/img/wechatplu.png">
					<div id="publicFind">
						2.扫描下方2维码立即关注
					</div>
					<img id="erweima" src="resources/img/erweima.png">
				</li>
			</ul>
		</div>
	</div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>