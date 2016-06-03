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
	div.top-level a{
		text-decoration:none;
		display: inline-block;
		color:gray;
	}
	
	div.top-level span a:hover,div.top-level span a:active{
		color:black;
		font-weight: bold;
	}
	
	div.top-level a+span{
		visibility: hidden;
		margin-right:1em;
	}
	
	div.top-level a+span a{
		font-size:1.5em;
	}
</style>
</head>
<body>
	<h3>文章类型</h3>
	<fieldset id="top">
		<legend>文章类型</legend>
		<div class="top-level" id="top-level">
			<c:if test="${not empty resList }">
				<c:forEach items="${resList }" var="type">
					<a href="JavaScript:void(0);" onclick="showChildType(${type.id})" onmouseover="showDelBtn(this);" onmouseout="hideDelBtn(this);"><c:out value="${type.typeName }" />
					</a><span onmouseover="show(this);" onmouseout="hide(this);"><a href="JavaScript:void(0);"  onclick="deleteType(${type.id})">×</a></span>
				</c:forEach>
			</c:if>
		</div>
		<input type="text" value="" id="typeAppend" style="display:none" />
		<input type="button" id="addBtn" value="新增" onclick="addInit()"/>
		<input type="button" id="saveBtn" value="保存" onclick="add()" style="display:none" />
	</fieldset>
	<fieldset id="second">
		<legend>文章子类型</legend>
		<div class="top-level" id="second-level">
		
		</div>
	</fieldset>
</body>
<script type="text/javascript" src="<c:url value='/WebResource/js/ajax.js'/>"></script>
<script type="text/javascript">
/**
 * 显示该文章类型的子类型
 */
function showChildType(typeId)
{
	var xhr = getXMLHttpRequest();
	var url = "<c:url value='/articalType/getChilds.do'/>?id="+typeId;
	xhr.open("GET",url);
	xhr.onreadystatechange=function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var text = xhr.responseText;
				console.log(text);
			}
		}
	}
	xhr.send(null);
}
/**
 * 添加文章类型
 */
function addInit()
{
	document.getElementById("typeAppend").style.display="inline-block";
	document.getElementById("saveBtn").style.display="inline-block";
	document.getElementById("addBtn").style.display="none";
}

/**
 * 在页面上添加文章类型
 */
function appendTypeDOM(typeName,id,pid)
{
	var aNode = document.createElement("a");
	var textNode = document.createTextNode(typeName);
	aNode.appendChild(textNode);
	
	var spanNode = document.createElement("span");
	var aChildNode = document.createElement("a");
	var delTextNode = document.createTextNode("×");
	aChildNode.appendChild(delTextNode);
	spanNode.appendChild(aChildNode);
	
	if(pid == -1){
		document.getElementById("top-level").appendChild(aNode);
		document.getElementById("top-level").appendChild(spanNode);
	}else{
		//TODO
	}
	
	//绑定事件
	aNode.addEventListener("click",function(){showChildType(id);},false);
	aNode.addEventListener("mouseover",function(){showDelBtn(aNode);},false);
	aNode.addEventListener("mouseout",function(){hideDelBtn(aNode);},false);
	
	spanNode.addEventListener("mouseover",function(){show(spanNode);},false);
	spanNode.addEventListener("mouseout",function(){hide(spanNode);},false);
	
	aChildNode.addEventListener("click",function(){deleteType(id);},false);
}

/**
 * 使用Ajax方法将数据添加到数据库中
 */
function ajaxAdd(typeName,pid){
	var xhr = getXMLHttpRequest();
	var url = "<c:url value='/articalType/add.do'/>";
	xhr.open("POST",url);
	xhr.onreadystatechange=function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var id = xhr.responseText;
				console.log(id);
				appendTypeDOM(typeName,id,pid);
			}
			else{
				alert("添加失败!");
			}
		}
	}
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
	xhr.send("typeName="+typeName+"&pid="+pid);
}

/**
 * 添加文章类型
 */
function add()
{
	var append = document.getElementById("typeAppend").value;
	if(append){
		ajaxAdd(append,-1);
	}else{
		return ;
	}
	document.getElementById("typeAppend").value="";
	document.getElementById("typeAppend").style.display="none";
	document.getElementById("saveBtn").style.display="none";
	document.getElementById("addBtn").style.display="inline-block";
}

function show(dom){
	dom.style.visibility="visible";
}
function hide(dom){
	dom.style.visibility="hidden";
}

/**
 * 显示当前DOM元素的删除按钮
 */
function showDelBtn(dom)
{
	var delBtn = dom.nextSibling;
	delBtn.style.visibility="visible";
}

/**
 * 隐藏当前DOM元素的删除按钮
 */
function hideDelBtn(dom)
{
	var delBtn = dom.nextSibling;
	delBtn.style.visibility="hidden";
}

/**
 * 删除文章类型
 */
 function deleteType(id)
 {
	var del = window.confirm("确认删除该文章类型么?");
	if(del){
		alert("删除文章类型!");
	}
 }
</script>
</html>