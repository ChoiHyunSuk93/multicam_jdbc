<%@page import="multi.MemberVO"%>
<%@page import="multi.MemberDAO3"%>
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

MemberDAO3 dao = new MemberDAO3();
MemberVO bag = dao.one(id);
%>

<!-- 3. 브라우저에게 결과를 알려주기 위한 html을 만들면 된다. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: #41ba29;
}
</style>

</head>
<body>
	<a href="member.html">
		<button id="b1">첫페이지로</button>
	</a>
	<hr>
	<%=id%>
	정보 검색 결과.
	<hr color="red">
	비밀번호 :
	<%=bag.getPw()%>
	<br> 이름 :
	<%=bag.getName()%>
	<br> 전화번호 :
	<%=bag.getTel()%>
	<br>


</body>
</html>