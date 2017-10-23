<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script type="text/javascript">
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
</script>
</head>
<body>
    	<table>
    		<thead>
    			<tr>
    				<th>id</th>
    				<th>详情</th>
    				<th>类型</th>
    				<th>rmb</th>
    				<th>时间</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach items="${list}" var="order">
    				<tr>
    					<td>${order.id }</td>
    					<td>${order.orderDescribe }</td>
    					<td><c:if test="${order.type==0}">
    							收入
    						</c:if>
    						<c:if test="${order.type==1}">
    							支出
    						</c:if>
    					</td>
    					<td>${order.money }</td>
    					<td>${order.date }</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    	<button type="button" id="upPage">上一页</button>
    	<button type="button" id="downPage">下一页</button>
</body>
</html>