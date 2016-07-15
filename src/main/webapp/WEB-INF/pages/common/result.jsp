<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh"  content="3;url=<c:url value='${returnURL }'/>">
<title>操作结果</title>
<script type="text/javascript" src="<c:url value='/WebResource/js/refresh.js' />"></script>
<style>
	html,body{
		width:100%;
	}
	div.tip{
		margin:5%;
	}
</style>
</head>
<body onload="onstart();">
<div class="tip">
	<c:choose>
		<c:when test="${result eq 'success' }">操作成功,</c:when>
		<c:otherwise>操作异常,</c:otherwise>
	</c:choose>
	<span id="seconds">3</span>秒后跳转!
</div>
</body>
</html>