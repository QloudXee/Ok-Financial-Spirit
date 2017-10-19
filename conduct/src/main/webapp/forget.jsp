<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#name").mouseout(function(){
			var name = $("#name").val();
			var nameRegex = /^[^@#]{3,16}$/;
			if(name == null||name == ""){
				//alert("用户名不能为空!");
				$("#namemsg").text("用户名不能为空!");
			}else if(!nameRegex.test(name)){
				//alert("用户名为3~16个字符，且不能包含”@”和”#”特殊字符");
				$("#namemsg").text("用户名为3~16个字符，且不能包含”@”和”#”特殊字符");
			}else{
				$("#namemsg").text("");
			}
		})	
		$("#email").mouseout(function(){
			var email = $("#email").val();
			if(email == null || email == ""){
				//alert("邮箱不能为空!");
				$("#emailmsg").text("邮箱不能为空");
			}else{
				$("#emailmsg").text("");
			}
		})
		$("#password").mouseout(function(){
			var password = $("#password").val();
			var passwordRegex=/^[0-9A-Za-z_]\w{5,19}$/;
			if(password == null || password == ""){
				//alert("密码!");
				$("#passwordmsg").text("密码不能为空！");
			}else if(!passwordRegex.test(password)){
				//alert("密码长度必须在6个字符到20个字符之间!");
				$("#passwordmsg").text("密码长度必须在6个字符到20个字符之间!");
			}else{
				$("#passwordmsg").text("");
			}
		})	
		$("#repassword").mouseout(function(){
			var password = $("#password").val();
			var repassword = $("#repassword").val();
			if(repassword != password){
				//alert("两次密码必须一致！");
				$("#repasswordmsg").text("两次密码必须一致！");
			}else if(repassword == null || repassword == ""){
				$("#repasswordmsg").text("重复密码不能为空！");
			}else{
				$("#repasswordmsg").text("");
			}
		})
		$("#button1").click(function(){
			var name = $("#name").val();
			var nameRegex = /^[^@#]{3,16}$/;
			var email = $("#email").val();
			var password = $("#password").val();
			var passwordRegex=/^[0-9A-Za-z_]\w{5,19}$/;
			var repassword = $("#repassword").val();
			/* if(name != null && password != null && repassword == password && email != null
					&& nameRegex.test(name) && passwordRegex.test(passwrod)){ */
				console.log("forget?name="+name+"&password="+password+"&email="+email);
				window.location.href = "/conduct/forget.do?name="+name+"&password="+password+"&email="+email;
		})
	})
</script>
<title>忘记密码</title>
</head>
<body>
<form id="formforget">
	用户名：<input id="name"><br>
	<font id="namemsg"></font><br>
	
	邮箱：<input id="email"><br>
	<font id="emailmsg"></font><br>
	
	新密码：<input id="password"><br>
	<font id="passwordmsg"></font><br>
	
	重复密码：<input id="repassword"><br>
	<font id="repasswordmsg"></font><br>
	
	<!-- <button type="submit">提交</button> -->
	<input type="button" id ="button1"></input>
	<button type="reset">重置</button>
	<button type="button">返回</button>
</form>
</body>
</html>