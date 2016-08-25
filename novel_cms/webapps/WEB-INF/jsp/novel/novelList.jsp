<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>小说管理系统</title>
	<%@include file="../head.jsp" %>
	<script type="text/javascript">Core.js('./js/iface/chapter');</script>
</head>
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
			<%@include  file="../leftmenu.jsp" %>
		<!-- right content -->
		<div class="right-content">
			<form id="searchForm" action="" method="post">
			<input type="hidden" name="_method" value="get" />
			<div class="lujing">
               <span class="zhucaidan">小说管理</span>
               <span class="jiantou">&lt;&lt;</span>
               <span class="zicaidan">小说列表</span>
               <!-- <div class="input-group search">
                   <img id="search" src="resources/img/ico23.png" alt="" />
                   <input type="text" name="key" class="form-control" value="" placeholder="请输入关键字...">
               </div> -->
         		<%-- <div class="form-inline" style="float: right;">
		                	<select class="form-control" id="material">
		                		<option value="">全部资源</option>
		                		<c:forEach var="material" items="${materials}">
		                			<option value="${material.id}" ${categories[0].materialId eq material.id?'selected':''}>${material.name}</option>
		                			<c:if test="${categories[0].materialId eq material.id}">
		                				<c:set var="material" value="${material}" scope="request"></c:set>
		                			</c:if>
		                		</c:forEach>
		                	</select>
		                	<select class="form-control" name="categoryId">
		                		<c:if test="${not empty param.categoryId}">
			                		<c:forEach var="category" items="${categories}">
			                			<option value="${category.id}" ${category.id eq param.categoryId?'selected':''}>${category.name}</option>
			                		</c:forEach>
		                		</c:if>
		                	</select>
		                	<input class="form-control" name="name" value="${param.name}" placeholder="输入资源名称按Enter查询">
		                	<button class="btn btn-default">查询</button>
				</div> --%>
			</div>
		 	<div class="handleBtn">
              	<button type="button" id="chose" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                   	${empty sessionScope.categoryName ? '选择分类' : sessionScope.categoryName}<span class="caret"></span>
               	</button>
                <ul class="dropdown-menu" role="menu">
                	<c:forEach var="category" items="${sessionScope.categorys}">
                		<li><a href="/novel_cms/novel?cateGoryId=${category.id}">${category.name}</a></li>
                	</c:forEach>
                </ul>
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
                       <th>ID</th>
	                   <th>小说名称</th>
	                   <th>所属分类</th>
	               	   <th>小说作者</th>
	               	   <th>最后更新时间</th>
	               	   <th>小说状态</th>
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
						<th>ID</th>
						<th>小说名称</th>
						<th>所属分类</th>
						<th>小说作者</th>
						<th>最后更新时间</th>
						<th>小说状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td><input name="marked" type="checkbox" value="${book.id}" /></td>
							<td>${book.id}</td>
							<td>${book.name}</td>
							<c:forEach var="category" items="${categorys}">
								<c:if test="${book.categoryId == category.id}">
									<td>${category.name}</td>
								</c:if>
							</c:forEach>
							
							<td>${book.author}</td>
							<td><fmt:formatDate value="${book.updateDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${book.status==1 ? '连载中' : '完本'}</td>
							<td>
			                   	<div>
					            	<button type="button" class="btn btn-default chapter" data-chapter="${book.id}">分章查看</button>
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
	            <div class="modal-body form-horizontal"></div>
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