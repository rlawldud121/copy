<%@page import="com.jy.pay.Result"%>
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
		Result r = (Result) request.getAttribute("rr");
	%>
	
	번 돈 : <%=request.getParameter("earn") %> <br>
	쓴 돈 : <%=r.getSpend() %> <br>
	남은 돈 :  <%= r.getRemain() %> <br>

</body>
</html>