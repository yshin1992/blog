<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建BLOG</title>
	<link rel="stylesheet" href="<c:url value='/WebResource/kindeditor/themes/default/default.css'/>" />
	<link rel="stylesheet" href="<c:url value='/WebResource/kindeditor/plugins/code/prettify.css'/>" />
	<script charset="utf-8" src="<c:url value='/WebResource/kindeditor/kindeditor-all.js'/>"></script>
	<script charset="utf-8" src="<c:url value='/WebResource/kindeditor/lang/zh-CN.js'/>"></script>
	<script charset="utf-8" src="<c:url value='/WebResource/kindeditor/plugins/code/prettify.js'/>"></script>
<style>
	.form-div{
		margin:10px;
		width:100%;
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
	<div class="form-div">
		<form name="example" method="post" action="demo.jsp">
		<label>标题</label><input type="text" name="title"/><br/>
		<label>分类</label><select id="top-level"></select>&nbsp;<select id="second-level"></select><br/>
		<label>内容</label><br/>
		<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
	</form>
	</div>
	<script type="text/javascript" src="<c:url value='/WebResource/js/ajax.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/WebResource/js/common.js'/>"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '<c:url value="/WebResource/kindeditor/plugins/code/prettify.css"/>',
				uploadJson : '<c:url value="/articalType/fileUpload.do"/>',
				fileManagerJson : '<c:url value="/articalType/fileManage.do"/>',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
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