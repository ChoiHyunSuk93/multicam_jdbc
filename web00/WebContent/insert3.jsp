<%@page import="multi.ProductDao"%>
<%@page import="multi.ProductVO"%>
<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 1. 브라우저가 보낸 데이터를 받아야 함. -> 자바로 짜야함 -->
<!-- 2. 브라우저가 보낸 데이터를 받을 때 사용하는 부품 필요함. -->

<!--변수를 전부 받아서 가방에 한번에 넣기 -->
<jsp:useBean id="bag" class="multi.ProductVO"></jsp:useBean>
<jsp:setProperty property="*" name="bag"/>

<%
	// 자바코드 넣는 부분
// tomcat은 미리 request를 만들어서 내장시켜놨음
/* String id = request.getParameter("id");
String name = request.getParameter("name");
String content = request.getParameter("content");
String price = request.getParameter("price");
String company = request.getParameter("company");
String img = request.getParameter("img"); */

/* ProductVO bag = new ProductVO();
bag.setId(id);
bag.setName(name);
bag.setContent(content);
bag.setPrice(Integer.parseInt(price));
bag.setCompany(company);
bag.setImg(img); */

ProductDao dao = new ProductDao();
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
	background: lime;
}
</style>

</head>
<body>
상품정보 추가되었음.
<hr color="red">

<img src="img/<%=bag.getImg()%>" width="300" height="200">
</body>
</html>