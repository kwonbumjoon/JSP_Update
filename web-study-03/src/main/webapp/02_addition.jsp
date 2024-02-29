<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%
	int num1 = 20;
	int num2 = 10;

	out.print(num1 + "+" + num2 + "=" + (num1 + num2));
	%>
</body>
</html>