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
	<h3 id="title"></h3>
	<hr/>
	<div class="nav-right">
		<span id="authorName"></span> | <span id="createTime"></span>&nbsp; 
	</div>
	<hr/>
	<div>
		&nbsp;#分类:<span id="typeName"></span>
	</div>
	<div class="content">
		<span id="content"></span>
	</div>
	</div>
	
	<div class="tail">
		出售此广告板块，只需198元/天，详情请咨询10086
	</div>
	<script type="text/javascript" src="<c:url value='/WebResource/js/ajax.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/WebResource/js/common.js'/>"></script>
	<script type="text/javascript">
		window.onload=function(){
			var search = window.location.search.substring(1);
			var id = search.split("=")[1];
			var $ajax = new ajaxUtil();
			$ajax.settings={
					url:"<c:url value='/artical/jsondetail.do'/>",
					method:"POST",
					param:"id="+id		
			};
			$ajax.send(function(xhr){
				var articalJson = xhr.responseText;
				console.log(articalJson);
				
				var articalObj = eval("("+articalJson+")");
				
				GetElement("authorName").innerHTML=articalObj["authorName"];
				GetElement("title").innerHTML = articalObj["title"];
				GetElement("typeName").innerHTML = articalObj["typeName"];
				GetElement("content").innerHTML = articalObj["content"];
			});
		} 
	</script>
</body>
</html>