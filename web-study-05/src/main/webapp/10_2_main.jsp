<%@page import="unit01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	MemberVO vo =  (MemberVO)session.getAttribute("member");
	
	/* if (session.getAttribute("loginUser") == null) { */
	if (session.getAttribute("member") == null) {
		response.sendRedirect("10_2_loginForm.jsp");
	} else {
	%>
<%-- 	<%=session.getAttribute("loginUser")%>님 안녕하세요!<br> --%>
	<%=vo.getName()%>님 안녕하세요!<br>
	<%=vo.getId() %><br>
	<%=vo.getPwd()%><br>
	
	<br> 저희 홈페이지에 방문해 주셔서 감사합니다.
	<br> 즐거운 시간 되세요....
	<br>
	<form method="post" action="10_2_logout.jsp">
		<input type=submit value="로그아웃">
	</form>
	<%
	}
	%>
</body>
</html>