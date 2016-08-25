<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="bar bar-tab bar-footer">
	<a class="tab-item ${PAGE_SELECT eq 'shelf'?'active':''}" href="shelf"> 
		<span class="icon fi-page-multiple"></span>
		<span class="tab-label">书架</span>
	</a> 
	<a class="tab-item ${PAGE_SELECT eq 'search'?'active':''}" href="search"> 
		<span class="icon icon-search"></span>
		<span class="tab-label">搜索</span>
	</a>
	<a class="tab-item ${PAGE_SELECT eq 'books'?'active':''}" href="books"> 
		<span class="icon fi-social-dropbox"></span>
		<span class="tab-label">书城</span>
	</a>
	<a class="tab-item ${PAGE_SELECT eq 'my'?'active':''}" href="my"> 
		<span class="icon fi-torso"></span>
		<span class="tab-label">我的</span>
	</a>
</nav>
