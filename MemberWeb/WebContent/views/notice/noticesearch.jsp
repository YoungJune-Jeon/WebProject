<%@page import="member.model.vo.Member"%>
<%@page import="notice.model.vo.pageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="notice.model.vo.Notice, java.util.*" %>

<%  
pageData pd = (pageData)request.getAttribute("pageData");
ArrayList<Notice> noticeList = pd.getPageList();	
String search=(String)request.getAttribute("search");
Member member=(Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
	<h1>공지사항</h1>
	<table border="1px">
		<tr><th>글번호</th><th>제목</th><th>글쓴이</th><th>작성일</th></tr>
		<%for(Notice n : noticeList){ %>
		<tr>
			<td><%=n.getNoticeNo()%></td>
			<td><%=n.getSubject()%></td>
			
			<td><%=n.getUserId()%></td>
			<td><%=n.getRegDate()%></td>
		<%} %>
		</tr>
		<tr>
			<td colspan="3" align="center">
			<form action="noticeSearch" method="get">
				<input type="text" name="search" value="<%=search%>">
				<input type="submit" value="검색">
			
			</form>
			</td>
			<td align="right">
			<form action="" method="post">
				<% if(member != null && member.getUserId().equals("admin")) {%>
				<input type ="submit" value="글쓰기">
				<%}%>
			</form>
		</tr>
		<tr>
		<td colspan="4" align="center">
		<%=pd.getPageNavi()%>
		</td>
		</tr>
	</table>
	<a href="/">메인페이지로 이동</a>
</center>
</body>
</html>