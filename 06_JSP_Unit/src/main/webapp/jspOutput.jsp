<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
  body{
    margin:0;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#6f6bff,#5f9cff);
    font-family:Arial, Helvetica, sans-serif;
}

/* 결과 박스 */
.result-box{
    background:white;
    padding:40px 60px;
    border-radius:15px;
    box-shadow:0 10px 30px rgba(0,0,0,0.2);

    display:flex;
    flex-direction:column;   /* ⭐ 세로 정렬 */
    align-items:center;
    gap:10px;                /* 줄 간격 */
}

/* 제목 */
.title{
    font-size:26px;
    font-weight:bold;
    margin-bottom:10px;
}

/* 값 */
.value{
    font-size:20px;
}

/* 화살표 */
.arrow{
    font-size:28px;
}

/* 결과 */
.result{
    font-size:28px;
    font-weight:bold;
    color:#5f9cff;
}

button{
    margin-top:10px;
    padding:10px 25px;
    border:none;
    border-radius:8px;
    background:#5f9cff;
    color:white;
    font-size:16px;
    cursor:pointer;
}

button:hover{
    background:#3d7ff0;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%
	int value = Integer.parseInt(request.getParameter("int"));
	String trans = request.getParameter("translate");
	
	double result = 0;
	String converUnit = "";
	String selectedUnit = "";
	
	if(trans.equals("c2i")){
		result = value * 0.3937;
		converUnit = "cm";
		selectedUnit = "inch";
	}
	else if(trans.equals("m2p")){
		result = value * 0.3025;
		converUnit = "㎡";
		selectedUnit = "평";
	}
	else if (trans.equals("c2f")){
		result = value * 1.8 +32;
		converUnit = "℃";
		selectedUnit = "℉";
	}
	else if (trans.equals("km2mi")){
		result = value * 0.6213;
		converUnit = "km/h";
		selectedUnit = "mi/h";
	}
	
	%>	
	

	
</body>
</html>