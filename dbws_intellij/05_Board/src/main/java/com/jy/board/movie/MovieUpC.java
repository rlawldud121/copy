package com.jy.board.movie;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/update")
public class MovieUpC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 그 영화 정보 하나 가져오늘 일
    //    MovieDAO.getMovie(request);
        AccountDAO.ADAO.loginCheck(request);
        MovieDAO.MDAO.upMovie(request);
        // 어디로?
        request.setAttribute("content", "jsp/movie/movie_up.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 수정하는 일
        request.setCharacterEncoding("UTF-8");
      //  MovieDAO.upMovie(request);
        MovieDAO.MDAO.upMovie(request);
        // 다 하고 나면 어디로 이동?
//        MovieDAO.getMovie(request); // 일 시키기 (requset안에 parameter안에 no가 있어야 동작 가능)
//        request.setAttribute("content", "jsp/movie/movie_detail.jsp"); // movie_detail.jsp로 이동하기
//        request.getRequestDispatcher("index.jsp").forward(request, response); // 최종적으로 이동하기

        response.sendRedirect("detail-movie?no=" + request.getParameter("no"));

    }



    public void destroy() {
    }
}