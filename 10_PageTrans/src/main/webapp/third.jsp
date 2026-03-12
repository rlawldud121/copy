<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>third page</h1>
<%
	int aa = Integer.parseInt(request.getParameter("a"));
	int bb = Integer.parseInt(request.getParameter("b"));
	
	Object ccc = request.getAttribute("ccc");
	
%>

	<%= aa %> + <%= bb %> = <%= aa+bb %>
	<hr>
	<%= aa %> + <%= bb %> = <%= ccc %>
	

</body>
</html>