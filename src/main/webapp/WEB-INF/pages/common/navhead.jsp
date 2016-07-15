<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="<c:url value='/icons/blog.png' />" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog</title>
<style type="text/css">
	html,body{
		padding:0;
		margin:0 auto;
		width:100%;
	}
	.nav-heading{
		background: #ccc;
		line-height:36px;
	}
	div.nav-heading-content{
		margin:0 5%;
	}
	.logo{
		color:gray;
		font-style:italic;
	}
	.login-div{
		display: inline-block;
		float:right;
		padding:0 30px 0;
		font-size:16px;
	}
	.login-div a{
		text-decoration: none;
		color:gray;
	}
	div.user{
		position:relative;
	}
	div.user-setting {
		position: absolute;
		top: 28px;
		background-color: #ccc;
		left: -10px;
		padding: 5px 5px;
		width: 50px;
		display: none;
		text-align: center;
	}

	div.user-setting>a {
		text-decoration: none;
		display: inline-block;
		color: gray;
		margin-top: 5px;
		margin-bottom: 5px;
		border-bottom:none;
	}
	div.user-setting>a:hover {
		border-bottom:1px solid red;
	}
	div.nav{
		border-bottom: 1px solid #e0e0e0;
		background: #fefefe;
		line-height:2em;
		height:3em;
		width:100%;
	}
	div.nav-content{
		margin:0 5%;
	}
	nav-block a{
		display:inline-block;
		padding:0.5em;
		color:#0f0f0f;
		text-decoration: none;
		border-bottom:none;
	}
	nav-block a:hover{
		color:gray;
		border-bottom:2px solid red;
	}
</style>
</head>
<body>
	<div class="nav-heading">
		<div class="nav-heading-content">
		<span class="logo">Gimis博客</span>
		<div class="login-div">
		<c:choose>
			<c:when test="${not empty sessionScope.cur_user }">
				<div class="user" onmouseover="showsetting();" onmouseout="hidesetting();">
					<a href="JavaScript:void(0);">${sessionScope.cur_user.loginName }</a>
					<div class="user-setting" id="setting">
						<a href="<c:url value='/loginout.do' />">退出</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/login.do'/>">登录</a>
			</c:otherwise>
		</c:choose>
		</div>
		</div>
	</div>
	<c:if test="${not empty sessionScope.cur_user }">
		<div class="nav">
			<div class="nav-content">
			<nav-block><a href="<c:url value="/index.do" />">首页</a></nav-block>
			<nav-block><a href="<c:url value="/index.do" />">个人主页</a></nav-block>
			<nav-block><a href="<c:url value="/index.do" />">消息中心</a></nav-block>
			</div>
		</div>
	</c:if>
</body>
<script type="text/javascript">
function showsetting(){
	document.getElementById("setting").style.display="block";
}

function hidesetting(){
	document.getElementById("setting").style.display="none";
}
</script>
</html>