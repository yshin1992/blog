<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="<c:url value='/icons/blog.png' />" type="image/x-icon" />
<title>Blog 登录</title>
<style>
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
	label{
		width: 85px;
		display: inline-block;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<div class="nav-heading">
		<span>Gimis博客</span>
		<span id="login-div">
		<c:choose>
			<c:when test="${not empty sessionScope.cur_user }">
				<a href="<c:url value='perinfo.do'/>">${sessionScope.cur_user.username }</a>
			</c:when>
		</c:choose>
		</span>
	</div>
	<div class="login-form">
	<form action="<c:url value='/login.do'/>" method="post" onsubmit="checkForm();">
		<label>用户名</label><input type="text" name="username" /><br/>
		<label>密码</label><input type="password" name="passwd" /><br/>
		<input type="submit" value="登录" />
	</form>
	</div>
</body>
<script type="text/javascript">
	function checkForm(){
		return true;
	}
</script>
</html>