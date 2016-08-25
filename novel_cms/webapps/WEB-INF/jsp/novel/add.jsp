<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="books/add" id="addForm" method="post" enctype="multipart/form-data">
<div class="form-group">
	<label class="col-sm-2 control-label">小说名称</label>
	<div class="col-sm-8">
		<input name="name" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说分类</label>
	<div class="col-sm-8">
		<select  name="categoryId" class="form-control col-sm-8" required="required">
			<c:forEach items="${sessionScope.categorys}" var="category">
				<option value="${category.id }">${category.name }</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说作者</label>
	<div class="col-sm-8">
		<input name="author" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说状态</label>
	<div class="col-sm-8">
		<select name="status" class="form-control col-sm-8" required="required">
			<option value="0">完本</option>
			<option value="1">连载中</option>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">封面图片</label>
	<div class="col-sm-8">
		<input name="image" type="file" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">小说简介</label>
	<div class="col-sm-8">
		<textarea name="desc" class="form-control" rows="3"></textarea>
	</div>
</div>
</form>