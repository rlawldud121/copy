package com.jy.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/show-all")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 전체 조회 하는 일
        UserDAO.showAllPeople(request);
        // 어디로 갈지?
        request.getRequestDispatcher("output.jsp").forward(request,response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 등록하는 일
        UserDAO.addPeople(request);
        // 어디로?

        // 전체조회 하는 일
        UserDAO.showAllPeople(request);
        request.getRequestDispatcher("output.jsp").forward(request,response);


    }


    public void destroy() {
    }
}