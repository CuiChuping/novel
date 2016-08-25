<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>规则管理</title>
	<%@include file="../head.jsp"%></head>
	<script type="text/javascript">Core.js('./js/iface/regular');</script>
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
               <span class="zhucaidan">采集管理</span>
               <span class="jiantou">&lt;&lt;</span>
               <span class="zicaidan">规则管理</span>
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
						<th>规则名称</th>
						<th>规则编号</th>
						<th>站点Url</th>
						<th>分类规则</th>
						<th>书籍规则</th>
						<th>章节规则</th>
						<th>提取html规则</th>
						<th>状态</th>
						<th>操作</th>
                   </tr>
                   </thead>
               </table>
           </div>
           <div class="tableDiv">
			<table class="table table-bordered table-striped table-hover myTable">
				<thead>
					<tr class="originalTr">
						<th class="w65"><input  type="checkbox"/> <label for="xuanxiang">选项</label> </th>
						<th>规则名称</th>
						<th>规则编号</th>
						<th>站点Url</th>
						<th>分类规则</th>
						<th>书籍规则</th>
						<th>章节规则</th>
						<th>提取html规则</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="regular" items="${regulars}">
						<tr>
							<td><input name="marked" type="checkbox" value="${regular.id}" /></td>
							<td>${regular.name}</td>
							<td>${regular.id}</td>
							<td>${regular.stationUrl}</td>
							<td>${regular.categoryReg}</td>
							<td>${regular.booksReg}</td>
							<td>${regular.chapterReg}</td>
							<td>${regular.htmlReg}</td>
							<td>${regular.status==1 ? '已启用' : '已禁用'}</td>
							<td>
								<div class="btn-group " role="group" aria-label="...">
				                   <c:if  test="${regular.status==0}">
				                   	<button type="button" class="btn btn-default btn-sm btn-success cgstatus" data-regular="${regular.id}" data-status="1"><span class="glyphicon glyphicon-ok-circle"></span>启用</button>
				                   </c:if>
				                   <c:if  test="${regular.status==1}">
				                   	<button type="button" class="btn btn-default btn-sm btn-danger cgstatus" data-regular="${regular.id}" data-status="0"><span class="glyphicon glyphicon-ban-circle"></span>禁用</button>
				                   </c:if>
								</div>
							</td>
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