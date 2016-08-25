<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CTX" value="${pageContext.request.contextPath}" scope="request" />
<c:set var="RES" value="http://res.1862.cn" scope="request" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta charset="utf-8" />
	<script src="libs/th2w.core.js" type="text/javascript"></script>
	<script src="libs/jquery/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
	 	Core.init ({
			url : 'resources',
			css	: ['bootstrap/css/bootstrap.min', 'dialog/css/ui-dialog', './css/layout'],
			js  : ['bootstrap/js/bootstrap.min', 'dialog/js/dialog-plus-min', 'jquery/form', './js/common', './js/buttons']
		});
	</script>
</head>