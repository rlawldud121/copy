
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> - edit page - </h1>
<form action="user-edit" method="post">
<div class="info-wrap">
    <div class="info-row">
        <div>ID.</div>


        <div>${sessionScope.user.id}</div>
    </div>
    <div class="info-row">
        <div>PW.</div>
        <%-- editC에 get만 사용했으니까(수정하기 form) parameter는 남는 post 사용하기--%>
        <div><input name="pw" type="text" value="${sessionScope.user.pw}"></div>
            <%-- value="${sessionScope.user.pw}이 login 할때 가져온 session이니까
             edit 하고는 수정이 되지않음(edit 사항이 반영되지않음) --%>
    </div>
    <div class="info-row">
        <div>Name.</div>
        <div><input name="name" type="text" value="${sessionScope.user.name}"></div>
    </div>
    <div>
        <button class="movie-btn" onclick="">확인</button>
        <button type="button" onclick="history.back()" class="movie-btn">취소</button>
        <%-- from태그 안에 버튼을 누르면 edit으로 이동해서 history.back이 동작하지않음
             => button에 type="button" 을 줌으로써 이 버튼은 form태그 안의 버튼이
               아닌 button으로써 동작한다는 뜻 --%>
    </div>
</div>
</form>


</body>
</html>
