
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--  Student s =  (Student) request.getAttribute("student");--%>
<%--%>--%>
        <%-- parameter(index에 작성한 name)으로도 값 불러오기 가능--%>
<%--이름 : <%=request.getParameter("n")%>
중간 : <%=s.getMid()%>
기말 : <%=s.getLast()%>
평점 : <%=s.getAvg()%>
등급 : <%=s.getGrade()%>--%>

<hr>
이름 : ${param.n} <br>
중간 : ${param.m} <br>
기말 : ${student.last} <br>
평점 : ${student.avg} <br>
등급 : ${student.grade} <br>
<hr>
a: ${a} <br>
b: ${b}<br>
c: ${c[0]},${c[1]},${c[2]},${c[3]}<br>
<%--↑c[3]배열에 데이터가 없어서 원래는 error났어야했는데 EL 사용해서 자동으로 넘어감--%>
d: ${d[0].grade} / ${d[1].name}<br>

<hr>
${students} <br>
${stidents[1].name}

<%--1번 학생의 이름 / 등급--%>
${students[0].name} / ${students[0].grade}<br>

<%--3번 학생의 이름, 평점, 등금--%>
${students[2].name} / ${students[2].avg} / ${students[2].grade}<br>

<%--
    .jsp 파일에 자바를 쓰는 경우
    : 값 받으려고(읽으려고)
    : 조건문, 반복문
    : 출력형식 때문에 Strinf.format()
    EL (Expression Language)
    - 값 읽을때
    - 연산자 사용 가능
    - import 필요 없음
    - 값이 없으면 넘어감

    EL  - parameter 읽기 : %{param.이름}
        - attribute 읽기 : %{attribute 이름}
        - object 읽기 : ${이름.멤버변수}}

        기본형[] or ArrayList<>    : ${이름[인덱스]}}
        객체[]                    : ${이름[인덱스].멤버변수}}
--%>
</body>
</html>
