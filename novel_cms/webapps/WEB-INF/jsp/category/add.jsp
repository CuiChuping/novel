<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="category/add" id="addForm" method="post">
<div class="form-group">
	<label class="col-sm-2 control-label">分类名称</label>
	<div class="col-sm-8">
		<input name="name" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">URL</label>
	<div class="col-sm-8">
		<input name="url" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">排序</label>
	<div class="col-sm-8">
		<input name="index" class="form-control">
	</div>
</div>
</form>