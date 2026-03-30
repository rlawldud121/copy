<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>웹 레이아웃</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
    }
    a {
      color: red;
      text-decoration: none;
    }
    .container {
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }

    .header {
      background-color: #2c3e50;
      color: white;
      padding: 20px;
      text-align: center;
      font-size: 24px;
    }

    .content {
      flex: 1;
      padding: 30px;
      background-color: #f4f4f4;
      font-size: 18px;
    }

    .footer {
      background-color: #ecf0f1;
      padding: 15px;
      display: flex;
      justify-content: center;
      gap: 20px;
      font-weight: bold;
    }

    .footer div {
      background-color: #bdc3c7;
      padding: 10px 15px;
      border-radius: 5px;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="header"><a href="/main">web's title</a></div>
  <div class="content">
    <jsp:include page="${content}"></jsp:include>
  </div>
  <div class="footer">
    <div><a href="core">JSTL-CORE</a></div>
    <div><a href="format">JSTL-Format</a></div>
  </div>
</div>
</body>
</html>