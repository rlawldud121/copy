<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bmi.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/unit.css">
</head>
<body>
<div class="header">
  <a href="home">jy's place</a>
</div>
<div class="nav">
  <div><a href="a">A</a></div>
  <div><a href="b">B</a></div>
  <div><a href="c">C</a></div>
  <div><a href="unit">Unit</a></div>
  <div><a href="bmi">BMI</a></div>
</div>
<div class="main">

  <jsp:include page="${contentPage}"></jsp:include>
</div>
<div class="footer">
  information .. .
</div>

</body>
</html>


