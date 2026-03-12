package com.jy.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Information {
    private String name;
    private int age; // age로 뭐 할 일 이 없어서 string 으로도 사용 가능
    private String gender;
    private String interest;


}
