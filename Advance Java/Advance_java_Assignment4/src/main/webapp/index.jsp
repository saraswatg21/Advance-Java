<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style><%@include file="Styles/styles.css"%></style>
</head>

<body>
	<div class="container">
		<h3 style="background-color: pink; width:100%;padding-left:0;margin:0;text-align:center;"> Login</h3>
		<form action="LogIn" method="post" >
			<div><b>Username</b>   <input style="margin-left: 50px;" type="text" name="username" /></div>
			
			<div><b>Password</b>   <input style="margin-left: 50px;" type="password" name="password" /></div>
			
			<input type="submit" value="Login" style="width: 25%" >
		</form>
	</div>
</body>
</html>
