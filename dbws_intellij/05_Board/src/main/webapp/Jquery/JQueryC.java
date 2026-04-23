package com.jy.board.Jquery;

import com.jy.board.account.AccountDAO;
import com.jy.board.review.ReviewDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JQueryC", value = "/jquery")
public class JQueryC extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/jquery/Ajax.html").forward(request,response);



    }

    public void destroy() {
    }
}