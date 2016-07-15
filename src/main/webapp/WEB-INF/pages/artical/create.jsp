<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建BLOG</title>
	<link rel="stylesheet" href="<c:url value='/WebResource/css/common.css'/>" />
	<link rel="stylesheet" href="<c:url value='/WebResource/kindeditor/themes/default/default.css'/>" />
	<link rel="stylesheet" href="<c:url value='/WebResource/kindeditor/plugins/code/prettify.css'/>" />
	<script charset="utf-8" src="<c:url value='/WebResource/kindeditor/kindeditor-all.js'/>"></script>
	<script charset="utf-8" src="<c:url value='/WebResource/kindeditor/lang/zh-CN.js'/>"></script>
	<script charset="utf-8" src="<c:url value='/WebResource/kindeditor/plugins/code/prettify.js'/>"></script>
<style>
	div.form-div{
		margin:1em;
	}
	.form-div label{
		display: inline-block;
		width:85px;
		margin-bottom:0.5em;
	}
	.form-div select{
		width:85px;
	}
</style>
</head>
<body>
	<div class="main">
		<div class="form-div">
			<form name="blog" method="post" action="<c:url value='/artical/create.do'/>">
				<label>标题</label><input type="text" name="title" style="width:500px" /><br/>
				<label>分类</label><select id="top-level"></select>&nbsp;<select id="second-level" name="articalType"></select><br/>
				<label>内容</label><br/>
				<textarea name="content1" cols="100" rows="8" style="width:800px;height:500px;visibility:hidden;"></textarea>
				<br />
				<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
			</form>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/WebResource/js/ajax.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/WebResource/js/common.js'/>"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '<c:url value="/WebResource/kindeditor/plugins/code/prettify.css"/>',
				uploadJson : '<c:url value="/artical/fileUpload.do"/>',
				fileManagerJson : '<c:url value="/artical/fileManage.do"/>',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['blog'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['blog'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	<script type="text/javascript">
	window.onload=function(){
		var topDom = document.getElementById("top-level");
		var secondDom = document.getElementById("second-level");
		var firstURL = function(){return "<c:url value='/articalType/getChilds.do'/>?id=-1";};
		var changeURL = function(){
			var selectedIndex = topDom.selectedIndex;
			var pid = topDom.options[selectedIndex].value;
			return "<c:url value='/articalType/getChilds.do'/>?id="+pid;
		};
		var doubleSelect = new DoubleSelectUtil(topDom,secondDom,firstURL,changeURL,"id","typeName");
		doubleSelect.init();
	}
	</script>
</body>
</html>