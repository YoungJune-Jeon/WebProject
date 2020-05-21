<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL Core Tags 실습</h2>
	<hr>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20"></c:set>
	
	<ol>
		<li>결과 : ${num1 }+${num2 }=${num1+num2 }</li>
	</ol>
	
	<br><br>
	<h2>JSTL Core tags(scope)</h2>
	<c:set var="number" value="100" scope="request"/>
	<c:set var="number" value="200" scope="session"/>
	
	request 값 출력 : ${requestScope.number }<br>
	session 값 출력 : ${sessionScope.number }<br>
	<br><br>
	<h2>JSTL Core tag3 (remove)</h2>
	<c:remove var="number" scope="session"/>
	
	request 값 출력 : ${requestScope.number }<br>
	session 값 출력 : ${sessionScope.number }<br>
	<br>
	<br>
	<h2>JSTL Core Tags4</h2>
	출력:<c:out value="100"/><br>
	default : <c:out value="${data}" default="없음"/><br>
	기본출력 : 글씨를 진하게 하려면 Bold태그인 <b></b>를 사용
	<br>
	기본출력 (escape 처리 ):<br>
	<c:out value="글씨를 진하게 하려면 Bold 태그<b>1</b>를 사용" escapeXml="false"/>
	<br><br>
	<c:out value="글씨를 진하게 하려면 Bold 태그<b>1</b>를 사용" escapeXml="true"/>
</body>
</html>