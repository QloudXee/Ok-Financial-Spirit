<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<link rel="stylesheet" href="style/regiest.css">
<script src="jquery-3.2.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#query").click(function(){
				window.location.href = "getAll";
			})
		})
	</script>
</head>
<body>
<div id="div0">
		<img src="images/logo.jpg" id="img1">
	</div>
	<div id="div1">
		<button id="query" class="button1">用户查询</button><br><br>
		<button id="regiest" class="button1">用户注册</button><br><br><br><br>
		<button class="button1">账号管理</button><br><br>
		<button class="button1">理财助手</button><br><br>
	</div>
	<div id="div2">
	</div>
	<br>
</body>
</html>