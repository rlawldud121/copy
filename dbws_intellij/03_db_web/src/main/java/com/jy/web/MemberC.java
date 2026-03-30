package com.jy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemberC", value = "/del")
public class MemberC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 무슨일 할지? => 삭제하는일
        MemberDAO.delMember(M.getMember(request));
        // 어디로 갈지?
//        MemberDAO.getAllMember(request);
//        request.getRequestDispatcher("member_list.jsp").forward(request, response);
            response.sendRedirect("all");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 등록하는 일
//        MemberDAO.addMember(req);        //request안에 "members"라는 배열이 들어있음
//
//        // 어디로?
//       // req.getRequestDispatcher("member_list.jsp").forward(req,resp);
        resp.sendRedirect("all");

    }

    public void destroy() {
    }
}