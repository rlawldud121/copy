package com.jy.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/show")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            // 전체 조회 하는 일
        ResM.showAllRes(request);
            // 어디서
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 등록하는 일
        ResM.addRes(request);
        // 어디로?
        response.sendRedirect("show");
    }

    public void destroy() {
    }
}