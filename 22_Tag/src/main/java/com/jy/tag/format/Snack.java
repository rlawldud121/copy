package com.jy.tag.format;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snack {
    private String name;
    private int price;
    private Date date;
}
