package com.jy.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user-login", name = "AccountC")
public class AccountC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    // 로그아웃 하는 일
        AccountDAO.ADAO.logout(request);
    // 어디로?
        response.sendRedirect("main");

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //　로그인 하는 일
        AccountDAO.ADAO.login(req);
        // 어디로?
        AccountDAO.ADAO.loginCheck(req);
        req.setAttribute("content", "home.jsp");
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }



    public void destroy() {
    }
}