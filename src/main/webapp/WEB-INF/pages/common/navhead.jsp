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
	}
	.nav-heading{
		background: #6CD7F3;
		width:100%;
		line-height:36px;
		padding:0 10px;
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
	background-color: #6CD7F3;
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
	}
</style>
</head>
<body>
	<div class="nav-heading">
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