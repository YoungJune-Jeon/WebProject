<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<title>Insert title here</title>
</head>
<body>
   <h1>1.다음(카카오) 주소 찾기 API</h1>

   <ul>
      <li><input type="text" id="postCode"
         style="width: 200px; display: inline-block;" placeholder="우편번호"
         readonly>
         <button id="addrSearchBtn" onclick="addSearch();">주소 검색</button></li>
      <li><input type="text" id="jibunAddr"
         style="width: 200px; display: inline-block;" placeholder="지번주소"
         readonly> <input type="text" id="roadAddr"
         style="width: 200px; display: inline-block;" placeholder="도로명주소"
         readonly> <input type="text" id="detailAddr"
         style="width: 200px; display: inline-block;" placeholder="상세주소">

      </li>

   </ul>

   <script>
      function addSearch() {
         new daum.Postcode({
            oncomplete : function(data) {
               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
               // 예제를 참고하여 다양한 활용법을 확인해 보세요.
               console.log(data);
               $("#postCode").val(data.zon);
               $("#jibunAddr").val(data.jibunAddress);
               $("#roadAddr").val(data.roadAddress);
            }
         }).open();
      }
   </script>

   <h2>2.네이버지도</h2>
   <script
      src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script type="text/javascript"
      src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=4gwem66ann"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=4gwem66ann&submodules=geocoder"></script>
   <div id="map" style="width: 100%; height: 400px;"></div>

   <script>
    
   $(function(){
        var map = new naver.maps.Map('map', {
           center : new naver.maps.LatLng(37.533807,126.896772),
           zoom : 17,
           zoomControl : true,
           zoomControlOptions :{
              position : naver.maps.Position.TOP_RIGHT,
              style : naver.maps.ZoomControlStyle.SMALL
           }
        
        });
         var marker = new naver.maps.Marker({
            position : new naver.maps.LatLng(37.533807, 126.896772),
            map : map
         });
         
         var contentString = ["<div class = 'iw_inner'><h3>KH정보교육원</h3>" + "<p>서울시 영등포구 선유로2동 57 이레빌딩 19F</p></div>"].join("");
         var infoWindow = new naver.maps.InfoWindow();
         naver.maps.Event.addListener(marker,"click", function(e){
            if(infoWindow.getMap()){
               infoWindow.close();
            }else{
               infoWindow = new naver.maps.InfoWindow({
                  content :contentString
               });
               infoWindow.open(map,marker);
            }
         });
         
         naver.maps.Event.addListener(map,"click",function(e){
            marker.setPosition(e.coord);
            if(infoWindow!=null){
               if(infoWindow.getMap()){
                  infoWindow.close();
               }
            }
            naver.maps.Service.reverseGeocode({
               location : new naver.maps.LatLng(e.coord.lat(),e.coord.lng())
            },
            function(status,response){
               if(status != naver.maps.Service.Status.OK){
                  return alert("아무리 찾아도없어..");
               }
               var result=response.result;
               items=result.items;
               address=items[2].address;
               contentString=["<div class='iw_inner'><p>"+address+"</p></div>"].join("");
            });
         });
     });
   </script>



</body>
</html>