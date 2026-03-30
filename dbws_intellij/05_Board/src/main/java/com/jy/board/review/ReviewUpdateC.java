package com.jy.board.review;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReviewUpdateC", value = "/review-update")
public class ReviewUpdateC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      // 전체 조회 하는 일
        ReviewDAO.RDAO.getReview(request);


        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/review/review_update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 수정하는 일
        ReviewDAO.RDAO.updateReview(request);


        // 어디로?
        response.sendRedirect("review-detail?pk="+request.getParameter("no"));
        // "review-detail(upate)"가 안되는 이유: 이동 한 후 url이 no(pk)로 이동해야하는데 가지않아서
        // => url을 requset해서 받아주기

    }

    public void destroy() {
    }
}