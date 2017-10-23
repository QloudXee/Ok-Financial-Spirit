<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userFees</title>
	<link rel="stylesheet" type="text/css" href="css/success.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/body.css">
	<link rel="stylesheet" type="text/css" href="css/fees.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.banner.revolution.min.js"></script>
	<script type="text/javascript" src="js/banner.js"></script>
</head>
<body>
	<div id="wrapper">
		<div class="fullwidthbanner-container">
			<div class="fullwidthbanner">
				<ul>
					<li data-transition="3dcurtain-horizontal" data-slotamount="15" data-masterspeed="300">
						<img src="images/slides/slide3.jpg" alt="" />									
					</li>
					<li data-transition="3dcurtain-vertical" data-slotamount="15" data-masterspeed="300" data-link="#">
						<img src="images/slides/slide5.jpg" alt="" />
					</li>
					<li data-transition="papercut" data-slotamount="15" data-masterspeed="300" data-link="#">
						<img src="images/slides/slide2.jpg" alt="" />
					</li>
					<li data-transition="turnoff" data-slotamount="15" data-masterspeed="300">
						<img src="images/slides/slide1.jpg" alt="" />
					</li>	
					<li data-transition="flyin" data-slotamount="15" data-masterspeed="300">
						<img src="images/slides/slide6.jpg" alt="" />	 
					</li>					
				</ul>
			</div>
		</div>
	</div>
	<div class="toBody">
		<div class="tohead">
			<img src="images/logo.jpg">
			<div class="s1"><span>ok理财！你的最佳选择</span></div>
			<div class="s2"><a href="userLoginSuccess.html">首页</a></div>
			<div class="s3"><marquee id="welcome"> 欢迎进入您的个人理财精灵</marquee></div>
			<div class="s4"><span>当前登录账户:<a href="">大吉</a></span></div>
			<div class="s5"><a href="login.html">退出</a></div>
		</div>
	</div>
	<div class="left_body">
		<div id = "a1"><a href="userForm.html">用户信息</a><hr></div>
		<div id = "a2"><a href="userFees.html">费用记录</a><hr></div>
		<div id = "a3"><a href="userChart.html">费用统计</a><hr></div>
	</div>
	<div class="boby_menu">
		<div class="box4">
		<div class="b1">
			<select id="x1" name="level" size="">
			<option value=""></option>
			<option class="o1" value="">全部查询</option>
             <option class="o1" value="">收入查询 </option>
             <option class="o2" value="">支出查询 </option>
           	</select>
           	<label>账单查询：</label><input id="i2" type="text" name="" placeholder="请输入你想查询的内容！">
		</div>	
		
		<table class="t1" border="1">
				<thead>
					<tr>	
						<th style="display: none;"></th>					
						<th>编号</th>
						<th>账单详情</th>
						<th>类型</th>
						<th>金额</td>
						<th>时间</th>
						<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<!-- 设置变量index -->
					<c:set var="index" value="${(page-1)*10 }"></c:set>
					<c:forEach items="${list }" var="order">
						<tr>
							<td id="id" style="display: none;">${order.id }</td>
							<!-- 让index自增 -->
							<c:set var="index" value="${index+1 }"></c:set>
							<td>${index }</td>
							<td>${order.orderDescribe }</td>
							<td>
								<c:if test="${order.type==0}">
    								收入
    							</c:if>
    							<c:if test="${order.type==1}">
    								支出
    							</c:if>
							</td>
							<td>${order.money }</td>
							<td>${order.date }</td>
							<td>
							<a href="useruFeesUpdate.html">编辑</a>&nbsp;
								<a href="*">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
				</div>	
		</table>
	<button type="button" id="upPage">上一页</button>
    	<button type="button" id="downPage">下一页</button>
	</div>
	<script type="text/javascript">
		$(function(){
			$(function(){
				//重新加载列表
				//$("#query1").click(function(){
				//	window.location.href = "getAll";
				//})
				//上一页点击事件
				$("#upPage").click(function(){
					window.location.href = "upPage?total="+${total}+"&page="+${page};
				})
				//下一页点击事件
				$("#downPage").click(function(){
					window.location.href = "downPage?total="+${total}+"&page="+${page};
				})
			})
		})
	</script>
</body>
</html>