<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserForm</title>
	<link rel="stylesheet" type="text/css" href="css/success.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/body.css">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
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
			<div class="s4"><span>当前登录账户:<a href="">蹲地炮</a></span></div>
			<div class="s5"><a href="login.html">退出</a></div>
		</div>
	</div>
	<div class="left_body">
		<div id = "a1"><a href="userForm.html">用户查询</a><hr></div>
		<div id = "a2"><a href="userFees.html">费用记录</a><hr></div>
		<div id = "a3"><a href="userChart.html">费用统计</a><hr></div>
	</div>
	<div class="boby_menu">
            <div id="h0">
				<div id="h1">
					<font size="10">用户信息</font>
				</div>
			</div>
				<div id="h2">
				<font size="6">
					<p>用户名称：${user.name }</p>
					<p>用户性别：${user.sex }</p>
					<p>用户余额：${user.balance }</p>
					<p>用户邮箱：${user.email }</p>
                    </font>
                    </div>
					<div id="button_1" >
						<button > 
						<a href="userModifyData.html"class="button_2">修改资料</a></button>
						<button >取消</button>
					</div>

				</div>
			</div>
		</body>
		</html>