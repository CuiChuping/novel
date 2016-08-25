<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>章节管理</title>
	<%@include file="../head.jsp"%></head>
<body>
	<div class="header none-margin">
		<div class="header-right">
			<div class="logo">LOGO</div>
			<div class="usrDiv"></div>
			<div class="manager">
	                <div>
	                    <ul class="nav nav-tabs" role="tablist">
		                    <li role="presentation" class=""><a href="/loving_cms/home/">小说列表</a></li>
	                    </ul>
					</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row main_content">
			<%@ include file="../leftmenu.jsp" %>
		<!-- right content -->
		<div class="right-content">
			<form id="searchForm" action="" method="post">
			<input type="hidden" name="_method" value="get" />
			<div class="lujing">
               <span class="zhucaidan">小说管理</span>
               <span class="jiantou">&lt;&lt;</span>
               <span class="zicaidan">章节管理</span>
			</div>
		 	<div class="handleBtn">
				<button type="button" id="add" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> 添加</button>
				<button type="button" id="edit" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> 编辑</button>
				<button type="button" id="delete" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span> 删除</button>
           </div>
           <!--table-->
           <!--固定表头,绝对定位-->
           <div class="fixedThead">
               <table class="table table-bordered myTable">
                   <thead>
                   <tr class="fixedTr">
						<th class="w65"><input id="xuanxiang" name="markedAll" type="checkbox"/> <label for="xuanxiang">选项</label> </th>
						<th>章节标题</th>
						<th>ID</th>
						<th>排序编号</th>
                   </tr>
                   </thead>
               </table>
           </div>
           <div class="tableDiv">
			<table class="table table-bordered table-striped table-hover myTable">
				<thead>
					<tr class="originalTr">
						<th class="w65"><input  type="checkbox"/> <label for="xuanxiang">选项</label> </th>
						<th>章节标题</th>
						<th>ID</th>
						<th>排序编号</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="chapter" items="${chapters}">
						<tr>
							<td><input name="marked" type="checkbox" value="${chapter.id}" /></td>
							<td>${chapter.name}</td>
							<td>${chapter.id}</td>
							<td>${chapter.index}</td>
						</tr>
					</c:forEach>
               </tbody>
           </table>
           </div>
           <!--end table-->
          </form>
       		</div> <!-- end right content -->
		</div>
	</div>	
 
	<!--弹出框-->
	<div class="modal fade" id="modal" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title"></h4>
	            </div>
	            <div class="modal-body form-horizontal">
					
	            </div>
	            <div class="modal-footer">
	                <span class="result">操作成功</span>
	                <button type="button" class="btn btn-default cancle" data-dismiss="modal">取消</button>
	                <button type="button" class="btn btn-primary sure">确定</button>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="loading">正在加载中...</div>
</body>
</html>