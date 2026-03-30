package com.jy.tag.unit;

import com.jy.tag.bmi.Model;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/unit")
public class unitC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //일
        UnitModel.calc(request);

        // 어디로 ? output.jsp > unit_conversion.jsp
        request.getRequestDispatcher("output.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model.calc(request);

        request.setAttribute("contentPage","unit/index.jsp");
        request.getRequestDispatcher("unit/output.jsp").forward(request,response);

    }


}