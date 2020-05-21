<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>If문</title>
</head>
<body>
		<c:if test="${param.value1 % 2 == 0}" var="result1">
			짝수입니다.<br>
		</c:if>
	
		<c:if test="${param.value1 % 2 == 1}" var="result2">
			홀수입니다.<br>
		</c:if>
		
		첫번째 if 결과 : <c:out value="${result1 }"></c:out>
		두번째 if 결과 : <c:out value="${result2 }"></c:out>
</body>
</html>