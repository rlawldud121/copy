package com.jy.web;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    public static void showAllPeople(HttpServletRequest request) {
        // 1. 값 or db   / 껍데기 3종 con, pstmt, rs (selec,조회 할때 껍데기 3종 필요!)

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String url = "jdbc:oracle:thin:@10.1.82.127:1521:XE";
    String sql = "select * from name_age_test";

	// 데이터 확인하는거
    try {
        con = DBManager.connect();
        System.out.println("connect success");
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        ArrayList<Human> humans = new ArrayList<>();
        Human human = null;

        while (rs.next()) {
            human = new Human(rs.getString("n_name"),rs.getInt("n_age"));
            humans.add(human);
        }
        System.out.println(humans);
        request.setAttribute("humans",humans);

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        DBManager.close(rs, ps, con);
    }
    }

    public static void addPeople(HttpServletRequest request) {
    // 1. 값 받기 or db세팅 (어차피 다 해야됨)
	// 데이터 입력하는거

        Connection con = null;
        PreparedStatement ps = null;

        try {
            String name = request.getParameter("n");
            String age = request.getParameter("a");

            con = DBManager.connect();
            System.out.println("connect success");
            ps = con.prepareStatement("insert into name_age_test values(?,?)");
            ps.setString(1, name);
            ps.setString(2, age);

            if (ps.executeUpdate() == 1) {
                System.out.println("insert success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(null, ps, con);

        }


    }
}
