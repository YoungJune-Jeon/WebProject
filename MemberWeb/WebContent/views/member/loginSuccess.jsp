<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
         Member member=(Member)session.getAttribute("member");
         /* object 형태로 가져오기 때문에 형변환해야함 (Member)로 형변환 */
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0.2 url=/">
<!-- 5초 후 /로 이동 -->
<title>Insert title here</title>
</head>
<body>
	<h1>로그인을 성공하였습니다</h1>
   [ <%=member.getUserName()%> ]님 환영합니다.<br>
   <h2>5초 후 메인페이지로 이동합니다.</h2>
	
</body>
</html>