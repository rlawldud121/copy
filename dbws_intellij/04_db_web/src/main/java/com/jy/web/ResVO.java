package com.jy.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResVO {
    // 결과에서 뭘 쓸지 ? or tbl (db)

    private int no;
    private String name;
    private String place;
    private String img;
}
