<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客首页</title>
<link rel="stylesheet" href="<c:url value='/WebResource/css/common.css'/>" />
<style>
	div.main h3{
		margin:0.5em;
	}
	artical-title{
		font-size: 1.5em;
		margin:0.5em;
	}
	.artical-list{
		line-height: 2;
		border:1px solid #f0f0f0;
		margin:0.25em;
		background-color: #fff;
	}
	div.artical-list div{
		display:inline-block;
		position:relative;
		float:right;
	}
	div.artical-list a{
		color:gray;
		text-decoration: none;
	}
	author,type{
		padding:0.2em 0.5em;
		background: gray;
		color:white;
		margin:0 0.5em;
		font-size:0.8em;
	}
	date{
		color:gray;
		font-size:0.8em;
	}
</style>
</head>
<body>
	<div class="main">
		<h3>博客列表</h3>
		<c:forEach items="${articalList }" var="artical">
			<div class="artical-list" onmouseover="divfocus(this);" onmouseout="divblur(this);">
				<artical-title>
					<a href="<c:url value='/artical/detail.do'/>?id=${artical.id}">${artical.title }</a>
				</artical-title>
				<div>
					<author>${artical.authorName }</author><type>${artical.typeName }</type>
					<date><fmt:formatDate value="${artical.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></date>
				</div>
			</div>
		</c:forEach>
		<br/>
		<a href="<c:url value='/artical/create.do'/>">创建博客</a>
	</div>
	<script>
		function divfocus(dom){
			dom.style.backgroundColor = "#f0f0f0";
		}
		function divblur(dom){
			dom.style.backgroundColor = "#fff";
		}
	</script>
</body>
</html>