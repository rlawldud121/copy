package com.jy.board.movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteMovie")
public class DeleteC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    //MovieDAO.deleteMovie(request);
    MovieDAO.MDAO.deleteMovie(request);
    response.sendRedirect("movie");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 등록하는 일
        // 어디로?
    }

    // static 있으면? 다른 파일에 . 찍고 바로 사용 가능
    // static 없으면? 다른 파일에 new로 새로운 객체를 만들어야 사용 가능


    public void destroy() {
    }
}