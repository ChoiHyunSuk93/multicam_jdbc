<%@page import="multi.MovieVO"%>
<%@page import="multi.MovieDAO"%>
<%@page import="multi.ProductVO"%>
<%@page import="multi.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 1. 브라우저가 보낸 데이터를 받아야 함. -> 자바로 짜야함 -->
<!-- 2. 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
<%
	// 자바코드 넣는 부분
// tomcat은 미리 request를 만들어서 내장시켜놨음

MovieDAO dao = new MovieDAO();
ArrayList<MovieVO> list = dao.list();
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
	<hr>
	<%
		if (list.size() == 0) {
	%>
	<h3>등록된 영화가 없습니다.</h3>
	<img alt="" src="img/no.png" width="250" height="250">
	<%
		} else {
	%>
	<table class="table table-danger table-striped">
		<tr>
			<td>id</td>
			<td>title</td>
			<td>director</td>
		</tr>
		<%
			for (MovieVO bag2 : list) {
		%>
		<tr>
			<td><%=bag2.getId()%></td>
			<td><a href="one4.jsp?id=<%=bag2.getId()%>"> <%=bag2.getTitle()%>
			</a></td>
			<td><%=bag2.getDirector()%></td>

			<%
				}
			%>
		
	</table>
	<%
		}
	%>
</body>
</html>