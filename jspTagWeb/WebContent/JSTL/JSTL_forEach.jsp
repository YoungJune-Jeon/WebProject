<%@page import="test.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<Member>list = new ArrayList<Member>();
		list.add(new Member("user11","pass11","일영자"));
		list.add(new Member("user22","pass22","이영자"));
		list.add(new Member("user33","pass33","삼영자"));
		request.setAttribute("list",list);
	%>
	<table border="1">
		<tr><th>순번</th><th>아이디</th><th>비번</th><th>이름</th></tr>
		<c:forEach items="${list }" var="member" varStatus="index">
			<tr>
				<td> <c:out value="${index.count }"></c:out></td>
				<td> <c:out value="${member.id }"></c:out></td>
				<td> <c:out value="${member.passwd }"></c:out></td>
				<td> <c:out value="${member.name }"></c:out></td>
			
			</tr>
		</c:forEach>
	</table>
</body>
</html>