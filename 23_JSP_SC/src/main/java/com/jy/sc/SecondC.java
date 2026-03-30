package com.jy.sc;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SecondC", value = "/second-c")
public class SecondC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model.make(request,response);
        request.getRequestDispatcher("second.jsp").forward(request,response);
    }

    public void destroy() {
    }
}