package com.jy.board.review;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReviewDeatilC", value = "/review-detail")
public class ReviewDeatilC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      // 조회 하는 일
        ReviewDAO.RDAO.getReview(request);

      // 일하고 어디로 이동?
        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/review/review_detail.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }



    public void destroy() {
    }
}