<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="regular/add" id="addForm" method="post">
<div class="form-group">
	<label class="col-sm-3 control-label">分类名称</label>
	<div class="col-sm-8">
		<input name="name" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">站点Url</label>
	<div class="col-sm-8">
		<input name="stationUrl" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">分类规则</label>
	<div class="col-sm-8">
		<input name="categoryReg" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">书籍规则</label>
	<div class="col-sm-8">
		<input name="booksReg" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">章节规则</label>
	<div class="col-sm-8">
		<input name="chapterReg" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">提取html规则</label>
	<div class="col-sm-8">
		<input name="htmlReg" class="form-control">
	</div>
</div>
</form>