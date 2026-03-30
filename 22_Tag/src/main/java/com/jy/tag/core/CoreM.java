package com.jy.tag.core;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;

public class CoreM {
    public static void work(HttpServletRequest request) {
    // 1. 값 받기
        int year = Integer.parseInt(request.getParameter("y"));
        System.out.println(year);

        int curYear = LocalDate.now().getYear();
        int age = curYear - year +1;
        request.setAttribute("age", age);

        int[] ar = {1,2,3,4,5};
        request.setAttribute("ar", ar); /*결과창에서 쓰고싶으면 attribute 만들어야 사용가능(attribute화)*/

        ArrayList<Menu>  menus = new ArrayList<>();
        menus.add(new Menu("휠렛세트",7500));
        menus.add(new Menu("닭갈비",8000));
        menus.add(new Menu("백반",5000));
        menus.add(new Menu("김치찌개",8500));
        menus.add(new Menu("집에가고싶어요",6000));
        request.setAttribute("menus", menus);


    }
}

