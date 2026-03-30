package com.jy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del") //(name = "ResDelC", value ="/del") 같음 (name 유무는 관계 없음)
public class ResDelC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            // 삭제하는 일
        ResM.delRes(request);
            // 일 다 하고 어디로?
        response.sendRedirect("show");

    }



    public void destroy() {
    }
}