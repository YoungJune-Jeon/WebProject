<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.*"%>
<%
	Notice notice = (Notice)request.getAttribute("content");
%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정</title>
</head>
<body>
	<h1>공지사항 수정</h1>
	<form action="/noticeModifyCommit" method="post">
		<input type="text" size="100" name="subject" value="${notice.subject }"><br><br>
		<textarea name="content" cols="100" rows="30">${notice.contents }></textarea><br><br>
		<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
		<!-- 사용자에게 보일 필요는 없고 수정내용을 반영하게 위해서 noticeNo를 가져간다 -->
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>