<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%

/* String userId = request.getParameter("userId");
Member member = new MemberService().selectMemberOne(userId); */
	
 	Member member = (Member)request.getAttribute("memberOne");

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원 정보 </title>
</head>
<body>

	<form action="/mUpdate" method="post">
	아이디    : <input type="text" name="userId" id="userId" value="<%= member.getUserId() %>">  <br>
	패스워드 : <input type="password" name="userPwd" id="userPwd"><br>
	패스워드 : <input type="password" name="userPwdRE" id="userPwdRE"><br>
	이름       : <input type="userName" name="userName" id="userName" value="<%= member.getUserName() %>"readonly><br>
	나이       : <input type="text" name="age" id="age" value="<%= member.getAge() %>"readonly><br>
	이메일    : <input type="email" name="email" id="email" value="<%= member.getEmail() %>"readonly><br>
	휴대폰    : <input type="text" name="phone" id="phone" value="<%= member.getPhone() %>"><br>
	주소       : <input type="text" name="address" id="address" value="<%= member.getAddress() %>"><br>
	성별       : 
	<% if(member.getGender().equals("M")){%> 
	<input type="radio" name="gender" value="M" checked>남자
	<input type="radio" name="gender" value="F" >여자 <br>
	<%} else {%>
	<input type="radio" name="gender" value="M" >남자
	<input type="radio" name="gender" value="F" checked>여자<br>
	<% }%>
	<br>
	취미       : <input type="text" name="hobby" id="hobby" value="<%= member.getHobby() %>"><br>
	<input type="submit" value="정보수정" /><input type="reset" value="취소" />
	
	</form>

	<script>
			function question(){
				var result = window.confirm("정말로 회원탈퇴를 하시겠습니까?");
				if(result){
					return true;
				}else{
					return false;
				}
			}
	</script>

	<a href="/index.jsp">메인페이지로 이동하기</a>
	<a href="/mdelete" id="mdel" onclick="return question();">회원 탈퇴하기</a>
	

</body>
</html>