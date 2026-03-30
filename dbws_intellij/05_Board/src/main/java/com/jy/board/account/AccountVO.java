package com.jy.board.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountVO {
    private String id;
    private String pw;
    private String name;

}
