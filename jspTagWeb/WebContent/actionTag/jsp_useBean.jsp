<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp:useBean tag</title>
</head>
<body>
	<jsp:useBean id="member" class="test.member.model.vo.Member" scope="page">
		<jsp:setProperty name="member" property="id" value="user11"/>
		<jsp:setProperty name="member" property="passwd" value="pass11"/>
		<jsp:setProperty name="member" property="name" value="홍길동"/>
	</jsp:useBean>
	
	<h2>jsp:useBean</h2>
	
	id:<jsp:getProperty property="id" name="member"/><br>
	password:<jsp:getProperty property="passwd" name="member"/><br>
	이름:<jsp:getProperty property="name" name="member"/><br>
</body>
</html>