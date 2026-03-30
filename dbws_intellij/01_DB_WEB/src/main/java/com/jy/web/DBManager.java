package com.jy.web;

import java.sql.*;

public class DBManager {

    public static Connection connect() throws SQLException {

        String url = "jdbc:oracle:thin:@10.1.82.127:1521:XE";
        // 클라우드

        return DriverManager.getConnection(url, "c##jy1004", "jy1004");
    }

    // 넘겨받는 순서 상관 x
    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        try{
        if (rs != null) {  //rs는 쓸수도 있고 안쓸수도 있으니까 null일경우 예외처리
            rs.close();
        }
            ps.close();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


}
