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
	div.top-level{
		margin-bottom:0.5em
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
					<a href="JavaScript:void(0);" onclick="showChildType('${type.id}')" onmouseover="showDelBtn(this);" onmouseout="hideDelBtn(this);">
						<c:out value="${type.typeName }" />
					</a><span onmouseover="show(this);" onmouseout="hide(this);"><a href="JavaScript:void(0);"  onclick="deleteType('${type.id}',this,'${type.parentId }')">×</a></span>
				</c:forEach>
			</c:if>
		</div>
		<input type="text" value="" id="typeAppend" style="display:none" />
		<input type="button" id="addBtn" value="新增" onclick="addInit(1)"/>
		<input type="button" id="saveBtn" value="保存" onclick="add(1)" style="display:none" />
	</fieldset>
	<fieldset id="second">
		<legend>文章子类型</legend>
		<div class="top-level" id="second-level">
		</div>
		<input type="text" value="" id="typeAppend-second" style="display:none" />
		<input type="button" id="addBtn-second" value="新增" onclick="addInit(2)"/>
		<input type="button" id="saveBtn-second" value="保存" onclick="add(2)" style="display:none" />
		<input type="hidden" id="parentType" value="${resList[0].id }"/>
	</fieldset>
</body>
<script type="text/javascript" src="<c:url value='/WebResource/js/ajax.js'/>"></script>
<script type="text/javascript" src="<c:url value='/WebResource/js/common.js'/>"></script>
<script type="text/javascript" src="<c:url value='/WebResource/js/articaltype.js'/>"></script>
<script type="text/javascript">
window.onload=function(){
	//加载第一个文章类型的子类型
	showChildType('${resList[0].id }')
}
/**
 * 显示该文章类型的子类型
 */
function showChildType(typeId)
{
	//清除之前的DOM元素
	document.getElementById("second-level").innerHTML="";
	var $ajax = new ajaxUtil();
	$ajax.settings={
			url:"<c:url value='/articalType/getChilds.do'/>?id="+typeId,
			method:"GET",
			param:null
	}
	$ajax.send(function(xhr){
		var childs = xhr.responseText;
		childs = eval(childs);
		console.log(childs)
		for(var i=0;i<childs.length;i++){
			appendTypeDOM(childs[i].typeName,childs[i].id,childs[i].parentId);
		}
	}); 
	document.getElementById("parentType").value=typeId;
}
/**
 * 添加文章类型
 */
function addInit(level)
{
	articalEdit.level = level;
	articalEdit.initAdd();
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
		//一级文章类型有子类型，所以添加此事件
		aNode.addEventListener("click",function(){showChildType(id);},false);
	}else{
		document.getElementById("second-level").appendChild(aNode);
		document.getElementById("second-level").appendChild(spanNode);
	}
	
	//绑定事件
	aNode.addEventListener("mouseover",function(){showDelBtn(aNode);},false);
	aNode.addEventListener("mouseout",function(){hideDelBtn(aNode);},false);
	aNode.setAttribute("href","JavaScript:void(0);");
	
	spanNode.addEventListener("mouseover",function(){show(spanNode);},false);
	spanNode.addEventListener("mouseout",function(){hide(spanNode);},false);
	
	aChildNode.addEventListener("click",function(){deleteType(id,aChildNode,pid);},false);
	aChildNode.setAttribute("href","JavaScript:void(0);");
}

/**
 * 使用Ajax方法将数据添加到数据库中
 */
function ajaxAdd(typeName,pid){
	var $ajax = new ajaxUtil();
	$ajax.settings={
			url:"<c:url value='/articalType/add.do'/>",
			method:"POST",
			param:"typeName="+typeName+"&pid="+pid
	}
	$ajax.send(function(xhr){appendTypeDOM(typeName,xhr.responseText,pid);}); 
}

/**
 * 添加文章类型
 */
function add(level)
{
	var append;
	if(level == 1){
		append = document.getElementById("typeAppend").value;
	}
	else{
		append = document.getElementById("typeAppend-second").value;
	}
	if(append){
		if(level == 1){
			ajaxAdd(append,-1);
		}else if(level == 2){
			var pid = document.getElementById("parentType").value;
			ajaxAdd(append,pid);
		}
	}else{
		return ;
	}
	articalEdit.level = level;
	articalEdit.add();
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
function deleteType(id,dom,parentId)
{
	 var cfm = window.confirm("确认删除此文章类型？");
	 if(cfm){
		 var $ajax = new ajaxUtil();
		 $ajax.settings={
					url:"<c:url value='/articalType/delete.do'/>",
					method:"POST",
					param:"id="+id
		 }
		 $ajax.send(function(xhr){
				var result = xhr.responseText;
				if(result == 1){
					alert("删除成功！");
					var predom = dom.parentNode.previousSibling;
					var top = document.getElementById("top-level");
					if(parentId != -1){
						top = document.getElementById("second-level");
					}
					top.removeChild(predom);
					top.removeChild(dom.parentNode);
				}else if(result == -1){
					alert("该文章类型有子文章类型，不能删除!");
				}
		 });  
	 }
}
</script>
</html>