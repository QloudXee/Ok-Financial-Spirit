<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
<link rel="stylesheet" href="style/regiest.css">
<script src="jquery-3.2.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#back").click(function(){
				window.location.href="main.jsp";
			})
			$("#alert").click(function(){
				var id = ${userLogin.id};
				window.location.href = "toAlertUser.do?id="+id;
			})
		})
	</script>
</head>
<body>
<div id="div0">
		<img src="images/logo.jpg" id="img1">
	</div>
	<div id="div1">
		<button id="alert" class="button1">修改信息</button><br><br>
		<button id="back" class="button1">返回首页</button><br><br>
	</div>
	<div id="div2">
		<div id="top">
			<b> 修 改 用 户 </b>
		</div>
		<div id="mid">
		<br><br>
		<form action="alertUser.do">
			<input type="text" id="input0" value="${userLogin.id}" name="id" hidden="hidden">
			<input type="text" id="input0" value="${userLogin.balance}" name="balance" hidden="hidden">
			用 户 名 称 ： <input type="text" id="input1" name="name" readonly="readonly" value="${userLogin.name}"><br><br><br>
			登 录 密 码 ： <input type="password" id="input1" name="password" readonly="readonly" value="${userLogin.password}"><br><br><br>
			用 户 余 额 ： <input type="password" id="input1" name="balance" readonly="readonly" value="${userLogin.balance}"><br><br><br>
			电 子 邮 箱 ： <input type="email" id="input1" name="email" readonly="readonly" value="${userLogin.email}"><br><br><br>
			性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 别 ： 
			<input type="text" name="sex" readonly="readonly" value="${userLogin.sex}">
		</div>
		<hr><br><br>
		</form>
	</div>
	<br>
</body>
</html>