<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	pageContext : <%= pageContext.getAttribute("name") %> <br>
	request : <%= request.getAttribute("name") %> <br>
	session : <%= session.getAttribute("name") %> <br>
	application : <%= application.getAttribute("name") %> <br>
	<a href="07_thirdPage.jsp">third page</a>
</body>
</html>