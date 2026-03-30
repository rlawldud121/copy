package com.jy.board.movie;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/movie")
public class MovieC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (request.getParameter("type") != null && request.getParameter("type").equals("movie")) {
            // 삭제하는 일
            // MovieDAO.deleteMovie(request);
            MovieDAO.MDAO.upMovie(request);
            MovieDAO.MDAO.deleteMovie(request);
            System.out.println("del");
            response.sendRedirect("movie");
        } else {
            String p = request.getParameter("p");
            int page = 1;
            if (p != null) {
                page =  Integer.parseInt(p);
            }

            // MovieDAO.selectAllMovie(request);
            // MovieDAO.paging(page, request);
            MovieDAO.MDAO.selectAllMovie(request);
            MovieDAO.MDAO.paging(page, request);
        }

        AccountDAO.ADAO.loginCheck(request);
        request.setAttribute("content", "jsp/movie/movie.jsp");  // content 안에 home.jsp를 넣음
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 등록하는 일
     //   MovieDAO.addMovie(request);
        MovieDAO.MDAO.upMovie(request);
        // 어디로?
        response.sendRedirect("movie");
    }



    public void destroy() {
    }
}