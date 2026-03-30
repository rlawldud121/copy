
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>second page~~</h1>

파라미터 : ${param.a}
<br>
어트리뷰트 : ${param.b}
<br>
세션 : ${sessionScope.c} <br>
쿠키 : ${cookie.d.value}

<hr>
<form action="third-c">
    <input type="text" name="a" value="${param.a}">
    <button>thirdC로 요청</button>
</form>
<hr>
<h2 onclick="location.href='third-c?a=ㅎㅅㅎ'">third c로 get 요청(js)</h2>
</body>
</html>
