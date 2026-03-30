<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 값 받아서 쓰기. 		계산 x => 계산은 이미 모델에서 했음!
		
	%>
	
	<h1>계산 결과</h1>
	<div>
		<div>상품 가격	: <%=request.getAttribute("price") %></div>
		<div>지불한 돈	: <%=request.getAttribute("money") %></div>
		<div>잔돈		: <%=request.getAttribute("ex") %></div>
		<div>멘트		: <%=request.getAttribute("say") %></div>
	</div>
	<hr>
	
	<%=request.getParameter("m") %> <br>
	-<%=request.getParameter("p") %>
	<hr>
	<%=request.getAttribute("ex") %>
	
</body>
</html>