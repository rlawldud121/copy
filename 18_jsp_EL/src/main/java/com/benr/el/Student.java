package com.benr.el;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //기본생성자 함수(constructor 함수생성)
@AllArgsConstructor //오버로딩생성자 함수(overloading)
@Data //getter, setter
public class Student {
    // 결과에서 뭘 쓸지
    private String name;
    private double mid;
    private double last;
    private double avg;
    private String grade;




}
