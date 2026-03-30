<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>

        body{
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg,#6dd5fa,#2980b9);
            height:100vh;
            display:flex;
            justify-content:center;
            align-items:center;
            margin:0;
        }

        form{
            background:white;
            padding:40px 60px;
            border-radius:10px;
            box-shadow:0 10px 25px rgba(0,0,0,0.2);
            text-align:center;
        }

        h1{
            margin-bottom:30px;
            color:#333;
        }

        div{
            display:flex;
            flex-direction:column;
            gap:15px;
        }

        input{
            padding:10px;
            border:1px solid #ccc;
            border-radius:5px;
            font-size:16px;
            width:220px;
        }

        input:focus{
            outline:none;
            border-color:#2980b9;
        }

        button{
            margin-top:10px;
            padding:10px;
            border:none;
            background:#2980b9;
            color:white;
            font-size:16px;
            border-radius:5px;
            cursor:pointer;
            transition:0.3s;
        }

        button:hover{
            background:#1f6694;
        }

    </style>
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