
<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>관리자 : 회원 관리 페이지</h1>

<table border="1">
	<tr>
		<th>아이디</th><th>이름</th><th>나이</th><th>이메일</th><th>휴대폰</th><th>주소</th><th>성별</th>
		<th>취미</th><th>가입날짜</th>
	</tr>
	
		<%for(Member m: list){ %>
		<tr>
		<td><a href="/myinfo?userId=<%=m.getUserId()%>"><%=m.getUserId()%></a></td>
		<td><%=m.getUserName()%></td>
		<td><%=m.getAge()%></td>
		<td><%=m.getEmail()%></td>
		<td><%=m.getPhone()%></td>
		<td><%=m.getAddress()%></td>
		<%if(m.getGender().equals("M")){%>
		<td>남자</td>
		<%}else{%>
		<td>여자</td>
		<%} %>
		<td><%=m.getHobby()%></td>
		<td><%=m.getEnrollDate()%></td>
		<tr>
		<%} %>
	
	
</table>
	<a href="/">메인 페이지로 이동</a>


</body>
</html>