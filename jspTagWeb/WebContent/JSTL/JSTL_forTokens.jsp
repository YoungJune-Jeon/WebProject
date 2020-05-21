<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forTokens문</title>
</head>
<body>
	<c:forTokens items="${param.hobby }" delims="," var="hobby">
		${hobby }<br>
	</c:forTokens>
</body>
</html>