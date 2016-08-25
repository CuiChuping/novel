<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="category/edit" id="editForm" method="post">
<div class="form-group">
	<label class="col-sm-2 control-label">分类Id</label>
	<div class="col-sm-8">
		<input name="id" value="${category.id}" readonly="readonly"  class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">分类名称</label>
	<div class="col-sm-8">
		<input name="name" value="${category.name}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">URL</label>
	<div class="col-sm-8">
		<input name="url" value="${category.url}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">排序</label>
	<div class="col-sm-8">
		<input name="index" value="${category.index}" class="form-control">
	</div>
</div>
</form>