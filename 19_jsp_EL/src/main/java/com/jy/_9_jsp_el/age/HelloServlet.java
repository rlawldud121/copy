package com.jy._9_jsp_el.age;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/age", name = "aa")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 일하는것(model을 불러오기)
        // 어디로 갈지
        request.getRequestDispatcher("age/index.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Model.makeInfo(request);
        request.getRequestDispatcher("age/output.jsp").forward(request,resp);
    }


}