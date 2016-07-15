<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章详情</title>
<link rel="stylesheet" href="<c:url value='/WebResource/css/common.css'/>" />
<link rel="stylesheet" href="<c:url value='/WebResource/kindeditor/themes/default/default.css'/>" />
<link rel="stylesheet" href="<c:url value='/WebResource/kindeditor/plugins/code/prettify.css'/>" />
<script charset="utf-8" src="<c:url value='/WebResource/kindeditor/plugins/code/prettify.js'/>"></script>
<style type="text/css">
h3{
	text-align: center;
	margin-top:0.25em;
}
div.nav-right{
	text-align:right;
	font-size:0.75em;
	color:gray;
}
hr{
	color:#fcfcfc;
}
div.content{
	margin:20px;
}
div.tail{
	min-height: 200px;
	margin:0.5em 20%;
	background:#fff;
}
</style>
</head>
<body>
	<div class="main">
	<h3>${artical.title }</h3>
	<hr/>
	<div class="nav-right">
		${artical.authorName } | <fmt:formatDate value="${artical.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp; 
	</div>
	<hr/>
	<div>
		&nbsp;#分类:${artical.typeName }
	</div>
	<div class="content">
		${artical.content }
	</div>
	</div>
	
	<div class="tail">
		出售此广告板块，只需198元/天，详情请咨询10086
	</div>
</body>
</html>