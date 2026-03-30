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


<%-- view 계산 x (model에서 이미 다 하고 옴)--%>
<hr>
<h1> -회원 정보 확인 -</h1>
<h1>이름 : ${information.name}</h1>
<h1>나이 : ${information.age}</h1>
<h1>성별 : ${information.gender}</h1>
<h1> 관심사 : ${information.interest}</h1>
<a href="/19_jsp_EL_war_exploded/">처음으로</a>
</body>
</html>
