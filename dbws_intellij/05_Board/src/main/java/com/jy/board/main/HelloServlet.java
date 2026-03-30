package com.jy.board.main;

import com.jy.board.account.AccountDAO;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/main")
public class HelloServlet extends HttpServlet {

    // 기준점 start
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    AccountDAO.ADAO.loginCheck(request);
    request.setAttribute("content", "home.jsp");
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    public void destroy() {
    }
}