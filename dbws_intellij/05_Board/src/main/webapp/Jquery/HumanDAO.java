package com.jy.board.Jquery;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jy.board.main.DBManager;
import com.jy.board.main.DBManager_new;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HumanDAO {

    public static void test1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
    }

    public static void test2(HttpServletRequest request, HttpServletResponse response) {
        String str = "안뇽ㅎㅎㅋㅋㅋㅋ";
        // json -> json-simple , gson
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("string", str);

        response.setContentType("application/json;charset=utf-8");
        try {
            response.getWriter().println(jsonObject); // ==printWriter
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void test3(HttpServletRequest request, HttpServletResponse response) {

        Human human = new Human();
        human.setName("zzzzzi0");
        human.setAge(18);

        JsonObject jobj = new JsonObject();
        //  jobj.addProperty("name", human.getName());
        // jobj.addProperty("age", human.getAge());

        response.setContentType("application/json;charset=utf-8");

        try {
            // 1. 객체 응답
//        System.out.println(human.toJson());
//        response.getWriter().println(human.toJson());

            // 2. 객체 키값 실어서 전송
            JsonObject obj = new JsonObject();
            JsonParser parser = new JsonParser();   //↓ Json element 형식으로 입력
            obj.add("person", parser.parse(human.toJson()));
            response.getWriter().println(obj);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void test4(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        Human human1 = new Human(1, "ye1", 10);
        Human human2 = new Human(2, "ye2", 20);
        Human human3 = new Human(3, "ye3", 30);
        System.out.println("------------------");
        System.out.println(human1);
        System.out.println(human1.toString());

        ArrayList<String> humans = new ArrayList<>();
        // 왜 ArrayList<Human> humans이 아니라 String인지
        humans.add(human1.toJson());
        humans.add(human2.toJson());
        humans.add(human3.toJson());
        System.out.println(humans);
        try {
            // 1. 배열응답
            //response.getWriter().println(humans);
            // 2. 객체 키값 부여
            JsonObject obj = new JsonObject();
            JsonParser parser = new JsonParser();
            obj.add("people", parser.parse(humans.toString()));
            response.getWriter().println(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void test5(HttpServletRequest request, HttpServletResponse response) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DBManager_new.connect();
            pstmt = con.prepareStatement("select * from HUMAN_TEST");
            rs = pstmt.executeQuery();
            Human human = new Human();
            ArrayList<String> humans = new ArrayList<>();
            while (rs.next()) {
                // 값세팅
                // setter는 순서 상관 x
                human.setAge(rs.getInt("h_age"));
                human.setNo(rs.getInt("h_no"));
                human.setName(rs.getString("h_name"));
                humans.add(human.toJson());
            }
            System.out.println(humans);
            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().println(humans);

            JsonObject obj = new JsonObject();
            JsonParser parser = new JsonParser();   //↓ Json element 형식으로 입력
            obj.add("people", parser.parse(human.toString()));
            response.getWriter().println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }


    }

    public static ArrayList<String> getJSON() {
        // 호출되면 모든 human이 json형태로 바뀐 결과
        // [{},{},..]
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from HUMAN_TEST";
        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            ArrayList<String> humans = new ArrayList<>();
            while (rs.next()) {
                Human human = new Human();
                human.setNo(rs.getInt(1));
                human.setName(rs.getString(2));
                human.setAge(rs.getInt(3));
                humans.add(human.toJson());
            }
            System.out.println(humans); // json
            return humans;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return null;
    }
}
