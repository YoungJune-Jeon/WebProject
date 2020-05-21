<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax 테스트</title>
</head>
<body>

		<h1>Ajax 개요</h1>
		<p>
		Ajax는 Asynchronous Javascript and XML이란 용어로 <br />
		서버로부터 데이터를 가져와 전체페이지를 새로 고치지 않고 일부만 로드 할 수 있게 하는 기법 <br />
		비동기식 요청을 함.
		</p>
		<h3>동기식 / 비동기 식이란?</h3>
		<p>
		동기식은 서버와 클라이언트가 동시에 통신하여 프로세스를 수행 및 종료까지 같이 하는 방식<br />
		이에 반해 비동기식은 페이지 리로딩없이 서버요청 사이사이 추가적인 요청과 처리가 가능
		</p>
		
		<h3> ajax구현 (Javascript)</h3>
		<h4>1. ajax로 서버에 전송값 보내기</h4>
		<p>버튼 클릭시 전송값을 서버에서 출력</p>
		<input type="text" id="msg" />
		<button onclick="isfunc();">보내기(js)</button>
		<script>
			function jsfunc(){
				//1. XMLHttpRequest객체 생성
				var xhttp = new XMLHttpRequest();
				var msg = document.getElementById("msg1").value;
				
				//2. 요청정보 설정
				xhttp.open("GET","/ajaxTest1?msg="+msg, true);
				
				//3. 데이터 처리에 따른 동작함수 설정
				xhttp.onreadystatechange = function(){
					if(this.readyState == 4&& this.status == 200){
						console.log("서버전송 성공!");
					}else if(this.readyState == 4&& this.status ==404){
						console.log("서버 전송 실패..");
					}
				}
				xhttp.send();
			}
		
		</script>
		
		
		
		
		<h3>ajax구현 (jquery)</h3>
		
		
		

</body>
</html>





