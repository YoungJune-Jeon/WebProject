<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MAP 처리</h1>
이름:${(member.name)}<br>
나이:${(member.age)}<br>
주소:${(member.addr)}<br>

<hr>
<h1>객체 배열 처리</h1>
<h2>천번째 데이터</h2>
아이디:${memberArr[0].id}<br>
비번:${memberArr[0].passwd}<br>
이름:${memberArr[0].name }<br>


아이디:${memberArr[1].id}<br>
비번:${memberArr[1].passwd}<br>
이름:${memberArr[1].name }<br>

<hr>
<h1>ArrayList 처리</h1>
<h2>첫번째 데이터</h2>
아이디:${memberlist[0].id}<br>
비번:${memberlist[0].passwd}<br>
이름:${memberlist[0].name}<br>


아이디:${memberlist[1].id}<br>
비번:${memberlist[1].passwd}<br>
이름:${memberlist[1].name}<br>

<hr>
<h1>session 처리</h1>
세션:${sessionScope.name}<br>


</body>
</html>