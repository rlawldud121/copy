package com.jy.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user-edit", name = "AccountEditC")
public class AccountEditC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 무슨 일? => 수정하는 일(은 할 수 없음...) => 수정하는 곳으로 보내기
        // pk 교체하는 로직은 존재하지않음 => 기술적으로 못할건 아니지만 하지말자
        // 결론 => 어디로 갈지 종착지
        // index로 가기전에 attribute 를 만들고가야 아래의 index가 정상 동작
        if (AccountDAO.ADAO.loginCheck(request)){
        request.setAttribute("content", "jsp/account/edit.jsp");
        } else {
        request.setAttribute("content", "home.jsp");
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    // 수정하는 일
        if (AccountDAO.ADAO.loginCheck(req)){
        // 세션이 죽으면 ↓도 만나지못함 (if충족이 안됐을때)
        AccountDAO.ADAO.editUser(req);
        }
   // 어디로?

        resp.sendRedirect("user-info");

         }



    public void destroy() {
    }
}