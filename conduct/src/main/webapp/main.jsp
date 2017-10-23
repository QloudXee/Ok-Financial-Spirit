<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<link rel="stylesheet" href="style/regiest.css">

<script src="js/jquery.min.js"></script>
<script src="js/calendar.js"></script>
<link rel="stylesheet" href="style/calendar.css">
<script>
	$(document).ready(function(){
		$("#logout").click(function(){
			window.location.href = "logout.do";
		})
		$("#alert").click(function(){
			var id = ${userLogin.id};
			window.location.href = "toAlertUser.do?id="+id;
		})
		$("#info").click(function(){
			window.location.href = "userInformation.jsp";
		})
	})
</script>
</head>
<body>
<div id="div0">
		<img src="images/logo.jpg" id="img1">
	</div>
	<div id="div1">
		<button id="alert" class="button1">账号管理</button><br><br>
		<button id="info" class="button1">账号信息</button><br><br>
		<button id="#" class="button1">理财助手</button><br><br><br><br>
		<button id="logout" class="button1">用户登出</button><br><br><br><br>
	</div>
	<div id="div2">
		<div id="rili">
				<div id="calendar" class="calendar"></div>
		</div>
		<div>
			<hr>
			<marquee scrollamount=2 id="roll" id="roll">
				<img src="images/deemo1.jpg" id="deemo1" height="200px" width="200px">
				<img src="images/deemo2.jpg" id="deemo1" height="200px">
				<img src="images/deemo3.jpg" id="deemo1" height="200px">
			</marquee>
		</div>
	</div>
	<br>
</body>
</html>