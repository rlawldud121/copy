package com.jy.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/all")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 전체 조회 하는 일
        MemberDAO.getAllMember(request);        //request안에 "members"라는 배열이 들어있음

        // 어디로?
        request.getRequestDispatcher("member_list.jsp").forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 등록하는 일
        MemberDAO.addMember(req);        //request안에 "members"라는 배열이 들어있음

        // 어디로?
       // req.getRequestDispatcher("member_list.jsp").forward(req,resp);
        resp.sendRedirect("all");

    }

    public void destroy() {
    }
}