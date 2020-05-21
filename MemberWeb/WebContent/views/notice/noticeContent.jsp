<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@page import="notice.model.vo.NoticeComment"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Notice notice = (Notice)request.getAttribute("content"); %>
  	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>상세내용</title>
</head>
<body>
<center>
	<h2>제목 : <%=notice.getSubject() %></h2>
	<h6>글번호 : <%=notice.getNoticeNo() %>
	/ 글쓴이 : <%=notice.getUserId() %>
	/ 작성일 : <%=notice.getRegDate() %>
	</h6>
	<h3>
	<%= notice.getContents() %></h3>
	<hr>
	<h4>댓글 목록</h4>
	<table border="1px">
		<tr><th>댓글</th><th>아이디</th><th>날짜</th></tr>

			<%
				for (NoticeComment list : notice.getComments()) {
			%>
			<tr>
				<td><%=list.getContent()%></td>
				<td><%=list.getUserId()%></td>
				<td><%=list.getRegdate()%></td>
				<td><a href="javascript:void(0)" onclick="showModifyComment(this,'<%=list.getContent()%>',
				'<%=list.getUserId()%>','<%=list.getRegdate()%>');">수정</a>
				<td><a href="/DeleteComment?commentNo=<%=list.getCommentNo()%>&noticeNo=<%=notice.getNoticeNo() %>">삭제</a></td>
				</tr>
				
			<tr style="display:none">
				<td><input type="text" size="40" id="modifyMent" value="<%=list.getContent()%>"></td>
				<td colspan=2>
				<a href="javascript:void(0)" onclick="modifyComment(this,'<%=list.getCommentNo()%>');">수정완료</a>
				<a href="javascript:void(0)" onclick="modifiyCancel(this);">취소</a>
				</td>
				
			</tr>	
				<%}%>		
	</table>
	
	<form action="/modifyComment" id="modifyForm" method="post">
		<input type="hidden" id="modComment" name="modComment">
		<input type="hidden" id="modNoticeNo" value="<%=notice.getNoticeNo()%>" name="modNoticeNo">
		<input type="hidden" id="modCommentNo" name="modCommentNo">
	</form>
	
	
	<a href="/noticeModify?noticeNo=<%=notice.getNoticeNo()%>">수정</a>
	<a href="/notice">목록</a>
	<a href="/noticeDelete?noticeNo=<%=notice.getNoticeNo()%>" onclick="return question()">삭제</a>
	<form action="/noticeCommentWrite?noticeNo=<%=notice.getNoticeNo()%>" method="post">
	comment:<input type="text" name="comment" size="50" placeholder="댓글을 작성해보세요">
	<input type="submit" value="작성">
	<script>
		function question(){
			return window.confirm("정말로 삭제하시겠습니까?");	
			
	}
		
		function showModifyComment(obj,comment,userId,regDate){
			console.log(obj);
			$(obj).parents("tr").next().show();
			$(obj).parents("tr").hide();
		}
		
		function modifiyCancel(obj){
			$(obj).parents("tr").prev().show();
			$(obj).parents("tr").hide();
		}
		
		function modifyComment(obj,commentNo){
			var comment=$(obj).parent().prev().find("input").val();
			$("#modCommentNo").val(commentNo);
			$("#modComment").val(comment);
			$("#modNoticeNo").val($("#modNoticeNo").val());
			$("#modifyForm").submit();
		}
		
		
	</script>
	</center>
</body>
</html>