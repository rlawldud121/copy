<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="bmi" method="post" enctype="multipart/form-data">

    <h1>BMI 측정</h1>
    <div>
        이름 : <input type="text" name="name">
         키 : <input type="number" name="height">
        몸무게 : <input type="number" name="weight">

        사진 : <input type = "file" name = "imgFile">
        <button>확인</button>
    </div>



</form>
</body>
</html>