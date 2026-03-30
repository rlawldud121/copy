package com.jy.board.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    // 결과page에서 뭐 쓸지 ? or DB tbl
    private int no;
    private String title;
    private String actor;
    private String img;
    private String story;

}
