
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${sessionScope.user.id} (${sessionScope.user.name})님 환영합니다^_^♥ <br>
<%--id랑 name은 VO에서 온 거임, 디비 테이블 아님!!--%>
<button onclick="location.href='user-info'">mypage</button>
<button onclick="location.href='user-login'">logout</button>
</body>
</html>
