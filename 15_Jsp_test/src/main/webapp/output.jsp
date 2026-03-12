<%@ page import="com.jy.test.Information" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
        Model2 방식 (MVC 패턴) 방식으로 구현

값 뭉쳐 보내기

        결과페이지

-회원 정보 확인 -
      이름 : ㅇㅇ
      나이 : ㅇㅇ
      성별 : ㅇㅇ
      관심사 : ㅇㅇ / ㅇㅇ / ㅇㅇ
--%>

<%
    // 값만 받는 곳
    Information info = (Information) request.getAttribute("information");

%>
<%-- view 계산 x (model에서 이미 다 하고 옴)--%>
<hr>
<h1> -회원 정보 확인 -</h1>
<h1>이름 : <%=info.getName()%></h1>
<h1>나이 : <%=info.getAge()%></h1>
<h1>성별 : <%=info.getGender()%></h1>
<h1> 관심사 : <%=info.getInterest()%></h1>
</body>
</html>
