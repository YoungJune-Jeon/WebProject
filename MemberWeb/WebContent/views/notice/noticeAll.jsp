<%@page import="member.model.vo.Member"%>
<%@page import="notice.model.vo.pageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page import="notice.model.vo.Notice, java.util.*"
	 %>

<%  
pageData pd = (pageData)request.getAttribute("pageData");
ArrayList<Notice> noticeList = pd.getPageList();
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
		
		<c:forEach items="${pageData.pageList }" var="notice"  varStatus="i">
		<tr>
			<td><c:out value="${notice.noticeNo }"></c:out></td>
			<td><a href="/noticeSelect?noticeNo=${notice.noticeNo }">${notice.subject }</a></td>
			<td><c:out value="${notice.userId }"></c:out></td>
			<td><c:out value="${notice.contents }"></c:out></td>
			<td><c:out value="${notice.regDate }"></c:out></td>
			</tr>
		</c:forEach>
		
		
		<%-- <%for(Notice n : noticeList){ %>
		
		
		<tr>
			<td><%=n.getNoticeNo()%></td>
			<td><a href="/noticeSelect?noticeNo=<%=n.getNoticeNo()%>"><%=n.getSubject()%></a></td>
			
			<td><%=n.getUserId()%></td>
			<td><%=n.getRegDate()%></td>
		<%} %>
		</tr> --%>
		<tr>
			<td colspan="3" align="center">
			<form action="noticeSearch" method="get">
				<input type="text" name="search">
				<input type="submit" value="검색">
			
			</form>
			</td>
			
			<c:if test="${sessionScope.member!=null && sessionScope.member.userId=='admin' }">
			<td align="right">
			<form action="views/notice/noticeWrite.html" method="post">
			<input type ="submit" value="글쓰기">
			</form>
			</c:if>
			<%-- <% if(member != null && member.getUserId().equals("admin")) {%>
				
				<%}%> --%>
				
			
		</tr>
		<tr><td colspan="4" align="center">
		${pageData.pageNavi }
		</td></tr>
	</table>
</center>
</body>
</html>