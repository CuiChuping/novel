<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="books/edit" id="editForm" method="post" enctype="multipart/form-data">
<div class="form-group">
	<input type="hidden" name="id" value="${novel.id}">
	<label class="col-sm-2 control-label">小说名称</label>
	<div class="col-sm-8">
		<input name="name" value="${novel.name}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说分类</label>
	<div class="col-sm-8">
		<select  name="categoryId" class="form-control col-sm-8" required="required">
			<c:forEach items="${sessionScope.categorys}" var="category">
				<option value="${category.id}" <c:if test="${novel.categoryId == category.id}">selected="selected" </c:if>>${category.name }</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说作者</label>
	<div class="col-sm-8">
		<input name="author" value="${novel.author}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说状态</label>
	<div class="col-sm-8">
		<select name="status" class="form-control col-sm-8" required="required">
			<option value="0" <c:if test="${novel.status == 0}">selected="selected" </c:if>>完本</option>
			<option value="1" <c:if test="${novel.status == 1}">selected="selected" </c:if>>连载中</option>
		</select>
	</div>
</div>
<input type="hidden" name="imagePath" value="${novel.imagePath}">
<div class="form-group">
	<label class="col-sm-2 control-label">封面图片</label>
	<div class="col-sm-8">
		<input name="imageEdit" type="file" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说简介</label>
	<div class="col-sm-8">
		<textarea name="desc" class="form-control" rows="3">${novel.desc}</textarea>
	</div>
</div>
</form>