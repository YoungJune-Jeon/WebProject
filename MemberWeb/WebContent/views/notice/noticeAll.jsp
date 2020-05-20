<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "member.model.vo.*, notice.model.vo.*, java.util.*"%>
<%
	/* ArrayList<Notice> nList = (ArrayList<Notice>)request.getAttribute("nList"); */
	PageData pageData = (PageData)request.getAttribute("pageData");
	ArrayList<Notice> noticeList = pageData.getPageList();
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
</head>
<body>
	<center>
		<h1>공지사항</h1>
		<table border="1">
			<tr><th>글번호</th><th>글제목</th><th>글쓴이</th><th>작성일</th></tr>
			<% for(Notice notice : noticeList) { %>
			<tr>
				<td><%= notice.getNoticeNo() %></td>
				<td><a href="/noticeSelect?noticeNo=<%= notice.getNoticeNo() %>"><%= notice.getSubject() %></a></td>
				<td><%= notice.getUserId() %></td>
				<td><%= notice.getRegDate() %></td>
			</tr>
			<% } %>
			<tr>
				<td colspan="3" align="center">
					<form action="/noticesearch" method="get">
						<input type="text" name="search">
						<input type="submit" value="검색" />
					</form>
				</td>
				<% if(member != null && member.getUserId().equals("admin")) { %>
				<td align="right">
					<!-- <form action="/views/notice/noticeWrite.html" method="post"> -->
					<form action="/noticeWriteForm" method="post">
						<input type="submit" value="글쓰기">
					</form>
				</td>
				<% } %>
			</tr>	
			<tr>
				<td colspan="4" align="center">
					<%= pageData.getPageNavi() %>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>