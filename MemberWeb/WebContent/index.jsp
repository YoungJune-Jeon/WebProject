<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	Member member =(Member)session.getAttribute("member");
%>

<title> 멤버 로그인</title>
</head>
<body>

<% if (member !=null) { %>
[<%= member.getUserName() %>] 님 환영합니다.

	<a href="/Logout">로그아웃</a>
	<a href="/myinfo?userId=<%= member.getUserId() %>">마이페이지</a>
	<a href="#">업로드</a>
	<a href="#">다운로드</a>
	<a href="/memberList">전체회원 조회</a><br>	
	<a href="/notice">공지사항</a> <br />
	<h1> 안녕하세요</h1>
<% } %>	


<% if(member == null) { %>

	<h1>로그인 페이지</h1>
	<form action="/login" method="post">
		ID : <input type="text" name="userId" id="userId"> <br>
		PW : <input type="password" name="userPwd" id="userPwd"><br>   
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
		<a href="/views/member/enroll.html">회원 가입</a>
		<a href="/notice">공지 사항</a>
	</form>
	
<% } %>

</body>

</html>



