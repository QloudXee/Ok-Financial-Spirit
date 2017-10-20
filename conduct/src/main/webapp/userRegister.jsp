<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script>
	$(document).ready(function(){
		$("#name").mouseout(function(){
			var name= $("#name").val();
			var nameRegex = /^[^@#]{3,16}$/;
			if (!nameRegex.test(name)) {
				$("#f1").html("用户名为3~16个字符，且不能包含”@”和”#”特殊字符!");
			}else if (nameRegex.test(name)) {
				$("#f1").html(" ");
				$.ajax({
					  type: "GET",
					  url: "check.do?k="+Math.random(),
					  dataType: "json",
					  data : "name="+name,
					  success : function(msg){
						  $("#f1").html(msg.msg);
					  },
					  error : function(){
						alert("error!");  
					  }
					});
			}
		});
		$("#password").mouseout(function(){
			var password = $("#password").val();
			var passwordRegex=/^[0-9A-Za-z_]\w{5,19}$/;
			if (!passwordRegex.test(password)) {
				$("#f2").html("密码长度必须在6个字符到20个字符之间!");
			}else if (passwordRegex.test(password)) {
				$("#f2").html(" ");
			}
		});
		$("#repassword").mouseout(function(){
			 var t= $("#repassword").val();
			var passwordRegex=/^[0-9A-Za-z_]\w{5,19}$/;
			if (!passwordRegex.test(t)) {
				$("#f3").html("密码长度必须在6个字符到20个字符之间!");
			}else if (passwordRegex.test(t)) {
				$("#f3").html(" ");
			}
		});
	})
	</script>
</head>
<body>
	<video id="v1" autoplay="autoplay" loop="loop" style="width: auto;">
			<source src="video/6.mp4">
	</video>
	<div class="box1">

		<div class="text">
			<div id="img"><img src="images/logo.jpg"></div>
			<div class ="text2">
				<span class="t1">理财精灵注册</span><br>
				<span class="t2">每一天，<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									让你的Money更可爱！</span>
			</div>

		</div>
		<div class="body_center">
		<form id="form2" action="*" method="post">
		<div class="box4">
  	 		<label class="">用户名称：</label><input id="name" name="name" type="text"  placeholder="请输入您的用户名！"><br>
  	 		<font id="f1" ></font><br>
  	 		<label class="">用户密码：</label><input id="password" name="password" type="password" placeholder="请输入您的密码！"><br>
  	 		<font id="f2"></font><br>
  	 		<label class="">重复密码：</label><input id="repassword" name="repassword" type="password" placeholder="请确认您的密码！"><br>
  	 		<font id="f3"></font><br>
			<label class="">电子邮箱：</label><input id="email" name="email" type="email" onblur="Email()" placeholder="请输入您的邮箱！"><br>
			<font id="f4"></font><br>
		</div>
		<div class="box5">
			<label class="">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别 :</label>
			<input type="radio" name="usergender" id="male" value="男" checked="checked" required><label for="male">男</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="usergender" id="male" value="女" checked="checked" required><label for="male">女</label>		
		</div>
		<div class="box6">
		   <button type="button" name="button">返回</a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <button type="reset" name="button">重置</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <button type="button" name="button">注册</button>

			</div>
 	
		</form>
		</div>
	</div>