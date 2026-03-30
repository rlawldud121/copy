package com.benr.el;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class M {
    public static void calc(HttpServletRequest request) {
        String name = request.getParameter("n");
        double mid  = Double.parseDouble(request.getParameter("m"));
        double last =  Double.parseDouble(request.getParameter("f"));

        System.out.println(name);
        System.out.println(mid);
        System.out.println(last);

        double avg = (mid+last)/2;

        String grde = "F";
        if (avg >= 90) {
            grde = "A";
        } else if (avg >= 80) {
            grde = "B";
        } else if (avg >= 70) {
            grde = "C";
        }

        Student student = new Student(name,mid,last,avg,grde);
        /* NoArgsConstructor(getter, setter) 안쓰려면 이렇게도 사용 가능
        student.setName(name);
        student.setMid(mid);
        student.setLast(last);
        student.setGrade(grde);
        student.setAvg(avg); */

        System.out.println(student);
        request.setAttribute("student", student);

        /// /////////
        request.setAttribute("a", "asdfafads");
        request.setAttribute("b", 12);
        int[] ar = {3,6,9};
        request.setAttribute("c", ar);

        Student [] ss = new Student[2];
        ss[0] = new Student("ss",90,90,90,"A");
        ss[1] =  new Student("s1", 90, 90, 90, "A");

        request.setAttribute("d", ss);

        Student s1 = new Student();

        //↓얘네는 attribute!! parameter로 땡겨쓰려고 하면 안땡겨짐
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(ss[0]);
        students.add(ss[1]);
        students.add(new Student("s2", 60, 70, 65, "B"));

        //↓ parameter로 쓸 수 있게 데이터 실어주기
        request.setAttribute("students", students);


    }
}
