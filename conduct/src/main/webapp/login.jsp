<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
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
	   <form id = "form1" name = "form1" action="login"  method="post">
		<div class="box2">
  	 		<label class="">用户名称：</label><input id="userName" name="name" type="text"  placeholder="请输入您的用户名！"><br>
  	 		<label class="">用户密码：</label><input id="userPassword" name="password" type="password" placeholder="请输入您的密码！"><br>
		</div>	
	  <div class="box3">
		   <button type="submit" name="button">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <button type="reset" name="button">重置</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <button type="button" name="button"><a id="register" href="userRegister.jsp">注册</a></button><br>
			</div>
		</form>
		 <hr>
		   <footer class="footer"> Copyright &copy 2017.JAVA1班OK小组版权所有 </footer>
	   </div>
	</div>
</body>
</html>