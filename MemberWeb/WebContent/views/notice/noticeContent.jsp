<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.*, java.util.*"%>
<%
	Notice notice = (Notice)request.getAttribute("content");
	ArrayList<NoticeComment> comments = notice.getComments();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세 내용</title>
</head>
<body>
	<h2>제목 : <%= notice.getSubject() %></h2>
	<h6>글번호 : <%= notice.getNoticeNo()%>
		/ 글쓴이 : <%= notice.getUserId() %>
		/ 작성일 : <%= notice.getRegDate() %>
	</h6>
	<h3><%= notice.getContents() %></h3>
	
	<a href="/noticeModify?noticeNo=<%= notice.getNoticeNo()%>">수정</a>
	<a href="/notice">목록</a>
	<a href="/noticeDelete?noticeNo=<%= notice.getNoticeNo()%>" onclick="return question();">삭제</a>
	
	<form action="/noticeCommentWrite" method="post">
	comment : <input type="text" name="comment" placeholder="댓글을 작성해보세요">
	<input type="hidden" name="noticeNo" value="<%= notice.getNoticeNo()%>"/>
	<input type="submit" value="작성">
	</form>
	
	<!-- 댓글부분 -->
	<table>
		<tr><th>댓글</th><th>아이디</th><th>날짜</th></tr>
		<% for (NoticeComment comment : comments) { %>
			<tr>
				<td><%= comment.getContent() %></td>
				<td><%= comment.getUserId() %></td>
				<td><%= comment.getRegDate() %></td>
			</tr>
		<% } %>
	</table>
	
	<!-- 쿠폰발급때 사용하기 -->
	<script>
		function question() {
			var result = window.confirm("정말로 삭제 하시겠습니까?");
			if(result) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>