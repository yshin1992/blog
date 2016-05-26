<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章类型</title>
<style>
	html,body{
		padding: 0 auto;
		margin:0;
	}
	h3{
		width:100%;
		text-align: center;
	}
	
	fieldset{
		margin:30px;
	}
</style>
</head>
<body>
	<h3>文章类型</h3>
	<fieldset id="top">
		<legend>文章类型</legend>
		<c:if test="${not empty resList }">
			<c:forEach items="${resList }" var="type">
				<a href="JavaScript:void(0);" onclick="showChildType(${type.id})"><span><c:out value="${type.typeName }" /></span></a>
			</c:forEach>
		</c:if>
		<input type="text" value="" id="typeAppend" style="display:none" />
		<input type="button" id="addBtn" value="新增" onclick="addInit()"/>
		<input type="button" id="saveBtn" value="保存" onclick="add()" style="display:none" />
	</fieldset>
	<fieldset id="second">
		<legend>文章子类型</legend>
		
	</fieldset>
</body>
<script type="text/javascript" src="<c:url value='/WebResource/js/ajax.js'/>"></script>
<script type="text/javascript">
function showChildType(typeId)
{
	var xhr = getXMLHttpRequest();
	var url = "<c:url value='/articalType/getChilds.do'/>";
}
function addInit()
{
	document.getElementById("typeAppend").style.display="inline-block";
	document.getElementById("saveBtn").style.display="inline-block";
	document.getElementById("addBtn").style.display="none";
}

function ajaxAdd(){
	var xhr = getXMLHttpRequest();
	var url = "<c:url value='/articalType/add.do'/>";
}

function add()
{
	var append = document.getElementById("typeAppend").value;
	if(append){
		
	}else{
		return ;
	}
	document.getElementById("typeAppend").style.display="none";
	document.getElementById("saveBtn").style.display="none";
	document.getElementById("addBtn").style.display="inline-block";
}
</script>
</html>