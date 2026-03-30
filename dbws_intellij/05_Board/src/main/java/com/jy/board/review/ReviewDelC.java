package com.jy.board.review;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/review-del")
public class ReviewDelC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      // 사제 하는 일
        ReviewDAO.RDAO.delReview(request);

        // 어디로?
        response.sendRedirect("review");

    }



    public void destroy() {
    }
}