<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.value2 ==1 }">1을 입력하셨습니다.<br></c:when>
		<c:when test="${param.value2 ==2 }">2을 입력하셨습니다.<br></c:when>
		<c:when test="${param.value2 ==3 }">3을 입력하셨습니다.<br></c:when>
		<c:otherwise>1~3중에 입력해주세요<br></c:otherwise>
	</c:choose>

</body>
</html>