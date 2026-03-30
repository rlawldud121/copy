package com.jy.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Human {
    // 결과에서 뭘 쓸지? or table(== db)
    private String name;
    private int age;


}
