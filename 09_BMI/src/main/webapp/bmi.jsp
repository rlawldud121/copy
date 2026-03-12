<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* 귀여운 폰트 적용 */
    @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
    
    * { margin: 0; padding: 0; box-sizing: border-box; }
    
    body {
        /* 딸기 우유 그라데이션 배경 */
        background: linear-gradient(135deg, #ffe6fa 0%, #ffd3e0 100%); 
        font-family: 'Jua', sans-serif; /* 동글동글 귀여운 폰트 */
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        color: #555;
    }

    /* 하얀색 귀여운 카드 상자 */
    .cute-card {
        background: white;
        padding: 30px 40px;
        border-radius: 30px; /* 모서리를 아주 둥글게! */
        box-shadow: 0 10px 20px rgba(255, 182, 193, 0.4); /* 부드러운 핑크 그림자 */
        width: 100%;
        max-width: 350px;
        text-align: center;
    }

    .title {
        color: #ff7fac;
        font-size: 28px;
        margin-bottom: 25px;
    }

    /* 각 항목을 가로로 양끝 정렬 */
    .result-row {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 15px;
        font-size: 18px;
        border-bottom: 2px dashed #ffe6fa; /* 점선으로 귀여움 추가 */
        padding-bottom: 10px;
    }

    /* 사용자님이 원하셨던 span 태그에 알약 디자인 적용 💊 */
    .result-row span {
        background: #fff0f5;
        color: #ff6b9d;
        padding: 5px 15px;
        border-radius: 20px;
        font-weight: bold;
    }

    /* 마지막 결과 줄은 특별히 더 강조! */
    .final-result {
        border-bottom: none; /* 마지막 줄은 점선 제거 */
        margin-top: 20px;
        font-size: 22px;
        color: #ff7fac;
    }
    .final-result span {
        background: #ff7fac;
        color: white;
        font-size: 20px;
        box-shadow: 0 4px 10px rgba(255, 127, 172, 0.3);
    }

    /* 젤리 같은 버튼 디자인 */
    button {
        width: 100%;
        padding: 15px;
        background: #ff7fac;
        color: white;
        border: none;
        border-radius: 25px;
        font-size: 20px;
        font-family: 'Jua', sans-serif;
        cursor: pointer;
        transition: 0.2s; /* 마우스 올렸을 때 부드러운 애니메이션 */
        margin-top: 15px;
        display: block;
    }
    
    button:hover { 
        background: #ff5c93; 
        transform: scale(1.05); /* 마우스 올리면 살짝 커지는 젤리 효과 */
    }</style>
</head>
<body>
<%

// 서버상 경로 살리기

String path = request.getServletContext().getRealPath("uploadFile");
System.out.println(path);

// 파일 업로드 기능. //cos.jar
// 2. mr객체 생성

MultipartRequest mr = new MultipartRequest(request, path, 1024 * 1024 * 20, //20mb 최대 허용 용량
		"utf-8", //req.setCharacter("utf-8") 그거
		new DefaultFileRenamePolicy()
		);

// 변수 설정 (스캐너 설정)
String name = mr.getParameter("name");
double height = Double.parseDouble(mr.getParameter("height"));
double weight = Double.parseDouble(mr.getParameter("weight"));
double bmi = 0;
String result = "";

String imgF = mr.getFilesystemName("imgFile"); //서버에 올라간 파일명

// 검사 실행
bmi = weight / (height/100 * height/100) ;
if (bmi < 18.5) {
				result = "저체중";
			} 
			else if ( bmi <= 24.9) {
				result = "정상";
			}
			else if (bmi <= 29.9) {
				result = "1단계 비만";
			}
			else if (bmi <= 34.9) {
				result = "2단계 비만";
			}
			else {
				result = "3단계 비만";
			}
%>




<!-- 결과 표시   -->
<div class = "cute-card">
<div class="title">💖BMI 검사 결과 💖</div>
<div>
<img id="img" style="width:200px" src="uploadFile/<%=imgF %>">
</div>

<div class="result-row"> 이름 <span><%= name %> </span> </div>
<div class="result-row"> 키(cm) <span><%= height %> </span> </div>
<div class="result-row"> 체중(kg) <span><%= weight %> </span> </div>
<div class="result-row"> BMI <span><%= String.format("%.2f", bmi) %> </span> </div>
<div class="result-row"> 결과 <span><%= result %> </span> </div>

			
			
<!-- 다시하기 버튼 -->
<button class="button" type="submit" onclick="location.href='bmi.html'">다시하기🐾</button>
</div>






</body>
</html>