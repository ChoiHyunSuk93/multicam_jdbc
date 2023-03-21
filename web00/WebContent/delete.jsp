<%@page import="multi.MemberDAO3"%>
<%@page import="multi.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 1. 브라우저가 보낸 데이터를 받아야 함. -> 자바로 짜야함 -->
<!-- 2. 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->
<%
	// 자바코드 넣는 부분
// tomcat은 미리 request를 만들어서 내장시켜놨음
String id = request.getParameter("id");

MemberVO bag = new MemberVO();
bag.setId(id);

MemberDAO3 dao = new MemberDAO3();
dao.delete(bag);

%>

<!-- 3. 브라우저에게 결과를 알려주기 위한 html을 만들면 된다. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: lime;
}
</style>

</head>
<body>
회원삭제 요청되었음.
<hr color="red">
삭제요청 id : <%= id %> <br>

</body>
</html>