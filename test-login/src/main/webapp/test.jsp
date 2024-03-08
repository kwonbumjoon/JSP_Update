<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dao.MemberDAO"%>
<%@ page import="java.sql.Connection"%>

<%
MemberDAO memDao = MemberDAO.getInstance();

Connection con = memDao.getConnection();

out.println("DB연결 완료 : " + con);
%>