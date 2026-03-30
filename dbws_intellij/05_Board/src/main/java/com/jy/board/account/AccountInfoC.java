package com.jy.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user-info", name = "AccountInfoC")
public class AccountInfoC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    // 무슨일? id 조회하는 일은 필요 x => 이미 세션에 있으니까!
       if (AccountDAO.ADAO.loginCheck(request)){
        request.setAttribute("content", "jsp/account/mypage.jsp");
       } else {
        request.setAttribute("content", "home.jsp");
       }

        request.getRequestDispatcher("index.jsp").forward(request,response);

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