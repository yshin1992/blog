<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog 登录</title>
<style>
	.login-form{
		margin:25px auto;
		width:250px;
		padding:20px 15px;
		border: 1px solid silver;
	}
	
	label{
		width: 85px;
		display: inline-block;
		margin-bottom: 10px;
	}
	span#error{
		color:red
	}
</style>
</head>
<body>
	<div class="login-form">
	<form action="<c:url value='/login.do'/>" method="post" onsubmit="return checkForm();">
		<label>用户名</label><input type="text" name="username" /><br/>
		<label>密码</label><input type="password" name="passwd" /><br/>
		<input type="submit" value="登录" />
		<br/><span id="error">${requestScope.error_info }</span>
	</form>
	</div>
</body>
<script type="text/javascript">
	function checkForm(){
		var username = document.forms[0].username.value;
		var passwd = document.forms[0].passwd.value;
		console.log(username + "," + passwd);
		if(!username){
			alert("用户名不能为空!");
			document.forms[0].username.focus();
			return false;
		}
		if(!passwd){
			alert("密码不能为空!")
			document.forms[0].passwd.focus();
			return false;
		}
		return true;
	}
</script>
</html>