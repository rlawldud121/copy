package com.jy.board.movie;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/detail-movie")
public class MovieDetailC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // 클릭한 그 영화 하나의 조회하는 일
    //MovieDAO.getMovie(request);
        AccountDAO.ADAO.loginCheck(request);
        MovieDAO.MDAO.getMovie(request);
        //어디로?
    request.setAttribute("content", "jsp/movie/movie_detail.jsp");
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }



    public void destroy() {
    }
}