<%@page import="com.jy.attr.Result"%>
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
		// 값 받기
		Result r = (Result)request.getAttribute("rr");
		
	%>
	
	<h1>계산 결과2</h1>
	<div>
		<div>상품 가격	: <%=r.getPrice() %></div>
		<div>지불한 돈	: <%=r.getMoney() %></div>
		<div>잔돈		: <%=r.getEx() %></div>
		<div>멘트		: <%=r.getSay() %></div>
	</div>
	<hr>
	
	<%=request.getParameter("m") %> <br>
	-<%=request.getParameter("p") %>
	<hr>
	<%=r.getEx() %>
	<hr>
	<!-- 1. 돈이 모자를 때만 버튼이 나오게 [얼마 모자른데요??] 버튼 누르면 output3.jsp에서 모자란 금액 안내
		상품이 1만원, 내가 5천원	-> 5천원이 모자라요~ -->
		
		<%
		// if(r.getEx() < 0)
		if(r.getMoney() < r.getPrice()){
			int howmuch = r.getPrice() - r.getMoney();%>		
			<a href="output3.jsp?howmuch=<%=howmuch %>">
			<button>얼마 모자른데요??</button></a>
			<a href="output3.jsp?howmuch=<%=r.getEx() * -1 %>">
			<button>얼마 모자른데요??</button></a>
			<a href="output3.jsp?howmuch=<%=r.getPrice() - r.getMoney() %>">
			<button>얼마 모자른데요??</button></a>
		
			<button onclick="location.href='output3.jsp?howmuch=<%=r.getEx() * -1 %>'">얼마 모자라요?</button>			

			<form action="output3.jsp">
				<input name="howmuch" hidden value="<%=r.getEx() * -1 %>">
				<button>얼마요?</button>
			</form>
			<% 	} %>
			
			<hr>
            <hr>

            <form action="Excontroller">
                <input name="howmuch" hidden value="<%=r.getEx() * -1 %>">
                <button>얼마요?</button>

            </form>
            
            
            <form action="Excontroller" method="post">
                <input name="asd" value="<%=r.getEx() * -1 %>">
                <button>얼마요?(데이터 이미 완성)</button>
            </form>
            
            <form action="Excontroller" method="post">
                <input name="asd" value="<%=r.getEx()%>">
                <button>얼마요?(데이터 미완성)</button>
            </form>

	
</body>
</html>