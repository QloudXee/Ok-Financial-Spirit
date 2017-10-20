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
			//上一页点击事件
			$("#previous").click(function(){
				window.location.href = "previous.do?total="+${total}+"&page="+${page};
			})
			//下一页点击事件
			$("#next").click(function(){
				window.location.href = "next.do?total="+${total}+"&page="+${page};
			})
			//页面跳转
			$("#pageButton").click(function(){
				var pageNum = $("#pageNum").val();
				window.location.href = "toPage.do?total="+${total}+"&page="+pageNum;
			})
			//根据用户名查询
			$("#query").click(function(){
				var username = $("#username").val();
				window.location.href = "query.do?name="+username;
			})
			//用户退出
			$("#logout").click(function(){
				window.location.href = "logout.do"
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
		<button class="button1" id="regiest">用户注册</button><br><br>
		<button class="button1" id="logout">用户退出</button><br><br>
	</div>
	<div id="div2">
		<div id="top">
			&nbsp;&nbsp;&nbsp;&nbsp;
			用户名称：<input type="text" name="username" id="username">
			<button id="query">查询</button>
		</div>
	<br>
	<table>
		<tbody>
			<tr width=100%>
				<td width="40px">全选</td>
				<td width="120px">用户名称：</td>
				<td width="70px">密码</td>
				<td width="150px">邮箱</td>
				<td width="80px">性别</td>
				<td width="100px">余额</td>
				<td width="100px">操作</td>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr width=100%>
					<td width="40px"><input type="radio"></td>
					<td width="110px">&nbsp; ${user.name} &nbsp;</td>
					<td width="70px">${user.password}</td>
					<td width="150px">${user.email}</td>
					<td width="80px">${user.sex}</td>
					<td width="100px">${user.balance}</td>
					<td width="100px"><a id="alert" href="toAlertUser.do?id=${user.id}&name=${user.name}&balance=${user.balance}">编辑</a>|
					<a id="delete" href="deleteUser.do?id=${user.id}&page=${page}&total=${total}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<hr>
		<a id="previous" href="#">上一页</a>
		<a id="next" href="#">下一页</a>
		<span id="num">第${page}页</span>
		<span id="total">共${total}页</span>
		<font>跳转至第</font><input type="text" name="pageNum" id="pageNum"><font>页</font>
		<button id="pageButton">跳转</button>
	</div>
</body>
</html>