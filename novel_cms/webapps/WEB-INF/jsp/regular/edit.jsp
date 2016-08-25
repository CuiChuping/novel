<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="regular/edit" id="editForm" method="post">
<input type="hidden" value="${regular.id}" name="id">
<div class="form-group">
	<label class="col-sm-3 control-label">分类名称</label>
	<div class="col-sm-8">
		<input name="name" value="${regular.name}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">站点Url</label>
	<div class="col-sm-8">
		<input name="stationUrl" value="${regular.stationUrl}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">分类规则</label>
	<div class="col-sm-8">
		<input name="categoryReg" value="${regular.categoryReg}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">书籍规则</label>
	<div class="col-sm-8">
		<input name="booksReg" value="${regular.booksReg}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">章节规则</label>
	<div class="col-sm-8">
		<input name="chapterReg" value="${regular.chapterReg}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label">提取html规则</label>
	<div class="col-sm-8">
		<input name="htmlReg" value="${regular.htmlReg}" class="form-control">
	</div>
</div>
</form>