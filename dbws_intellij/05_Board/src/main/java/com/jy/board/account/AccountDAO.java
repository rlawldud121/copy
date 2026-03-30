package com.jy.board.account;

import com.jy.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class AccountDAO {
    public static final AccountDAO ADAO = new AccountDAO();

    private AccountDAO() {

    }

    public boolean loginCheck (HttpServletRequest req){
        AccountVO user = (AccountVO) req.getSession().getAttribute("user"); // set으로 꺼내온걸 사용할때는 get 사용
        //attribute는 형 맞춰서 꺼내는거 (캐스트처리)는 꺼내고서 맞추는거
        if (user != null){  // 로그인 성공했을때
            req.setAttribute("loginPage","jsp/account/loginOK.jsp");
            return true;
        } else{ // 로그인 실패했을때
            req.setAttribute("loginPage","jsp/account/login.jsp");
            return false;
        }
    }

    public void login(HttpServletRequest req){
        // 값받기 or db
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        // id의 parameter값이 없을때 쓰는 로직 (일반 로그인때는 id를 입력하므로 사용되지않음)
        if (id == null){
            id = (String)req.getAttribute("idd");
        }

        // db 여기에 있는 계정이랑 비교
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from LOGIN_TEST where L_ID=?";
        try {
            con=DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();
            String msg = null;
            if(rs.next()){ //밑으로 내려가면서 볼 필요가 없으니까 (필요한 id만 보고싶으니까) while 대신 if 사용
                if (rs.getString("l_pw").equals(pw)){ // 입력한 input이 db와 같은지 확인
                    // 로그인 성공
                    System.out.println("로그인 성공");
                    msg = "로그인 성공";

                    AccountVO accountVO = new AccountVO(); // 새로운 객체 생성
                    // 객체 생성 후 값 세팅
                    accountVO.setId(rs.getString( "l_id"));
                    accountVO.setPw(rs.getString("l_pw"));
                    accountVO.setName(rs.getString("l_name"));
                   // req.setAttribute("user", accountVO);
                    HttpSession hs = req.getSession(); // 브라우저 끄기 전까지 유지되게 하는 코드
                    hs.setAttribute("user", accountVO);
                    hs.setMaxInactiveInterval(60 * 5); // 이 설정때문에 5초만 유지
                } else {
                    // 비밀번호 에러
                    System.out.println("비밀번호 에러");
                    msg = "비밀번호 에러";
                }
                } else {
                // 유저 없음
                    System.out.println("유저 정보 없음");
                    msg = "유저 정보 없음";
            }
            req.setAttribute("msg", msg);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,rs);
        }
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // 세션 삭제? 죽이는? 방법?
        // session.invalidate(); 세션 초기화 => 잘 안쓰는거 추천 (사유: 세션을 하나만 쓸거라는 보장 x 그런데? 다 삭제해버릴수도..)
        session.removeAttribute("user"); // "user"라는 세션 삭제 => 센세 추천
        // session.setAttribute("user", null); // 직접적으로 user에 null을 넣는방법
    }


    public boolean delUser(HttpServletRequest request) {// 값받기 or db

        // db 여기에 있는 계정이랑 비교
        // Object인 "user"를 accountV0로 형태를 바꾸고 싶어서 캐스트 처리를 해준것 (ACcountV0)
        // AccountV0 user 변수 안에는 request.getSession().getAttribute("user")가 object형태가 아닌 AccountVO형으로 들어있다!
        AccountVO user = (AccountVO) request.getSession().getAttribute("user");
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "delete LOGIN_TEST where L_ID=?";

        try {

            if (user.getPw().equals(request.getParameter("pw"))) { // 비밀번호가 잘못됐을때
                con = DBManager.connect();
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, user.getId());

                if (pstmt.executeUpdate() == 1) {
                    System.out.println("delete success");
                    logout(request);
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,null);
        }

        return false;
    }


    public void editUser(HttpServletRequest req) {
        AccountVO user = (AccountVO) req.getSession().getAttribute("user");
        // ↑ 이 안에 id가 들어있음
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "update LOGIN_TEST set L_PW=?, L_NAME=? where L_ID=?";

        try {
                con = DBManager.connect();
                pstmt = con.prepareStatement(sql);
                String name = req.getParameter("name");
                String pw = req.getParameter("pw");
                pstmt.setString(1,pw);
                pstmt.setString(2,name);
                pstmt.setString(3,user.getId());

                if (pstmt.executeUpdate() == 1) {
                    System.out.println("edit success");
                    req.setAttribute("iddd", user.getId());
                    // session이 login할때 입력을 한 값이 출력되기때문에
                    // edit이 성공했다고 해도 edit.jsp의 session값이 반영되지않음

                    // 해결방법 1. => 로그인 다시
                     //login(req);
                     // 이 경우 login에서 끌어다 쓰는거기 때문에 id의 parameter이 입력되지않음

                    // 해결방법 2. => 세션 업데이트
                    user.setName(name);
                    user.setPw(pw);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con,pstmt,null);
        }
    }
}
