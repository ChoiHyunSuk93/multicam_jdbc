<%@page import="multi.MailDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 1. 브라우저가 보낸 데이터를 받아야 함. -> 자바로 짜야함 -->
<!-- 2. 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->

<!--변수를 전부 받아서 가방에 한번에 넣기 -->
<jsp:useBean id="bag" class="multi.MailVO"></jsp:useBean>
<jsp:setProperty property="*" name="bag" />

<%
	MailDAO dao = new MailDAO();
	dao.insert(bag);
%>

<!-- 3. 브라우저에게 결과를 알려주기 위한 html을 만들면 된다. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: #13c242;
}
</style>

</head>
<body>
	<a href="mail.html">
		<button id="b1">첫페이지로</button>
	</a>
	<br> 메일 추가되었음.
	<hr color="red">

</body>
</html>