package com.jy._9_jsp_el.bmi;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Model {
    public static void calc(HttpServletRequest request) throws IOException {

        String path = request.getServletContext().getRealPath("uploadFile");
        System.out.println(path);

        MultipartRequest mr = new MultipartRequest(request, path , 1024*1024*20,"utf-8", new DefaultFileRenamePolicy());
        //값 받기
       String name =  mr.getParameter("name");
       double height=Double.parseDouble(mr.getParameter("height"))/100;
       double weight = Double.parseDouble(mr.getParameter("weight"));

        String imgF = mr.getFilesystemName("imgFile");
       //bmi 계산
        double bmi = weight/(height*height);

        String result = "";

        if(bmi >=25){
            result= "살 좀 빼라";
        }else if(bmi >=23){
            result= "돼지";
        }else if(bmi >= 18.5){
            result = "정상";
        }else if (bmi < 18.5){
            result = "기아";
        }

        String r = String.format("%.2f", bmi);

        Bean b1 = new Bean(name,height,weight,r,result,imgF);
        request.setAttribute("b2",b1);
    }
}
