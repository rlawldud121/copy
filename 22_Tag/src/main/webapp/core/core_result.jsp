
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        div {
            text-align: center;
        }

        .item {
            width: 50%;
            border-bottom: 1px solid black;
        }

        .item-row:hover {
            background-color: tomato;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>당신의 나이는 ${age} 입니다.</h1>
<%--
    1. jsp 표준 액션 태그 : include

    2. jstl (사제,기본 베이스로는 사용 불가) : jstl.jar(연결해주는 라이브러리 필요)


    20살 이상 존댓말 / 반말
--%>
<c:if test="${age >= 20}">
    <h1>안녕하세요</h1>
</c:if>

<c:if test="${age < 20}">
    <h1>안녕</h1>
</c:if>

<%-- <c:otherwise>asd</c:otherwise>  : else 느낌 / 단독으로만은 사용 불가(짝을 찾을수가 없어서)--%>

<%-- if, else if, else --%>
<c:choose>
        <c:when test="${age >= 20}">
            어서오세요
        </c:when>
        <c:when test="s{age > 10}">
            어서와~
        </c:when>
        <c:otherwise>
            안녕~
        </c:otherwise>

</c:choose>
<hr>
<%--반복문--%>

<c:forEach begin="1" end="3" step="2">
    <h1>ㅇㅁㅇ</h1>
</c:forEach>


<%-- 역순은 안됨 / step에 음수 사용 불가 / 다른 방법을 써야됨 --%>
<c:forEach begin="1" end="${age}" var="aa" step="1">
    ${aa}
</c:forEach>
<hr>

<c:forEach items="${ar}" var="aa">
    ${aa}
</c:forEach>

<hr>
<c:forEach var="menu" items="${menus}">
    ${menu.name} / ${menu.price}
</c:forEach>

<div style="border: 2px solid mediumpurple; width: 300px">
    <div style="display: flex">
        <div class="item name">번호</div>
        <div class="item name">메뉴명</div>
        <div class="item price">가격</div>
    </div>
        <c:forEach items="${menus}" var="menu" varStatus="st">
        <div class="item-row" style="display: flex">
            <div class="item index">${st.count}</div>
            <div class="item name">${menu.name}</div>
            <div class="item price">${menu.price}</div>
        </div>
        </c:forEach>
</div>

<hr>

<c:forEach var="i" begin="1" end="10" varStatus="st">
    <%-- 11-i   --%>
    ${st.end+1-i}
</c:forEach>

<c:forEach var="i" begin="1" end="10">
    <c:set var="v" value="${11-i}"></c:set>
    <c:out value="${v}"></c:out>
</c:forEach>


</body>
</html>

