<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	네이버 홈페이지로 이동
	<%
		response.sendRedirect("http://www.naver.com");
	%>
</body>
</html>