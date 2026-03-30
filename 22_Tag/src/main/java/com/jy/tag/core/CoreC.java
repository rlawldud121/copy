package com.jy.tag.core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CoreC", value = "/core")
public class CoreC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("content","core/core.jsp");
        request.getRequestDispatcher("main.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CoreM.work(request);

        //어디로 -> main
        request.setAttribute("content","core/core_result.jsp");
        request.getRequestDispatcher("main.jsp").forward(request,response);

    }

    public void destroy() {
    }
}