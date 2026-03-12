package com.jy.test;

import javax.servlet.http.HttpServletRequest;

public class Model {
    public static void makeInfo(HttpServletRequest request) {


        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String interest[] = request.getParameterValues("checkbox");

        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);

        String interest2 = "";
        if (interest != null) {
            for(String i : interest) {
                System.out.println(i);
                interest2 += i + "/";
            }

        }
    // 결과에서 필요한거
    // 한번에 뭉쳐서 보내기 (객체)
    Information info = new  Information(name, age, gender, interest2);
    request.setAttribute("information", info);



    }

}
