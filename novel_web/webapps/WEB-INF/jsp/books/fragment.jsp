<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="books" items="${pager.result}">
	<dl>
		<dt>
			<a href="books/detail?id=${books.id}">
				<img class="books" src="${books.imagePath}">
			</a>
		</dt>
		<dd>${books.name}</dd>
	</dl>
</c:forEach>