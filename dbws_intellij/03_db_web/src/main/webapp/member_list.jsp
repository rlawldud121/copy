<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="member.css">
  <script>
    function deleteMember(nooo){
      let ok = confirm('삭제하시겠습니까?')   //boolen타입 확인 : true / 최소 : false
      if(ok){
        location.href='del?num=' + nooo;
      }
    }
    function updateMemberName(nnn, naaaame){
      let name = prompt('수정하시겠습니까?', naaaame);
      // alert(name);
      if(name != "" && name != null){
      location.href = 'update?num='+nnn+'&n='+name; // href는 get 요청이기때문에 post 부분에 연경을 할 수 없음
      }


    }
  </script>
</head>
<body>
<%-- members라는 attribute값을 꺼내오기 --%>
<div class="container">
  <div class="title">👩‍💻 회원 리스트</div>

  <c:forEach var="m" items="${members}">    <%-- 펼쳐지는게 foreach의 영향이니까 그 안에서 버튼 생성해야됨 --%>
    <div class="member">                        <%-- 글자면 '' 필수 / 숫자여도 '' 넣는게 더 잘 작동됨 --%>
      <span class="name" onclick="updateMemberName('${m.no}','${m.name}')">${m.name}</span>
      <span class="age">${m.age}세</span>
      <div><button onclick="deleteMember(${m.no})">del</button></div>
    </div>
  </c:forEach>
</div>

</body>
</html>
