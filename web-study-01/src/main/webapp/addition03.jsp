<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>출력 결과</h1>
	${n1} + ${n2} = ${add}
	<hr>
	<%
		int n1 = (int)request.getAttribute("n1");
		int n2 = (int)request.getAttribute("n2");
	%>
	n1 : <%= n1 %><br>
	n2 : <%= n2 %>
</body>
</html>