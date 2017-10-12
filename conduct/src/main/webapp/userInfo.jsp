<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<link rel="stylesheet" type="text/css" href="style/userList.css">
	<script src="jquery-3.2.1.min.js"></script>
	<script>
		$(document).ready(function(){
			//跳转至注册页面
			$("#regiest").click(function(){
				window.location.href = "regiest.jsp";
			})
			//根据用户名查询
			$("#query").click(function(){
				var username = $("#username").val();
				window.location.href = "query?name="+username;
			})
			//用户查询页面
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
		<button class="button1" id="query">用户查询</button><br><br>
		<button class="button1" id="regiest">用户注册</button>
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
					<td width="100px">${user.balance}
						<%-- <c:set var="statues" value="${user.statues}"></c:set>
						<c:if test="${statues==1}">
							用户
						</c:if>
						<c:if test="${statues==2}">
							管理员
						</c:if> --%>
					</td>
					<td width="100px">编辑|<a id="delete" href="deleteUser?id=${user.id}&page=${page}&total=${total}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	</div>
</body>
</html>