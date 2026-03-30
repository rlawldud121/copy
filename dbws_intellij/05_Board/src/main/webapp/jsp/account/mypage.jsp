
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1> - my page - </h1>
<div class="info-wrap">
  <div class="info-row">
    <div>ID.</div>
    <div>${sessionScope.user.id}</div>
  </div>
  <div class="info-row">
    <div>PW.</div>
    <div>${sessionScope.user.pw}</div>
  </div>
  <div class="info-row">
    <div>Name.</div>
    <div>${sessionScope.user.name}</div>
  </div>
  <div>
    <button class="movie-btn" onclick="location.href='user-edit'">수정하기</button>
    <%-- url 설정 잘 해놨는데 자꾸 home page로 돌아옴! => include 잘못된건 아닌지 의심하기 --%>
    <button onclick="deleteUser()" class="movie-btn">탈퇴하기</button>

    <div class="confirm" style="display: none">
      your every data will be gone. are you sure? <br>
      <form action="user-delete" method="post">
        <input type="password" name="pw">
        <button class="confirm">confirm</button>
      </form>
    </div>

  </div>
</div>
<script >
  function deleteUser(){
    <%--const id = "${user.id}";--%>

    <%--let ok =confirm("탈퇴하시겠습니까?")--%>
    <%--if (ok){--%>
    <%--  location.href='user-delete?l_id=' + id;--%>
    // }
                          // 클래스 선택자 : .으로 불러옴
    document.querySelector('.confirm').style.display = 'block'
  }

</script>
</body>
</html>
