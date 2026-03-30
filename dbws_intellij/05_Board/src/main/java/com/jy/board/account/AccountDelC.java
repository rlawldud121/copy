package com.jy.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user-delete", name = "AccountDelC")
public class AccountDelC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    // 삭제 하는 일
        AccountDAO.ADAO.delUser(request);
    // 어디로?
        response.sendRedirect("main");

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //　로그인 하는 일
        if(AccountDAO.ADAO.delUser(req)){

            // 성공
        resp.sendRedirect("main");

        } else {
            // 아닐땐
        resp.sendRedirect("user-info");

        }

        // 어디로?
//        AccountDAO.loginCheck(req);
//        req.setAttribute("content", "home.jsp");
//        req.getRequestDispatcher("index.jsp").forward(req,resp);

        // 아닐때


    }



    public void destroy() {
    }
}