<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <section class="container">
      <form action="/insertPhoto" method="post" enctype="multipart/form-data" style="width:1000px; margin: 0 auto;">
         <table class="table table-bordered">
            <tr>
               <th>작성자</th>
               <td>${sessionScope.member.userId }<input type="hidden" name="photoWriter" value="${sessionScope.member.userId }"></td>
            </tr>
            <tr>
               <th>첨부파일</th>
               <td>
                  <input type="file" name="filename" onchange="loadImg(this);">   
               </td>
            </tr>
            <tr>
               <th>미리보기</th>
               <td>
                  <div id="img-viewer">
                     <img id="img-view" width="350">
                  </div>
               </td>
            </tr>
            
            <tr>
               <th>내용</th>
               <td>
                  <textarea name="photoContent" rows="3" style="width:100%"></textarea>
               </td>
            </tr>
            
            <tr>
               <th style="text-align:center;" colspan="2">
               <button type="submit">등록</button>
               </th>
            </tr>
            
         </table>
      </form>
   </section>
   
   <script>
      function loadImg(obj){
         console.log(obj.files);
         if(obj.files.length != 0 && obj.files[0] !=0){
            var reader = new FileReader();
            reader.readAsDataURL(obj.files[0]);
            reader.onload = function(e){
               $("#img-view").attr("src",e.target.result);
            }
            
         }else{
            $("#img-view").attr("src","");
         }
         
      }
   </script>
</body>
</html>