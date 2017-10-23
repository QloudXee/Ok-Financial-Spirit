<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
	<link rel="stylesheet" type="text/css" href="style/userList.css">
	<script src="jquery-3.2.1.min.js"></script>
	<script>
		$(document).ready(function(){
			//跳转至注册页面
			$("#regiest").click(function(){
				window.location.href = "userRegister.jsp";
			})
			//重新加载列表
			$("#query1").click(function(){
				window.location.href = "getAll.do";
			})
			//根据用户名查询
			$("#query").click(function(){
				var username = $("#username").val();
				window.location.href = "query.do?name="+username;
			})
			//用户退出
			$("#logout").click(function(){
				window.location.href = "logout.do";
			})
		})
		
	</script>
	
</head>
<body>
	<div id="div0">
		<img src="images/logo.jpg" id="img1">
	</div>
	<div id="div1">
		<button class="button1" id="query1">用户查询</button><br><br>
		<button class="button1" id="regiest">用户注册</button><br><br><br><br>
		<button class="button1" id="logout">管理退出</button><br><br>
	</div>
	<div id="div2">
		<div id="top">
			&nbsp;&nbsp;&nbsp;&nbsp;
			用户名称：<input type="text" name="username" id="username">
			<button id="query">查询</button>
		</div>
		<div id="mid">
				<img src="images/deemo3.jpg" width="100%" height="340px">
				<br><br><br>
				<h1 id="welcome">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您!
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						管理员:&nbsp;&nbsp;${user.name}</h1>
		</div>
	</div>
</body>
</html>