package com.jy.web;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    public static ArrayList<MemberDTO> getAllMember() {
        // DB에 접속하는애

        // 1. 값 or db세팅
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from member_test";

        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int no, age;
            String name;
            MemberDTO memberDTO = null;
            ArrayList<MemberDTO> members = new ArrayList<>();
            while (rs.next()) {
                no = rs.getInt("m_no");     //컬럼 넘버(인덱스)=라벨 출력은 동일
                name = rs.getString(2);
                age = rs.getInt(3);
                memberDTO = new MemberDTO(no, name, age);
                members.add(memberDTO);
            }
            System.out.println(members);
            return members;


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return null;
    }


    public static void addMember(MemberDTO member) {
        // 1. 값받기 or db setting

         // DB setting
        Connection conn = null;
        PreparedStatement pstmt = null;                                      // sql에는 ";" 있으면 안됨!!
        String sql = "insert into member_test values (member_test_seq.nextval, ?, ?)";

        try {
//            req.setCharacterEncoding("UTF-8");

            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);

            // 값받기(index.jsp의 input 부분)

            String name = member.getName();
            int  age = member.getAge();
            pstmt.setString(1, name);   // 1번째 물음표
            pstmt.setInt(2, age);    // 2번째 물음표

            if (pstmt.executeUpdate() == 1){
                System.out.println("add success");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }   finally {
            DBManager.close(conn, pstmt, null);

        }

    }

    public static void delMember(MemberDTO member) {
        // 1. 값받기 or DBsetting
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete member_test where m_no = ?";       // "?"가 포인트 = pk가없으면 삭제를 할수가 없음!!!

        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);

            // 값받기(index.jsp의 input 부분)

            int no = member.getNo();     // delete function에서 쓴 변수명
            pstmt.setInt(1, no);   // 1번째 물음표

            if (pstmt.executeUpdate() == 1){
                System.out.println("delete success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }   finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public static void updateMemberName(MemberDTO member) {
        // 1. 값받기 or DBsetting
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update member_test set m_name = ? where m_no = ?";

        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);

            // 값받기(index.jsp의 input 부분)

            int no = member.getNo();
            String name = member.getName();
            pstmt.setString(1, name);   // 1번째 물음표
            pstmt.setInt(2, no);   // 2번째 물음표

            if (pstmt.executeUpdate() == 1){
                System.out.println("name update success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }   finally {
            DBManager.close(conn, pstmt, null);
        }

    }
}

