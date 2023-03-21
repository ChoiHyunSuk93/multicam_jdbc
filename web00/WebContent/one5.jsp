<%@page import="multi.MailVO"%>
<%@page import="multi.MailDAO"%>
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
String no = request.getParameter("no");

MailDAO dao = new MailDAO();
MailVO bag = dao.one(no);
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
	background: #13c242;
}
</style>

</head>
<body>
	<a href="one5.html">
		<button id="b1">검색페이지로</button>
	</a>
	<a href="mail.html">
		<button id="b1">첫페이지로</button>
	</a>
	<br> 메일 번호 :
	<%=no%>
	<hr color="red">
	<table class="table table-dark table-striped">
		<tr>
			<td>보낸사람 :</td>
			<td><%=bag.getSender()%></td>
		</tr>
		<tr>
			<td>메일제목 :</td>
			<td><%=bag.getTitle()%></td>
		</tr>
		<tr>
			<td>내용 :</td>
			<td><%=bag.getContent()%></td>
		</tr>
		<tr>
			<td>날짜 :</td>
			<td><%=bag.getDate()%></td>
		</tr>
	</table>


</body>
</html>