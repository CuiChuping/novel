<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1 id="title" class="title">关于软件</h1>
	</header>
	<div class="content">
		<ul class="table-view">
			<li class="table-view-cell media">
				<a href="#relief" class="navigate-right">
					 免责声明
				</a>
			</li>
			<li class="table-view-cell media">
				<a class="navigate-right">
					  么么哒书城使用
				</a>
			</li>
			<li class="table-view-cell media">
				<a class="navigate-right">
					 给我打分
				</a>
			</li>
		</ul>
	</div>
	
	<div id="relief" class="modal">
		<header class="bar bar-nav">
			<a class="icon icon-close pull-right" href="#relief"></a>
			<h1 class="title">免责声明</h1>
		</header>
		<div class="content">
			<p class="content-padded">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在用本应用前，请仔细阅读本声明。您可以不使用本应用，如果您使用，您的行为将被视为对本声明全部内容的认可。<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本应用是一款提供网络小说及时更新的工具，为广大小说爱好者提供一种方便、快捷、舒适的试读体验。本应用致 力于最大程度的减少阅读者在搜寻网络小说过程中无意义的时间浪费，通过专业搜索展示不同网站中网络小说最新 章节。本应用为广大小说爱好者提供方便、舒适、快捷的试读体验的同时，也使优秀网络小说得以更快速、更广泛 的传播，从而达到了在一定程度促进网络文学繁荣发展的目的。<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当您点击搜索一本书时，本应用会将该书的书名以关键字的形式提交到第三方网站或搜索引擎（如百度、宜搜、贴 吧等）。第三方网站返回的内容与本应用无关，本应用对其概不负责，亦不承担任何法律责任。第三方搜索引擎结 果根据您提交的宿命自动搜索获得并提供试读，不代表本应用赞成被搜索链接到的第三方网页上的内容和立场。您 应该对使用搜索引擎的结果自行承担风险。本应用不作任何形式的保证：不保证第三方搜索服务不中断，不保证第 三方搜索引擎的搜索结果满足您的要求，不保证搜索结果的安全性、正确性、及时性、合法性等。因网络状况、通 讯线路、第三方网站等任何原因而导致您不能正常使用本应用，本应用不承担任何法律责任。本应用尊重并保护所 有使用本应用的用户的个人隐私权，您的任何信息未经您亲自许可不会被本应用泄漏给他人。<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本应用鼓励广大小说爱好者通过本应用发现优秀网络小说及其提供商，并建议阅读正版图书。任何单位或个人认为 通过本应用搜索链接到的第三方网页内容可能涉嫌侵犯其信息网络隐私权，应该及时向本应用提出权利通知，并提 供身份证明、权属证明及详细侵权情况证明。本应用在收到相关文件后，将会依法尽快断开相关链接内容。<br>
			</p>
			<button class="btn btn-positive btn-block">知道了</button>
		</div>
	</div>
	<%@ include file="../comm/foot.jsp" %>
</body>
</html>