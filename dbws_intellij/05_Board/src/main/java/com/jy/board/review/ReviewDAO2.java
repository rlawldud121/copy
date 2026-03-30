package com.jy.board.review;

import com.jy.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ReviewDAO2 {

    public static final ReviewDAO2 RDAO = new ReviewDAO2(); // 상수 (private이 아니라 getter 필요 x)

    private ReviewDAO2() { //생성자 잠금
    }

    public ArrayList<ReviewVO> showAllReview(HttpServletRequest request) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from REVIEW_TEST order by r_date";
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            ReviewVO reviewVO = null;
            ArrayList<ReviewVO> reviews = new ArrayList<>();
            while (rs.next()) {
                int no = rs.getInt("r_no");
                String title = rs.getString("r_title");
                String txt = rs.getString("r_txt");
                Date date = rs.getDate("r_date");
                reviewVO = new ReviewVO();
                reviewVO.setNo(no);
                reviewVO.setTitle(title);
                reviewVO.setTxt(txt);
                reviewVO.setDate(date);
                reviews.add(reviewVO);
            }
            return reviews;
           // request.setAttribute("reviews", reviews);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }


        return null;
    }


    public void upReview(HttpServletRequest req) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into review_test values("+"review_test_seq.nextval, ?, ?, sysdate)";

        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            req.setCharacterEncoding("UTF-8");
            pstmt.setString(1, req.getParameter("title"));
            pstmt.setString(2, req.getParameter("txt"));

            if(pstmt.executeUpdate() == 1){
                System.out.println("add success");
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void getReview(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from REVIEW_TEST where r_no=?";
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);   /* jsp에서 설정한 parameter */
            pstmt.setString(1, request.getParameter("pk"));

            rs = pstmt.executeQuery();
            ReviewVO reviewVO = null;
            if (rs.next()) {
                int no = rs.getInt("r_no");
                String title = rs.getString("r_title");
                String txt = rs.getString("r_txt");
                Date date = rs.getDate("r_date");
                reviewVO = new ReviewVO();
                reviewVO.setNo(no);
                reviewVO.setTitle(title);
                reviewVO.setTxt(txt);
                reviewVO.setDate(date);
            }
            request.setAttribute("review", reviewVO);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
    }

    public void updateReview(HttpServletRequest req) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update REVIEW_TEST set R_TITLE=?, R_TXT=? where r_no=?";

        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            req.setCharacterEncoding("UTF-8");
                                        /*update input name 에서 param 체크*/
            pstmt.setString(1, req.getParameter("title"));
            pstmt.setString(2, req.getParameter("txt"));
            pstmt.setString(3, req.getParameter("no"));

            if(pstmt.executeUpdate() == 1){
                System.out.println("edit success");
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }

    }

    public void delReview(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete REVIEW_TEST where r_no=?";
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);   /* jsp에서 설정한 parameter */
            pstmt.setString(1, request.getParameter("no"));

            if (pstmt.executeUpdate() == 1) {
                System.out.println("delete success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void paging(int pageNum, HttpServletRequest request) {
        request.setAttribute("currentPage", pageNum);
        ArrayList<ReviewVO> reviews = showAllReview(request);
        int total = reviews.size();
                    // ↑ 전체개수가 필요해서 불러온것
        int cnt = 3;

        // 페이지수
        int totalPage = (int)Math.ceil((double)total/cnt);
        request.setAttribute("totalPage", totalPage);

        int start = total - (cnt * (pageNum - 1));
        int end = (pageNum == totalPage) ? -1 : start - (cnt + 1);

        ArrayList<ReviewVO> items = new ArrayList<>();
        for(int i = start -1; i > end; i--){
            items.add(reviews.get(i));

        }
        request.setAttribute("reviews", items);


    }
}
