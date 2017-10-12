<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
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
		<button id="regiest" class="button1">用户注册</button>
	</div>
	<div id="div2">
		<div id="top">
			<b>新 增 & 编 辑 用 户</b>
		</div>
		<div id="mid">
		<br><br>
		<form action="regiest">
			用 户 名 称 ： <input type="text" id="input1" name="name"><br><br><br>
			登 录 密 码 ： <input type="password" id="input1" name="password"><br><br><br>
			重 复 密 码 ： <input type="password" id="input1" name="repassword"><br><br><br>
			电 子 邮 箱 ： <input type="email" id="input1" name="email"><br><br><br>
			性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 别 ： 
			<input type="radio" name="sex" value="男">&nbsp;&nbsp;男&nbsp;&nbsp;
			<input type="radio" name="sex" value="女">&nbsp;&nbsp;女
		</div>
		<hr><br><br>
		<button id="button2" type="submit">保存</button>
		<button type="reset" id="button3">重置</button>
		<button id="button4">返回</button>
		</form>
	</div>
	<br>
</body>
</html>