package com.jy.board.review;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/review-add")
public class ReviewAddC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      // 게시글 추가하러 (일을 할 수 없으니 input 받을 jsp?를 작성)

        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/review/review_add.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 등록하는 일
        req.setCharacterEncoding("utf-8");
        ReviewDAO.RDAO.upReview(req);

        // 어디로?
        // 이동했을때 전체 조회하는 일을 해야됨

        resp.sendRedirect("review");
        // ↑의 축약본 ↓
//        ReviewDAO.RDAO.showAllReview(req);
//        AccountDAO.ADAO.loginCheck(req);
//        req.setAttribute("content", "jsp/review/review_add.jsp");
//        req.getRequestDispatcher("index.jsp").forward(req,resp);


    }



    public void destroy() {
    }
}