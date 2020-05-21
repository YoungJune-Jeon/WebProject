<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js" 
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax 테스트</title>
</head>
<body>

   <h1>Ajax 개요</h1>
   <p>
   Ajax는 Asynchronous Javascript and XML이란 용어로 <br>
   서버로 부터 데이터를 가져와 전체 페이지를 새로 고치지않고 일부만 로드할수있게 하는 기법
   <br> 
   비동기식 요청을 함.
   </p>
   <h3> 동기식 / 비동기식이란</h3>
   <p> 
      동기식은 서버와 클라이언트가 동시에 통신하여 프로세스를 수행 및 종료까지 같이하는 방식
      <br>
      이에 반해 비동기식은 페이지 리로딩 없이 서버요청 사이사이 추가적인 요청과 처리가 가능
   </p>
   
   <h3>ajax 구현 (Javascript)</h3>
   <h4>1. ajax로 서버에 전송값 보내기</h4>
   <p>버튼 클릭시 전송값을 서버에서 출력</p>
   <input type="text" id="msg1">
   <button onclick="jsFunc();">보내기(js)</button>
   <script>
   function jsFunc(){
      // 1.XMLHttpRequest 객체 생성
         var xhttp = new XMLHttpRequest();
         var msg = document.getElementById("msg1").value;
         
      // 2.요청정보 설정
      xhttp.open("GET", "/ajaxTest1?msg="+msg, true);
      
      // 3.데이터 처리에 따른 동작함수 설정
      xhttp.onreadystatechange = function(){
         if(this.readyState==4 && this.status == 200){
            console.log("서버 전송 성공");
         }else if(this.readyState == 4 && this.status == 404){
            console.log("서버 전송 실패");
         }   
      }
      xhttp.send();
   }
   </script>
   <h3>ajax 구현 (jQuery)</h3>
   <h4>ajax(jQuery)로 서버에 데이터 전송하기</h4>
   <input type="text" id="msg2" />
   <button id="jQbtn2">전송</button>
   <script>
   	$("#jQbtn2").click(function(){
   	var msg = $("#msg2").val();
   		$.ajax({
   		url:"/ajaxTest1",
   		data:{msg: msg},
   		type :"get",
   		success : function(){
   			console.log("서버 전송 성공!");
   		}
   		});
   	});
   	
   
   </script>
   <h4>3. 버튼 클릭시 서버에서 보낸 값 수신</h4>
   <button id="jQbtn3">서버에서 보낸 값 확인</button>
   <p id="confirmArea"></p>
   <script>
   	$("#jQbtn3").click(function(){
   		$.ajax({
   			url:"/ajaxTest2",
   			type:"get",
   			success:function(data){
   				$("#confirmArea").html(data);
   			},
   			error:function(){
   				console.log("실패");
   			}
   		});
   	});
   
   </script>
   
   <h4>4.서버로 전송값 보내고 결과 문자열 받아서 처리</h4>
      <p>숫자 개를 전송하고 더한 값 받기</p>
         첫번째수 :<input type="text" id="num1"><br>
         두번째수 :<input type="text" id="num2"><br>
         <button id="jQbtn4">전송 및 결과 확인</button>
         <p id="p4"></p>
         <script>
            $("#jQbtn4").click(function(){
               var num1=$("#num1").val();
               var num2=$("#num2").val();
               
               $.ajax({
                  url:"/ajaxTest3",
                  data:{
                     num1:num1,
                     num2:num2
                  },
                  type:"get",
                  success:function(data){
                     $("#p4").html(data);
                  },
                  error: function(data){
                     console.log("실패");
                  }
               });
            })
         </script>
   
   <h1>JSON 개요</h1>
   <p>
   Ajax 서버통신 시 데이터 전송을 위한 포맷<br />
   JSON (javascript Object Notation) : 자바스크립트 객체 표기법<br />
   JSON을 사용하면 모든 데이터형을 서버와 주고 받을 수 있다.
   숫자,문자열, boolean, 배열, 객체 , null; <br>
   '{'으로 시작하여 '}'으로 끝나며 그속에 데이터를 표기하고 'key: 값Value 쌍으로 구성된다.
   <pre>
   {
   "name" : "이순신",
   "age" : 27,
   "birth": "1900-01-01",
   "gender" : "남",
   "marry" : true,
   "address" : "서울 특별시 영등포구 당산동",
   "family":{
   				"father" : "아바지",
   				"mother" : "어머니",
   				"brother" : "동생"
   				}
   }
   </pre>
<h4>5. 서버로 전송값 보내고 결과 JSON으로 받아서 처리</h4>
   유저번호입력:<input type="text" id="userNum"><br>
   <p id="p5"></p>
   <button id="jQbtn5">실행 및 결과확인</button>
   
   <script>
      $("#jQbtn5").click(function(){
         var num=$("#userNum").val();
      
         $.ajax({
            url:"/ajaxTest4",
            type:"get",
            data:{userNum : num},
            success:function(data){
               //data가 JSON 
               console.log(data);
               
               var userNo=decodeURIComponent(data.userNo);
               var userName=decodeURIComponent(data.userName);
               var userAddr=decodeURIComponent(data.userAddr);
               
               $("#p5").html("번호 : "+userNo+" / 이름 : "+userName+" / 주소 : "+userAddr)
            },
            error:function(data){
               console.log("실패")
            }
         });
      
      });
      
   </script>
   
   <h4>6.서버로 전송값을 보내고  JSONArray로 결과받아서 처리</h4>
   <p>유저 번호를 보내서 해당 유저를 가져오고,없는 경우 전체리스트 가져오기</p>
   유저 번호 입력:<input type="text" id="findNum"><br>
   
   <p id="p6"></p>
   <button id="jQbtn6">실행 및 결과 확인</button>
   
   <script>
      $("#jQbtn6").click(function(){
         var findNum=$("#findNum").val();
         
         $.ajax({
            url:"/ajaxTest5",
            type:"get",
            data:{userNum:findNum},
            success:function(data){
               //console.log(data);
               var resultText="";
               for(var i=0 ;i<data.length;i++){
            	   var userNo =data[i].userNo;
            	   var userName = decodeURIComponent(data[i].userName);
            	   var userAddr=decodeURIComponent(data[i].userAddr);
            	   resultText +="번호:" +userNo+"/이름 :" +userName+"/주소: "+userAddr+"<br>";
               }
               $("#p6").html(resultText);
            },
            error: function(data) {
               console.log("실패");
            }
         });
      
      });
      
   
   </script>
   
   
   <br /><br /><br /><br /><br /><br />
</body>
</html>












