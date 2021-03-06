<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member, member.model.service.MemberService" %>
<%
	String userId = (String)request.getParameter("userId");

	Member member = new MemberService().selectMemberOne(userId);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
	아이디 : <%= member.getUserId() %><br>
	패스워드 : <%= member.getUserPwd() %><br>
	이름 : <%= member.getUserName() %><br>
	나이 : <%= member.getAge() %><br>
	이메일 : <%= member.getEmail() %><br>
	휴대폰 : <%= member.getPhone() %><br>
	주소 : <%= member.getAddress() %><br>
	성별 : <%= member.getGender() %><br>
	취미 : <%= member.getHobby() %><br>
</body>
</html>