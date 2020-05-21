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
<c:url var="urlAddress" value="https://search.naver.com/search.naver?">
		<!-- 쿼리스트링 -->
		<c:param name="sm" value="top_hty"></c:param>
		<c:param name="fbm" value="1"/>
		<c:param name="ie" value="utf-8"></c:param>
		<c:param name="query" value="한소희"></c:param>
</c:url>

<a href="${urlAddress }">검색이동</a>
<a href=https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=전지현>검색이동</a>


</body>
</html>