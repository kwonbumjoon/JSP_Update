<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 리스트 - 관리자 페이지</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right;"><a
					href="productWrite.do">상품등록</a></td>
			</tr>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>가격</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.code}</td>
					<td>${product.name}</td>
					<td><fmt:formatNumber value="${product.price}" pattern="#,###" />원</td>
					<td><a href="productUpdate.do?code=${product.code}">상품 수정</a>
					<td><a href="productDelete.do?code=${product.code}">상품 삭제</a>
					</td>
			
			</c:forEach>
		</table>
	</div>
</body>
</html>