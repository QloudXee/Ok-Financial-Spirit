<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="lessMoney" method="get">
	描述：<input type="text" name="describe"><br />
	类型：<input type="radio" name="type" value="0">收入
		<input type="radio" name="type" value="1">支出<br />
	money:<input type="text" name="jsp_money"><br />
	<button type="submit">提交</button>
</form>
</body>
</html>