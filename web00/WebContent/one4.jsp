<%@page import="multi.MovieVO"%>
<%@page import="multi.MovieDAO"%>
<%@page import="multi.ProductVO"%>
<%@page import="multi.ProductDao"%>
<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 1. 브라우저가 보낸 데이터를 받아야 함. -> 자바로 짜야함 -->
<!-- 2. 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
<%
	// 자바코드 넣는 부분
// tomcat은 미리 request를 만들어서 내장시켜놨음
String id = request.getParameter("id");

MovieDAO dao = new MovieDAO();
MovieVO bag = dao.one(id);
%>

<!-- 3. 브라우저에게 결과를 알려주기 위한 html을 만들면 된다. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body {
	background: #fcba03;
}
</style>

</head>
<body>
	<a href="movie.html">
		<button id="b1">첫페이지로</button>
	</a>
	영화 ID : <%=id%> 
	<hr color="red">
	<table class="table table-dark table-striped">
		<tr>
			<td>영화제목 :</td>
			<td><%=bag.getTitle()%></td>
		</tr>
		<tr>
			<td>내용 :</td>
			<td><%=bag.getContent()%></td>
		</tr>
		<tr>
			<td>장소 :</td>
			<td><%=bag.getLocation()%></td>
		</tr>
		<tr>
			<td>감독 :</td>
			<td><%=bag.getDirector()%></td>
		</tr>
		
	</table>


</body>
</html>