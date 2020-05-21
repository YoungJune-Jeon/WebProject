<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="1 url=/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h1>로그인을 성공하였습니다!</h1>
	[<%= member.getUserName() %>]님 환영 합니다.<br>
	<h2>5초 후 메인페이지로 이동합니다.</h2>
</body>
</html>