<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>first page~~</h1>
<a href="second-c">(a태그) SecondC로 get요청</a>
<hr>
<form action="second-c">
    <input type="text" name="a" >
    <button>SecondC로 (get/post)요청</button>
</form>
<hr>
<h2 onclick="location.href='second-c?a=ㅎㅅㅎ'">(js) SecondC로 get방식 요청</h2>

</body>x
</html>