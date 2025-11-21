package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 데이터베이스 연결 관리 유틸리티 클래스
 * web-study-11 패턴과 동일
 */
public class DBManager {

    /**
     * MySQL 데이터베이스 연결 생성
     * 
     * 처리 과정:
     * 1. JDBC 드라이버 로드
     * 2. url, id, password 이용해서 접속
     * 
     * @return Connection 객체 (연결 실패 시 null)
     */
    public static Connection getConnection() {

        Connection con = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 정보
            // characterEncoding=UTF-8&useUnicode=true: 한글 인코딩 처리
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dcproject?serverTimezone=Asia/Seoul&characterEncoding=UTF-8&useUnicode=true",
                    "jdbctest",
                    "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * SELECT 수행한 후 자원 반납
     * 
     * @param con  Connection 객체
     * @param stmt Statement 객체
     * @param rs   ResultSet 객체
     */
    public static void close(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * INSERT, UPDATE, DELETE 수행한 후 자원 반납
     * 
     * @param con  Connection 객체
     * @param stmt Statement 객체
     */
    public static void close(Connection con, Statement stmt) {
        try {
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
