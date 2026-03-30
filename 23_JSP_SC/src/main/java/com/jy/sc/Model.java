package com.jy.sc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Model {

    /*
     parameter - V에서 만든 값(html, jsp, get요청 만든 문자열, form -> input name)
               - String, String[] _ chkbox
                 req에 실려서 전송
         - 값 읽을 때
            - java  : req.getParameter("이름")
            - EL    : ${param.이름}

    attribute - Java에서 만든 값(Model)
              - Object 다 됨 (객체, 배열, 문자 그외 등등 다!)
                req에 실려서 전송
         - 값 읽을 때
            - java  : req.getAttrbute("이름")
            - EL    : ${이름}
    * */

    public static void printSC(HttpServletRequest request){
        /*
          ★중요★    session.attr - java(Model, Controller(servelet)  - 서버----ㅡ클라이언트 연경상태(연결끊기면 없어짐)에 달림
                    => object / 시간제한 (기본 30분)
                값 읽을 때
                    JAVA    : req.getSession().getAttribute("이름")
                    EL      : ${이름} / ${sessionScope.이름} << 추천

         */
            // HttpSession hs = request.getSession();
        Object session = request.getSession().getAttribute("c");
        System.out.println(session);




        /*
            cookie  - java에서 만든 값
            - 값 읽을 때
                EL  : ${cookie.쿠키이름.value}
                JAVA : 하기의 설명 확인


        */
           Cookie[] cookies = request.getCookies();  // 쿠키라는게 하나의 정해진 값이 아니기때문에 배열에 담아짐
           for(Cookie cookie : cookies){
               System.out.println(cookie.getName());
               if(cookie.getName().equals("d")){
                   System.out.println(cookie.getValue());
               }
           }


    }

    public static void make(HttpServletRequest request, HttpServletResponse response) {
        String bbb = "zzz";
        request.setAttribute("b", bbb);

        request.getParameter("a");

        // => attribute로 출력됨

        // param, attr
    // 특성 third에서 사용 불가능

     // session, cookie

        String ccc = "세션~~~!~";
        HttpSession hs = request.getSession();
        hs.setAttribute("c",ccc);
        hs.setMaxInactiveInterval(10);  // 10초

        // 서버와 클라이언트 연결상태(접속한거)
        // 연결만 살아있으면 이 사이트 어디에서든 사용 가능

        // 연결 끊어지면 못 씀 (접속 종료 / 브라우저 다 닫은거)
        // 세션 유지시간(기본 30분)

        // 유지시간 이내에 '요청'등이 일어나지 않으면 죽음
        // 시가내에 '요청'등의 작업을 하면 갱신됨(유지시간 초기화)

        // cookie

        // 사용자 컴퓨터에 파일로 저장.
        // 브라우저를 꺼도, 접속을 끊어도, 재부팅을 해도 살아있음

        // 시간제한을 걸 수 있음

        String ddd = "쿠키";
        Cookie coo = new Cookie("d", ddd);
        coo.setMaxAge(5*60);//5분
        response.addCookie(coo);







    }

}
