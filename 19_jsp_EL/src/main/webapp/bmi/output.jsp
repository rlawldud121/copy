
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<img id = "img" style = "width: 200px" src= "uploadFile/${b2.imgF}"><br>
이름 : ${b2.name}<br>
 키 : ${b2.height*100}cm<br>
체중 : ${b2.weight}kg<br>
bmi : ${b2.r}<br>
당신은${b2.result}입니다 <br>
<a href="/19_jsp_EL_war_exploded/">처음으로</a>
</body>
</html>
