package com.jy.board.movie;

import com.jy.board.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieDAO {

    public static final MovieDAO MDAO = new MovieDAO();

    private MovieDAO() {
        
    }

    private ArrayList<MovieDTO> movies;
    //static 이 non static을 볼 순 없음. static이 다른애들을 봐줄 수 있게
    // private 에서 private static으로 변경해줌

    // 전체조회 기능
    public void selectAllMovie(HttpServletRequest req){
        // 값 or DB

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from MOVIE_TEST";
        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            MovieDTO dto = null;
            movies = new ArrayList<>();
            while (rs.next()) {
                dto = new MovieDTO();
                dto.setNo(rs.getInt("m_no"));
                dto.setTitle(rs.getString("m_title"));
                dto.setActor(rs.getString("m_actor"));
                dto.setImg(rs.getString("m_img"));
                dto.setStory(rs.getString("m_story"));
                movies.add(dto);
            }
            req.setAttribute("movies", movies);
            System.out.println(movies);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,rs);
        }

    }

    public void addMovie(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "insert into movie_test values (movie_test_seq.nextval, ?, ?, ?,?)";
       // String path = request.getServletContext().getRealPath("movieFile");
         String path = "C:/JY/dbws_intellij/upload/movieFile";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);

            // 박스포장해놓은것때문에 바로 request로 사용 불가능 => ↓ multipartrequest사용
            MultipartRequest mr = new MultipartRequest(request,path,
                    1024*1024*20, "UTF-8", new DefaultFileRenamePolicy());

            // 값받기 시작
            String title = mr.getParameter("title");

            String actor = mr.getParameter("actor");
            String story = mr.getParameter("story");
            String fileName = mr.getFilesystemName("img");

            System.out.println(title);
            System.out.println(actor);
            System.out.println(story);
            System.out.println(fileName);

            story = story.replaceAll("\r\n", "<br>");

            pstmt.setString(1, title);
            pstmt.setString(2, actor);
            pstmt.setString(3, fileName);
            pstmt.setString(4, story);

            if(pstmt.executeUpdate() == 1){
                System.out.println("add success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,null);
        }
    }

    public void deleteMovie(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "delete from movie_test where M_NO = ?";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, request.getParameter("no")); //index에서 받는 parameter값의 name?

            if(pstmt.executeUpdate() == 1){
                System.out.println("delete success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,null);
        }
    }


    public void upMovie(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "update movie_test set M_TITLE=?, M_ACTOR=?, M_STORY=? where M_NO = ?";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);

            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String story = request.getParameter("story");
            String no = request.getParameter("no");

            story = story.replaceAll("\r\n", "<br>");
            System.out.println(title);
            System.out.println(actor);
            System.out.println(story);
            System.out.println(no);

            pstmt.setString(1, title);
            pstmt.setString(2, actor);
            pstmt.setString(3, story);
            pstmt.setString(4, no);

            if(pstmt.executeUpdate() == 1){
                System.out.println("update success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,null);
        }
    }

    public void getMovie(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from MOVIE_TEST where M_NO = ?";
        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, request.getParameter("no")); // "no" <= movie.jsp url들어가는 parameter값
            rs = pstmt.executeQuery();
            MovieDTO dto = null;
            if (rs.next()) {
                dto = new MovieDTO();
                dto.setNo(rs.getInt("m_no"));
                dto.setTitle(rs.getString("m_title"));
                dto.setActor(rs.getString("m_actor"));
                dto.setImg(rs.getString("m_img"));
                dto.setStory(rs.getString("m_story"));
            }
            System.out.println(dto);
            request.setAttribute("movie", dto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,rs);
        }
    }

    public void upMovie2(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "update movie_test set M_TITLE=?, M_ACTOR=?, M_STORY=?, M_IMG=? where M_NO = ?";
        String path = "C:\\JY\\dbws_intellij\\upload\\movieFile";
        // 여기 왜 \\로 한거지? 나 혼란.

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);

            // 박스포장해놓은것(enctype)때문에 바로 request로 사용 불가능 => ↓ multipartrequest사용
            MultipartRequest mr = new MultipartRequest(request,path,
                    1024*1024*20, "UTF-8", new DefaultFileRenamePolicy());

            String title = mr.getParameter("title");
            String actor = mr.getParameter("actor");
            String story = mr.getParameter("story");
            String newImg = mr.getFilesystemName("newImg");
            String no = mr.getParameter("no"); // getmovie는 박스포장이 되어있어서 no를 받지못함
            String img = newImg;
            String oldImg = mr.getParameter("oldImg");
            if (newImg == null) {
                img = oldImg;
            }

            System.out.println(title);
            System.

                    out.println(actor);
            System.out.println(story);
            System.out.println(img);

            story = story.replaceAll("\r\n", "<br>");

            pstmt.setString(1, title);
            pstmt.setString(2, actor);
            pstmt.setString(3, story);
            pstmt.setString(4, img);
            pstmt.setString(5, no);

            request.setAttribute("noo", no);

            if(pstmt.executeUpdate() == 1){
                System.out.println("edit success");
                if (newImg != null) { //유저는 새로운 post 사진으로 교체를 함(이전사진 삭제 필요)
                    File f = new File(path + "/" + oldImg);
                    f.delete();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,null);
        }
    }

public void paging(int pageNum, HttpServletRequest request) {
        request.setAttribute("currentPage", pageNum);
        int total = movies.size();
        int cnt = 3;

        // 페이지수
    int totalPage = (int)Math.ceil((double)total/cnt);
    request.setAttribute("totalPage", totalPage);
    int start = total - (cnt * (pageNum - 1));
    int end = (pageNum == totalPage) ? -1 : start - (cnt + 1);

    ArrayList<MovieDTO> items = new ArrayList<>();
    for(int i = start -1; i > end; i--){
        items.add(movies.get(i));

    }
    request.setAttribute("movies", items);


}


}


