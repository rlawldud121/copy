package com.jy.tag.bmi;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/bmi")
public class BMIC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("contentPage","bmi/index.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model.calc(request);

        request.setAttribute("contentPage","bmi/index.jsp");
        request.getRequestDispatcher("bmi/output.jsp").forward(request,response);

    }


}