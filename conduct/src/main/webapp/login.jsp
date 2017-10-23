<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script>
	var a=""+'${loginMsg}';
	if(a!=""){
		alert(a);
		a="";
	}
		$(document).ready(function(){
			
			$("#forget").click(function(){
				window.location.href="forget.jsp";
			})
			$("#regist").click(function(){
				window.location.href="userRegister.jsp";
			})
			$("#login").click(function(){
				var name = $("#userName").val();
				var password = $("#userPassword").val();
				window.location.href="login.do?name="+name+"&password="+password;
			})
		})
	</script>
</head>
<body>

	<video id="v1" autoplay="autoplay" loop="loop" style="width: auto;">
			<source src="video/3.mp4">
	</video>
	<div class="box1">
		<div class="text">
			<div id="img"><img src="images/logo.jpg"></div>
			<h1>个人理财精灵</h1>
		</div>
		<div class="boby_menu"> 
	   <form id = "form1" name = "form1" action="login.do"  method="post">
		<div class="box2">
  	 		<label class="">用户名称：</label><input id="userName" name="name" type="text"  placeholder="请输入您的用户名！"><br>
  	 		<label class="">用户密码：</label><input id="userPassword" name="password" type="password" placeholder="请输入您的密码！"><br>
		</div>	
	  <div class="box3">
		   <button type="submit" id="login">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <button type="button" id="forget">忘记密码</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <button type="button" id="regist">注册</button><br>
			</div>
		</form>
		 <hr>
		   <footer class="footer"> Copyright &copy 2017.JAVA1班OK小组版权所有 </footer>
	   </div>
	</div>
</body>
</html>