<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header none-margin">
<div class="header-right">
            <div class="logo"><img src="${RES}/logo/1862/log_small.png" /></div>
            <div class="usrDiv">
                <span>欢迎您：</span>
                <div class="btn-group">
                    <div class="btn-group">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                           <span class="username">${manager.name}</span>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                             <li><a href="logout">注销</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="manager">
            	<div>
             	<!-- Nav tabs -->
             		<ul class="nav nav-tabs" role="tablist">
                	<li role="presentation" class="active"><a href="javascript:void(0);">基础平台</a></li>
                	<c:if test="${not empty systems and empty platformFlag }">
	                  <c:forEach var="sys" items="${systems}">
							<li role="presentation"><a href="${sys.url}" >${sys.name}</a></li>
						</c:forEach>
					</c:if>
                 </ul>
               </div>
            </div>
            <div class="qudao">
            	<c:if test="${not empty platforms and empty platformFlag }">
					<div class="btnRight">
						<div class="btn-group">
							<ul class="dropdown-menu" role="menu" id="platformId" style="width: 50">
								<c:forEach var="plt" items="${platforms}">
									<li value = "${plt.id}"><a href="javascript:void(0)" onclick="_changePlt('${plt.id}')">${plt.name}</a></li>
								</c:forEach>
							</ul>
							<button id="platformBut" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" >
							<c:set var="showValue" value="选择平台" />
								<c:forEach items="${platforms}" var="plt">
						          	<c:if test="${plt.id eq platform.id}">
						            	<c:set var="showValue" value="${plt.name}" />
						            </c:if>
								</c:forEach>
		          				${showValue}<span class="caret"></span>
	       					</button>
						</div>
					</div>  
				</c:if>
            </div>
        </div>
    </div>