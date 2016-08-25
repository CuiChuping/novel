<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="left_nav">
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
		<div class="panel panel-default myPanel">
			<div class="panel-heading primary-menu drop-down" role="tab" id="heading0">
				<img src="resources/img/ico12.png" data-up-icon="/resources/img/ico11.png" data-down-icon="/resources/img/ico12.png" />
				<h4 class="panel-title" data-selected="true">
					<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse0" aria-expanded="false" aria-controls="collapse0">
						小说管理
					</a>
				</h4>
			</div>
			<div id="collapse0" class="panel-collapse collapse subMenu in" role="tabpanel" aria-labelledby="heading0">
				<div class="panel-body">
					<ul>
						<li class="activeStyle"><a href="/novel_cms/novel">小说列表</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="panel panel-default myPanel">
			<div class="panel-heading primary-menu close-up" role="tab" id="heading1">
				<img src="resources/img/ico01.png" data-up-icon="/resources/img/ico01.png" data-down-icon="/resources/img/ico02.png" />
				<h4 class="panel-title" data-selected="false">
					<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="false" aria-controls="collapse1">
						分类管理
					</a>
				</h4>
			</div>
			<div id="collapse1" class="panel-collapse collapse subMenu " role="tabpanel" aria-labelledby="heading1">
				<div class="panel-body">
					<ul>
						<li class=""><a href="/novel_cms/category">分类管理</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="panel panel-default myPanel">
			<div class="panel-heading primary-menu close-up" role="tab" id="heading1">
				<img src="resources/img/ico01.png" data-up-icon="/resources/img/ico01.png" data-down-icon="/resources/img/ico02.png" />
				<h4 class="panel-title" data-selected="false">
					<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false" aria-controls="collapse2">
						采集管理
					</a>
				</h4>
			</div>
			<div id="collapse2" class="panel-collapse collapse subMenu " role="tabpanel" aria-labelledby="heading2">
				<div class="panel-body">
					<ul>
						<li class=""><a href="/novel_cms/regular">规则管理</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	 <div class="NavToggle">
		<div class="btnToggle"></div>
	 </div>
</div><!-- end right content-->