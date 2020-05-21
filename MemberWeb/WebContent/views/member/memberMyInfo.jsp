<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Member member= (Member)request.getAttribute("memberOne"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
	<form action="/mupdate" method="post">
	
	아이디 :<input type="text" name="userId" id="userId" value="${member.userId}"><br>
	패스워드:<input type="password" name="userPwd" id="userPwd"><br>
	패스워드:<input type="password" name="userPwdRe" id="userPwdRe"><br>
	이름:<input type="text" name="userName" id="userName" value="${member.userName}" readonly><br>
	나이:<input type="text" name="age" id="age" value="${member.age}" readonly><br>
	이메일:<input type="text" name="email"id="email"value="${member.email }"><br>
	휴대폰:<input type="text" name="phone" id="phone" value="${member.phone }"><br>
	주소:<input type="text"name="address" id="address" value="${member.address }"><br>
	성별:<% if(member.getGender().equals("M")){
	%><input type="radio" name="gender" value="M" checked readonly>남자
	  <input type="radio" name="gender" value="F">여자<br>
	  <%}else{ %>
	  <input type="radio" name="gender" value="M" readonly>남자
	  <input type="radio" name="gender" value="F" checked>여자<br>
	  <%} %>
	
	취미:<input type="text" name="hobby" id="hobby" value="${member.hobby }"><br>	
	<input type= "submit" value="정보수정">
	<input type="reset" value="취소">
	</form>
	
	<a href="/">메인페이지로 이동하기</a>
	<a href="/mdelete" id="mdel" onclick="return question();">회원 탈퇴하기</a>
	
	<script>
	
		function question(){
			var result=window.confirm("정말로 회원 탈퇴를 하시겠습니까?");
			if(result){
				return true;
			}
			else{
				return false;
			}
		}
	</script>
	
</body>
</html>