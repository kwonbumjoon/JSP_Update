<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String str = "안녕하세요!";
	int a = 5, b = -5;

	public int abs(int n) {
		if (n < 0) {
			n = -n;
		}
		return n;
	}%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 한쪽에만 기입해도 다른 한쪽에도 영향을 미친다. -->
	<%
	int c = 100;
	out.print(str + "<br>");
	out.print(c + "<br>");
	out.print(a + "의 절댓값 : " + abs(a) + "<br>");
	out.print(b + "의 절댓값 : " + abs(b) + "<br>");
	%>
	<hr>
	<%
	c = 120;
	out.print(str + "<br>");
	out.print(c + "<br>");
	out.print(a + "의 절댓값 : " + abs(a) + "<br>");
	out.print(b + "의 절댓값 : " + abs(b) + "<br>");
	%>
	
</body>
</html>