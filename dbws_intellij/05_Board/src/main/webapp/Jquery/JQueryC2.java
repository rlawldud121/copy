package com.jy.board.Jquery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JQueryC2", value = "/get-json")
public class JQueryC2 extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("json get 요청 ~~~~ ");
        response.setContentType("application/json;charset=utf-8");
        HumanDAO.getJSON();
        response.getWriter().println(HumanDAO.getJSON());



    }

    public void destroy() {
    }
}