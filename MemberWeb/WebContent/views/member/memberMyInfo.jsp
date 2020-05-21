<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%
	Member member = (Member)request.getAttribute("memberOne");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
	<form action="/mUpdate" method="post">
		아이디 : <input type="text" name="userId" id="userId" <%-- value="<%= member.getUserId() %>" --%> value="${member.userId }" readonly><br>
		패스워드 : <input type="password" name="userPwd" id="userPwd"/><br>
		패스워드 확인 : <input type="password" name="userPwdRe" id="userPwdRe"/><br>
		이름 : <input type="text" name="userName" id="userName" value="${member.userName }" readonly/><br>
		나이 : <input type="text" name="age" id="age" value="${member.age }" readonly/><br>
		이메일 : <input type="email" name="email" id="email" value="${member.email }"/><br>
		휴대폰 : <input type="phone" name="phone" id=" phone" value="${member.phone }"/><br>
		주소 : <input type="text" name="address" id="address" value="${member.address }"/><br>
		성별 : 
		<c:if test="${member.gender eq 'M' }">
			<input type="radio" name="gender" value="M" checked>남자
			<input type="radio" name="gender" value="F">여자
		</c:if>
		<c:if test="${member.gender ne 'M' }">
			<input type="radio" name="gender" value="M" >남자
			<input type="radio" name="gender" value="F" checked>여자
		</c:if>
		<!-- 예전답 -->
		<%-- <% if (member.getGender().equals("M")) { %>
			<input type="radio" name="gender" value="M" checked>남자
			<input type="radio" name="gender" value="F"/>여자
		<% } else if(member.getGender().equals("F")){ %>
			<input type="radio" name="gender" value="M">남자
			<input type="radio" name="gender" value="F" checked/>여자 --%>
		<!-- 참고사항 -->
		 <%--<% }else if (member.getGender()!=null) {%>	
			<input type="radio" name="gender" value="M">남자
			<input type="radio" name="gender" value="F" checked/>여자 --%> 
			<!-- 이 조건은 member.getGender()값이 만약 null일 경우
			member.getGender() != null이라는 조건문을 사용하려고 해도
			member.getGender()값이 null이라서 시작부터 오류가 발생한다
			그래서 이 조건 사용 불가 -->
		<%-- <% } %> --%>
		<%-- <%= member.getGender() %> --%>
		<br>
		취미 : <input type="text" name="hobby" id="hobby" value="${member.hobby }"/><br>
		<input type="submit" value="정보수정"/>
		<input type="reset" value="취소" />
	</form>
	
	<a href="/index.jsp">메인페이지로 이동하기</a>
	<a href="/mdelete" id="mdel" onclick="return question();">회원 탈퇴하기</a>
	
	<!-- 쿠폰발급때 사용하기 -->
	<script>
		function question() {
			var result = window.confirm("정말로 회원탈퇴를 하시겠습니까?");
			if(result) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>