package com.jy.board.movie;

import com.jy.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit")
public class MovieUpdateC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 그 영화 정보 하나 가져오늘 일
        //MovieDAO.getMovie(request);
        AccountDAO.ADAO.loginCheck(request);
        MovieDAO.MDAO.getMovie(request);
        // 어디로?
        request.setAttribute("content", "jsp/movie/movie_edit.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 수정하는 일
        request.setCharacterEncoding("UTF-8");
        //MovieDAO.upMovie2(request);
        MovieDAO.MDAO.upMovie2(request);
        // 다 하고 나면 어디로 이동?

        response.sendRedirect("detail-movie?no="+request.getAttribute("noo"));
    }



    public void destroy() {
    }
}