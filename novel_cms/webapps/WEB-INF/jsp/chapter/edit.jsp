<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="chapter/edit" id="editForm" method="post">
<div class="form-group">
	<input type="hidden" name="bookId" value="${sessionScope.bookId}">
	<input type="hidden" name="id" value="${chapter.id}">
	<label class="col-sm-2 control-label">章节标题</label>
	<div class="col-sm-8">
		<input name="name" value="${chapter.name}" class="form-control">
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">内容</label>
	<div class="col-sm-8">
		<textarea name="content" class="form-control" rows="3">${chapter.content}</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label">排序</label>
	<div class="col-sm-8">
		<input name="index" value="${chapter.index}"  class="form-control">
	</div>
</div>
</form>