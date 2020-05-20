<%@page import="file.model.vo.FileData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    ArrayList<FileData>list = (ArrayList<FileData>)request.getAttribute("fileList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
	<h1>
		<table border="1">
			<tr>
				<th>파일이름</th><th>파일사이즈</th><th>업로더</th>
				<th>업로드 시간</th><th>다운로드</th><th>삭제</th>
			</tr>
			<% for(FileData data: list){%>
			<tr>
				<td><%=data.getFileName() %></td>
				<td><%=data.getFileSize() %></td>
				<td><%=data.getFileUser() %></td>
				<td><%=data.getUploadTime() %></td>
				<td>다운로드</td>
				<td>
				<form action="fileRemove" method="post">
					<input type="hidden" name="filePath" value="<%= data.getFilePath() %>" />
					<input type="hidden" name="fileUser" value="<%= data.getFileUser()%>"/>
					<input type="submit" value="삭제"/>
				</form>
				삭제</td>
			</tr>
			<% } %>
		</table>
	</h1>
</center>

</body>
</html>