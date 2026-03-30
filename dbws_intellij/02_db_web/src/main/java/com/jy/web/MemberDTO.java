package com.jy.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
    //DTO : 데이터 실행하는애
    // 결과에서 뭐 쓸지? or tbl (db보고 쓰는거?db에 테이블)
    private int no;
    private String name;
    private int age;
}
