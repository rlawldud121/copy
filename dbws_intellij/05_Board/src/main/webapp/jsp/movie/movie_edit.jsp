
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>- Movie Edit -</h1>
<form action="edit" method="post" enctype="multipart/form-data">
<div style="display: flex; justify-content: center;">
    <div class="movie-detail">
        <div>
            <div class="col-1">No.</div>
            <div class="col-2"><input type="text" name="no" value="${movie.no}" disabled></div>
        </div>
        <div>
            <div><img src="/images/${movie.img}">
                <input type="file" name="newImg">
                <input name="oldImg" hidden value="${movie.img}">
            <%--기존 파일의 이름을 들고 갈 용도로 타입이 파일일 필요가 없다--%>
            <%--기존 이미지의 변경이 없다--%>
            </div>
        </div>


        <div>
            <div class="col-1">Title.</div>
            <div class="col-2"><input type="text" name="title" value=""${movie.title}></div>
<%--         <input type="text" value="${movie.no}" name="no" hidden="">--%>
            <%--↑sql작성할때 pk가 필요함(sql)수정할때 필요하니까 불러오기함
             but 유저가 수정할 필요는 없으니까 hidden으로 가려둔것--%>
        </div>
        <div>
            <div class="col-1">Actor.</div>
            <div class="col-2"><input type="text" name="actor" value="${movie.actor}"></div>
        </div>

        <div>
            <div class="col-1">Story.</div>
            <div class="col-2"><textarea name="story" id="" cols="30" rows="10">${movie.story}</textarea></div>
        </div>
        <div>
        <button class="movie-btn" name="no" value="${movie.no}">done</button>
<%--            <button class="movie-btn">done</button>--%>
        </div>

    </div>
</div>
</form>
</body>
</html>
