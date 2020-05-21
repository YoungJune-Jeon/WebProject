<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 제어문</title>
</head>
<body>
	<h3> c:if문</h3>
	<form action ="JSTL_if.jsp">
		숫자입력:<input type="text" name="value1">
		<input type="submit" value="전송">
	</form>
	<br>
	<hr>
	
	
	<h3> c:choose문</h3>
	<form action="JSTL_choose.jsp">
		1~3 중 입력하세요 : <input type="text" name ="value2">
		<input type="submit" value="전송">
	</form>
	
	
	<h3> c:forEach문</h3>
	<a href="JSTL_forEach.jsp">forEach문 이동</a>
	
	
	<h3>c:forTokens문</h3>
	<form action="JSTL_forTokens.jsp">
		당신의 취미를 적어보세요(여러개면 ,로 구분하세요)
		<br>
		<input type="text" name="hobby">
		<input type="submit" value="전송">
	</form>
	
	<h3>c:url 태그</h3>
	<a href="JSTL_url.jsp">url 태그</a>
	
</body>
</html>