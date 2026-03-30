package com.jy.tag.unit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UnitVO {
    private double v;
    private String u;
    private String r;
    private String before;
    private String after;
    private String beforeColor;
    private String afterColor;
    private String cardColor;

}
