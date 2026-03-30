package com.jy.tag.unit;

import javax.servlet.http.HttpServletRequest;

public class UnitModel {
    public static void calc(HttpServletRequest request) {

        double v = Double.parseDouble(request.getParameter("vals"));
        String u = request.getParameter("unit");
        double result = 0;

        String before = "";
        String after = "";
        String beforeColor = "";
        String afterColor = "";
        String cardColor = "";

        if (u.equals("cm")) {
            result = v * 0.3937;
            before = "cm";
            after = "inch";
            beforeColor = "blue";
            afterColor = "blue";
            cardColor = "#d0e7ff";// 연한 파랑
        }

        else if (u.equals("mm")) {
            result = v * 0.3025;
            before = "㎡";
            after = "평";
            beforeColor = "purple";
            afterColor = "purple";
            cardColor = "#f3e0ff"; // 연한 보라
        }

        else if (u.equals("cc")) {
            result = (v * 9 / 5) + 32;
            before = "℃";
            after = "℉";
            beforeColor = "red";
            afterColor = "red";
            cardColor = "#ffe0e0"; // 연한 빨강
        }

        else if (u.equals("km")) {
            result = v * 0.621371;
            before = "km/h";
            after = "mi/h";
            beforeColor = "green";
            afterColor = "green";
            cardColor = "#b3f0c4"; // 연한 초록
        }

        /* 소수점 1자리 */
        String r = String.format("%.1f", result);

        UnitVO unitVO = new UnitVO(v, u, r, before, beforeColor, after, afterColor, cardColor);
        request.setAttribute("unit", unitVO);
        }
}
