package com.jy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/up")
public class ResUpC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            // 업데이트하는 일
        ResM.upResName(request);
            // 일 다 하고 어디로?
        response.sendRedirect("show");

    }



    public void destroy() {
    }
}