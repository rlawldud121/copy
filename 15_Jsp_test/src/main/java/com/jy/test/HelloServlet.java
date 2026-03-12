package com.jy.test;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 일하는것(model을 불러오기)
        Model.makeInfo(request);
        // 어디로 갈지
        request.getRequestDispatcher("output.jsp").forward(request,response);
    }

    public void destroy() {
    }
}